package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzaf implements Runnable {
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzae zzvw;

    zzaf(zzae zzae, int i) {
        this.zzvw = zzae;
        this.zzvv = i;
    }

    public final void run() {
        this.zzvw.zzvu.zzg(((long) this.zzvv) * 1000);
    }
}
