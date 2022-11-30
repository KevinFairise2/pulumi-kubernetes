// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../../../types/input";
import * as outputs from "../../../types/output";
import * as enums from "../../../types/enums";
import * as utilities from "../../../utilities";

/**
 * AggregationRule describes how to locate ClusterRoles to aggregate into the ClusterRole
 */
export interface AggregationRule {
    /**
     * ClusterRoleSelectors holds a list of selectors which will be used to find ClusterRoles and create the rules. If any of the selectors match, then the ClusterRole's permissions will be added
     */
    clusterRoleSelectors?: pulumi.Input<pulumi.Input<inputs.meta.v1.LabelSelector>[]>;
}

/**
 * AggregationRule describes how to locate ClusterRoles to aggregate into the ClusterRole
 */
export interface AggregationRulePatch {
    /**
     * ClusterRoleSelectors holds a list of selectors which will be used to find ClusterRoles and create the rules. If any of the selectors match, then the ClusterRole's permissions will be added
     */
    clusterRoleSelectors?: pulumi.Input<pulumi.Input<inputs.meta.v1.LabelSelectorPatch>[]>;
}

/**
 * ClusterRole is a cluster level, logical grouping of PolicyRules that can be referenced as a unit by a RoleBinding or ClusterRoleBinding. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 ClusterRole, and will no longer be served in v1.20.
 */
export interface ClusterRole {
    /**
     * AggregationRule is an optional field that describes how to build the Rules for this ClusterRole. If AggregationRule is set, then the Rules are controller managed and direct changes to Rules will be stomped by the controller.
     */
    aggregationRule?: pulumi.Input<inputs.rbac.v1alpha1.AggregationRule>;
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion?: pulumi.Input<"rbac.authorization.k8s.io/v1alpha1">;
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind?: pulumi.Input<"ClusterRole">;
    /**
     * Standard object's metadata.
     */
    metadata?: pulumi.Input<inputs.meta.v1.ObjectMeta>;
    /**
     * Rules holds all the PolicyRules for this ClusterRole
     */
    rules?: pulumi.Input<pulumi.Input<inputs.rbac.v1alpha1.PolicyRule>[]>;
}

/**
 * ClusterRoleBinding references a ClusterRole, but not contain it.  It can reference a ClusterRole in the global namespace, and adds who information via Subject. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 ClusterRoleBinding, and will no longer be served in v1.20.
 */
export interface ClusterRoleBinding {
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion?: pulumi.Input<"rbac.authorization.k8s.io/v1alpha1">;
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind?: pulumi.Input<"ClusterRoleBinding">;
    /**
     * Standard object's metadata.
     */
    metadata?: pulumi.Input<inputs.meta.v1.ObjectMeta>;
    /**
     * RoleRef can only reference a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
     */
    roleRef: pulumi.Input<inputs.rbac.v1alpha1.RoleRef>;
    /**
     * Subjects holds references to the objects the role applies to.
     */
    subjects?: pulumi.Input<pulumi.Input<inputs.rbac.v1alpha1.Subject>[]>;
}

/**
 * PolicyRule holds information that describes a policy rule, but does not contain information about who the rule applies to or which namespace the rule applies to.
 */
export interface PolicyRule {
    /**
     * APIGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any action requested against one of the enumerated resources in any API group will be allowed.
     */
    apiGroups?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * NonResourceURLs is a set of partial urls that a user should have access to.  *s are allowed, but only as the full, final step in the path This name is intentionally different than the internal type so that the DefaultConvert works nicely and because the ordering may be different. Since non-resource URLs are not namespaced, this field is only applicable for ClusterRoles referenced from a ClusterRoleBinding. Rules can either apply to API resources (such as "pods" or "secrets") or non-resource URL paths (such as "/api"),  but not both.
     */
    nonResourceURLs?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
     */
    resourceNames?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Resources is a list of resources this rule applies to.  ResourceAll represents all resources.
     */
    resources?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Verbs is a list of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule.  VerbAll represents all kinds.
     */
    verbs: pulumi.Input<pulumi.Input<string>[]>;
}

/**
 * PolicyRule holds information that describes a policy rule, but does not contain information about who the rule applies to or which namespace the rule applies to.
 */
export interface PolicyRulePatch {
    /**
     * APIGroups is the name of the APIGroup that contains the resources.  If multiple API groups are specified, any action requested against one of the enumerated resources in any API group will be allowed.
     */
    apiGroups?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * NonResourceURLs is a set of partial urls that a user should have access to.  *s are allowed, but only as the full, final step in the path This name is intentionally different than the internal type so that the DefaultConvert works nicely and because the ordering may be different. Since non-resource URLs are not namespaced, this field is only applicable for ClusterRoles referenced from a ClusterRoleBinding. Rules can either apply to API resources (such as "pods" or "secrets") or non-resource URL paths (such as "/api"),  but not both.
     */
    nonResourceURLs?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
     */
    resourceNames?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Resources is a list of resources this rule applies to.  ResourceAll represents all resources.
     */
    resources?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Verbs is a list of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule.  VerbAll represents all kinds.
     */
    verbs?: pulumi.Input<pulumi.Input<string>[]>;
}

