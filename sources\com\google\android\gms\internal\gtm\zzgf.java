package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzgf implements Runnable {
    final /* synthetic */ zzfy zzaqb;

    zzgf(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void run() {
        this.zzaqb.zzamv.execute(new zzgg(this));
    }
}
