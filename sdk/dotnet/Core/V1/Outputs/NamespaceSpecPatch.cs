// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Outputs.Core.V1
{

    /// <summary>
    /// NamespaceSpec describes the attributes on a Namespace.
    /// </summary>
    [OutputType]
    public sealed class NamespaceSpecPatch
    {
        /// <summary>
        /// Finalizers is an opaque list of values that must be empty to permanently remove object from storage. More info: https://kubernetes.io/docs/tasks/administer-cluster/namespaces/
        /// </summary>
        public readonly ImmutableArray<string> Finalizers;

        [OutputConstructor]
        private NamespaceSpecPatch(ImmutableArray<string> finalizers)
        {
            Finalizers = finalizers;
        }
    }
}