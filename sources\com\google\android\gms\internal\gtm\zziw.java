package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.List;

public final class zziw extends zzhb {
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        Preconditions.checkArgument(zzfl.has(str));
        zzoa<?> zzoa = zzoaArr[1];
        Preconditions.checkNotNull(zzoa);
        zzoa<?> zzoa2 = zzoaArr[2];
        Preconditions.checkArgument(zzoa2 instanceof zzoh);
        List list = (List) ((zzoh) zzoa2).value();
        Iterator<zzoa<?>> zzmf = zzoa.zzmf();
        while (zzmf.hasNext()) {
            zzfl.zzb(str, zzmf.next());
            zzog zza = zzoo.zza(zzfl, list);
            if (zza == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza.zzmh()) {
                return zza;
            }
        }
        return zzog.zzaum;
    }
}
