// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Certificates.V1Beta1
{
    /// <summary>
    /// Describes a certificate signing request
    /// </summary>
    public partial class CertificateSigningRequest : KubernetesResource
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
        /// The certificate request itself and any additional information.
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Certificates.V1Beta1.CertificateSigningRequestSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Derived information about the request.
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.Certificates.V1Beta1.CertificateSigningRequestStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a CertificateSigningRequest resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public CertificateSigningRequest(string name, Types.Inputs.Certificates.V1Beta1.CertificateSigningRequestArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:certificates.k8s.io/v1beta1:CertificateSigningRequest", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal CertificateSigningRequest(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:certificates.k8s.io/v1beta1:CertificateSigningRequest", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Certificates.V1Beta1.CertificateSigningRequestArgs? args)
        {
            args ??= new Types.Inputs.Certificates.V1Beta1.CertificateSigningRequestArgs();
            args.ApiVersion = "certificates.k8s.io/v1beta1";
            args.Kind = "CertificateSigningRequest";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            return options;
        }

        /// <summary>
        /// Get an existing CertificateSigningRequest resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static CertificateSigningRequest Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new CertificateSigningRequest(name, default(Types.Inputs.Certificates.V1Beta1.CertificateSigningRequestArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
