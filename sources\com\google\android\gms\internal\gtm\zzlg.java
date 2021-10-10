package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzlg extends zzhb {
    private final zzfj zzaru;

    public zzlg(zzfj zzfj) {
        this.zzaru = zzfj;
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
        return zzoo.zzq(this.zzaru.zzkt().zzkg());
    }
}
