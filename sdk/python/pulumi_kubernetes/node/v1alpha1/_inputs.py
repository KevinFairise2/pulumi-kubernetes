# coding=utf-8
# *** WARNING: this file was generated by pulumigen. ***
# *** Do not edit by hand unless you're certain you know what you are doing! ***

import copy
import warnings
import pulumi
import pulumi.runtime
from typing import Any, Callable, Mapping, Optional, Sequence, Union, overload
from ... import _utilities
from ... import core as _core
from ... import meta as _meta

__all__ = [
    'OverheadPatchArgs',
    'OverheadArgs',
    'RuntimeClassSpecPatchArgs',
    'RuntimeClassSpecArgs',
    'RuntimeClassArgs',
    'SchedulingPatchArgs',
    'SchedulingArgs',
]

@pulumi.input_type
class OverheadPatchArgs:
    def __init__(__self__, *,
                 pod_fixed: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None):
        """
        Overhead structure represents the resource overhead associated with running a pod.
        :param pulumi.Input[Mapping[str, pulumi.Input[str]]] pod_fixed: PodFixed represents the fixed resource overhead associated with running a pod.
        """
        OverheadPatchArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            pod_fixed=pod_fixed,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             pod_fixed: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if pod_fixed is None and 'podFixed' in kwargs:
            pod_fixed = kwargs['podFixed']

        if pod_fixed is not None:
            _setter("pod_fixed", pod_fixed)

    @property
    @pulumi.getter(name="podFixed")
    def pod_fixed(self) -> Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]:
        """
        PodFixed represents the fixed resource overhead associated with running a pod.
        """
        return pulumi.get(self, "pod_fixed")

    @pod_fixed.setter
    def pod_fixed(self, value: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]):
        pulumi.set(self, "pod_fixed", value)


@pulumi.input_type
class OverheadArgs:
    def __init__(__self__, *,
                 pod_fixed: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None):
        """
        Overhead structure represents the resource overhead associated with running a pod.
        :param pulumi.Input[Mapping[str, pulumi.Input[str]]] pod_fixed: PodFixed represents the fixed resource overhead associated with running a pod.
        """
        OverheadArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            pod_fixed=pod_fixed,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             pod_fixed: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if pod_fixed is None and 'podFixed' in kwargs:
            pod_fixed = kwargs['podFixed']

        if pod_fixed is not None:
            _setter("pod_fixed", pod_fixed)

    @property
    @pulumi.getter(name="podFixed")
    def pod_fixed(self) -> Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]:
        """
        PodFixed represents the fixed resource overhead associated with running a pod.
        """
        return pulumi.get(self, "pod_fixed")

    @pod_fixed.setter
    def pod_fixed(self, value: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]):
        pulumi.set(self, "pod_fixed", value)


