package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzjj implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        Preconditions.checkArgument(zzoaArr.length == 4);
        zzoa zza = zzoo.zza(zzfl, zzoaArr[3]);
        Preconditions.checkArgument(zza instanceof zzoh);
        List list = (List) ((zzoh) zza).value();
        zzoa<?> zzoa = zzoaArr[2];
        Preconditions.checkArgument(zzoa instanceof zzod);
        if (((Boolean) ((zzod) zzoa).value()).booleanValue()) {
            zzog zza2 = zzoo.zza(zzfl, list);
            if (zza2 == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza2.zzmh()) {
                return zza2;
            }
        }
        while (zzha.zza(zzoo.zza(zzfl, zzoaArr[0]))) {
            zzog zza3 = zzoo.zza(zzfl, list);
            if (zza3 == zzog.zzauj) {
                return zzog.zzaum;
            }
            if (zza3.zzmh()) {
                return zza3;
            }
            zzoo.zza(zzfl, zzoaArr[1]);
        }
        return zzog.zzaum;
    }
}
