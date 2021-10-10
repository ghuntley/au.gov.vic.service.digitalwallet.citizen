package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzmk {
    private final String zzaec;
    private final String zzajh;
    private final String zzams;
    private final String zzasg;
    private final boolean zzash;
    private final String zzasi;

    public zzmk(String str, String str2, String str3, boolean z, String str4) {
        this(str, str2, str3, z, str4, "");
    }

    private zzmk(String str, String str2, String str3, boolean z, String str4, String str5) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str5);
        this.zzaec = str;
        this.zzams = str2;
        this.zzasg = str3;
        this.zzash = z;
        this.zzasi = str4;
        this.zzajh = str5;
    }

    public final String getContainerId() {
        return this.zzaec;
    }

    public final String zzld() {
        return this.zzams;
    }

    public final String zzle() {
        return this.zzasg;
    }

    public final String zzlf() {
        String str = this.zzasg;
        if (str == null) {
            return this.zzaec;
        }
        String str2 = this.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        return sb.toString();
    }

    public final boolean zzlg() {
        return this.zzash;
    }

    public final String zzlh() {
        return this.zzasi;
    }

    public final String zzli() {
        return this.zzajh;
    }
}
