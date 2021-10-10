package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class zzkk extends zzhb {
    private final zzkl zzarl;

    public zzkk(zzkl zzkl) {
        this.zzarl = zzkl;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkNotNull(zzoaArr);
        Preconditions.checkArgument(zzoaArr.length > 0);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        String str = (String) ((zzom) zzoaArr[0]).value();
        HashMap hashMap = new HashMap();
        if (zzoaArr.length >= 2 && zzoaArr[1] != zzog.zzaum) {
            Preconditions.checkArgument(zzoaArr[1] instanceof zzok);
            for (Map.Entry entry : ((Map) ((zzok) zzoaArr[1]).value()).entrySet()) {
                Preconditions.checkState(!(entry.getValue() instanceof zzol));
                Preconditions.checkState(!zzoo.zzm((zzoa) entry.getValue()));
                hashMap.put((String) entry.getKey(), ((zzoa) entry.getValue()).value());
            }
        }
        return zzoo.zzq(this.zzarl.zza(str, hashMap));
    }
}
