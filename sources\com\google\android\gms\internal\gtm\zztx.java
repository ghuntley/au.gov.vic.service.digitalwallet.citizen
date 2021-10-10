package com.google.android.gms.internal.gtm;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import net.openid.appauth.AuthorizationRequest;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
public final class zztx {
    private static final Logger logger = Logger.getLogger(zztx.class.getName());
    private static final Class<?> zzavt = zzpp.zznb();
    private static final boolean zzawt = zzrp();
    private static final Unsafe zzbcx;
    private static final boolean zzbet;
    private static final boolean zzbeu;
    private static final zzd zzbev;
    private static final boolean zzbew = zzrq();
    static final long zzbex;
    private static final long zzbey = ((long) zzl(boolean[].class));
    private static final long zzbez = ((long) zzm(boolean[].class));
    private static final long zzbfa = ((long) zzl(int[].class));
    private static final long zzbfb = ((long) zzm(int[].class));
    private static final long zzbfc = ((long) zzl(long[].class));
    private static final long zzbfd = ((long) zzm(long[].class));
    private static final long zzbfe = ((long) zzl(float[].class));
    private static final long zzbff = ((long) zzm(float[].class));
    private static final long zzbfg = ((long) zzl(double[].class));
    private static final long zzbfh = ((long) zzm(double[].class));
    private static final long zzbfi = ((long) zzl(Object[].class));
    private static final long zzbfj = ((long) zzm(Object[].class));
    private static final long zzbfk;
    private static final int zzbfl;
    static final boolean zzbfm = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zztx() {
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j);
            }
            return zztx.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j, b);
            } else {
                zztx.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j);
            }
            return zztx.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j, z);
            } else {
                zztx.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            this.zzbfn.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzbfn.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzbfn.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzbfn.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzbfn.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return this.zzbfn.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzbfn.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return this.zzbfn.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzbfn.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzbfn.copyMemory(bArr, zztx.zzbex + j, (Object) null, j2, j3);
        }
    }

    static boolean zzrm() {
        return zzawt;
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzd {
        Unsafe zzbfn;

        zzd(Unsafe unsafe) {
            this.zzbfn = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzbfn.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzbfn.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzbfn.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzbfn.putLong(obj, j, j2);
        }
    }

    static boolean zzrn() {
        return zzbew;
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & -1), b);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final byte zzy(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j);
            }
            return zztx.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j, b);
            } else {
                zztx.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final boolean zzm(Object obj, long j) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j);
            }
            return zztx.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j, z);
            } else {
                zztx.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.zztx.zzd
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }
    }

    static <T> T zzk(Class<T> cls) {
        try {
            return (T) zzbcx.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzl(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzm(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzbev.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzbev.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzbev.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzbev.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzbev.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzbev.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzbev.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzbev.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzbev.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzbev.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzbev.zzbfn.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzbev.zzbfn.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzbev.zzy(bArr, zzbex + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzbev.zze(bArr, zzbex + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzbev.zza(bArr, j, j2, j3);
    }

    static void zza(long j, byte b) {
        zzbev.zza(j, b);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzbev.zzl(byteBuffer, zzbfk);
    }

    static Unsafe zzro() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzty());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzrp() {
        Unsafe unsafe = zzbcx;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzpp.zzna()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzrq() {
        Unsafe unsafe = zzbcx;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzrr() == null) {
                return false;
            }
            if (zzpp.zzna()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzn(Class<?> cls) {
        if (!zzpp.zzna()) {
            return false;
        }
        try {
            Class<?> cls2 = zzavt;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzrr() {
        Field zzb2;
        if (zzpp.zzna() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, AuthorizationRequest.Scope.ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    static int zza(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        int i4;
        if (i < 0 || i2 < 0 || i3 < 0 || i + i3 > bArr.length || i2 + i3 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (zzawt) {
            int i6 = (zzbfl + i) & 7;
            while (i5 < i3 && (i6 & 7) != 0) {
                if (bArr[i + i5] != bArr2[i2 + i5]) {
                    return i5;
                }
                i5++;
                i6++;
            }
            int i7 = ((i3 - i5) & -8) + i5;
            while (i5 < i7) {
                long j = zzbex;
                long j2 = (long) i5;
                long zzl = zzl(bArr, ((long) i) + j + j2);
                long zzl2 = zzl(bArr2, j + ((long) i2) + j2);
                if (zzl != zzl2) {
                    if (zzbfm) {
                        i4 = Long.numberOfLeadingZeros(zzl ^ zzl2);
                    } else {
                        i4 = Long.numberOfTrailingZeros(zzl ^ zzl2);
                    }
                    return i5 + (i4 >> 3);
                }
                i5 += 8;
            }
        }
        while (i5 < i3) {
            if (bArr[i + i5] != bArr2[i2 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        Unsafe zzro = zzro();
        zzbcx = zzro;
        boolean zzn = zzn(Long.TYPE);
        zzbet = zzn;
        boolean zzn2 = zzn(Integer.TYPE);
        zzbeu = zzn2;
        zzd zzd2 = null;
        if (zzro != null) {
            if (!zzpp.zzna()) {
                zzd2 = new zzc(zzro);
            } else if (zzn) {
                zzd2 = new zzb(zzro);
            } else if (zzn2) {
                zzd2 = new zza(zzro);
            }
        }
        zzbev = zzd2;
        long zzl = (long) zzl(byte[].class);
        zzbex = zzl;
        Field zzrr = zzrr();
        zzbfk = (zzrr == null || zzd2 == null) ? -1 : zzd2.zzbfn.objectFieldOffset(zzrr);
        zzbfl = (int) (7 & zzl);
    }
}
