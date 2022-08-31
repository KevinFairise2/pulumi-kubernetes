// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.networking.v1.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.kubernetes.meta.v1.inputs.LabelSelectorArgs;
import com.pulumi.kubernetes.networking.v1.inputs.NetworkPolicyEgressRuleArgs;
import com.pulumi.kubernetes.networking.v1.inputs.NetworkPolicyIngressRuleArgs;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * NetworkPolicySpec provides the specification of a NetworkPolicy
 * 
 */
public final class NetworkPolicySpecArgs extends com.pulumi.resources.ResourceArgs {

    public static final NetworkPolicySpecArgs Empty = new NetworkPolicySpecArgs();

    /**
     * List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects are isolated by default). This field is beta-level in 1.8
     * 
     */
    @Import(name="egress")
    private @Nullable Output<List<NetworkPolicyEgressRuleArgs>> egress;

    /**
     * @return List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects are isolated by default). This field is beta-level in 1.8
     * 
     */
    public Optional<Output<List<NetworkPolicyEgressRuleArgs>>> egress() {
        return Optional.ofNullable(this.egress);
    }

    /**
     * List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is the pod&#39;s local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and serves solely to ensure that the pods it selects are isolated by default)
     * 
     */
    @Import(name="ingress")
    private @Nullable Output<List<NetworkPolicyIngressRuleArgs>> ingress;

    /**
     * @return List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is the pod&#39;s local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and serves solely to ensure that the pods it selects are isolated by default)
     * 
     */
    public Optional<Output<List<NetworkPolicyIngressRuleArgs>>> ingress() {
        return Optional.ofNullable(this.ingress);
    }

    /**
     * Selects the pods to which this NetworkPolicy object applies. The array of ingress rules is applied to any pods selected by this field. Multiple network policies can select the same set of pods. In this case, the ingress rules for each are combined additively. This field is NOT optional and follows standard label selector semantics. An empty podSelector matches all pods in this namespace.
     * 
     */
    @Import(name="podSelector", required=true)
    private Output<LabelSelectorArgs> podSelector;

    /**
     * @return Selects the pods to which this NetworkPolicy object applies. The array of ingress rules is applied to any pods selected by this field. Multiple network policies can select the same set of pods. In this case, the ingress rules for each are combined additively. This field is NOT optional and follows standard label selector semantics. An empty podSelector matches all pods in this namespace.
     * 
     */
    public Output<LabelSelectorArgs> podSelector() {
        return this.podSelector;
    }

    /**
     * List of rule types that the NetworkPolicy relates to. Valid options are [&#34;Ingress&#34;], [&#34;Egress&#34;], or [&#34;Ingress&#34;, &#34;Egress&#34;]. If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify policyTypes [ &#34;Egress&#34; ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you must specify a policyTypes value that include &#34;Egress&#34; (since such a policy would not include an Egress section and would otherwise default to just [ &#34;Ingress&#34; ]). This field is beta-level in 1.8
     * 
     */
    @Import(name="policyTypes")
    private @Nullable Output<List<String>> policyTypes;

    /**
     * @return List of rule types that the NetworkPolicy relates to. Valid options are [&#34;Ingress&#34;], [&#34;Egress&#34;], or [&#34;Ingress&#34;, &#34;Egress&#34;]. If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify policyTypes [ &#34;Egress&#34; ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you must specify a policyTypes value that include &#34;Egress&#34; (since such a policy would not include an Egress section and would otherwise default to just [ &#34;Ingress&#34; ]). This field is beta-level in 1.8
     * 
     */
    public Optional<Output<List<String>>> policyTypes() {
        return Optional.ofNullable(this.policyTypes);
    }

    private NetworkPolicySpecArgs() {}

