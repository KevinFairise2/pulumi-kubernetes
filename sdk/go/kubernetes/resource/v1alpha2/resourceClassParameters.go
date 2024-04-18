// Code generated by pulumigen DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package v1alpha2

import (
	"context"
	"reflect"

	metav1 "github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/meta/v1"
	"github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/utilities"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// ResourceClassParameters defines resource requests for a ResourceClass in an in-tree format understood by Kubernetes.
type ResourceClassParameters struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringOutput `pulumi:"apiVersion"`
	// Filters describes additional contraints that must be met when using the class.
	Filters ResourceFilterArrayOutput `pulumi:"filters"`
	// If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
	GeneratedFrom ResourceClassParametersReferenceOutput `pulumi:"generatedFrom"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringOutput `pulumi:"kind"`
	// Standard object metadata
	Metadata metav1.ObjectMetaOutput `pulumi:"metadata"`
	// VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
	VendorParameters VendorParametersArrayOutput `pulumi:"vendorParameters"`
}

// NewResourceClassParameters registers a new resource with the given unique name, arguments, and options.
func NewResourceClassParameters(ctx *pulumi.Context,
	name string, args *ResourceClassParametersArgs, opts ...pulumi.ResourceOption) (*ResourceClassParameters, error) {
	if args == nil {
		args = &ResourceClassParametersArgs{}
	}

	args.ApiVersion = pulumi.StringPtr("resource.k8s.io/v1alpha2")
	args.Kind = pulumi.StringPtr("ResourceClassParameters")
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource ResourceClassParameters
	err := ctx.RegisterResource("kubernetes:resource.k8s.io/v1alpha2:ResourceClassParameters", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetResourceClassParameters gets an existing ResourceClassParameters resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetResourceClassParameters(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ResourceClassParametersState, opts ...pulumi.ResourceOption) (*ResourceClassParameters, error) {
	var resource ResourceClassParameters
	err := ctx.ReadResource("kubernetes:resource.k8s.io/v1alpha2:ResourceClassParameters", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ResourceClassParameters resources.
type resourceClassParametersState struct {
}

type ResourceClassParametersState struct {
}

func (ResourceClassParametersState) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceClassParametersState)(nil)).Elem()
}

type resourceClassParametersArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// Filters describes additional contraints that must be met when using the class.
	Filters []ResourceFilter `pulumi:"filters"`
	// If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
	GeneratedFrom *ResourceClassParametersReference `pulumi:"generatedFrom"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind *string `pulumi:"kind"`
	// Standard object metadata
	Metadata *metav1.ObjectMeta `pulumi:"metadata"`
	// VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
	VendorParameters []VendorParameters `pulumi:"vendorParameters"`
}

// The set of arguments for constructing a ResourceClassParameters resource.
type ResourceClassParametersArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// Filters describes additional contraints that must be met when using the class.
	Filters ResourceFilterArrayInput
	// If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
	GeneratedFrom ResourceClassParametersReferencePtrInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrInput
	// Standard object metadata
	Metadata metav1.ObjectMetaPtrInput
	// VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
	VendorParameters VendorParametersArrayInput
}

func (ResourceClassParametersArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*resourceClassParametersArgs)(nil)).Elem()
}

type ResourceClassParametersInput interface {
	pulumi.Input

	ToResourceClassParametersOutput() ResourceClassParametersOutput
	ToResourceClassParametersOutputWithContext(ctx context.Context) ResourceClassParametersOutput
}

func (*ResourceClassParameters) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceClassParameters)(nil)).Elem()
}

func (i *ResourceClassParameters) ToResourceClassParametersOutput() ResourceClassParametersOutput {
	return i.ToResourceClassParametersOutputWithContext(context.Background())
}

func (i *ResourceClassParameters) ToResourceClassParametersOutputWithContext(ctx context.Context) ResourceClassParametersOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassParametersOutput)
}

// ResourceClassParametersArrayInput is an input type that accepts ResourceClassParametersArray and ResourceClassParametersArrayOutput values.
// You can construct a concrete instance of `ResourceClassParametersArrayInput` via:
//
//	ResourceClassParametersArray{ ResourceClassParametersArgs{...} }
type ResourceClassParametersArrayInput interface {
	pulumi.Input

	ToResourceClassParametersArrayOutput() ResourceClassParametersArrayOutput
	ToResourceClassParametersArrayOutputWithContext(context.Context) ResourceClassParametersArrayOutput
}

type ResourceClassParametersArray []ResourceClassParametersInput

func (ResourceClassParametersArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceClassParameters)(nil)).Elem()
}

func (i ResourceClassParametersArray) ToResourceClassParametersArrayOutput() ResourceClassParametersArrayOutput {
	return i.ToResourceClassParametersArrayOutputWithContext(context.Background())
}

func (i ResourceClassParametersArray) ToResourceClassParametersArrayOutputWithContext(ctx context.Context) ResourceClassParametersArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassParametersArrayOutput)
}

