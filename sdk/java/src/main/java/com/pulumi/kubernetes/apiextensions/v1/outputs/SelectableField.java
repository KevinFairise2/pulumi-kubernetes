// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.apiextensions.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class SelectableField {
    /**
     * @return jsonPath is a simple JSON path which is evaluated against each custom resource to produce a field selector value. Only JSON paths without the array notation are allowed. Must point to a field of type string, boolean or integer. Types with enum values and strings with formats are allowed. If jsonPath refers to absent field in a resource, the jsonPath evaluates to an empty string. Must not point to metdata fields. Required.
     * 
     */
    private String jsonPath;

    private SelectableField() {}
    /**
     * @return jsonPath is a simple JSON path which is evaluated against each custom resource to produce a field selector value. Only JSON paths without the array notation are allowed. Must point to a field of type string, boolean or integer. Types with enum values and strings with formats are allowed. If jsonPath refers to absent field in a resource, the jsonPath evaluates to an empty string. Must not point to metdata fields. Required.
     * 
     */
    public String jsonPath() {
        return this.jsonPath;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SelectableField defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String jsonPath;
        public Builder() {}
        public Builder(SelectableField defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.jsonPath = defaults.jsonPath;
        }

        @CustomType.Setter
        public Builder jsonPath(String jsonPath) {
            this.jsonPath = Objects.requireNonNull(jsonPath);
            return this;
        }
        public SelectableField build() {
            final var o = new SelectableField();
            o.jsonPath = jsonPath;
            return o;
        }
    }
}
