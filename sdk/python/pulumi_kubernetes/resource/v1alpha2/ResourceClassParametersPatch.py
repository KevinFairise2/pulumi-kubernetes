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

__all__ = ['ResourceClassParametersPatchArgs', 'ResourceClassParametersPatch']

@pulumi.input_type
class ResourceClassParametersPatchArgs:
    def __init__(__self__, *,
                 api_version: Optional[pulumi.Input[str]] = None,
                 filters: Optional[pulumi.Input[Sequence[pulumi.Input['ResourceFilterPatchArgs']]]] = None,
                 generated_from: Optional[pulumi.Input['ResourceClassParametersReferencePatchArgs']] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaPatchArgs']] = None,
                 vendor_parameters: Optional[pulumi.Input[Sequence[pulumi.Input['VendorParametersPatchArgs']]]] = None):
        """
        The set of arguments for constructing a ResourceClassParametersPatch resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[Sequence[pulumi.Input['ResourceFilterPatchArgs']]] filters: Filters describes additional contraints that must be met when using the class.
        :param pulumi.Input['ResourceClassParametersReferencePatchArgs'] generated_from: If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input['_meta.v1.ObjectMetaPatchArgs'] metadata: Standard object metadata
        :param pulumi.Input[Sequence[pulumi.Input['VendorParametersPatchArgs']]] vendor_parameters: VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
        """
        if api_version is not None:
            pulumi.set(__self__, "api_version", 'resource.k8s.io/v1alpha2')
        if filters is not None:
            pulumi.set(__self__, "filters", filters)
        if generated_from is not None:
            pulumi.set(__self__, "generated_from", generated_from)
        if kind is not None:
            pulumi.set(__self__, "kind", 'ResourceClassParameters')
        if metadata is not None:
            pulumi.set(__self__, "metadata", metadata)
        if vendor_parameters is not None:
            pulumi.set(__self__, "vendor_parameters", vendor_parameters)

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
    @pulumi.getter
    def filters(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['ResourceFilterPatchArgs']]]]:
        """
        Filters describes additional contraints that must be met when using the class.
        """
        return pulumi.get(self, "filters")

    @filters.setter
    def filters(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['ResourceFilterPatchArgs']]]]):
        pulumi.set(self, "filters", value)

    @property
    @pulumi.getter(name="generatedFrom")
    def generated_from(self) -> Optional[pulumi.Input['ResourceClassParametersReferencePatchArgs']]:
        """
        If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
        """
        return pulumi.get(self, "generated_from")

    @generated_from.setter
    def generated_from(self, value: Optional[pulumi.Input['ResourceClassParametersReferencePatchArgs']]):
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
    @pulumi.getter(name="vendorParameters")
    def vendor_parameters(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['VendorParametersPatchArgs']]]]:
        """
        VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
        """
        return pulumi.get(self, "vendor_parameters")

    @vendor_parameters.setter
    def vendor_parameters(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['VendorParametersPatchArgs']]]]):
        pulumi.set(self, "vendor_parameters", value)


class ResourceClassParametersPatch(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 filters: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['ResourceFilterPatchArgs']]]]] = None,
                 generated_from: Optional[pulumi.Input[pulumi.InputType['ResourceClassParametersReferencePatchArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']]] = None,
                 vendor_parameters: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['VendorParametersPatchArgs']]]]] = None,
                 __props__=None):
        """
        Patch resources are used to modify existing Kubernetes resources by using
        Server-Side Apply updates. The name of the resource must be specified, but all other properties are optional. More than
        one patch may be applied to the same resource, and a random FieldManager name will be used for each Patch resource.
        Conflicts will result in an error by default, but can be forced using the "pulumi.com/patchForce" annotation. See the
        [Server-Side Apply Docs](https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/) for
        additional information about using Server-Side Apply to manage Kubernetes resources with Pulumi.
        ResourceClassParameters defines resource requests for a ResourceClass in an in-tree format understood by Kubernetes.

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['ResourceFilterPatchArgs']]]] filters: Filters describes additional contraints that must be met when using the class.
        :param pulumi.Input[pulumi.InputType['ResourceClassParametersReferencePatchArgs']] generated_from: If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']] metadata: Standard object metadata
        :param pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['VendorParametersPatchArgs']]]] vendor_parameters: VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: Optional[ResourceClassParametersPatchArgs] = None,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Patch resources are used to modify existing Kubernetes resources by using
        Server-Side Apply updates. The name of the resource must be specified, but all other properties are optional. More than
        one patch may be applied to the same resource, and a random FieldManager name will be used for each Patch resource.
        Conflicts will result in an error by default, but can be forced using the "pulumi.com/patchForce" annotation. See the
        [Server-Side Apply Docs](https://www.pulumi.com/registry/packages/kubernetes/how-to-guides/managing-resources-with-server-side-apply/) for
        additional information about using Server-Side Apply to manage Kubernetes resources with Pulumi.
        ResourceClassParameters defines resource requests for a ResourceClass in an in-tree format understood by Kubernetes.

        :param str resource_name: The name of the resource.
        :param ResourceClassParametersPatchArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(ResourceClassParametersPatchArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 filters: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['ResourceFilterPatchArgs']]]]] = None,
                 generated_from: Optional[pulumi.Input[pulumi.InputType['ResourceClassParametersReferencePatchArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaPatchArgs']]] = None,
                 vendor_parameters: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['VendorParametersPatchArgs']]]]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = ResourceClassParametersPatchArgs.__new__(ResourceClassParametersPatchArgs)

            __props__.__dict__["api_version"] = 'resource.k8s.io/v1alpha2'
            __props__.__dict__["filters"] = filters
            __props__.__dict__["generated_from"] = generated_from
            __props__.__dict__["kind"] = 'ResourceClassParameters'
            __props__.__dict__["metadata"] = metadata
            __props__.__dict__["vendor_parameters"] = vendor_parameters
        super(ResourceClassParametersPatch, __self__).__init__(
            'kubernetes:resource.k8s.io/v1alpha2:ResourceClassParametersPatch',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None) -> 'ResourceClassParametersPatch':
        """
        Get an existing ResourceClassParametersPatch resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = ResourceClassParametersPatchArgs.__new__(ResourceClassParametersPatchArgs)

        __props__.__dict__["api_version"] = None
        __props__.__dict__["filters"] = None
        __props__.__dict__["generated_from"] = None
        __props__.__dict__["kind"] = None
        __props__.__dict__["metadata"] = None
        __props__.__dict__["vendor_parameters"] = None
        return ResourceClassParametersPatch(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> pulumi.Output[Optional[str]]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter
    def filters(self) -> pulumi.Output[Optional[Sequence['outputs.ResourceFilterPatch']]]:
        """
        Filters describes additional contraints that must be met when using the class.
        """
        return pulumi.get(self, "filters")

    @property
    @pulumi.getter(name="generatedFrom")
    def generated_from(self) -> pulumi.Output[Optional['outputs.ResourceClassParametersReferencePatch']]:
        """
        If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
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
    @pulumi.getter(name="vendorParameters")
    def vendor_parameters(self) -> pulumi.Output[Optional[Sequence['outputs.VendorParametersPatch']]]:
        """
        VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
        """
        return pulumi.get(self, "vendor_parameters")

