package com.github.ajalt.reprint.core;

public interface AuthenticationListener {
    void onFailure(AuthenticationFailureReason authenticationFailureReason, boolean z, CharSequence charSequence, int i, int i2);

    void onSuccess(int i);
}
