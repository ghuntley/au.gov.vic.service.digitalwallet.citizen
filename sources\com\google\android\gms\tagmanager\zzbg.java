package com.google.android.gms.tagmanager;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzbg extends zzcn {
    private final /* synthetic */ AppMeasurement zzagp;

    zzbg(AppMeasurement appMeasurement) {
        this.zzagp = appMeasurement;
    }

    @Override // com.google.android.gms.tagmanager.zzcm
    public final void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzagp.logEventInternalNoInterceptor(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.tagmanager.zzcm
    public final Map<String, Object> zzib() {
        return this.zzagp.getUserProperties(true);
    }

    @Override // com.google.android.gms.tagmanager.zzcm
    public final void zza(zzcj zzcj) {
        this.zzagp.setEventInterceptor(new zzbh(this, zzcj));
    }

    @Override // com.google.android.gms.tagmanager.zzcm
    public final void zza(zzcg zzcg) {
        this.zzagp.registerOnMeasurementEventListener(new zzbi(this, zzcg));
    }
}
