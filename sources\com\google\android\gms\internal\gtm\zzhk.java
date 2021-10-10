package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzhk extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        List list = (List) ((zzoh) zzoaArr[0]).value();
        return !list.isEmpty() ? (zzoa) list.remove(list.size() - 1) : zzog.zzaum;
    }
}
