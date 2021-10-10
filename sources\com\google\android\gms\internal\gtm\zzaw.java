package com.google.android.gms.internal.gtm;

final class zzaw implements Runnable {
    private final /* synthetic */ zzce zzxh;
    private final /* synthetic */ zzav zzxi;

    zzaw(zzav zzav, zzce zzce) {
        this.zzxi = zzav;
        this.zzxh = zzce;
    }

    public final void run() {
        if (!this.zzxi.zzxe.isConnected()) {
            this.zzxi.zzxe.zzr("Connected to service after a timeout");
            this.zzxi.zzxe.zza((zzat) this.zzxh);
        }
    }
}
