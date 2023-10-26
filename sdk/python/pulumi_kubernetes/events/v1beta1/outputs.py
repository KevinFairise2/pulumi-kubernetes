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
from ... import core as _core
from ... import meta as _meta

__all__ = [
    'Event',
    'EventSeries',
    'EventSeriesPatch',
]

@pulumi.output_type
class Event(dict):
    """
    Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system.
    """
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "eventTime":
            suggest = "event_time"
        elif key == "apiVersion":
            suggest = "api_version"
        elif key == "deprecatedCount":
            suggest = "deprecated_count"
        elif key == "deprecatedFirstTimestamp":
            suggest = "deprecated_first_timestamp"
        elif key == "deprecatedLastTimestamp":
            suggest = "deprecated_last_timestamp"
        elif key == "deprecatedSource":
            suggest = "deprecated_source"
        elif key == "reportingController":
            suggest = "reporting_controller"
        elif key == "reportingInstance":
            suggest = "reporting_instance"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in Event. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        Event.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        Event.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 event_time: str,
                 action: Optional[str] = None,
                 api_version: Optional[str] = None,
                 deprecated_count: Optional[int] = None,
                 deprecated_first_timestamp: Optional[str] = None,
                 deprecated_last_timestamp: Optional[str] = None,
                 deprecated_source: Optional['_core.v1.outputs.EventSource'] = None,
                 kind: Optional[str] = None,
                 metadata: Optional['_meta.v1.outputs.ObjectMeta'] = None,
                 note: Optional[str] = None,
                 reason: Optional[str] = None,
                 regarding: Optional['_core.v1.outputs.ObjectReference'] = None,
                 related: Optional['_core.v1.outputs.ObjectReference'] = None,
                 reporting_controller: Optional[str] = None,
                 reporting_instance: Optional[str] = None,
                 series: Optional['outputs.EventSeries'] = None,
                 type: Optional[str] = None):
        """
        Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system.
        :param str event_time: Required. Time when this Event was first observed.
        :param str action: What action was taken/failed regarding to the regarding object.
        :param str api_version: APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        :param int deprecated_count: Deprecated field assuring backward compatibility with core.v1 Event type
        :param str deprecated_first_timestamp: Deprecated field assuring backward compatibility with core.v1 Event type
        :param str deprecated_last_timestamp: Deprecated field assuring backward compatibility with core.v1 Event type
        :param '_core.v1.EventSourceArgs' deprecated_source: Deprecated field assuring backward compatibility with core.v1 Event type
        :param str kind: Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        :param str note: Optional. A human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
        :param str reason: Why the action was taken.
        :param '_core.v1.ObjectReferenceArgs' regarding: The object this Event is about. In most cases it's an Object reporting controller implements. E.g. ReplicaSetController implements ReplicaSets and this event is emitted because it acts on some changes in a ReplicaSet object.
        :param '_core.v1.ObjectReferenceArgs' related: Optional secondary object for more complex actions. E.g. when regarding object triggers a creation or deletion of related object.
        :param str reporting_controller: Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
        :param str reporting_instance: ID of the controller instance, e.g. `kubelet-xyzf`.
        :param 'EventSeriesArgs' series: Data about the Event series this event represents or nil if it's a singleton Event.
        :param str type: Type of this event (Normal, Warning), new types could be added in the future.
        """
        Event._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            event_time=event_time,
            action=action,
            api_version=api_version,
            deprecated_count=deprecated_count,
            deprecated_first_timestamp=deprecated_first_timestamp,
            deprecated_last_timestamp=deprecated_last_timestamp,
            deprecated_source=deprecated_source,
            kind=kind,
            metadata=metadata,
            note=note,
            reason=reason,
            regarding=regarding,
            related=related,
            reporting_controller=reporting_controller,
            reporting_instance=reporting_instance,
            series=series,
            type=type,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             event_time: Optional[str] = None,
             action: Optional[str] = None,
             api_version: Optional[str] = None,
             deprecated_count: Optional[int] = None,
             deprecated_first_timestamp: Optional[str] = None,
             deprecated_last_timestamp: Optional[str] = None,
             deprecated_source: Optional['_core.v1.outputs.EventSource'] = None,
             kind: Optional[str] = None,
             metadata: Optional['_meta.v1.outputs.ObjectMeta'] = None,
             note: Optional[str] = None,
             reason: Optional[str] = None,
             regarding: Optional['_core.v1.outputs.ObjectReference'] = None,
             related: Optional['_core.v1.outputs.ObjectReference'] = None,
             reporting_controller: Optional[str] = None,
             reporting_instance: Optional[str] = None,
             series: Optional['outputs.EventSeries'] = None,
             type: Optional[str] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if event_time is None and 'eventTime' in kwargs:
            event_time = kwargs['eventTime']
        if event_time is None:
            raise TypeError("Missing 'event_time' argument")
        if api_version is None and 'apiVersion' in kwargs:
            api_version = kwargs['apiVersion']
        if deprecated_count is None and 'deprecatedCount' in kwargs:
            deprecated_count = kwargs['deprecatedCount']
        if deprecated_first_timestamp is None and 'deprecatedFirstTimestamp' in kwargs:
            deprecated_first_timestamp = kwargs['deprecatedFirstTimestamp']
        if deprecated_last_timestamp is None and 'deprecatedLastTimestamp' in kwargs:
            deprecated_last_timestamp = kwargs['deprecatedLastTimestamp']
        if deprecated_source is None and 'deprecatedSource' in kwargs:
            deprecated_source = kwargs['deprecatedSource']
        if reporting_controller is None and 'reportingController' in kwargs:
            reporting_controller = kwargs['reportingController']
        if reporting_instance is None and 'reportingInstance' in kwargs:
            reporting_instance = kwargs['reportingInstance']

        _setter("event_time", event_time)
        if action is not None:
            _setter("action", action)
        if api_version is not None:
            _setter("api_version", 'events.k8s.io/v1beta1')
        if deprecated_count is not None:
            _setter("deprecated_count", deprecated_count)
        if deprecated_first_timestamp is not None:
            _setter("deprecated_first_timestamp", deprecated_first_timestamp)
        if deprecated_last_timestamp is not None:
            _setter("deprecated_last_timestamp", deprecated_last_timestamp)
        if deprecated_source is not None:
            _setter("deprecated_source", deprecated_source)
        if kind is not None:
            _setter("kind", 'Event')
        if metadata is not None:
            _setter("metadata", metadata)
        if note is not None:
            _setter("note", note)
        if reason is not None:
            _setter("reason", reason)
        if regarding is not None:
            _setter("regarding", regarding)
        if related is not None:
            _setter("related", related)
        if reporting_controller is not None:
            _setter("reporting_controller", reporting_controller)
        if reporting_instance is not None:
            _setter("reporting_instance", reporting_instance)
        if series is not None:
            _setter("series", series)
        if type is not None:
            _setter("type", type)

    @property
    @pulumi.getter(name="eventTime")
    def event_time(self) -> str:
        """
        Required. Time when this Event was first observed.
        """
        return pulumi.get(self, "event_time")

    @property
    @pulumi.getter
    def action(self) -> Optional[str]:
        """
        What action was taken/failed regarding to the regarding object.
        """
        return pulumi.get(self, "action")

    @property
    @pulumi.getter(name="apiVersion")
    def api_version(self) -> Optional[str]:
        """
        APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        """
        return pulumi.get(self, "api_version")

    @property
    @pulumi.getter(name="deprecatedCount")
    def deprecated_count(self) -> Optional[int]:
        """
        Deprecated field assuring backward compatibility with core.v1 Event type
        """
        return pulumi.get(self, "deprecated_count")

    @property
    @pulumi.getter(name="deprecatedFirstTimestamp")
    def deprecated_first_timestamp(self) -> Optional[str]:
        """
        Deprecated field assuring backward compatibility with core.v1 Event type
        """
        return pulumi.get(self, "deprecated_first_timestamp")

    @property
    @pulumi.getter(name="deprecatedLastTimestamp")
    def deprecated_last_timestamp(self) -> Optional[str]:
        """
        Deprecated field assuring backward compatibility with core.v1 Event type
        """
        return pulumi.get(self, "deprecated_last_timestamp")

    @property
    @pulumi.getter(name="deprecatedSource")
    def deprecated_source(self) -> Optional['_core.v1.outputs.EventSource']:
        """
        Deprecated field assuring backward compatibility with core.v1 Event type
        """
        return pulumi.get(self, "deprecated_source")

    @property
    @pulumi.getter
    def kind(self) -> Optional[str]:
        """
        Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        """
        return pulumi.get(self, "kind")

    @property
    @pulumi.getter
    def metadata(self) -> Optional['_meta.v1.outputs.ObjectMeta']:
        return pulumi.get(self, "metadata")

    @property
    @pulumi.getter
    def note(self) -> Optional[str]:
        """
        Optional. A human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
        """
        return pulumi.get(self, "note")

    @property
    @pulumi.getter
    def reason(self) -> Optional[str]:
        """
        Why the action was taken.
        """
        return pulumi.get(self, "reason")

    @property
    @pulumi.getter
    def regarding(self) -> Optional['_core.v1.outputs.ObjectReference']:
        """
        The object this Event is about. In most cases it's an Object reporting controller implements. E.g. ReplicaSetController implements ReplicaSets and this event is emitted because it acts on some changes in a ReplicaSet object.
        """
        return pulumi.get(self, "regarding")

    @property
    @pulumi.getter
    def related(self) -> Optional['_core.v1.outputs.ObjectReference']:
        """
        Optional secondary object for more complex actions. E.g. when regarding object triggers a creation or deletion of related object.
        """
        return pulumi.get(self, "related")

    @property
    @pulumi.getter(name="reportingController")
    def reporting_controller(self) -> Optional[str]:
        """
        Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
        """
        return pulumi.get(self, "reporting_controller")

    @property
    @pulumi.getter(name="reportingInstance")
    def reporting_instance(self) -> Optional[str]:
        """
        ID of the controller instance, e.g. `kubelet-xyzf`.
        """
        return pulumi.get(self, "reporting_instance")

    @property
    @pulumi.getter
    def series(self) -> Optional['outputs.EventSeries']:
        """
        Data about the Event series this event represents or nil if it's a singleton Event.
        """
        return pulumi.get(self, "series")

    @property
    @pulumi.getter
    def type(self) -> Optional[str]:
        """
        Type of this event (Normal, Warning), new types could be added in the future.
        """
        return pulumi.get(self, "type")


