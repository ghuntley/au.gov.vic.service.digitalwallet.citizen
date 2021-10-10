package com.google.android.gms.internal.instantapps;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.openid.appauth.AuthorizationRequest;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
public final class zzfs {
    private static final Logger logger = Logger.getLogger(zzfs.class.getName());
    private static final Class<?> zzakl = zzbi.zzq();
    private static final boolean zzalq = zzeg();
    private static final Unsafe zzarm;
    private static final boolean zzati;
    private static final boolean zzatj;
    private static final zzd zzatk;
    private static final boolean zzatl = zzeh();
    private static final long zzatm;
    private static final long zzatn = ((long) zzh(boolean[].class));
    private static final long zzato = ((long) zzi(boolean[].class));
    private static final long zzatp = ((long) zzh(int[].class));
    private static final long zzatq = ((long) zzi(int[].class));
    private static final long zzatr = ((long) zzh(long[].class));
    private static final long zzats = ((long) zzi(long[].class));
    private static final long zzatt = ((long) zzh(float[].class));
    private static final long zzatu = ((long) zzi(float[].class));
    private static final long zzatv = ((long) zzh(double[].class));
    private static final long zzatw = ((long) zzi(double[].class));
    private static final long zzatx = ((long) zzh(Object[].class));
    private static final long zzaty = ((long) zzi(Object[].class));
    private static final long zzatz;
    private static final int zzaua;
    static final boolean zzaub = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzfs() {
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final byte zzy(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzq(obj, j);
            }
            return zzfs.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfs.zzaub) {
                zzfs.zza(obj, j, b);
            } else {
                zzfs.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzs(obj, j);
            }
            return zzfs.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzfs.zzaub) {
                zzfs.zzb(obj, j, z);
            } else {
                zzfs.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzaue.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zze(Object obj, long j, byte b) {
            this.zzaue.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzaue.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzaue.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final float zzn(Object obj, long j) {
            return this.zzaue.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzaue.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final double zzo(Object obj, long j) {
            return this.zzaue.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, double d) {
            this.zzaue.putDouble(obj, j, d);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final byte zzy(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzq(obj, j);
            }
            return zzfs.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zze(Object obj, long j, byte b) {
            if (zzfs.zzaub) {
                zzfs.zza(obj, j, b);
            } else {
                zzfs.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzfs.zzaub) {
                return zzfs.zzs(obj, j);
            }
            return zzfs.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzfs.zzaub) {
                zzfs.zzb(obj, j, z);
            } else {
                zzfs.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.instantapps.zzfs.zzd
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static boolean zzed() {
        return zzalq;
    }

    /* access modifiers changed from: package-private */
    public static abstract class zzd {
        Unsafe zzaue;

        zzd(Unsafe unsafe) {
            this.zzaue = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzaue.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzaue.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzaue.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzaue.putLong(obj, j, j2);
        }
    }

    static boolean zzee() {
        return zzatl;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return (T) zzarm.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzalq) {
            return zzatk.zzaue.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzalq) {
            return zzatk.zzaue.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzatk.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzatk.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzatk.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzatk.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzatk.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzatk.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzatk.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzatk.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzatk.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzatk.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzatk.zzaue.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzatk.zzaue.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzatk.zzy(bArr, zzatm + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzatk.zze(bArr, zzatm + j, b);
    }

    static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfu());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Unsafe unsafe = zzarm;
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
            if (zzbi.zzp()) {
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

    private static boolean zzeh() {
        Unsafe unsafe = zzarm;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzei() == null) {
                return false;
            }
            if (zzbi.zzp()) {
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

    private static boolean zzj(Class<?> cls) {
        if (!zzbi.zzp()) {
            return false;
        }
        try {
            Class<?> cls2 = zzakl;
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

    private static Field zzei() {
        Field zzb2;
        if (zzbi.zzp() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, AuthorizationRequest.Scope.ADDRESS);
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
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
        Unsafe zzef = zzef();
        zzarm = zzef;
        boolean zzj = zzj(Long.TYPE);
        zzati = zzj;
        boolean zzj2 = zzj(Integer.TYPE);
        zzatj = zzj2;
        zzd zzd2 = null;
        if (zzef != null) {
            if (!zzbi.zzp()) {
                zzd2 = new zzb(zzef);
            } else if (zzj) {
                zzd2 = new zzc(zzef);
            } else if (zzj2) {
                zzd2 = new zza(zzef);
            }
        }
        zzatk = zzd2;
        long zzh = (long) zzh(byte[].class);
        zzatm = zzh;
        Field zzei = zzei();
        zzatz = (zzei == null || zzd2 == null) ? -1 : zzd2.zzaue.objectFieldOffset(zzei);
        zzaua = (int) (7 & zzh);
    }
}
