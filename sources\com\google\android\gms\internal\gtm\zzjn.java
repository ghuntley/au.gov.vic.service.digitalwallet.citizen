package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjn extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        double zzb = zzha.zzb(zzoaArr[0]);
        double zzb2 = zzha.zzb(zzoaArr[1]);
        if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if ((Double.isInfinite(zzb) && zzb2 == 0.0d) || (zzb == 0.0d && Double.isInfinite(zzb2))) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        if (!Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(zzb * zzb2));
        }
        boolean z2 = ((double) Double.compare(zzb, 0.0d)) < 0.0d;
        if (((double) Double.compare(zzb2, 0.0d)) >= 0.0d) {
            z = false;
        }
        return new zzoe(Double.valueOf(z ^ z2 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY));
    }
}
