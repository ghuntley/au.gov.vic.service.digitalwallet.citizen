package com.google.android.gms.location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final /* synthetic */ class zzw implements FusedLocationProviderClient.zza {
    private final TaskCompletionSource zza;

    zzw(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.location.FusedLocationProviderClient.zza
    public final void zza() {
        this.zza.trySetResult(null);
    }
}
