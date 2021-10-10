package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjw extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        double d;
        double d2;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        double zzc = zzoaArr.length < 2 ? 0.0d : zzha.zzc(zzoaArr[1]);
        double length = (double) str.length();
        if (zzoaArr.length == 3 && zzoaArr[2] != zzog.zzaum) {
            length = zzha.zzc(zzoaArr[2]);
        }
        if (zzc < 0.0d) {
            d = Math.max(((double) str.length()) + zzc, 0.0d);
        } else {
            d = Math.min(zzc, (double) str.length());
        }
        int i = (int) d;
        if (length < 0.0d) {
            d2 = Math.max(((double) str.length()) + length, 0.0d);
        } else {
            d2 = Math.min(length, (double) str.length());
        }
        return new zzom(str.substring(i, Math.max(0, ((int) d2) - i) + i));
    }
}
