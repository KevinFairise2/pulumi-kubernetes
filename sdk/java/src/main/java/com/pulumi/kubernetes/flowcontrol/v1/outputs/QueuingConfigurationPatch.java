// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.flowcontrol.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Integer;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class QueuingConfigurationPatch {
    /**
     * @return `handSize` is a small positive number that configures the shuffle sharding of requests into queues.  When enqueuing a request at this priority level the request&#39;s flow identifier (a string pair) is hashed and the hash value is used to shuffle the list of queues and deal a hand of the size specified here.  The request is put into one of the shortest queues in that hand. `handSize` must be no larger than `queues`, and should be significantly smaller (so that a few heavy flows do not saturate most of the queues).  See the user-facing documentation for more extensive guidance on setting this field.  This field has a default value of 8.
     * 
     */
    private @Nullable Integer handSize;
    /**
     * @return `queueLengthLimit` is the maximum number of requests allowed to be waiting in a given queue of this priority level at a time; excess requests are rejected.  This value must be positive.  If not specified, it will be defaulted to 50.
     * 
     */
    private @Nullable Integer queueLengthLimit;
    /**
     * @return `queues` is the number of queues for this priority level. The queues exist independently at each apiserver. The value must be positive.  Setting it to 1 effectively precludes shufflesharding and thus makes the distinguisher method of associated flow schemas irrelevant.  This field has a default value of 64.
     * 
     */
    private @Nullable Integer queues;

    private QueuingConfigurationPatch() {}
    /**
     * @return `handSize` is a small positive number that configures the shuffle sharding of requests into queues.  When enqueuing a request at this priority level the request&#39;s flow identifier (a string pair) is hashed and the hash value is used to shuffle the list of queues and deal a hand of the size specified here.  The request is put into one of the shortest queues in that hand. `handSize` must be no larger than `queues`, and should be significantly smaller (so that a few heavy flows do not saturate most of the queues).  See the user-facing documentation for more extensive guidance on setting this field.  This field has a default value of 8.
     * 
     */
    public Optional<Integer> handSize() {
        return Optional.ofNullable(this.handSize);
    }
    /**
     * @return `queueLengthLimit` is the maximum number of requests allowed to be waiting in a given queue of this priority level at a time; excess requests are rejected.  This value must be positive.  If not specified, it will be defaulted to 50.
     * 
     */
    public Optional<Integer> queueLengthLimit() {
        return Optional.ofNullable(this.queueLengthLimit);
    }
    /**
     * @return `queues` is the number of queues for this priority level. The queues exist independently at each apiserver. The value must be positive.  Setting it to 1 effectively precludes shufflesharding and thus makes the distinguisher method of associated flow schemas irrelevant.  This field has a default value of 64.
     * 
     */
    public Optional<Integer> queues() {
        return Optional.ofNullable(this.queues);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(QueuingConfigurationPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Integer handSize;
        private @Nullable Integer queueLengthLimit;
        private @Nullable Integer queues;
        public Builder() {}
        public Builder(QueuingConfigurationPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.handSize = defaults.handSize;
    	      this.queueLengthLimit = defaults.queueLengthLimit;
    	      this.queues = defaults.queues;
        }

        @CustomType.Setter
        public Builder handSize(@Nullable Integer handSize) {
            this.handSize = handSize;
            return this;
        }
        @CustomType.Setter
        public Builder queueLengthLimit(@Nullable Integer queueLengthLimit) {
            this.queueLengthLimit = queueLengthLimit;
            return this;
        }
        @CustomType.Setter
        public Builder queues(@Nullable Integer queues) {
            this.queues = queues;
            return this;
        }
        public QueuingConfigurationPatch build() {
            final var o = new QueuingConfigurationPatch();
            o.handSize = handSize;
            o.queueLengthLimit = queueLengthLimit;
            o.queues = queues;
            return o;
        }
    }
}