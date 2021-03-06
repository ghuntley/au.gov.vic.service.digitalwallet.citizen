package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzml;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
final class zzgj implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfz zzb;

    zzgj(zzfz zzfz, zzn zzn) {
        this.zzb = zzfz;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzr();
        zzkl zzkl = this.zzb.zza;
        zzn zzn = this.zza;
        if (zzml.zzb() && zzkl.zzb().zza(zzas.zzci)) {
            zzkl.zzp().zzc();
            zzkl.zzn();
            Preconditions.checkNotEmpty(zzn.zza);
            zzac zza2 = zzac.zza(zzn.zzw);
            zzac zza3 = zzkl.zza(zzn.zza);
            zzkl.zzq().zzw().zza("Setting consent, package, consent", zzn.zza, zza2);
            zzkl.zza(zzn.zza, zza2);
            if (zza2.zza(zza3)) {
                zzkl.zza(zzn);
            }
        }
    }
}
