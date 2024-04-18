// Code generated by pulumigen DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package v1

import (
	"context"
	"reflect"

	metav1 "github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/meta/v1"
	"github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/utilities"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// Patch resources are used to modify existing Kubernetes resources by using
// Server-Side Apply updates. The name of the resource must be specified, but all other properties are optional. More than
// one patch may be applied to the same resource, and a random FieldManager name will be used for each Patch resource.
// Conflicts will result in an error by default, but can be forced using the "pulumi.com/patchForce" annotation. See the
// [Server-Side Apply Docs](https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/) for
// additional information about using Server-Side Apply to manage Kubernetes resources with Pulumi.
// ValidatingAdmissionPolicy describes the definition of an admission validation policy that accepts or rejects an object without changing it.
type ValidatingAdmissionPolicyPatch struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrOutput `pulumi:"apiVersion"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrOutput `pulumi:"kind"`
	// Standard object metadata; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata.
	Metadata metav1.ObjectMetaPatchPtrOutput `pulumi:"metadata"`
	// Specification of the desired behavior of the ValidatingAdmissionPolicy.
	Spec ValidatingAdmissionPolicySpecPatchPtrOutput `pulumi:"spec"`
	// The status of the ValidatingAdmissionPolicy, including warnings that are useful to determine if the policy behaves in the expected way. Populated by the system. Read-only.
	Status ValidatingAdmissionPolicyStatusPatchPtrOutput `pulumi:"status"`
}

// NewValidatingAdmissionPolicyPatch registers a new resource with the given unique name, arguments, and options.
func NewValidatingAdmissionPolicyPatch(ctx *pulumi.Context,
	name string, args *ValidatingAdmissionPolicyPatchArgs, opts ...pulumi.ResourceOption) (*ValidatingAdmissionPolicyPatch, error) {
	if args == nil {
		args = &ValidatingAdmissionPolicyPatchArgs{}
	}

	args.ApiVersion = pulumi.StringPtr("admissionregistration.k8s.io/v1")
	args.Kind = pulumi.StringPtr("ValidatingAdmissionPolicy")
	aliases := pulumi.Aliases([]pulumi.Alias{
		{
			Type: pulumi.String("kubernetes:admissionregistration.k8s.io/v1alpha1:ValidatingAdmissionPolicyPatch"),
		},
		{
			Type: pulumi.String("kubernetes:admissionregistration.k8s.io/v1beta1:ValidatingAdmissionPolicyPatch"),
		},
	})
	opts = append(opts, aliases)
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource ValidatingAdmissionPolicyPatch
	err := ctx.RegisterResource("kubernetes:admissionregistration.k8s.io/v1:ValidatingAdmissionPolicyPatch", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetValidatingAdmissionPolicyPatch gets an existing ValidatingAdmissionPolicyPatch resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetValidatingAdmissionPolicyPatch(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ValidatingAdmissionPolicyPatchState, opts ...pulumi.ResourceOption) (*ValidatingAdmissionPolicyPatch, error) {
	var resource ValidatingAdmissionPolicyPatch
	err := ctx.ReadResource("kubernetes:admissionregistration.k8s.io/v1:ValidatingAdmissionPolicyPatch", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ValidatingAdmissionPolicyPatch resources.
type validatingAdmissionPolicyPatchState struct {
}

type ValidatingAdmissionPolicyPatchState struct {
}

func (ValidatingAdmissionPolicyPatchState) ElementType() reflect.Type {
	return reflect.TypeOf((*validatingAdmissionPolicyPatchState)(nil)).Elem()
}

type validatingAdmissionPolicyPatchArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind *string `pulumi:"kind"`
	// Standard object metadata; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata.
	Metadata *metav1.ObjectMetaPatch `pulumi:"metadata"`
	// Specification of the desired behavior of the ValidatingAdmissionPolicy.
	Spec *ValidatingAdmissionPolicySpecPatch `pulumi:"spec"`
}

// The set of arguments for constructing a ValidatingAdmissionPolicyPatch resource.
type ValidatingAdmissionPolicyPatchArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrInput
	// Standard object metadata; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata.
	Metadata metav1.ObjectMetaPatchPtrInput
	// Specification of the desired behavior of the ValidatingAdmissionPolicy.
	Spec ValidatingAdmissionPolicySpecPatchPtrInput
}

func (ValidatingAdmissionPolicyPatchArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*validatingAdmissionPolicyPatchArgs)(nil)).Elem()
}

type ValidatingAdmissionPolicyPatchInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyPatchOutput() ValidatingAdmissionPolicyPatchOutput
	ToValidatingAdmissionPolicyPatchOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchOutput
}

func (*ValidatingAdmissionPolicyPatch) ElementType() reflect.Type {
	return reflect.TypeOf((**ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (i *ValidatingAdmissionPolicyPatch) ToValidatingAdmissionPolicyPatchOutput() ValidatingAdmissionPolicyPatchOutput {
	return i.ToValidatingAdmissionPolicyPatchOutputWithContext(context.Background())
}

func (i *ValidatingAdmissionPolicyPatch) ToValidatingAdmissionPolicyPatchOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyPatchOutput)
}

// ValidatingAdmissionPolicyPatchArrayInput is an input type that accepts ValidatingAdmissionPolicyPatchArray and ValidatingAdmissionPolicyPatchArrayOutput values.
// You can construct a concrete instance of `ValidatingAdmissionPolicyPatchArrayInput` via:
//
//	ValidatingAdmissionPolicyPatchArray{ ValidatingAdmissionPolicyPatchArgs{...} }
type ValidatingAdmissionPolicyPatchArrayInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyPatchArrayOutput() ValidatingAdmissionPolicyPatchArrayOutput
	ToValidatingAdmissionPolicyPatchArrayOutputWithContext(context.Context) ValidatingAdmissionPolicyPatchArrayOutput
}

type ValidatingAdmissionPolicyPatchArray []ValidatingAdmissionPolicyPatchInput

func (ValidatingAdmissionPolicyPatchArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (i ValidatingAdmissionPolicyPatchArray) ToValidatingAdmissionPolicyPatchArrayOutput() ValidatingAdmissionPolicyPatchArrayOutput {
	return i.ToValidatingAdmissionPolicyPatchArrayOutputWithContext(context.Background())
}

func (i ValidatingAdmissionPolicyPatchArray) ToValidatingAdmissionPolicyPatchArrayOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyPatchArrayOutput)
}

// ValidatingAdmissionPolicyPatchMapInput is an input type that accepts ValidatingAdmissionPolicyPatchMap and ValidatingAdmissionPolicyPatchMapOutput values.
// You can construct a concrete instance of `ValidatingAdmissionPolicyPatchMapInput` via:
//
//	ValidatingAdmissionPolicyPatchMap{ "key": ValidatingAdmissionPolicyPatchArgs{...} }
type ValidatingAdmissionPolicyPatchMapInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyPatchMapOutput() ValidatingAdmissionPolicyPatchMapOutput
	ToValidatingAdmissionPolicyPatchMapOutputWithContext(context.Context) ValidatingAdmissionPolicyPatchMapOutput
}

type ValidatingAdmissionPolicyPatchMap map[string]ValidatingAdmissionPolicyPatchInput

func (ValidatingAdmissionPolicyPatchMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (i ValidatingAdmissionPolicyPatchMap) ToValidatingAdmissionPolicyPatchMapOutput() ValidatingAdmissionPolicyPatchMapOutput {
	return i.ToValidatingAdmissionPolicyPatchMapOutputWithContext(context.Background())
}

func (i ValidatingAdmissionPolicyPatchMap) ToValidatingAdmissionPolicyPatchMapOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyPatchMapOutput)
}

type ValidatingAdmissionPolicyPatchOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyPatchOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyPatchOutput) ToValidatingAdmissionPolicyPatchOutput() ValidatingAdmissionPolicyPatchOutput {
	return o
}

func (o ValidatingAdmissionPolicyPatchOutput) ToValidatingAdmissionPolicyPatchOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o ValidatingAdmissionPolicyPatchOutput) ApiVersion() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyPatch) pulumi.StringPtrOutput { return v.ApiVersion }).(pulumi.StringPtrOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ValidatingAdmissionPolicyPatchOutput) Kind() pulumi.StringPtrOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyPatch) pulumi.StringPtrOutput { return v.Kind }).(pulumi.StringPtrOutput)
}

// Standard object metadata; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata.
func (o ValidatingAdmissionPolicyPatchOutput) Metadata() metav1.ObjectMetaPatchPtrOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyPatch) metav1.ObjectMetaPatchPtrOutput { return v.Metadata }).(metav1.ObjectMetaPatchPtrOutput)
}

// Specification of the desired behavior of the ValidatingAdmissionPolicy.
func (o ValidatingAdmissionPolicyPatchOutput) Spec() ValidatingAdmissionPolicySpecPatchPtrOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyPatch) ValidatingAdmissionPolicySpecPatchPtrOutput { return v.Spec }).(ValidatingAdmissionPolicySpecPatchPtrOutput)
}

// The status of the ValidatingAdmissionPolicy, including warnings that are useful to determine if the policy behaves in the expected way. Populated by the system. Read-only.
func (o ValidatingAdmissionPolicyPatchOutput) Status() ValidatingAdmissionPolicyStatusPatchPtrOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyPatch) ValidatingAdmissionPolicyStatusPatchPtrOutput { return v.Status }).(ValidatingAdmissionPolicyStatusPatchPtrOutput)
}

type ValidatingAdmissionPolicyPatchArrayOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyPatchArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyPatchArrayOutput) ToValidatingAdmissionPolicyPatchArrayOutput() ValidatingAdmissionPolicyPatchArrayOutput {
	return o
}

func (o ValidatingAdmissionPolicyPatchArrayOutput) ToValidatingAdmissionPolicyPatchArrayOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchArrayOutput {
	return o
}

func (o ValidatingAdmissionPolicyPatchArrayOutput) Index(i pulumi.IntInput) ValidatingAdmissionPolicyPatchOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ValidatingAdmissionPolicyPatch {
		return vs[0].([]*ValidatingAdmissionPolicyPatch)[vs[1].(int)]
	}).(ValidatingAdmissionPolicyPatchOutput)
}

type ValidatingAdmissionPolicyPatchMapOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyPatchMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ValidatingAdmissionPolicyPatch)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyPatchMapOutput) ToValidatingAdmissionPolicyPatchMapOutput() ValidatingAdmissionPolicyPatchMapOutput {
	return o
}

func (o ValidatingAdmissionPolicyPatchMapOutput) ToValidatingAdmissionPolicyPatchMapOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyPatchMapOutput {
	return o
}

func (o ValidatingAdmissionPolicyPatchMapOutput) MapIndex(k pulumi.StringInput) ValidatingAdmissionPolicyPatchOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ValidatingAdmissionPolicyPatch {
		return vs[0].(map[string]*ValidatingAdmissionPolicyPatch)[vs[1].(string)]
	}).(ValidatingAdmissionPolicyPatchOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyPatchInput)(nil)).Elem(), &ValidatingAdmissionPolicyPatch{})
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyPatchArrayInput)(nil)).Elem(), ValidatingAdmissionPolicyPatchArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyPatchMapInput)(nil)).Elem(), ValidatingAdmissionPolicyPatchMap{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyPatchOutput{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyPatchArrayOutput{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyPatchMapOutput{})
}
