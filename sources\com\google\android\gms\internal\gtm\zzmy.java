package com.google.android.gms.internal.gtm;

public final class zzmy {
    private final zznm zzaov;
    private final byte[] zzatb;
    private final long zzatc;
    private final zzmk zzatd;

    public zzmy(zznm zznm) {
        this(null, null, zznm, 0);
    }

    public zzmy(zzmk zzmk, byte[] bArr, zznm zznm, long j) {
        this.zzatd = zzmk;
        this.zzatb = bArr;
        this.zzaov = zznm;
        this.zzatc = j;
    }

    public final byte[] zzlo() {
        return this.zzatb;
    }

    public final zzmk zzlp() {
        return this.zzatd;
    }

    public final zznm zzlq() {
        return this.zzaov;
    }

    public final long zzlr() {
        return this.zzatc;
    }
}