@pulumi.output_type
class EventSeries(dict):
    """
    EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
    """
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "lastObservedTime":
            suggest = "last_observed_time"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in EventSeries. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        EventSeries.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        EventSeries.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 count: int,
                 last_observed_time: str,
                 state: str):
        """
        EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
        :param int count: Number of occurrences in this series up to the last heartbeat time
        :param str last_observed_time: Time when last Event from the series was seen before last heartbeat.
        :param str state: Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
        """
        EventSeries._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            count=count,
            last_observed_time=last_observed_time,
            state=state,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             count: Optional[int] = None,
             last_observed_time: Optional[str] = None,
             state: Optional[str] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if count is None:
            raise TypeError("Missing 'count' argument")
        if last_observed_time is None and 'lastObservedTime' in kwargs:
            last_observed_time = kwargs['lastObservedTime']
        if last_observed_time is None:
            raise TypeError("Missing 'last_observed_time' argument")
        if state is None:
            raise TypeError("Missing 'state' argument")

        _setter("count", count)
        _setter("last_observed_time", last_observed_time)
        _setter("state", state)

    @property
    @pulumi.getter
    def count(self) -> int:
        """
        Number of occurrences in this series up to the last heartbeat time
        """
        return pulumi.get(self, "count")

    @property
    @pulumi.getter(name="lastObservedTime")
    def last_observed_time(self) -> str:
        """
        Time when last Event from the series was seen before last heartbeat.
        """
        return pulumi.get(self, "last_observed_time")

    @property
    @pulumi.getter
    def state(self) -> str:
        """
        Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
        """
        return pulumi.get(self, "state")


