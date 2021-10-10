package com.google.android.gms.analytics;

/* access modifiers changed from: package-private */
public final class zzl implements Runnable {
    private final /* synthetic */ zzg zzsw;
    private final /* synthetic */ zzk zzsx;

    zzl(zzk zzk, zzg zzg) {
        this.zzsx = zzk;
        this.zzsw = zzg;
    }

    public final void run() {
        this.zzsw.zzap().zza(this.zzsw);
        for (zzn zzn : this.zzsx.zzsr) {
            zzn.zza(this.zzsw);
        }
        zzk zzk = this.zzsx;
        zzk.zzb((zzk) this.zzsw);
    }
}
