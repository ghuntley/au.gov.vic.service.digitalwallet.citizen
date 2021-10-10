package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class p extends k implements q {
    public p() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.k
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        if (i == 2) {
            b((Bundle) l.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            c((Bundle) l.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
