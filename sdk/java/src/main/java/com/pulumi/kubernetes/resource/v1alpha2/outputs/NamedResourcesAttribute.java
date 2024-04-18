// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.resource.v1alpha2.outputs.NamedResourcesIntSlice;
import com.pulumi.kubernetes.resource.v1alpha2.outputs.NamedResourcesStringSlice;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class NamedResourcesAttribute {
    /**
     * @return BoolValue is a true/false value.
     * 
     */
    private @Nullable Boolean bool;
    /**
     * @return IntValue is a 64-bit integer.
     * 
     */
    private @Nullable Integer int_;
    /**
     * @return IntSliceValue is an array of 64-bit integers.
     * 
     */
    private @Nullable NamedResourcesIntSlice intSlice;
    /**
     * @return Name is unique identifier among all resource instances managed by the driver on the node. It must be a DNS subdomain.
     * 
     */
    private String name;
    /**
     * @return QuantityValue is a quantity.
     * 
     */
    private @Nullable String quantity;
    /**
     * @return StringValue is a string.
     * 
     */
    private @Nullable String string;
    /**
     * @return StringSliceValue is an array of strings.
     * 
     */
    private @Nullable NamedResourcesStringSlice stringSlice;
    /**
     * @return VersionValue is a semantic version according to semver.org spec 2.0.0.
     * 
     */
    private @Nullable String version;

    private NamedResourcesAttribute() {}
    /**
     * @return BoolValue is a true/false value.
     * 
     */
    public Optional<Boolean> bool() {
        return Optional.ofNullable(this.bool);
    }
    /**
     * @return IntValue is a 64-bit integer.
     * 
     */
    public Optional<Integer> int_() {
        return Optional.ofNullable(this.int_);
    }
    /**
     * @return IntSliceValue is an array of 64-bit integers.
     * 
     */
    public Optional<NamedResourcesIntSlice> intSlice() {
        return Optional.ofNullable(this.intSlice);
    }
    /**
     * @return Name is unique identifier among all resource instances managed by the driver on the node. It must be a DNS subdomain.
     * 
     */
    public String name() {
        return this.name;
    }
    /**
     * @return QuantityValue is a quantity.
     * 
     */
    public Optional<String> quantity() {
        return Optional.ofNullable(this.quantity);
    }
    /**
     * @return StringValue is a string.
     * 
     */
    public Optional<String> string() {
        return Optional.ofNullable(this.string);
    }
    /**
     * @return StringSliceValue is an array of strings.
     * 
     */
    public Optional<NamedResourcesStringSlice> stringSlice() {
        return Optional.ofNullable(this.stringSlice);
    }
    /**
     * @return VersionValue is a semantic version according to semver.org spec 2.0.0.
     * 
     */
    public Optional<String> version() {
        return Optional.ofNullable(this.version);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(NamedResourcesAttribute defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean bool;
        private @Nullable Integer int_;
        private @Nullable NamedResourcesIntSlice intSlice;
        private String name;
        private @Nullable String quantity;
        private @Nullable String string;
        private @Nullable NamedResourcesStringSlice stringSlice;
        private @Nullable String version;
        public Builder() {}
        public Builder(NamedResourcesAttribute defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bool = defaults.bool;
    	      this.int_ = defaults.int_;
    	      this.intSlice = defaults.intSlice;
    	      this.name = defaults.name;
    	      this.quantity = defaults.quantity;
    	      this.string = defaults.string;
    	      this.stringSlice = defaults.stringSlice;
    	      this.version = defaults.version;
        }

        @CustomType.Setter
        public Builder bool(@Nullable Boolean bool) {
            this.bool = bool;
            return this;
        }
        @CustomType.Setter("int")
        public Builder int_(@Nullable Integer int_) {
            this.int_ = int_;
            return this;
        }
        @CustomType.Setter
        public Builder intSlice(@Nullable NamedResourcesIntSlice intSlice) {
            this.intSlice = intSlice;
            return this;
        }
        @CustomType.Setter
        public Builder name(String name) {
            this.name = Objects.requireNonNull(name);
            return this;
        }
        @CustomType.Setter
        public Builder quantity(@Nullable String quantity) {
            this.quantity = quantity;
            return this;
        }
        @CustomType.Setter
        public Builder string(@Nullable String string) {
            this.string = string;
            return this;
        }
        @CustomType.Setter
        public Builder stringSlice(@Nullable NamedResourcesStringSlice stringSlice) {
            this.stringSlice = stringSlice;
            return this;
        }
        @CustomType.Setter
        public Builder version(@Nullable String version) {
            this.version = version;
            return this;
        }
        public NamedResourcesAttribute build() {
            final var o = new NamedResourcesAttribute();
            o.bool = bool;
            o.int_ = int_;
            o.intSlice = intSlice;
            o.name = name;
            o.quantity = quantity;
            o.string = string;
            o.stringSlice = stringSlice;
            o.version = version;
            return o;
        }
    }
}
