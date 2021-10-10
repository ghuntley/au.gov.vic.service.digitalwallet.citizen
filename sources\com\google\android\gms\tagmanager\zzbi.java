package com.google.android.gms.tagmanager;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzbi implements AppMeasurement.OnEventListener {
    private final /* synthetic */ zzcg zzagr;

    zzbi(zzbg zzbg, zzcg zzcg) {
        this.zzagr = zzcg;
    }

    @Override // com.google.android.gms.measurement.AppMeasurement.OnEventListener, com.google.android.gms.measurement.internal.zzgz
    public final void onEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zzagr.onEvent(str, str2, bundle, j);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }
}
