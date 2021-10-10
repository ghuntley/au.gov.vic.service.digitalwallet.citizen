package com.google.android.gms.internal.safetynet;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.safetynet.zzk;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class zzn extends zzk.zzf {
    private final /* synthetic */ int[] zzaa;
    private final /* synthetic */ int zzab;
    private final /* synthetic */ String zzx;
    private final /* synthetic */ String zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzn(GoogleApiClient googleApiClient, int[] iArr, int i, String str, String str2) {
        super(googleApiClient);
        this.zzaa = iArr;
        this.zzab = i;
        this.zzz = str;
        this.zzx = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzx zzx2) throws RemoteException {
        zzx zzx3 = zzx2;
        ArrayList arrayList = new ArrayList();
        for (int i : this.zzaa) {
            arrayList.add(Integer.valueOf(i));
        }
        zzx3.zza(this.zzaf, arrayList, this.zzab, this.zzz, this.zzx);
    }
}
