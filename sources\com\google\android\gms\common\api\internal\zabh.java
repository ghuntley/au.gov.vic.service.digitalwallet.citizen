package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zabh implements Runnable {
    private final /* synthetic */ zabf zaa;

    zabh(zabf zabf) {
        this.zaa = zabf;
    }

    public final void run() {
        this.zaa.zaa.zac.disconnect(String.valueOf(this.zaa.zaa.zac.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
