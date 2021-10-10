package com.google.android.gms.internal.instantapps;

import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.instantapps.LaunchData;

public abstract class zzr extends zza implements zzs {
    public zzr() {
        super("com.google.android.gms.instantapps.internal.IInstantAppsCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.instantapps.zza
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (zzw) zzd.zza(parcel, zzw.CREATOR));
            return true;
        } else if (i == 9) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (zzan) zzd.zza(parcel, zzan.CREATOR));
            return true;
        } else if (i == 10) {
            zza(parcel.readInt());
            return true;
        } else if (i == 12) {
            zza((Status) zzd.zza(parcel, Status.CREATOR), parcel.readInt());
            return true;
        } else if (i != 13) {
            switch (i) {
                case 18:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), (PackageInfo) zzd.zza(parcel, PackageInfo.CREATOR));
                    return true;
                case 19:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), (LaunchData) zzd.zza(parcel, LaunchData.CREATOR));
                    return true;
                case 20:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), parcel.createTypedArrayList(zzay.CREATOR));
                    return true;
                case 21:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), (ParcelFileDescriptor) zzd.zza(parcel, ParcelFileDescriptor.CREATOR));
                    return true;
                case 22:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), (BitmapTeleporter) zzd.zza(parcel, BitmapTeleporter.CREATOR));
                    return true;
                case 23:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                    return true;
                case 24:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), parcel.createByteArray());
                    return true;
                case 25:
                    zzb((Status) zzd.zza(parcel, Status.CREATOR), zzd.zza(parcel));
                    return true;
                case 26:
                    zzc((Status) zzd.zza(parcel, Status.CREATOR), zzd.zza(parcel));
                    return true;
                case 27:
                    zza((Status) zzd.zza(parcel, Status.CREATOR), zzd.zza(parcel));
                    return true;
                default:
                    return false;
            }
        } else {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (zzam) zzd.zza(parcel, zzam.CREATOR));
            return true;
        }
    }
}
