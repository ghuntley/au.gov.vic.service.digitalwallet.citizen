package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzat;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
public final class zzaw extends zzat {
    private final ListenerHolder<LocationListener> zza;

    zzaw(ListenerHolder<LocationListener> listenerHolder) {
        this.zza = listenerHolder;
    }

    @Override // com.google.android.gms.location.zzaq
    public final synchronized void zza(Location location) {
        this.zza.notifyListener(new zzav(this, location));
    }

    public final synchronized void zza() {
        this.zza.clear();
    }
}
