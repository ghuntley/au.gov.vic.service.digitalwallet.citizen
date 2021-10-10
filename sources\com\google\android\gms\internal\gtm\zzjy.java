package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjy extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        int zzc = (int) zzha.zzc(zzoaArr.length < 2 ? zzog.zzaum : zzoaArr[1]);
        int length = str.length();
        if (zzoaArr.length == 3 && zzoaArr[2] != zzog.zzaum) {
            length = (int) zzha.zzc(zzoo.zza(zzfl, zzoaArr[2]));
        }
        int min = Math.min(Math.max(zzc, 0), str.length());
        int min2 = Math.min(Math.max(length, 0), str.length());
        return new zzom(str.substring(Math.min(min, min2), Math.max(min, min2)));
    }
}
