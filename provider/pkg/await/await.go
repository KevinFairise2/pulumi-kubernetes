// Copyright 2016-2023, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package await

import (
	"context"
	"encoding/json"
	"fmt"
	"os"

	fluxssa "github.com/fluxcd/pkg/ssa"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/clients"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/cluster"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/kinds"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/logging"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/metadata"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/openapi"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/retry"
	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/ssa"
	pulumiprovider "github.com/pulumi/pulumi/pkg/v3/resource/provider"
	"github.com/pulumi/pulumi/sdk/v3/go/common/diag"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	logger "github.com/pulumi/pulumi/sdk/v3/go/common/util/logging"
	"k8s.io/apimachinery/pkg/api/errors"
	"k8s.io/apimachinery/pkg/api/meta"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/apis/meta/v1/unstructured"
	"k8s.io/apimachinery/pkg/fields"
	"k8s.io/apimachinery/pkg/runtime/schema"
	"k8s.io/apimachinery/pkg/types"
	"k8s.io/apimachinery/pkg/watch"
	"k8s.io/client-go/dynamic"
	k8sopenapi "k8s.io/kubectl/pkg/util/openapi"
	"sigs.k8s.io/yaml"
)

// --------------------------------------------------------------------------

// Await primitives.
//
// A collection of functions that perform an operation on a resource (e.g., `Create` or `Delete`),
// and block until either the operation is complete, or error. For example, a user wishing to block
// on object creation might write:
//
//   await.Creation(pool, disco, serviceObj)

// --------------------------------------------------------------------------

type ProviderConfig struct {
	Context           context.Context
	Host              *pulumiprovider.HostClient
	URN               resource.URN
	InitialAPIVersion string
	FieldManager      string
	ClusterVersion    *cluster.ServerVersion
	ServerSideApply   bool

	ClientSet   *clients.DynamicClientSet
	DedupLogger *logging.DedupLogger
	Resources   k8sopenapi.Resources
}

type CreateConfig struct {
	ProviderConfig
	Inputs  *unstructured.Unstructured
	Timeout float64
	Preview bool
}

type ReadConfig struct {
	ProviderConfig
	Inputs          *unstructured.Unstructured
	Name            string
	ReadFromCluster bool
}

type UpdateConfig struct {
	ProviderConfig
	Previous *unstructured.Unstructured
	Inputs   *unstructured.Unstructured
	Timeout  float64
	Preview  bool
}

type DeleteConfig struct {
	ProviderConfig
	Inputs  *unstructured.Unstructured
	Name    string
	Timeout float64
}

type ResourceID struct {
	Name       string
	Namespace  string // Namespace should never be "" (use "default" instead).
	GVK        schema.GroupVersionKind
	Generation int64
}

func (r ResourceID) String() string {
	if len(r.Namespace) > 0 {
		return r.Namespace + "/" + r.Name
	}
	return r.Name
}

func (r ResourceID) GVKString() string {
	return fmt.Sprintf(`'[%s] %s'`, r.GVK, r.String())
}

func ResourceIDFromUnstructured(uns *unstructured.Unstructured) ResourceID {
	return ResourceID{
		Namespace:  clients.NamespaceOrDefault(uns.GetNamespace()),
		Name:       uns.GetName(),
		GVK:        uns.GroupVersionKind(),
		Generation: uns.GetGeneration(),
	}
}

// skipRetry checks if we should skip retrying creation for unresolvable errors.
func skipRetry(gvk schema.GroupVersionKind, k8sVersion *cluster.ServerVersion, err error,
) (bool, *cluster.ServerVersion) {
	if meta.IsNoMatchError(err) {
		// If the GVK is known to have been removed, it's not waiting on any CRD creation, and we can return early.
		if removed, version := kinds.RemovedAPIVersion(gvk, *k8sVersion); removed {
			return true, version
		}
	}

	return false, nil
}

const ssaConflictDocLink = "https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/#handle-field-conflicts-on-existing-resources"

