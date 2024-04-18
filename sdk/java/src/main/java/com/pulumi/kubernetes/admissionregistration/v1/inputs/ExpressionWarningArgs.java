// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.admissionregistration.v1.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;


/**
 * ExpressionWarning is a warning information that targets a specific expression.
 * 
 */
public final class ExpressionWarningArgs extends com.pulumi.resources.ResourceArgs {

    public static final ExpressionWarningArgs Empty = new ExpressionWarningArgs();

    /**
     * The path to the field that refers the expression. For example, the reference to the expression of the first item of validations is &#34;spec.validations[0].expression&#34;
     * 
     */
    @Import(name="fieldRef", required=true)
    private Output<String> fieldRef;

    /**
     * @return The path to the field that refers the expression. For example, the reference to the expression of the first item of validations is &#34;spec.validations[0].expression&#34;
     * 
     */
    public Output<String> fieldRef() {
        return this.fieldRef;
    }

    /**
     * The content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
     * 
     */
    @Import(name="warning", required=true)
    private Output<String> warning;

    /**
     * @return The content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
     * 
     */
    public Output<String> warning() {
        return this.warning;
    }

    private ExpressionWarningArgs() {}

    private ExpressionWarningArgs(ExpressionWarningArgs $) {
        this.fieldRef = $.fieldRef;
        this.warning = $.warning;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ExpressionWarningArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ExpressionWarningArgs $;

        public Builder() {
            $ = new ExpressionWarningArgs();
        }

        public Builder(ExpressionWarningArgs defaults) {
            $ = new ExpressionWarningArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param fieldRef The path to the field that refers the expression. For example, the reference to the expression of the first item of validations is &#34;spec.validations[0].expression&#34;
         * 
         * @return builder
         * 
         */
        public Builder fieldRef(Output<String> fieldRef) {
            $.fieldRef = fieldRef;
            return this;
        }

        /**
         * @param fieldRef The path to the field that refers the expression. For example, the reference to the expression of the first item of validations is &#34;spec.validations[0].expression&#34;
         * 
         * @return builder
         * 
         */
        public Builder fieldRef(String fieldRef) {
            return fieldRef(Output.of(fieldRef));
        }

        /**
         * @param warning The content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
         * 
         * @return builder
         * 
         */
        public Builder warning(Output<String> warning) {
            $.warning = warning;
            return this;
        }

        /**
         * @param warning The content of type checking information in a human-readable form. Each line of the warning contains the type that the expression is checked against, followed by the type check error from the compiler.
         * 
         * @return builder
         * 
         */
        public Builder warning(String warning) {
            return warning(Output.of(warning));
        }

        public ExpressionWarningArgs build() {
            $.fieldRef = Objects.requireNonNull($.fieldRef, "expected parameter 'fieldRef' to be non-null");
            $.warning = Objects.requireNonNull($.warning, "expected parameter 'warning' to be non-null");
            return $;
        }
    }

}
