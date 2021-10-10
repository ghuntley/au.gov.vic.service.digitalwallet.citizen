package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhq extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        zzoh zzoh = (zzoh) zzoaArr[0];
        int zzc = (int) zzha.zzc(zzoaArr[1]);
        if (zzc < 0) {
            i = Math.max(((List) zzoh.value()).size() + zzc, 0);
        } else {
            i = Math.min(zzc, ((List) zzoh.value()).size());
        }
        int size = ((List) zzoh.value()).size();
        if (zzoaArr.length == 3) {
            int zzc2 = (int) zzha.zzc(zzoaArr[2]);
            if (zzc2 < 0) {
                size = Math.max(zzc2 + ((List) zzoh.value()).size(), 0);
            } else {
                size = Math.min(zzc2, ((List) zzoh.value()).size());
            }
        }
        return new zzoh(new ArrayList(((List) zzoh.value()).subList(i, Math.max(i, size))));
    }
}
