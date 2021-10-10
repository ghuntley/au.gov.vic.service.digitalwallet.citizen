package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class bw extends k implements bx {
    public bw() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.k
    public final boolean a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                i(parcel.readInt(), (Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) l.a(parcel, Bundle.CREATOR);
                k(readInt);
                return true;
            case 4:
                b(parcel.readInt(), (Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                g(parcel.readInt(), (Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                j((Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                h(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                f((Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                c((Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) l.a(parcel, Bundle.CREATOR);
                m();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) l.a(parcel, Bundle.CREATOR);
                l();
                return true;
            case 12:
                d((Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                e((Bundle) l.a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
