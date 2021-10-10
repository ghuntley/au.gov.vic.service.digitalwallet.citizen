package com.google.android.gms.vision.clearcut;

import com.google.android.gms.internal.vision.zzfi;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zza implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ zzfi.zzo zzb;
    private final /* synthetic */ DynamiteClearcutLogger zzc;

    zza(DynamiteClearcutLogger dynamiteClearcutLogger, int i, zzfi.zzo zzo) {
        this.zzc = dynamiteClearcutLogger;
        this.zza = i;
        this.zzb = zzo;
    }

    public final void run() {
        DynamiteClearcutLogger.zza(this.zzc).zza(this.zza, this.zzb);
    }
}
