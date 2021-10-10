package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public abstract class zzmd extends zzhb {
    /* access modifiers changed from: protected */
    public abstract boolean zza(double d, double d2);

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        try {
            double zzb = zzha.zzb(zzoaArr[0]);
            double zzb2 = zzha.zzb(zzoaArr[1]);
            if (Double.isNaN(zzb) || Double.isNaN(zzb2)) {
                return new zzod(false);
            }
            return new zzod(Boolean.valueOf(zza(zzb, zzb2)));
        } catch (IllegalArgumentException unused) {
            return new zzod(false);
        }
    }
}
