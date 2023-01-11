// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PodSchedulingGatePatch {
    /**
     * @return Name of the scheduling gate. Each scheduling gate must have a unique name field.
     * 
     */
    private @Nullable String name;

    private PodSchedulingGatePatch() {}
    /**
     * @return Name of the scheduling gate. Each scheduling gate must have a unique name field.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PodSchedulingGatePatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String name;
        public Builder() {}
        public Builder(PodSchedulingGatePatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.name = defaults.name;
        }

        @CustomType.Setter
        public Builder name(@Nullable String name) {
            this.name = name;
            return this;
        }
        public PodSchedulingGatePatch build() {
            final var o = new PodSchedulingGatePatch();
            o.name = name;
            return o;
        }
    }
}