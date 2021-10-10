package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class aa extends j implements ac {
    aa(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override // com.google.android.play.core.internal.ac
    public final void c(String str, Bundle bundle, ae aeVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.c(a, aeVar);
        b(2, a);
    }
}
