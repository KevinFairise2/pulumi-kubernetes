// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.resource.v1alpha2.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * ResourceHandle holds opaque resource data for processing by a specific kubelet plugin.
 * 
 */
public final class ResourceHandleArgs extends com.pulumi.resources.ResourceArgs {

    public static final ResourceHandleArgs Empty = new ResourceHandleArgs();

    /**
     * Data contains the opaque data associated with this ResourceHandle. It is set by the controller component of the resource driver whose name matches the DriverName set in the ResourceClaimStatus this ResourceHandle is embedded in. It is set at allocation time and is intended for processing by the kubelet plugin whose name matches the DriverName set in this ResourceHandle.
     * 
     * The maximum size of this field is 16KiB. This may get increased in the future, but not reduced.
     * 
     */
    @Import(name="data")
    private @Nullable Output<String> data;

    /**
     * @return Data contains the opaque data associated with this ResourceHandle. It is set by the controller component of the resource driver whose name matches the DriverName set in the ResourceClaimStatus this ResourceHandle is embedded in. It is set at allocation time and is intended for processing by the kubelet plugin whose name matches the DriverName set in this ResourceHandle.
     * 
     * The maximum size of this field is 16KiB. This may get increased in the future, but not reduced.
     * 
     */
    public Optional<Output<String>> data() {
        return Optional.ofNullable(this.data);
    }

    /**
     * DriverName specifies the name of the resource driver whose kubelet plugin should be invoked to process this ResourceHandle&#39;s data once it lands on a node. This may differ from the DriverName set in ResourceClaimStatus this ResourceHandle is embedded in.
     * 
     */
    @Import(name="driverName")
    private @Nullable Output<String> driverName;

    /**
     * @return DriverName specifies the name of the resource driver whose kubelet plugin should be invoked to process this ResourceHandle&#39;s data once it lands on a node. This may differ from the DriverName set in ResourceClaimStatus this ResourceHandle is embedded in.
     * 
     */
    public Optional<Output<String>> driverName() {
        return Optional.ofNullable(this.driverName);
    }

    private ResourceHandleArgs() {}

    private ResourceHandleArgs(ResourceHandleArgs $) {
        this.data = $.data;
        this.driverName = $.driverName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(ResourceHandleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private ResourceHandleArgs $;

        public Builder() {
            $ = new ResourceHandleArgs();
        }

        public Builder(ResourceHandleArgs defaults) {
            $ = new ResourceHandleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param data Data contains the opaque data associated with this ResourceHandle. It is set by the controller component of the resource driver whose name matches the DriverName set in the ResourceClaimStatus this ResourceHandle is embedded in. It is set at allocation time and is intended for processing by the kubelet plugin whose name matches the DriverName set in this ResourceHandle.
         * 
         * The maximum size of this field is 16KiB. This may get increased in the future, but not reduced.
         * 
         * @return builder
         * 
         */
        public Builder data(@Nullable Output<String> data) {
            $.data = data;
            return this;
        }

        /**
         * @param data Data contains the opaque data associated with this ResourceHandle. It is set by the controller component of the resource driver whose name matches the DriverName set in the ResourceClaimStatus this ResourceHandle is embedded in. It is set at allocation time and is intended for processing by the kubelet plugin whose name matches the DriverName set in this ResourceHandle.
         * 
         * The maximum size of this field is 16KiB. This may get increased in the future, but not reduced.
         * 
         * @return builder
         * 
         */
        public Builder data(String data) {
            return data(Output.of(data));
        }

        /**
         * @param driverName DriverName specifies the name of the resource driver whose kubelet plugin should be invoked to process this ResourceHandle&#39;s data once it lands on a node. This may differ from the DriverName set in ResourceClaimStatus this ResourceHandle is embedded in.
         * 
         * @return builder
         * 
         */
        public Builder driverName(@Nullable Output<String> driverName) {
            $.driverName = driverName;
            return this;
        }

        /**
         * @param driverName DriverName specifies the name of the resource driver whose kubelet plugin should be invoked to process this ResourceHandle&#39;s data once it lands on a node. This may differ from the DriverName set in ResourceClaimStatus this ResourceHandle is embedded in.
         * 
         * @return builder
         * 
         */
        public Builder driverName(String driverName) {
            return driverName(Output.of(driverName));
        }

        public ResourceHandleArgs build() {
            return $;
        }
    }

}