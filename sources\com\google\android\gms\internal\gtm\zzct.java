package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzct implements zzbw {
    private final /* synthetic */ Runnable zzacj;
    private final /* synthetic */ zzcq zzack;

    zzct(zzcq zzcq, Runnable runnable) {
        this.zzack = zzcq;
        this.zzacj = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzbw
    public final void zza(Throwable th) {
        this.zzack.handler.post(this.zzacj);
    }
}
