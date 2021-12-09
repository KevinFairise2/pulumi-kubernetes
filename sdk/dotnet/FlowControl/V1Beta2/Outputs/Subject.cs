// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2
{

    /// <summary>
    /// Subject matches the originator of a request, as identified by the request authentication system. There are three ways of matching an originator; by user, group, or service account.
    /// </summary>
    [OutputType]
    public sealed class Subject
    {
        /// <summary>
        /// `group` matches based on user group name.
        /// </summary>
        public readonly Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.GroupSubject Group;
        /// <summary>
        /// `kind` indicates which one of the other fields is non-empty. Required
        /// </summary>
        public readonly string Kind;
        /// <summary>
        /// `serviceAccount` matches ServiceAccounts.
        /// </summary>
        public readonly Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.ServiceAccountSubject ServiceAccount;
        /// <summary>
        /// `user` matches based on username.
        /// </summary>
        public readonly Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.UserSubject User;

        [OutputConstructor]
        private Subject(
            Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.GroupSubject group,

            string kind,

            Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.ServiceAccountSubject serviceAccount,

            Pulumi.Kubernetes.Types.Outputs.FlowControl.V1Beta2.UserSubject user)
        {
            Group = group;
            Kind = kind;
            ServiceAccount = serviceAccount;
            User = user;
        }
    }
}