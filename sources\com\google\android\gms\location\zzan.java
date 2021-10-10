package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public class zzan extends zza implements zzak {
    public static zzak zza(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        if (queryLocalInterface instanceof zzak) {
            return (zzak) queryLocalInterface;
        }
        return new zzam(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.location.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw new NoSuchMethodError();
    }
}
