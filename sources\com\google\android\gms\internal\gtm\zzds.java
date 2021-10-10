package com.google.android.gms.internal.gtm;

final class zzds implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    zzds(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    public final void run() {
        zzdq.zzc(this.zzanc).execute(new zzdw(this.zzanc, null));
    }
}
