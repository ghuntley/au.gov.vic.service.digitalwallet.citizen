package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhj extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzof);
        zzoh zzoh = (zzoh) zzoaArr[0];
        zzof zzof = (zzof) zzoaArr[1];
        List list = (List) zzoh.value();
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size && i < ((List) zzoh.value()).size()) {
            zzoa<?> zzoa = null;
            if (zzoh.zzad(i)) {
                zzoa = ((zzgz) zzof.value()).zzb(zzfl, (zzoa) list.get(i), new zzoe(Double.valueOf((double) i)), zzoh);
                Preconditions.checkState(!zzoo.zzm(zzoa));
            }
            arrayList.add(zzoa);
            i++;
        }
        return new zzoh(arrayList);
    }
}
