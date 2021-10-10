package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjl extends zzhb {
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
        if (Double.isInfinite(zzb) && Double.isInfinite(zzb2)) {
            return new zzoe(Double.valueOf(Double.NaN));
        }
        double d = 0.0d;
        boolean z2 = ((double) Double.compare(zzb, 0.0d)) < 0.0d;
        if (((double) Double.compare(zzb2, 0.0d)) >= 0.0d) {
            z = false;
        }
        boolean z3 = z2 ^ z;
        double d2 = Double.NEGATIVE_INFINITY;
        if (Double.isInfinite(zzb) && !Double.isInfinite(zzb2)) {
            if (!z3) {
                d2 = Double.POSITIVE_INFINITY;
            }
            return new zzoe(Double.valueOf(d2));
        } else if (Double.isInfinite(zzb) || !Double.isInfinite(zzb2)) {
            int i = (zzb > 0.0d ? 1 : (zzb == 0.0d ? 0 : -1));
            if (i == 0) {
                if (zzb2 == 0.0d) {
                    return new zzoe(Double.valueOf(Double.NaN));
                }
                if (z3) {
                    d = -0.0d;
                }
                return new zzoe(Double.valueOf(d));
            } else if (Double.isInfinite(zzb) || i == 0 || zzb2 != 0.0d) {
                return new zzoe(Double.valueOf(zzb / zzb2));
            } else {
                if (!z3) {
                    d2 = Double.POSITIVE_INFINITY;
                }
                return new zzoe(Double.valueOf(d2));
            }
        } else {
            if (z3) {
                d = -0.0d;
            }
            return new zzoe(Double.valueOf(d));
        }
    }
}