// Creation (as the usage, `await.Creation`, implies) will block until one of the following is true:
// (1) the Kubernetes resource is reported to be initialized; (2) the initialization timeout has
// occurred; or (3) an error has occurred while the resource was being initialized.
func Creation(c CreateConfig) (*unstructured.Unstructured, error) {
	// Issue create request. We retry the create REST request on failure, so that we can tolerate
	// some amount of misordering (e.g., creating a `Pod` before the `Namespace` it goes in;
	// creating a custom resource before the CRD is registered; etc.), which is common among Helm
	// Charts and YAML files.
	//
	// For more discussion see pulumi-kubernetes#239. See also the retry logic `kubectl` uses to
	// mitigate resource conflicts:
	//
	// nolint
	// https://github.com/kubernetes/kubernetes/blob/54889d581a35acf940d52a8a384cccaa0b597ddc/pkg/kubectl/cmd/apply/apply.go#L94

	var outputs *unstructured.Unstructured
	var client dynamic.ResourceInterface
	err := retry.SleepingRetry(
		func(i uint) error {
			// Recreate the client for resource, in case the client's cache of the server API was
			// invalidated. For example, when a CRD is created, it will invalidate the client cache;
			// this allows CRs that we tried (and failed) to create before to re-try with the new
			// server API, at which point they should hopefully succeed.
			var err error
			if client == nil {
				client, err = c.ClientSet.ResourceClient(c.Inputs.GroupVersionKind(), c.Inputs.GetNamespace())
				if err != nil {
					if skip, version := skipRetry(c.Inputs.GroupVersionKind(), c.ClusterVersion, err); skip {
						return &kinds.RemovedAPIError{
							GVK:     c.Inputs.GroupVersionKind(),
							Version: version,
						}
					}

					_ = c.Host.LogStatus(c.Context, diag.Info, c.URN, fmt.Sprintf(
						"Retry #%d; creation failed: %v", i, err))
					return err
				}
			}

			if c.ServerSideApply {
				force := patchForce(c.Inputs, nil, c.Preview)
				options := metav1.PatchOptions{
					FieldManager:    c.FieldManager,
					Force:           &force,
					FieldValidation: metav1.FieldValidationWarn,
				}
				if c.Preview {
					options.DryRun = []string{metav1.DryRunAll}
				}
				var objYAML []byte
				objYAML, err = yaml.Marshal(c.Inputs.Object)
				if err != nil {
					return err
				}
				outputs, err = client.Patch(
					c.Context, c.Inputs.GetName(), types.ApplyPatchType, objYAML, options)

				if errors.IsConflict(err) {
					err = fmt.Errorf("Server-Side Apply field conflict detected. see %s for troubleshooting help\n: %w",
						ssaConflictDocLink, err)
				}
			} else {
				options := metav1.CreateOptions{
					FieldManager: c.FieldManager,
				}
				if c.Preview {
					options.DryRun = []string{metav1.DryRunAll}
				}

				outputs, err = client.Create(c.Context, c.Inputs, options)
			}
			if err != nil {
				// If the namespace hasn't been created yet, the preview will always fail.
				if c.Preview && IsNamespaceNotFoundErr(err) {
					return &namespaceError{c.Inputs}
				}

				_ = c.Host.LogStatus(c.Context, diag.Info, c.URN, fmt.Sprintf(
					"Retry #%d; creation failed: %v", i, err))
				return err
			}

			return nil

		}).
		WithMaxRetries(5).
		WithBackoffFactor(2).
		Do(errors.IsNotFound, meta.IsNoMatchError)
	if err != nil {
		return nil, err
	}
	_ = clearStatus(c.Context, c.Host, c.URN)

	if c.Preview {
		return outputs, nil
	}

	// Wait until create resolves as success or error. Note that the conditional is set up to log
	// only if we don't have an entry for the resource type; in the event that we do, but the await
	// logic is blank, simply do nothing instead of logging.
	id := fmt.Sprintf("%s/%s", c.Inputs.GetAPIVersion(), c.Inputs.GetKind())
	if awaiter, exists := awaiters[id]; exists {
		if metadata.SkipAwaitLogic(c.Inputs) {
			logger.V(1).Infof("Skipping await logic for %v", c.Inputs.GetName())
		} else {
			if awaiter.awaitCreation != nil {
				conf := createAwaitConfig{
					host:              c.Host,
					ctx:               c.Context,
					urn:               c.URN,
					initialAPIVersion: c.InitialAPIVersion,
					clientSet:         c.ClientSet,
					currentInputs:     c.Inputs,
					currentOutputs:    outputs,
					logger:            c.DedupLogger,
					timeout:           c.Timeout,
					clusterVersion:    c.ClusterVersion,
				}
				waitErr := awaiter.awaitCreation(conf)
				if waitErr != nil {
					return nil, waitErr
				}
			}
		}
	} else {
		logger.V(1).Infof(
			"No initialization logic found for object of type %q; assuming initialization successful", id)
	}

	// If the client fails to get the live object for some reason, DO NOT return the error. This
	// will leak the fact that the object was successfully created. Instead, fall back to the
	// last-seen live object.
	live, err := client.Get(c.Context, c.Inputs.GetName(), metav1.GetOptions{})
	if err != nil {
		return outputs, nil
	}
	return live, nil
}