// ResourceClassParametersMapInput is an input type that accepts ResourceClassParametersMap and ResourceClassParametersMapOutput values.
// You can construct a concrete instance of `ResourceClassParametersMapInput` via:
//
//	ResourceClassParametersMap{ "key": ResourceClassParametersArgs{...} }
type ResourceClassParametersMapInput interface {
	pulumi.Input

	ToResourceClassParametersMapOutput() ResourceClassParametersMapOutput
	ToResourceClassParametersMapOutputWithContext(context.Context) ResourceClassParametersMapOutput
}

type ResourceClassParametersMap map[string]ResourceClassParametersInput

func (ResourceClassParametersMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceClassParameters)(nil)).Elem()
}

func (i ResourceClassParametersMap) ToResourceClassParametersMapOutput() ResourceClassParametersMapOutput {
	return i.ToResourceClassParametersMapOutputWithContext(context.Background())
}

func (i ResourceClassParametersMap) ToResourceClassParametersMapOutputWithContext(ctx context.Context) ResourceClassParametersMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ResourceClassParametersMapOutput)
}

type ResourceClassParametersOutput struct{ *pulumi.OutputState }

func (ResourceClassParametersOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ResourceClassParameters)(nil)).Elem()
}

func (o ResourceClassParametersOutput) ToResourceClassParametersOutput() ResourceClassParametersOutput {
	return o
}

func (o ResourceClassParametersOutput) ToResourceClassParametersOutputWithContext(ctx context.Context) ResourceClassParametersOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o ResourceClassParametersOutput) ApiVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *ResourceClassParameters) pulumi.StringOutput { return v.ApiVersion }).(pulumi.StringOutput)
}

// Filters describes additional contraints that must be met when using the class.
func (o ResourceClassParametersOutput) Filters() ResourceFilterArrayOutput {
	return o.ApplyT(func(v *ResourceClassParameters) ResourceFilterArrayOutput { return v.Filters }).(ResourceFilterArrayOutput)
}

// If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
func (o ResourceClassParametersOutput) GeneratedFrom() ResourceClassParametersReferenceOutput {
	return o.ApplyT(func(v *ResourceClassParameters) ResourceClassParametersReferenceOutput { return v.GeneratedFrom }).(ResourceClassParametersReferenceOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ResourceClassParametersOutput) Kind() pulumi.StringOutput {
	return o.ApplyT(func(v *ResourceClassParameters) pulumi.StringOutput { return v.Kind }).(pulumi.StringOutput)
}

// Standard object metadata
func (o ResourceClassParametersOutput) Metadata() metav1.ObjectMetaOutput {
	return o.ApplyT(func(v *ResourceClassParameters) metav1.ObjectMetaOutput { return v.Metadata }).(metav1.ObjectMetaOutput)
}

// VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
func (o ResourceClassParametersOutput) VendorParameters() VendorParametersArrayOutput {
	return o.ApplyT(func(v *ResourceClassParameters) VendorParametersArrayOutput { return v.VendorParameters }).(VendorParametersArrayOutput)
}

type ResourceClassParametersArrayOutput struct{ *pulumi.OutputState }

func (ResourceClassParametersArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ResourceClassParameters)(nil)).Elem()
}

func (o ResourceClassParametersArrayOutput) ToResourceClassParametersArrayOutput() ResourceClassParametersArrayOutput {
	return o
}

func (o ResourceClassParametersArrayOutput) ToResourceClassParametersArrayOutputWithContext(ctx context.Context) ResourceClassParametersArrayOutput {
	return o
}

func (o ResourceClassParametersArrayOutput) Index(i pulumi.IntInput) ResourceClassParametersOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ResourceClassParameters {
		return vs[0].([]*ResourceClassParameters)[vs[1].(int)]
	}).(ResourceClassParametersOutput)
}

type ResourceClassParametersMapOutput struct{ *pulumi.OutputState }

func (ResourceClassParametersMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ResourceClassParameters)(nil)).Elem()
}

func (o ResourceClassParametersMapOutput) ToResourceClassParametersMapOutput() ResourceClassParametersMapOutput {
	return o
}

func (o ResourceClassParametersMapOutput) ToResourceClassParametersMapOutputWithContext(ctx context.Context) ResourceClassParametersMapOutput {
	return o
}

func (o ResourceClassParametersMapOutput) MapIndex(k pulumi.StringInput) ResourceClassParametersOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ResourceClassParameters {
		return vs[0].(map[string]*ResourceClassParameters)[vs[1].(string)]
	}).(ResourceClassParametersOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassParametersInput)(nil)).Elem(), &ResourceClassParameters{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassParametersArrayInput)(nil)).Elem(), ResourceClassParametersArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ResourceClassParametersMapInput)(nil)).Elem(), ResourceClassParametersMap{})
	pulumi.RegisterOutputType(ResourceClassParametersOutput{})
	pulumi.RegisterOutputType(ResourceClassParametersArrayOutput{})
	pulumi.RegisterOutputType(ResourceClassParametersMapOutput{})
}
