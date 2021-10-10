package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzij implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoa<?> zza = zzoo.zza(zzfl, zzoaArr[0]);
        if (zzha.zza(zza)) {
            return zza;
        }
        return zzoo.zza(zzfl, zzoaArr[1]);
    }
}
