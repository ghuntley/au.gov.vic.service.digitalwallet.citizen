package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final /* synthetic */ class zzae implements RemoteCall {
    private final Location zza;

    zzae(Location location) {
        this.zza = location;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
