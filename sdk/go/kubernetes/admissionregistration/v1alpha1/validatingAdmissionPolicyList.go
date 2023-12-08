// Code generated by pulumigen DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package v1alpha1

import (
	"context"
	"reflect"

	metav1 "github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/meta/v1"
	"github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/utilities"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ValidatingAdmissionPolicyList is a list of ValidatingAdmissionPolicy.
type ValidatingAdmissionPolicyList struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringOutput `pulumi:"apiVersion"`
	// List of ValidatingAdmissionPolicy.
	Items ValidatingAdmissionPolicyTypeArrayOutput `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringOutput `pulumi:"kind"`
	// Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Metadata metav1.ListMetaOutput `pulumi:"metadata"`
}

// NewValidatingAdmissionPolicyList registers a new resource with the given unique name, arguments, and options.
func NewValidatingAdmissionPolicyList(ctx *pulumi.Context,
	name string, args *ValidatingAdmissionPolicyListArgs, opts ...pulumi.ResourceOption) (*ValidatingAdmissionPolicyList, error) {
	if args == nil {
		args = &ValidatingAdmissionPolicyListArgs{}
	}

	args.ApiVersion = pulumi.StringPtr("admissionregistration.k8s.io/v1alpha1")
	args.Kind = pulumi.StringPtr("ValidatingAdmissionPolicyList")
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource ValidatingAdmissionPolicyList
	err := ctx.RegisterResource("kubernetes:admissionregistration.k8s.io/v1alpha1:ValidatingAdmissionPolicyList", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetValidatingAdmissionPolicyList gets an existing ValidatingAdmissionPolicyList resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetValidatingAdmissionPolicyList(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ValidatingAdmissionPolicyListState, opts ...pulumi.ResourceOption) (*ValidatingAdmissionPolicyList, error) {
	var resource ValidatingAdmissionPolicyList
	err := ctx.ReadResource("kubernetes:admissionregistration.k8s.io/v1alpha1:ValidatingAdmissionPolicyList", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ValidatingAdmissionPolicyList resources.
type validatingAdmissionPolicyListState struct {
}

type ValidatingAdmissionPolicyListState struct {
}

func (ValidatingAdmissionPolicyListState) ElementType() reflect.Type {
	return reflect.TypeOf((*validatingAdmissionPolicyListState)(nil)).Elem()
}

type validatingAdmissionPolicyListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// List of ValidatingAdmissionPolicy.
	Items []ValidatingAdmissionPolicyType `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind *string `pulumi:"kind"`
	// Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Metadata *metav1.ListMeta `pulumi:"metadata"`
}

// The set of arguments for constructing a ValidatingAdmissionPolicyList resource.
type ValidatingAdmissionPolicyListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// List of ValidatingAdmissionPolicy.
	Items ValidatingAdmissionPolicyTypeArrayInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrInput
	// Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Metadata metav1.ListMetaPtrInput
}

func (ValidatingAdmissionPolicyListArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*validatingAdmissionPolicyListArgs)(nil)).Elem()
}

type ValidatingAdmissionPolicyListInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyListOutput() ValidatingAdmissionPolicyListOutput
	ToValidatingAdmissionPolicyListOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListOutput
}

func (*ValidatingAdmissionPolicyList) ElementType() reflect.Type {
	return reflect.TypeOf((**ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (i *ValidatingAdmissionPolicyList) ToValidatingAdmissionPolicyListOutput() ValidatingAdmissionPolicyListOutput {
	return i.ToValidatingAdmissionPolicyListOutputWithContext(context.Background())
}

func (i *ValidatingAdmissionPolicyList) ToValidatingAdmissionPolicyListOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyListOutput)
}

// ValidatingAdmissionPolicyListArrayInput is an input type that accepts ValidatingAdmissionPolicyListArray and ValidatingAdmissionPolicyListArrayOutput values.
// You can construct a concrete instance of `ValidatingAdmissionPolicyListArrayInput` via:
//
//	ValidatingAdmissionPolicyListArray{ ValidatingAdmissionPolicyListArgs{...} }
type ValidatingAdmissionPolicyListArrayInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyListArrayOutput() ValidatingAdmissionPolicyListArrayOutput
	ToValidatingAdmissionPolicyListArrayOutputWithContext(context.Context) ValidatingAdmissionPolicyListArrayOutput
}

type ValidatingAdmissionPolicyListArray []ValidatingAdmissionPolicyListInput

func (ValidatingAdmissionPolicyListArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (i ValidatingAdmissionPolicyListArray) ToValidatingAdmissionPolicyListArrayOutput() ValidatingAdmissionPolicyListArrayOutput {
	return i.ToValidatingAdmissionPolicyListArrayOutputWithContext(context.Background())
}

func (i ValidatingAdmissionPolicyListArray) ToValidatingAdmissionPolicyListArrayOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyListArrayOutput)
}

