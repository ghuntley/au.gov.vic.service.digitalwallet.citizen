package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzji implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (zzoa<?> zzoa : zzoaArr) {
            Preconditions.checkNotNull(zzoa);
            Preconditions.checkArgument(zzoa instanceof zzom);
            zzfl.zza((String) ((zzom) zzoa).value(), zzog.zzaum);
        }
        return zzog.zzaum;
    }
}
