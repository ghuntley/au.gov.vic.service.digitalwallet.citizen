package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class m extends j implements o {
    m(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    @Override // com.google.android.play.core.internal.o
    public final void c(String str, Bundle bundle, q qVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.c(a, qVar);
        b(2, a);
    }

    @Override // com.google.android.play.core.internal.o
    public final void d(String str, Bundle bundle, q qVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.c(a, qVar);
        b(3, a);
    }
}
