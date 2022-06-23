// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Immutable;

namespace Pulumi.Kubernetes
{
    public static class Config
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Design", "IDE1006", Justification = 
        "Double underscore prefix used to avoid conflicts with variable names.")]
        private sealed class __Value<T>
        {
            private readonly Func<T> _getter;
            private T _value = default!;
            private bool _set;

            public __Value(Func<T> getter)
            {
                _getter = getter;
            }

            public T Get() => _set ? _value : _getter();

            public void Set(T value)
            {
                _value = value;
                _set = true;
            }
        }

        private static readonly Pulumi.Config __config = new Pulumi.Config("kubernetes");

        private static readonly __Value<string?> _cluster = new __Value<string?>(() => __config.Get("cluster"));
        /// <summary>
        /// If present, the name of the kubeconfig cluster to use.
        /// </summary>
        public static string? Cluster
        {
            get => _cluster.Get();
            set => _cluster.Set(value);
        }

        private static readonly __Value<string?> _context = new __Value<string?>(() => __config.Get("context"));
        /// <summary>
        /// If present, the name of the kubeconfig context to use.
        /// </summary>
        public static string? Context
        {
            get => _context.Get();
            set => _context.Set(value);
        }

        private static readonly __Value<bool?> _deleteUnreachable = new __Value<bool?>(() => __config.GetBoolean("deleteUnreachable"));
        /// <summary>
        /// If present and set to true, the provider will delete resources associated with an unreachable Kubernetes cluster from Pulumi state
        /// </summary>
        public static bool? DeleteUnreachable
        {
            get => _deleteUnreachable.Get();
            set => _deleteUnreachable.Set(value);
        }

        private static readonly __Value<bool?> _enableConfigMapMutable = new __Value<bool?>(() => __config.GetBoolean("enableConfigMapMutable"));
        /// <summary>
        /// BETA FEATURE - If present and set to true, allow ConfigMaps to be mutated.
        /// This feature is in developer preview, and is disabled by default.
        /// 
        /// This config can be specified in the following ways using this precedence:
        /// 1. This `enableConfigMapMutable` parameter.
        /// 2. The `PULUMI_K8S_ENABLE_CONFIGMAP_MUTABLE` environment variable.
        /// </summary>
        public static bool? EnableConfigMapMutable
        {
            get => _enableConfigMapMutable.Get();
            set => _enableConfigMapMutable.Set(value);
        }

        private static readonly __Value<bool?> _enableDryRun = new __Value<bool?>(() => __config.GetBoolean("enableDryRun"));
        /// <summary>
        /// Deprecated. If present and set to true, enable server-side diff calculations.
        /// </summary>
        public static bool? EnableDryRun
        {
            get => _enableDryRun.Get();
            set => _enableDryRun.Set(value);
        }

        private static readonly __Value<bool?> _enableReplaceCRD = new __Value<bool?>(() => __config.GetBoolean("enableReplaceCRD"));
        /// <summary>
        /// Obsolete. This option has no effect.
        /// </summary>
        public static bool? EnableReplaceCRD
        {
            get => _enableReplaceCRD.Get();
            set => _enableReplaceCRD.Set(value);
        }

        private static readonly __Value<bool?> _enableServerSideApply = new __Value<bool?>(() => __config.GetBoolean("enableServerSideApply"));
        /// <summary>
        /// BETA FEATURE - If present and set to true, enable Server-Side Apply mode.
        /// See https://github.com/pulumi/pulumi-kubernetes/issues/2011 for additional details.
        /// This feature is in developer preview, and is disabled by default.
        /// </summary>
        public static bool? EnableServerSideApply
        {
            get => _enableServerSideApply.Get();
            set => _enableServerSideApply.Set(value);
        }

        private static readonly __Value<string?> _kubeconfig = new __Value<string?>(() => __config.Get("kubeconfig"));
        /// <summary>
        /// The contents of a kubeconfig file or the path to a kubeconfig file. If this is set, this config will be used instead of $KUBECONFIG.
        /// </summary>
        public static string? KubeConfig
        {
            get => _kubeconfig.Get();
            set => _kubeconfig.Set(value);
        }

        private static readonly __Value<string?> _namespace = new __Value<string?>(() => __config.Get("namespace"));
        /// <summary>
        /// If present, the default namespace to use. This flag is ignored for cluster-scoped resources.
        /// 
        /// A namespace can be specified in multiple places, and the precedence is as follows:
        /// 1. `.metadata.namespace` set on the resource.
        /// 2. This `namespace` parameter.
        /// 3. `namespace` set for the active context in the kubeconfig.
        /// </summary>
        public static string? Namespace
        {
            get => _namespace.Get();
            set => _namespace.Set(value);
        }

        private static readonly __Value<string?> _renderYamlToDirectory = new __Value<string?>(() => __config.Get("renderYamlToDirectory"));
        /// <summary>
        /// BETA FEATURE - If present, render resource manifests to this directory. In this mode, resources will not
        /// be created on a Kubernetes cluster, but the rendered manifests will be kept in sync with changes
        /// to the Pulumi program. This feature is in developer preview, and is disabled by default.
        /// 
        /// Note that some computed Outputs such as status fields will not be populated
        /// since the resources are not created on a Kubernetes cluster. These Output values will remain undefined,
        /// and may result in an error if they are referenced by other resources. Also note that any secret values
        /// used in these resources will be rendered in plaintext to the resulting YAML.
        /// </summary>
        public static string? RenderYamlToDirectory
        {
            get => _renderYamlToDirectory.Get();
            set => _renderYamlToDirectory.Set(value);
        }

        private static readonly __Value<bool?> _suppressDeprecationWarnings = new __Value<bool?>(() => __config.GetBoolean("suppressDeprecationWarnings"));
        /// <summary>
        /// If present and set to true, suppress apiVersion deprecation warnings from the CLI.
        /// 
        /// This config can be specified in the following ways, using this precedence:
        /// 1. This `suppressDeprecationWarnings` parameter.
        /// 2. The `PULUMI_K8S_SUPPRESS_DEPRECATION_WARNINGS` environment variable.
        /// </summary>
        public static bool? SuppressDeprecationWarnings
        {
            get => _suppressDeprecationWarnings.Get();
            set => _suppressDeprecationWarnings.Set(value);
        }

        private static readonly __Value<bool?> _suppressHelmHookWarnings = new __Value<bool?>(() => __config.GetBoolean("suppressHelmHookWarnings"));
        /// <summary>
        /// If present and set to true, suppress unsupported Helm hook warnings from the CLI.
        /// 
        /// This config can be specified in the following ways, using this precedence:
        /// 1. This `suppressHelmHookWarnings` parameter.
        /// 2. The `PULUMI_K8S_SUPPRESS_HELM_HOOK_WARNINGS` environment variable.
        /// </summary>
        public static bool? SuppressHelmHookWarnings
        {
            get => _suppressHelmHookWarnings.Get();
            set => _suppressHelmHookWarnings.Set(value);
        }

    }
}
