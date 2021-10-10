package com.google.android.gms.internal.gtm;

import android.os.Build;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlc implements zzgz {
    private final String zzarq = Build.MODEL;

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        return new zzom(this.zzarq);
    }
}
