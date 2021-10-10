package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhm extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?> zzoa;
        int i;
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
            i = 0;
        } else {
            Preconditions.checkState(size > 0);
            zzoa = zzoh.zzac(0);
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i = 1;
                    break;
                } else if (zzoh.zzad(i2)) {
                    zzoa = zzoh.zzac(i2);
                    i = i2 + 1;
                    break;
                } else {
                    i2++;
                }
            }
            Preconditions.checkState(i2 < size);
        }
        while (i < size && i < ((List) zzoh.value()).size()) {
            if (zzoh.zzad(i)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, zzoa, (zzoa) list.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
            }
            i++;
        }
        return zzoa;
    }
}
