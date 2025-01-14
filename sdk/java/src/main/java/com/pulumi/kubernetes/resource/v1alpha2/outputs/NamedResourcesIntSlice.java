// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.List;
import java.util.Objects;

@CustomType
public final class NamedResourcesIntSlice {
    /**
     * @return Ints is the slice of 64-bit integers.
     * 
     */
    private List<Integer> ints;

    private NamedResourcesIntSlice() {}
    /**
     * @return Ints is the slice of 64-bit integers.
     * 
     */
    public List<Integer> ints() {
        return this.ints;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(NamedResourcesIntSlice defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<Integer> ints;
        public Builder() {}
        public Builder(NamedResourcesIntSlice defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ints = defaults.ints;
        }

        @CustomType.Setter
        public Builder ints(List<Integer> ints) {
            this.ints = Objects.requireNonNull(ints);
            return this;
        }
        public Builder ints(Integer... ints) {
            return ints(List.of(ints));
        }
        public NamedResourcesIntSlice build() {
            final var o = new NamedResourcesIntSlice();
            o.ints = ints;
            return o;
        }
    }
}
