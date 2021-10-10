package com.google.android.gms.internal.instantapps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.instantapps.zzk;

public final class zzt extends zzb implements zzu {
    zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.instantapps.internal.IInstantAppsService");
    }

    @Override // com.google.android.gms.internal.instantapps.zzu
    public final void zza(zzs zzs, String str, zzk zzk) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzs);
        zza.writeString(str);
        zzd.zza(zza, zzk);
        zza(19, zza);
    }

    @Override // com.google.android.gms.internal.instantapps.zzu
    public final void zza(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzs);
        zza(29, zza);
    }

    @Override // com.google.android.gms.internal.instantapps.zzu
    public final void zzb(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzs);
        zza(40, zza);
    }
}
