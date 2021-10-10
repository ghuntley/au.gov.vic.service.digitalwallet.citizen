package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class n extends k implements o {
    public static o b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof o ? (o) queryLocalInterface : new m(iBinder);
    }
}
