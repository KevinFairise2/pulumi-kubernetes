# coding=utf-8
# *** WARNING: this file was generated by pulumigen. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Mapping, Optional, Sequence, Union, overload
from ... import _utilities
from . import outputs
from ... import meta as _meta
from ._inputs import *

__all__ = ['ResourceClaimParametersPatchArgs', 'ResourceClaimParametersPatch']

@pulumi.input_type
class ResourceClaimParametersPatchArgs:
    def __init__(__self__, *,
                 api_version: Optional[pulumi.Input[str]] = None,
                 driver_requests: Optional[pulumi.Input[Sequence[pulumi.Input['DriverRequestsPatchArgs']]]] = None,
                 generated_from: Optional[pulumi.Input['ResourceClaimParametersReferencePatchArgs']] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaPatchArgs']] = None,
                 shareable: Optional[pulumi.Input[bool]] = None):
        """
        The set of arguments for constructing a ResourceClaimParametersPatch resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[Sequence[pulumi.Input['DriverRequestsPatchArgs']]] driver_requests: DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.
               
               May be empty, in which case the claim can always be allocated.
        :param pulumi.Input['ResourceClaimParametersReferencePatchArgs'] generated_from: If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the claim parameters when the parameter reference of the claim refers to some unknown type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input['_meta.v1.ObjectMetaPatchArgs'] metadata: Standard object metadata
        :param pulumi.Input[bool] shareable: Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
        """
        if api_version is not None:
            pulumi.set(__self__, "api_version", 'resource.k8s.io/v1alpha2')
        if driver_requests is not None:
            pulumi.set(__self__, "driver_requests", driver_requests)
        if generated_from is not None:
            pulumi.set(__self__, "generated_from", generated_from)
        if kind is not None:
            pulumi.set(__self__, "kind", 'ResourceClaimParameters')
        if metadata is not None:
            pulumi.set(__self__, "metadata", metadata)
        if shareable is not None:
            pulumi.set(__self__, "shareable", shareable)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> Optional[pulumi.Input[str]]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @api_version.setter
    def api_version(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "api_version", value)

    @property
    @pulumi.getter(name="driverRequests")
    def driver_requests(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['DriverRequestsPatchArgs']]]]:
        """
        DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.

        May be empty, in which case the claim can always be allocated.
        """
        return pulumi.get(self, "driver_requests")

    @driver_requests.setter
    def driver_requests(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['DriverRequestsPatchArgs']]]]):
        pulumi.set(self, "driver_requests", value)

    @property
    @pulumi.getter(name="generatedFrom")
    def generated_from(self) -> Optional[pulumi.Input['ResourceClaimParametersReferencePatchArgs']]:
        """
        If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the claim parameters when the parameter reference of the claim refers to some unknown type.
        """
        return pulumi.get(self, "generated_from")

    @generated_from.setter
    def generated_from(self, value: Optional[pulumi.Input['ResourceClaimParametersReferencePatchArgs']]):
        pulumi.set(self, "generated_from", value)

    @property
    @pulumi.getter
    def kind(self) -> Optional[pulumi.Input[str]]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @kind.setter
    def kind(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "kind", value)

    @property
    @pulumi.getter
    def metadata(self) -> Optional[pulumi.Input['_meta.v1.ObjectMetaPatchArgs']]:
        """
        Standard object metadata
        """
        return pulumi.get(self, "metadata")

    @metadata.setter
    def metadata(self, value: Optional[pulumi.Input['_meta.v1.ObjectMetaPatchArgs']]):
        pulumi.set(self, "metadata", value)

    @property
    @pulumi.getter
    def shareable(self) -> Optional[pulumi.Input[bool]]:
        """
        Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
        """
        return pulumi.get(self, "shareable")

    @shareable.setter
    def shareable(self, value: Optional[pulumi.Input[bool]]):
        pulumi.set(self, "shareable", value)


