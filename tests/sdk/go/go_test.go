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

package test

import (
	b64 "encoding/base64"
	"encoding/json"
	"fmt"
	"os"
	"os/exec"
	"path/filepath"
	"regexp"
	"strings"
	"testing"

	"github.com/pulumi/pulumi-kubernetes/provider/v4/pkg/openapi"
	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
	"helm.sh/helm/v3/pkg/repo"
	"k8s.io/apimachinery/pkg/apis/meta/v1/unstructured"
)

var baseOptions = &integration.ProgramTestOptions{
	Verbose: true,
	Dependencies: []string{
		"github.com/pulumi/pulumi-kubernetes/sdk/v4",
	},
	Env: []string{
		"PULUMI_K8S_CLIENT_BURST=200",
		"PULUMI_K8S_CLIENT_QPS=100",
	},
}

// TestGo runs Go SDK tests sequentially to avoid OOM errors in CI
func TestGo(t *testing.T) {
	cwd, err := os.Getwd()
	if !assert.NoError(t, err) {
		t.FailNow()
	}
	t.Run("Basic", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "basic"),
			ExpectRefreshChanges: true,
			Quick:                true,
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("YAML", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "yaml"),
			Quick:                true,
			ExpectRefreshChanges: true,
			OrderedConfig: []integration.ConfigValue{
				{
					Key:   "pulumi:disable-default-providers[0]",
					Value: "kubernetes",
					Path:  true,
				},
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Local", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "helm-local", "step1"),
			Quick:                true,
			ExpectRefreshChanges: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				// Verify resource creation order using the Event stream. The Chart resources must be created
				// first, followed by the dependent ConfigMap. (The ConfigMap doesn't actually need the Chart, but
				// it creates almost instantly, so it's a good choice to test creation ordering)
				cmRegex := regexp.MustCompile(`ConfigMap::nginx-server-block`)
				svcRegex := regexp.MustCompile(`Service::nginx`)
				deployRegex := regexp.MustCompile(`Deployment::nginx`)
				dependentRegex := regexp.MustCompile(`ConfigMap::foo`)

				var configmapFound, serviceFound, deploymentFound, dependentFound bool
				for _, e := range stackInfo.Events {
					if e.ResOutputsEvent != nil {
						switch {
						case cmRegex.MatchString(e.ResOutputsEvent.Metadata.URN):
							configmapFound = true
						case svcRegex.MatchString(e.ResOutputsEvent.Metadata.URN):
							serviceFound = true
						case deployRegex.MatchString(e.ResOutputsEvent.Metadata.URN):
							deploymentFound = true
						case dependentRegex.MatchString(e.ResOutputsEvent.Metadata.URN):
							dependentFound = true
						}
						assert.Falsef(t, dependentFound && !(configmapFound && serviceFound && deploymentFound),
							"dependent ConfigMap created before all chart resources were ready")
						fmt.Println(e.ResOutputsEvent.Metadata.URN)
					}
				}
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Release Import (Option)", func(t *testing.T) {

		chart := bitnamiNginxChart
		chartVersion := bitnamiNginxChart.Versions[0]

		// Run a program test for each of the various ways to import a Helm chart.
		type runOptions struct {
			InstallHelmRepository bool
		}
		run := func(t *testing.T, options integration.ProgramTestOptions, opts runOptions) {
			// create a Helm environment with a chart repository
			var repos []repo.Entry
			if opts.InstallHelmRepository {
				repos = append(repos, chart.HelmRepo)
			}
			he, cleanup, err := createHelmEnvironment(t, repos...)
			require.NoError(t, err, "failed to create Helm environment")
			t.Cleanup(func() {
				contract.IgnoreError(cleanup())
			})

			// pre-install the Helm chart to be imported
			namespace := getRandomNamespace("importtest")
			chartPath := filepath.Join(cwd, chart.TestPath)
			require.NoError(t, createRelease("mynginx", namespace, chartPath, true))
			t.Cleanup(func() {
				contract.IgnoreError(deleteRelease("mynginx", namespace))
			})

			// Import a Helm release using the `import` option on the `helm.Release` resource.
			// The program inputs MUST exactly match the provider-generated inputs,
			// or Pulumi will report: "error: inputs to import do not match the existing resource".
			hValues, _ := json.Marshal(chartVersion.Values)
			successCriteria := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.NotEmpty(t, stack.Outputs["svc_ip"])
				assert.NotEmpty(t, stack.Outputs["resourceNames"])
			}
			options = options.With(integration.ProgramTestOptions{
				Config: map[string]string{
					"namespace": namespace,
					"name":      "mynginx",
					"values":    string(hValues),
					"import-id": fmt.Sprintf("%s/%s", namespace, "mynginx"),
				},
				Env:                    he.EnvVars(),
				Quick:                  true,
				ExpectRefreshChanges:   true,
				ExtraRuntimeValidation: successCriteria,
				NoParallel:             true,
				DestroyOnCleanup:       true,
			})

			integration.ProgramTest(t, &options)
		}

		// 1. Import by searching the local chart repositories for a matching chart.
		t.Run("chart reference", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-remote"),
				Config: map[string]string{
					"chart":   chart.ChartReference(), // bitnami/nginx
					"version": chartVersion.Version,   // 15.3.4
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: true,
			})
		})

		// 2. Import by searching for an unpacked chart in the program directory.
		t.Run("chart directory", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-local-directory"),
				Config: map[string]string{
					"chart":   chart.Name, // nginx
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})

		// 3. Import by searching for a chart archive in the program directory.
		t.Run("chart archive", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-local-tar"),
				Config: map[string]string{
					"chart":   fmt.Sprintf("%s-%s.tgz", chart.Name, chartVersion.Version), // nginx-15.3.4.tgz
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})
	})

	t.Run("Helm Release Import (Tool)", func(t *testing.T) {

		chart := bitnamiNginxChart
		chartVersion := bitnamiNginxChart.Versions[0]

		// Run a program test for each of the various ways to import a Helm chart.
		type runOptions struct {
			InstallHelmRepository bool
			ExpectHelmUpgrade     bool
		}
		run := func(t *testing.T, baseOptions integration.ProgramTestOptions, opts runOptions) {
			// create a Helm environment with a chart repository
			var repos []repo.Entry
			if opts.InstallHelmRepository {
				repos = append(repos, chart.HelmRepo)
			}
			he, cleanup, err := createHelmEnvironment(t, repos...)
			require.NoError(t, err, "failed to create Helm environment")
			t.Cleanup(func() {
				contract.IgnoreError(cleanup())
			})

			// pre-install the Helm chart to be imported
			namespace := getRandomNamespace("importtest")
			chartPath := filepath.Join(cwd, chart.TestPath)
			require.NoError(t, createRelease("mynginx", namespace, chartPath, true))
			t.Cleanup(func() {
				contract.IgnoreError(deleteRelease("mynginx", namespace))
			})

			// Import a Helm release using the `pulumi import` tool.
			// The provider infers the chart reference from the existing release,
			// by searching the local environment for a matching chart.
			// The program inputs may or may not match the provider-generated inputs;
			// if not, import succeeds with a warning and a subsequent deployment may cause a Helm upgrade.
			hValues, _ := json.Marshal(chartVersion.Values)
			successCriteria := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.NotEmpty(t, stack.Outputs["svc_ip"])
				assert.NotEmpty(t, stack.Outputs["resourceNames"])
			}
			options := baseOptions.With(integration.ProgramTestOptions{
				Config: map[string]string{
					"namespace": namespace,
					"name":      "mynginx",
					"values":    string(hValues),
				},
				Env:                    he.EnvVars(),
				Quick:                  true,
				ExpectRefreshChanges:   true,
				ExtraRuntimeValidation: successCriteria,
				NoParallel:             true,
				DestroyOnCleanup:       true,
			})
			pt := integration.ProgramTestManualLifeCycle(t, &options)

			require.NoError(t, pt.TestLifeCyclePrepare(), "prepare")
			t.Cleanup(pt.TestCleanUp)

			require.NoError(t, pt.TestLifeCycleInitialize(), "initialize")

			// Import the Helm release: `pulumi import [type] [name] [id] [flags]`
			id := fmt.Sprintf("%s/%s", namespace, "mynginx")
			require.NoError(t,
				pt.RunPulumiCommand("import", "--yes", "kubernetes:helm.sh/v3:Release", "test", id),
				"import failed")

			// Run an update to verify that the Helm release was imported.
			require.NoError(t, pt.TestPreviewUpdateAndEdits(), "update")

			// assert that the release wasn't upgraded by the import operation.
			release, err := getRelease("mynginx", namespace)
			require.NoError(t, err, "getRelease")
			if !opts.ExpectHelmUpgrade {
				assert.Equal(t, 1, release.Version, "release version")
			} else {
				assert.Equal(t, 2, release.Version, "release version")
			}
		}

		// 1. Import by searching the local chart repositories for a matching chart.
		t.Run("chart reference", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-remote"),
				Config: map[string]string{
					"chart":   chart.ChartReference(), // bitnami/nginx
					"version": chartVersion.Version,   // 15.3.4
				},
				ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: true,
				ExpectHelmUpgrade:     false,
			})
		})

		// 2. Import by searching for an unpacked chart in the program directory.
		t.Run("chart directory", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-local-directory"),
				Config: map[string]string{
					"chart":   chart.Name, // nginx
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
				ExpectHelmUpgrade:     false,
			})
		})

		// 3. Import by searching for a chart archive in the program directory.
		t.Run("chart archive", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-local-tar"),
				Config: map[string]string{
					"chart":   fmt.Sprintf("%s-%s.tgz", chart.Name, chartVersion.Version), // nginx-15.3.4.tgz
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
				ExpectHelmUpgrade:     false,
			})
		})

		// 4. Import without matching a chart. The tool gives a warning, and a subsequent deployment
		// will cause a Helm upgrade to "correct" the inputs.
		t.Run("manual", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release-import", "step1-remote"),
				Config: map[string]string{
					"chart":   chart.Name,           // nginx
					"repo":    chart.HelmRepo.URL,   // https://charts.bitnami.com/bitnami
					"version": chartVersion.Version, // 15.3.4
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
				ExpectHelmUpgrade:     true,
			})
		})
	})

	t.Run("Import Deployment Created by Helm", func(t *testing.T) {
		baseDir := filepath.Join(cwd, "helm-import-deployment", "step1")
		namespace := getRandomNamespace("importdepl")
		chartPath := filepath.Join(baseDir, "./nginx")
		require.NoError(t, createRelease("mynginx", namespace, chartPath, true))
		defer func() {
			contract.IgnoreError(deleteRelease("mynginx", namespace))
		}()
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir: baseDir,
			Config: map[string]string{
				"namespace": namespace,
			},
			ExpectRefreshChanges: true,
			NoParallel:           true,
			Verbose:              true,
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Remote", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "helm", "step1"),
			Quick:                true,
			ExpectRefreshChanges: true,
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Release", func(t *testing.T) {
		chart := bitnamiNginxChart
		chartVersion := bitnamiNginxChart.Versions[0]

		// Run a program test for each of the various ways to install a Helm chart.
		type runOptions struct {
			InstallHelmRepository bool
		}
		run := func(t *testing.T, options integration.ProgramTestOptions, opts runOptions) {
			// create a Helm environment with a chart repository
			var repos []repo.Entry
			if opts.InstallHelmRepository {
				repos = append(repos, chart.HelmRepo)
			}
			he, cleanup, err := createHelmEnvironment(t, repos...)
			require.NoError(t, err, "failed to create Helm environment")
			t.Cleanup(func() {
				contract.IgnoreError(cleanup())
			})

			hValues, _ := json.Marshal(chartVersion.Values)
			successCriteria := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.NotEmpty(t, stack.Outputs["svc_ip"])
				assert.NotEmpty(t, stack.Outputs["resourceNames"])
			}
			options = options.With(integration.ProgramTestOptions{
				Config: map[string]string{
					"values": string(hValues),
				},
				Env:                    he.EnvVars(),
				Quick:                  true,
				ExpectRefreshChanges:   true,
				ExtraRuntimeValidation: successCriteria,
				NoParallel:             true,
				DestroyOnCleanup:       true,
			})

			integration.ProgramTest(t, &options)
		}

		// There's "six ways" to reference a Helm chart, and we test each of them here.

		// 1. By chart reference: helm install mymaria example/mariadb
		t.Run("chart reference", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   chart.ChartReference(), // bitnami/nginx
					"version": chartVersion.Version,   // 15.3.4
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: true,
			})
		})

		// 2. By path to an unpacked chart directory: helm install mynginx ./nginx
		t.Run("chart directory", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   filepath.Join(cwd, chart.TestPath), // "/workspace/tests/testdata/helm/nginx"
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})

		// 3. By path to a packaged chart: helm install mynginx ./nginx-1.2.3.tgz
		t.Run("chart archive", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   filepath.Join(cwd, chart.TestArchive), // /workspace/tests/testdata/nginx-15.3.4.tgz
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})

		// 4. By absolute URL: helm install mynginx https://example.com/charts/nginx-1.2.3.tgz
		t.Run("absolute URL", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   chart.ChartURL, // https://charts.bitnami.com/bitnami/nginx-15.3.4.tgz
					"version": chartVersion.Version,
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})

		// 5. By chart reference and repo url: helm install --repo https://example.com/charts/ mynginx nginx
		t.Run("chart reference and repo url", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   chart.Name,           // nginx
					"repo":    chart.HelmRepo.URL,   // https://charts.bitnami.com/bitnami
					"version": chartVersion.Version, // 15.3.4
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})

		// 6. By OCI registries: helm install mynginx --version 1.2.3 oci://example.com/charts/nginx
		t.Run("oci chart", func(t *testing.T) {
			options := baseOptions.With(integration.ProgramTestOptions{
				Dir: filepath.Join(cwd, "helm-release", "step1"),
				Config: map[string]string{
					"chart":   chart.OciURL,         // oci://registry-1.docker.io/bitnamicharts/nginx
					"version": chartVersion.Version, // 15.3.4
				},
			})
			run(t, options, runOptions{
				InstallHelmRepository: false,
			})
		})
	})

	t.Run("Helm Release (Local Chart Versioning)", func(t *testing.T) {
		validateVersion := func(t *testing.T, stack integration.RuntimeValidationStackInfo, expected string) {
			actual, ok := stack.Outputs["version"].(string)
			if !ok {
				t.Fatalf("expected a version output")
			}
			assert.Equal(t, expected, actual, "expected version to be %d", expected)
		}
		validateReplicas := func(t *testing.T, stack integration.RuntimeValidationStackInfo, expected float64) {
			actual, ok := stack.Outputs["replicas"].(float64)
			if !ok {
				t.Fatalf("expected a replicas output")
			}
			assert.Equal(t, expected, actual, "expected replicas to be %d", expected)
		}

		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "helm-release-local", "step1"),
			Quick:                true,
			ExpectRefreshChanges: true,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				validateReplicas(t, stack, 1)
			},
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join("helm-release-local", "step2"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
						// expect the change in values.yaml (replicaCount: 2) to NOT be detected
						// because Pulumi detects version changes only.
						validateReplicas(t, stack, 1)
						validateVersion(t, stack, "6.0.5")
					},
					ExpectFailure: false,
				},
				{
					Dir:      filepath.Join("helm-release-local", "step3"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
						// bump the chart version and expect Pulumi to perform an upgrade.
						validateReplicas(t, stack, 2)
						validateVersion(t, stack, "6.1.0")
					},
					ExpectFailure: false,
				},
				{
					Dir:      filepath.Join("helm-release-local", "step4"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
						// bump the chart version again but with ignoreChanges: ["version"]
						// expect no change in the number of replicas.
						validateReplicas(t, stack, 2)
						validateVersion(t, stack, "6.1.0")
					},
					ExpectFailure: false,
				},
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Release (Partial Error)", func(t *testing.T) {
		// Validate that we only see a single release in the namespace - success or failure.
		validation := func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
			var namespace string
			for _, res := range stack.Deployment.Resources {
				if res.Type == "kubernetes:helm.sh/v3:Release" {
					ns, found := res.Outputs["namespace"]
					assert.True(t, found)
					namespace = ns.(string)
				}
			}
			assert.NotEmpty(t, namespace)
			releases, err := listReleases(namespace)
			assert.NoError(t, err)
			assert.Len(t, releases, 1)
		}

		test := baseOptions.With(integration.ProgramTestOptions{
			Dir:                    filepath.Join("helm-partial-error", "step1"),
			SkipRefresh:            false,
			SkipEmptyPreviewUpdate: true,
			SkipPreview:            true,
			Verbose:                true,
			ExpectFailure:          true,
			ExtraRuntimeValidation: validation,
			EditDirs: []integration.EditDir{
				{
					Dir:                    filepath.Join("helm-partial-error", "step2"),
					Additive:               true,
					ExtraRuntimeValidation: validation,
					ExpectFailure:          false,
				},
			},
		})
		integration.ProgramTest(t, &test)
	})

	t.Run("Helm API Versions", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "helm-api-versions", "step1"),
			Quick:                true,
			ExpectRefreshChanges: true,
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Kube Version", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "helm-kube-version", "step1"),
			Quick:                true,
			ExpectRefreshChanges: true,
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Helm Skip CRD Rendering", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:         filepath.Join("helm-skip-crd-rendering", "step1"),
			Quick:       true,
			SkipRefresh: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				assert.NotNil(t, stackInfo.Deployment)
				assert.Equal(t, 8, len(stackInfo.Deployment.Resources))

				for _, res := range stackInfo.Deployment.Resources {
					if res.Type == "kubernetes:core/v1:Pod" {
						annotations, ok := openapi.Pluck(res.Inputs, "metadata", "annotations")
						if strings.Contains(res.ID.String(), "skip-crd") {
							assert.False(t, ok)
						} else {
							assert.True(t, ok)
							assert.Contains(t, annotations, "pulumi.com/skipAwait")
						}
					}
				}
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Kustomize", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:   filepath.Join(cwd, "kustomize"),
			Quick: true,
			OrderedConfig: []integration.ConfigValue{
				{
					Key:   "pulumi:disable-default-providers[0]",
					Value: "kubernetes",
					Path:  true,
				},
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("Secrets", func(t *testing.T) {
		secretMessage := "secret message for testing"

		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:   filepath.Join(cwd, "secrets"),
			Quick: true,
			Config: map[string]string{
				"message": secretMessage,
			},
			ExpectRefreshChanges: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				assert.NotNil(t, stackInfo.Deployment)
				state, err := json.Marshal(stackInfo.Deployment)
				assert.NoError(t, err)

				assert.NotContains(t, string(state), secretMessage)

				// The program converts the secret message to base64, to make a ConfigMap from it, so the state
				// should also not contain the base64 encoding of secret message.
				assert.NotContains(t, string(state), b64.StdEncoding.EncodeToString([]byte(secretMessage)))
			},
		})
		integration.ProgramTest(t, &options)
	})

	t.Run("ServerSideApply", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:                  filepath.Join(cwd, "server-side-apply"),
			ExpectRefreshChanges: true,
			OrderedConfig: []integration.ConfigValue{
				{
					Key:   "pulumi:disable-default-providers[0]",
					Value: "kubernetes",
					Path:  true,
				},
			},
			EditDirs: []integration.EditDir{
				{
					Dir:      filepath.Join("server-side-apply", "step2"),
					Additive: true,
					ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
						// Validate patched CustomResource
						crPatchedLabels := stackInfo.Outputs["crPatchedLabels"].(map[string]any)
						fooV, ok, err := unstructured.NestedString(crPatchedLabels, "foo")
						assert.True(t, ok)
						assert.NoError(t, err)
						assert.Equal(t, "foo", fooV)
					},
				},
			},
		})
		integration.ProgramTest(t, &options)
	})

	// Test to ensure https://github.com/pulumi/pulumi-kubernetes/issues/2336 is fixed. This spins up a deployment pod with
	// 2 containers using CSA. Then, it updates the deployment to use SSA while deleting one of the containers.
	t.Run("switchSSADeleteContainer", func(t *testing.T) {
		validation := func(expectedContainers string) func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
			return func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				ns, ok := stack.Outputs["namespace"].(string)
				if !ok {
					t.Fatalf("expected a string namespace output")
				}

				// Check that the stack has the expected number of deployments/resources.
				var count int
				for _, res := range stack.Deployment.Resources {
					// Validate that the deployment has the expected number of containers. We use kubectl to verify this,
					// as there have been issues in the past with Pulumi outputs not accurately reflecting the state of the
					// cluster.
					if !strings.Contains(string(res.URN), "v1:Deployment::deployment") {
						continue
					}

					count++
					out, err := exec.Command("kubectl", "get", "deployment", "-o", "jsonpath={.spec.template.spec.containers[*].name}", "-n", ns, "nginx").CombinedOutput()
					assert.NoError(t, err)
					assert.Equal(t, expectedContainers, string(out))
				}

				if count != 1 {
					t.Errorf("expected 1 resource, got %d", count)
				}
			}
		}

		test := baseOptions.With(integration.ProgramTestOptions{
			Dir:                    filepath.Join("switch-ssa-delete-container", "step1"),
			Verbose:                true,
			ExtraRuntimeValidation: validation("nginx sidecar"),
			EditDirs: []integration.EditDir{
				{
					Dir:                    filepath.Join("switch-ssa-delete-container", "step2"),
					Additive:               true,
					ExpectNoChanges:        false,
					ExtraRuntimeValidation: validation("nginx"),
				},
			},
		})
		integration.ProgramTest(t, &test)
	})

	// Test to ensure that we can get a resource from the default namespace. This uses the wordpress chart as it requires the
	// default namespace to be present in the GVK get request.
	t.Run("ChartGetResource", func(t *testing.T) {
		options := baseOptions.With(integration.ProgramTestOptions{
			Dir:   filepath.Join(cwd, "helm-get-default-namespace", "step1"),
			Quick: true,
			EditDirs: []integration.EditDir{
				{
					Dir:             filepath.Join(cwd, "helm-get-default-namespace", "step2"),
					Additive:        true,
					ExpectNoChanges: false,
				},
			},
		})
		integration.ProgramTest(t, &options)
	})
}
