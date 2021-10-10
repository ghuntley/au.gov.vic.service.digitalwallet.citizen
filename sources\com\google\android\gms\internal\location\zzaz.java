package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzaz extends zzaq {
    private BaseImplementation.ResultHolder<LocationSettingsResult> zza;

    public zzaz(BaseImplementation.ResultHolder<LocationSettingsResult> resultHolder) {
        Preconditions.checkArgument(resultHolder != null, "listener can't be null.");
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzan
    public final void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.zza.setResult(locationSettingsResult);
        this.zza = null;
    }
}
