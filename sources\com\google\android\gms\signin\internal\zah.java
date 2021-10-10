package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zah extends zab implements zae {
    zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(int i) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i);
        zab(7, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, iAccountAccessor);
        zaa.writeInt(i);
        zad.zaa(zaa, z);
        zab(9, zaa);
    }

    @Override // com.google.android.gms.signin.internal.zae
    public final void zaa(zak zak, zac zac) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, zak);
        zad.zaa(zaa, zac);
        zab(12, zaa);
    }
}
