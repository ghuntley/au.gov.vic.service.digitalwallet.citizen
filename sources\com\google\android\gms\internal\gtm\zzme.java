package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzme extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2 || zzoaArr.length == 3);
        String zzd = zzha.zzd(zzoaArr[0]);
        String zzd2 = zzha.zzd(zzoaArr[1]);
        if (zzoaArr.length < 3) {
            z = false;
        } else {
            z = "true".equalsIgnoreCase(zzha.zzd(zzoaArr[2]));
        }
        int i = 64;
        if (z) {
            i = 66;
        }
        try {
            return new zzod(Boolean.valueOf(Pattern.compile(zzd2, i).matcher(zzd).find()));
        } catch (PatternSyntaxException unused) {
            return new zzod(false);
        }
    }
}
