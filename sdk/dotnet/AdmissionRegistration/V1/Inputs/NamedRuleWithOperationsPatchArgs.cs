// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Inputs.AdmissionRegistration.V1
{

    /// <summary>
    /// NamedRuleWithOperations is a tuple of Operations and Resources with ResourceNames.
    /// </summary>
    public class NamedRuleWithOperationsPatchArgs : global::Pulumi.ResourceArgs
    {
        [Input("apiGroups")]
        private InputList<string>? _apiGroups;

        /// <summary>
        /// APIGroups is the API groups the resources belong to. '*' is all groups. If '*' is present, the length of the slice must be one. Required.
        /// </summary>
        public InputList<string> ApiGroups
        {
            get => _apiGroups ?? (_apiGroups = new InputList<string>());
            set => _apiGroups = value;
        }

        [Input("apiVersions")]
        private InputList<string>? _apiVersions;

        /// <summary>
        /// APIVersions is the API versions the resources belong to. '*' is all versions. If '*' is present, the length of the slice must be one. Required.
        /// </summary>
        public InputList<string> ApiVersions
        {
            get => _apiVersions ?? (_apiVersions = new InputList<string>());
            set => _apiVersions = value;
        }

        [Input("operations")]
        private InputList<string>? _operations;

        /// <summary>
        /// Operations is the operations the admission hook cares about - CREATE, UPDATE, DELETE, CONNECT or * for all of those operations and any future admission operations that are added. If '*' is present, the length of the slice must be one. Required.
        /// </summary>
        public InputList<string> Operations
        {
            get => _operations ?? (_operations = new InputList<string>());
            set => _operations = value;
        }

        [Input("resourceNames")]
        private InputList<string>? _resourceNames;

        /// <summary>
        /// ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
        /// </summary>
        public InputList<string> ResourceNames
        {
            get => _resourceNames ?? (_resourceNames = new InputList<string>());
            set => _resourceNames = value;
        }

        [Input("resources")]
        private InputList<string>? _resources;

        /// <summary>
        /// Resources is a list of resources this rule applies to.
        /// 
        /// For example: 'pods' means pods. 'pods/log' means the log subresource of pods. '*' means all resources, but not subresources. 'pods/*' means all subresources of pods. '*/scale' means all scale subresources. '*/*' means all resources and their subresources.
        /// 
        /// If wildcard is present, the validation rule will ensure resources do not overlap with each other.
        /// 
        /// Depending on the enclosing object, subresources might not be allowed. Required.
        /// </summary>
        public InputList<string> Resources
        {
            get => _resources ?? (_resources = new InputList<string>());
            set => _resources = value;
        }

        /// <summary>
        /// scope specifies the scope of this rule. Valid values are "Cluster", "Namespaced", and "*" "Cluster" means that only cluster-scoped resources will match this rule. Namespace API objects are cluster-scoped. "Namespaced" means that only namespaced resources will match this rule. "*" means that there are no scope restrictions. Subresources match the scope of their parent resource. Default is "*".
        /// </summary>
        [Input("scope")]
        public Input<string>? Scope { get; set; }

        public NamedRuleWithOperationsPatchArgs()
        {
        }
        public static new NamedRuleWithOperationsPatchArgs Empty => new NamedRuleWithOperationsPatchArgs();
    }
}
