package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzjv extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        Matcher matcher = Pattern.compile(zzoaArr.length < 2 ? "" : zzha.zzd(zzoaArr[1])).matcher((String) ((zzom) zzoaArr[0]).value());
        if (matcher.find()) {
            return new zzoe(Double.valueOf((double) matcher.start()));
        }
        return new zzoe(Double.valueOf(-1.0d));
    }
}
