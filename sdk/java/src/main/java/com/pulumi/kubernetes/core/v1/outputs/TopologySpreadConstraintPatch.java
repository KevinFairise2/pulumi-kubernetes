// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.meta.v1.outputs.LabelSelectorPatch;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class TopologySpreadConstraintPatch {
    /**
     * @return LabelSelector is used to find matching pods. Pods that match this label selector are counted to determine the number of pods in their corresponding topology domain.
     * 
     */
    private @Nullable LabelSelectorPatch labelSelector;
    /**
     * @return MatchLabelKeys is a set of pod label keys to select the pods over which spreading will be calculated. The keys are used to lookup values from the incoming pod labels, those key-value labels are ANDed with labelSelector to select the group of existing pods over which spreading will be calculated for the incoming pod. The same key is forbidden to exist in both MatchLabelKeys and LabelSelector. MatchLabelKeys cannot be set when LabelSelector isn&#39;t set. Keys that don&#39;t exist in the incoming pod labels will be ignored. A null or empty list means only match against labelSelector.
     * 
     * This is a beta field and requires the MatchLabelKeysInPodTopologySpread feature gate to be enabled (enabled by default).
     * 
     */
    private @Nullable List<String> matchLabelKeys;
    /**
     * @return MaxSkew describes the degree to which pods may be unevenly distributed. When `whenUnsatisfiable=DoNotSchedule`, it is the maximum permitted difference between the number of matching pods in the target topology and the global minimum. The global minimum is the minimum number of matching pods in an eligible domain or zero if the number of eligible domains is less than MinDomains. For example, in a 3-zone cluster, MaxSkew is set to 1, and pods with the same labelSelector spread as 2/2/1: In this case, the global minimum is 1. | zone1 | zone2 | zone3 | |  P P  |  P P  |   P   | - if MaxSkew is 1, incoming pod can only be scheduled to zone3 to become 2/2/2; scheduling it onto zone1(zone2) would make the ActualSkew(3-1) on zone1(zone2) violate MaxSkew(1). - if MaxSkew is 2, incoming pod can be scheduled onto any zone. When `whenUnsatisfiable=ScheduleAnyway`, it is used to give higher precedence to topologies that satisfy it. It&#39;s a required field. Default value is 1 and 0 is not allowed.
     * 
     */
    private @Nullable Integer maxSkew;
    /**
     * @return MinDomains indicates a minimum number of eligible domains. When the number of eligible domains with matching topology keys is less than minDomains, Pod Topology Spread treats &#34;global minimum&#34; as 0, and then the calculation of Skew is performed. And when the number of eligible domains with matching topology keys equals or greater than minDomains, this value has no effect on scheduling. As a result, when the number of eligible domains is less than minDomains, scheduler won&#39;t schedule more than maxSkew Pods to those domains. If value is nil, the constraint behaves as if MinDomains is equal to 1. Valid values are integers greater than 0. When value is not nil, WhenUnsatisfiable must be DoNotSchedule.
     * 
     * For example, in a 3-zone cluster, MaxSkew is set to 2, MinDomains is set to 5 and pods with the same labelSelector spread as 2/2/2: | zone1 | zone2 | zone3 | |  P P  |  P P  |  P P  | The number of domains is less than 5(MinDomains), so &#34;global minimum&#34; is treated as 0. In this situation, new pod with the same labelSelector cannot be scheduled, because computed skew will be 3(3 - 0) if new Pod is scheduled to any of the three zones, it will violate MaxSkew.
     * 
     */
    private @Nullable Integer minDomains;
    /**
     * @return NodeAffinityPolicy indicates how we will treat Pod&#39;s nodeAffinity/nodeSelector when calculating pod topology spread skew. Options are: - Honor: only nodes matching nodeAffinity/nodeSelector are included in the calculations. - Ignore: nodeAffinity/nodeSelector are ignored. All nodes are included in the calculations.
     * 
     * If this value is nil, the behavior is equivalent to the Honor policy. This is a beta-level feature default enabled by the NodeInclusionPolicyInPodTopologySpread feature flag.
     * 
     */
    private @Nullable String nodeAffinityPolicy;
    /**
     * @return NodeTaintsPolicy indicates how we will treat node taints when calculating pod topology spread skew. Options are: - Honor: nodes without taints, along with tainted nodes for which the incoming pod has a toleration, are included. - Ignore: node taints are ignored. All nodes are included.
     * 
     * If this value is nil, the behavior is equivalent to the Ignore policy. This is a beta-level feature default enabled by the NodeInclusionPolicyInPodTopologySpread feature flag.
     * 
     */
    private @Nullable String nodeTaintsPolicy;
    /**
     * @return TopologyKey is the key of node labels. Nodes that have a label with this key and identical values are considered to be in the same topology. We consider each &lt;key, value&gt; as a &#34;bucket&#34;, and try to put balanced number of pods into each bucket. We define a domain as a particular instance of a topology. Also, we define an eligible domain as a domain whose nodes meet the requirements of nodeAffinityPolicy and nodeTaintsPolicy. e.g. If TopologyKey is &#34;kubernetes.io/hostname&#34;, each Node is a domain of that topology. And, if TopologyKey is &#34;topology.kubernetes.io/zone&#34;, each zone is a domain of that topology. It&#39;s a required field.
     * 
     */
    private @Nullable String topologyKey;
    /**
     * @return WhenUnsatisfiable indicates how to deal with a pod if it doesn&#39;t satisfy the spread constraint. - DoNotSchedule (default) tells the scheduler not to schedule it. - ScheduleAnyway tells the scheduler to schedule the pod in any location,
     *   but giving higher precedence to topologies that would help reduce the
     *   skew.
     * A constraint is considered &#34;Unsatisfiable&#34; for an incoming pod if and only if every possible node assignment for that pod would violate &#34;MaxSkew&#34; on some topology. For example, in a 3-zone cluster, MaxSkew is set to 1, and pods with the same labelSelector spread as 3/1/1: | zone1 | zone2 | zone3 | | P P P |   P   |   P   | If WhenUnsatisfiable is set to DoNotSchedule, incoming pod can only be scheduled to zone2(zone3) to become 3/2/1(3/1/2) as ActualSkew(2-1) on zone2(zone3) satisfies MaxSkew(1). In other words, the cluster can still be imbalanced, but scheduler won&#39;t make it *more* imbalanced. It&#39;s a required field.
     * 
     */
    private @Nullable String whenUnsatisfiable;

    private TopologySpreadConstraintPatch() {}
    /**
     * @return LabelSelector is used to find matching pods. Pods that match this label selector are counted to determine the number of pods in their corresponding topology domain.
     * 
     */
    public Optional<LabelSelectorPatch> labelSelector() {
        return Optional.ofNullable(this.labelSelector);
    }
    /**
     * @return MatchLabelKeys is a set of pod label keys to select the pods over which spreading will be calculated. The keys are used to lookup values from the incoming pod labels, those key-value labels are ANDed with labelSelector to select the group of existing pods over which spreading will be calculated for the incoming pod. The same key is forbidden to exist in both MatchLabelKeys and LabelSelector. MatchLabelKeys cannot be set when LabelSelector isn&#39;t set. Keys that don&#39;t exist in the incoming pod labels will be ignored. A null or empty list means only match against labelSelector.
     * 
     * This is a beta field and requires the MatchLabelKeysInPodTopologySpread feature gate to be enabled (enabled by default).
     * 
     */
    public List<String> matchLabelKeys() {
        return this.matchLabelKeys == null ? List.of() : this.matchLabelKeys;
    }
    /**
     * @return MaxSkew describes the degree to which pods may be unevenly distributed. When `whenUnsatisfiable=DoNotSchedule`, it is the maximum permitted difference between the number of matching pods in the target topology and the global minimum. The global minimum is the minimum number of matching pods in an eligible domain or zero if the number of eligible domains is less than MinDomains. For example, in a 3-zone cluster, MaxSkew is set to 1, and pods with the same labelSelector spread as 2/2/1: In this case, the global minimum is 1. | zone1 | zone2 | zone3 | |  P P  |  P P  |   P   | - if MaxSkew is 1, incoming pod can only be scheduled to zone3 to become 2/2/2; scheduling it onto zone1(zone2) would make the ActualSkew(3-1) on zone1(zone2) violate MaxSkew(1). - if MaxSkew is 2, incoming pod can be scheduled onto any zone. When `whenUnsatisfiable=ScheduleAnyway`, it is used to give higher precedence to topologies that satisfy it. It&#39;s a required field. Default value is 1 and 0 is not allowed.
     * 
     */
    public Optional<Integer> maxSkew() {
        return Optional.ofNullable(this.maxSkew);
    }
    /**
     * @return MinDomains indicates a minimum number of eligible domains. When the number of eligible domains with matching topology keys is less than minDomains, Pod Topology Spread treats &#34;global minimum&#34; as 0, and then the calculation of Skew is performed. And when the number of eligible domains with matching topology keys equals or greater than minDomains, this value has no effect on scheduling. As a result, when the number of eligible domains is less than minDomains, scheduler won&#39;t schedule more than maxSkew Pods to those domains. If value is nil, the constraint behaves as if MinDomains is equal to 1. Valid values are integers greater than 0. When value is not nil, WhenUnsatisfiable must be DoNotSchedule.
     * 
     * For example, in a 3-zone cluster, MaxSkew is set to 2, MinDomains is set to 5 and pods with the same labelSelector spread as 2/2/2: | zone1 | zone2 | zone3 | |  P P  |  P P  |  P P  | The number of domains is less than 5(MinDomains), so &#34;global minimum&#34; is treated as 0. In this situation, new pod with the same labelSelector cannot be scheduled, because computed skew will be 3(3 - 0) if new Pod is scheduled to any of the three zones, it will violate MaxSkew.
     * 
     */
    public Optional<Integer> minDomains() {
        return Optional.ofNullable(this.minDomains);
    }
    /**
     * @return NodeAffinityPolicy indicates how we will treat Pod&#39;s nodeAffinity/nodeSelector when calculating pod topology spread skew. Options are: - Honor: only nodes matching nodeAffinity/nodeSelector are included in the calculations. - Ignore: nodeAffinity/nodeSelector are ignored. All nodes are included in the calculations.
     * 
     * If this value is nil, the behavior is equivalent to the Honor policy. This is a beta-level feature default enabled by the NodeInclusionPolicyInPodTopologySpread feature flag.
     * 
     */
    public Optional<String> nodeAffinityPolicy() {
        return Optional.ofNullable(this.nodeAffinityPolicy);
    }
    /**
     * @return NodeTaintsPolicy indicates how we will treat node taints when calculating pod topology spread skew. Options are: - Honor: nodes without taints, along with tainted nodes for which the incoming pod has a toleration, are included. - Ignore: node taints are ignored. All nodes are included.
     * 
     * If this value is nil, the behavior is equivalent to the Ignore policy. This is a beta-level feature default enabled by the NodeInclusionPolicyInPodTopologySpread feature flag.
     * 
     */
    public Optional<String> nodeTaintsPolicy() {
        return Optional.ofNullable(this.nodeTaintsPolicy);
    }
    /**
     * @return TopologyKey is the key of node labels. Nodes that have a label with this key and identical values are considered to be in the same topology. We consider each &lt;key, value&gt; as a &#34;bucket&#34;, and try to put balanced number of pods into each bucket. We define a domain as a particular instance of a topology. Also, we define an eligible domain as a domain whose nodes meet the requirements of nodeAffinityPolicy and nodeTaintsPolicy. e.g. If TopologyKey is &#34;kubernetes.io/hostname&#34;, each Node is a domain of that topology. And, if TopologyKey is &#34;topology.kubernetes.io/zone&#34;, each zone is a domain of that topology. It&#39;s a required field.
     * 
     */
    public Optional<String> topologyKey() {
        return Optional.ofNullable(this.topologyKey);
    }
    /**
     * @return WhenUnsatisfiable indicates how to deal with a pod if it doesn&#39;t satisfy the spread constraint. - DoNotSchedule (default) tells the scheduler not to schedule it. - ScheduleAnyway tells the scheduler to schedule the pod in any location,
     *   but giving higher precedence to topologies that would help reduce the
     *   skew.
     * A constraint is considered &#34;Unsatisfiable&#34; for an incoming pod if and only if every possible node assignment for that pod would violate &#34;MaxSkew&#34; on some topology. For example, in a 3-zone cluster, MaxSkew is set to 1, and pods with the same labelSelector spread as 3/1/1: | zone1 | zone2 | zone3 | | P P P |   P   |   P   | If WhenUnsatisfiable is set to DoNotSchedule, incoming pod can only be scheduled to zone2(zone3) to become 3/2/1(3/1/2) as ActualSkew(2-1) on zone2(zone3) satisfies MaxSkew(1). In other words, the cluster can still be imbalanced, but scheduler won&#39;t make it *more* imbalanced. It&#39;s a required field.
     * 
     */
    public Optional<String> whenUnsatisfiable() {
        return Optional.ofNullable(this.whenUnsatisfiable);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(TopologySpreadConstraintPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable LabelSelectorPatch labelSelector;
        private @Nullable List<String> matchLabelKeys;
        private @Nullable Integer maxSkew;
        private @Nullable Integer minDomains;
        private @Nullable String nodeAffinityPolicy;
        private @Nullable String nodeTaintsPolicy;
        private @Nullable String topologyKey;
        private @Nullable String whenUnsatisfiable;
        public Builder() {}
        public Builder(TopologySpreadConstraintPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.labelSelector = defaults.labelSelector;
    	      this.matchLabelKeys = defaults.matchLabelKeys;
    	      this.maxSkew = defaults.maxSkew;
    	      this.minDomains = defaults.minDomains;
    	      this.nodeAffinityPolicy = defaults.nodeAffinityPolicy;
    	      this.nodeTaintsPolicy = defaults.nodeTaintsPolicy;
    	      this.topologyKey = defaults.topologyKey;
    	      this.whenUnsatisfiable = defaults.whenUnsatisfiable;
        }

        @CustomType.Setter
        public Builder labelSelector(@Nullable LabelSelectorPatch labelSelector) {
            this.labelSelector = labelSelector;
            return this;
        }
        @CustomType.Setter
        public Builder matchLabelKeys(@Nullable List<String> matchLabelKeys) {
            this.matchLabelKeys = matchLabelKeys;
            return this;
        }
        public Builder matchLabelKeys(String... matchLabelKeys) {
            return matchLabelKeys(List.of(matchLabelKeys));
        }
        @CustomType.Setter
        public Builder maxSkew(@Nullable Integer maxSkew) {
            this.maxSkew = maxSkew;
            return this;
        }
        @CustomType.Setter
        public Builder minDomains(@Nullable Integer minDomains) {
            this.minDomains = minDomains;
            return this;
        }
        @CustomType.Setter
        public Builder nodeAffinityPolicy(@Nullable String nodeAffinityPolicy) {
            this.nodeAffinityPolicy = nodeAffinityPolicy;
            return this;
        }
        @CustomType.Setter
        public Builder nodeTaintsPolicy(@Nullable String nodeTaintsPolicy) {
            this.nodeTaintsPolicy = nodeTaintsPolicy;
            return this;
        }
        @CustomType.Setter
        public Builder topologyKey(@Nullable String topologyKey) {
            this.topologyKey = topologyKey;
            return this;
        }
        @CustomType.Setter
        public Builder whenUnsatisfiable(@Nullable String whenUnsatisfiable) {
            this.whenUnsatisfiable = whenUnsatisfiable;
            return this;
        }
        public TopologySpreadConstraintPatch build() {
            final var o = new TopologySpreadConstraintPatch();
            o.labelSelector = labelSelector;
            o.matchLabelKeys = matchLabelKeys;
            o.maxSkew = maxSkew;
            o.minDomains = minDomains;
            o.nodeAffinityPolicy = nodeAffinityPolicy;
            o.nodeTaintsPolicy = nodeTaintsPolicy;
            o.topologyKey = topologyKey;
            o.whenUnsatisfiable = whenUnsatisfiable;
            return o;
        }
    }
}
