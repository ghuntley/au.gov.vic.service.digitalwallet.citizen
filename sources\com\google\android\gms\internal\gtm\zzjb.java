package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzjb extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzoh);
        if (zzoaArr.length == 3) {
            Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        }
        List arrayList = new ArrayList();
        if (zzha.zza(zzoaArr[0])) {
            arrayList = (List) ((zzoh) zzoaArr[1]).value();
        } else if (zzoaArr.length > 2) {
            arrayList = (List) ((zzoh) zzoaArr[2]).value();
        }
        zzog zza = zzoo.zza(zzfl, arrayList);
        if (!(zza instanceof zzog) || !zzoo.zzm(zza)) {
            return zzog.zzaum;
        }
        return zza;
    }
}
