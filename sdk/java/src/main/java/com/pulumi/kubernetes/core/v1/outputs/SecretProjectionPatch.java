// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.core.v1.outputs.KeyToPathPatch;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class SecretProjectionPatch {
    /**
     * @return items if unspecified, each key-value pair in the Data field of the referenced Secret will be projected into the volume as a file whose name is the key and content is the value. If specified, the listed keys will be projected into the specified paths, and unlisted keys will not be present. If a key is specified which is not present in the Secret, the volume setup will error unless it is marked optional. Paths must be relative and may not contain the &#39;..&#39; path or start with &#39;..&#39;.
     * 
     */
    private @Nullable List<KeyToPathPatch> items;
    /**
     * @return Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     * 
     */
    private @Nullable String name;
    /**
     * @return optional field specify whether the Secret or its key must be defined
     * 
     */
    private @Nullable Boolean optional;

    private SecretProjectionPatch() {}
    /**
     * @return items if unspecified, each key-value pair in the Data field of the referenced Secret will be projected into the volume as a file whose name is the key and content is the value. If specified, the listed keys will be projected into the specified paths, and unlisted keys will not be present. If a key is specified which is not present in the Secret, the volume setup will error unless it is marked optional. Paths must be relative and may not contain the &#39;..&#39; path or start with &#39;..&#39;.
     * 
     */
    public List<KeyToPathPatch> items() {
        return this.items == null ? List.of() : this.items;
    }
    /**
     * @return Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }
    /**
     * @return optional field specify whether the Secret or its key must be defined
     * 
     */
    public Optional<Boolean> optional() {
        return Optional.ofNullable(this.optional);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SecretProjectionPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<KeyToPathPatch> items;
        private @Nullable String name;
        private @Nullable Boolean optional;
        public Builder() {}
        public Builder(SecretProjectionPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.items = defaults.items;
    	      this.name = defaults.name;
    	      this.optional = defaults.optional;
        }

        @CustomType.Setter
        public Builder items(@Nullable List<KeyToPathPatch> items) {
            this.items = items;
            return this;
        }
        public Builder items(KeyToPathPatch... items) {
            return items(List.of(items));
        }
        @CustomType.Setter
        public Builder name(@Nullable String name) {
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder optional(@Nullable Boolean optional) {
            this.optional = optional;
            return this;
        }
        public SecretProjectionPatch build() {
            final var o = new SecretProjectionPatch();
            o.items = items;
            o.name = name;
            o.optional = optional;
            return o;
        }
    }
}