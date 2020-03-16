// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Storage.V1
{
    /// <summary>
    /// VolumeAttachment captures the intent to attach or detach the specified volume to/from the
    /// specified node.
    /// 
    /// VolumeAttachment objects are non-namespaced.
    /// </summary>
    public partial class VolumeAttachment : KubernetesResource
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
        /// Standard object metadata. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// Specification of the desired attach/detach volume behavior. Populated by the Kubernetes
        /// system.
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Storage.V1.VolumeAttachmentSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Status of the VolumeAttachment request. Populated by the entity completing the attach or
        /// detach operation, i.e. the external-attacher.
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.Storage.V1.VolumeAttachmentStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a VolumeAttachment resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public VolumeAttachment(string name, Types.Inputs.Storage.V1.VolumeAttachmentArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:storage.k8s.io/v1:VolumeAttachment", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal VolumeAttachment(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:storage.k8s.io/v1:VolumeAttachment", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Storage.V1.VolumeAttachmentArgs? args)
        {
            args ??= new Types.Inputs.Storage.V1.VolumeAttachmentArgs();
            args.ApiVersion = "storage.k8s.io/v1";
            args.Kind = "VolumeAttachment";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:storage.k8s.io/v1alpha1:VolumeAttachment" },
                    new Alias { Type = "kubernetes:storage.k8s.io/v1beta1:VolumeAttachment" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing VolumeAttachment resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static VolumeAttachment Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new VolumeAttachment(name, default(Types.Inputs.Storage.V1.VolumeAttachmentArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
