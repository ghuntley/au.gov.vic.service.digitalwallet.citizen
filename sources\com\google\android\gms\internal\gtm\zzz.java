package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;

public final class zzz extends zzi<zzz> {
    private String zzus;
    private String zzut;
    private String zzuu;
    private String zzuv;
    private boolean zzuw;
    private String zzux;
    private boolean zzuy;
    private double zzuz;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.zzus);
        hashMap.put("clientId", this.zzut);
        hashMap.put("userId", this.zzuu);
        hashMap.put("androidAdId", this.zzuv);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzuw));
        hashMap.put("sessionControl", this.zzux);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzuy));
        hashMap.put("sampleRate", Double.valueOf(this.zzuz));
        return zza((Object) hashMap);
    }

    public final String zzbs() {
        return this.zzus;
    }

    public final void zzl(String str) {
        this.zzus = str;
    }

    public final String zzbt() {
        return this.zzut;
    }

    public final void setClientId(String str) {
        this.zzut = str;
    }

    public final String zzbu() {
        return this.zzuu;
    }

    public final void setUserId(String str) {
        this.zzuu = str;
    }

    public final String zzbv() {
        return this.zzuv;
    }

    public final void zzm(String str) {
        this.zzuv = str;
    }

    public final boolean zzbw() {
        return this.zzuw;
    }

    public final void zza(boolean z) {
        this.zzuw = z;
    }

    public final String zzbx() {
        return this.zzux;
    }

    public final boolean zzby() {
        return this.zzuy;
    }

    public final void zzb(boolean z) {
        this.zzuy = true;
    }

    public final double zzbz() {
        return this.zzuz;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzz zzz) {
        zzz zzz2 = zzz;
        if (!TextUtils.isEmpty(this.zzus)) {
            zzz2.zzus = this.zzus;
        }
        if (!TextUtils.isEmpty(this.zzut)) {
            zzz2.zzut = this.zzut;
        }
        if (!TextUtils.isEmpty(this.zzuu)) {
            zzz2.zzuu = this.zzuu;
        }
        if (!TextUtils.isEmpty(this.zzuv)) {
            zzz2.zzuv = this.zzuv;
        }
        boolean z = true;
        if (this.zzuw) {
            zzz2.zzuw = true;
        }
        if (!TextUtils.isEmpty(this.zzux)) {
            zzz2.zzux = this.zzux;
        }
        boolean z2 = this.zzuy;
        if (z2) {
            zzz2.zzuy = z2;
        }
        double d = this.zzuz;
        if (d != 0.0d) {
            if (d < 0.0d || d > 100.0d) {
                z = false;
            }
            Preconditions.checkArgument(z, "Sample rate must be between 0% and 100%");
            zzz2.zzuz = d;
        }
    }
}
