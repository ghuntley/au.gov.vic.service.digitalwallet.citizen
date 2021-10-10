package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlr extends zzhb {
    private static final zzoe zzarv = new zzoe(Double.valueOf(0.0d));
    private static final zzoe zzarw = new zzoe(Double.valueOf(2.147483647E9d));

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        double d;
        double d2;
        Preconditions.checkArgument(true);
        zzoe zzoe = zzoaArr.length > 0 ? zzoaArr[0] : zzarv;
        zzoe zzoe2 = zzoaArr.length > 1 ? zzoaArr[1] : zzarw;
        if (!zzg(zzoe) || !zzg(zzoe2) || !zzha.zzb(zzoe, zzoe2)) {
            d2 = 0.0d;
            d = 2.147483647E9d;
        } else {
            d2 = ((Double) zzoe.value()).doubleValue();
            d = ((Double) zzoe2.value()).doubleValue();
        }
        return new zzoe(Double.valueOf((double) Math.round((Math.random() * (d - d2)) + d2)));
    }

    private static boolean zzg(zzoa<?> zzoa) {
        return (zzoa instanceof zzoe) && !Double.isNaN(((Double) ((zzoe) zzoa).value()).doubleValue());
    }
}
