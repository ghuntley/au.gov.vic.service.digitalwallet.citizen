package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzi;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

public final class zzr extends zzi<zzr> {
    private String name;
    private String zzno;
    private String zztz;
    private String zzua;
    private String zzub;
    private String zzuc;
    private String zzud;
    private String zzue;
    private String zzuf;
    private String zzug;

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.name);
        hashMap.put("source", this.zztz);
        hashMap.put("medium", this.zzua);
        hashMap.put("keyword", this.zzub);
        hashMap.put(FirebaseAnalytics.Param.CONTENT, this.zzuc);
        hashMap.put("id", this.zzno);
        hashMap.put("adNetworkId", this.zzud);
        hashMap.put("gclid", this.zzue);
        hashMap.put("dclid", this.zzuf);
        hashMap.put(FirebaseAnalytics.Param.ACLID, this.zzug);
        return zza((Object) hashMap);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getSource() {
        return this.zztz;
    }

    public final void zzc(String str) {
        this.zztz = str;
    }

    public final String zzbd() {
        return this.zzua;
    }

    public final void zzd(String str) {
        this.zzua = str;
    }

    public final String zzbe() {
        return this.zzub;
    }

    public final void zze(String str) {
        this.zzub = str;
    }

    public final String zzbf() {
        return this.zzuc;
    }

    public final void zzf(String str) {
        this.zzuc = str;
    }

    public final String getId() {
        return this.zzno;
    }

    public final void zzg(String str) {
        this.zzno = str;
    }

    public final String zzbg() {
        return this.zzud;
    }

    public final void zzh(String str) {
        this.zzud = str;
    }

    public final String zzbh() {
        return this.zzue;
    }

    public final void zzi(String str) {
        this.zzue = str;
    }

    public final String zzbi() {
        return this.zzuf;
    }

    public final void zzj(String str) {
        this.zzuf = str;
    }

    public final String zzbj() {
        return this.zzug;
    }

    public final void zzk(String str) {
        this.zzug = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.analytics.zzi] */
    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzr zzr) {
        zzr zzr2 = zzr;
        if (!TextUtils.isEmpty(this.name)) {
            zzr2.name = this.name;
        }
        if (!TextUtils.isEmpty(this.zztz)) {
            zzr2.zztz = this.zztz;
        }
        if (!TextUtils.isEmpty(this.zzua)) {
            zzr2.zzua = this.zzua;
        }
        if (!TextUtils.isEmpty(this.zzub)) {
            zzr2.zzub = this.zzub;
        }
        if (!TextUtils.isEmpty(this.zzuc)) {
            zzr2.zzuc = this.zzuc;
        }
        if (!TextUtils.isEmpty(this.zzno)) {
            zzr2.zzno = this.zzno;
        }
        if (!TextUtils.isEmpty(this.zzud)) {
            zzr2.zzud = this.zzud;
        }
        if (!TextUtils.isEmpty(this.zzue)) {
            zzr2.zzue = this.zzue;
        }
        if (!TextUtils.isEmpty(this.zzuf)) {
            zzr2.zzuf = this.zzuf;
        }
        if (!TextUtils.isEmpty(this.zzug)) {
            zzr2.zzug = this.zzug;
        }
    }
}
