package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzfq implements Runnable {
    private final /* synthetic */ zzfo zzapm;

    zzfq(zzfo zzfo) {
        this.zzapm = zzfo;
    }

    public final void run() {
        this.zzapm.zzapi = false;
        this.zzapm.zzapg.dispatch();
    }
}
