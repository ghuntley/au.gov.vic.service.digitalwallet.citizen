package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzit extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        ArrayList arrayList = new ArrayList();
        int length = zzoaArr.length;
        for (int i = 0; i < length; i++) {
            zzoa<?> zzoa = zzoaArr[i];
            Preconditions.checkArgument(!(zzoa instanceof zzog) || zzoa == zzog.zzaum || zzoa == zzog.zzaul);
            arrayList.add(zzoa);
        }
        return new zzoh(arrayList);
    }
}
