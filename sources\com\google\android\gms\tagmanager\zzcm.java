package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Map;

public interface zzcm extends IInterface {
    void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) throws RemoteException;

    void zza(zzcg zzcg) throws RemoteException;

    void zza(zzcj zzcj) throws RemoteException;

    Map zzib() throws RemoteException;
}
