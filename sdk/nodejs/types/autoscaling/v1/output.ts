// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../../../types/input";
import * as outputs from "../../../types/output";
import * as enums from "../../../types/enums";
import * as utilities from "../../../utilities";

/**
 * CrossVersionObjectReference contains enough information to let you identify the referred resource.
 */
export interface CrossVersionObjectReference {
    /**
     * API version of the referent
     */
    apiVersion: string;
    /**
     * Kind of the referent; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds"
     */
    kind: string;
    /**
     * Name of the referent; More info: http://kubernetes.io/docs/user-guide/identifiers#names
     */
    name: string;
}

/**
 * CrossVersionObjectReference contains enough information to let you identify the referred resource.
 */
export interface CrossVersionObjectReferencePatch {
    /**
     * API version of the referent
     */
    apiVersion: string;
    /**
     * Kind of the referent; More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds"
     */
    kind: string;
    /**
     * Name of the referent; More info: http://kubernetes.io/docs/user-guide/identifiers#names
     */
    name: string;
}

/**
 * configuration of a horizontal pod autoscaler.
 */
export interface HorizontalPodAutoscaler {
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion: "autoscaling/v1";
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind: "HorizontalPodAutoscaler";
    /**
     * Standard object metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
     */
    metadata: outputs.meta.v1.ObjectMeta;
    /**
     * behaviour of autoscaler. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status.
     */
    spec: outputs.autoscaling.v1.HorizontalPodAutoscalerSpec;
    /**
     * current information about the autoscaler.
     */
    status: outputs.autoscaling.v1.HorizontalPodAutoscalerStatus;
}

/**
 * specification of a horizontal pod autoscaler.
 */
export interface HorizontalPodAutoscalerSpec {
    /**
     * upper limit for the number of pods that can be set by the autoscaler; cannot be smaller than MinReplicas.
     */
    maxReplicas: number;
    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    minReplicas: number;
    /**
     * reference to scaled resource; horizontal pod autoscaler will learn the current resource consumption and will set the desired number of pods by using its Scale subresource.
     */
    scaleTargetRef: outputs.autoscaling.v1.CrossVersionObjectReference;
    /**
     * target average CPU utilization (represented as a percentage of requested CPU) over all the pods; if not specified the default autoscaling policy will be used.
     */
    targetCPUUtilizationPercentage: number;
}

/**
 * specification of a horizontal pod autoscaler.
 */
export interface HorizontalPodAutoscalerSpecPatch {
    /**
     * upper limit for the number of pods that can be set by the autoscaler; cannot be smaller than MinReplicas.
     */
    maxReplicas: number;
    /**
     * minReplicas is the lower limit for the number of replicas to which the autoscaler can scale down.  It defaults to 1 pod.  minReplicas is allowed to be 0 if the alpha feature gate HPAScaleToZero is enabled and at least one Object or External metric is configured.  Scaling is active as long as at least one metric value is available.
     */
    minReplicas: number;
    /**
     * reference to scaled resource; horizontal pod autoscaler will learn the current resource consumption and will set the desired number of pods by using its Scale subresource.
     */
    scaleTargetRef: outputs.autoscaling.v1.CrossVersionObjectReferencePatch;
    /**
     * target average CPU utilization (represented as a percentage of requested CPU) over all the pods; if not specified the default autoscaling policy will be used.
     */
    targetCPUUtilizationPercentage: number;
}

/**
 * current status of a horizontal pod autoscaler
 */
export interface HorizontalPodAutoscalerStatus {
    /**
     * current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that an average pod is using now 70% of its requested CPU.
     */
    currentCPUUtilizationPercentage: number;
    /**
     * current number of replicas of pods managed by this autoscaler.
     */
    currentReplicas: number;
    /**
     * desired number of replicas of pods managed by this autoscaler.
     */
    desiredReplicas: number;
    /**
     * last time the HorizontalPodAutoscaler scaled the number of pods; used by the autoscaler to control how often the number of pods is changed.
     */
    lastScaleTime: string;
    /**
     * most recent generation observed by this autoscaler.
     */
    observedGeneration: number;
}

/**
 * current status of a horizontal pod autoscaler
 */
export interface HorizontalPodAutoscalerStatusPatch {
    /**
     * current average CPU utilization over all pods, represented as a percentage of requested CPU, e.g. 70 means that an average pod is using now 70% of its requested CPU.
     */
    currentCPUUtilizationPercentage: number;
    /**
     * current number of replicas of pods managed by this autoscaler.
     */
    currentReplicas: number;
    /**
     * desired number of replicas of pods managed by this autoscaler.
     */
    desiredReplicas: number;
    /**
     * last time the HorizontalPodAutoscaler scaled the number of pods; used by the autoscaler to control how often the number of pods is changed.
     */
    lastScaleTime: string;
    /**
     * most recent generation observed by this autoscaler.
     */
    observedGeneration: number;
}