// Read checks a resource, returning the object if it was created and initialized successfully.
func Read(c ReadConfig) (*unstructured.Unstructured, error) {
	client, err := c.ClientSet.ResourceClient(c.Inputs.GroupVersionKind(), c.Inputs.GetNamespace())
	if err != nil {
		return nil, err
	}

	// Retrieve live version of the object from k8s.
	outputs, err := client.Get(c.Context, c.Name, metav1.GetOptions{})
	if err != nil {
		return nil, err
	} else if c.ReadFromCluster {
		// If the resource is read from a .get or an import, simply return the resource state from the cluster.
		return outputs, nil
	}

	id := fmt.Sprintf("%s/%s", outputs.GetAPIVersion(), outputs.GetKind())
	if awaiter, exists := awaiters[id]; exists {
		if metadata.SkipAwaitLogic(c.Inputs) {
			logger.V(1).Infof("Skipping await logic for %v", c.Inputs.GetName())
		} else {
			if awaiter.awaitRead != nil {
				conf := createAwaitConfig{
					host:              c.Host,
					ctx:               c.Context,
					urn:               c.URN,
					initialAPIVersion: c.InitialAPIVersion,
					clientSet:         c.ClientSet,
					currentInputs:     c.Inputs,
					currentOutputs:    outputs,
					logger:            c.DedupLogger,
					clusterVersion:    c.ClusterVersion,
				}
				waitErr := awaiter.awaitRead(conf)
				if waitErr != nil {
					return nil, waitErr
				}
			}
		}
	}

	logger.V(1).Infof(
		"No read logic found for object of type %q; falling back to retrieving object", id)

	// If the client fails to get the live object for some reason, DO NOT return the error. This
	// will leak the fact that the object was successfully created. Instead, fall back to the
	// last-seen live object.
	live, err := client.Get(c.Context, c.Name, metav1.GetOptions{})
	if err != nil {
		return outputs, nil
	}
	return live, nil
}

// Update updates an existing resource with new values. This client uses a Server-side Apply (SSA) patch by default, but
// also supports the older three-way JSON patch and the strategic merge patch as fallback options.
// See references [1], [2], [3].
//
// nolint
// [1]:
// https://kubernetes.io/docs/tasks/run-application/update-api-object-kubectl-patch/#use-a-json-merge-patch-to-update-a-deployment
// [2]:
// https://kubernetes.io/docs/concepts/overview/object-management-kubectl/declarative-config/#how-apply-calculates-differences-and-merges-changes
// [3]:
// https://kubernetes.io/docs/reference/using-api/server-side-apply
func Update(c UpdateConfig) (*unstructured.Unstructured, error) {
	client, err := c.ClientSet.ResourceClientForObject(c.Inputs)
	if err != nil {
		return nil, err
	}

	// Get the "live" version of the last submitted object. This is necessary because the server may
	// have populated some fields automatically, updated status fields, and so on.
	liveOldObj, err := client.Get(c.Context, c.Previous.GetName(), metav1.GetOptions{})
	if err != nil {
		return nil, err
	}

	currentOutputs, err := updateResource(&c, liveOldObj, client)
	if err != nil {
		return nil, err
	}
	if c.Preview {
		// We do not need to get the updated live object if we are in preview mode.
		return currentOutputs, nil
	}

	// Wait until patch resolves as success or error. Note that the conditional is set up to log only
	// if we don't have an entry for the resource type; in the event that we do, but the await logic
	// is blank, simply do nothing instead of logging.
	id := fmt.Sprintf("%s/%s", c.Inputs.GetAPIVersion(), c.Inputs.GetKind())
	if awaiter, exists := awaiters[id]; exists {
		if metadata.SkipAwaitLogic(c.Inputs) {
			logger.V(1).Infof("Skipping await logic for %v", c.Inputs.GetName())
		} else {
			if awaiter.awaitUpdate != nil {
				conf := updateAwaitConfig{
					createAwaitConfig: createAwaitConfig{
						host:              c.Host,
						ctx:               c.Context,
						urn:               c.URN,
						initialAPIVersion: c.InitialAPIVersion,
						clientSet:         c.ClientSet,
						currentInputs:     c.Inputs,
						currentOutputs:    currentOutputs,
						logger:            c.DedupLogger,
						timeout:           c.Timeout,
						clusterVersion:    c.ClusterVersion,
					},
					lastInputs:  c.Previous,
					lastOutputs: liveOldObj,
				}
				waitErr := awaiter.awaitUpdate(conf)
				if waitErr != nil {
					return nil, waitErr
				}
			}
		}
	} else {
		logger.V(1).Infof("No initialization logic found for object of type %q; assuming initialization successful", id)
	}

	gvk := c.Inputs.GroupVersionKind()
	logger.V(3).Infof("Resource %s/%s/%s  '%s.%s' patched and updated", gvk.Group, gvk.Version,
		gvk.Kind, c.Inputs.GetNamespace(), c.Inputs.GetName())

	// If the client fails to get the live object for some reason, DO NOT return the error. This
	// will leak the fact that the object was successfully created. Instead, fall back to the
	// last-seen live object.
	live, err := client.Get(c.Context, c.Inputs.GetName(), metav1.GetOptions{})
	if err != nil {
		return currentOutputs, nil
	}
	return live, nil
}

