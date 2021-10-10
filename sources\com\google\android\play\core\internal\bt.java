package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class bt extends j implements bv {
    bt(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.internal.bv
    public final void c(String str, List<Bundle> list, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(2, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void d(String str, int i, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(4, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void e(String str, int i, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeInt(i);
        l.c(a, bxVar);
        b(5, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void f(String str, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.c(a, bxVar);
        b(6, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void g(String str, List<Bundle> list, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(7, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void h(String str, List<Bundle> list, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(8, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void i(String str, List<Bundle> list, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(13, a);
    }

    @Override // com.google.android.play.core.internal.bv
    public final void j(String str, List<Bundle> list, Bundle bundle, bx bxVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, bxVar);
        b(14, a);
    }
}
