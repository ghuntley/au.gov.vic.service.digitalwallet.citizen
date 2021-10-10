package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzep extends zzn implements zzeo {
    public zzep() {
        super("com.google.android.gms.tagmanager.internal.ITagManagerLoadContainerCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzn
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zza(zzo.zza(parcel), parcel.readString());
        return true;
    }
}
