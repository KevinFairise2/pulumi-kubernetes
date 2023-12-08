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

// ReplicationController represents the configuration of a replication controller.
type ReplicationController struct {
	pulumi.CustomResourceState

	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringOutput `pulumi:"apiVersion"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringOutput `pulumi:"kind"`
	// If the Labels of a ReplicationController are empty, they are defaulted to be the same as the Pod(s) that the replication controller manages. Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
	Metadata metav1.ObjectMetaOutput `pulumi:"metadata"`
	// Spec defines the specification of the desired behavior of the replication controller. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
	Spec ReplicationControllerSpecOutput `pulumi:"spec"`
	// Status is the most recently observed status of the replication controller. This data may be out of date by some window of time. Populated by the system. Read-only. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
	Status ReplicationControllerStatusPtrOutput `pulumi:"status"`
}

// NewReplicationController registers a new resource with the given unique name, arguments, and options.
func NewReplicationController(ctx *pulumi.Context,
	name string, args *ReplicationControllerArgs, opts ...pulumi.ResourceOption) (*ReplicationController, error) {
	if args == nil {
		args = &ReplicationControllerArgs{}
	}

	args.ApiVersion = pulumi.StringPtr("v1")
	args.Kind = pulumi.StringPtr("ReplicationController")
	opts = utilities.PkgResourceDefaultOpts(opts)
	var resource ReplicationController
	err := ctx.RegisterResource("kubernetes:core/v1:ReplicationController", name, args, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// GetReplicationController gets an existing ReplicationController resource's state with the given name, ID, and optional
// state properties that are used to uniquely qualify the lookup (nil if not required).
func GetReplicationController(ctx *pulumi.Context,
	name string, id pulumi.IDInput, state *ReplicationControllerState, opts ...pulumi.ResourceOption) (*ReplicationController, error) {
	var resource ReplicationController
	err := ctx.ReadResource("kubernetes:core/v1:ReplicationController", name, id, state, &resource, opts...)
	if err != nil {
		return nil, err
	}
	return &resource, nil
}

// Input properties used for looking up and filtering ReplicationController resources.
type replicationControllerState struct {
}

type ReplicationControllerState struct {
}

func (ReplicationControllerState) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationControllerState)(nil)).Elem()
}

type replicationControllerArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion *string `pulumi:"apiVersion"`
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind *string `pulumi:"kind"`
	// If the Labels of a ReplicationController are empty, they are defaulted to be the same as the Pod(s) that the replication controller manages. Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
	Metadata *metav1.ObjectMeta `pulumi:"metadata"`
	// Spec defines the specification of the desired behavior of the replication controller. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
	Spec *ReplicationControllerSpec `pulumi:"spec"`
}

// The set of arguments for constructing a ReplicationController resource.
type ReplicationControllerArgs struct {
	// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
	ApiVersion pulumi.StringPtrInput
	// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
	Kind pulumi.StringPtrInput
	// If the Labels of a ReplicationController are empty, they are defaulted to be the same as the Pod(s) that the replication controller manages. Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
	Metadata metav1.ObjectMetaPtrInput
	// Spec defines the specification of the desired behavior of the replication controller. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
	Spec ReplicationControllerSpecPtrInput
}

func (ReplicationControllerArgs) ElementType() reflect.Type {
	return reflect.TypeOf((*replicationControllerArgs)(nil)).Elem()
}

type ReplicationControllerInput interface {
	pulumi.Input

	ToReplicationControllerOutput() ReplicationControllerOutput
	ToReplicationControllerOutputWithContext(ctx context.Context) ReplicationControllerOutput
}

func (*ReplicationController) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationController)(nil)).Elem()
}

func (i *ReplicationController) ToReplicationControllerOutput() ReplicationControllerOutput {
	return i.ToReplicationControllerOutputWithContext(context.Background())
}

func (i *ReplicationController) ToReplicationControllerOutputWithContext(ctx context.Context) ReplicationControllerOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationControllerOutput)
}

// ReplicationControllerArrayInput is an input type that accepts ReplicationControllerArray and ReplicationControllerArrayOutput values.
// You can construct a concrete instance of `ReplicationControllerArrayInput` via:
//
//	ReplicationControllerArray{ ReplicationControllerArgs{...} }
type ReplicationControllerArrayInput interface {
	pulumi.Input

	ToReplicationControllerArrayOutput() ReplicationControllerArrayOutput
	ToReplicationControllerArrayOutputWithContext(context.Context) ReplicationControllerArrayOutput
}

type ReplicationControllerArray []ReplicationControllerInput

func (ReplicationControllerArray) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationController)(nil)).Elem()
}

func (i ReplicationControllerArray) ToReplicationControllerArrayOutput() ReplicationControllerArrayOutput {
	return i.ToReplicationControllerArrayOutputWithContext(context.Background())
}

func (i ReplicationControllerArray) ToReplicationControllerArrayOutputWithContext(ctx context.Context) ReplicationControllerArrayOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationControllerArrayOutput)
}

// ReplicationControllerMapInput is an input type that accepts ReplicationControllerMap and ReplicationControllerMapOutput values.
// You can construct a concrete instance of `ReplicationControllerMapInput` via:
//
//	ReplicationControllerMap{ "key": ReplicationControllerArgs{...} }
type ReplicationControllerMapInput interface {
	pulumi.Input

	ToReplicationControllerMapOutput() ReplicationControllerMapOutput
	ToReplicationControllerMapOutputWithContext(context.Context) ReplicationControllerMapOutput
}

type ReplicationControllerMap map[string]ReplicationControllerInput

func (ReplicationControllerMap) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationController)(nil)).Elem()
}

func (i ReplicationControllerMap) ToReplicationControllerMapOutput() ReplicationControllerMapOutput {
	return i.ToReplicationControllerMapOutputWithContext(context.Background())
}

func (i ReplicationControllerMap) ToReplicationControllerMapOutputWithContext(ctx context.Context) ReplicationControllerMapOutput {
	return pulumi.ToOutputWithContext(ctx, i).(ReplicationControllerMapOutput)
}

type ReplicationControllerOutput struct{ *pulumi.OutputState }

func (ReplicationControllerOutput) ElementType() reflect.Type {
	return reflect.TypeOf((**ReplicationController)(nil)).Elem()
}

func (o ReplicationControllerOutput) ToReplicationControllerOutput() ReplicationControllerOutput {
	return o
}

func (o ReplicationControllerOutput) ToReplicationControllerOutputWithContext(ctx context.Context) ReplicationControllerOutput {
	return o
}

// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
func (o ReplicationControllerOutput) ApiVersion() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationController) pulumi.StringOutput { return v.ApiVersion }).(pulumi.StringOutput)
}

// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
func (o ReplicationControllerOutput) Kind() pulumi.StringOutput {
	return o.ApplyT(func(v *ReplicationController) pulumi.StringOutput { return v.Kind }).(pulumi.StringOutput)
}

// If the Labels of a ReplicationController are empty, they are defaulted to be the same as the Pod(s) that the replication controller manages. Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
func (o ReplicationControllerOutput) Metadata() metav1.ObjectMetaOutput {
	return o.ApplyT(func(v *ReplicationController) metav1.ObjectMetaOutput { return v.Metadata }).(metav1.ObjectMetaOutput)
}

// Spec defines the specification of the desired behavior of the replication controller. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
func (o ReplicationControllerOutput) Spec() ReplicationControllerSpecOutput {
	return o.ApplyT(func(v *ReplicationController) ReplicationControllerSpecOutput { return v.Spec }).(ReplicationControllerSpecOutput)
}

// Status is the most recently observed status of the replication controller. This data may be out of date by some window of time. Populated by the system. Read-only. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
func (o ReplicationControllerOutput) Status() ReplicationControllerStatusPtrOutput {
	return o.ApplyT(func(v *ReplicationController) ReplicationControllerStatusPtrOutput { return v.Status }).(ReplicationControllerStatusPtrOutput)
}

type ReplicationControllerArrayOutput struct{ *pulumi.OutputState }

func (ReplicationControllerArrayOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*[]*ReplicationController)(nil)).Elem()
}

func (o ReplicationControllerArrayOutput) ToReplicationControllerArrayOutput() ReplicationControllerArrayOutput {
	return o
}

func (o ReplicationControllerArrayOutput) ToReplicationControllerArrayOutputWithContext(ctx context.Context) ReplicationControllerArrayOutput {
	return o
}

func (o ReplicationControllerArrayOutput) Index(i pulumi.IntInput) ReplicationControllerOutput {
	return pulumi.All(o, i).ApplyT(func(vs []interface{}) *ReplicationController {
		return vs[0].([]*ReplicationController)[vs[1].(int)]
	}).(ReplicationControllerOutput)
}

type ReplicationControllerMapOutput struct{ *pulumi.OutputState }

func (ReplicationControllerMapOutput) ElementType() reflect.Type {
	return reflect.TypeOf((*map[string]*ReplicationController)(nil)).Elem()
}

func (o ReplicationControllerMapOutput) ToReplicationControllerMapOutput() ReplicationControllerMapOutput {
	return o
}

func (o ReplicationControllerMapOutput) ToReplicationControllerMapOutputWithContext(ctx context.Context) ReplicationControllerMapOutput {
	return o
}

func (o ReplicationControllerMapOutput) MapIndex(k pulumi.StringInput) ReplicationControllerOutput {
	return pulumi.All(o, k).ApplyT(func(vs []interface{}) *ReplicationController {
		return vs[0].(map[string]*ReplicationController)[vs[1].(string)]
	}).(ReplicationControllerOutput)
}

func init() {
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationControllerInput)(nil)).Elem(), &ReplicationController{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationControllerArrayInput)(nil)).Elem(), ReplicationControllerArray{})
	pulumi.RegisterInputType(reflect.TypeOf((*ReplicationControllerMapInput)(nil)).Elem(), ReplicationControllerMap{})
	pulumi.RegisterOutputType(ReplicationControllerOutput{})
	pulumi.RegisterOutputType(ReplicationControllerArrayOutput{})
	pulumi.RegisterOutputType(ReplicationControllerMapOutput{})
}
