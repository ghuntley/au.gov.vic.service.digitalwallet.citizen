package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import java.util.HashMap;

public final class zzab extends zzi<zzab> {
    public String zzvh;
    public String zzvi;
    public String zzvj;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("network", this.zzvh);
        hashMap.put("action", this.zzvi);
        hashMap.put("target", this.zzvj);
        return zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzab zzab) {
        zzab zzab2 = zzab;
        if (!TextUtils.isEmpty(this.zzvh)) {
            zzab2.zzvh = this.zzvh;
        }
        if (!TextUtils.isEmpty(this.zzvi)) {
            zzab2.zzvi = this.zzvi;
        }
        if (!TextUtils.isEmpty(this.zzvj)) {
            zzab2.zzvj = this.zzvj;
        }
    }
}
