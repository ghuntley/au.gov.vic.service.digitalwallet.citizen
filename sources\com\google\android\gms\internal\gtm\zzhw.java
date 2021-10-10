package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhw extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length >= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        int zzc = (int) zzha.zzc(zzoaArr[1]);
        if (zzc < 0) {
            i = Math.max(((List) zzoh.value()).size() + zzc, 0);
        } else {
            i = Math.min(zzc, ((List) zzoh.value()).size());
        }
        int min = Math.min(Math.max((int) zzha.zzc(zzoaArr[2]), 0), ((List) zzoh.value()).size() - i) + i;
        ArrayList arrayList = new ArrayList(((List) zzoh.value()).subList(i, min));
        ((List) zzoh.value()).subList(i, min).clear();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 3; i2 < zzoaArr.length; i2++) {
            arrayList2.add(zzoaArr[i2]);
        }
        ((List) zzoh.value()).addAll(i, arrayList2);
        return new zzoh(arrayList);
    }
}
