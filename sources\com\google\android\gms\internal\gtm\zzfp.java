package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzfp implements zzen {
    private final /* synthetic */ zzfo zzapm;

    zzfp(zzfo zzfo) {
        this.zzapm = zzfo;
    }

    @Override // com.google.android.gms.internal.gtm.zzen
    public final void zze(boolean z) {
        zzfo zzfo = this.zzapm;
        zzfo.zza(z, zzfo.connected);
    }
}
