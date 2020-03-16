// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.FlowControl.V1Alpha1
{
    /// <summary>
    /// PriorityLevelConfigurationList is a list of PriorityLevelConfiguration objects.
    /// </summary>
    public partial class PriorityLevelConfigurationList : KubernetesResource
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
        /// `items` is a list of request-priorities.
        /// </summary>
        [Output("items")]
        public Output<ImmutableArray<Types.Outputs.FlowControl.V1Alpha1.PriorityLevelConfiguration>> Items { get; private set; } = null!;

        /// <summary>
        /// Kind is a string value representing the REST resource this object represents. Servers
        /// may infer this from the endpoint the client submits requests to. Cannot be updated. In
        /// CamelCase. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        /// </summary>
        [Output("kind")]
        public Output<string> Kind { get; private set; } = null!;

        /// <summary>
        /// `metadata` is the standard object's metadata. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ListMeta> Metadata { get; private set; } = null!;


        /// <summary>
        /// Create a PriorityLevelConfigurationList resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public PriorityLevelConfigurationList(string name, Types.Inputs.FlowControl.V1Alpha1.PriorityLevelConfigurationListArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:flowcontrol.apiserver.k8s.io/v1alpha1:PriorityLevelConfigurationList", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal PriorityLevelConfigurationList(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:flowcontrol.apiserver.k8s.io/v1alpha1:PriorityLevelConfigurationList", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.FlowControl.V1Alpha1.PriorityLevelConfigurationListArgs? args)
        {
            args ??= new Types.Inputs.FlowControl.V1Alpha1.PriorityLevelConfigurationListArgs();
            args.ApiVersion = "flowcontrol.apiserver.k8s.io/v1alpha1";
            args.Kind = "PriorityLevelConfigurationList";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            return options;
        }

        /// <summary>
        /// Get an existing PriorityLevelConfigurationList resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static PriorityLevelConfigurationList Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new PriorityLevelConfigurationList(name, default(Types.Inputs.FlowControl.V1Alpha1.PriorityLevelConfigurationListArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
