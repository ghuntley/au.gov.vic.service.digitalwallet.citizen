package com.google.android.gms.internal.instantapps;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.instantapps.zze;

final class zzag implements zze {
    private final Status zzbi;
    private final LaunchData zzbj;

    zzag(Status status, LaunchData launchData) {
        this.zzbi = status;
        this.zzbj = launchData;
    }

    @Override // com.google.android.gms.instantapps.zze
    public final LaunchData zzb() {
        return this.zzbj;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzbi;
    }
}
