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

__all__ = ['RoleBindingInitArgs', 'RoleBinding']

@pulumi.input_type
class RoleBindingInitArgs:
    def __init__(__self__, *,
                 role_ref: pulumi.Input['RoleRefArgs'],
                 api_version: Optional[pulumi.Input[str]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']] = None,
                 subjects: Optional[pulumi.Input[Sequence[pulumi.Input['SubjectArgs']]]] = None):
        """
        The set of arguments for constructing a RoleBinding resource.
        :param pulumi.Input['RoleRefArgs'] role_ref: RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input['_meta.v1.ObjectMetaArgs'] metadata: Standard object's metadata.
        :param pulumi.Input[Sequence[pulumi.Input['SubjectArgs']]] subjects: Subjects holds references to the objects the role applies to.
        """
        RoleBindingInitArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            role_ref=role_ref,
            api_version=api_version,
            kind=kind,
            metadata=metadata,
            subjects=subjects,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             role_ref: pulumi.Input['RoleRefArgs'],
             api_version: Optional[pulumi.Input[str]] = None,
             kind: Optional[pulumi.Input[str]] = None,
             metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']] = None,
             subjects: Optional[pulumi.Input[Sequence[pulumi.Input['SubjectArgs']]]] = None,
             opts: Optional[pulumi.ResourceOptions]=None,
             **kwargs):
        if 'roleRef' in kwargs:
            role_ref = kwargs['roleRef']
        if 'apiVersion' in kwargs:
            api_version = kwargs['apiVersion']

        _setter("role_ref", role_ref)
        if api_version is not None:
            _setter("api_version", 'rbac.authorization.k8s.io/v1alpha1')
        if kind is not None:
            _setter("kind", 'RoleBinding')
        if metadata is not None:
            _setter("metadata", metadata)
        if subjects is not None:
            _setter("subjects", subjects)

    @property
    @pulumi.getter(name="roleRef")
    def role_ref(self) -> pulumi.Input['RoleRefArgs']:
        """
        RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
        """
        return pulumi.get(self, "role_ref")

    @role_ref.setter
    def role_ref(self, value: pulumi.Input['RoleRefArgs']):
        pulumi.set(self, "role_ref", value)

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
    def metadata(self) -> Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']]:
        """
        Standard object's metadata.
        """
        return pulumi.get(self, "metadata")

    @metadata.setter
    def metadata(self, value: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']]):
        pulumi.set(self, "metadata", value)

    @property
    @pulumi.getter
    def subjects(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['SubjectArgs']]]]:
        """
        Subjects holds references to the objects the role applies to.
        """
        return pulumi.get(self, "subjects")

    @subjects.setter
    def subjects(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['SubjectArgs']]]]):
        pulumi.set(self, "subjects", value)


