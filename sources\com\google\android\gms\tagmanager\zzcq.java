package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;

public abstract class zzcq extends zzn implements zzcp {
    public zzcq() {
        super("com.google.android.gms.tagmanager.ITagManagerApi");
    }

    public static zzcp asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.tagmanager.ITagManagerApi");
        if (queryLocalInterface instanceof zzcp) {
            return (zzcp) queryLocalInterface;
        }
        return new zzcr(iBinder);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzn
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcm zzcm;
        zzcm zzcm2;
        zzcm zzcm3;
        zzcd zzcd = null;
        if (i == 1) {
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
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
            initialize(asInterface, zzcm, zzcd);
        } else if (i == 2) {
            preview((Intent) zzo.zza(parcel, Intent.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
        } else if (i != 3) {
            return false;
        } else {
            Intent intent = (Intent) zzo.zza(parcel, Intent.CREATOR);
            IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 == null) {
                zzcm2 = null;
            } else {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.tagmanager.IMeasurementProxy");
                if (queryLocalInterface3 instanceof zzcm) {
                    zzcm3 = (zzcm) queryLocalInterface3;
                } else {
                    zzcm3 = new zzco(readStrongBinder3);
                }
                zzcm2 = zzcm3;
            }
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
                if (queryLocalInterface4 instanceof zzcd) {
                    zzcd = (zzcd) queryLocalInterface4;
                } else {
                    zzcd = new zzcf(readStrongBinder4);
                }
            }
            previewIntent(intent, asInterface2, asInterface3, zzcm2, zzcd);
        }
        parcel2.writeNoException();
        return true;
    }
}
