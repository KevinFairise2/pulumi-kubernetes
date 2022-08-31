// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.core.v1.outputs.LoadBalancerIngress;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class LoadBalancerStatus {
    /**
     * @return Ingress is a list containing ingress points for the load-balancer. Traffic intended for the service should be sent to these ingress points.
     * 
     */
    private @Nullable List<LoadBalancerIngress> ingress;

    private LoadBalancerStatus() {}
    /**
     * @return Ingress is a list containing ingress points for the load-balancer. Traffic intended for the service should be sent to these ingress points.
     * 
     */
    public List<LoadBalancerIngress> ingress() {
        return this.ingress == null ? List.of() : this.ingress;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(LoadBalancerStatus defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<LoadBalancerIngress> ingress;
        public Builder() {}
        public Builder(LoadBalancerStatus defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ingress = defaults.ingress;
        }

        @CustomType.Setter
        public Builder ingress(@Nullable List<LoadBalancerIngress> ingress) {
            this.ingress = ingress;
            return this;
        }
        public Builder ingress(LoadBalancerIngress... ingress) {
            return ingress(List.of(ingress));
        }
        public LoadBalancerStatus build() {
            final var o = new LoadBalancerStatus();
            o.ingress = ingress;
            return o;
        }
    }
}