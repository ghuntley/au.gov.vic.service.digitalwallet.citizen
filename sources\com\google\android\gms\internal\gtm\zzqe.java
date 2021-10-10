package com.google.android.gms.internal.gtm;

import java.io.IOException;

public abstract class zzqe {
    int zzawf;
    int zzawg;
    private int zzawh;
    zzqh zzawi;
    private boolean zzawj;

    public static zzqe zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzsk> T zza(zzsu<T> zzsu, zzqp zzqp) throws IOException;

    public abstract void zzan(int i) throws zzrk;

    public abstract boolean zzao(int i) throws IOException;

    public abstract int zzaq(int i) throws zzrk;

    public abstract void zzar(int i);

    public abstract void zzas(int i) throws IOException;

    public abstract int zzni() throws IOException;

    public abstract long zznj() throws IOException;

    public abstract long zznk() throws IOException;

    public abstract int zznl() throws IOException;

    public abstract long zznm() throws IOException;

    public abstract int zznn() throws IOException;

    public abstract boolean zzno() throws IOException;

    public abstract String zznp() throws IOException;

    public abstract zzps zznq() throws IOException;

    public abstract int zznr() throws IOException;

    public abstract int zzns() throws IOException;

    public abstract int zznt() throws IOException;

    public abstract long zznu() throws IOException;

    public abstract int zznv() throws IOException;

    public abstract long zznw() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zznx() throws IOException;

    public abstract boolean zzny() throws IOException;

    public abstract int zznz();

    static zzqe zza(byte[] bArr, int i, int i2, boolean z) {
        zzqg zzqg = new zzqg(bArr, i, i2, false);
        try {
            zzqg.zzaq(i2);
            return zzqg;
        } catch (zzrk e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzqe() {
        this.zzawg = 100;
        this.zzawh = Integer.MAX_VALUE;
        this.zzawj = false;
    }

    public final int zzap(int i) {
        if (i >= 0) {
            int i2 = this.zzawg;
            this.zzawg = i;
            return i2;
        }
        StringBuilder sb = new StringBuilder(47);
        sb.append("Recursion limit cannot be negative: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
