package com.google.android.gms.internal.gtm;

final class zzgn implements Runnable {
    private final /* synthetic */ zzgl zzaqv;
    private final /* synthetic */ zzee zzaqw;

    zzgn(zzgl zzgl, zzee zzee) {
        this.zzaqv = zzgl;
        this.zzaqw = zzee;
    }

    public final void run() {
        if (this.zzaqv.zzaqs.isEmpty()) {
            zzev.zzav("TagManagerBackend emit called without loaded container.");
            return;
        }
        for (zzdq zzdq : this.zzaqv.zzaqs.values()) {
            zzdq.zza(this.zzaqw);
        }
    }
}
