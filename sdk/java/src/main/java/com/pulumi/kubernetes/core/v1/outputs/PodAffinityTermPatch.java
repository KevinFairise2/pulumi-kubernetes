// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.meta.v1.outputs.LabelSelectorPatch;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class PodAffinityTermPatch {
    /**
     * @return A label query over a set of resources, in this case pods. If it&#39;s null, this PodAffinityTerm matches with no Pods.
     * 
     */
    private @Nullable LabelSelectorPatch labelSelector;
    /**
     * @return MatchLabelKeys is a set of pod label keys to select which pods will be taken into consideration. The keys are used to lookup values from the incoming pod labels, those key-value labels are merged with `labelSelector` as `key in (value)` to select the group of existing pods which pods will be taken into consideration for the incoming pod&#39;s pod (anti) affinity. Keys that don&#39;t exist in the incoming pod labels will be ignored. The default value is empty. The same key is forbidden to exist in both matchLabelKeys and labelSelector. Also, matchLabelKeys cannot be set when labelSelector isn&#39;t set. This is an alpha field and requires enabling MatchLabelKeysInPodAffinity feature gate.
     * 
     */
    private @Nullable List<String> matchLabelKeys;
    /**
     * @return MismatchLabelKeys is a set of pod label keys to select which pods will be taken into consideration. The keys are used to lookup values from the incoming pod labels, those key-value labels are merged with `labelSelector` as `key notin (value)` to select the group of existing pods which pods will be taken into consideration for the incoming pod&#39;s pod (anti) affinity. Keys that don&#39;t exist in the incoming pod labels will be ignored. The default value is empty. The same key is forbidden to exist in both mismatchLabelKeys and labelSelector. Also, mismatchLabelKeys cannot be set when labelSelector isn&#39;t set. This is an alpha field and requires enabling MatchLabelKeysInPodAffinity feature gate.
     * 
     */
    private @Nullable List<String> mismatchLabelKeys;
    /**
     * @return A label query over the set of namespaces that the term applies to. The term is applied to the union of the namespaces selected by this field and the ones listed in the namespaces field. null selector and null or empty namespaces list means &#34;this pod&#39;s namespace&#34;. An empty selector ({}) matches all namespaces.
     * 
     */
    private @Nullable LabelSelectorPatch namespaceSelector;
    /**
     * @return namespaces specifies a static list of namespace names that the term applies to. The term is applied to the union of the namespaces listed in this field and the ones selected by namespaceSelector. null or empty namespaces list and null namespaceSelector means &#34;this pod&#39;s namespace&#34;.
     * 
     */
    private @Nullable List<String> namespaces;
    /**
     * @return This pod should be co-located (affinity) or not co-located (anti-affinity) with the pods matching the labelSelector in the specified namespaces, where co-located is defined as running on a node whose value of the label with key topologyKey matches that of any node on which any of the selected pods is running. Empty topologyKey is not allowed.
     * 
     */
    private @Nullable String topologyKey;

    private PodAffinityTermPatch() {}
    /**
     * @return A label query over a set of resources, in this case pods. If it&#39;s null, this PodAffinityTerm matches with no Pods.
     * 
     */
    public Optional<LabelSelectorPatch> labelSelector() {
        return Optional.ofNullable(this.labelSelector);
    }
    /**
     * @return MatchLabelKeys is a set of pod label keys to select which pods will be taken into consideration. The keys are used to lookup values from the incoming pod labels, those key-value labels are merged with `labelSelector` as `key in (value)` to select the group of existing pods which pods will be taken into consideration for the incoming pod&#39;s pod (anti) affinity. Keys that don&#39;t exist in the incoming pod labels will be ignored. The default value is empty. The same key is forbidden to exist in both matchLabelKeys and labelSelector. Also, matchLabelKeys cannot be set when labelSelector isn&#39;t set. This is an alpha field and requires enabling MatchLabelKeysInPodAffinity feature gate.
     * 
     */
    public List<String> matchLabelKeys() {
        return this.matchLabelKeys == null ? List.of() : this.matchLabelKeys;
    }
    /**
     * @return MismatchLabelKeys is a set of pod label keys to select which pods will be taken into consideration. The keys are used to lookup values from the incoming pod labels, those key-value labels are merged with `labelSelector` as `key notin (value)` to select the group of existing pods which pods will be taken into consideration for the incoming pod&#39;s pod (anti) affinity. Keys that don&#39;t exist in the incoming pod labels will be ignored. The default value is empty. The same key is forbidden to exist in both mismatchLabelKeys and labelSelector. Also, mismatchLabelKeys cannot be set when labelSelector isn&#39;t set. This is an alpha field and requires enabling MatchLabelKeysInPodAffinity feature gate.
     * 
     */
    public List<String> mismatchLabelKeys() {
        return this.mismatchLabelKeys == null ? List.of() : this.mismatchLabelKeys;
    }
    /**
     * @return A label query over the set of namespaces that the term applies to. The term is applied to the union of the namespaces selected by this field and the ones listed in the namespaces field. null selector and null or empty namespaces list means &#34;this pod&#39;s namespace&#34;. An empty selector ({}) matches all namespaces.
     * 
     */
    public Optional<LabelSelectorPatch> namespaceSelector() {
        return Optional.ofNullable(this.namespaceSelector);
    }
    /**
     * @return namespaces specifies a static list of namespace names that the term applies to. The term is applied to the union of the namespaces listed in this field and the ones selected by namespaceSelector. null or empty namespaces list and null namespaceSelector means &#34;this pod&#39;s namespace&#34;.
     * 
     */
    public List<String> namespaces() {
        return this.namespaces == null ? List.of() : this.namespaces;
    }
    /**
     * @return This pod should be co-located (affinity) or not co-located (anti-affinity) with the pods matching the labelSelector in the specified namespaces, where co-located is defined as running on a node whose value of the label with key topologyKey matches that of any node on which any of the selected pods is running. Empty topologyKey is not allowed.
     * 
     */
    public Optional<String> topologyKey() {
        return Optional.ofNullable(this.topologyKey);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PodAffinityTermPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable LabelSelectorPatch labelSelector;
        private @Nullable List<String> matchLabelKeys;
        private @Nullable List<String> mismatchLabelKeys;
        private @Nullable LabelSelectorPatch namespaceSelector;
        private @Nullable List<String> namespaces;
        private @Nullable String topologyKey;
        public Builder() {}
        public Builder(PodAffinityTermPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.labelSelector = defaults.labelSelector;
    	      this.matchLabelKeys = defaults.matchLabelKeys;
    	      this.mismatchLabelKeys = defaults.mismatchLabelKeys;
    	      this.namespaceSelector = defaults.namespaceSelector;
    	      this.namespaces = defaults.namespaces;
    	      this.topologyKey = defaults.topologyKey;
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
        public Builder mismatchLabelKeys(@Nullable List<String> mismatchLabelKeys) {
            this.mismatchLabelKeys = mismatchLabelKeys;
            return this;
        }
        public Builder mismatchLabelKeys(String... mismatchLabelKeys) {
            return mismatchLabelKeys(List.of(mismatchLabelKeys));
        }
        @CustomType.Setter
        public Builder namespaceSelector(@Nullable LabelSelectorPatch namespaceSelector) {
            this.namespaceSelector = namespaceSelector;
            return this;
        }
        @CustomType.Setter
        public Builder namespaces(@Nullable List<String> namespaces) {
            this.namespaces = namespaces;
            return this;
        }
        public Builder namespaces(String... namespaces) {
            return namespaces(List.of(namespaces));
        }
        @CustomType.Setter
        public Builder topologyKey(@Nullable String topologyKey) {
            this.topologyKey = topologyKey;
            return this;
        }
        public PodAffinityTermPatch build() {
            final var o = new PodAffinityTermPatch();
            o.labelSelector = labelSelector;
            o.matchLabelKeys = matchLabelKeys;
            o.mismatchLabelKeys = mismatchLabelKeys;
            o.namespaceSelector = namespaceSelector;
            o.namespaces = namespaces;
            o.topologyKey = topologyKey;
            return o;
        }
    }
}
