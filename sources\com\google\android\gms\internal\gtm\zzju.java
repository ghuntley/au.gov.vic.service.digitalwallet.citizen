package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzju extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        Preconditions.checkArgument(zzoaArr.length > 0 && zzoaArr.length <= 3);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        if (zzoaArr.length == 1) {
            return new zzom(str);
        }
        String zzd = zzha.zzd(zzoaArr[1]);
        zzoa<?> zzoa = zzoaArr.length < 3 ? zzog.zzaum : zzoaArr[2];
        int indexOf = str.indexOf(zzd);
        if (indexOf == -1) {
            return new zzom(str);
        }
        if (zzoa instanceof zzof) {
            zzoa = ((zzgz) ((zzof) zzoa).value()).zzb(zzfl, new zzom(zzd), new zzoe(Double.valueOf((double) indexOf)), new zzom(str));
        }
        String zzd2 = zzha.zzd(zzoa);
        String substring = str.substring(0, indexOf);
        String substring2 = str.substring(indexOf + zzd.length());
        StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + String.valueOf(zzd2).length() + String.valueOf(substring2).length());
        sb.append(substring);
        sb.append(zzd2);
        sb.append(substring2);
        return new zzom(sb.toString());
    }
}