func updateResource(c *UpdateConfig, liveOldObj *unstructured.Unstructured, client dynamic.ResourceInterface) (*unstructured.Unstructured, error) {
	var currentOutputs *unstructured.Unstructured
	var err error
	switch {
	case clients.IsCRD(c.Inputs):
		// CRDs require special handling to update. Rather than computing a patch, replace the CRD with a PUT
		// operation (equivalent to running `kubectl replace`). This is accomplished by getting the `resourceVersion`
		// of the existing CRD, setting that as the `resourceVersion` in the request, and then running an update. This
		// results in the immediate replacement of the CRD without deleting it, or any CustomResources that depend on
		// it. The PUT operation is still validated by the api server, so a badly formed request will fail as usual.
		c.Inputs.SetResourceVersion(liveOldObj.GetResourceVersion())
		currentOutputs, err = client.Update(c.Context, c.Inputs, metav1.UpdateOptions{})
	case c.ServerSideApply:
		currentOutputs, err = ssaUpdate(c, liveOldObj, client)
	default:
		currentOutputs, err = csaUpdate(c, liveOldObj, client)
	}
	return currentOutputs, err
}

// csaUpdate handles the logic for updating a resource using client-side apply.
func csaUpdate(c *UpdateConfig, liveOldObj *unstructured.Unstructured, client dynamic.ResourceInterface) (*unstructured.Unstructured, error) {
	// Create merge patch (prefer strategic merge patch, fall back to JSON merge patch).
	patch, patchType, _, err := openapi.PatchForResourceUpdate(c.Resources, c.Previous, c.Inputs, liveOldObj)
	if err != nil {
		return nil, err
	}

	options := metav1.PatchOptions{
		FieldManager: c.FieldManager,
	}
	if c.Preview {
		options.DryRun = []string{metav1.DryRunAll}
	}

	return client.Patch(c.Context, c.Inputs.GetName(), patchType, patch, options)
}

// ssaUpdate handles the logic for updating a resource using server-side apply.
func ssaUpdate(c *UpdateConfig, liveOldObj *unstructured.Unstructured, client dynamic.ResourceInterface) (*unstructured.Unstructured, error) {
	if !c.Preview {
		err := fixCSAFieldManagers(c, liveOldObj, client)
		if err != nil {
			return nil, err
		}
	}

	objYAML, err := yaml.Marshal(c.Inputs.Object)
	if err != nil {
		return nil, err
	}
	force := patchForce(c.Inputs, liveOldObj, c.Preview)
	options := metav1.PatchOptions{
		FieldManager: c.FieldManager,
		Force:        &force,
	}
	if c.Preview {
		options.DryRun = []string{metav1.DryRunAll}
	}

	currentOutputs, err := client.Patch(c.Context, c.Inputs.GetName(), types.ApplyPatchType, objYAML, options)
	if err != nil {
		if errors.IsConflict(err) {
			err = fmt.Errorf("Server-Side Apply field conflict detected. See %s for troubleshooting help\n: %w",
				ssaConflictDocLink, err)
		}
		return nil, err
	}

	return currentOutputs, nil
}

