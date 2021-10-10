package com.google.android.gms.tagmanager;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.gtm.zzm;
import com.google.android.gms.internal.gtm.zzo;

public final class zzcr extends zzm implements zzcp {
    zzcr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ITagManagerApi");
    }

    @Override // com.google.android.gms.tagmanager.zzcp
    public final void initialize(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzo.zza(obtainAndWriteInterfaceToken, zzcm);
        zzo.zza(obtainAndWriteInterfaceToken, zzcd);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.tagmanager.zzcp
    public final void preview(Intent intent, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, intent);
        zzo.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.tagmanager.zzcp
    public final void previewIntent(Intent intent, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, zzcm zzcm, zzcd zzcd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, intent);
        zzo.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzo.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzo.zza(obtainAndWriteInterfaceToken, zzcm);
        zzo.zza(obtainAndWriteInterfaceToken, zzcd);
        zza(3, obtainAndWriteInterfaceToken);
    }
}
