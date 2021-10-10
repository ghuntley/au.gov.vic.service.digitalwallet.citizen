package com.google.android.gms.instantapps;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzg implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzn = new zzg();

    private zzg() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return ((zze) result).zzb();
    }
}
