package com.google.android.gms.tagmanager;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.gtm.zzer;
import com.google.android.gms.internal.gtm.zzes;
import com.google.android.gms.internal.gtm.zzm;
import com.google.android.gms.internal.gtm.zzo;

public final class zzcu extends zzm implements zzcs {
    zzcu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.ITagManagerServiceProvider");
    }

    @Override // com.google.android.gms.tagmanager.zzcs
    public final zzer getService(IObjectWrapper iObjectWrapper, zzcm zzcm, zzcd zzcd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzo.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzo.zza(obtainAndWriteInterfaceToken, zzcm);
        zzo.zza(obtainAndWriteInterfaceToken, zzcd);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzer zza = zzes.zza(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zza;
    }
}
