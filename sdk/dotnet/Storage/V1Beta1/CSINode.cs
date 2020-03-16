// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Storage.V1Beta1
{
    /// <summary>
    /// DEPRECATED - storage/v1beta1/CSINode is deprecated by storage/v1/CSINode.
    /// 
    /// CSINode holds information about all CSI drivers installed on a node. CSI drivers do not need
    /// to create the CSINode object directly. As long as they use the node-driver-registrar sidecar
    /// container, the kubelet will automatically populate the CSINode object for the CSI driver as
    /// part of kubelet plugin registration. CSINode has the same name as a node. If the object is
    /// missing, it means either there are no CSI Drivers available on the node, or the Kubelet
    /// version is low enough that it doesn't create this object. CSINode has an OwnerReference that
    /// points to the corresponding node object.
    /// </summary>
    public partial class CSINode : KubernetesResource
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
        /// metadata.name must be the Kubernetes node name.
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// spec is the specification of CSINode
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Storage.V1Beta1.CSINodeSpec> Spec { get; private set; } = null!;


        /// <summary>
        /// Create a CSINode resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CSINode(string name, Types.Inputs.Storage.V1Beta1.CSINodeArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:storage.k8s.io/v1beta1:CSINode", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal CSINode(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:storage.k8s.io/v1beta1:CSINode", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Storage.V1Beta1.CSINodeArgs? args)
        {
            args ??= new Types.Inputs.Storage.V1Beta1.CSINodeArgs();
            args.ApiVersion = "storage.k8s.io/v1beta1";
            args.Kind = "CSINode";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:storage.k8s.io/v1:CSINode" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing CSINode resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CSINode Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new CSINode(name, default(Types.Inputs.Storage.V1Beta1.CSINodeArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
