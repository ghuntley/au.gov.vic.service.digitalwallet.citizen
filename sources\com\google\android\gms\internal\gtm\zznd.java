package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zznd implements Runnable {
    private final /* synthetic */ String zzatf;
    private final /* synthetic */ zzmz zzath;
    private final /* synthetic */ byte[] zzatj;

    zznd(zzmz zzmz, String str, byte[] bArr) {
        this.zzath = zzmz;
        this.zzatf = str;
        this.zzatj = bArr;
    }

    public final void run() {
        this.zzath.zzb(this.zzatf, this.zzatj);
    }
}
