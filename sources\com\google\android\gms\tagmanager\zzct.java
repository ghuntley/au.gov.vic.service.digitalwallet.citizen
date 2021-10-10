package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.gtm.zzer;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;

public abstract class zzct extends zzn implements zzcs {
    public zzct() {
        super("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    public static zzcs asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerServiceProvider");
        if (queryLocalInterface instanceof zzcs) {
            return (zzcs) queryLocalInterface;
        }
        return new zzcu(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzn
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcm zzcm;
        if (i != 1) {
            return false;
        }
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        IBinder readStrongBinder = parcel.readStrongBinder();
        zzcd zzcd = null;
        if (readStrongBinder == null) {
            zzcm = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementProxy");
            if (queryLocalInterface instanceof zzcm) {
                zzcm = (zzcm) queryLocalInterface;
            } else {
                zzcm = new zzco(readStrongBinder);
            }
        }
        IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
            if (queryLocalInterface2 instanceof zzcd) {
                zzcd = (zzcd) queryLocalInterface2;
            } else {
                zzcd = new zzcf(readStrongBinder2);
            }
        }
        zzer service = getService(asInterface, zzcm, zzcd);
        parcel2.writeNoException();
        zzo.zza(parcel2, service);
        return true;
    }
}
