// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.kubernetes.core.v1.inputs;

import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import java.lang.Boolean;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


/**
 * VolumeMount describes a mounting of a Volume within a container.
 * 
 */
public final class VolumeMountArgs extends com.pulumi.resources.ResourceArgs {

    public static final VolumeMountArgs Empty = new VolumeMountArgs();

    /**
     * Path within the container at which the volume should be mounted.  Must not contain &#39;:&#39;.
     * 
     */
    @Import(name="mountPath", required=true)
    private Output<String> mountPath;

    /**
     * @return Path within the container at which the volume should be mounted.  Must not contain &#39;:&#39;.
     * 
     */
    public Output<String> mountPath() {
        return this.mountPath;
    }

    /**
     * mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
     * 
     */
    @Import(name="mountPropagation")
    private @Nullable Output<String> mountPropagation;

    /**
     * @return mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
     * 
     */
    public Optional<Output<String>> mountPropagation() {
        return Optional.ofNullable(this.mountPropagation);
    }

    /**
     * This must match the Name of a Volume.
     * 
     */
    @Import(name="name", required=true)
    private Output<String> name;

    /**
     * @return This must match the Name of a Volume.
     * 
     */
    public Output<String> name() {
        return this.name;
    }

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     * 
     */
    @Import(name="readOnly")
    private @Nullable Output<Boolean> readOnly;

    /**
     * @return Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     * 
     */
    public Optional<Output<Boolean>> readOnly() {
        return Optional.ofNullable(this.readOnly);
    }

    /**
     * RecursiveReadOnly specifies whether read-only mounts should be handled recursively.
     * 
     * If ReadOnly is false, this field has no meaning and must be unspecified.
     * 
     * If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.
     * 
     * If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).
     * 
     * If this field is not specified, it is treated as an equivalent of Disabled.
     * 
     */
    @Import(name="recursiveReadOnly")
    private @Nullable Output<String> recursiveReadOnly;

    /**
     * @return RecursiveReadOnly specifies whether read-only mounts should be handled recursively.
     * 
     * If ReadOnly is false, this field has no meaning and must be unspecified.
     * 
     * If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.
     * 
     * If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).
     * 
     * If this field is not specified, it is treated as an equivalent of Disabled.
     * 
     */
    public Optional<Output<String>> recursiveReadOnly() {
        return Optional.ofNullable(this.recursiveReadOnly);
    }

    /**
     * Path within the volume from which the container&#39;s volume should be mounted. Defaults to &#34;&#34; (volume&#39;s root).
     * 
     */
    @Import(name="subPath")
    private @Nullable Output<String> subPath;

    /**
     * @return Path within the volume from which the container&#39;s volume should be mounted. Defaults to &#34;&#34; (volume&#39;s root).
     * 
     */
    public Optional<Output<String>> subPath() {
        return Optional.ofNullable(this.subPath);
    }

    /**
     * Expanded path within the volume from which the container&#39;s volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container&#39;s environment. Defaults to &#34;&#34; (volume&#39;s root). SubPathExpr and SubPath are mutually exclusive.
     * 
     */
    @Import(name="subPathExpr")
    private @Nullable Output<String> subPathExpr;

    /**
     * @return Expanded path within the volume from which the container&#39;s volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container&#39;s environment. Defaults to &#34;&#34; (volume&#39;s root). SubPathExpr and SubPath are mutually exclusive.
     * 
     */
    public Optional<Output<String>> subPathExpr() {
        return Optional.ofNullable(this.subPathExpr);
    }

    private VolumeMountArgs() {}

