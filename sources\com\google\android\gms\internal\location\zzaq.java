package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public abstract class zzaq extends zza implements zzan {
    public zzaq() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.location.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza((LocationSettingsResult) zzd.zza(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
