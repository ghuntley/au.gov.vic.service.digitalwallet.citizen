package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class ab extends k implements ac {
    public static ac b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof ac ? (ac) queryLocalInterface : new aa(iBinder);
    }
}
