package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzku {
    private static final zzks zza = zzc();
    private static final zzks zzb = new zzkv();

    static zzks zza() {
        return zza;
    }

    static zzks zzb() {
        return zzb;
    }

    private static zzks zzc() {
        try {
            return (zzks) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
