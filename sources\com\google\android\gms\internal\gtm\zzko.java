package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzko extends zzhb {
    private final zzfj zzapc;

    public zzko(Context context, zzfj zzfj) {
        this.zzapc = zzfj;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zzapc.zzkt().zzg(false);
        return zzog.zzaum;
    }
}
