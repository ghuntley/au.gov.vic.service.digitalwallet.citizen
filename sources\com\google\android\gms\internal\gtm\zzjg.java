package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjg extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[1] instanceof zzoh);
        Preconditions.checkArgument(zzoaArr[2] instanceof zzoh);
        zzoa<?> zzoa = zzoaArr[0];
        List list = (List) ((zzoh) zzoaArr[1]).value();
        List list2 = (List) ((zzoh) zzoaArr[2]).value();
        Preconditions.checkArgument(list2.size() <= list.size() + 1);
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (z || zzha.zzd(zzoa, zzoo.zza(zzfl, (zzoa) list.get(i)))) {
                zzoa<?> zza = zzoo.zza(zzfl, (zzoa) list2.get(i));
                if (!(zza instanceof zzog)) {
                    z = true;
                } else if (zza == zzog.zzauk || ((zzog) zza).zzmh()) {
                    return zza;
                } else {
                    if (zza == zzog.zzauj) {
                        return zzog.zzaum;
                    }
                }
            }
        }
        if (list.size() < list2.size()) {
            zzoa<?> zza2 = zzoo.zza(zzfl, (zzoa) list2.get(list2.size() - 1));
            if ((zza2 instanceof zzog) && (zza2 == zzog.zzauk || ((zzog) zza2).zzmh())) {
                return zza2;
            }
        }
        return zzog.zzaum;
    }
}
