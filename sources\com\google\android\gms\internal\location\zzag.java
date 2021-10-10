package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.zzbe;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzag extends zzaf {
    private final /* synthetic */ zzbe zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(zzae zzae, GoogleApiClient googleApiClient, zzbe zzbe) {
        super(googleApiClient);
        this.zza = zzbe;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzay zzay) throws RemoteException {
        zzay.zza(this.zza, this);
    }
}