// fixCSAFieldManagers patches the field managers for an existing resource that was managed using client-side apply.
// The new server-side apply field manager takes ownership of all these fields to avoid conflicts.
func fixCSAFieldManagers(c *UpdateConfig, live *unstructured.Unstructured, client dynamic.ResourceInterface) error {
	if managedFields := live.GetManagedFields(); len(managedFields) > 0 {
		patches, err := fluxssa.PatchReplaceFieldsManagers(live, []fluxssa.FieldManager{
			{
				// take ownership of changes made with 'kubectl apply --server-side --force-conflicts'
				Name:          "kubectl",
				OperationType: metav1.ManagedFieldsOperationApply,
			},
			{
				// take ownership of changes made with 'kubectl apply'
				Name:          "kubectl",
				OperationType: metav1.ManagedFieldsOperationUpdate,
			},
			{
				// take ownership of changes made with 'kubectl apply'
				Name:          "before-first-apply",
				OperationType: metav1.ManagedFieldsOperationUpdate,
			},
			// The following are possible field manager values for resources that were created using this provider under
			// CSA mode. Note the "Update" operation type, which Kubernetes treats as a separate field manager even if
			// the name is identical. See https://github.com/kubernetes/kubernetes/issues/99003
			{
				// take ownership of changes made with pulumi-kubernetes CSA
				Name:          "pulumi-kubernetes",
				OperationType: metav1.ManagedFieldsOperationUpdate,
			},
			{
				// take ownership of changes made with pulumi-kubernetes CSA
				Name:          "pulumi-kubernetes.exe",
				OperationType: metav1.ManagedFieldsOperationUpdate,
			},
			{
				// take ownership of changes made with pulumi-kubernetes CSA
				Name:          "pulumi-resource-kubernetes",
				OperationType: metav1.ManagedFieldsOperationUpdate,
			},
		}, c.FieldManager)
		if err != nil {
			return err
		}
		patch, err := json.Marshal(patches)
		if err != nil {
			return err
		}
		_, err = client.Patch(c.Context, live.GetName(), types.JSONPatchType, patch, metav1.PatchOptions{})
		if err != nil {
			return err
		}
	}
	return nil
}

// Deletion (as the usage, `await.Deletion`, implies) will block until one of the following is true:
// (1) the Kubernetes resource is reported to be deleted; (2) the initialization timeout has
// occurred; or (3) an error has occurred while the resource was being deleted.
func Deletion(c DeleteConfig) error {
	// nilIfGVKDeleted takes an error and returns nil if `errors.IsNotFound`; otherwise, it returns
	// the error argument unchanged.
	//
	// Rationale: If we have gotten to this point, this resource was successfully created and is now
	// being deleted. This implies that the G/V/K once did exist, but now does not. This, in turn,
	// implies that it has been successfully deleted. For example: the resource was likely a CR, but
	// the CRD has since been removed. Otherwise, the resource was deleted out-of-band.
	//
	// This is necessary for CRs, which are often deleted after the relevant CRDs (especially in
	// Helm charts), and it is acceptable for other resources because it is semantically like
	// running `refresh` before deletion.
	nilIfGVKDeleted := func(err error) error {
		if errors.IsNotFound(err) {
			return nil
		}
		return err
	}

	// Obtain client for the resource being deleted.
	client, err := c.ClientSet.ResourceClientForObject(c.Inputs)
	if err != nil {
		return nilIfGVKDeleted(err)
	}

	patchResource := kinds.PatchQualifiedTypes.Has(c.URN.QualifiedType().String())
	if c.ServerSideApply && patchResource {
		err = ssa.Relinquish(c.Context, client, c.Inputs, c.FieldManager)
		return err
	}

	timeout := metadata.TimeoutDuration(c.Timeout, c.Inputs, 300)
	timeoutSeconds := int64(timeout.Seconds())
	listOpts := metav1.ListOptions{
		FieldSelector:  fields.OneTermEqualSelector("metadata.name", c.Name).String(),
		TimeoutSeconds: &timeoutSeconds,
	}

	// Set up a watcher for the selected resource.
	watcher, err := client.Watch(c.Context, listOpts)
	if err != nil {
		return nilIfGVKDeleted(err)
	}

	err = deleteResource(c.Context, c.Name, client)
	if err != nil {
		return nilIfGVKDeleted(err)
	}

	// Wait until delete resolves as success or error. Note that the conditional is set up to log only
	// if we don't have an entry for the resource type; in the event that we do, but the await logic
	// is blank, simply do nothing instead of logging.
	var waitErr error
	id := fmt.Sprintf("%s/%s", c.Inputs.GetAPIVersion(), c.Inputs.GetKind())
	if awaiter, exists := awaiters[id]; exists && awaiter.awaitDeletion != nil {
		if metadata.SkipAwaitLogic(c.Inputs) {
			logger.V(1).Infof("Skipping await logic for %v", c.Inputs.GetName())
		} else {
			waitErr = awaiter.awaitDeletion(deleteAwaitConfig{
				createAwaitConfig: createAwaitConfig{
					host:              c.Host,
					ctx:               c.Context,
					urn:               c.URN,
					initialAPIVersion: c.InitialAPIVersion,
					clientSet:         c.ClientSet,
					currentInputs:     c.Inputs,
					logger:            c.DedupLogger,
					timeout:           c.Timeout,
					clusterVersion:    c.ClusterVersion,
				},
				clientForResource: client,
			})
		}
	} else {
		for {
			select {
			case event, ok := <-watcher.ResultChan():
				if !ok {
					deleted, obj := checkIfResourceDeleted(c.Context, c.Name, client)
					if deleted {
						_ = clearStatus(c.Context, c.Host, c.URN)
						return nil
					}

					return &timeoutError{
						object: obj,
						subErrors: []string{
							fmt.Sprintf("Timed out waiting for deletion of %s %q", id, c.Name),
						},
					}
				}

				switch event.Type {
				case watch.Deleted:
					_ = clearStatus(c.Context, c.Host, c.URN)
					return nil
				case watch.Error:
					deleted, obj := checkIfResourceDeleted(c.Context, c.Name, client)
					if deleted {
						_ = clearStatus(c.Context, c.Host, c.URN)
						return nil
					}
					return &initializationError{
						object:    obj,
						subErrors: []string{errors.FromObject(event.Object).Error()},
					}
				}
			case <-c.Context.Done(): // Handle user cancellation during watch for deletion.
				watcher.Stop()
				logger.V(3).Infof("Received error deleting object %q: %#v", id, err)
				deleted, obj := checkIfResourceDeleted(c.Context, c.Name, client)
				if deleted {
					_ = clearStatus(c.Context, c.Host, c.URN)
					return nil
				}

				return &cancellationError{
					object: obj,
				}
			}
		}
	}

	return waitErr
}

