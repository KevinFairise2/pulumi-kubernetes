// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2
{

    /// <summary>
    /// ResourceClassParameters defines resource requests for a ResourceClass in an in-tree format understood by Kubernetes.
    /// </summary>
    [OutputType]
    public sealed class ResourceClassParameters
    {
        /// <summary>
        /// APIVersion defines the versioned schema of this representation of an object. Servers should convert recognized schemas to the latest internal value, and may reject unrecognized values. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        /// </summary>
        public readonly string ApiVersion;
        /// <summary>
        /// Filters describes additional contraints that must be met when using the class.
        /// </summary>
        public readonly ImmutableArray<Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.ResourceFilter> Filters;
        /// <summary>
        /// If this object was created from some other resource, then this links back to that resource. This field is used to find the in-tree representation of the class parameters when the parameter reference of the class refers to some unknown type.
        /// </summary>
        public readonly Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.ResourceClassParametersReference GeneratedFrom;
        /// <summary>
        /// Kind is a string value representing the REST resource this object represents. Servers may infer this from the endpoint the client submits requests to. Cannot be updated. In CamelCase. More info: https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        /// </summary>
        public readonly string Kind;
        /// <summary>
        /// Standard object metadata
        /// </summary>
        public readonly Pulumi.Kubernetes.Types.Outputs.Meta.V1.ObjectMeta Metadata;
        /// <summary>
        /// VendorParameters are arbitrary setup parameters for all claims using this class. They are ignored while allocating the claim. There must not be more than one entry per driver.
        /// </summary>
        public readonly ImmutableArray<Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.VendorParameters> VendorParameters;

        [OutputConstructor]
        private ResourceClassParameters(
            string apiVersion,

            ImmutableArray<Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.ResourceFilter> filters,

            Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.ResourceClassParametersReference generatedFrom,

            string kind,

            Pulumi.Kubernetes.Types.Outputs.Meta.V1.ObjectMeta metadata,

            ImmutableArray<Pulumi.Kubernetes.Types.Outputs.Resource.V1Alpha2.VendorParameters> vendorParameters)
        {
            ApiVersion = apiVersion;
            Filters = filters;
            GeneratedFrom = generatedFrom;
            Kind = kind;
            Metadata = metadata;
            VendorParameters = vendorParameters;
        }
    }
}
