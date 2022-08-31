// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.flowcontrol.v1beta2.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.flowcontrol.v1beta2.outputs.PriorityLevelConfigurationCondition;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class PriorityLevelConfigurationStatus {
    /**
     * @return `conditions` is the current state of &#34;request-priority&#34;.
     * 
     */
    private @Nullable List<PriorityLevelConfigurationCondition> conditions;

    private PriorityLevelConfigurationStatus() {}
    /**
     * @return `conditions` is the current state of &#34;request-priority&#34;.
     * 
     */
    public List<PriorityLevelConfigurationCondition> conditions() {
        return this.conditions == null ? List.of() : this.conditions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PriorityLevelConfigurationStatus defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<PriorityLevelConfigurationCondition> conditions;
        public Builder() {}
        public Builder(PriorityLevelConfigurationStatus defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.conditions = defaults.conditions;
        }

        @CustomType.Setter
        public Builder conditions(@Nullable List<PriorityLevelConfigurationCondition> conditions) {
            this.conditions = conditions;
            return this;
        }
        public Builder conditions(PriorityLevelConfigurationCondition... conditions) {
            return conditions(List.of(conditions));
        }
        public PriorityLevelConfigurationStatus build() {
            final var o = new PriorityLevelConfigurationStatus();
            o.conditions = conditions;
            return o;
        }
    }
}