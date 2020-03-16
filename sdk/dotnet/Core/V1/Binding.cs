// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Core.V1
{
    /// <summary>
    /// Binding ties one object to another; for example, a pod is bound to a node by a scheduler.
    /// Deprecated in 1.7, please use the bindings subresource of pods instead.
    /// </summary>
    public partial class Binding : KubernetesResource
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
        /// Standard object's metadata. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// The target object that you want to bind to the standard object.
        /// </summary>
        [Output("target")]
        public Output<Types.Outputs.Core.V1.ObjectReference> Target { get; private set; } = null!;


        /// <summary>
        /// Create a Binding resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Binding(string name, Types.Inputs.Core.V1.BindingArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:core/v1:Binding", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal Binding(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:core/v1:Binding", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Core.V1.BindingArgs? args)
        {
            args ??= new Types.Inputs.Core.V1.BindingArgs();
            args.ApiVersion = "v1";
            args.Kind = "Binding";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            return options;
        }

        /// <summary>
        /// Get an existing Binding resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Binding Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new Binding(name, default(Types.Inputs.Core.V1.BindingArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
