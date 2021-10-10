package com.google.android.gms.internal.instantapps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.zzf;

/* access modifiers changed from: package-private */
public final class zzz extends zzad<zzf> {
    zzz(zzy zzy, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.instantapps.zzad
    public final void zza(Context context, zzu zzu) throws RemoteException {
        zzu.zza(new zzab(this));
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzac(this, status);
    }
}
