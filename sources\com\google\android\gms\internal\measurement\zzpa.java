package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzpa implements zzec<zzpd> {
    private static zzpa zza = new zzpa();
    private final zzec<zzpd> zzb;

    public static boolean zzb() {
        return ((zzpd) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpd) zza.zza()).zzb();
    }

    private zzpa(zzec<zzpd> zzec) {
        this.zzb = zzef.zza((zzec) zzec);
    }

    public zzpa() {
        this(zzef.zza(new zzpc()));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpd zza() {
        return this.zzb.zza();
    }
}
