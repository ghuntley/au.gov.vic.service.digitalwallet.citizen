package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zziy implements zzgz {
    private static zzff zzamz;

    public zziy(zzff zzff) {
        zzamz = zzff;
    }

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        return zzamz.zzbx((String) ((zzom) zzoaArr[0]).value());
    }
}
