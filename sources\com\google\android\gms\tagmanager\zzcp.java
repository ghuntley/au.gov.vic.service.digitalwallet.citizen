package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzcp extends IInterface {
    void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException;

    void preview(Intent intent, IObjectWrapper iObjectWrapper) throws RemoteException;

    void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) throws RemoteException;
}
