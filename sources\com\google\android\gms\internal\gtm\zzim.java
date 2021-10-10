package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzim implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?> zzoa;
        Preconditions.checkArgument(zzoaArr != null);
        Preconditions.checkArgument(zzoaArr.length == 3);
        if (zzha.zza(zzoo.zza(zzfl, zzoaArr[0]))) {
            zzoa = zzoo.zza(zzfl, zzoaArr[1]);
        } else {
            zzoa = zzoo.zza(zzfl, zzoaArr[2]);
        }
        if (!(zzoa instanceof zzog) || zzoa == zzog.zzaum || zzoa == zzog.zzaul) {
            return zzoa;
        }
        throw new IllegalArgumentException("Illegal InternalType passed to Ternary.");
    }
}
