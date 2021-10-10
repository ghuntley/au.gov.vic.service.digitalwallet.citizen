package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class zac {
    public final int zaa;

    public zac(int i) {
        this.zaa = i;
    }

    public abstract void zaa(Status status);

    public abstract void zaa(zaw zaw, boolean z);

    public abstract void zaa(Exception exc);

    public abstract void zac(GoogleApiManager.zaa<?> zaa2) throws DeadObjectException;

    /* access modifiers changed from: private */
    public static Status zab(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }
}
