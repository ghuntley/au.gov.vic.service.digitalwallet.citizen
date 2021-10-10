package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;

final class zzt extends zze {
    private final /* synthetic */ zzk.zzc zzah;

    zzt(zzk.zzc zzc) {
        this.zzah = zzc;
    }

    @Override // com.google.android.gms.internal.safetynet.zzg, com.google.android.gms.internal.safetynet.zze
    public final void zza(Status status, boolean z) {
        this.zzah.setResult((Result) new zzk.zzj(status, z));
    }
}
