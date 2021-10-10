package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkq implements zzgz {
    private final zzdl zzarm;

    public zzkq(Context context) {
        this(zzdl.zzo(context));
    }

    private zzkq(zzdl zzdl) {
        this.zzarm = zzdl;
    }

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = false;
        Preconditions.checkArgument(zzoaArr != null);
        if (zzoaArr.length == 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return new zzod(Boolean.valueOf(!this.zzarm.isLimitAdTrackingEnabled()));
    }
}
