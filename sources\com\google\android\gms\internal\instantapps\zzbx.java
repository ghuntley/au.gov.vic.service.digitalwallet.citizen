package com.google.android.gms.internal.instantapps;

/* access modifiers changed from: package-private */
public final class zzbx {
    private final byte[] buffer;
    private final zzce zzalb;

    private zzbx(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzalb = zzce.zzb(bArr);
    }

    public final zzbp zzy() {
        this.zzalb.zzbb();
        return new zzbz(this.buffer);
    }

    public final zzce zzz() {
        return this.zzalb;
    }

    /* synthetic */ zzbx(int i, zzbo zzbo) {
        this(i);
    }
}
