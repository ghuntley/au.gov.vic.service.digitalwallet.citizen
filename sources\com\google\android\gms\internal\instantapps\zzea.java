package com.google.android.gms.internal.instantapps;

final class zzea {
    private static final zzdy zzarj = zzda();
    private static final zzdy zzark = new zzeb();

    static zzdy zzcy() {
        return zzarj;
    }

    static zzdy zzcz() {
        return zzark;
    }

    private static zzdy zzda() {
        try {
            return (zzdy) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
