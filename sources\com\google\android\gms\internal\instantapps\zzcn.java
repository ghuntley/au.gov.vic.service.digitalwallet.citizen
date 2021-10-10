package com.google.android.gms.internal.instantapps;

final class zzcn {
    private static final zzcm<?> zzamb = new zzco();
    private static final zzcm<?> zzamc = zzbi();

    private static zzcm<?> zzbi() {
        try {
            return (zzcm) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzcm<?> zzbj() {
        return zzamb;
    }

    static zzcm<?> zzbk() {
        zzcm<?> zzcm = zzamc;
        if (zzcm != null) {
            return zzcm;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
