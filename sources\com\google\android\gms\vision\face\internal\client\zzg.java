package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zza;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzs;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.3 */
public abstract class zzg extends zza implements zzh {
    public zzg() {
        super("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            FaceParcel[] zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzs) zzd.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(zza, 1);
        } else if (i == 2) {
            boolean zza2 = zza(parcel.readInt());
            parcel2.writeNoException();
            zzd.zza(parcel2, zza2);
        } else if (i == 3) {
            zza();
            parcel2.writeNoException();
        } else if (i != 4) {
            return false;
        } else {
            FaceParcel[] zza3 = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (zzs) zzd.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
            parcel2.writeTypedArray(zza3, 1);
        }
        return true;
    }
}
