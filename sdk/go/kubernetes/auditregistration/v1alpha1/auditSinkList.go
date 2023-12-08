// Code generated by pulumigen DO NOT EDIT.
// *** WARNING: Do not edit by hand unless you're certain you know what you are doing! ***

package v1alpha1

import (
	"context"
	"reflect"

	"errors"
	metav1 "github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/meta/v1"
	"github.com/pulumi/pulumi-kubernetes/sdk/v4/go/kubernetes/utilities"
	"github.com/pulumi/pulumi/sdk/v3/go/pulumi"
)

// AuditSinkList is a list of AuditSink items.
type AuditSinkList struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringOutput `pulumi:"apiVersion"`
	// List of audit configurations.
	Items AuditSinkTypeArrayOutput `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind     pulumi.StringOutput   `pulumi:"kind"`
	Metadata metav1.ListMetaOutput `pulumi:"metadata"`
}

// NewAuditSinkList registers a new resource with the given unique name, arguments, and options.
func NewAuditSinkList(ctx *pulumi.Context,
	name string, args *AuditSinkListArgs, opts ...pulumi.ResourceOption) (*AuditSinkList, error) {
	if args == nil {
		return nil, errors.New("missing one or more required arguments")
	}

	if args.Items == nil {
		return nil, errors.New("invalid value for required argument 'Items'")
	}
	args.ApiVersion = pulumi.StringPtr("auditregistration.k8s.io/v1alpha1")
	args.Kind = pulumi.StringPtr("AuditSinkList")
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource AuditSinkList
	err := ctx.RegisterResource("kubernetes:auditregistration.k8s.io/v1alpha1:AuditSinkList", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetAuditSinkList gets an existing AuditSinkList resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetAuditSinkList(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *AuditSinkListState, opts ...pulumi.ResourceOption) (*AuditSinkList, error) {
	var resource AuditSinkList
	err := ctx.ReadResource("kubernetes:auditregistration.k8s.io/v1alpha1:AuditSinkList", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering AuditSinkList resources.
type auditSinkListState struct {
}

type AuditSinkListState struct {
}

func (AuditSinkListState) ElementType() reflect.Type {
	return reflect.TypeOf((*auditSinkListState)(nil)).Elem()
}

type auditSinkListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// List of audit configurations.
	Items []AuditSinkType `pulumi:"items"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind     *string          `pulumi:"kind"`
	Metadata *metav1.ListMeta `pulumi:"metadata"`
}

// The set of arguments for constructing a AuditSinkList resource.
type AuditSinkListArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// List of audit configurations.
	Items AuditSinkTypeArrayInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind     pulumi.StringPtrInput
	Metadata metav1.ListMetaPtrInput
}

func (AuditSinkListArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*auditSinkListArgs)(nil)).Elem()
}

type AuditSinkListInput interface {
	pulumi.Input

	ToAuditSinkListOutput() AuditSinkListOutput
	ToAuditSinkListOutputWithContext(ctx context.Context) AuditSinkListOutput
}

func (*AuditSinkList) ElementType() reflect.Type {
	return reflect.TypeOf((**AuditSinkList)(nil)).Elem()
}

func (i *AuditSinkList) ToAuditSinkListOutput() AuditSinkListOutput {
	return i.ToAuditSinkListOutputWithContext(context.Background())
}

func (i *AuditSinkList) ToAuditSinkListOutputWithContext(ctx context.Context) AuditSinkListOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AuditSinkListOutput)
}

// AuditSinkListArrayInput is an input type that accepts AuditSinkListArray and AuditSinkListArrayOutput values.
// You can construct a concrete instance of `AuditSinkListArrayInput` via:
//
//	AuditSinkListArray{ AuditSinkListArgs{...} }
type AuditSinkListArrayInput interface {
	pulumi.Input

	ToAuditSinkListArrayOutput() AuditSinkListArrayOutput
	ToAuditSinkListArrayOutputWithContext(context.Context) AuditSinkListArrayOutput
}

type AuditSinkListArray []AuditSinkListInput

func (AuditSinkListArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AuditSinkList)(nil)).Elem()
}

func (i AuditSinkListArray) ToAuditSinkListArrayOutput() AuditSinkListArrayOutput {
	return i.ToAuditSinkListArrayOutputWithContext(context.Background())
}

