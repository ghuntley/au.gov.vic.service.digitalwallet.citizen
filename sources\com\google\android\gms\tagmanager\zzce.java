package com.google.android.gms.tagmanager;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzn;
import com.google.android.gms.internal.gtm.zzo;

public abstract class zzce extends zzn implements zzcd {
    public zzce() {
        super("com.google.android.gms.tagmanager.ICustomEvaluatorProxy");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzn
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb(parcel.readString(), zzo.zzb(parcel));
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            String zzc = zzc(parcel.readString(), zzo.zzb(parcel));
            parcel2.writeNoException();
            parcel2.writeString(zzc);
        }
        return true;
    }
}