@pulumi.input_type
class RuntimeClassSpecPatchArgs:
    def __init__(__self__, *,
                 overhead: Optional[pulumi.Input['OverheadPatchArgs']] = None,
                 runtime_handler: Optional[pulumi.Input[str]] = None,
                 scheduling: Optional[pulumi.Input['SchedulingPatchArgs']] = None):
        """
        RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
        :param pulumi.Input['OverheadPatchArgs'] overhead: Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. For more details, see https://git.k8s.io/enhancements/keps/sig-node/20190226-pod-overhead.md This field is alpha-level as of Kubernetes v1.15, and is only honored by servers that enable the PodOverhead feature.
        :param pulumi.Input[str] runtime_handler: RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node & CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must conform to the DNS Label (RFC 1123) requirements and is immutable.
        :param pulumi.Input['SchedulingPatchArgs'] scheduling: Scheduling holds the scheduling constraints to ensure that pods running with this RuntimeClass are scheduled to nodes that support it. If scheduling is nil, this RuntimeClass is assumed to be supported by all nodes.
        """
        RuntimeClassSpecPatchArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            overhead=overhead,
            runtime_handler=runtime_handler,
            scheduling=scheduling,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             overhead: Optional[pulumi.Input['OverheadPatchArgs']] = None,
             runtime_handler: Optional[pulumi.Input[str]] = None,
             scheduling: Optional[pulumi.Input['SchedulingPatchArgs']] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if runtime_handler is None and 'runtimeHandler' in kwargs:
            runtime_handler = kwargs['runtimeHandler']

        if overhead is not None:
            _setter("overhead", overhead)
        if runtime_handler is not None:
            _setter("runtime_handler", runtime_handler)
        if scheduling is not None:
            _setter("scheduling", scheduling)

    @property
    @pulumi.getter
    def overhead(self) -> Optional[pulumi.Input['OverheadPatchArgs']]:
        """
        Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. For more details, see https://git.k8s.io/enhancements/keps/sig-node/20190226-pod-overhead.md This field is alpha-level as of Kubernetes v1.15, and is only honored by servers that enable the PodOverhead feature.
        """
        return pulumi.get(self, "overhead")

    @overhead.setter
    def overhead(self, value: Optional[pulumi.Input['OverheadPatchArgs']]):
        pulumi.set(self, "overhead", value)

    @property
    @pulumi.getter(name="runtimeHandler")
    def runtime_handler(self) -> Optional[pulumi.Input[str]]:
        """
        RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node & CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must conform to the DNS Label (RFC 1123) requirements and is immutable.
        """
        return pulumi.get(self, "runtime_handler")

    @runtime_handler.setter
    def runtime_handler(self, value: Optional[pulumi.Input[str]]):
        pulumi.set(self, "runtime_handler", value)

    @property
    @pulumi.getter
    def scheduling(self) -> Optional[pulumi.Input['SchedulingPatchArgs']]:
        """
        Scheduling holds the scheduling constraints to ensure that pods running with this RuntimeClass are scheduled to nodes that support it. If scheduling is nil, this RuntimeClass is assumed to be supported by all nodes.
        """
        return pulumi.get(self, "scheduling")

    @scheduling.setter
    def scheduling(self, value: Optional[pulumi.Input['SchedulingPatchArgs']]):
        pulumi.set(self, "scheduling", value)


@pulumi.input_type
class RuntimeClassSpecArgs:
    def __init__(__self__, *,
                 runtime_handler: pulumi.Input[str],
                 overhead: Optional[pulumi.Input['OverheadArgs']] = None,
                 scheduling: Optional[pulumi.Input['SchedulingArgs']] = None):
        """
        RuntimeClassSpec is a specification of a RuntimeClass. It contains parameters that are required to describe the RuntimeClass to the Container Runtime Interface (CRI) implementation, as well as any other components that need to understand how the pod will be run. The RuntimeClassSpec is immutable.
        :param pulumi.Input[str] runtime_handler: RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node & CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must conform to the DNS Label (RFC 1123) requirements and is immutable.
        :param pulumi.Input['OverheadArgs'] overhead: Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. For more details, see https://git.k8s.io/enhancements/keps/sig-node/20190226-pod-overhead.md This field is alpha-level as of Kubernetes v1.15, and is only honored by servers that enable the PodOverhead feature.
        :param pulumi.Input['SchedulingArgs'] scheduling: Scheduling holds the scheduling constraints to ensure that pods running with this RuntimeClass are scheduled to nodes that support it. If scheduling is nil, this RuntimeClass is assumed to be supported by all nodes.
        """
        RuntimeClassSpecArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            runtime_handler=runtime_handler,
            overhead=overhead,
            scheduling=scheduling,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             runtime_handler: Optional[pulumi.Input[str]] = None,
             overhead: Optional[pulumi.Input['OverheadArgs']] = None,
             scheduling: Optional[pulumi.Input['SchedulingArgs']] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if runtime_handler is None and 'runtimeHandler' in kwargs:
            runtime_handler = kwargs['runtimeHandler']
        if runtime_handler is None:
            raise TypeError("Missing 'runtime_handler' argument")

        _setter("runtime_handler", runtime_handler)
        if overhead is not None:
            _setter("overhead", overhead)
        if scheduling is not None:
            _setter("scheduling", scheduling)

    @property
    @pulumi.getter(name="runtimeHandler")
    def runtime_handler(self) -> pulumi.Input[str]:
        """
        RuntimeHandler specifies the underlying runtime and configuration that the CRI implementation will use to handle pods of this class. The possible values are specific to the node & CRI configuration.  It is assumed that all handlers are available on every node, and handlers of the same name are equivalent on every node. For example, a handler called "runc" might specify that the runc OCI runtime (using native Linux containers) will be used to run the containers in a pod. The RuntimeHandler must conform to the DNS Label (RFC 1123) requirements and is immutable.
        """
        return pulumi.get(self, "runtime_handler")

    @runtime_handler.setter
    def runtime_handler(self, value: pulumi.Input[str]):
        pulumi.set(self, "runtime_handler", value)

    @property
    @pulumi.getter
    def overhead(self) -> Optional[pulumi.Input['OverheadArgs']]:
        """
        Overhead represents the resource overhead associated with running a pod for a given RuntimeClass. For more details, see https://git.k8s.io/enhancements/keps/sig-node/20190226-pod-overhead.md This field is alpha-level as of Kubernetes v1.15, and is only honored by servers that enable the PodOverhead feature.
        """
        return pulumi.get(self, "overhead")

    @overhead.setter
    def overhead(self, value: Optional[pulumi.Input['OverheadArgs']]):
        pulumi.set(self, "overhead", value)

    @property
    @pulumi.getter
    def scheduling(self) -> Optional[pulumi.Input['SchedulingArgs']]:
        """
        Scheduling holds the scheduling constraints to ensure that pods running with this RuntimeClass are scheduled to nodes that support it. If scheduling is nil, this RuntimeClass is assumed to be supported by all nodes.
        """
        return pulumi.get(self, "scheduling")

    @scheduling.setter
    def scheduling(self, value: Optional[pulumi.Input['SchedulingArgs']]):
        pulumi.set(self, "scheduling", value)


