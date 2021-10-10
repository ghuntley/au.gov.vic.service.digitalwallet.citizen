package com.google.android.gms.internal.gtm;

final class zzpp {
    private static final Class<?> zzavt = zzcx("libcore.io.Memory");
    private static final boolean zzavu = (zzcx("org.robolectric.Robolectric") != null);

    static boolean zzna() {
        return zzavt != null && !zzavu;
    }

    static Class<?> zznb() {
        return zzavt;
    }

    private static <T> Class<T> zzcx(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
