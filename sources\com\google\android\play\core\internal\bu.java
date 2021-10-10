package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class bu extends k implements bv {
    public static bv b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
        return queryLocalInterface instanceof bv ? (bv) queryLocalInterface : new bt(iBinder);
    }
}
