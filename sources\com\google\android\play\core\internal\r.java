package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class r extends j implements t {
    r(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    @Override // com.google.android.play.core.internal.t
    public final void c(String str, List<Bundle> list, Bundle bundle, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, vVar);
        b(2, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void d(String str, List<Bundle> list, Bundle bundle, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, vVar);
        b(14, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void e(String str, Bundle bundle, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.c(a, vVar);
        b(5, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void f(String str, Bundle bundle, Bundle bundle2, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.b(a, bundle2);
        l.c(a, vVar);
        b(6, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void g(String str, Bundle bundle, Bundle bundle2, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.b(a, bundle2);
        l.c(a, vVar);
        b(7, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void h(String str, Bundle bundle, Bundle bundle2, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.b(a, bundle2);
        l.c(a, vVar);
        b(9, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void i(String str, Bundle bundle, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.c(a, vVar);
        b(10, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void j(String str, Bundle bundle, Bundle bundle2, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.b(a, bundle2);
        l.c(a, vVar);
        b(11, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void k(String str, List<Bundle> list, Bundle bundle, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        a.writeTypedList(list);
        l.b(a, bundle);
        l.c(a, vVar);
        b(12, a);
    }

    @Override // com.google.android.play.core.internal.t
    public final void l(String str, Bundle bundle, Bundle bundle2, v vVar) throws RemoteException {
        Parcel a = a();
        a.writeString(str);
        l.b(a, bundle);
        l.b(a, bundle2);
        l.c(a, vVar);
        b(13, a);
    }
}
