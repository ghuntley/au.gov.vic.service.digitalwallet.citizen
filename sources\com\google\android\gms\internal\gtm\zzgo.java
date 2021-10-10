package com.google.android.gms.internal.gtm;

final class zzgo implements Runnable {
    private final /* synthetic */ zzgl zzaqv;

    zzgo(zzgl zzgl) {
        this.zzaqv = zzgl;
    }

    public final void run() {
        if (this.zzaqv.zzaqs.isEmpty()) {
            zzev.zzac("TagManagerBackend dispatch called without loaded container.");
            return;
        }
        for (zzdq zzdq : this.zzaqv.zzaqs.values()) {
            zzdq.dispatch();
        }
    }
}
