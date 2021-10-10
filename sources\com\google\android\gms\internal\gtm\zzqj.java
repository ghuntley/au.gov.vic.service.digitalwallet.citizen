package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzqj extends zzpr {
    private static final Logger logger = Logger.getLogger(zzqj.class.getName());
    private static final boolean zzawt = zztx.zzrm();
    zzql zzawu;

    static final class zzb extends zza {
        private final ByteBuffer zzawv;
        private int zzaww;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zzawv = byteBuffer;
            this.zzaww = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.gtm.zzqj, com.google.android.gms.internal.gtm.zzqj.zza
        public final void flush() {
            this.zzawv.position(this.zzaww + zzok());
        }
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzbd(int i) {
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

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    private static int zzbi(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static int zzc(double d) {
        return 8;
    }

    public static zzqj zzg(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzj(boolean z) {
        return 1;
    }

    public static int zzt(long j) {
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

    public static int zzv(long j) {
        return 8;
    }

    public static int zzw(long j) {
        return 8;
    }

    private static long zzx(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzps zzps) throws IOException;

    public abstract void zza(int i, zzsk zzsk) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzsk zzsk, zzsz zzsz) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(zzps zzps) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzsk zzsk, zzsz zzsz) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public abstract void zzb(int i, zzps zzps) throws IOException;

    public abstract void zzb(int i, zzsk zzsk) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public abstract void zzb(zzsk zzsk) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzcz(String str) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, int i2) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract int zzoi();

    public abstract void zzp(long j) throws IOException;

    public abstract void zzr(long j) throws IOException;

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        zzc(String str) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "));
            String valueOf = String.valueOf(str);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        zzc(String str, Throwable th) {
            super(r3.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(r3) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
            String valueOf = String.valueOf(str);
        }
    }

    public static zzqj zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (zztx.zzrn()) {
            return new zze(byteBuffer);
        } else {
            return new zzd(byteBuffer);
        }
    }

    static final class zzd extends zzqj {
        private final int zzaww;
        private final ByteBuffer zzawx;
        private final ByteBuffer zzawy;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zzawx = byteBuffer;
            this.zzawy = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zzaww = byteBuffer.position();
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzps) throws IOException {
            zzd(i, 2);
            zza(zzps);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk) throws IOException {
            zzd(i, 2);
            zzb(zzsk);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i, 2);
            zza(zzsk, zzsz);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzsk);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzps);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            try {
                this.zzawy.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp((long) i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzawy.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzawy.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            try {
                this.zzawy.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzawy.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzawy.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            try {
                this.zzawy.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc(e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzawy.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            } catch (BufferOverflowException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int position = this.zzawy.position();
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int position2 = this.zzawy.position() + zzbd2;
                    this.zzawy.position(position2);
                    zzdb(str);
                    int position3 = this.zzawy.position();
                    this.zzawy.position(position);
                    zzay(position3 - position2);
                    this.zzawy.position(position3);
                    return;
                }
                zzay(zztz.zza(str));
                zzdb(str);
            } catch (zzud e) {
                this.zzawy.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.zzawx.position(this.zzawy.position());
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.zzawy.remaining();
        }

        private final void zzdb(String str) throws IOException {
            try {
                zztz.zza(str, this.zzawy);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(e);
            }
        }
    }

    static final class zze extends zzqj {
        private final ByteBuffer zzawx;
        private final ByteBuffer zzawy;
        private final long zzawz;
        private final long zzaxa;
        private final long zzaxb;
        private final long zzaxc;
        private long zzaxd;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zzawx = byteBuffer;
            this.zzawy = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long zzb = zztx.zzb(byteBuffer);
            this.zzawz = zzb;
            long position = ((long) byteBuffer.position()) + zzb;
            this.zzaxa = position;
            long limit = zzb + ((long) byteBuffer.limit());
            this.zzaxb = limit;
            this.zzaxc = limit - 10;
            this.zzaxd = position;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzps) throws IOException {
            zzd(i, 2);
            zza(zzps);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk) throws IOException {
            zzd(i, 2);
            zzb(zzsk);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i, 2);
            zza(zzsk, zzsz);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzsk);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzps);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            long j = this.zzaxd;
            if (j < this.zzaxb) {
                this.zzaxd = 1 + j;
                zztx.zza(j, b);
                return;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp((long) i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (this.zzaxd <= this.zzaxc) {
                while ((i & -128) != 0) {
                    long j = this.zzaxd;
                    this.zzaxd = j + 1;
                    zztx.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zzaxd;
                this.zzaxd = 1 + j2;
                zztx.zza(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.zzaxd;
                if (j3 >= this.zzaxb) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1));
                } else if ((i & -128) == 0) {
                    this.zzaxd = 1 + j3;
                    zztx.zza(j3, (byte) i);
                    return;
                } else {
                    this.zzaxd = j3 + 1;
                    zztx.zza(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
            this.zzawy.putInt((int) (this.zzaxd - this.zzawz), i);
            this.zzaxd += 4;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (this.zzaxd <= this.zzaxc) {
                while ((j & -128) != 0) {
                    long j2 = this.zzaxd;
                    this.zzaxd = j2 + 1;
                    zztx.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zzaxd;
                this.zzaxd = 1 + j3;
                zztx.zza(j3, (byte) ((int) j));
                return;
            }
            while (true) {
                long j4 = this.zzaxd;
                if (j4 >= this.zzaxb) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), 1));
                } else if ((j & -128) == 0) {
                    this.zzaxd = 1 + j4;
                    zztx.zza(j4, (byte) ((int) j));
                    return;
                } else {
                    this.zzaxd = j4 + 1;
                    zztx.zza(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
            this.zzawy.putLong((int) (this.zzaxd - this.zzawz), j);
            this.zzaxd += 8;
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = (long) i2;
                long j2 = this.zzaxd;
                if (this.zzaxb - j >= j2) {
                    zztx.zza(bArr, (long) i, j2, j);
                    this.zzaxd += j;
                    return;
                }
            }
            Objects.requireNonNull(bArr, "value");
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.zzaxd), Long.valueOf(this.zzaxb), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            long j = this.zzaxd;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i = ((int) (this.zzaxd - this.zzawz)) + zzbd2;
                    this.zzawy.position(i);
                    zztz.zza(str, this.zzawy);
                    int position = this.zzawy.position() - i;
                    zzay(position);
                    this.zzaxd += (long) position;
                    return;
                }
                int zza = zztz.zza(str);
                zzay(zza);
                zzy(this.zzaxd);
                zztz.zza(str, this.zzawy);
                this.zzaxd += (long) zza;
            } catch (zzud e) {
                this.zzaxd = j;
                zzy(j);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc(e3);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void flush() {
            this.zzawx.position((int) (this.zzaxd - this.zzawz));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return (int) (this.zzaxb - this.zzaxd);
        }

        private final void zzy(long j) {
            this.zzawy.position((int) (j - this.zzawz));
        }
    }

    /* access modifiers changed from: package-private */
    public static class zza extends zzqj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            Objects.requireNonNull(bArr, "buffer");
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) >= 0) {
                this.buffer = bArr;
                this.offset = i;
                this.position = i;
                this.limit = i3;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public void flush() {
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzd(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(int i, int i2) throws IOException {
            zzd(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzf(int i, int i2) throws IOException {
            zzd(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzh(int i, int i2) throws IOException {
            zzd(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, long j) throws IOException {
            zzd(i, 0);
            zzp(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(int i, long j) throws IOException {
            zzd(i, 1);
            zzr(j);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, boolean z) throws IOException {
            zzd(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, String str) throws IOException {
            zzd(i, 2);
            zzcz(str);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzps zzps) throws IOException {
            zzd(i, 2);
            zza(zzps);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzps zzps) throws IOException {
            zzay(zzps.size());
            zzps.zza(this);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk) throws IOException {
            zzd(i, 2);
            zzb(zzsk);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(int i, zzsk zzsk, zzsz zzsz) throws IOException {
            zzd(i, 2);
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzsk zzsk) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzsk);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(int i, zzps zzps) throws IOException {
            zzd(1, 3);
            zzf(2, i);
            zza(3, zzps);
            zzd(1, 4);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzb(zzsk zzsk) throws IOException {
            zzay(zzsk.zzpe());
            zzsk.zzb(this);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zza(zzsk zzsk, zzsz zzsz) throws IOException {
            zzpl zzpl = (zzpl) zzsk;
            int zzmw = zzpl.zzmw();
            if (zzmw == -1) {
                zzmw = zzsz.zzad(zzpl);
                zzpl.zzag(zzmw);
            }
            zzay(zzmw);
            zzsz.zza(zzsk, this.zzawu);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzp((long) i);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzay(int i) throws IOException {
            if (!zzqj.zzawt || zzpp.zzna() || zzoi() < 5) {
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zztx.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zztx.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zztx.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zztx.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zztx.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zztx.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zztx.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zztx.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zztx.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzba(int i) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzp(long j) throws IOException {
            if (!zzqj.zzawt || zzoi() < 10) {
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
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zztx.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zztx.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzr(long j) throws IOException {
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
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzpr
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final void zzcz(String str) throws IOException {
            int i = this.position;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i2 = i + zzbd2;
                    this.position = i2;
                    int zza = zztz.zza(str, this.buffer, i2, zzoi());
                    this.position = i;
                    zzay((zza - i) - zzbd2);
                    this.position = zza;
                    return;
                }
                zzay(zztz.zza(str));
                this.position = zztz.zza(str, this.buffer, this.position, zzoi());
            } catch (zzud e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc(e2);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zzqj
        public final int zzoi() {
            return this.limit - this.position;
        }

        public final int zzok() {
            return this.position - this.offset;
        }
    }

    private zzqj() {
    }

    public final void zzg(int i, int i2) throws IOException {
        zzf(i, zzbi(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzx(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzh(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzaz(int i) throws IOException {
        zzay(zzbi(i));
    }

    public final void zzq(long j) throws IOException {
        zzp(zzx(j));
    }

    public final void zza(float f) throws IOException {
        zzba(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzr(Double.doubleToRawLongBits(d));
    }

    public final void zzi(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzi(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzj(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzk(int i, int i2) {
        return zzbb(i) + zzbd(zzbi(i2));
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzt(j);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzt(zzx(j));
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbb(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzbb(i) + 8;
    }

    public static int zzc(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzn(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzda(str);
    }

    public static int zzc(int i, zzps zzps) {
        int zzbb = zzbb(i);
        int size = zzps.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zza(int i, zzrr zzrr) {
        int zzbb = zzbb(i);
        int zzpe = zzrr.zzpe();
        return zzbb + zzbd(zzpe) + zzpe;
    }

    public static int zzc(int i, zzsk zzsk) {
        return zzbb(i) + zzc(zzsk);
    }

    static int zzb(int i, zzsk zzsk, zzsz zzsz) {
        return zzbb(i) + zzb(zzsk, zzsz);
    }

    public static int zzd(int i, zzsk zzsk) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzsk);
    }

    public static int zzd(int i, zzps zzps) {
        return (zzbb(1) << 1) + zzj(2, i) + zzc(3, zzps);
    }

    public static int zzb(int i, zzrr zzrr) {
        return (zzbb(1) << 1) + zzj(2, i) + zza(3, zzrr);
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbe(int i) {
        return zzbd(zzbi(i));
    }

    public static int zzs(long j) {
        return zzt(j);
    }

    public static int zzu(long j) {
        return zzt(zzx(j));
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    public static int zzda(String str) {
        int i;
        try {
            i = zztz.zza(str);
        } catch (zzud unused) {
            i = str.getBytes(zzre.UTF_8).length;
        }
        return zzbd(i) + i;
    }

    public static int zza(zzrr zzrr) {
        int zzpe = zzrr.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    public static int zzb(zzps zzps) {
        int size = zzps.size();
        return zzbd(size) + size;
    }

    public static int zzh(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzc(zzsk zzsk) {
        int zzpe = zzsk.zzpe();
        return zzbd(zzpe) + zzpe;
    }

    static int zzb(zzsk zzsk, zzsz zzsz) {
        zzpl zzpl = (zzpl) zzsk;
        int zzmw = zzpl.zzmw();
        if (zzmw == -1) {
            zzmw = zzsz.zzad(zzpl);
            zzpl.zzag(zzmw);
        }
        return zzbd(zzmw) + zzmw;
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzud zzud) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzud);
        byte[] bytes = str.getBytes(zzre.UTF_8);
        try {
            zzay(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc(e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzsk zzsk, zzsz zzsz) {
        int zzbb = zzbb(i) << 1;
        zzpl zzpl = (zzpl) zzsk;
        int zzmw = zzpl.zzmw();
        if (zzmw == -1) {
            zzmw = zzsz.zzad(zzpl);
            zzpl.zzag(zzmw);
        }
        return zzbb + zzmw;
    }

    @Deprecated
    public static int zzd(zzsk zzsk) {
        return zzsk.zzpe();
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }
}
