// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Outputs.ApiRegistration.V1
{

    [OutputType]
    public sealed class APIServiceStatus
    {
        /// <summary>
        /// Current service state of apiService.
        /// </summary>
        public readonly ImmutableArray<Pulumi.Kubernetes.Types.Outputs.ApiRegistration.V1.APIServiceCondition> Conditions;

        [OutputConstructor]
        private APIServiceStatus(ImmutableArray<Pulumi.Kubernetes.Types.Outputs.ApiRegistration.V1.APIServiceCondition> conditions)
        {
            Conditions = conditions;
        }
    }
}