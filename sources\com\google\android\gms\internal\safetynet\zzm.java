package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;
import java.util.List;

final class zzm extends zzk.zzf {
    private final /* synthetic */ String zzx = null;
    private final /* synthetic */ List zzy;
    private final /* synthetic */ String zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzm(zzk zzk, GoogleApiClient googleApiClient, List list, String str, String str2) {
        super(googleApiClient);
        this.zzy = list;
        this.zzz = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzx zzx2) throws RemoteException {
        zzx2.zza(this.zzaf, this.zzy, 1, this.zzz, this.zzx);
    }
}
