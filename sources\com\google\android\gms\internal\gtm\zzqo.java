package com.google.android.gms.internal.gtm;

/* access modifiers changed from: package-private */
public final class zzqo {
    private static final Class<?> zzaxg = zzom();

    private static Class<?> zzom() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzqp zzon() {
        if (zzaxg != null) {
            try {
                return zzdc("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzqp.zzaxk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    static zzqp zzoo() {
        zzqp zzqp;
        if (zzaxg != null) {
            try {
                zzqp = zzdc("loadGeneratedRegistry");
            } catch (Exception unused) {
            }
            if (zzqp == null) {
                zzqp = zzqp.zzoo();
            }
            return zzqp != null ? zzon() : zzqp;
        }
        zzqp = null;
        if (zzqp == null) {
        }
        if (zzqp != null) {
        }
    }

    private static final zzqp zzdc(String str) throws Exception {
        return (zzqp) zzaxg.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
