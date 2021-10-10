package com.google.android.gms.internal.gtm;

public final class zzba extends zzan {
    private final zzq zzsu = new zzq();

    zzba(zzap zzap) {
        super(zzap);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzan
    public final void zzaw() {
        zzcq().zzat().zzb(this.zzsu);
        zzda zzcu = zzcu();
        String zzaz = zzcu.zzaz();
        if (zzaz != null) {
            this.zzsu.setAppName(zzaz);
        }
        String zzba = zzcu.zzba();
        if (zzba != null) {
            this.zzsu.setAppVersion(zzba);
        }
    }

    public final zzq zzdv() {
        zzdb();
        return this.zzsu;
    }
}
