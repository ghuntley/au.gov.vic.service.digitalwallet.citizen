package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzak implements Runnable {
    private final /* synthetic */ zzae zzvw;
    private final /* synthetic */ zzbw zzwb;

    zzak(zzae zzae, zzbw zzbw) {
        this.zzvw = zzae;
        this.zzwb = zzbw;
    }

    public final void run() {
        this.zzvw.zzvu.zzb(this.zzwb);
    }
}
