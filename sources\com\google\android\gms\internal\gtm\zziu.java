package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;

public final class zziu extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        HashMap hashMap = new HashMap();
        for (int i = 0; i < zzoaArr.length - 1; i += 2) {
            String zzd = zzha.zzd(zzoaArr[i]);
            zzoa<?> zzoa = zzoaArr[i + 1];
            if (!(zzoa instanceof zzog) || zzoa == zzog.zzaul || zzoa == zzog.zzaum) {
                hashMap.put(zzd, zzoa);
            } else {
                throw new IllegalStateException("Illegal InternalType found in CreateObject.");
            }
        }
        return new zzok(hashMap);
    }
}