// deleteResource deletes the specified resource using foreground cascading delete.
func deleteResource(ctx context.Context, name string, client dynamic.ResourceInterface) error {
	fg := metav1.DeletePropagationForeground
	deleteOpts := metav1.DeleteOptions{
		PropagationPolicy: &fg,
	}

	return client.Delete(ctx, name, deleteOpts)
}

// checkIfResourceDeleted attempts to get a k8s resource, and returns true if the resource is not found (was deleted).
// Return the resource if it still exists.
func checkIfResourceDeleted(
	ctx context.Context, name string, client dynamic.ResourceInterface) (bool, *unstructured.Unstructured) {
	obj, err := client.Get(ctx, name, metav1.GetOptions{})
	if err != nil && is404(err) { // In case of 404, the resource no longer exists, so return success.
		return true, nil
	}

	return false, obj
}

// clearStatus will clear the `Info` column of the CLI of all statuses and messages.
func clearStatus(context context.Context, host *pulumiprovider.HostClient, urn resource.URN) error {
	return host.LogStatus(context, diag.Info, urn, "")
}

// patchForce decides whether to overwrite patch conflicts.
func patchForce(inputs, live *unstructured.Unstructured, preview bool) bool {
	if metadata.IsAnnotationTrue(inputs, metadata.AnnotationPatchForce) {
		return true
	}
	if enabled, exists := os.LookupEnv("PULUMI_K8S_ENABLE_PATCH_FORCE"); exists {
		return enabled == "true"
	}
	if preview {
		// Always force on preview if no previous state to avoid erroneous conflict errors for resource replacements.
		if live == nil {
			return true
		}
		// If the resource includes a CSA field manager for this provider, then force the update. Field managers will be
		// adjusted before this on real updates, so only force on preview.
		for _, managedField := range live.GetManagedFields() {
			if managedField.Operation != metav1.ManagedFieldsOperationUpdate {
				continue
			}
			switch managedField.Manager {
			case "pulumi-resource-kubernetes", "pulumi-kubernetes", "pulumi-kubernetes.exe":
				return true
			}
		}
	}

	return false
}
