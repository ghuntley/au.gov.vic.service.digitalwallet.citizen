package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjp extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        int i = 0;
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        if (zzoaArr.length == 2) {
            i = (int) zzha.zzc(zzoaArr[1]);
        }
        if (i < 0 || i >= str.length()) {
            return new zzom("");
        }
        return new zzom(String.valueOf(str.charAt(i)));
    }
}
