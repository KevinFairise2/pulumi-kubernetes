// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Apps.V1Beta2
{
    /// <summary>
    /// DEPRECATED - apps/v1beta2/ReplicaSet is deprecated by apps/v1/ReplicaSet and not supported
    /// by Kubernetes v1.16+ clusters.
    /// 
    /// ReplicaSet ensures that a specified number of pod replicas are running at any given time.
    /// </summary>
    public partial class ReplicaSet : KubernetesResource
    {
        /// <summary>
        /// APIVersion defines the versioned schema of this representation of an object. Servers
        /// should convert recognized schemas to the latest internal value, and may reject
        /// unrecognized values. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#resources
        /// </summary>
        [Output("apiVersion")]
        public Output<string> ApiVersion { get; private set; } = null!;

        /// <summary>
        /// Kind is a string value representing the REST resource this object represents. Servers
        /// may infer this from the endpoint the client submits requests to. Cannot be updated. In
        /// CamelCase. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        /// </summary>
        [Output("kind")]
        public Output<string> Kind { get; private set; } = null!;

        /// <summary>
        /// If the Labels of a ReplicaSet are empty, they are defaulted to be the same as the Pod(s)
        /// that the ReplicaSet manages. Standard object's metadata. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// Spec defines the specification of the desired behavior of the ReplicaSet. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Apps.V1Beta2.ReplicaSetSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Status is the most recently observed status of the ReplicaSet. This data may be out of
        /// date by some window of time. Populated by the system. Read-only. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.Apps.V1Beta2.ReplicaSetStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a ReplicaSet resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ReplicaSet(string name, Types.Inputs.Apps.V1Beta2.ReplicaSetArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:apps/v1beta2:ReplicaSet", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal ReplicaSet(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:apps/v1beta2:ReplicaSet", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Apps.V1Beta2.ReplicaSetArgs? args)
        {
            args ??= new Types.Inputs.Apps.V1Beta2.ReplicaSetArgs();
            args.ApiVersion = "apps/v1beta2";
            args.Kind = "ReplicaSet";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:apps/v1:ReplicaSet" },
                    new Alias { Type = "kubernetes:extensions/v1beta1:ReplicaSet" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing ReplicaSet resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ReplicaSet Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new ReplicaSet(name, default(Types.Inputs.Apps.V1Beta2.ReplicaSetArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
