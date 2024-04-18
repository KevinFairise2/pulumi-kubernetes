// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.kubernetes.resource.v1alpha2.inputs.NamedResourcesInstanceArgs;
import java.util.List;
import java.util.Objects;


/**
 * NamedResourcesResources is used in ResourceModel.
 * 
 */
public final class NamedResourcesResourcesArgs extends com.pulumi.resources.ResourceArgs {

    public static final NamedResourcesResourcesArgs Empty = new NamedResourcesResourcesArgs();

    /**
     * The list of all individual resources instances currently available.
     * 
     */
    @Import(name="instances", required=true)
    private Output<List<NamedResourcesInstanceArgs>> instances;

    /**
     * @return The list of all individual resources instances currently available.
     * 
     */
    public Output<List<NamedResourcesInstanceArgs>> instances() {
        return this.instances;
    }

    private NamedResourcesResourcesArgs() {}

    private NamedResourcesResourcesArgs(NamedResourcesResourcesArgs $) {
        this.instances = $.instances;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(NamedResourcesResourcesArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private NamedResourcesResourcesArgs $;

        public Builder() {
            $ = new NamedResourcesResourcesArgs();
        }

        public Builder(NamedResourcesResourcesArgs defaults) {
            $ = new NamedResourcesResourcesArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param instances The list of all individual resources instances currently available.
         * 
         * @return builder
         * 
         */
        public Builder instances(Output<List<NamedResourcesInstanceArgs>> instances) {
            $.instances = instances;
            return this;
        }

        /**
         * @param instances The list of all individual resources instances currently available.
         * 
         * @return builder
         * 
         */
        public Builder instances(List<NamedResourcesInstanceArgs> instances) {
            return instances(Output.of(instances));
        }

        /**
         * @param instances The list of all individual resources instances currently available.
         * 
         * @return builder
         * 
         */
        public Builder instances(NamedResourcesInstanceArgs... instances) {
            return instances(List.of(instances));
        }

        public NamedResourcesResourcesArgs build() {
            $.instances = Objects.requireNonNull($.instances, "expected parameter 'instances' to be non-null");
            return $;
        }
    }

}