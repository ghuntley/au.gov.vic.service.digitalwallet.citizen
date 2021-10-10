package com.google.android.gms.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.location.zzay;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final /* synthetic */ class zzbh implements RemoteCall {
    private final LocationSettingsRequest zza;

    zzbh(LocationSettingsRequest locationSettingsRequest) {
        this.zza = locationSettingsRequest;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        ((zzay) obj).zza(this.zza, new SettingsClient.zza((TaskCompletionSource) obj2), (String) null);
    }
}
