package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzag extends FusedLocationProviderClient.zzc {
    private final /* synthetic */ ListenerHolder zza;
    private final /* synthetic */ FusedLocationProviderClient zzb;

    zzag(FusedLocationProviderClient fusedLocationProviderClient, ListenerHolder listenerHolder) {
        this.zzb = fusedLocationProviderClient;
        this.zza = listenerHolder;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(zzay zzay, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException {
        zzay zzay2 = zzay;
        TaskCompletionSource<Boolean> taskCompletionSource2 = taskCompletionSource;
        if (zza()) {
            try {
                zzay2.zzb(this.zza.getListenerKey(), this.zzb.zza(taskCompletionSource2));
            } catch (RuntimeException e) {
                taskCompletionSource2.trySetException(e);
            }
        }
    }
}
