// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.kubernetes.core.v1.inputs.AppArmorProfilePatchArgs;
import com.pulumi.kubernetes.core.v1.inputs.CapabilitiesPatchArgs;
import com.pulumi.kubernetes.core.v1.inputs.SELinuxOptionsPatchArgs;
import com.pulumi.kubernetes.core.v1.inputs.SeccompProfilePatchArgs;
import com.pulumi.kubernetes.core.v1.inputs.WindowsSecurityContextOptionsPatchArgs;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * SecurityContext holds security configuration that will be applied to a container. Some fields are present in both SecurityContext and PodSecurityContext.  When both are set, the values in SecurityContext take precedence.
 * 
 */
public final class SecurityContextPatchArgs extends com.pulumi.resources.ResourceArgs {

    public static final SecurityContextPatchArgs Empty = new SecurityContextPatchArgs();

    /**
     * AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="allowPrivilegeEscalation")
    private @Nullable Output<Boolean> allowPrivilegeEscalation;

    /**
     * @return AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<Boolean>> allowPrivilegeEscalation() {
        return Optional.ofNullable(this.allowPrivilegeEscalation);
    }

    /**
     * appArmorProfile is the AppArmor options to use by this container. If set, this profile overrides the pod&#39;s appArmorProfile. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="appArmorProfile")
    private @Nullable Output<AppArmorProfilePatchArgs> appArmorProfile;

    /**
     * @return appArmorProfile is the AppArmor options to use by this container. If set, this profile overrides the pod&#39;s appArmorProfile. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<AppArmorProfilePatchArgs>> appArmorProfile() {
        return Optional.ofNullable(this.appArmorProfile);
    }

    /**
     * The capabilities to add/drop when running containers. Defaults to the default set of capabilities granted by the container runtime. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="capabilities")
    private @Nullable Output<CapabilitiesPatchArgs> capabilities;

    /**
     * @return The capabilities to add/drop when running containers. Defaults to the default set of capabilities granted by the container runtime. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<CapabilitiesPatchArgs>> capabilities() {
        return Optional.ofNullable(this.capabilities);
    }

    /**
     * Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="privileged")
    private @Nullable Output<Boolean> privileged;

    /**
     * @return Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<Boolean>> privileged() {
        return Optional.ofNullable(this.privileged);
    }

    /**
     * procMount denotes the type of proc mount to use for the containers. The default is DefaultProcMount which uses the container runtime defaults for readonly paths and masked paths. This requires the ProcMountType feature flag to be enabled. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="procMount")
    private @Nullable Output<String> procMount;

    /**
     * @return procMount denotes the type of proc mount to use for the containers. The default is DefaultProcMount which uses the container runtime defaults for readonly paths and masked paths. This requires the ProcMountType feature flag to be enabled. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<String>> procMount() {
        return Optional.ofNullable(this.procMount);
    }

    /**
     * Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="readOnlyRootFilesystem")
    private @Nullable Output<Boolean> readOnlyRootFilesystem;

    /**
     * @return Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<Boolean>> readOnlyRootFilesystem() {
        return Optional.ofNullable(this.readOnlyRootFilesystem);
    }

    /**
     * The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="runAsGroup")
    private @Nullable Output<Integer> runAsGroup;

    /**
     * @return The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<Integer>> runAsGroup() {
        return Optional.ofNullable(this.runAsGroup);
    }

    /**
     * Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * 
     */
    @Import(name="runAsNonRoot")
    private @Nullable Output<Boolean> runAsNonRoot;

    /**
     * @return Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
     * 
     */
    public Optional<Output<Boolean>> runAsNonRoot() {
        return Optional.ofNullable(this.runAsNonRoot);
    }

    /**
     * The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="runAsUser")
    private @Nullable Output<Integer> runAsUser;

    /**
     * @return The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<Integer>> runAsUser() {
        return Optional.ofNullable(this.runAsUser);
    }

    /**
     * The SELinux context to be applied to the container. If unspecified, the container runtime will allocate a random SELinux context for each container.  May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="seLinuxOptions")
    private @Nullable Output<SELinuxOptionsPatchArgs> seLinuxOptions;

    /**
     * @return The SELinux context to be applied to the container. If unspecified, the container runtime will allocate a random SELinux context for each container.  May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<SELinuxOptionsPatchArgs>> seLinuxOptions() {
        return Optional.ofNullable(this.seLinuxOptions);
    }

    /**
     * The seccomp options to use by this container. If seccomp options are provided at both the pod &amp; container level, the container options override the pod options. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    @Import(name="seccompProfile")
    private @Nullable Output<SeccompProfilePatchArgs> seccompProfile;

    /**
     * @return The seccomp options to use by this container. If seccomp options are provided at both the pod &amp; container level, the container options override the pod options. Note that this field cannot be set when spec.os.name is windows.
     * 
     */
    public Optional<Output<SeccompProfilePatchArgs>> seccompProfile() {
        return Optional.ofNullable(this.seccompProfile);
    }

