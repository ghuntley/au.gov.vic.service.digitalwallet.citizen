package com.google.android.gms.internal.instantapps;

/* access modifiers changed from: package-private */
public final class zzcl {
    private static final Class<?> zzama = zzbg();

    private static Class<?> zzbg() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzck zzbh() {
        Class<?> cls = zzama;
        if (cls != null) {
            try {
                return (zzck) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzck.zzaly;
    }
}
