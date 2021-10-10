package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhn extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?> zzoa;
        int i;
        int i2;
        zzoa<?> zzoa2;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = (zzoh) zzoaArr[0];
        zzof zzof = (zzof) zzoaArr[1];
        List list = (List) zzoh.value();
        int size = list.size();
        if (zzoaArr.length == 3) {
            zzoa = zzoaArr[2];
            i = size - 1;
        } else {
            Preconditions.checkState(size > 0);
            int i3 = size - 1;
            zzoa<?> zzac = zzoh.zzac(i3);
            int i4 = size - 2;
            while (true) {
                if (i3 < 0) {
                    i2 = i4;
                    zzoa2 = zzac;
                    break;
                } else if (zzoh.zzad(i3)) {
                    zzoa2 = zzoh.zzac(i3);
                    i2 = i3 - 1;
                    break;
                } else {
                    i3--;
                }
            }
            Preconditions.checkState(i3 >= 0);
            zzoa = zzoa2;
            i = i2;
        }
        while (i >= 0) {
            if (zzoh.zzad(i)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, zzoa, (zzoa) list.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
            }
            i--;
        }
        return zzoa;
    }
}
