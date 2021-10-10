package com.google.android.gms.internal.gtm;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzet extends zzm implements zzer {
    zzet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.tagmanager.internal.ITagManagerService");
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zzc(String str, String str2, String str3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zza(1, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zza(String str, String str2, String str3, zzeo zzeo) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzo.zza(obtainAndWriteInterfaceToken, zzeo);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zzkm() throws RemoteException {
        zza(3, obtainAndWriteInterfaceToken());
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void zza(String str, Bundle bundle, String str2, long j, boolean z) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzo.zza(obtainAndWriteInterfaceToken, bundle);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeLong(j);
        zzo.writeBoolean(obtainAndWriteInterfaceToken, z);
        zza(101, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.gtm.zzer
    public final void dispatch() throws RemoteException {
        zza(102, obtainAndWriteInterfaceToken());
    }
}