/**
 * Role is a namespaced, logical grouping of PolicyRules that can be referenced as a unit by a RoleBinding. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 Role, and will no longer be served in v1.20.
 */
export interface Role {
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion?: pulumi.Input<"rbac.authorization.k8s.io/v1alpha1">;
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind?: pulumi.Input<"Role">;
    /**
     * Standard object's metadata.
     */
    metadata?: pulumi.Input<inputs.meta.v1.ObjectMeta>;
    /**
     * Rules holds all the PolicyRules for this Role
     */
    rules?: pulumi.Input<pulumi.Input<inputs.rbac.v1alpha1.PolicyRule>[]>;
}

/**
 * RoleBinding references a role, but does not contain it.  It can reference a Role in the same namespace or a ClusterRole in the global namespace. It adds who information via Subjects and namespace information by which namespace it exists in.  RoleBindings in a given namespace only have effect in that namespace. Deprecated in v1.17 in favor of rbac.authorization.k8s.io/v1 RoleBinding, and will no longer be served in v1.20.
 */
export interface RoleBinding {
    /**
     * APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
     */
    apiVersion?: pulumi.Input<"rbac.authorization.k8s.io/v1alpha1">;
    /**
     * Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
     */
    kind?: pulumi.Input<"RoleBinding">;
    /**
     * Standard object's metadata.
     */
    metadata?: pulumi.Input<inputs.meta.v1.ObjectMeta>;
    /**
     * RoleRef can reference a Role in the current namespace or a ClusterRole in the global namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
     */
    roleRef: pulumi.Input<inputs.rbac.v1alpha1.RoleRef>;
    /**
     * Subjects holds references to the objects the role applies to.
     */
    subjects?: pulumi.Input<pulumi.Input<inputs.rbac.v1alpha1.Subject>[]>;
}

/**
 * RoleRef contains information that points to the role being used
 */
export interface RoleRef {
    /**
     * APIGroup is the group for the resource being referenced
     */
    apiGroup: pulumi.Input<string>;
    /**
     * Kind is the type of resource being referenced
     */
    kind: pulumi.Input<string>;
    /**
     * Name is the name of resource being referenced
     */
    name: pulumi.Input<string>;
}

/**
 * RoleRef contains information that points to the role being used
 */
export interface RoleRefPatch {
    /**
     * APIGroup is the group for the resource being referenced
     */
    apiGroup?: pulumi.Input<string>;
    /**
     * Kind is the type of resource being referenced
     */
    kind?: pulumi.Input<string>;
    /**
     * Name is the name of resource being referenced
     */
    name?: pulumi.Input<string>;
}

/**
 * Subject contains a reference to the object or user identities a role binding applies to.  This can either hold a direct API object reference, or a value for non-objects such as user and group names.
 */
export interface Subject {
    /**
     * APIVersion holds the API group and version of the referenced subject. Defaults to "v1" for ServiceAccount subjects. Defaults to "rbac.authorization.k8s.io/v1alpha1" for User and Group subjects.
     */
    apiVersion?: pulumi.Input<string>;
    /**
     * Kind of object being referenced. Values defined by this API group are "User", "Group", and "ServiceAccount". If the Authorizer does not recognized the kind value, the Authorizer should report an error.
     */
    kind: pulumi.Input<string>;
    /**
     * Name of the object being referenced.
     */
    name: pulumi.Input<string>;
    /**
     * Namespace of the referenced object.  If the object kind is non-namespace, such as "User" or "Group", and this value is not empty the Authorizer should report an error.
     */
    namespace?: pulumi.Input<string>;
}

/**
 * Subject contains a reference to the object or user identities a role binding applies to.  This can either hold a direct API object reference, or a value for non-objects such as user and group names.
 */
export interface SubjectPatch {
    /**
     * APIVersion holds the API group and version of the referenced subject. Defaults to "v1" for ServiceAccount subjects. Defaults to "rbac.authorization.k8s.io/v1alpha1" for User and Group subjects.
     */
    apiVersion?: pulumi.Input<string>;
    /**
     * Kind of object being referenced. Values defined by this API group are "User", "Group", and "ServiceAccount". If the Authorizer does not recognized the kind value, the Authorizer should report an error.
     */
    kind?: pulumi.Input<string>;
    /**
     * Name of the object being referenced.
     */
    name?: pulumi.Input<string>;
    /**
     * Namespace of the referenced object.  If the object kind is non-namespace, such as "User" or "Group", and this value is not empty the Authorizer should report an error.
     */
    namespace?: pulumi.Input<string>;
}
