package com.digitalwallet.app;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class AppStartUp_LifecycleAdapter implements GeneratedAdapter {
    final AppStartUp mReceiver;

    AppStartUp_LifecycleAdapter(AppStartUp appStartUp) {
        this.mReceiver = appStartUp;
    }

    @Override // androidx.lifecycle.GeneratedAdapter
    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (z || event != Lifecycle.Event.ON_START) {
            return;
        }
        if (!z2 || methodCallsLogger.approveCall("onAppForegrounded", 1)) {
            this.mReceiver.onAppForegrounded();
        }
    }
}
