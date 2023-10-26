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
from ._inputs import *

__all__ = ['StatusArgs', 'Status']

@pulumi.input_type
class StatusArgs:
    def __init__(__self__, *,
                 api_version: Optional[pulumi.Input[str]] = None,
                 code: Optional[pulumi.Input[int]] = None,
                 details: Optional[pulumi.Input['StatusDetailsArgs']] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 message: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['ListMetaArgs']] = None,
                 reason: Optional[pulumi.Input[str]] = None):
        """
        The set of arguments for constructing a Status resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[int] code: Suggested HTTP return code for this status, 0 if not set.
        :param pulumi.Input['StatusDetailsArgs'] details: Extended data associated with the reason.  Each reason may define its own extended details. This field is optional and the data returned is not guaranteed to conform to any schema except that defined by the reason type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[str] message: A human-readable description of the status of this operation.
        :param pulumi.Input['ListMetaArgs'] metadata: Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[str] reason: A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available. A Reason clarifies an HTTP status code but does not override it.
        """
        StatusArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            api_version=api_version,
            code=code,
            details=details,
            kind=kind,
            message=message,
            metadata=metadata,
            reason=reason,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             api_version: Optional[pulumi.Input[str]] = None,
             code: Optional[pulumi.Input[int]] = None,
             details: Optional[pulumi.Input['StatusDetailsArgs']] = None,
             kind: Optional[pulumi.Input[str]] = None,
             message: Optional[pulumi.Input[str]] = None,
             metadata: Optional[pulumi.Input['ListMetaArgs']] = None,
             reason: Optional[pulumi.Input[str]] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if api_version is None and 'apiVersion' in kwargs:
            api_version = kwargs['apiVersion']

        if api_version is not None:
            _setter("api_version", 'v1')
        if code is not None:
            _setter("code", code)
        if details is not None:
            _setter("details", details)
        if kind is not None:
            _setter("kind", 'Status')
        if message is not None:
            _setter("message", message)
        if metadata is not None:
            _setter("metadata", metadata)
        if reason is not None:
            _setter("reason", reason)

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
    def code(self) -> Optional[pulumi.Input[int]]:
        """
        Suggested HTTP return code for this status, 0 if not set.
        """
        return pulumi.get(self, "code")

    @code.setter
    def code(self, value: Optional[pulumi.Input[int]]):
        pulumi.set(self, "code", value)

    @property
    @pulumi.getter
    def details(self) -> Optional[pulumi.Input['StatusDetailsArgs']]:
        """
        Extended data associated with the reason.  Each reason may define its own extended details. This field is optional and the data returned is not guaranteed to conform to any schema except that defined by the reason type.
        """
        return pulumi.get(self, "details")

    @details.setter
    def details(self, value: Optional[pulumi.Input['StatusDetailsArgs']]):
        pulumi.set(self, "details", value)

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
    def message(self) -> Optional[pulumi.Input[str]]:
        """
        A human-readable description of the status of this operation.
        """
        return pulumi.get(self, "message")

    @message.setter
    def message(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "message", value)

    @property
    @pulumi.getter
    def metadata(self) -> Optional[pulumi.Input['ListMetaArgs']]:
        """
        Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "metadata")

    @metadata.setter
    def metadata(self, value: Optional[pulumi.Input['ListMetaArgs']]):
        pulumi.set(self, "metadata", value)

    @property
    @pulumi.getter
    def reason(self) -> Optional[pulumi.Input[str]]:
        """
        A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available. A Reason clarifies an HTTP status code but does not override it.
        """
        return pulumi.get(self, "reason")

    @reason.setter
    def reason(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "reason", value)


class Status(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 code: Optional[pulumi.Input[int]] = None,
                 details: Optional[pulumi.Input[pulumi.InputType['StatusDetailsArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 message: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['ListMetaArgs']]] = None,
                 reason: Optional[pulumi.Input[str]] = None,
                 __props__=None):
        """
        Status is a return value for calls that don't return other objects.

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[int] code: Suggested HTTP return code for this status, 0 if not set.
        :param pulumi.Input[pulumi.InputType['StatusDetailsArgs']] details: Extended data associated with the reason.  Each reason may define its own extended details. This field is optional and the data returned is not guaranteed to conform to any schema except that defined by the reason type.
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[str] message: A human-readable description of the status of this operation.
        :param pulumi.Input[pulumi.InputType['ListMetaArgs']] metadata: Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[str] reason: A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available. A Reason clarifies an HTTP status code but does not override it.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: Optional[StatusArgs] = None,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        Status is a return value for calls that don't return other objects.

        :param str resource_name: The name of the resource.
        :param StatusArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(StatusArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            kwargs = kwargs or {}
            def _setter(key, value):
                kwargs[key] = value
            StatusArgs._configure(_setter, **kwargs)
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 code: Optional[pulumi.Input[int]] = None,
                 details: Optional[pulumi.Input[pulumi.InputType['StatusDetailsArgs']]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 message: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['ListMetaArgs']]] = None,
                 reason: Optional[pulumi.Input[str]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = StatusArgs.__new__(StatusArgs)

            __props__.__dict__["api_version"] = 'v1'
            __props__.__dict__["code"] = code
            details = _utilities.configure(details, StatusDetailsArgs, True)
            __props__.__dict__["details"] = details
            __props__.__dict__["kind"] = 'Status'
            __props__.__dict__["message"] = message
            metadata = _utilities.configure(metadata, ListMetaArgs, True)
            __props__.__dict__["metadata"] = metadata
            __props__.__dict__["reason"] = reason
            __props__.__dict__["status"] = None
        super(Status, __self__).__init__(
            'kubernetes:meta/v1:Status',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None) -> 'Status':
        """
        Get an existing Status resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = StatusArgs.__new__(StatusArgs)

        __props__.__dict__["api_version"] = None
        __props__.__dict__["code"] = None
        __props__.__dict__["details"] = None
        __props__.__dict__["kind"] = None
        __props__.__dict__["message"] = None
        __props__.__dict__["metadata"] = None
        __props__.__dict__["reason"] = None
        __props__.__dict__["status"] = None
        return Status(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> pulumi.Output[str]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter
    def code(self) -> pulumi.Output[int]:
        """
        Suggested HTTP return code for this status, 0 if not set.
        """
        return pulumi.get(self, "code")

    @property
    @pulumi.getter
    def details(self) -> pulumi.Output['outputs.StatusDetails']:
        """
        Extended data associated with the reason.  Each reason may define its own extended details. This field is optional and the data returned is not guaranteed to conform to any schema except that defined by the reason type.
        """
        return pulumi.get(self, "details")

    @property
    @pulumi.getter
    def kind(self) -> pulumi.Output[str]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @property
    @pulumi.getter
    def message(self) -> pulumi.Output[str]:
        """
        A human-readable description of the status of this operation.
        """
        return pulumi.get(self, "message")

    @property
    @pulumi.getter
    def metadata(self) -> pulumi.Output['outputs.ListMeta']:
        """
        Standard list metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "metadata")

    @property
    @pulumi.getter
    def reason(self) -> pulumi.Output[str]:
        """
        A machine-readable description of why this operation is in the "Failure" status. If this value is empty there is no information available. A Reason clarifies an HTTP status code but does not override it.
        """
        return pulumi.get(self, "reason")

    @property
    @pulumi.getter
    def status(self) -> pulumi.Output[Optional[str]]:
        """
        Status of the operation. One of: "Success" or "Failure". More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        """
        return pulumi.get(self, "status")

