package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzd;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzar extends zzb implements zzap {
    zzar(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.location.zzap
    public final void zza(LocationResult locationResult) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, locationResult);
        zzc(1, b_);
    }

    @Override // com.google.android.gms.location.zzap
    public final void zza(LocationAvailability locationAvailability) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, locationAvailability);
        zzc(2, b_);
    }
}
