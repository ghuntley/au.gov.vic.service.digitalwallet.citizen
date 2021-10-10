package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.safetynet.zzd;

final class zzu extends zze {
    private final /* synthetic */ zzk.zzd zzai;

    zzu(zzk.zzd zzd) {
        this.zzai = zzd;
    }

    @Override // com.google.android.gms.internal.safetynet.zzg, com.google.android.gms.internal.safetynet.zze
    public final void zza(Status status, zzd zzd) {
        this.zzai.setResult((Result) new zzk.zzg(status, zzd));
    }
}
