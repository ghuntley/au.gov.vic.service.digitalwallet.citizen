package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public final class zzac extends zzb implements zzad {
    zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzs zzs, zzaj zzaj) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, iObjectWrapper);
        zzd.zza(a_, zzs);
        zzd.zza(a_, zzaj);
        Parcel zza = zza(3, a_);
        zzah[] zzahArr = (zzah[]) zza.createTypedArray(zzah.CREATOR);
        zza.recycle();
        return zzahArr;
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final void zzb() throws RemoteException {
        zzb(2, a_());
    }
}
