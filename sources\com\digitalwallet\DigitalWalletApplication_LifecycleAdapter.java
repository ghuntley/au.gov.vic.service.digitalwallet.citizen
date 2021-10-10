package com.digitalwallet;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class DigitalWalletApplication_LifecycleAdapter implements GeneratedAdapter {
    final DigitalWalletApplication mReceiver;

    DigitalWalletApplication_LifecycleAdapter(DigitalWalletApplication digitalWalletApplication) {
        this.mReceiver = digitalWalletApplication;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            if (event == Lifecycle.Event.ON_STOP) {
                if (!z2 || methodCallsLogger.approveCall("onAppBackgrounded", 1)) {
                    this.mReceiver.onAppBackgrounded();
                }
            } else if (event != Lifecycle.Event.ON_START) {
            } else {
                if (!z2 || methodCallsLogger.approveCall("onAppForegrounded", 1)) {
                    this.mReceiver.onAppForegrounded();
                }
            }
        }
    }
}
