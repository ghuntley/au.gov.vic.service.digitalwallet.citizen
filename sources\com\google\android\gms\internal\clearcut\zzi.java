package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzi extends zzg {
    private final /* synthetic */ zzh zzap;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzi(zzh zzh) {
        super(null);
        this.zzap = zzh;
    }

    @Override // com.google.android.gms.internal.clearcut.zzl, com.google.android.gms.internal.clearcut.zzg
    public final void zza(Status status) {
        this.zzap.setResult((Result) status);
    }
}
