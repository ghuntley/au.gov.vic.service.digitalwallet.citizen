package com.google.android.gms.instantapps;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final /* synthetic */ class zzi implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzn = new zzi();

    private zzi() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    public final Object convert(Result result) {
        return ((zzf) result).zzc();
    }
}