class RoleBinding(pulumi.CustomResource):
    @overload
    def __init__(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaArgs']]] = None,
                 role_ref: Optional[pulumi.Input[pulumi.InputType['RoleRefArgs']]] = None,
                 subjects: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['SubjectArgs']]]]] = None,
                 __props__=None):
        """
        RoleBinding references a role, but does not contain it.  It can reference a Role in the same namespace or a ClusterRole in the global namespace. It adds who information via Subjects and namespace information by which namespace it exists in.  RoleBindings in a given namespace only have effect in that namespace. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 RoleBinding, and will no longer be served in v1.20.

        :param str resource_name: The name of the resource.
        :param pulumi.ResourceOptions opts: Options for the resource.
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaArgs']] metadata: Standard object's metadata.
        :param pulumi.Input[pulumi.InputType['RoleRefArgs']] role_ref: RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
        :param pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['SubjectArgs']]]] subjects: Subjects holds references to the objects the role applies to.
        """
        ...
    @overload
    def __init__(__self__,
                 resource_name: str,
                 args: RoleBindingInitArgs,
                 opts: Optional[pulumi.ResourceOptions] = None):
        """
        RoleBinding references a role, but does not contain it.  It can reference a Role in the same namespace or a ClusterRole in the global namespace. It adds who information via Subjects and namespace information by which namespace it exists in.  RoleBindings in a given namespace only have effect in that namespace. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 RoleBinding, and will no longer be served in v1.20.

        :param str resource_name: The name of the resource.
        :param RoleBindingInitArgs args: The arguments to use to populate this resource's properties.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        ...
    def __init__(__self__, resource_name: str, *args, **kwargs):
        resource_args, opts = _utilities.get_resource_args_opts(RoleBindingInitArgs, pulumi.ResourceOptions, *args, **kwargs)
        if resource_args is not None:
            __self__._internal_init(resource_name, opts, **resource_args.__dict__)
        else:
            kwargs = kwargs or {}
            def _setter(key, value):
                kwargs[key] = value
            RoleBindingInitArgs._configure(_setter, **kwargs)
            __self__._internal_init(resource_name, *args, **kwargs)

    def _internal_init(__self__,
                 resource_name: str,
                 opts: Optional[pulumi.ResourceOptions] = None,
                 api_version: Optional[pulumi.Input[str]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input[pulumi.InputType['_meta.v1.ObjectMetaArgs']]] = None,
                 role_ref: Optional[pulumi.Input[pulumi.InputType['RoleRefArgs']]] = None,
                 subjects: Optional[pulumi.Input[Sequence[pulumi.Input[pulumi.InputType['SubjectArgs']]]]] = None,
                 __props__=None):
        opts = pulumi.ResourceOptions.merge(_utilities.get_resource_opts_defaults(), opts)
        if not isinstance(opts, pulumi.ResourceOptions):
            raise TypeError('Expected resource options to be a ResourceOptions instance')
        if opts.id is None:
            if __props__ is not None:
                raise TypeError('__props__ is only valid when passed in combination with a valid opts.id to get an existing resource')
            __props__ = RoleBindingInitArgs.__new__(RoleBindingInitArgs)

            __props__.__dict__["api_version"] = 'rbac.authorization.k8s.io/v1alpha1'
            __props__.__dict__["kind"] = 'RoleBinding'
            if metadata is not None and not isinstance(metadata, _meta.v1.ObjectMetaArgs):
                metadata = metadata or {}
                def _setter(key, value):
                    metadata[key] = value
                _meta.v1.ObjectMetaArgs._configure(_setter, **metadata)
            __props__.__dict__["metadata"] = metadata
            if role_ref is not None and not isinstance(role_ref, RoleRefArgs):
                role_ref = role_ref or {}
                def _setter(key, value):
                    role_ref[key] = value
                RoleRefArgs._configure(_setter, **role_ref)
            if role_ref is None and not opts.urn:
                raise TypeError("Missing required property 'role_ref'")
            __props__.__dict__["role_ref"] = role_ref
            __props__.__dict__["subjects"] = subjects
        alias_opts = pulumi.ResourceOptions(aliases=[pulumi.Alias(type_="kubernetes:rbac.authorization.k8s.io/v1:RoleBinding"), pulumi.Alias(type_="kubernetes:rbac.authorization.k8s.io/v1beta1:RoleBinding")])
        opts = pulumi.ResourceOptions.merge(opts, alias_opts)
        super(RoleBinding, __self__).__init__(
            'kubernetes:rbac.authorization.k8s.io/v1alpha1:RoleBinding',
            resource_name,
            __props__,
            opts)

    @staticmethod
    def get(resource_name: str,
            id: pulumi.Input[str],
            opts: Optional[pulumi.ResourceOptions] = None) -> 'RoleBinding':
        """
        Get an existing RoleBinding resource's state with the given name, id, and optional extra
        properties used to qualify the lookup.

        :param str resource_name: The unique name of the resulting resource.
        :param pulumi.Input[str] id: The unique provider ID of the resource to lookup.
        :param pulumi.ResourceOptions opts: Options for the resource.
        """
        opts = pulumi.ResourceOptions.merge(opts, pulumi.ResourceOptions(id=id))

        __props__ = RoleBindingInitArgs.__new__(RoleBindingInitArgs)

        __props__.__dict__["api_version"] = None
        __props__.__dict__["kind"] = None
        __props__.__dict__["metadata"] = None
        __props__.__dict__["role_ref"] = None
        __props__.__dict__["subjects"] = None
        return RoleBinding(resource_name, opts=opts, __props__=__props__)

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> pulumi.Output[str]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter
    def kind(self) -> pulumi.Output[str]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @property
    @pulumi.getter
    def metadata(self) -> pulumi.Output['_meta.v1.outputs.ObjectMeta']:
        """
        Standard object's metadata.
        """
        return pulumi.get(self, "metadata")

    @property
    @pulumi.getter(name="roleRef")
    def role_ref(self) -> pulumi.Output['outputs.RoleRef']:
        """
        RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
        """
        return pulumi.get(self, "role_ref")

    @property
    @pulumi.getter
    def subjects(self) -> pulumi.Output[Sequence['outputs.Subject']]:
        """
        Subjects holds references to the objects the role applies to.
        """
        return pulumi.get(self, "subjects")

