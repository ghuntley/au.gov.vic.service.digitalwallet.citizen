package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final class zzw extends zzaa {
    private final /* synthetic */ LocationRequest zza;
    private final /* synthetic */ LocationCallback zzb;
    private final /* synthetic */ Looper zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzw(zzn zzn, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        super(googleApiClient);
        this.zza = locationRequest;
        this.zzb = locationCallback;
        this.zzc = looper;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.common.api.Api$AnyClient] */
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(zzay zzay) throws RemoteException {
        zzay.zza(zzbc.zza(this.zza), ListenerHolders.createListenerHolder(this.zzb, zzbj.zza(this.zzc), LocationCallback.class.getSimpleName()), new zzz(this));
    }
}
