package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhr extends zzhb {
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
        boolean z = false;
        int i = 0;
        while (!z && i < size && i < ((List) zzoh.value()).size()) {
            if (zzoh.zzad(i)) {
                z |= zzha.zza(((zzgz) zzof.value()).zzb(zzfl, (zzoa) list.get(i), new zzoe(Double.valueOf((double) i)), zzoh));
            }
            i++;
        }
        return new zzod(Boolean.valueOf(z));
    }
}
