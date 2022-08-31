// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.apps.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.apps.v1.outputs.DaemonSetUpdateStrategyPatch;
import com.pulumi.kubernetes.core.v1.outputs.PodTemplateSpecPatch;
import com.pulumi.kubernetes.meta.v1.outputs.LabelSelectorPatch;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DaemonSetSpecPatch {
    /**
     * @return The minimum number of seconds for which a newly created DaemonSet pod should be ready without any of its container crashing, for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready).
     * 
     */
    private @Nullable Integer minReadySeconds;
    /**
     * @return The number of old history to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     * 
     */
    private @Nullable Integer revisionHistoryLimit;
    /**
     * @return A label query over pods that are managed by the daemon set. Must match in order to be controlled. It must match the pod template&#39;s labels. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/#label-selectors
     * 
     */
    private @Nullable LabelSelectorPatch selector;
    /**
     * @return An object that describes the pod that will be created. The DaemonSet will create exactly one copy of this pod on every node that matches the template&#39;s node selector (or on every node if no node selector is specified). More info: https://kubernetes.io/docs/concepts/workloads/controllers/replicationcontroller#pod-template
     * 
     */
    private @Nullable PodTemplateSpecPatch template;
    /**
     * @return An update strategy to replace existing DaemonSet pods with new pods.
     * 
     */
    private @Nullable DaemonSetUpdateStrategyPatch updateStrategy;

    private DaemonSetSpecPatch() {}
    /**
     * @return The minimum number of seconds for which a newly created DaemonSet pod should be ready without any of its container crashing, for it to be considered available. Defaults to 0 (pod will be considered available as soon as it is ready).
     * 
     */
    public Optional<Integer> minReadySeconds() {
        return Optional.ofNullable(this.minReadySeconds);
    }
    /**
     * @return The number of old history to retain to allow rollback. This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     * 
     */
    public Optional<Integer> revisionHistoryLimit() {
        return Optional.ofNullable(this.revisionHistoryLimit);
    }
    /**
     * @return A label query over pods that are managed by the daemon set. Must match in order to be controlled. It must match the pod template&#39;s labels. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/labels/#label-selectors
     * 
     */
    public Optional<LabelSelectorPatch> selector() {
        return Optional.ofNullable(this.selector);
    }
    /**
     * @return An object that describes the pod that will be created. The DaemonSet will create exactly one copy of this pod on every node that matches the template&#39;s node selector (or on every node if no node selector is specified). More info: https://kubernetes.io/docs/concepts/workloads/controllers/replicationcontroller#pod-template
     * 
     */
    public Optional<PodTemplateSpecPatch> template() {
        return Optional.ofNullable(this.template);
    }
    /**
     * @return An update strategy to replace existing DaemonSet pods with new pods.
     * 
     */
    public Optional<DaemonSetUpdateStrategyPatch> updateStrategy() {
        return Optional.ofNullable(this.updateStrategy);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DaemonSetSpecPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer minReadySeconds;
        private @Nullable Integer revisionHistoryLimit;
        private @Nullable LabelSelectorPatch selector;
        private @Nullable PodTemplateSpecPatch template;
        private @Nullable DaemonSetUpdateStrategyPatch updateStrategy;
        public Builder() {}
        public Builder(DaemonSetSpecPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.minReadySeconds = defaults.minReadySeconds;
    	      this.revisionHistoryLimit = defaults.revisionHistoryLimit;
    	      this.selector = defaults.selector;
    	      this.template = defaults.template;
    	      this.updateStrategy = defaults.updateStrategy;
        }

        @CustomType.Setter
        public Builder minReadySeconds(@Nullable Integer minReadySeconds) {
            this.minReadySeconds = minReadySeconds;
            return this;
        }
        @CustomType.Setter
        public Builder revisionHistoryLimit(@Nullable Integer revisionHistoryLimit) {
            this.revisionHistoryLimit = revisionHistoryLimit;
            return this;
        }
        @CustomType.Setter
        public Builder selector(@Nullable LabelSelectorPatch selector) {
            this.selector = selector;
            return this;
        }
        @CustomType.Setter
        public Builder template(@Nullable PodTemplateSpecPatch template) {
            this.template = template;
            return this;
        }
        @CustomType.Setter
        public Builder updateStrategy(@Nullable DaemonSetUpdateStrategyPatch updateStrategy) {
            this.updateStrategy = updateStrategy;
            return this;
        }
        public DaemonSetSpecPatch build() {
            final var o = new DaemonSetSpecPatch();
            o.minReadySeconds = minReadySeconds;
            o.revisionHistoryLimit = revisionHistoryLimit;
            o.selector = selector;
            o.template = template;
            o.updateStrategy = updateStrategy;
            return o;
        }
    }
}