package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class w extends k implements x {
    public w() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.k
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        z zVar = null;
        if (i == 2) {
            Bundle bundle = (Bundle) l.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                zVar = queryLocalInterface instanceof z ? (z) queryLocalInterface : new y(readStrongBinder);
            }
            b(bundle, zVar);
            return true;
        } else if (i != 3) {
            return false;
        } else {
            Bundle bundle2 = (Bundle) l.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                zVar = queryLocalInterface2 instanceof z ? (z) queryLocalInterface2 : new y(readStrongBinder2);
            }
            c(zVar);
            return true;
        }
    }
}
