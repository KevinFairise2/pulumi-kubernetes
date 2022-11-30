// *** WARNING: this file was generated by pulumigen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../../../types/input";
import * as outputs from "../../../types/output";
import * as enums from "../../../types/enums";
import * as utilities from "../../../utilities";

/**
 * TokenReviewSpec is a description of the token authentication request.
 */
export interface TokenReviewSpec {
    /**
     * Audiences is a list of the identifiers that the resource server presented with the token identifies as. Audience-aware token authenticators will verify that the token was intended for at least one of the audiences in this list. If no audiences are provided, the audience will default to the audience of the Kubernetes apiserver.
     */
    audiences?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Token is the opaque bearer token.
     */
    token?: pulumi.Input<string>;
}

/**
 * TokenReviewSpec is a description of the token authentication request.
 */
export interface TokenReviewSpecPatch {
    /**
     * Audiences is a list of the identifiers that the resource server presented with the token identifies as. Audience-aware token authenticators will verify that the token was intended for at least one of the audiences in this list. If no audiences are provided, the audience will default to the audience of the Kubernetes apiserver.
     */
    audiences?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Token is the opaque bearer token.
     */
    token?: pulumi.Input<string>;
}

