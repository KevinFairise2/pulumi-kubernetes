// Code generated by pulumigen DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package v1alpha2

import (
	"context"
	"reflect"

	"errors"
	metav1 "github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/meta/v1"
	"github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/utilities"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ResourceClassList is a collection of classes.
type ResourceClassList struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringOutput `pulumi:"apiVersion"`
	// Items is the list of resource classes.
	Items ResourceClassTypeArrayOutput `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringOutput `pulumi:"kind"`
	// Standard list metadata
	Metadata metav1.ListMetaOutput `pulumi:"metadata"`
}

// NewResourceClassList registers a new resource with the given unique name, arguments, and options.
func NewResourceClassList(ctx *pulumi.Context,
	name string, args *ResourceClassListArgs, opts ...pulumi.ResourceOption) (*ResourceClassList, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Items == nil {
		return nil, errors.New("invalid value for required argument 'Items'")
	}
	args.ApiVersion = pulumi.StringPtr("resource.k8s.io/v1alpha2")
	args.Kind = pulumi.StringPtr("ResourceClassList")
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource ResourceClassList
	err := ctx.RegisterResource("kubernetes:resource.k8s.io/v1alpha2:ResourceClassList", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetResourceClassList gets an existing ResourceClassList resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetResourceClassList(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ResourceClassListState, opts ...pulumi.ResourceOption) (*ResourceClassList, error) {
	var resource ResourceClassList
	err := ctx.ReadResource("kubernetes:resource.k8s.io/v1alpha2:ResourceClassList", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ResourceClassList resources.
type resourceClassListState struct {
}

type ResourceClassListState struct {
}

func (ResourceClassListState) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceClassListState)(nil)).Elem()
}

type resourceClassListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// Items is the list of resource classes.
	Items []ResourceClassType `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind *string `pulumi:"kind"`
	// Standard list metadata
	Metadata *metav1.ListMeta `pulumi:"metadata"`
}

// The set of arguments for constructing a ResourceClassList resource.
type ResourceClassListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// Items is the list of resource classes.
	Items ResourceClassTypeArrayInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrInput
	// Standard list metadata
	Metadata metav1.ListMetaPtrInput
}

func (ResourceClassListArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceClassListArgs)(nil)).Elem()
}

type ResourceClassListInput interface {
	pulumi.Input

	ToResourceClassListOutput() ResourceClassListOutput
	ToResourceClassListOutputWithContext(ctx context.Context) ResourceClassListOutput
}

func (*ResourceClassList) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceClassList)(nil)).Elem()
}

func (i *ResourceClassList) ToResourceClassListOutput() ResourceClassListOutput {
	return i.ToResourceClassListOutputWithContext(context.Background())
}

func (i *ResourceClassList) ToResourceClassListOutputWithContext(ctx context.Context) ResourceClassListOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassListOutput)
}

// ResourceClassListArrayInput is an input type that accepts ResourceClassListArray and ResourceClassListArrayOutput values.
// You can construct a concrete instance of `ResourceClassListArrayInput` via:
//
//	ResourceClassListArray{ ResourceClassListArgs{...} }
type ResourceClassListArrayInput interface {
	pulumi.Input

	ToResourceClassListArrayOutput() ResourceClassListArrayOutput
	ToResourceClassListArrayOutputWithContext(context.Context) ResourceClassListArrayOutput
}

type ResourceClassListArray []ResourceClassListInput

func (ResourceClassListArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceClassList)(nil)).Elem()
}

func (i ResourceClassListArray) ToResourceClassListArrayOutput() ResourceClassListArrayOutput {
	return i.ToResourceClassListArrayOutputWithContext(context.Background())
}

func (i ResourceClassListArray) ToResourceClassListArrayOutputWithContext(ctx context.Context) ResourceClassListArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassListArrayOutput)
}

