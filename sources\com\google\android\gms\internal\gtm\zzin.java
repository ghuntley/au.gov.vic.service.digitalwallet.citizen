package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzin extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1);
        Preconditions.checkArgument(!(zzoaArr[0] instanceof zzol));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoaArr[0]));
        zzoa<?> zzoa = zzoaArr[0];
        if (zzoa == zzog.zzaum) {
            str = "undefined";
        } else if (zzoa instanceof zzod) {
            str = "boolean";
        } else if (zzoa instanceof zzoe) {
            str = "number";
        } else if (zzoa instanceof zzom) {
            str = "string";
        } else {
            str = zzoa instanceof zzof ? "function" : "object";
        }
        return new zzom(str);
    }
}
