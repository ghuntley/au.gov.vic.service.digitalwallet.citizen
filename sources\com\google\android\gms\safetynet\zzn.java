package com.google.android.gms.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.safetynet.zzi;
import com.google.android.gms.internal.safetynet.zzx;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzn extends TaskApiCall<zzx, Void> {
    zzn(SafetyNetClient safetyNetClient) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(zzx zzx, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzi) zzx.getService()).zzb();
    }
}
