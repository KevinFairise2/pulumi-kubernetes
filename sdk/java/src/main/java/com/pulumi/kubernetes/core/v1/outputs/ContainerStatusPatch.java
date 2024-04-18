// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.kubernetes.core.v1.outputs.ContainerStatePatch;
import com.pulumi.kubernetes.core.v1.outputs.ResourceRequirementsPatch;
import com.pulumi.kubernetes.core.v1.outputs.VolumeMountStatusPatch;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class ContainerStatusPatch {
    /**
     * @return AllocatedResources represents the compute resources allocated for this container by the node. Kubelet sets this value to Container.Resources.Requests upon successful pod admission and after successfully admitting desired pod resize.
     * 
     */
    private @Nullable Map<String,String> allocatedResources;
    /**
     * @return ContainerID is the ID of the container in the format &#39;&lt;type&gt;://&lt;container_id&gt;&#39;. Where type is a container runtime identifier, returned from Version call of CRI API (for example &#34;containerd&#34;).
     * 
     */
    private @Nullable String containerID;
    /**
     * @return Image is the name of container image that the container is running. The container image may not match the image used in the PodSpec, as it may have been resolved by the runtime. More info: https://kubernetes.io/docs/concepts/containers/images.
     * 
     */
    private @Nullable String image;
    /**
     * @return ImageID is the image ID of the container&#39;s image. The image ID may not match the image ID of the image used in the PodSpec, as it may have been resolved by the runtime.
     * 
     */
    private @Nullable String imageID;
    /**
     * @return LastTerminationState holds the last termination state of the container to help debug container crashes and restarts. This field is not populated if the container is still running and RestartCount is 0.
     * 
     */
    private @Nullable ContainerStatePatch lastState;
    /**
     * @return Name is a DNS_LABEL representing the unique name of the container. Each container in a pod must have a unique name across all container types. Cannot be updated.
     * 
     */
    private @Nullable String name;
    /**
     * @return Ready specifies whether the container is currently passing its readiness check. The value will change as readiness probes keep executing. If no readiness probes are specified, this field defaults to true once the container is fully started (see Started field).
     * 
     * The value is typically used to determine whether a container is ready to accept traffic.
     * 
     */
    private @Nullable Boolean ready;
    /**
     * @return Resources represents the compute resource requests and limits that have been successfully enacted on the running container after it has been started or has been successfully resized.
     * 
     */
    private @Nullable ResourceRequirementsPatch resources;
    /**
     * @return RestartCount holds the number of times the container has been restarted. Kubelet makes an effort to always increment the value, but there are cases when the state may be lost due to node restarts and then the value may be reset to 0. The value is never negative.
     * 
     */
    private @Nullable Integer restartCount;
    /**
     * @return Started indicates whether the container has finished its postStart lifecycle hook and passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. In both cases, startup probes will run again. Is always true when no startupProbe is defined and container is running and has passed the postStart lifecycle hook. The null value must be treated the same as false.
     * 
     */
    private @Nullable Boolean started;
    /**
     * @return State holds details about the container&#39;s current condition.
     * 
     */
    private @Nullable ContainerStatePatch state;
    /**
     * @return Status of volume mounts.
     * 
     */
    private @Nullable List<VolumeMountStatusPatch> volumeMounts;

    private ContainerStatusPatch() {}
    /**
     * @return AllocatedResources represents the compute resources allocated for this container by the node. Kubelet sets this value to Container.Resources.Requests upon successful pod admission and after successfully admitting desired pod resize.
     * 
     */
    public Map<String,String> allocatedResources() {
        return this.allocatedResources == null ? Map.of() : this.allocatedResources;
    }
    /**
     * @return ContainerID is the ID of the container in the format &#39;&lt;type&gt;://&lt;container_id&gt;&#39;. Where type is a container runtime identifier, returned from Version call of CRI API (for example &#34;containerd&#34;).
     * 
     */
    public Optional<String> containerID() {
        return Optional.ofNullable(this.containerID);
    }
    /**
     * @return Image is the name of container image that the container is running. The container image may not match the image used in the PodSpec, as it may have been resolved by the runtime. More info: https://kubernetes.io/docs/concepts/containers/images.
     * 
     */
    public Optional<String> image() {
        return Optional.ofNullable(this.image);
    }
    /**
     * @return ImageID is the image ID of the container&#39;s image. The image ID may not match the image ID of the image used in the PodSpec, as it may have been resolved by the runtime.
     * 
     */
    public Optional<String> imageID() {
        return Optional.ofNullable(this.imageID);
    }
    /**
     * @return LastTerminationState holds the last termination state of the container to help debug container crashes and restarts. This field is not populated if the container is still running and RestartCount is 0.
     * 
     */
    public Optional<ContainerStatePatch> lastState() {
        return Optional.ofNullable(this.lastState);
    }
    /**
     * @return Name is a DNS_LABEL representing the unique name of the container. Each container in a pod must have a unique name across all container types. Cannot be updated.
     * 
     */
    public Optional<String> name() {
        return Optional.ofNullable(this.name);
    }
    /**
     * @return Ready specifies whether the container is currently passing its readiness check. The value will change as readiness probes keep executing. If no readiness probes are specified, this field defaults to true once the container is fully started (see Started field).
     * 
     * The value is typically used to determine whether a container is ready to accept traffic.
     * 
     */
    public Optional<Boolean> ready() {
        return Optional.ofNullable(this.ready);
    }
    /**
     * @return Resources represents the compute resource requests and limits that have been successfully enacted on the running container after it has been started or has been successfully resized.
     * 
     */
    public Optional<ResourceRequirementsPatch> resources() {
        return Optional.ofNullable(this.resources);
    }
    /**
     * @return RestartCount holds the number of times the container has been restarted. Kubelet makes an effort to always increment the value, but there are cases when the state may be lost due to node restarts and then the value may be reset to 0. The value is never negative.
     * 
     */
    public Optional<Integer> restartCount() {
        return Optional.ofNullable(this.restartCount);
    }
    /**
     * @return Started indicates whether the container has finished its postStart lifecycle hook and passed its startup probe. Initialized as false, becomes true after startupProbe is considered successful. Resets to false when the container is restarted, or if kubelet loses state temporarily. In both cases, startup probes will run again. Is always true when no startupProbe is defined and container is running and has passed the postStart lifecycle hook. The null value must be treated the same as false.
     * 
     */
    public Optional<Boolean> started() {
        return Optional.ofNullable(this.started);
    }
    /**
     * @return State holds details about the container&#39;s current condition.
     * 
     */
    public Optional<ContainerStatePatch> state() {
        return Optional.ofNullable(this.state);
    }
    /**
     * @return Status of volume mounts.
     * 
     */
    public List<VolumeMountStatusPatch> volumeMounts() {
        return this.volumeMounts == null ? List.of() : this.volumeMounts;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ContainerStatusPatch defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Map<String,String> allocatedResources;
        private @Nullable String containerID;
        private @Nullable String image;
        private @Nullable String imageID;
        private @Nullable ContainerStatePatch lastState;
        private @Nullable String name;
        private @Nullable Boolean ready;
        private @Nullable ResourceRequirementsPatch resources;
        private @Nullable Integer restartCount;
        private @Nullable Boolean started;
        private @Nullable ContainerStatePatch state;
        private @Nullable List<VolumeMountStatusPatch> volumeMounts;
        public Builder() {}
        public Builder(ContainerStatusPatch defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.allocatedResources = defaults.allocatedResources;
    	      this.containerID = defaults.containerID;
    	      this.image = defaults.image;
    	      this.imageID = defaults.imageID;
    	      this.lastState = defaults.lastState;
    	      this.name = defaults.name;
    	      this.ready = defaults.ready;
    	      this.resources = defaults.resources;
    	      this.restartCount = defaults.restartCount;
    	      this.started = defaults.started;
    	      this.state = defaults.state;
    	      this.volumeMounts = defaults.volumeMounts;
        }

        @CustomType.Setter
        public Builder allocatedResources(@Nullable Map<String,String> allocatedResources) {
            this.allocatedResources = allocatedResources;
            return this;
        }
        @CustomType.Setter
        public Builder containerID(@Nullable String containerID) {
            this.containerID = containerID;
            return this;
        }
        @CustomType.Setter
        public Builder image(@Nullable String image) {
            this.image = image;
            return this;
        }
        @CustomType.Setter
        public Builder imageID(@Nullable String imageID) {
            this.imageID = imageID;
            return this;
        }
        @CustomType.Setter
        public Builder lastState(@Nullable ContainerStatePatch lastState) {
            this.lastState = lastState;
            return this;
        }
        @CustomType.Setter
        public Builder name(@Nullable String name) {
            this.name = name;
            return this;
        }
        @CustomType.Setter
        public Builder ready(@Nullable Boolean ready) {
            this.ready = ready;
            return this;
        }
        @CustomType.Setter
        public Builder resources(@Nullable ResourceRequirementsPatch resources) {
            this.resources = resources;
            return this;
        }
        @CustomType.Setter
        public Builder restartCount(@Nullable Integer restartCount) {
            this.restartCount = restartCount;
            return this;
        }
        @CustomType.Setter
        public Builder started(@Nullable Boolean started) {
            this.started = started;
            return this;
        }
        @CustomType.Setter
        public Builder state(@Nullable ContainerStatePatch state) {
            this.state = state;
            return this;
        }
        @CustomType.Setter
        public Builder volumeMounts(@Nullable List<VolumeMountStatusPatch> volumeMounts) {
            this.volumeMounts = volumeMounts;
            return this;
        }
        public Builder volumeMounts(VolumeMountStatusPatch... volumeMounts) {
            return volumeMounts(List.of(volumeMounts));
        }
        public ContainerStatusPatch build() {
            final var o = new ContainerStatusPatch();
            o.allocatedResources = allocatedResources;
            o.containerID = containerID;
            o.image = image;
            o.imageID = imageID;
            o.lastState = lastState;
            o.name = name;
            o.ready = ready;
            o.resources = resources;
            o.restartCount = restartCount;
            o.started = started;
            o.state = state;
            o.volumeMounts = volumeMounts;
            return o;
        }
    }
}