    private VolumeMountArgs(VolumeMountArgs $) {
        this.mountPath = $.mountPath;
        this.mountPropagation = $.mountPropagation;
        this.name = $.name;
        this.readOnly = $.readOnly;
        this.recursiveReadOnly = $.recursiveReadOnly;
        this.subPath = $.subPath;
        this.subPathExpr = $.subPathExpr;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(VolumeMountArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private VolumeMountArgs $;

        public Builder() {
            $ = new VolumeMountArgs();
        }

        public Builder(VolumeMountArgs defaults) {
            $ = new VolumeMountArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param mountPath Path within the container at which the volume should be mounted.  Must not contain &#39;:&#39;.
         * 
         * @return builder
         * 
         */
        public Builder mountPath(Output<String> mountPath) {
            $.mountPath = mountPath;
            return this;
        }

        /**
         * @param mountPath Path within the container at which the volume should be mounted.  Must not contain &#39;:&#39;.
         * 
         * @return builder
         * 
         */
        public Builder mountPath(String mountPath) {
            return mountPath(Output.of(mountPath));
        }

        /**
         * @param mountPropagation mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
         * 
         * @return builder
         * 
         */
        public Builder mountPropagation(@Nullable Output<String> mountPropagation) {
            $.mountPropagation = mountPropagation;
            return this;
        }

        /**
         * @param mountPropagation mountPropagation determines how mounts are propagated from the host to container and the other way around. When not set, MountPropagationNone is used. This field is beta in 1.10. When RecursiveReadOnly is set to IfPossible or to Enabled, MountPropagation must be None or unspecified (which defaults to None).
         * 
         * @return builder
         * 
         */
        public Builder mountPropagation(String mountPropagation) {
            return mountPropagation(Output.of(mountPropagation));
        }

        /**
         * @param name This must match the Name of a Volume.
         * 
         * @return builder
         * 
         */
        public Builder name(Output<String> name) {
            $.name = name;
            return this;
        }

        /**
         * @param name This must match the Name of a Volume.
         * 
         * @return builder
         * 
         */
        public Builder name(String name) {
            return name(Output.of(name));
        }

        /**
         * @param readOnly Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
         * 
         * @return builder
         * 
         */
        public Builder readOnly(@Nullable Output<Boolean> readOnly) {
            $.readOnly = readOnly;
            return this;
        }

        /**
         * @param readOnly Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
         * 
         * @return builder
         * 
         */
        public Builder readOnly(Boolean readOnly) {
            return readOnly(Output.of(readOnly));
        }

        /**
         * @param recursiveReadOnly RecursiveReadOnly specifies whether read-only mounts should be handled recursively.
         * 
         * If ReadOnly is false, this field has no meaning and must be unspecified.
         * 
         * If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.
         * 
         * If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).
         * 
         * If this field is not specified, it is treated as an equivalent of Disabled.
         * 
         * @return builder
         * 
         */
        public Builder recursiveReadOnly(@Nullable Output<String> recursiveReadOnly) {
            $.recursiveReadOnly = recursiveReadOnly;
            return this;
        }

        /**
         * @param recursiveReadOnly RecursiveReadOnly specifies whether read-only mounts should be handled recursively.
         * 
         * If ReadOnly is false, this field has no meaning and must be unspecified.
         * 
         * If ReadOnly is true, and this field is set to Disabled, the mount is not made recursively read-only.  If this field is set to IfPossible, the mount is made recursively read-only, if it is supported by the container runtime.  If this field is set to Enabled, the mount is made recursively read-only if it is supported by the container runtime, otherwise the pod will not be started and an error will be generated to indicate the reason.
         * 
         * If this field is set to IfPossible or Enabled, MountPropagation must be set to None (or be unspecified, which defaults to None).
         * 
         * If this field is not specified, it is treated as an equivalent of Disabled.
         * 
         * @return builder
         * 
         */
        public Builder recursiveReadOnly(String recursiveReadOnly) {
            return recursiveReadOnly(Output.of(recursiveReadOnly));
        }

        /**
         * @param subPath Path within the volume from which the container&#39;s volume should be mounted. Defaults to &#34;&#34; (volume&#39;s root).
         * 
         * @return builder
         * 
         */
        public Builder subPath(@Nullable Output<String> subPath) {
            $.subPath = subPath;
            return this;
        }

        /**
         * @param subPath Path within the volume from which the container&#39;s volume should be mounted. Defaults to &#34;&#34; (volume&#39;s root).
         * 
         * @return builder
         * 
         */
        public Builder subPath(String subPath) {
            return subPath(Output.of(subPath));
        }

        /**
         * @param subPathExpr Expanded path within the volume from which the container&#39;s volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container&#39;s environment. Defaults to &#34;&#34; (volume&#39;s root). SubPathExpr and SubPath are mutually exclusive.
         * 
         * @return builder
         * 
         */
        public Builder subPathExpr(@Nullable Output<String> subPathExpr) {
            $.subPathExpr = subPathExpr;
            return this;
        }

        /**
         * @param subPathExpr Expanded path within the volume from which the container&#39;s volume should be mounted. Behaves similarly to SubPath but environment variable references $(VAR_NAME) are expanded using the container&#39;s environment. Defaults to &#34;&#34; (volume&#39;s root). SubPathExpr and SubPath are mutually exclusive.
         * 
         * @return builder
         * 
         */
        public Builder subPathExpr(String subPathExpr) {
            return subPathExpr(Output.of(subPathExpr));
        }

        public VolumeMountArgs build() {
            $.mountPath = Objects.requireNonNull($.mountPath, "expected parameter 'mountPath' to be non-null");
            $.name = Objects.requireNonNull($.name, "expected parameter 'name' to be non-null");
            return $;
        }
    }

}
