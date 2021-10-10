package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zznc implements Runnable {
    private final /* synthetic */ String zzatf;
    private final /* synthetic */ zzmn zzatg;
    private final /* synthetic */ zzmz zzath;
    private final /* synthetic */ String zzati;

    zznc(zzmz zzmz, String str, String str2, zzmn zzmn) {
        this.zzath = zzmz;
        this.zzatf = str;
        this.zzati = str2;
        this.zzatg = zzmn;
    }

    public final void run() {
        this.zzath.zzb(this.zzatf, this.zzati, this.zzatg);
    }
}
