package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.internal.location.zzbc;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final /* synthetic */ class zzz implements RemoteCall {
    private final FusedLocationProviderClient zza;
    private final zzbc zzb;
    private final PendingIntent zzc;

    zzz(FusedLocationProviderClient fusedLocationProviderClient, zzbc zzbc, PendingIntent pendingIntent) {
        this.zza = fusedLocationProviderClient;
        this.zzb = zzbc;
        this.zzc = pendingIntent;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zza.zza(this.zzb, this.zzc, (zzay) obj, (TaskCompletionSource) obj2);
    }
}
