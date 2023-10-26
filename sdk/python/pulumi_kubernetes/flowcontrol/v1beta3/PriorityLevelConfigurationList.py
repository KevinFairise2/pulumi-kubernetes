# coding=utf-8
# *** WARNING: this file was generated by pulumigen. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Callable, Mapping, Optional, Sequence, Union, overload
from ... import _utilities
from . import outputs
from ... import meta as _meta
from ._inputs import *

__all__ = ['PriorityLevelConfigurationListArgs', 'PriorityLevelConfigurationList']

@pulumi.input_type
class PriorityLevelConfigurationListArgs:
    def __init__(__self__, *,
                 items: pulumi.Input[Sequence[pulumi.Input['PriorityLevelConfigurationArgs']]],
                 api_version: Optional[pulumi.Input[str]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['_meta.v1.ListMetaArgs']] = None):
        """
        The set of arguments for constructing a PriorityLevelConfigurationList resource.
        :param pulumi.Input[Sequence[pulumi.Input['PriorityLevelConfigurationArgs']]] items: `items` is a list of request-priorities.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input['_meta.v1.ListMetaArgs'] metadata: `metadata` is the standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        PriorityLevelConfigurationListArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            items=items,
            api_version=api_version,
            kind=kind,
            metadata=metadata,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             items: Optional[pulumi.Input[Sequence[pulumi.Input['PriorityLevelConfigurationArgs']]]] = None,
             api_version: Optional[pulumi.Input[str]] = None,
             kind: Optional[pulumi.Input[str]] = None,
             metadata: Optional[pulumi.Input['_meta.v1.ListMetaArgs']] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if items is None:
            raise TypeError("Missing 'items' argument")
        if api_version is None and 'apiVersion' in kwargs:
            api_version = kwargs['apiVersion']

        _setter("items", items)
        if api_version is not None:
            _setter("api_version", 'flowcontrol.apiserver.k8s.io/v1beta3')
        if kind is not None:
            _setter("kind", 'PriorityLevelConfigurationList')
        if metadata is not None:
            _setter("metadata", metadata)

    @property
    @pulumi.getter
    def items(self) -> pulumi.Input[Sequence[pulumi.Input['PriorityLevelConfigurationArgs']]]:
        """
        `items` is a list of request-priorities.
        """
        return pulumi.get(self, "items")

    @items.setter
    def items(self, value: pulumi.Input[Sequence[pulumi.Input['PriorityLevelConfigurationArgs']]]):
        pulumi.set(self, "items", value)

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
    def metadata(self) -> Optional[pulumi.Input['_meta.v1.ListMetaArgs']]:
        """
        `metadata` is the standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        return pulumi.get(self, "metadata")

    @metadata.setter
    def metadata(self, value: Optional[pulumi.Input['_meta.v1.ListMetaArgs']]):
        pulumi.set(self, "metadata", value)


class PriorityLevelConfigurationList(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 items: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['PriorityLevelConfigurationArgs']]]]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ListMetaArgs']]] = None,
                 __props__=None):
        """
        PriorityLevelConfigurationList is a list of PriorityLevelConfiguration objects.

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['PriorityLevelConfigurationArgs']]]] items: `items` is a list of request-priorities.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[pulumi.InputType['_meta.v1.ListMetaArgs']] metadata: `metadata` is the standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: PriorityLevelConfigurationListArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        PriorityLevelConfigurationList is a list of PriorityLevelConfiguration objects.

        :param str resource_name: The name of the resource.
        :param PriorityLevelConfigurationListArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(PriorityLevelConfigurationListArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            kwargs = kwargs or {}
            def _setter(key, value):
                kwargs[key] = value
            PriorityLevelConfigurationListArgs._configure(_setter, **kwargs)
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 items: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['PriorityLevelConfigurationArgs']]]]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ListMetaArgs']]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = PriorityLevelConfigurationListArgs.__new__(PriorityLevelConfigurationListArgs)

            __props__.__dict__["api_version"] = 'flowcontrol.apiserver.k8s.io/v1beta3'
            if items is None and not opts.urn:
                raise TypeError("Missing required property 'items'")
            __props__.__dict__["items"] = items
            __props__.__dict__["kind"] = 'PriorityLevelConfigurationList'
            metadata = _utilities.configure(metadata, _meta.v1.ListMetaArgs, True)
            __props__.__dict__["metadata"] = metadata
        super(PriorityLevelConfigurationList, __self__).__init__(
            'kubernetes:flowcontrol.apiserver.k8s.io/v1beta3:PriorityLevelConfigurationList',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None) -> 'PriorityLevelConfigurationList':
        """
        Get an existing PriorityLevelConfigurationList resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = PriorityLevelConfigurationListArgs.__new__(PriorityLevelConfigurationListArgs)

        __props__.__dict__["api_version"] = None
        __props__.__dict__["items"] = None
        __props__.__dict__["kind"] = None
        __props__.__dict__["metadata"] = None
        return PriorityLevelConfigurationList(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> pulumi.Output[str]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter
    def items(self) -> pulumi.Output[Sequence['outputs.PriorityLevelConfiguration']]:
        """
        `items` is a list of request-priorities.
        """
        return pulumi.get(self, "items")

    @property
    @pulumi.getter
    def kind(self) -> pulumi.Output[str]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @property
    @pulumi.getter
    def metadata(self) -> pulumi.Output['_meta.v1.outputs.ListMeta']:
        """
        `metadata` is the standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        return pulumi.get(self, "metadata")

