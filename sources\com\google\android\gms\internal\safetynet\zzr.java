package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;

final class zzr extends zzk.zze {
    private final /* synthetic */ String zzac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzr(zzk zzk, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzac = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzx zzx) throws RemoteException {
        ((zzi) zzx.getService()).zza(this.zzaf, this.zzac);
    }
}
