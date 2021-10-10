package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhl extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        int size = ((List) zzoh.value()).size();
        zzoh.setSize((zzoaArr.length + size) - 1);
        for (int i = 1; i < zzoaArr.length; i++) {
            zzoh.zza(size, zzoaArr[i]);
            size++;
        }
        return new zzoe(Double.valueOf((double) size));
    }
}
