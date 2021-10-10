package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhg extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        int i = 0;
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        zzoa<?> zzoa = zzoaArr.length < 2 ? zzog.zzaum : zzoaArr[1];
        zzoa<?> zzoa2 = zzoaArr.length < 3 ? zzog.zzaum : zzoaArr[2];
        List list = (List) zzoh.value();
        int size = list.size();
        if (zzoa2 != zzog.zzaum) {
            int zzc = (int) zzha.zzc(zzoa2);
            i = zzc < 0 ? Math.max(size - Math.abs(zzc), 0) : zzc;
        }
        int i2 = -1;
        while (true) {
            if (i < size) {
                if (zzoh.zzad(i) && zzha.zzd(zzoa, (zzoa) list.get(i))) {
                    i2 = i;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return new zzoe(Double.valueOf((double) i2));
    }
}
