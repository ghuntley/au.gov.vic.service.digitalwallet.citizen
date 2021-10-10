package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzak extends zzb implements zzai {
    zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zza(zzac zzac) throws RemoteException {
        Parcel b_ = b_();
        zzd.zza(b_, zzac);
        zzc(1, b_);
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void a_() throws RemoteException {
        zzc(2, b_());
    }
}
