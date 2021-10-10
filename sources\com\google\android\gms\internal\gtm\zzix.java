package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzix implements zzgz {
    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        zzoa<?> zzca = zzfl.zzca((String) ((zzom) zzoaArr[0]).value());
        if (zzca instanceof zzol) {
            throw new IllegalStateException("Illegal Statement type encountered in Get.");
        } else if (!(zzca instanceof zzog) || zzca == zzog.zzaum || zzca == zzog.zzaul) {
            return zzca;
        } else {
            throw new IllegalStateException("Illegal InternalType encountered in Get.");
        }
    }
}
