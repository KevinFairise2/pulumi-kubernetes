// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Apps.V1Beta2
{
    /// <summary>
    /// DEPRECATED - apps/v1beta2/ControllerRevision is deprecated by apps/v1/ControllerRevision and
    /// not supported by Kubernetes v1.16+ clusters.
    /// 
    /// ControllerRevision implements an immutable snapshot of state data. Clients are responsible
    /// for serializing and deserializing the objects that contain their internal state. Once a
    /// ControllerRevision has been successfully created, it can not be updated. The API Server will
    /// fail validation of all requests that attempt to mutate the Data field. ControllerRevisions
    /// may, however, be deleted. Note that, due to its use by both the DaemonSet and StatefulSet
    /// controllers for update and rollback, this object is beta. However, it may be subject to name
    /// and representation changes in future releases, and clients should not depend on its
    /// stability. It is primarily for internal use by controllers.
    /// </summary>
    public partial class ControllerRevision : KubernetesResource
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
        /// Data is the serialized representation of the state.
        /// </summary>
        [Output("data")]
        public Output<System.Text.Json.JsonElement> Data { get; private set; } = null!;

        /// <summary>
        /// Kind is a string value representing the REST resource this object represents. Servers
        /// may infer this from the endpoint the client submits requests to. Cannot be updated. In
        /// CamelCase. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#types-kinds
        /// </summary>
        [Output("kind")]
        public Output<string> Kind { get; private set; } = null!;

        /// <summary>
        /// Standard object's metadata. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// Revision indicates the revision of the state represented by Data.
        /// </summary>
        [Output("revision")]
        public Output<int> Revision { get; private set; } = null!;


        /// <summary>
        /// Create a ControllerRevision resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public ControllerRevision(string name, Types.Inputs.Apps.V1Beta2.ControllerRevisionArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:apps/v1beta2:ControllerRevision", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal ControllerRevision(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:apps/v1beta2:ControllerRevision", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Apps.V1Beta2.ControllerRevisionArgs? args)
        {
            args ??= new Types.Inputs.Apps.V1Beta2.ControllerRevisionArgs();
            args.ApiVersion = "apps/v1beta2";
            args.Kind = "ControllerRevision";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:apps/v1:ControllerRevision" },
                    new Alias { Type = "kubernetes:apps/v1beta1:ControllerRevision" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing ControllerRevision resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static ControllerRevision Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new ControllerRevision(name, default(Types.Inputs.Apps.V1Beta2.ControllerRevisionArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