    /**
     * The Windows specific settings applied to all containers. If unspecified, the options from the PodSecurityContext will be used. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is linux.
     * 
     */
    @Import(name="windowsOptions")
    private @Nullable Output<WindowsSecurityContextOptionsPatchArgs> windowsOptions;

    /**
     * @return The Windows specific settings applied to all containers. If unspecified, the options from the PodSecurityContext will be used. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is linux.
     * 
     */
    public Optional<Output<WindowsSecurityContextOptionsPatchArgs>> windowsOptions() {
        return Optional.ofNullable(this.windowsOptions);
    }

    private SecurityContextPatchArgs() {}

    private SecurityContextPatchArgs(SecurityContextPatchArgs $) {
        this.allowPrivilegeEscalation = $.allowPrivilegeEscalation;
        this.appArmorProfile = $.appArmorProfile;
        this.capabilities = $.capabilities;
        this.privileged = $.privileged;
        this.procMount = $.procMount;
        this.readOnlyRootFilesystem = $.readOnlyRootFilesystem;
        this.runAsGroup = $.runAsGroup;
        this.runAsNonRoot = $.runAsNonRoot;
        this.runAsUser = $.runAsUser;
        this.seLinuxOptions = $.seLinuxOptions;
        this.seccompProfile = $.seccompProfile;
        this.windowsOptions = $.windowsOptions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(SecurityContextPatchArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private SecurityContextPatchArgs $;

        public Builder() {
            $ = new SecurityContextPatchArgs();
        }

        public Builder(SecurityContextPatchArgs defaults) {
            $ = new SecurityContextPatchArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param allowPrivilegeEscalation AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder allowPrivilegeEscalation(@Nullable Output<Boolean> allowPrivilegeEscalation) {
            $.allowPrivilegeEscalation = allowPrivilegeEscalation;
            return this;
        }

        /**
         * @param allowPrivilegeEscalation AllowPrivilegeEscalation controls whether a process can gain more privileges than its parent process. This bool directly controls if the no_new_privs flag will be set on the container process. AllowPrivilegeEscalation is true always when the container is: 1) run as Privileged 2) has CAP_SYS_ADMIN Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder allowPrivilegeEscalation(Boolean allowPrivilegeEscalation) {
            return allowPrivilegeEscalation(Output.of(allowPrivilegeEscalation));
        }

        /**
         * @param appArmorProfile appArmorProfile is the AppArmor options to use by this container. If set, this profile overrides the pod&#39;s appArmorProfile. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder appArmorProfile(@Nullable Output<AppArmorProfilePatchArgs> appArmorProfile) {
            $.appArmorProfile = appArmorProfile;
            return this;
        }

        /**
         * @param appArmorProfile appArmorProfile is the AppArmor options to use by this container. If set, this profile overrides the pod&#39;s appArmorProfile. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder appArmorProfile(AppArmorProfilePatchArgs appArmorProfile) {
            return appArmorProfile(Output.of(appArmorProfile));
        }

        /**
         * @param capabilities The capabilities to add/drop when running containers. Defaults to the default set of capabilities granted by the container runtime. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder capabilities(@Nullable Output<CapabilitiesPatchArgs> capabilities) {
            $.capabilities = capabilities;
            return this;
        }

        /**
         * @param capabilities The capabilities to add/drop when running containers. Defaults to the default set of capabilities granted by the container runtime. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder capabilities(CapabilitiesPatchArgs capabilities) {
            return capabilities(Output.of(capabilities));
        }

        /**
         * @param privileged Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder privileged(@Nullable Output<Boolean> privileged) {
            $.privileged = privileged;
            return this;
        }

        /**
         * @param privileged Run container in privileged mode. Processes in privileged containers are essentially equivalent to root on the host. Defaults to false. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder privileged(Boolean privileged) {
            return privileged(Output.of(privileged));
        }

        /**
         * @param procMount procMount denotes the type of proc mount to use for the containers. The default is DefaultProcMount which uses the container runtime defaults for readonly paths and masked paths. This requires the ProcMountType feature flag to be enabled. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder procMount(@Nullable Output<String> procMount) {
            $.procMount = procMount;
            return this;
        }

        /**
         * @param procMount procMount denotes the type of proc mount to use for the containers. The default is DefaultProcMount which uses the container runtime defaults for readonly paths and masked paths. This requires the ProcMountType feature flag to be enabled. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder procMount(String procMount) {
            return procMount(Output.of(procMount));
        }

        /**
         * @param readOnlyRootFilesystem Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder readOnlyRootFilesystem(@Nullable Output<Boolean> readOnlyRootFilesystem) {
            $.readOnlyRootFilesystem = readOnlyRootFilesystem;
            return this;
        }

        /**
         * @param readOnlyRootFilesystem Whether this container has a read-only root filesystem. Default is false. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder readOnlyRootFilesystem(Boolean readOnlyRootFilesystem) {
            return readOnlyRootFilesystem(Output.of(readOnlyRootFilesystem));
        }

        /**
         * @param runAsGroup The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder runAsGroup(@Nullable Output<Integer> runAsGroup) {
            $.runAsGroup = runAsGroup;
            return this;
        }

        /**
         * @param runAsGroup The GID to run the entrypoint of the container process. Uses runtime default if unset. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder runAsGroup(Integer runAsGroup) {
            return runAsGroup(Output.of(runAsGroup));
        }

        /**
         * @param runAsNonRoot Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         * 
         * @return builder
         * 
         */
        public Builder runAsNonRoot(@Nullable Output<Boolean> runAsNonRoot) {
            $.runAsNonRoot = runAsNonRoot;
            return this;
        }

        /**
         * @param runAsNonRoot Indicates that the container must run as a non-root user. If true, the Kubelet will validate the image at runtime to ensure that it does not run as UID 0 (root) and fail to start the container if it does. If unset or false, no such validation will be performed. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence.
         * 
         * @return builder
         * 
         */
        public Builder runAsNonRoot(Boolean runAsNonRoot) {
            return runAsNonRoot(Output.of(runAsNonRoot));
        }

        /**
         * @param runAsUser The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder runAsUser(@Nullable Output<Integer> runAsUser) {
            $.runAsUser = runAsUser;
            return this;
        }

        /**
         * @param runAsUser The UID to run the entrypoint of the container process. Defaults to user specified in image metadata if unspecified. May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder runAsUser(Integer runAsUser) {
            return runAsUser(Output.of(runAsUser));
        }

        /**
         * @param seLinuxOptions The SELinux context to be applied to the container. If unspecified, the container runtime will allocate a random SELinux context for each container.  May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder seLinuxOptions(@Nullable Output<SELinuxOptionsPatchArgs> seLinuxOptions) {
            $.seLinuxOptions = seLinuxOptions;
            return this;
        }

        /**
         * @param seLinuxOptions The SELinux context to be applied to the container. If unspecified, the container runtime will allocate a random SELinux context for each container.  May also be set in PodSecurityContext.  If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder seLinuxOptions(SELinuxOptionsPatchArgs seLinuxOptions) {
            return seLinuxOptions(Output.of(seLinuxOptions));
        }

        /**
         * @param seccompProfile The seccomp options to use by this container. If seccomp options are provided at both the pod &amp; container level, the container options override the pod options. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder seccompProfile(@Nullable Output<SeccompProfilePatchArgs> seccompProfile) {
            $.seccompProfile = seccompProfile;
            return this;
        }

        /**
         * @param seccompProfile The seccomp options to use by this container. If seccomp options are provided at both the pod &amp; container level, the container options override the pod options. Note that this field cannot be set when spec.os.name is windows.
         * 
         * @return builder
         * 
         */
        public Builder seccompProfile(SeccompProfilePatchArgs seccompProfile) {
            return seccompProfile(Output.of(seccompProfile));
        }

        /**
         * @param windowsOptions The Windows specific settings applied to all containers. If unspecified, the options from the PodSecurityContext will be used. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is linux.
         * 
         * @return builder
         * 
         */
        public Builder windowsOptions(@Nullable Output<WindowsSecurityContextOptionsPatchArgs> windowsOptions) {
            $.windowsOptions = windowsOptions;
            return this;
        }

        /**
         * @param windowsOptions The Windows specific settings applied to all containers. If unspecified, the options from the PodSecurityContext will be used. If set in both SecurityContext and PodSecurityContext, the value specified in SecurityContext takes precedence. Note that this field cannot be set when spec.os.name is linux.
         * 
         * @return builder
         * 
         */
        public Builder windowsOptions(WindowsSecurityContextOptionsPatchArgs windowsOptions) {
            return windowsOptions(Output.of(windowsOptions));
        }

        public SecurityContextPatchArgs build() {
            return $;
        }
    }

}
