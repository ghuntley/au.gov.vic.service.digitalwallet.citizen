package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;

/* access modifiers changed from: package-private */
public final class zzl extends zzk.zzb {
    private final /* synthetic */ byte[] zzw;
    private final /* synthetic */ String zzx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzl(GoogleApiClient googleApiClient, byte[] bArr, String str) {
        super(googleApiClient);
        this.zzw = bArr;
        this.zzx = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzx zzx2) throws RemoteException {
        zzx zzx3 = zzx2;
        zzg zzg = this.zzaf;
        byte[] bArr = this.zzw;
        String str = this.zzx;
        if (TextUtils.isEmpty(str)) {
            str = zzx3.zzb("com.google.android.safetynet.ATTEST_API_KEY");
        }
        ((zzi) zzx3.getService()).zza(zzg, bArr, str);
    }
}
