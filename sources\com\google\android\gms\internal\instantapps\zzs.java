package com.google.android.gms.internal.instantapps;

import android.content.pm.PackageInfo;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.instantapps.LaunchData;
import java.util.List;

public interface zzs extends IInterface {
    void zza(int i) throws RemoteException;

    void zza(Status status, int i) throws RemoteException;

    void zza(Status status, PackageInfo packageInfo) throws RemoteException;

    void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(Status status, BitmapTeleporter bitmapTeleporter) throws RemoteException;

    void zza(Status status, LaunchData launchData) throws RemoteException;

    void zza(Status status, zzam zzam) throws RemoteException;

    void zza(Status status, zzan zzan) throws RemoteException;

    void zza(Status status, zzn zzn) throws RemoteException;

    void zza(Status status, zzw zzw) throws RemoteException;

    void zza(Status status, List<zzay> list) throws RemoteException;

    void zza(Status status, boolean z) throws RemoteException;

    void zza(Status status, byte[] bArr) throws RemoteException;

    void zzb(Status status, boolean z) throws RemoteException;

    void zzc(Status status, boolean z) throws RemoteException;
}
