package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

public final class zzhh extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        String str;
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length == 1 || zzoaArr.length == 2);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzoh);
        List<zzoa> list = (List) ((zzoh) zzoaArr[0]).value();
        zzoa<?> zzoa = zzoaArr.length < 2 ? zzog.zzaum : zzoaArr[1];
        if (zzoa == zzog.zzaum) {
            str = ",";
        } else {
            str = zzha.zzd(zzoa);
        }
        ArrayList arrayList = new ArrayList();
        for (zzoa zzoa2 : list) {
            if (zzoa2 == zzog.zzaul || zzoa2 == zzog.zzaum) {
                arrayList.add("");
            } else {
                arrayList.add(zzha.zzd(zzoa2));
            }
        }
        return new zzom(TextUtils.join(str, arrayList));
    }
}
