package com.google.android.gms.internal.instantapps;

final class zzep {
    private static final zzen zzase = zzdh();
    private static final zzen zzasf = new zzem();

    static zzen zzdf() {
        return zzase;
    }

    static zzen zzdg() {
        return zzasf;
    }

    private static zzen zzdh() {
        try {
            return (zzen) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
