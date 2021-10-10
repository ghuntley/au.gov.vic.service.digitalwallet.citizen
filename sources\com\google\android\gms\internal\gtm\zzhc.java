package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhc extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        ArrayList arrayList = new ArrayList();
        for (zzoa zzoa : (List) ((zzoh) zzoaArr[0]).value()) {
            arrayList.add(zzoa);
        }
        for (int i = 1; i < zzoaArr.length; i++) {
            if (zzoaArr[i] instanceof zzoh) {
                for (zzoa zzoa2 : (List) ((zzoh) zzoaArr[i]).value()) {
                    arrayList.add(zzoa2);
                }
            } else {
                arrayList.add(zzoaArr[i]);
            }
        }
        return new zzoh(arrayList);
    }
}
