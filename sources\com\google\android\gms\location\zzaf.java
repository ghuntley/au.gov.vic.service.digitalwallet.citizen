package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.internal.location.zzac;
import com.google.android.gms.internal.location.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzaf extends zzah {
    private final /* synthetic */ TaskCompletionSource zza;

    zzaf(FusedLocationProviderClient fusedLocationProviderClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void a_() {
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zza(zzac zzac) throws RemoteException {
        Status status = zzac.getStatus();
        if (status == null) {
            this.zza.trySetException(new ApiException(new Status(8, "Got null status from location service")));
        } else if (status.getStatusCode() == 0) {
            this.zza.setResult(true);
        } else {
            this.zza.trySetException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
