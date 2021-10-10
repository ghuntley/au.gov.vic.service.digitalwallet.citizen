package com.google.android.gms.internal.gtm;

final /* synthetic */ class zzcr implements Runnable {
    private final zzcq zzace;
    private final int zzacf;
    private final zzci zzacg;

    zzcr(zzcq zzcq, int i, zzci zzci) {
        this.zzace = zzcq;
        this.zzacf = i;
        this.zzacg = zzci;
    }

    public final void run() {
        this.zzace.zza(this.zzacf, this.zzacg);
    }
}
