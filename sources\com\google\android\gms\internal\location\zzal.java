package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzbe;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public interface zzal extends IInterface {
    @Deprecated
    Location zza() throws RemoteException;

    Location zza(String str) throws RemoteException;

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzaj zzaj, String str) throws RemoteException;

    void zza(Location location) throws RemoteException;

    void zza(zzai zzai) throws RemoteException;

    void zza(zzbe zzbe) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzaj zzaj) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzan zzan, String str) throws RemoteException;

    void zza(zzbe zzbe, zzaj zzaj) throws RemoteException;

    void zza(boolean z) throws RemoteException;

    void zza(String[] strArr, zzaj zzaj, String str) throws RemoteException;

    LocationAvailability zzb(String str) throws RemoteException;
}
