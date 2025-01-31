// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.auditregistration.v1alpha1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.auditregistration.v1alpha1.outputs.Policy;
import com.pulumi.kubernetes.auditregistration.v1alpha1.outputs.Webhook;
import java.util.Objects;

@CustomType
public final class AuditSinkSpec {
    /**
     * @return Policy defines the policy for selecting which events should be sent to the webhook required
     * 
     */
    private Policy policy;
    /**
     * @return Webhook to send events required
     * 
     */
    private Webhook webhook;

    private AuditSinkSpec() {}
    /**
     * @return Policy defines the policy for selecting which events should be sent to the webhook required
     * 
     */
    public Policy policy() {
        return this.policy;
    }
    /**
     * @return Webhook to send events required
     * 
     */
    public Webhook webhook() {
        return this.webhook;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AuditSinkSpec defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Policy policy;
        private Webhook webhook;
        public Builder() {}
        public Builder(AuditSinkSpec defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.policy = defaults.policy;
    	      this.webhook = defaults.webhook;
        }

        @CustomType.Setter
        public Builder policy(Policy policy) {
            this.policy = Objects.requireNonNull(policy);
            return this;
        }
        @CustomType.Setter
        public Builder webhook(Webhook webhook) {
            this.webhook = Objects.requireNonNull(webhook);
            return this;
        }
        public AuditSinkSpec build() {
            final var o = new AuditSinkSpec();
            o.policy = policy;
            o.webhook = webhook;
            return o;
        }
    }
}
