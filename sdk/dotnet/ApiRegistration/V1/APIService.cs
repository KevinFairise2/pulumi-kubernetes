// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.ApiRegistration.V1
{
    /// <summary>
    /// APIService represents a server for a particular GroupVersion. Name must be "version.group".
    /// </summary>
    public partial class APIService : KubernetesResource
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

        
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// Spec contains information for locating and communicating with a server
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.ApiRegistration.V1.APIServiceSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Status contains derived information about an API server
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.ApiRegistration.V1.APIServiceStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a APIService resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public APIService(string name, Types.Inputs.ApiRegistration.V1.APIServiceArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:apiregistration/v1:APIService", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal APIService(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:apiregistration/v1:APIService", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.ApiRegistration.V1.APIServiceArgs? args)
        {
            args ??= new Types.Inputs.ApiRegistration.V1.APIServiceArgs();
            args.ApiVersion = "apiregistration.k8s.io/v1";
            args.Kind = "APIService";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:apiregistration.k8s.io/v1beta1:APIService" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing APIService resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static APIService Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new APIService(name, default(Types.Inputs.ApiRegistration.V1.APIServiceArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
