package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzge implements Callable<List<zzz>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzfz zzd;

    zzge(zzfz zzfz, zzn zzn, String str, String str2) {
        this.zzd = zzfz;
        this.zza = zzn;
        this.zzb = str;
        this.zzc = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        this.zzd.zza.zzr();
        return this.zzd.zza.zze().zzb(this.zza.zza, this.zzb, this.zzc);
    }
}
