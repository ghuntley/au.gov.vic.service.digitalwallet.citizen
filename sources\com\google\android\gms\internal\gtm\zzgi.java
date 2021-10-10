package com.google.android.gms.internal.gtm;

final class zzgi implements Runnable {
    private final /* synthetic */ zzgh zzaqo;

    zzgi(zzgh zzgh) {
        this.zzaqo = zzgh;
    }

    public final void run() {
        zzev.zzab("App's UI deactivated. Dispatching hits.");
        this.zzaqo.zzaqb.zzaps.dispatch();
    }
}
