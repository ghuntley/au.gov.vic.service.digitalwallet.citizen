package com.google.android.gms.internal.instantapps;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.LaunchData;

final class zzaa extends zze {
    private final /* synthetic */ zzx zzbe;

    zzaa(zzx zzx) {
        this.zzbe = zzx;
    }

    @Override // com.google.android.gms.internal.instantapps.zze, com.google.android.gms.internal.instantapps.zzs
    public final void zza(Status status, LaunchData launchData) {
        this.zzbe.setResult((Result) new zzag(status, launchData));
    }
}
