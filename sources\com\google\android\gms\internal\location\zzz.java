package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-location@@17.1.0 */
final class zzz extends zzah {
    private final BaseImplementation.ResultHolder<Status> zza;

    public zzz(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void a_() {
    }

    @Override // com.google.android.gms.internal.location.zzai
    public final void zza(zzac zzac) {
        this.zza.setResult(zzac.getStatus());
    }
}
