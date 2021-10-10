package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class ad extends k implements ae {
    public ad() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.k
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        b((Bundle) l.a(parcel, Bundle.CREATOR));
        return true;
    }
}
