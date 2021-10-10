package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import java.util.HashMap;

public final class zzy extends zzi<zzy> {
    public String zzuq;
    public boolean zzur;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.zzuq);
        hashMap.put("fatal", Boolean.valueOf(this.zzur));
        return zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzy zzy) {
        zzy zzy2 = zzy;
        if (!TextUtils.isEmpty(this.zzuq)) {
            zzy2.zzuq = this.zzuq;
        }
        boolean z = this.zzur;
        if (z) {
            zzy2.zzur = z;
        }
    }
}
