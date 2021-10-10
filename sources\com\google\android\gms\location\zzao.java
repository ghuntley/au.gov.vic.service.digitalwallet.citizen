package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzd;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public abstract class zzao extends zza implements zzap {
    public zzao() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    public static zzap zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        if (queryLocalInterface instanceof zzap) {
            return (zzap) queryLocalInterface;
        }
        return new zzar(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.location.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((LocationResult) zzd.zza(parcel, LocationResult.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza((LocationAvailability) zzd.zza(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
