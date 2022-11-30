// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../../../types/input";
import * as outputs from "../../../types/output";
import * as enums from "../../../types/enums";
import * as utilities from "../../../utilities";

/**
 * CronJob represents the configuration of a single cron job.
 */
export interface CronJob {
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion: "batch/v2alpha1";
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind: "CronJob";
    /**
     * Standard object's metadata. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
     */
    metadata: outputs.meta.v1.ObjectMeta;
    /**
     * Specification of the desired behavior of a cron job, including the schedule. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    spec: outputs.batch.v2alpha1.CronJobSpec;
    /**
     * Current status of a cron job. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    status: outputs.batch.v2alpha1.CronJobStatus;
}

/**
 * CronJobSpec describes how the job execution will look like and when it will actually run.
 */
export interface CronJobSpec {
    /**
     * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; - "Replace": cancels currently running job and replaces it with a new one
     */
    concurrencyPolicy: string;
    /**
     * The number of failed finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified.
     */
    failedJobsHistoryLimit: number;
    /**
     * Specifies the job that will be created when executing a CronJob.
     */
    jobTemplate: outputs.batch.v2alpha1.JobTemplateSpec;
    /**
     * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
     */
    schedule: string;
    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs executions will be counted as failed ones.
     */
    startingDeadlineSeconds: number;
    /**
     * The number of successful finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified.
     */
    successfulJobsHistoryLimit: number;
    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.  Defaults to false.
     */
    suspend: boolean;
}

/**
 * CronJobSpec describes how the job execution will look like and when it will actually run.
 */
export interface CronJobSpecPatch {
    /**
     * Specifies how to treat concurrent executions of a Job. Valid values are: - "Allow" (default): allows CronJobs to run concurrently; - "Forbid": forbids concurrent runs, skipping next run if previous run hasn't finished yet; - "Replace": cancels currently running job and replaces it with a new one
     */
    concurrencyPolicy: string;
    /**
     * The number of failed finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified.
     */
    failedJobsHistoryLimit: number;
    /**
     * Specifies the job that will be created when executing a CronJob.
     */
    jobTemplate: outputs.batch.v2alpha1.JobTemplateSpecPatch;
    /**
     * The schedule in Cron format, see https://en.wikipedia.org/wiki/Cron.
     */
    schedule: string;
    /**
     * Optional deadline in seconds for starting the job if it misses scheduled time for any reason.  Missed jobs executions will be counted as failed ones.
     */
    startingDeadlineSeconds: number;
    /**
     * The number of successful finished jobs to retain. This is a pointer to distinguish between explicit zero and not specified.
     */
    successfulJobsHistoryLimit: number;
    /**
     * This flag tells the controller to suspend subsequent executions, it does not apply to already started executions.  Defaults to false.
     */
    suspend: boolean;
}

/**
 * CronJobStatus represents the current state of a cron job.
 */
export interface CronJobStatus {
    /**
     * A list of pointers to currently running jobs.
     */
    active: outputs.core.v1.ObjectReference[];
    /**
     * Information when was the last time the job was successfully scheduled.
     */
    lastScheduleTime: string;
}

/**
 * CronJobStatus represents the current state of a cron job.
 */
export interface CronJobStatusPatch {
    /**
     * A list of pointers to currently running jobs.
     */
    active: outputs.core.v1.ObjectReferencePatch[];
    /**
     * Information when was the last time the job was successfully scheduled.
     */
    lastScheduleTime: string;
}

/**
 * JobTemplateSpec describes the data a Job should have when created from a template
 */
export interface JobTemplateSpec {
    /**
     * Standard object's metadata of the jobs created from this template. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
     */
    metadata: outputs.meta.v1.ObjectMeta;
    /**
     * Specification of the desired behavior of the job. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    spec: outputs.batch.v1.JobSpec;
}

/**
 * JobTemplateSpec describes the data a Job should have when created from a template
 */
export interface JobTemplateSpecPatch {
    /**
     * Standard object's metadata of the jobs created from this template. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
     */
    metadata: outputs.meta.v1.ObjectMetaPatch;
    /**
     * Specification of the desired behavior of the job. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
     */
    spec: outputs.batch.v1.JobSpecPatch;
}

