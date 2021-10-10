package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjq extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        StringBuilder sb = new StringBuilder((String) ((zzom) zzoaArr[0]).value());
        for (int i = 1; i < zzoaArr.length; i++) {
            sb.append(zzha.zzd(zzoaArr[i]));
        }
        return new zzom(sb.toString());
    }
}
