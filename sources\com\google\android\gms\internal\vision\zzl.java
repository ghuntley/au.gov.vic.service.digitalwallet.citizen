package com.google.android.gms.internal.vision;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public interface zzl extends IInterface {
    void zza() throws RemoteException;

    Barcode[] zza(IObjectWrapper iObjectWrapper, zzs zzs) throws RemoteException;

    Barcode[] zzb(IObjectWrapper iObjectWrapper, zzs zzs) throws RemoteException;
}
