// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Inputs.Apps.V1Beta1
{

    /// <summary>
    /// StatefulSetUpdateStrategy indicates the strategy that the StatefulSet controller will use to perform updates. It includes any additional parameters necessary to perform the update for the indicated strategy.
    /// </summary>
    public class StatefulSetUpdateStrategyPatchArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// RollingUpdate is used to communicate parameters when Type is RollingUpdateStatefulSetStrategyType.
        /// </summary>
        [Input("rollingUpdate")]
        public Input<Pulumi.Kubernetes.Types.Inputs.Apps.V1Beta1.RollingUpdateStatefulSetStrategyPatchArgs>? RollingUpdate { get; set; }

        /// <summary>
        /// Type indicates the type of the StatefulSetUpdateStrategy.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public StatefulSetUpdateStrategyPatchArgs()
        {
        }
        public static new StatefulSetUpdateStrategyPatchArgs Empty => new StatefulSetUpdateStrategyPatchArgs();
    }
}
