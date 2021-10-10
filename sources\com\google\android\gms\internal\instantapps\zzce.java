package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzce extends zzbm {
    private static final Logger logger = Logger.getLogger(zzce.class.getName());
    private static final boolean zzalq = zzfs.zzed();
    zzch zzalr;

    public static int zzac(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzae(int i) {
        return 4;
    }

    public static int zzaf(int i) {
        return 4;
    }

    private static int zzah(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(boolean z) {
        return 1;
    }

    public static zzce zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzh(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzj(long j) {
        return 8;
    }

    public static int zzk(long j) {
        return 8;
    }

    private static long zzl(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzbp zzbp) throws IOException;

    public abstract void zza(int i, zzef zzef) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzef zzef, zzeu zzeu) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzbp zzbp) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, zzbp zzbp) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzef zzef) throws IOException;

    public abstract int zzba();

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zzd(long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzd(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzf(long j) throws IOException;

    public abstract void zzf(String str) throws IOException;

    public abstract void zzw(int i) throws IOException;

    public abstract void zzx(int i) throws IOException;

    public abstract void zzz(int i) throws IOException;

    public static class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        zzb(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }
    }

    private zzce() {
    }

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzah(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzl(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzy(int i) throws IOException {
        zzx(zzah(i));
    }

    /* access modifiers changed from: package-private */
    public static class zza extends zzce {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                this.buffer = bArr;
                this.offset = 0;
                this.position = 0;
                this.limit = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzb(int i, int i2) throws IOException {
            zzx((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzw(i2);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzx(i2);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzz(i2);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zzd(j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzf(j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzb(int i, boolean z) throws IOException {
            zzb(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzf(str);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(int i, zzbp zzbp) throws IOException {
            zzb(i, 2);
            zza(zzbp);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(zzbp zzbp) throws IOException {
            zzx(zzbp.size());
            zzbp.zza(this);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzd(byte[] bArr, int i, int i2) throws IOException {
            zzx(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(int i, zzef zzef, zzeu zzeu) throws IOException {
            zzb(i, 2);
            zzbe zzbe = (zzbe) zzef;
            int zzn = zzbe.zzn();
            if (zzn == -1) {
                zzn = zzeu.zzm(zzbe);
                zzbe.zze(zzn);
            }
            zzx(zzn);
            zzeu.zza(zzef, this.zzalr);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zza(int i, zzef zzef) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zzb(3, 2);
            zzb(zzef);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzb(int i, zzbp zzbp) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbp);
            zzb(1, 4);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzb(zzef zzef) throws IOException {
            zzx(zzef.zzbz());
            zzef.zzb(this);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzw(int i) throws IOException {
            if (i >= 0) {
                zzx(i);
            } else {
                zzd((long) i);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzx(int i) throws IOException {
            if (!zzce.zzalq || zzbi.zzp() || zzba() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzfs.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzfs.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzfs.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzfs.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzfs.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzfs.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzfs.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzfs.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzfs.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzz(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (i >> 16);
                this.position = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzd(long j) throws IOException {
            if (!zzce.zzalq || zzba() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzfs.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzfs.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzf(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) ((int) (j >> 8));
                int i4 = i3 + 1;
                this.position = i4;
                bArr[i3] = (byte) ((int) (j >> 16));
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) ((int) (j >> 24));
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) ((int) (j >> 32));
                int i7 = i6 + 1;
                this.position = i7;
                bArr[i6] = (byte) ((int) (j >> 40));
                int i8 = i7 + 1;
                this.position = i8;
                bArr[i7] = (byte) ((int) (j >> 48));
                this.position = i8 + 1;
                bArr[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzbm
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final void zzf(String str) throws IOException {
            int i = this.position;
            try {
                int zzac = zzac(str.length() * 3);
                int zzac2 = zzac(str.length());
                if (zzac2 == zzac) {
                    int i2 = i + zzac2;
                    this.position = i2;
                    int zza = zzfv.zza(str, this.buffer, i2, zzba());
                    this.position = i;
                    zzx((zza - i) - zzac2);
                    this.position = zza;
                    return;
                }
                zzx(zzfv.zza(str));
                this.position = zzfv.zza(str, this.buffer, this.position, zzba());
            } catch (zzfy e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzce
        public final int zzba() {
            return this.limit - this.position;
        }
    }

    public final void zze(long j) throws IOException {
        zzd(zzl(j));
    }

    public final void zza(float f) throws IOException {
        zzz(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzf(Double.doubleToRawLongBits(d));
    }

    public final void zza(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzg(int i, int i2) {
        return zzaa(i) + zzab(i2);
    }

    public static int zzh(int i, int i2) {
        return zzaa(i) + zzac(i2);
    }

    public static int zzi(int i, int i2) {
        return zzaa(i) + zzac(zzah(i2));
    }

    public static int zzj(int i, int i2) {
        return zzaa(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzaa(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzaa(i) + zzh(j);
    }

    public static int zze(int i, long j) {
        return zzaa(i) + zzh(j);
    }

    public static int zzf(int i, long j) {
        return zzaa(i) + zzh(zzl(j));
    }

    public static int zzg(int i, long j) {
        return zzaa(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzaa(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzaa(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzaa(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzaa(i) + 1;
    }

    public static int zzl(int i, int i2) {
        return zzaa(i) + zzab(i2);
    }

    public static int zzb(int i, String str) {
        return zzaa(i) + zzg(str);
    }

    public static int zzc(int i, zzbp zzbp) {
        int zzaa = zzaa(i);
        int size = zzbp.size();
        return zzaa + zzac(size) + size;
    }

    public static int zza(int i, zzdk zzdk) {
        int zzaa = zzaa(i);
        int zzbz = zzdk.zzbz();
        return zzaa + zzac(zzbz) + zzbz;
    }

    static int zzb(int i, zzef zzef, zzeu zzeu) {
        return zzaa(i) + zza(zzef, zzeu);
    }

    public static int zzb(int i, zzef zzef) {
        return (zzaa(1) << 1) + zzh(2, i) + zzaa(3) + zzc(zzef);
    }

    public static int zzd(int i, zzbp zzbp) {
        return (zzaa(1) << 1) + zzh(2, i) + zzc(3, zzbp);
    }

    public static int zzb(int i, zzdk zzdk) {
        return (zzaa(1) << 1) + zzh(2, i) + zza(3, zzdk);
    }

    public static int zzaa(int i) {
        return zzac(i << 3);
    }

    public static int zzab(int i) {
        if (i >= 0) {
            return zzac(i);
        }
        return 10;
    }

    public static int zzad(int i) {
        return zzac(zzah(i));
    }

    public static int zzg(long j) {
        return zzh(j);
    }

    public static int zzi(long j) {
        return zzh(zzl(j));
    }

    public static int zzag(int i) {
        return zzab(i);
    }

    public static int zzg(String str) {
        int i;
        try {
            i = zzfv.zza(str);
        } catch (zzfy unused) {
            i = str.getBytes(zzcy.UTF_8).length;
        }
        return zzac(i) + i;
    }

    public static int zza(zzdk zzdk) {
        int zzbz = zzdk.zzbz();
        return zzac(zzbz) + zzbz;
    }

    public static int zzb(zzbp zzbp) {
        int size = zzbp.size();
        return zzac(size) + size;
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return zzac(length) + length;
    }

    public static int zzc(zzef zzef) {
        int zzbz = zzef.zzbz();
        return zzac(zzbz) + zzbz;
    }

    static int zza(zzef zzef, zzeu zzeu) {
        zzbe zzbe = (zzbe) zzef;
        int zzn = zzbe.zzn();
        if (zzn == -1) {
            zzn = zzeu.zzm(zzbe);
            zzbe.zze(zzn);
        }
        return zzac(zzn) + zzn;
    }

    public final void zzbb() {
        if (zzba() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzfy zzfy) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzfy);
        byte[] bytes = str.getBytes(zzcy.UTF_8);
        try {
            zzx(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        } catch (zzb e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzef zzef, zzeu zzeu) {
        int zzaa = zzaa(i) << 1;
        zzbe zzbe = (zzbe) zzef;
        int zzn = zzbe.zzn();
        if (zzn == -1) {
            zzn = zzeu.zzm(zzbe);
            zzbe.zze(zzn);
        }
        return zzaa + zzn;
    }

    @Deprecated
    public static int zzd(zzef zzef) {
        return zzef.zzbz();
    }

    @Deprecated
    public static int zzai(int i) {
        return zzac(i);
    }
}
