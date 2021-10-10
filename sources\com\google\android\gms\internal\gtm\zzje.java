package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzje extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length > 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzog(zzoaArr.length <= 0 ? zzog.zzaum : zzoaArr[0]);
    }
}
