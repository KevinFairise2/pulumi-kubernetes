// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Authorization.V1Beta1
{
    /// <summary>
    /// SelfSubjectRulesReview enumerates the set of actions the current user can perform within a
    /// namespace. The returned list of actions may be incomplete depending on the server's
    /// authorization mode, and any errors experienced during the evaluation. SelfSubjectRulesReview
    /// should be used by UIs to show/hide actions, or to quickly let an end user reason about their
    /// permissions. It should NOT Be used by external systems to drive authorization decisions as
    /// this raises confused deputy, cache lifetime/revocation, and correctness concerns.
    /// SubjectAccessReview, and LocalAccessReview are the correct way to defer authorization
    /// decisions to the API server.
    /// </summary>
    public partial class SelfSubjectRulesReview : KubernetesResource
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
        /// Spec holds information about the request being evaluated.
        /// </summary>
        [Output("spec")]
        public Output<Types.Outputs.Authorization.V1Beta1.SelfSubjectRulesReviewSpec> Spec { get; private set; } = null!;

        /// <summary>
        /// Status is filled in by the server and indicates the set of actions a user can perform.
        /// </summary>
        [Output("status")]
        public Output<Types.Outputs.Authorization.V1Beta1.SubjectRulesReviewStatus> Status { get; private set; } = null!;


        /// <summary>
        /// Create a SelfSubjectRulesReview resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public SelfSubjectRulesReview(string name, Types.Inputs.Authorization.V1Beta1.SelfSubjectRulesReviewArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:authorization.k8s.io/v1beta1:SelfSubjectRulesReview", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal SelfSubjectRulesReview(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:authorization.k8s.io/v1beta1:SelfSubjectRulesReview", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Authorization.V1Beta1.SelfSubjectRulesReviewArgs? args)
        {
            args ??= new Types.Inputs.Authorization.V1Beta1.SelfSubjectRulesReviewArgs();
            args.ApiVersion = "authorization.k8s.io/v1beta1";
            args.Kind = "SelfSubjectRulesReview";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:authorization.k8s.io/v1:SelfSubjectRulesReview" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing SelfSubjectRulesReview resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static SelfSubjectRulesReview Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new SelfSubjectRulesReview(name, default(Types.Inputs.Authorization.V1Beta1.SelfSubjectRulesReviewArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
