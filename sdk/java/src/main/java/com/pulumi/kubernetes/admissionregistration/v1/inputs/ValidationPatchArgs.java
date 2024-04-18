// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.admissionregistration.v1.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * Validation specifies the CEL expression which is used to apply the validation.
 * 
 */
public final class ValidationPatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final ValidationPatchArgs Empty = new ValidationPatchArgs();

    /**
     * Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:
     * 
     * - &#39;object&#39; - The object from the incoming request. The value is null for DELETE requests. - &#39;oldObject&#39; - The existing object. The value is null for CREATE requests. - &#39;request&#39; - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - &#39;params&#39; - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - &#39;namespaceObject&#39; - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - &#39;variables&#39; - Map of composited variables, from its name to its lazily evaluated value.
     *   For example, a variable named &#39;foo&#39; can be accessed as &#39;variables.foo&#39;.
     * - &#39;authorizer&#39; - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.
     *   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz
     * - &#39;authorizer.requestResource&#39; - A CEL ResourceCheck constructed from the &#39;authorizer&#39; and configured with the
     *   request resource.
     * 
     * The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.
     * 
     * Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]*` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - &#39;__&#39; escapes to &#39;__underscores__&#39; - &#39;.&#39; escapes to &#39;__dot__&#39; - &#39;-&#39; escapes to &#39;__dash__&#39; - &#39;/&#39; escapes to &#39;__slash__&#39; - Property names that exactly match a CEL RESERVED keyword escape to &#39;__{keyword}__&#39;. The keywords are:
     * 	  &#34;true&#34;, &#34;false&#34;, &#34;null&#34;, &#34;in&#34;, &#34;as&#34;, &#34;break&#34;, &#34;const&#34;, &#34;continue&#34;, &#34;else&#34;, &#34;for&#34;, &#34;function&#34;, &#34;if&#34;,
     * 	  &#34;import&#34;, &#34;let&#34;, &#34;loop&#34;, &#34;package&#34;, &#34;namespace&#34;, &#34;return&#34;.
     * Examples:
     *   - Expression accessing a property named &#34;namespace&#34;: {&#34;Expression&#34;: &#34;object.__namespace__ &gt; 0&#34;}
     *   - Expression accessing a property named &#34;x-prop&#34;: {&#34;Expression&#34;: &#34;object.x__dash__prop &gt; 0&#34;}
     *   - Expression accessing a property named &#34;redact__d&#34;: {&#34;Expression&#34;: &#34;object.redact__underscores__d &gt; 0&#34;}
     * 
     * Equality on arrays with list type of &#39;set&#39; or &#39;map&#39; ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:
     *   - &#39;set&#39;: `X + Y` performs a union where the array positions of all elements in `X` are preserved and
     *     non-intersecting elements in `Y` are appended, retaining their partial order.
     *   - &#39;map&#39;: `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values
     *     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with
     *     non-intersecting keys are appended, retaining their partial order.
     *     Required.
     * 
     */
    @Import(name="expression")
    private @Nullable Output<String> expression;

    /**
     * @return Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:
     * 
     * - &#39;object&#39; - The object from the incoming request. The value is null for DELETE requests. - &#39;oldObject&#39; - The existing object. The value is null for CREATE requests. - &#39;request&#39; - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - &#39;params&#39; - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - &#39;namespaceObject&#39; - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - &#39;variables&#39; - Map of composited variables, from its name to its lazily evaluated value.
     *   For example, a variable named &#39;foo&#39; can be accessed as &#39;variables.foo&#39;.
     * - &#39;authorizer&#39; - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.
     *   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz
     * - &#39;authorizer.requestResource&#39; - A CEL ResourceCheck constructed from the &#39;authorizer&#39; and configured with the
     *   request resource.
     * 
     * The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.
     * 
     * Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]*` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - &#39;__&#39; escapes to &#39;__underscores__&#39; - &#39;.&#39; escapes to &#39;__dot__&#39; - &#39;-&#39; escapes to &#39;__dash__&#39; - &#39;/&#39; escapes to &#39;__slash__&#39; - Property names that exactly match a CEL RESERVED keyword escape to &#39;__{keyword}__&#39;. The keywords are:
     * 	  &#34;true&#34;, &#34;false&#34;, &#34;null&#34;, &#34;in&#34;, &#34;as&#34;, &#34;break&#34;, &#34;const&#34;, &#34;continue&#34;, &#34;else&#34;, &#34;for&#34;, &#34;function&#34;, &#34;if&#34;,
     * 	  &#34;import&#34;, &#34;let&#34;, &#34;loop&#34;, &#34;package&#34;, &#34;namespace&#34;, &#34;return&#34;.
     * Examples:
     *   - Expression accessing a property named &#34;namespace&#34;: {&#34;Expression&#34;: &#34;object.__namespace__ &gt; 0&#34;}
     *   - Expression accessing a property named &#34;x-prop&#34;: {&#34;Expression&#34;: &#34;object.x__dash__prop &gt; 0&#34;}
     *   - Expression accessing a property named &#34;redact__d&#34;: {&#34;Expression&#34;: &#34;object.redact__underscores__d &gt; 0&#34;}
     * 
     * Equality on arrays with list type of &#39;set&#39; or &#39;map&#39; ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:
     *   - &#39;set&#39;: `X + Y` performs a union where the array positions of all elements in `X` are preserved and
     *     non-intersecting elements in `Y` are appended, retaining their partial order.
     *   - &#39;map&#39;: `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values
     *     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with
     *     non-intersecting keys are appended, retaining their partial order.
     *     Required.
     * 
     */
    public Optional<Output<String>> expression() {
        return Optional.ofNullable(this.expression);
    }

    /**
     * Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is &#34;failed rule: {Rule}&#34;. e.g. &#34;must be a URL with the host matching spec.host&#34; If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is &#34;failed Expression: {Expression}&#34;.
     * 
     */
    @Import(name="message")
    private @Nullable Output<String> message;

    /**
     * @return Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is &#34;failed rule: {Rule}&#34;. e.g. &#34;must be a URL with the host matching spec.host&#34; If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is &#34;failed Expression: {Expression}&#34;.
     * 
     */
    public Optional<Output<String>> message() {
        return Optional.ofNullable(this.message);
    }

    /**
     * messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for &#39;authorizer&#39; and &#39;authorizer.requestResource&#39;. Example: &#34;object.x must be less than max (&#34;+string(params.max)+&#34;)&#34;
     * 
     */
    @Import(name="messageExpression")
    private @Nullable Output<String> messageExpression;

    /**
     * @return messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for &#39;authorizer&#39; and &#39;authorizer.requestResource&#39;. Example: &#34;object.x must be less than max (&#34;+string(params.max)+&#34;)&#34;
     * 
     */
    public Optional<Output<String>> messageExpression() {
        return Optional.ofNullable(this.messageExpression);
    }

    /**
     * Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: &#34;Unauthorized&#34;, &#34;Forbidden&#34;, &#34;Invalid&#34;, &#34;RequestEntityTooLarge&#34;. If not set, StatusReasonInvalid is used in the response to the client.
     * 
     */
    @Import(name="reason")
    private @Nullable Output<String> reason;

    /**
     * @return Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: &#34;Unauthorized&#34;, &#34;Forbidden&#34;, &#34;Invalid&#34;, &#34;RequestEntityTooLarge&#34;. If not set, StatusReasonInvalid is used in the response to the client.
     * 
     */
    public Optional<Output<String>> reason() {
        return Optional.ofNullable(this.reason);
    }

    private ValidationPatchArgs() {}

    private ValidationPatchArgs(ValidationPatchArgs $) {
        this.expression = $.expression;
        this.message = $.message;
        this.messageExpression = $.messageExpression;
        this.reason = $.reason;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ValidationPatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ValidationPatchArgs $;

        public Builder() {
            $ = new ValidationPatchArgs();
        }

        public Builder(ValidationPatchArgs defaults) {
            $ = new ValidationPatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param expression Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:
         * 
         * - &#39;object&#39; - The object from the incoming request. The value is null for DELETE requests. - &#39;oldObject&#39; - The existing object. The value is null for CREATE requests. - &#39;request&#39; - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - &#39;params&#39; - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - &#39;namespaceObject&#39; - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - &#39;variables&#39; - Map of composited variables, from its name to its lazily evaluated value.
         *   For example, a variable named &#39;foo&#39; can be accessed as &#39;variables.foo&#39;.
         * - &#39;authorizer&#39; - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.
         *   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz
         * - &#39;authorizer.requestResource&#39; - A CEL ResourceCheck constructed from the &#39;authorizer&#39; and configured with the
         *   request resource.
         * 
         * The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.
         * 
         * Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]*` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - &#39;__&#39; escapes to &#39;__underscores__&#39; - &#39;.&#39; escapes to &#39;__dot__&#39; - &#39;-&#39; escapes to &#39;__dash__&#39; - &#39;/&#39; escapes to &#39;__slash__&#39; - Property names that exactly match a CEL RESERVED keyword escape to &#39;__{keyword}__&#39;. The keywords are:
         * 	  &#34;true&#34;, &#34;false&#34;, &#34;null&#34;, &#34;in&#34;, &#34;as&#34;, &#34;break&#34;, &#34;const&#34;, &#34;continue&#34;, &#34;else&#34;, &#34;for&#34;, &#34;function&#34;, &#34;if&#34;,
         * 	  &#34;import&#34;, &#34;let&#34;, &#34;loop&#34;, &#34;package&#34;, &#34;namespace&#34;, &#34;return&#34;.
         * Examples:
         *   - Expression accessing a property named &#34;namespace&#34;: {&#34;Expression&#34;: &#34;object.__namespace__ &gt; 0&#34;}
         *   - Expression accessing a property named &#34;x-prop&#34;: {&#34;Expression&#34;: &#34;object.x__dash__prop &gt; 0&#34;}
         *   - Expression accessing a property named &#34;redact__d&#34;: {&#34;Expression&#34;: &#34;object.redact__underscores__d &gt; 0&#34;}
         * 
         * Equality on arrays with list type of &#39;set&#39; or &#39;map&#39; ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:
         *   - &#39;set&#39;: `X + Y` performs a union where the array positions of all elements in `X` are preserved and
         *     non-intersecting elements in `Y` are appended, retaining their partial order.
         *   - &#39;map&#39;: `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values
         *     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with
         *     non-intersecting keys are appended, retaining their partial order.
         *     Required.
         * 
         * @return builder
         * 
         */
        public Builder expression(@Nullable Output<String> expression) {
            $.expression = expression;
            return this;
        }

        /**
         * @param expression Expression represents the expression which will be evaluated by CEL. ref: https://github.com/google/cel-spec CEL expressions have access to the contents of the API request/response, organized into CEL variables as well as some other useful variables:
         * 
         * - &#39;object&#39; - The object from the incoming request. The value is null for DELETE requests. - &#39;oldObject&#39; - The existing object. The value is null for CREATE requests. - &#39;request&#39; - Attributes of the API request([ref](/pkg/apis/admission/types.go#AdmissionRequest)). - &#39;params&#39; - Parameter resource referred to by the policy binding being evaluated. Only populated if the policy has a ParamKind. - &#39;namespaceObject&#39; - The namespace object that the incoming object belongs to. The value is null for cluster-scoped resources. - &#39;variables&#39; - Map of composited variables, from its name to its lazily evaluated value.
         *   For example, a variable named &#39;foo&#39; can be accessed as &#39;variables.foo&#39;.
         * - &#39;authorizer&#39; - A CEL Authorizer. May be used to perform authorization checks for the principal (user or service account) of the request.
         *   See https://pkg.go.dev/k8s.io/apiserver/pkg/cel/library#Authz
         * - &#39;authorizer.requestResource&#39; - A CEL ResourceCheck constructed from the &#39;authorizer&#39; and configured with the
         *   request resource.
         * 
         * The `apiVersion`, `kind`, `metadata.name` and `metadata.generateName` are always accessible from the root of the object. No other metadata properties are accessible.
         * 
         * Only property names of the form `[a-zA-Z_.-/][a-zA-Z0-9_.-/]*` are accessible. Accessible property names are escaped according to the following rules when accessed in the expression: - &#39;__&#39; escapes to &#39;__underscores__&#39; - &#39;.&#39; escapes to &#39;__dot__&#39; - &#39;-&#39; escapes to &#39;__dash__&#39; - &#39;/&#39; escapes to &#39;__slash__&#39; - Property names that exactly match a CEL RESERVED keyword escape to &#39;__{keyword}__&#39;. The keywords are:
         * 	  &#34;true&#34;, &#34;false&#34;, &#34;null&#34;, &#34;in&#34;, &#34;as&#34;, &#34;break&#34;, &#34;const&#34;, &#34;continue&#34;, &#34;else&#34;, &#34;for&#34;, &#34;function&#34;, &#34;if&#34;,
         * 	  &#34;import&#34;, &#34;let&#34;, &#34;loop&#34;, &#34;package&#34;, &#34;namespace&#34;, &#34;return&#34;.
         * Examples:
         *   - Expression accessing a property named &#34;namespace&#34;: {&#34;Expression&#34;: &#34;object.__namespace__ &gt; 0&#34;}
         *   - Expression accessing a property named &#34;x-prop&#34;: {&#34;Expression&#34;: &#34;object.x__dash__prop &gt; 0&#34;}
         *   - Expression accessing a property named &#34;redact__d&#34;: {&#34;Expression&#34;: &#34;object.redact__underscores__d &gt; 0&#34;}
         * 
         * Equality on arrays with list type of &#39;set&#39; or &#39;map&#39; ignores element order, i.e. [1, 2] == [2, 1]. Concatenation on arrays with x-kubernetes-list-type use the semantics of the list type:
         *   - &#39;set&#39;: `X + Y` performs a union where the array positions of all elements in `X` are preserved and
         *     non-intersecting elements in `Y` are appended, retaining their partial order.
         *   - &#39;map&#39;: `X + Y` performs a merge where the array positions of all keys in `X` are preserved but the values
         *     are overwritten by values in `Y` when the key sets of `X` and `Y` intersect. Elements in `Y` with
         *     non-intersecting keys are appended, retaining their partial order.
         *     Required.
         * 
         * @return builder
         * 
         */
        public Builder expression(String expression) {
            return expression(Output.of(expression));
        }

        /**
         * @param message Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is &#34;failed rule: {Rule}&#34;. e.g. &#34;must be a URL with the host matching spec.host&#34; If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is &#34;failed Expression: {Expression}&#34;.
         * 
         * @return builder
         * 
         */
        public Builder message(@Nullable Output<String> message) {
            $.message = message;
            return this;
        }

        /**
         * @param message Message represents the message displayed when validation fails. The message is required if the Expression contains line breaks. The message must not contain line breaks. If unset, the message is &#34;failed rule: {Rule}&#34;. e.g. &#34;must be a URL with the host matching spec.host&#34; If the Expression contains line breaks. Message is required. The message must not contain line breaks. If unset, the message is &#34;failed Expression: {Expression}&#34;.
         * 
         * @return builder
         * 
         */
        public Builder message(String message) {
            return message(Output.of(message));
        }

        /**
         * @param messageExpression messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for &#39;authorizer&#39; and &#39;authorizer.requestResource&#39;. Example: &#34;object.x must be less than max (&#34;+string(params.max)+&#34;)&#34;
         * 
         * @return builder
         * 
         */
        public Builder messageExpression(@Nullable Output<String> messageExpression) {
            $.messageExpression = messageExpression;
            return this;
        }

        /**
         * @param messageExpression messageExpression declares a CEL expression that evaluates to the validation failure message that is returned when this rule fails. Since messageExpression is used as a failure message, it must evaluate to a string. If both message and messageExpression are present on a validation, then messageExpression will be used if validation fails. If messageExpression results in a runtime error, the runtime error is logged, and the validation failure message is produced as if the messageExpression field were unset. If messageExpression evaluates to an empty string, a string with only spaces, or a string that contains line breaks, then the validation failure message will also be produced as if the messageExpression field were unset, and the fact that messageExpression produced an empty string/string with only spaces/string with line breaks will be logged. messageExpression has access to all the same variables as the `expression` except for &#39;authorizer&#39; and &#39;authorizer.requestResource&#39;. Example: &#34;object.x must be less than max (&#34;+string(params.max)+&#34;)&#34;
         * 
         * @return builder
         * 
         */
        public Builder messageExpression(String messageExpression) {
            return messageExpression(Output.of(messageExpression));
        }

        /**
         * @param reason Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: &#34;Unauthorized&#34;, &#34;Forbidden&#34;, &#34;Invalid&#34;, &#34;RequestEntityTooLarge&#34;. If not set, StatusReasonInvalid is used in the response to the client.
         * 
         * @return builder
         * 
         */
        public Builder reason(@Nullable Output<String> reason) {
            $.reason = reason;
            return this;
        }

        /**
         * @param reason Reason represents a machine-readable description of why this validation failed. If this is the first validation in the list to fail, this reason, as well as the corresponding HTTP response code, are used in the HTTP response to the client. The currently supported reasons are: &#34;Unauthorized&#34;, &#34;Forbidden&#34;, &#34;Invalid&#34;, &#34;RequestEntityTooLarge&#34;. If not set, StatusReasonInvalid is used in the response to the client.
         * 
         * @return builder
         * 
         */
        public Builder reason(String reason) {
            return reason(Output.of(reason));
        }

        public ValidationPatchArgs build() {
            return $;
        }
    }

}
