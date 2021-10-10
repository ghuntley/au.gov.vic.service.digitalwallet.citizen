package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import java.util.Map;

final class zzeh {
    private final long zzabb;
    private final long zzagy;
    private final long zzagz;
    private String zzaha;
    private String zzant;
    private Map<String, String> zzanu;
    private String zzanv;

    /* access modifiers changed from: package-private */
    public final long zzih() {
        return this.zzagy;
    }

    /* access modifiers changed from: package-private */
    public final long zzii() {
        return this.zzagz;
    }

    zzeh(long j, long j2, long j3) {
        this.zzagy = j;
        this.zzabb = j2;
        this.zzagz = j3;
    }

    /* access modifiers changed from: package-private */
    public final String zzij() {
        return this.zzaha;
    }

    /* access modifiers changed from: package-private */
    public final void zzbc(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzaha = str;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbt(String str) {
        this.zzant = str;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Map<String, String> map) {
        this.zzanu = map;
    }

    /* access modifiers changed from: package-private */
    public final void zzbu(String str) {
        this.zzanv = str;
    }

    /* access modifiers changed from: package-private */
    public final String zzkj() {
        return this.zzant;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzkk() {
        return this.zzanu;
    }

    /* access modifiers changed from: package-private */
    public final String zzkl() {
        return this.zzanv;
    }
}
