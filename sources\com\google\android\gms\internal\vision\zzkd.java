package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzkd implements zzkl {
    private zzkl[] zza;

    zzkd(zzkl... zzklArr) {
        this.zza = zzklArr;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final boolean zza(Class<?> cls) {
        for (zzkl zzkl : this.zza) {
            if (zzkl.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzkl
    public final zzki zzb(Class<?> cls) {
        zzkl[] zzklArr = this.zza;
        for (zzkl zzkl : zzklArr) {
            if (zzkl.zza(cls)) {
                return zzkl.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