    private NetworkPolicySpecArgs(NetworkPolicySpecArgs $) {
        this.egress = $.egress;
        this.ingress = $.ingress;
        this.podSelector = $.podSelector;
        this.policyTypes = $.policyTypes;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NetworkPolicySpecArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NetworkPolicySpecArgs $;

        public Builder() {
            $ = new NetworkPolicySpecArgs();
        }

        public Builder(NetworkPolicySpecArgs defaults) {
            $ = new NetworkPolicySpecArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param egress List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects are isolated by default). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder egress(@Nullable Output<List<NetworkPolicyEgressRuleArgs>> egress) {
            $.egress = egress;
            return this;
        }

        /**
         * @param egress List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects are isolated by default). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder egress(List<NetworkPolicyEgressRuleArgs> egress) {
            return egress(Output.of(egress));
        }

        /**
         * @param egress List of egress rules to be applied to the selected pods. Outgoing traffic is allowed if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic matches at least one egress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy limits all outgoing traffic (and serves solely to ensure that the pods it selects are isolated by default). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder egress(NetworkPolicyEgressRuleArgs... egress) {
            return egress(List.of(egress));
        }

        /**
         * @param ingress List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is the pod&#39;s local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and serves solely to ensure that the pods it selects are isolated by default)
         * 
         * @return builder
         * 
         */
        public Builder ingress(@Nullable Output<List<NetworkPolicyIngressRuleArgs>> ingress) {
            $.ingress = ingress;
            return this;
        }

        /**
         * @param ingress List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is the pod&#39;s local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and serves solely to ensure that the pods it selects are isolated by default)
         * 
         * @return builder
         * 
         */
        public Builder ingress(List<NetworkPolicyIngressRuleArgs> ingress) {
            return ingress(Output.of(ingress));
        }

        /**
         * @param ingress List of ingress rules to be applied to the selected pods. Traffic is allowed to a pod if there are no NetworkPolicies selecting the pod (and cluster policy otherwise allows the traffic), OR if the traffic source is the pod&#39;s local node, OR if the traffic matches at least one ingress rule across all of the NetworkPolicy objects whose podSelector matches the pod. If this field is empty then this NetworkPolicy does not allow any traffic (and serves solely to ensure that the pods it selects are isolated by default)
         * 
         * @return builder
         * 
         */
        public Builder ingress(NetworkPolicyIngressRuleArgs... ingress) {
            return ingress(List.of(ingress));
        }

        /**
         * @param podSelector Selects the pods to which this NetworkPolicy object applies. The array of ingress rules is applied to any pods selected by this field. Multiple network policies can select the same set of pods. In this case, the ingress rules for each are combined additively. This field is NOT optional and follows standard label selector semantics. An empty podSelector matches all pods in this namespace.
         * 
         * @return builder
         * 
         */
        public Builder podSelector(Output<LabelSelectorArgs> podSelector) {
            $.podSelector = podSelector;
            return this;
        }

        /**
         * @param podSelector Selects the pods to which this NetworkPolicy object applies. The array of ingress rules is applied to any pods selected by this field. Multiple network policies can select the same set of pods. In this case, the ingress rules for each are combined additively. This field is NOT optional and follows standard label selector semantics. An empty podSelector matches all pods in this namespace.
         * 
         * @return builder
         * 
         */
        public Builder podSelector(LabelSelectorArgs podSelector) {
            return podSelector(Output.of(podSelector));
        }

        /**
         * @param policyTypes List of rule types that the NetworkPolicy relates to. Valid options are [&#34;Ingress&#34;], [&#34;Egress&#34;], or [&#34;Ingress&#34;, &#34;Egress&#34;]. If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify policyTypes [ &#34;Egress&#34; ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you must specify a policyTypes value that include &#34;Egress&#34; (since such a policy would not include an Egress section and would otherwise default to just [ &#34;Ingress&#34; ]). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder policyTypes(@Nullable Output<List<String>> policyTypes) {
            $.policyTypes = policyTypes;
            return this;
        }

        /**
         * @param policyTypes List of rule types that the NetworkPolicy relates to. Valid options are [&#34;Ingress&#34;], [&#34;Egress&#34;], or [&#34;Ingress&#34;, &#34;Egress&#34;]. If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify policyTypes [ &#34;Egress&#34; ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you must specify a policyTypes value that include &#34;Egress&#34; (since such a policy would not include an Egress section and would otherwise default to just [ &#34;Ingress&#34; ]). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder policyTypes(List<String> policyTypes) {
            return policyTypes(Output.of(policyTypes));
        }

        /**
         * @param policyTypes List of rule types that the NetworkPolicy relates to. Valid options are [&#34;Ingress&#34;], [&#34;Egress&#34;], or [&#34;Ingress&#34;, &#34;Egress&#34;]. If this field is not specified, it will default based on the existence of Ingress or Egress rules; policies that contain an Egress section are assumed to affect Egress, and all policies (whether or not they contain an Ingress section) are assumed to affect Ingress. If you want to write an egress-only policy, you must explicitly specify policyTypes [ &#34;Egress&#34; ]. Likewise, if you want to write a policy that specifies that no egress is allowed, you must specify a policyTypes value that include &#34;Egress&#34; (since such a policy would not include an Egress section and would otherwise default to just [ &#34;Ingress&#34; ]). This field is beta-level in 1.8
         * 
         * @return builder
         * 
         */
        public Builder policyTypes(String... policyTypes) {
            return policyTypes(List.of(policyTypes));
        }

        public NetworkPolicySpecArgs build() {
            $.podSelector = Objects.requireNonNull($.podSelector, "expected parameter 'podSelector' to be non-null");
            return $;
        }
    }

}