@pulumi.input_type
class RuntimeClassArgs:
    def __init__(__self__, *,
                 spec: pulumi.Input['RuntimeClassSpecArgs'],
                 api_version: Optional[pulumi.Input[str]] = None,
                 kind: Optional[pulumi.Input[str]] = None,
                 metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']] = None):
        """
        RuntimeClass defines a class of container runtime supported in the cluster. The RuntimeClass is used to determine which container runtime is used to run all containers in a pod. RuntimeClasses are (currently) manually defined by a user or cluster provisioner, and referenced in the PodSpec. The Kubelet is responsible for resolving the RuntimeClassName reference before running the pod.  For more details, see https://git.k8s.io/enhancements/keps/sig-node/runtime-class.md
        :param pulumi.Input['RuntimeClassSpecArgs'] spec: Specification of the RuntimeClass More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        :param pulumi.Input[str] api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param pulumi.Input[str] kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param pulumi.Input['_meta.v1.ObjectMetaArgs'] metadata: More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        RuntimeClassArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            spec=spec,
            api_version=api_version,
            kind=kind,
            metadata=metadata,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             spec: Optional[pulumi.Input['RuntimeClassSpecArgs']] = None,
             api_version: Optional[pulumi.Input[str]] = None,
             kind: Optional[pulumi.Input[str]] = None,
             metadata: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if spec is None:
            raise TypeError("Missing 'spec' argument")
        if api_version is None and 'apiVersion' in kwargs:
            api_version = kwargs['apiVersion']

        _setter("spec", spec)
        if api_version is not None:
            _setter("api_version", 'node.k8s.io/v1alpha1')
        if kind is not None:
            _setter("kind", 'RuntimeClass')
        if metadata is not None:
            _setter("metadata", metadata)

    @property
    @pulumi.getter
    def spec(self) -> pulumi.Input['RuntimeClassSpecArgs']:
        """
        Specification of the RuntimeClass More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        """
        return pulumi.get(self, "spec")

    @spec.setter
    def spec(self, value: pulumi.Input['RuntimeClassSpecArgs']):
        pulumi.set(self, "spec", value)

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
        More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        """
        return pulumi.get(self, "metadata")

    @metadata.setter
    def metadata(self, value: Optional[pulumi.Input['_meta.v1.ObjectMetaArgs']]):
        pulumi.set(self, "metadata", value)


@pulumi.input_type
class SchedulingPatchArgs:
    def __init__(__self__, *,
                 node_selector: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
                 tolerations: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationPatchArgs']]]] = None):
        """
        Scheduling specifies the scheduling constraints for nodes supporting a RuntimeClass.
        :param pulumi.Input[Mapping[str, pulumi.Input[str]]] node_selector: nodeSelector lists labels that must be present on nodes that support this RuntimeClass. Pods using this RuntimeClass can only be scheduled to a node matched by this selector. The RuntimeClass nodeSelector is merged with a pod's existing nodeSelector. Any conflicts will cause the pod to be rejected in admission.
        :param pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationPatchArgs']]] tolerations: tolerations are appended (excluding duplicates) to pods running with this RuntimeClass during admission, effectively unioning the set of nodes tolerated by the pod and the RuntimeClass.
        """
        SchedulingPatchArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            node_selector=node_selector,
            tolerations=tolerations,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             node_selector: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
             tolerations: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationPatchArgs']]]] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if node_selector is None and 'nodeSelector' in kwargs:
            node_selector = kwargs['nodeSelector']

        if node_selector is not None:
            _setter("node_selector", node_selector)
        if tolerations is not None:
            _setter("tolerations", tolerations)

    @property
    @pulumi.getter(name="nodeSelector")
    def node_selector(self) -> Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]:
        """
        nodeSelector lists labels that must be present on nodes that support this RuntimeClass. Pods using this RuntimeClass can only be scheduled to a node matched by this selector. The RuntimeClass nodeSelector is merged with a pod's existing nodeSelector. Any conflicts will cause the pod to be rejected in admission.
        """
        return pulumi.get(self, "node_selector")

    @node_selector.setter
    def node_selector(self, value: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]):
        pulumi.set(self, "node_selector", value)

    @property
    @pulumi.getter
    def tolerations(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationPatchArgs']]]]:
        """
        tolerations are appended (excluding duplicates) to pods running with this RuntimeClass during admission, effectively unioning the set of nodes tolerated by the pod and the RuntimeClass.
        """
        return pulumi.get(self, "tolerations")

    @tolerations.setter
    def tolerations(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationPatchArgs']]]]):
        pulumi.set(self, "tolerations", value)


@pulumi.input_type
class SchedulingArgs:
    def __init__(__self__, *,
                 node_selector: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
                 tolerations: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationArgs']]]] = None):
        """
        Scheduling specifies the scheduling constraints for nodes supporting a RuntimeClass.
        :param pulumi.Input[Mapping[str, pulumi.Input[str]]] node_selector: nodeSelector lists labels that must be present on nodes that support this RuntimeClass. Pods using this RuntimeClass can only be scheduled to a node matched by this selector. The RuntimeClass nodeSelector is merged with a pod's existing nodeSelector. Any conflicts will cause the pod to be rejected in admission.
        :param pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationArgs']]] tolerations: tolerations are appended (excluding duplicates) to pods running with this RuntimeClass during admission, effectively unioning the set of nodes tolerated by the pod and the RuntimeClass.
        """
        SchedulingArgs._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            node_selector=node_selector,
            tolerations=tolerations,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             node_selector: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]] = None,
             tolerations: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationArgs']]]] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if node_selector is None and 'nodeSelector' in kwargs:
            node_selector = kwargs['nodeSelector']

        if node_selector is not None:
            _setter("node_selector", node_selector)
        if tolerations is not None:
            _setter("tolerations", tolerations)

    @property
    @pulumi.getter(name="nodeSelector")
    def node_selector(self) -> Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]:
        """
        nodeSelector lists labels that must be present on nodes that support this RuntimeClass. Pods using this RuntimeClass can only be scheduled to a node matched by this selector. The RuntimeClass nodeSelector is merged with a pod's existing nodeSelector. Any conflicts will cause the pod to be rejected in admission.
        """
        return pulumi.get(self, "node_selector")

    @node_selector.setter
    def node_selector(self, value: Optional[pulumi.Input[Mapping[str, pulumi.Input[str]]]]):
        pulumi.set(self, "node_selector", value)

    @property
    @pulumi.getter
    def tolerations(self) -> Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationArgs']]]]:
        """
        tolerations are appended (excluding duplicates) to pods running with this RuntimeClass during admission, effectively unioning the set of nodes tolerated by the pod and the RuntimeClass.
        """
        return pulumi.get(self, "tolerations")

    @tolerations.setter
    def tolerations(self, value: Optional[pulumi.Input[Sequence[pulumi.Input['_core.v1.TolerationArgs']]]]):
        pulumi.set(self, "tolerations", value)


