package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzjf extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z = true;
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length == 3);
        zzoa<?> zzoa = zzoaArr[0];
        zzoa<?> zzoa2 = zzoaArr[1];
        zzoa<?> zzoa3 = zzoaArr[2];
        Preconditions.checkArgument(zzoa != zzog.zzaul);
        Preconditions.checkArgument(zzoa != zzog.zzaum);
        Preconditions.checkArgument(!zzoo.zzm(zzoa));
        Preconditions.checkArgument(!zzoo.zzm(zzoa2));
        Preconditions.checkArgument(!zzoo.zzm(zzoa3));
        if (zzoo.zzl(zzoa)) {
            return zzoa3;
        }
        String zzd = zzha.zzd(zzoa2);
        if (zzoa instanceof zzok) {
            zzok zzok = (zzok) zzoa;
            if (!zzok.isImmutable()) {
                zzok.zzc(zzd, zzoa3);
            }
            return zzoa3;
        }
        if (zzoa instanceof zzoh) {
            zzoh zzoh = (zzoh) zzoa;
            if ("length".equals(zzd)) {
                double zzb = zzha.zzb(zzoa3);
                if (Double.isInfinite(zzb) || zzb != Math.floor(zzb)) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                zzoh.setSize((int) zzb);
                return zzoa3;
            }
            double zzb2 = zzha.zzb(zzoa2);
            if (!Double.isInfinite(zzb2) && zzb2 >= 0.0d) {
                int i = (int) zzb2;
                if (zzd.equals(Integer.toString(i))) {
                    zzoh.zza(i, zzoa3);
                    return zzoa3;
                }
            }
        }
        zzoa.zzc(zzd, zzoa3);
        return zzoa3;
    }
}
