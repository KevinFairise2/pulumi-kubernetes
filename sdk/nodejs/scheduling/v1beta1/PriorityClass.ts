// *** WARNING: this file was generated by the Pulumi Kubernetes codegen tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputApi from "../../types/input";
import * as outputApi from "../../types/output";

    /**
     * DEPRECATED - This group version of PriorityClass is deprecated by
     * scheduling.k8s.io/v1/PriorityClass. PriorityClass defines mapping from a priority class name
     * to the priority integer value. The value can be any valid integer.
     */
    export class PriorityClass extends pulumi.CustomResource {
      /**
       * APIVersion defines the versioned schema of this representation of an object. Servers should
       * convert recognized schemas to the latest internal value, and may reject unrecognized
       * values. More info:
       * https://git.k8s.io/community/contributors/devel/api-conventions.md#resources
       */
      public readonly apiVersion: pulumi.Output<"scheduling.k8s.io/v1beta1">;

      /**
       * description is an arbitrary string that usually provides guidelines on when this priority
       * class should be used.
       */
      public readonly description: pulumi.Output<string>;

      /**
       * globalDefault specifies whether this PriorityClass should be considered as the default
       * priority for pods that do not have any priority class. Only one PriorityClass can be marked
       * as `globalDefault`. However, if more than one PriorityClasses exists with their
       * `globalDefault` field set to true, the smallest value of such global default
       * PriorityClasses will be used as the default priority.
       */
      public readonly globalDefault: pulumi.Output<boolean>;

      /**
       * Kind is a string value representing the REST resource this object represents. Servers may
       * infer this from the endpoint the client submits requests to. Cannot be updated. In
       * CamelCase. More info:
       * https://git.k8s.io/community/contributors/devel/api-conventions.md#types-kinds
       */
      public readonly kind: pulumi.Output<"PriorityClass">;

      /**
       * Standard object's metadata. More info:
       * https://git.k8s.io/community/contributors/devel/sig-architecture/api-conventions.md#metadata
       */
      public readonly metadata: pulumi.Output<outputApi.meta.v1.ObjectMeta>;

      /**
       * The value of this priority class. This is the actual priority that pods receive when they
       * have the name of this class in their pod spec.
       */
      public readonly value: pulumi.Output<number>;

      /**
       * Get the state of an existing `PriorityClass` resource, as identified by `id`.
       * Typically this ID  is of the form <namespace>/<name>; if <namespace> is omitted, then (per
       * Kubernetes convention) the ID becomes default/<name>.
       *
       * Pulumi will keep track of this resource using `name` as the Pulumi ID.
       *
       * @param name _Unique_ name used to register this resource with Pulumi.
       * @param id An ID for the Kubernetes resource to retrieve. Takes the form
       *  <namespace>/<name> or <name>.
       * @param opts Uniquely specifies a CustomResource to select.
       */
      public static get(name: string, id: pulumi.Input<pulumi.ID>, opts?: pulumi.CustomResourceOptions): PriorityClass {
          return new PriorityClass(name, undefined, { ...opts, id: id });
      }

      public getInputs(): inputApi.scheduling.v1beta1.PriorityClass { return this.__inputs; }
      private readonly __inputs: inputApi.scheduling.v1beta1.PriorityClass;

      /**
       * Create a scheduling.v1beta1.PriorityClass resource with the given unique name, arguments, and options.
       *
       * @param name The _unique_ name of the resource.
       * @param args The arguments to use to populate this resource's properties.
       * @param opts A bag of options that control this resource's behavior.
       */
      constructor(name: string, args?: inputApi.scheduling.v1beta1.PriorityClass, opts?: pulumi.CustomResourceOptions) {
          let inputs: pulumi.Inputs = {};
          inputs["apiVersion"] = "scheduling.k8s.io/v1beta1";
          inputs["description"] = args && args.description || undefined;
          inputs["globalDefault"] = args && args.globalDefault || undefined;
          inputs["kind"] = "PriorityClass";
          inputs["metadata"] = args && args.metadata || undefined;
          inputs["value"] = args && args.value || undefined;
          super("kubernetes:scheduling.k8s.io/v1beta1:PriorityClass", name, inputs, opts);
          this.__inputs = <any>args;
      }
    }
