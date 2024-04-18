// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.outputs;

import com.google.gson.JsonElement;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.resource.v1alpha2.outputs.ResourceRequestPatch;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DriverRequestsPatch {
    /**
     * @return DriverName is the name used by the DRA driver kubelet plugin.
     * 
     */
    private @Nullable String driverName;
    /**
     * @return Requests describes all resources that are needed from the driver.
     * 
     */
    private @Nullable List<ResourceRequestPatch> requests;
    /**
     * @return VendorParameters are arbitrary setup parameters for all requests of the claim. They are ignored while allocating the claim.
     * 
     */
    private @Nullable JsonElement vendorParameters;

    private DriverRequestsPatch() {}
    /**
     * @return DriverName is the name used by the DRA driver kubelet plugin.
     * 
     */
    public Optional<String> driverName() {
        return Optional.ofNullable(this.driverName);
    }
    /**
     * @return Requests describes all resources that are needed from the driver.
     * 
     */
    public List<ResourceRequestPatch> requests() {
        return this.requests == null ? List.of() : this.requests;
    }
    /**
     * @return VendorParameters are arbitrary setup parameters for all requests of the claim. They are ignored while allocating the claim.
     * 
     */
    public Optional<JsonElement> vendorParameters() {
        return Optional.ofNullable(this.vendorParameters);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DriverRequestsPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String driverName;
        private @Nullable List<ResourceRequestPatch> requests;
        private @Nullable JsonElement vendorParameters;
        public Builder() {}
        public Builder(DriverRequestsPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.driverName = defaults.driverName;
    	      this.requests = defaults.requests;
    	      this.vendorParameters = defaults.vendorParameters;
        }

        @CustomType.Setter
        public Builder driverName(@Nullable String driverName) {
            this.driverName = driverName;
            return this;
        }
        @CustomType.Setter
        public Builder requests(@Nullable List<ResourceRequestPatch> requests) {
            this.requests = requests;
            return this;
        }
        public Builder requests(ResourceRequestPatch... requests) {
            return requests(List.of(requests));
        }
        @CustomType.Setter
        public Builder vendorParameters(@Nullable JsonElement vendorParameters) {
            this.vendorParameters = vendorParameters;
            return this;
        }
        public DriverRequestsPatch build() {
            final var o = new DriverRequestsPatch();
            o.driverName = driverName;
            o.requests = requests;
            o.vendorParameters = vendorParameters;
            return o;
        }
    }
}
