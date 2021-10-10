package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhx extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < zzoaArr.length; i++) {
            arrayList.add(zzoaArr[i]);
        }
        ((List) zzoh.value()).addAll(0, arrayList);
        return new zzoe(Double.valueOf((double) ((List) zzoh.value()).size()));
    }
}
