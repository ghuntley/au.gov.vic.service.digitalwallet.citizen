package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.instantapps.InstantApps;

/* access modifiers changed from: package-private */
public abstract class zzad<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzaf> {
    zzad(GoogleApiClient googleApiClient) {
        super(InstantApps.API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Context context, zzu zzu) throws RemoteException;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public /* synthetic */ void doExecute(zzaf zzaf) throws RemoteException {
        zzaf zzaf2 = zzaf;
        zza(zzaf2.getContext(), (zzu) zzaf2.getService());
    }
}
