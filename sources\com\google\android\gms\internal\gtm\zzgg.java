package com.google.android.gms.internal.gtm;

final class zzgg implements Runnable {
    private final /* synthetic */ zzgf zzaqn;

    zzgg(zzgf zzgf) {
        this.zzaqn = zzgf;
    }

    public final void run() {
        if (this.zzaqn.zzaqb.zzapx == 1 || this.zzaqn.zzaqb.zzapx == 2) {
            this.zzaqn.zzaqb.zzapx = 4;
            zzev.zzav("Container load timed out after 5000ms.");
            while (!this.zzaqn.zzaqb.zzapy.isEmpty()) {
                this.zzaqn.zzaqb.zzamv.execute((Runnable) this.zzaqn.zzaqb.zzapy.remove());
            }
        }
    }
}
