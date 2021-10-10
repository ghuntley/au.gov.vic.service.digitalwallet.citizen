package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public final class zzjx extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        ArrayList arrayList = new ArrayList();
        if (zzoaArr.length == 1) {
            arrayList.add(zzoaArr[0]);
        } else {
            String str = (String) ((zzom) zzoaArr[0]).value();
            String zzd = zzha.zzd(zzoaArr[1]);
            boolean equals = zzd.equals("");
            String[] split = str.split(zzd, equals ? 0 : -1);
            if (!equals || split.length <= 0 || !split[0].equals("")) {
                i = 0;
            }
            while (i < split.length) {
                arrayList.add(new zzom(split[i]));
                i++;
            }
        }
        return new zzoh(arrayList);
    }
}