class ResourceClaimParametersPatch(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 driver_requests: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['DriverRequestsPatchArgs']]]]] = None,
                 generated_from: Optional[pulumi.Input[pulumi.InputType['ResourceClaimParametersReferencePatchArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']]] = None,
                 shareable: Optional[pulumi.Input[bool]] = None,
                 __props__=None):
        """
        Patch resources are used to modify existing Kubernetes resources by using
        Server-Side Apply updates. The name of the resource must be specified, but all other properties are optional. More than
        one patch may be applied to the same resource, and a random FieldManager name will be used for each Patch resource.
        Conflicts will result in an error by default, but can be forced using the "pulumi.com/patchForce" annotation. See the
        [Server-Side Apply Docs](https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/) for
        additional information about using Server-Side Apply to manage Kubernetes resources with Pulumi.
        ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['DriverRequestsPatchArgs']]]] driver_requests: DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.
               
               May be empty, in which case the claim can always be allocated.
        :param pulumi.Input[pulumi.InputType['ResourceClaimParametersReferencePatchArgs']] generated_from: If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the claim parameters when the parameter reference of the claim refers to some unknown type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']] metadata: Standard object metadata
        :param pulumi.Input[bool] shareable: Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: Optional[ResourceClaimParametersPatchArgs] = None,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Patch resources are used to modify existing Kubernetes resources by using
        Server-Side Apply updates. The name of the resource must be specified, but all other properties are optional. More than
        one patch may be applied to the same resource, and a random FieldManager name will be used for each Patch resource.
        Conflicts will result in an error by default, but can be forced using the "pulumi.com/patchForce" annotation. See the
        [Server-Side Apply Docs](https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/) for
        additional information about using Server-Side Apply to manage Kubernetes resources with Pulumi.
        ResourceClaimParameters defines resource requests for a ResourceClaim in an in-tree format understood by Kubernetes.

        :param str resource_name: The name of the resource.
        :param ResourceClaimParametersPatchArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(ResourceClaimParametersPatchArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 driver_requests: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['DriverRequestsPatchArgs']]]]] = None,
                 generated_from: Optional[pulumi.Input[pulumi.InputType['ResourceClaimParametersReferencePatchArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']]] = None,
                 shareable: Optional[pulumi.Input[bool]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = ResourceClaimParametersPatchArgs.__new__(ResourceClaimParametersPatchArgs)

            __props__.__dict__["api_version"] = 'resource.k8s.io/v1alpha2'
            __props__.__dict__["driver_requests"] = driver_requests
            __props__.__dict__["generated_from"] = generated_from
            __props__.__dict__["kind"] = 'ResourceClaimParameters'
            __props__.__dict__["metadata"] = metadata
            __props__.__dict__["shareable"] = shareable
        super(ResourceClaimParametersPatch, __self__).__init__(
            'kubernetes:resource.k8s.io/v1alpha2:ResourceClaimParametersPatch',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None) -> 'ResourceClaimParametersPatch':
        """
        Get an existing ResourceClaimParametersPatch resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = ResourceClaimParametersPatchArgs.__new__(ResourceClaimParametersPatchArgs)

        __props__.__dict__["api_version"] = None
        __props__.__dict__["driver_requests"] = None
        __props__.__dict__["generated_from"] = None
        __props__.__dict__["kind"] = None
        __props__.__dict__["metadata"] = None
        __props__.__dict__["shareable"] = None
        return ResourceClaimParametersPatch(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> pulumi.Output[Optional[str]]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter(name="driverRequests")
    def driver_requests(self) -> pulumi.Output[Optional[Sequence['outputs.DriverRequestsPatch']]]:
        """
        DriverRequests describes all resources that are needed for the allocated claim. A single claim may use resources coming from different drivers. For each driver, this array has at most one entry which then may have one or more per-driver requests.

        May be empty, in which case the claim can always be allocated.
        """
        return pulumi.get(self, "driver_requests")

    @property
    @pulumi.getter(name="generatedFrom")
    def generated_from(self) -> pulumi.Output[Optional['outputs.ResourceClaimParametersReferencePatch']]:
        """
        If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the claim parameters when the parameter reference of the claim refers to some unknown type.
        """
        return pulumi.get(self, "generated_from")

    @property
    @pulumi.getter
    def kind(self) -> pulumi.Output[Optional[str]]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @property
    @pulumi.getter
    def metadata(self) -> pulumi.Output[Optional['_meta.v1.outputs.ObjectMetaPatch']]:
        """
        Standard object metadata
        """
        return pulumi.get(self, "metadata")

    @property
    @pulumi.getter
    def shareable(self) -> pulumi.Output[Optional[bool]]:
        """
        Shareable indicates whether the allocated claim is meant to be shareable by multiple consumers at the same time.
        """
        return pulumi.get(self, "shareable")
