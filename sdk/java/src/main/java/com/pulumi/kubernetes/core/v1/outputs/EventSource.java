// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class EventSource {
    /**
     * @return Component from which the event is generated.
     * 
     */
    private @Nullable String component;
    /**
     * @return Node name on which the event is generated.
     * 
     */
    private @Nullable String host;

    private EventSource() {}
    /**
     * @return Component from which the event is generated.
     * 
     */
    public Optional<String> component() {
        return Optional.ofNullable(this.component);
    }
    /**
     * @return Node name on which the event is generated.
     * 
     */
    public Optional<String> host() {
        return Optional.ofNullable(this.host);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(EventSource defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String component;
        private @Nullable String host;
        public Builder() {}
        public Builder(EventSource defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.component = defaults.component;
    	      this.host = defaults.host;
        }

        @CustomType.Setter
        public Builder component(@Nullable String component) {
            this.component = component;
            return this;
        }
        @CustomType.Setter
        public Builder host(@Nullable String host) {
            this.host = host;
            return this;
        }
        public EventSource build() {
            final var o = new EventSource();
            o.component = component;
            o.host = host;
            return o;
        }
    }
}