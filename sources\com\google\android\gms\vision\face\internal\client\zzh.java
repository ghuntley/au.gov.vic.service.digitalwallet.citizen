package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzs;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public interface zzh extends IInterface {
    void zza() throws RemoteException;

    boolean zza(int i) throws RemoteException;

    FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzs zzs) throws RemoteException;

    FaceParcel[] zza(IObjectWrapper iObjectWrapper, zzs zzs) throws RemoteException;
}