func (i AuditSinkListArray) ToAuditSinkListArrayOutputWithContext(ctx context.Context) AuditSinkListArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AuditSinkListArrayOutput)
}

// AuditSinkListMapInput is an input type that accepts AuditSinkListMap and AuditSinkListMapOutput values.
// You can construct a concrete instance of `AuditSinkListMapInput` via:
//
//	AuditSinkListMap{ "key": AuditSinkListArgs{...} }
type AuditSinkListMapInput interface {
	pulumi.Input

	ToAuditSinkListMapOutput() AuditSinkListMapOutput
	ToAuditSinkListMapOutputWithContext(context.Context) AuditSinkListMapOutput
}

type AuditSinkListMap map[string]AuditSinkListInput

func (AuditSinkListMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AuditSinkList)(nil)).Elem()
}

func (i AuditSinkListMap) ToAuditSinkListMapOutput() AuditSinkListMapOutput {
	return i.ToAuditSinkListMapOutputWithContext(context.Background())
}

func (i AuditSinkListMap) ToAuditSinkListMapOutputWithContext(ctx context.Context) AuditSinkListMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(AuditSinkListMapOutput)
}

type AuditSinkListOutput struct{ *pulumi.OutputState }

func (AuditSinkListOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**AuditSinkList)(nil)).Elem()
}

func (o AuditSinkListOutput) ToAuditSinkListOutput() AuditSinkListOutput {
	return o
}

func (o AuditSinkListOutput) ToAuditSinkListOutputWithContext(ctx context.Context) AuditSinkListOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o AuditSinkListOutput) ApiVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *AuditSinkList) pulumi.StringOutput { return v.ApiVersion }).(pulumi.StringOutput)
}

// List of audit configurations.
func (o AuditSinkListOutput) Items() AuditSinkTypeArrayOutput {
	return o.ApplyT(func(v *AuditSinkList) AuditSinkTypeArrayOutput { return v.Items }).(AuditSinkTypeArrayOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o AuditSinkListOutput) Kind() pulumi.StringOutput {
	return o.ApplyT(func(v *AuditSinkList) pulumi.StringOutput { return v.Kind }).(pulumi.StringOutput)
}

func (o AuditSinkListOutput) Metadata() metav1.ListMetaOutput {
	return o.ApplyT(func(v *AuditSinkList) metav1.ListMetaOutput { return v.Metadata }).(metav1.ListMetaOutput)
}

type AuditSinkListArrayOutput struct{ *pulumi.OutputState }

func (AuditSinkListArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*AuditSinkList)(nil)).Elem()
}

func (o AuditSinkListArrayOutput) ToAuditSinkListArrayOutput() AuditSinkListArrayOutput {
	return o
}

func (o AuditSinkListArrayOutput) ToAuditSinkListArrayOutputWithContext(ctx context.Context) AuditSinkListArrayOutput {
	return o
}

func (o AuditSinkListArrayOutput) Index(i pulumi.IntInput) AuditSinkListOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *AuditSinkList {
		return vs[0].([]*AuditSinkList)[vs[1].(int)]
	}).(AuditSinkListOutput)
}

type AuditSinkListMapOutput struct{ *pulumi.OutputState }

func (AuditSinkListMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*AuditSinkList)(nil)).Elem()
}

func (o AuditSinkListMapOutput) ToAuditSinkListMapOutput() AuditSinkListMapOutput {
	return o
}

func (o AuditSinkListMapOutput) ToAuditSinkListMapOutputWithContext(ctx context.Context) AuditSinkListMapOutput {
	return o
}

func (o AuditSinkListMapOutput) MapIndex(k pulumi.StringInput) AuditSinkListOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *AuditSinkList {
		return vs[0].(map[string]*AuditSinkList)[vs[1].(string)]
	}).(AuditSinkListOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*AuditSinkListInput)(nil)).Elem(), &AuditSinkList{})
	pulumi.RegisterInputType(reflect.TypeOf((*AuditSinkListArrayInput)(nil)).Elem(), AuditSinkListArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*AuditSinkListMapInput)(nil)).Elem(), AuditSinkListMap{})
	pulumi.RegisterOutputType(AuditSinkListOutput{})
	pulumi.RegisterOutputType(AuditSinkListArrayOutput{})
	pulumi.RegisterOutputType(AuditSinkListMapOutput{})
}
