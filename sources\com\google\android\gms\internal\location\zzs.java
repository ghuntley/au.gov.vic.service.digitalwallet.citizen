package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final class zzs extends zzaa {
    private final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzs(zzn zzn, GoogleApiClient googleApiClient, boolean z) {
        super(googleApiClient);
        this.zza = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzay zzay) throws RemoteException {
        zzay.zza(this.zza);
        setResult((Result) Status.RESULT_SUCCESS);
    }
}
