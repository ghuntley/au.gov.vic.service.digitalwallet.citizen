package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;
import java.util.Map;

public abstract class zzcn extends zzn implements zzcm {
    public zzcn() {
        super("com.google.android.gms.tagmanager.IMeasurementProxy");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzn
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            logEventInternalNoInterceptor(parcel.readString(), parcel.readString(), (Bundle) zzo.zza(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
            return true;
        } else if (i != 11) {
            zzcj zzcj = null;
            zzcg zzcg = null;
            if (i == 21) {
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementInterceptor");
                    if (queryLocalInterface instanceof zzcj) {
                        zzcj = (zzcj) queryLocalInterface;
                    } else {
                        zzcj = new zzcl(readStrongBinder);
                    }
                }
                zza(zzcj);
                parcel2.writeNoException();
                return true;
            } else if (i != 22) {
                return false;
            } else {
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementEventListener");
                    if (queryLocalInterface2 instanceof zzcg) {
                        zzcg = (zzcg) queryLocalInterface2;
                    } else {
                        zzcg = new zzci(readStrongBinder2);
                    }
                }
                zza(zzcg);
                parcel2.writeNoException();
                return true;
            }
        } else {
            Map zzib = zzib();
            parcel2.writeNoException();
            parcel2.writeMap(zzib);
            return true;
        }
    }
}
