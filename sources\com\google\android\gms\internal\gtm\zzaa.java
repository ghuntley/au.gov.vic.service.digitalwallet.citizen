package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.UUID;

public final class zzaa extends zzi<zzaa> {
    private String zzva;
    private int zzvb;
    private int zzvc;
    private String zzvd;
    private String zzve;
    private boolean zzvf;
    private boolean zzvg;

    public zzaa() {
        this(false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    private zzaa(boolean z) {
        this(false, r0);
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = Integer.MAX_VALUE;
        }
    }

    private zzaa(boolean z, int i) {
        Preconditions.checkNotZero(i);
        this.zzvb = i;
        this.zzvg = false;
    }

    public final String zzca() {
        return this.zzva;
    }

    public final int zzcb() {
        return this.zzvb;
    }

    public final String zzcc() {
        return this.zzve;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.zzva);
        hashMap.put("interstitial", Boolean.valueOf(this.zzvf));
        hashMap.put("automatic", Boolean.valueOf(this.zzvg));
        hashMap.put("screenId", Integer.valueOf(this.zzvb));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzvc));
        hashMap.put("referrerScreenName", this.zzvd);
        hashMap.put("referrerUri", this.zzve);
        return zza((Object) hashMap);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzaa zzaa) {
        zzaa zzaa2 = zzaa;
        if (!TextUtils.isEmpty(this.zzva)) {
            zzaa2.zzva = this.zzva;
        }
        int i = this.zzvb;
        if (i != 0) {
            zzaa2.zzvb = i;
        }
        int i2 = this.zzvc;
        if (i2 != 0) {
            zzaa2.zzvc = i2;
        }
        if (!TextUtils.isEmpty(this.zzvd)) {
            zzaa2.zzvd = this.zzvd;
        }
        if (!TextUtils.isEmpty(this.zzve)) {
            String str = this.zzve;
            if (TextUtils.isEmpty(str)) {
                zzaa2.zzve = null;
            } else {
                zzaa2.zzve = str;
            }
        }
        boolean z = this.zzvf;
        if (z) {
            zzaa2.zzvf = z;
        }
        boolean z2 = this.zzvg;
        if (z2) {
            zzaa2.zzvg = z2;
        }
    }
}
