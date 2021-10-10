package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzjd implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        ArrayList arrayList = new ArrayList(zzoaArr.length);
        for (zzoa<?> zzoa : zzoaArr) {
            arrayList.add(zzoa);
        }
        return new zzoh(arrayList);
    }
}
