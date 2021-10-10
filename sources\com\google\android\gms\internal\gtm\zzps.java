package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.UByte;

public abstract class zzps implements Serializable, Iterable<Byte> {
    public static final zzps zzavx = new zzqc(zzre.zzbbh);
    private static final zzpy zzavy = (zzpp.zzna() ? new zzqd(null) : new zzpw(null));
    private static final Comparator<zzps> zzavz = new zzpu();
    private int zzavn = 0;

    zzps() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b) {
        return b & UByte.MAX_VALUE;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzpr zzpr) throws IOException;

    public abstract byte zzak(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzal(int i);

    public abstract zzps zzc(int i, int i2);

    public abstract boolean zznd();

    public static zzps zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzqc(zzavy.zzc(bArr, i, i2));
    }

    static zzps zzf(byte[] bArr) {
        return new zzqc(bArr);
    }

    public static zzps zzcy(String str) {
        return new zzqc(str.getBytes(zzre.UTF_8));
    }

    public final String zznc() {
        return size() == 0 ? "" : zza(zzre.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzavn;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzavn = i;
        }
        return i;
    }

    static zzqa zzam(int i) {
        return new zzqa(i, null);
    }

    /* access modifiers changed from: protected */
    public final int zzne() {
        return this.zzavn;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzpt(this);
    }
}
