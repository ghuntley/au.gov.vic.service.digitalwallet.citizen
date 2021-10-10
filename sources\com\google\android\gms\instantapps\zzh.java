package com.google.android.gms.instantapps;

import android.os.RemoteException;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.internal.instantapps.zzaf;
import com.google.android.gms.internal.instantapps.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

final /* synthetic */ class zzh implements BiConsumer {
    private final InstantAppsClient zzp;

    zzh(InstantAppsClient instantAppsClient) {
        this.zzp = instantAppsClient;
    }

    @Override // com.google.android.gms.common.util.BiConsumer
    public final void accept(Object obj, Object obj2) {
        zzaf zzaf = (zzaf) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        try {
            ((zzu) zzaf.getService()).zzb(new zzj(this.zzp, taskCompletionSource));
        } catch (RemoteException e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
