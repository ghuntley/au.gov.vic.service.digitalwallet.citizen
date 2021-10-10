package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public final class zzls extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        int i = 1;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length >= 2);
        if (zzoaArr[0] == zzog.zzaum || zzoaArr[1] == zzog.zzaum) {
            return zzog.zzaum;
        }
        String zzd = zzha.zzd(zzoaArr[0]);
        String zzd2 = zzha.zzd(zzoaArr[1]);
        int i2 = 64;
        if (zzoaArr.length > 2 && zzoaArr[2] != zzog.zzaum && zzha.zza(zzoaArr[2])) {
            i2 = 66;
        }
        if (zzoaArr.length > 3 && zzoaArr[3] != zzog.zzaum) {
            if (!(zzoaArr[3] instanceof zzoe)) {
                return zzog.zzaum;
            }
            double zzc = zzha.zzc(zzoaArr[3]);
            if (Double.isInfinite(zzc) || zzc < 0.0d) {
                return zzog.zzaum;
            }
            i = (int) zzc;
        }
        String str = null;
        try {
            Matcher matcher = Pattern.compile(zzd2, i2).matcher(zzd);
            if (matcher.find() && matcher.groupCount() >= i) {
                str = matcher.group(i);
            }
            return str == null ? zzog.zzaum : new zzom(str);
        } catch (PatternSyntaxException unused) {
            return zzog.zzaum;
        }
    }
}
