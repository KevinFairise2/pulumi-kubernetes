// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Kubernetes.Types.Outputs.AdmissionRegistration.V1
{

    /// <summary>
    /// TypeChecking contains results of type checking the expressions in the ValidatingAdmissionPolicy
    /// </summary>
    [OutputType]
    public sealed class TypeChecking
    {
        /// <summary>
        /// The type checking warnings for each expression.
        /// </summary>
        public readonly ImmutableArray<Pulumi.Kubernetes.Types.Outputs.AdmissionRegistration.V1.ExpressionWarning> ExpressionWarnings;

        [OutputConstructor]
        private TypeChecking(ImmutableArray<Pulumi.Kubernetes.Types.Outputs.AdmissionRegistration.V1.ExpressionWarning> expressionWarnings)
        {
            ExpressionWarnings = expressionWarnings;
        }
    }
}
