package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public interface zzaj extends IInterface {
    void zza(int i, PendingIntent pendingIntent) throws RemoteException;

    void zza(int i, String[] strArr) throws RemoteException;

    void zzb(int i, String[] strArr) throws RemoteException;
}
