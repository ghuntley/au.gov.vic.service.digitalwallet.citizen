package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import java.util.HashMap;

public final class zzv extends zzi<zzv> {
    private String zzuj;
    public int zzuk;
    public int zzul;
    public int zzum;
    public int zzun;
    public int zzuo;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.zzuj);
        hashMap.put("screenColors", Integer.valueOf(this.zzuk));
        hashMap.put("screenWidth", Integer.valueOf(this.zzul));
        hashMap.put("screenHeight", Integer.valueOf(this.zzum));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzun));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzuo));
        return zza((Object) hashMap);
    }

    public final String getLanguage() {
        return this.zzuj;
    }

    public final void setLanguage(String str) {
        this.zzuj = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzv zzv) {
        zzv zzv2 = zzv;
        int i = this.zzuk;
        if (i != 0) {
            zzv2.zzuk = i;
        }
        int i2 = this.zzul;
        if (i2 != 0) {
            zzv2.zzul = i2;
        }
        int i3 = this.zzum;
        if (i3 != 0) {
            zzv2.zzum = i3;
        }
        int i4 = this.zzun;
        if (i4 != 0) {
            zzv2.zzun = i4;
        }
        int i5 = this.zzuo;
        if (i5 != 0) {
            zzv2.zzuo = i5;
        }
        if (!TextUtils.isEmpty(this.zzuj)) {
            zzv2.zzuj = this.zzuj;
        }
    }
}
