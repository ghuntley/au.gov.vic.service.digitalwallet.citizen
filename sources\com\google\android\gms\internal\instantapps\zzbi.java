package com.google.android.gms.internal.instantapps;

final class zzbi {
    private static final Class<?> zzakl = zzd("libcore.io.Memory");
    private static final boolean zzakm = (zzd("org.robolectric.Robolectric") != null);

    static boolean zzp() {
        return zzakl != null && !zzakm;
    }

    static Class<?> zzq() {
        return zzakl;
    }

    private static <T> Class<T> zzd(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