@pulumi.output_type
class EventSeriesPatch(dict):
    """
    EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
    """
    @staticmethod
    def __key_warning(key: str):
        suggest = None
        if key == "lastObservedTime":
            suggest = "last_observed_time"

        if suggest:
            pulumi.log.warn(f"Key '{key}' not found in EventSeriesPatch. Access the value via the '{suggest}' property getter instead.")

    def __getitem__(self, key: str) -> Any:
        EventSeriesPatch.__key_warning(key)
        return super().__getitem__(key)

    def get(self, key: str, default = None) -> Any:
        EventSeriesPatch.__key_warning(key)
        return super().get(key, default)

    def __init__(__self__, *,
                 count: Optional[int] = None,
                 last_observed_time: Optional[str] = None,
                 state: Optional[str] = None):
        """
        EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
        :param int count: Number of occurrences in this series up to the last heartbeat time
        :param str last_observed_time: Time when last Event from the series was seen before last heartbeat.
        :param str state: Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
        """
        EventSeriesPatch._configure(
            lambda key, value: pulumi.set(__self__, key, value),
            count=count,
            last_observed_time=last_observed_time,
            state=state,
        )
    @staticmethod
    def _configure(
             _setter: Callable[[Any, Any], None],
             count: Optional[int] = None,
             last_observed_time: Optional[str] = None,
             state: Optional[str] = None,
             opts: Optional[pulumi.ResourceOptions] = None,
             **kwargs):
        if last_observed_time is None and 'lastObservedTime' in kwargs:
            last_observed_time = kwargs['lastObservedTime']

        if count is not None:
            _setter("count", count)
        if last_observed_time is not None:
            _setter("last_observed_time", last_observed_time)
        if state is not None:
            _setter("state", state)

    @property
    @pulumi.getter
    def count(self) -> Optional[int]:
        """
        Number of occurrences in this series up to the last heartbeat time
        """
        return pulumi.get(self, "count")

    @property
    @pulumi.getter(name="lastObservedTime")
    def last_observed_time(self) -> Optional[str]:
        """
        Time when last Event from the series was seen before last heartbeat.
        """
        return pulumi.get(self, "last_observed_time")

    @property
    @pulumi.getter
    def state(self) -> Optional[str]:
        """
        Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
        """
        return pulumi.get(self, "state")


