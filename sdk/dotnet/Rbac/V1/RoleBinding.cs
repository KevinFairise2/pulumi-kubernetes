// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Rbac.V1
{
    /// <summary>
    /// RoleBinding references a role, but does not contain it.  It can reference a Role in the same
    /// namespace or a ClusterRole in the global namespace. It adds who information via Subjects and
    /// namespace information by which namespace it exists in.  RoleBindings in a given namespace
    /// only have effect in that namespace.
    /// </summary>
    public partial class RoleBinding : KubernetesResource
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
        /// Standard object's metadata.
        /// </summary>
        [Output("metadata")]
        public Output<Types.Outputs.Meta.V1.ObjectMeta> Metadata { get; private set; } = null!;

        /// <summary>
        /// RoleRef can reference a Role in the current namespace or a ClusterRole in the global
        /// namespace. If the RoleRef cannot be resolved, the Authorizer must return an error.
        /// </summary>
        [Output("roleRef")]
        public Output<Types.Outputs.Rbac.V1.RoleRef> RoleRef { get; private set; } = null!;

        /// <summary>
        /// Subjects holds references to the objects the role applies to.
        /// </summary>
        [Output("subjects")]
        public Output<ImmutableArray<Types.Outputs.Rbac.V1.Subject>> Subjects { get; private set; } = null!;


        /// <summary>
        /// Create a RoleBinding resource with the given unique name, arguments, and options.
        /// </summary>
        /// <param name="name">The unique name of the resource</param>
        /// <param name="args">The arguments used to populate this resource's properties</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public RoleBinding(string name, Types.Inputs.Rbac.V1.RoleBindingArgs? args = null, CustomResourceOptions? options = null)
            : base("kubernetes:rbac.authorization.k8s.io/v1:RoleBinding", name, SetAPIKindAndVersion(args), MakeOptions(options))
        {
        }

        internal RoleBinding(string name, ImmutableDictionary<string, object?> dictionary, CustomResourceOptions? options = null)
            : base("kubernetes:rbac.authorization.k8s.io/v1:RoleBinding", name, dictionary, options)
        {
        }

        private static ResourceArgs SetAPIKindAndVersion(Types.Inputs.Rbac.V1.RoleBindingArgs? args)
        {
            args ??= new Types.Inputs.Rbac.V1.RoleBindingArgs();
            args.ApiVersion = "rbac.authorization.k8s.io/v1";
            args.Kind = "RoleBinding";
            return args;
        }

        private static CustomResourceOptions? MakeOptions(CustomResourceOptions? options)
        {
            var extraOptions = new CustomResourceOptions
            {
                Aliases =
                {
                    new Alias { Type = "kubernetes:rbac.authorization.k8s.io/v1alpha1:RoleBinding" },
                    new Alias { Type = "kubernetes:rbac.authorization.k8s.io/v1beta1:RoleBinding" },
                }
            };

            return CustomResourceOptions.Merge(options, extraOptions);
        }

        /// <summary>
        /// Get an existing RoleBinding resource's state with the given name and ID.
        /// </summary>
        /// <param name="name">The unique name of the resulting resource.</param>
        /// <param name="id">The unique provider ID of the resource to lookup.</param>
        /// <param name="options">A bag of options that control this resource's behavior</param>
        public static RoleBinding Get(string name, Input<string> id, CustomResourceOptions? options = null)
        {
            return new RoleBinding(name, default(Types.Inputs.Rbac.V1.RoleBindingArgs),
                CustomResourceOptions.Merge(options, new CustomResourceOptions {Id = id}));
        }
    }
}
