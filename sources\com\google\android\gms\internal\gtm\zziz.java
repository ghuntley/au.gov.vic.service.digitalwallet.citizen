package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zziz extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        zzoa<?> zzac;
        Preconditions.checkArgument(true);
        boolean z = false;
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoa<?> zzoa = zzoaArr[0];
        zzoa<?> zzoa2 = zzoaArr[1];
        boolean z2 = zzoa instanceof zzom;
        if (z2 || !zzoo.zzl(zzoa)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        Preconditions.checkArgument(!zzoo.zzm(zzoa));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa2));
        String zzd = zzha.zzd(zzoa2);
        if (zzoa instanceof zzoh) {
            zzoh zzoh = (zzoh) zzoa;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((List) zzoh.value()).size()));
            }
            double zzb = zzha.zzb(zzoa2);
            if (zzb == Math.floor(zzb)) {
                int i = (int) zzb;
                if (zzd.equals(Integer.toString(i)) && (zzac = zzoh.zzac(i)) != zzog.zzaum) {
                    return zzac;
                }
            }
        } else if (z2) {
            zzom zzom = (zzom) zzoa;
            if ("length".equals(zzd)) {
                return new zzoe(Double.valueOf((double) ((String) zzom.value()).length()));
            }
            double zzb2 = zzha.zzb(zzoa2);
            if (zzb2 == Math.floor(zzb2)) {
                int i2 = (int) zzb2;
                if (zzd.equals(Integer.toString(i2))) {
                    return zzom.zzae(i2);
                }
            }
            return zzog.zzaum;
        }
        return zzoa.zzco(zzd);
    }
}
