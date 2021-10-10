package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zam;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zacc implements Runnable {
    private final /* synthetic */ zam zaa;
    private final /* synthetic */ zacb zab;

    zacc(zacb zacb, zam zam) {
        this.zab = zacb;
        this.zaa = zam;
    }

    public final void run() {
        this.zab.zab((zacb) this.zaa);
    }
}
