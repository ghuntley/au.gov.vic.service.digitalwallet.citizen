package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzbh implements AppMeasurement.EventInterceptor {
    private final /* synthetic */ zzcj zzagq;

    zzbh(zzbg zzbg, zzcj zzcj) {
        this.zzagq = zzcj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw, com.google.android.gms.measurement.AppMeasurement.EventInterceptor
    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zzagq.interceptEvent(str, str2, bundle, j);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