// ResourceClassListMapInput is an input type that accepts ResourceClassListMap and ResourceClassListMapOutput values.
// You can construct a concrete instance of `ResourceClassListMapInput` via:
//
//	ResourceClassListMap{ "key": ResourceClassListArgs{...} }
type ResourceClassListMapInput interface {
	pulumi.Input

	ToResourceClassListMapOutput() ResourceClassListMapOutput
	ToResourceClassListMapOutputWithContext(context.Context) ResourceClassListMapOutput
}

type ResourceClassListMap map[string]ResourceClassListInput

func (ResourceClassListMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceClassList)(nil)).Elem()
}

func (i ResourceClassListMap) ToResourceClassListMapOutput() ResourceClassListMapOutput {
	return i.ToResourceClassListMapOutputWithContext(context.Background())
}

func (i ResourceClassListMap) ToResourceClassListMapOutputWithContext(ctx context.Context) ResourceClassListMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassListMapOutput)
}

type ResourceClassListOutput struct{ *pulumi.OutputState }

func (ResourceClassListOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceClassList)(nil)).Elem()
}

func (o ResourceClassListOutput) ToResourceClassListOutput() ResourceClassListOutput {
	return o
}

func (o ResourceClassListOutput) ToResourceClassListOutputWithContext(ctx context.Context) ResourceClassListOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o ResourceClassListOutput) ApiVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *ResourceClassList) pulumi.StringOutput { return v.ApiVersion }).(pulumi.StringOutput)
}

// Items is the list of resource classes.
func (o ResourceClassListOutput) Items() ResourceClassTypeArrayOutput {
	return o.ApplyT(func(v *ResourceClassList) ResourceClassTypeArrayOutput { return v.Items }).(ResourceClassTypeArrayOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ResourceClassListOutput) Kind() pulumi.StringOutput {
	return o.ApplyT(func(v *ResourceClassList) pulumi.StringOutput { return v.Kind }).(pulumi.StringOutput)
}

// Standard list metadata
func (o ResourceClassListOutput) Metadata() metav1.ListMetaOutput {
	return o.ApplyT(func(v *ResourceClassList) metav1.ListMetaOutput { return v.Metadata }).(metav1.ListMetaOutput)
}

type ResourceClassListArrayOutput struct{ *pulumi.OutputState }

func (ResourceClassListArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceClassList)(nil)).Elem()
}

func (o ResourceClassListArrayOutput) ToResourceClassListArrayOutput() ResourceClassListArrayOutput {
	return o
}

func (o ResourceClassListArrayOutput) ToResourceClassListArrayOutputWithContext(ctx context.Context) ResourceClassListArrayOutput {
	return o
}

func (o ResourceClassListArrayOutput) Index(i pulumi.IntInput) ResourceClassListOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ResourceClassList {
		return vs[0].([]*ResourceClassList)[vs[1].(int)]
	}).(ResourceClassListOutput)
}

type ResourceClassListMapOutput struct{ *pulumi.OutputState }

func (ResourceClassListMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceClassList)(nil)).Elem()
}

func (o ResourceClassListMapOutput) ToResourceClassListMapOutput() ResourceClassListMapOutput {
	return o
}

func (o ResourceClassListMapOutput) ToResourceClassListMapOutputWithContext(ctx context.Context) ResourceClassListMapOutput {
	return o
}

func (o ResourceClassListMapOutput) MapIndex(k pulumi.StringInput) ResourceClassListOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ResourceClassList {
		return vs[0].(map[string]*ResourceClassList)[vs[1].(string)]
	}).(ResourceClassListOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassListInput)(nil)).Elem(), &ResourceClassList{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassListArrayInput)(nil)).Elem(), ResourceClassListArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassListMapInput)(nil)).Elem(), ResourceClassListMap{})
	pulumi.RegisterOutputType(ResourceClassListOutput{})
	pulumi.RegisterOutputType(ResourceClassListArrayOutput{})
	pulumi.RegisterOutputType(ResourceClassListMapOutput{})
}
