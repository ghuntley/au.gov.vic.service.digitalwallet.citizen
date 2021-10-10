package com.google.android.gms.location;

import com.google.android.gms.location.FusedLocationProviderClient;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final /* synthetic */ class zzu implements FusedLocationProviderClient.zza {
    private final FusedLocationProviderClient zza;
    private final FusedLocationProviderClient.zzc zzb;
    private final LocationCallback zzc;
    private final FusedLocationProviderClient.zza zzd;

    zzu(FusedLocationProviderClient fusedLocationProviderClient, FusedLocationProviderClient.zzc zzc2, LocationCallback locationCallback, FusedLocationProviderClient.zza zza2) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzc2;
        this.zzc = locationCallback;
        this.zzd = zza2;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient.zza
    public final void zza() {
        FusedLocationProviderClient fusedLocationProviderClient = this.zza;
        FusedLocationProviderClient.zzc zzc2 = this.zzb;
        LocationCallback locationCallback = this.zzc;
        FusedLocationProviderClient.zza zza2 = this.zzd;
        zzc2.zza(false);
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        if (zza2 != null) {
            zza2.zza();
        }
    }
}