// ValidatingAdmissionPolicyListMapInput is an input type that accepts ValidatingAdmissionPolicyListMap and ValidatingAdmissionPolicyListMapOutput values.
// You can construct a concrete instance of `ValidatingAdmissionPolicyListMapInput` via:
//
//	ValidatingAdmissionPolicyListMap{ "key": ValidatingAdmissionPolicyListArgs{...} }
type ValidatingAdmissionPolicyListMapInput interface {
	pulumi.Input

	ToValidatingAdmissionPolicyListMapOutput() ValidatingAdmissionPolicyListMapOutput
	ToValidatingAdmissionPolicyListMapOutputWithContext(context.Context) ValidatingAdmissionPolicyListMapOutput
}

type ValidatingAdmissionPolicyListMap map[string]ValidatingAdmissionPolicyListInput

func (ValidatingAdmissionPolicyListMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (i ValidatingAdmissionPolicyListMap) ToValidatingAdmissionPolicyListMapOutput() ValidatingAdmissionPolicyListMapOutput {
	return i.ToValidatingAdmissionPolicyListMapOutputWithContext(context.Background())
}

func (i ValidatingAdmissionPolicyListMap) ToValidatingAdmissionPolicyListMapOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ValidatingAdmissionPolicyListMapOutput)
}

type ValidatingAdmissionPolicyListOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyListOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyListOutput) ToValidatingAdmissionPolicyListOutput() ValidatingAdmissionPolicyListOutput {
	return o
}

func (o ValidatingAdmissionPolicyListOutput) ToValidatingAdmissionPolicyListOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o ValidatingAdmissionPolicyListOutput) ApiVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyList) pulumi.StringOutput { return v.ApiVersion }).(pulumi.StringOutput)
}

// List of ValidatingAdmissionPolicy.
func (o ValidatingAdmissionPolicyListOutput) Items() ValidatingAdmissionPolicyTypeArrayOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyList) ValidatingAdmissionPolicyTypeArrayOutput { return v.Items }).(ValidatingAdmissionPolicyTypeArrayOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ValidatingAdmissionPolicyListOutput) Kind() pulumi.StringOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyList) pulumi.StringOutput { return v.Kind }).(pulumi.StringOutput)
}

// Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ValidatingAdmissionPolicyListOutput) Metadata() metav1.ListMetaOutput {
	return o.ApplyT(func(v *ValidatingAdmissionPolicyList) metav1.ListMetaOutput { return v.Metadata }).(metav1.ListMetaOutput)
}

type ValidatingAdmissionPolicyListArrayOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyListArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyListArrayOutput) ToValidatingAdmissionPolicyListArrayOutput() ValidatingAdmissionPolicyListArrayOutput {
	return o
}

func (o ValidatingAdmissionPolicyListArrayOutput) ToValidatingAdmissionPolicyListArrayOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListArrayOutput {
	return o
}

func (o ValidatingAdmissionPolicyListArrayOutput) Index(i pulumi.IntInput) ValidatingAdmissionPolicyListOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ValidatingAdmissionPolicyList {
		return vs[0].([]*ValidatingAdmissionPolicyList)[vs[1].(int)]
	}).(ValidatingAdmissionPolicyListOutput)
}

type ValidatingAdmissionPolicyListMapOutput struct{ *pulumi.OutputState }

func (ValidatingAdmissionPolicyListMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ValidatingAdmissionPolicyList)(nil)).Elem()
}

func (o ValidatingAdmissionPolicyListMapOutput) ToValidatingAdmissionPolicyListMapOutput() ValidatingAdmissionPolicyListMapOutput {
	return o
}

func (o ValidatingAdmissionPolicyListMapOutput) ToValidatingAdmissionPolicyListMapOutputWithContext(ctx context.Context) ValidatingAdmissionPolicyListMapOutput {
	return o
}

func (o ValidatingAdmissionPolicyListMapOutput) MapIndex(k pulumi.StringInput) ValidatingAdmissionPolicyListOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ValidatingAdmissionPolicyList {
		return vs[0].(map[string]*ValidatingAdmissionPolicyList)[vs[1].(string)]
	}).(ValidatingAdmissionPolicyListOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyListInput)(nil)).Elem(), &ValidatingAdmissionPolicyList{})
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyListArrayInput)(nil)).Elem(), ValidatingAdmissionPolicyListArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ValidatingAdmissionPolicyListMapInput)(nil)).Elem(), ValidatingAdmissionPolicyListMap{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyListOutput{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyListArrayOutput{})
	pulumi.RegisterOutputType(ValidatingAdmissionPolicyListMapOutput{})
}
