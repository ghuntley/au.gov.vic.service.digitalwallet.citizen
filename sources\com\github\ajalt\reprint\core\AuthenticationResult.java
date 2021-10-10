package com.github.ajalt.reprint.core;

public class AuthenticationResult {
    public final int errorCode;
    public final CharSequence errorMessage;
    public final AuthenticationFailureReason failureReason;
    public final int fromModule;
    public final Status status;

    public enum Status {
        SUCCESS,
        NONFATAL_FAILURE,
        FATAL_FAILURE
    }

    public AuthenticationResult(Status status2, AuthenticationFailureReason authenticationFailureReason, CharSequence charSequence, int i, int i2) {
        this.status = status2;
        this.failureReason = authenticationFailureReason;
        this.errorMessage = charSequence;
        this.fromModule = i;
        this.errorCode = i2;
    }
}
