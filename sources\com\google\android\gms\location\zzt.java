package com.google.android.gms.location;

import com.google.android.gms.tasks.OnTokenCanceledListener;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final /* synthetic */ class zzt implements OnTokenCanceledListener {
    private final FusedLocationProviderClient zza;
    private final LocationCallback zzb;

    zzt(FusedLocationProviderClient fusedLocationProviderClient, LocationCallback locationCallback) {
        this.zza = fusedLocationProviderClient;
        this.zzb = locationCallback;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        this.zza.removeLocationUpdates(this.zzb);
    }
}
