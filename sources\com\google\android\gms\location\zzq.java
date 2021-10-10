package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final /* synthetic */ class zzq implements RemoteCall {
    private final FusedLocationProviderClient zza;

    zzq(FusedLocationProviderClient fusedLocationProviderClient) {
        this.zza = fusedLocationProviderClient;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        this.zza.zza((zzay) obj, (TaskCompletionSource) obj2);
    }
}
