package com.google.android.gms.internal.instantapps;

import java.io.IOException;

public abstract class zzcb {
    int zzald;
    int zzale;
    private int zzalf;
    zzcc zzalg;
    private boolean zzalh;

    static zzcb zza(byte[] bArr, int i, int i2, boolean z) {
        zzcd zzcd = new zzcd(bArr, 0, i2, false);
        try {
            zzcd.zzo(i2);
            return zzcd;
        } catch (zzdf e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zzc(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zzq(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract int zzaa() throws IOException;

    public abstract long zzab() throws IOException;

    public abstract long zzac() throws IOException;

    public abstract int zzad() throws IOException;

    public abstract long zzae() throws IOException;

    public abstract int zzaf() throws IOException;

    public abstract boolean zzag() throws IOException;

    public abstract String zzah() throws IOException;

    public abstract zzbp zzai() throws IOException;

    public abstract int zzaj() throws IOException;

    public abstract int zzak() throws IOException;

    public abstract int zzal() throws IOException;

    public abstract long zzam() throws IOException;

    public abstract int zzan() throws IOException;

    public abstract long zzao() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzap() throws IOException;

    public abstract boolean zzaq() throws IOException;

    public abstract int zzar();

    public abstract void zzm(int i) throws zzdf;

    public abstract boolean zzn(int i) throws IOException;

    public abstract int zzo(int i) throws zzdf;

    public abstract void zzp(int i);

    private zzcb() {
        this.zzale = 100;
        this.zzalf = Integer.MAX_VALUE;
        this.zzalh = false;
    }
}
