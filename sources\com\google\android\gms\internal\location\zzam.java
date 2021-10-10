package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public abstract class zzam extends zza implements zzaj {
    public zzam() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.location.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza(parcel.readInt(), parcel.createStringArray());
        } else if (i == 2) {
            zzb(parcel.readInt(), parcel.createStringArray());
        } else if (i != 3) {
            return false;
        } else {
            zza(parcel.readInt(), (PendingIntent) zzd.zza(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
