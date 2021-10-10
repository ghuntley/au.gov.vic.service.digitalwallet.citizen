package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

final class zzax implements Runnable {
    private final /* synthetic */ ComponentName val$name;
    private final /* synthetic */ zzav zzxi;

    zzax(zzav zzav, ComponentName componentName) {
        this.zzxi = zzav;
        this.val$name = componentName;
    }

    public final void run() {
        this.zzxi.zzxe.onServiceDisconnected(this.val$name);
    }
}
