package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzja extends zzhb {
    public static final zzja zzark = new zzja();

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 2);
        zzoa<?> zzoa = zzoaArr[0];
        zzoa<?> zzoa2 = zzoaArr[1];
        Preconditions.checkArgument(!zzoo.zzm(zzoa));
        Preconditions.checkArgument(true ^ zzoo.zzm(zzoa2));
        String zzd = zzha.zzd(zzoa2);
        if (zzoa instanceof zzoh) {
            if ("length".equals(zzd)) {
                return new zzod(true);
            }
            double zzb = zzha.zzb(zzoa2);
            if (zzb == Math.floor(zzb)) {
                int i = (int) zzb;
                if (zzd.equals(Integer.toString(i)) && i >= 0 && i < ((List) ((zzoh) zzoa).value()).size()) {
                    return new zzod(true);
                }
            }
        } else if (zzoa instanceof zzom) {
            if ("length".equals(zzd)) {
                return new zzod(true);
            }
            double zzb2 = zzha.zzb(zzoa2);
            if (zzb2 == Math.floor(zzb2)) {
                int i2 = (int) zzb2;
                if (zzd.equals(Integer.toString(i2)) && i2 >= 0 && i2 < ((String) ((zzom) zzoa).value()).length()) {
                    return new zzod(true);
                }
            }
            return new zzod(false);
        }
        return new zzod(Boolean.valueOf(zzoa.zzcn(zzd)));
    }
}
