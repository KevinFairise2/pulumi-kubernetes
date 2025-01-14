// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class NamedResourcesIntSlicePatch {
    /**
     * @return Ints is the slice of 64-bit integers.
     * 
     */
    private @Nullable List<Integer> ints;

    private NamedResourcesIntSlicePatch() {}
    /**
     * @return Ints is the slice of 64-bit integers.
     * 
     */
    public List<Integer> ints() {
        return this.ints == null ? List.of() : this.ints;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(NamedResourcesIntSlicePatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<Integer> ints;
        public Builder() {}
        public Builder(NamedResourcesIntSlicePatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ints = defaults.ints;
        }

        @CustomType.Setter
        public Builder ints(@Nullable List<Integer> ints) {
            this.ints = ints;
            return this;
        }
        public Builder ints(Integer... ints) {
            return ints(List.of(ints));
        }
        public NamedResourcesIntSlicePatch build() {
            final var o = new NamedResourcesIntSlicePatch();
            o.ints = ints;
            return o;
        }
    }
}
