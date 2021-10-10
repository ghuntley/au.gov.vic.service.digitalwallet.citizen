package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzbs {
    private final boolean zza;

    public zzbs(zzbv zzbv) {
        zzde.zza(zzbv, "BuildInfo must be non-null");
        this.zza = !zzbv.zza();
    }

    public final boolean zza(String str) {
        zzde.zza(str, "flagName must not be null");
        if (!this.zza) {
            return true;
        }
        return zzbu.zza.zza().zza(str);
    }
}
