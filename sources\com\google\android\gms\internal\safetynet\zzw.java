package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk;
import com.google.android.gms.safetynet.SafeBrowsingData;

final class zzw extends zze {
    private final /* synthetic */ zzk.zzf zzak;

    zzw(zzk.zzf zzf) {
        this.zzak = zzf;
    }

    @Override // com.google.android.gms.internal.safetynet.zzg, com.google.android.gms.internal.safetynet.zze
    public final void zza(Status status, SafeBrowsingData safeBrowsingData) {
        this.zzak.setResult((Result) new zzk.zzi(status, safeBrowsingData));
    }
}
