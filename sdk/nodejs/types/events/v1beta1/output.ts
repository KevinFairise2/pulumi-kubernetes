// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../../../types/input";
import * as outputs from "../../../types/output";
import * as enums from "../../../types/enums";
import * as utilities from "../../../utilities";

/**
 * Event is a report of an event somewhere in the cluster. It generally denotes some state change in the system.
 */
export interface Event {
    /**
     * What action was taken/failed regarding to the regarding object.
     */
    action: string;
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion: "events.k8s.io/v1beta1";
    /**
     * Deprecated field assuring backward compatibility with core.v1 Event type
     */
    deprecatedCount: number;
    /**
     * Deprecated field assuring backward compatibility with core.v1 Event type
     */
    deprecatedFirstTimestamp: string;
    /**
     * Deprecated field assuring backward compatibility with core.v1 Event type
     */
    deprecatedLastTimestamp: string;
    /**
     * Deprecated field assuring backward compatibility with core.v1 Event type
     */
    deprecatedSource: outputs.core.v1.EventSource;
    /**
     * Required. Time when this Event was first observed.
     */
    eventTime: string;
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind: "Event";
    metadata: outputs.meta.v1.ObjectMeta;
    /**
     * Optional. A human-readable description of the status of this operation. Maximal length of the note is 1kB, but libraries should be prepared to handle values up to 64kB.
     */
    note: string;
    /**
     * Why the action was taken.
     */
    reason: string;
    /**
     * The object this Event is about. In most cases it's an Object reporting controller implements. E.g. ReplicaSetController implements ReplicaSets and this event is emitted because it acts on some changes in a ReplicaSet object.
     */
    regarding: outputs.core.v1.ObjectReference;
    /**
     * Optional secondary object for more complex actions. E.g. when regarding object triggers a creation or deletion of related object.
     */
    related: outputs.core.v1.ObjectReference;
    /**
     * Name of the controller that emitted this Event, e.g. `kubernetes.io/kubelet`.
     */
    reportingController: string;
    /**
     * ID of the controller instance, e.g. `kubelet-xyzf`.
     */
    reportingInstance: string;
    /**
     * Data about the Event series this event represents or nil if it's a singleton Event.
     */
    series: outputs.events.v1beta1.EventSeries;
    /**
     * Type of this event (Normal, Warning), new types could be added in the future.
     */
    type: string;
}

/**
 * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
 */
export interface EventSeries {
    /**
     * Number of occurrences in this series up to the last heartbeat time
     */
    count: number;
    /**
     * Time when last Event from the series was seen before last heartbeat.
     */
    lastObservedTime: string;
    /**
     * Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
     */
    state: string;
}

/**
 * EventSeries contain information on series of events, i.e. thing that was/is happening continuously for some time.
 */
export interface EventSeriesPatch {
    /**
     * Number of occurrences in this series up to the last heartbeat time
     */
    count: number;
    /**
     * Time when last Event from the series was seen before last heartbeat.
     */
    lastObservedTime: string;
    /**
     * Information whether this series is ongoing or finished. Deprecated. Planned removal for 1.18
     */
    state: string;
}

