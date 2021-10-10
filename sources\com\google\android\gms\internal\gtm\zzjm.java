package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjm extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        double zzb = zzha.zzb(zzoaArr[0]);
        double zzb2 = zzha.zzb(zzoaArr[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (Double.isInfinite(zzb) || zzb2 == 0.0d) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (!Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb));
        }
        if (zzb != 0.0d || i == 0 || Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb % zzb2));
        }
        return new zzoe(Double.valueOf(zzb));
    }
}
