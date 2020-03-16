// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Networking.V1Beta1
{
    /// <summary>
    /// Ingress is a collection of rules that allow inbound connections to reach the endpoints
    /// defined by a backend. An Ingress can be configured to give services externally-reachable
    /// urls, load balance traffic, terminate SSL, offer name based virtual hosting etc.
    /// 
    /// This resource waits until its status is ready before registering success
    /// for create/update, and populating output properties from the current state of the resource.
    /// The following conditions are used to determine whether the resource creation has
    /// succeeded or failed:
    /// 
    /// 1.  Ingress object exists.
    /// 2.  Endpoint objects exist with matching names for each Ingress path (except when Service
    ///     type is ExternalName).
    /// 3.  Ingress entry exists for '.status.loadBalancer.ingress'.
    /// 
    /// If the Ingress has not reached a Ready state after 10 minutes, it will
    /// time out and mark the resource update as Failed. You can override the default timeout value
    /// by setting the 'customTimeouts' option on the resource.
    /// </summary>
    public partial class Ingress : KubernetesResource
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
        /// Spec is the desired state of the Ingress. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Networking.V1Beta1.IngressSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Status is the current state of the Ingress. More info:
        /// https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#spec-and-status
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.Networking.V1Beta1.IngressStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a Ingress resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public Ingress(string name, Types.Inputs.Networking.V1Beta1.IngressArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:networking.k8s.io/v1beta1:Ingress", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal Ingress(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:networking.k8s.io/v1beta1:Ingress", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Networking.V1Beta1.IngressArgs? args)
        {
            args ??= new Types.Inputs.Networking.V1Beta1.IngressArgs();
            args.ApiVersion = "networking.k8s.io/v1beta1";
            args.Kind = "Ingress";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:extensions/v1beta1:Ingress" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing Ingress resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static Ingress Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new Ingress(name, default(Types.Inputs.Networking.V1Beta1.IngressArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
