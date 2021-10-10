package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zznm {
    private String version;
    private final List<zznr> zzatq;
    private final Map<String, zzno> zzatr;
    private int zzpw = 0;

    public zznm(List<zznr> list, Map<String, zzno> map, String str, int i) {
        this.zzatq = Collections.unmodifiableList(list);
        this.zzatr = Collections.unmodifiableMap(map);
        this.version = str;
    }

    public final List<zznr> zzls() {
        return this.zzatq;
    }

    public final zzno zzck(String str) {
        return this.zzatr.get(str);
    }

    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatq);
        String valueOf2 = String.valueOf(this.zzatr);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18 + String.valueOf(valueOf2).length());
        sb.append("Rules: ");
        sb.append(valueOf);
        sb.append("\n  Macros: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
