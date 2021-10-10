package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;

public final class zznr {
    private final List<zzno> zzatu;
    private final List<zzno> zzatv;
    private final List<zzno> zzatw;
    private final List<zzno> zzatx;

    private zznr(List<zzno> list, List<zzno> list2, List<zzno> list3, List<zzno> list4) {
        this.zzatu = Collections.unmodifiableList(list);
        this.zzatv = Collections.unmodifiableList(list2);
        this.zzatw = Collections.unmodifiableList(list3);
        this.zzatx = Collections.unmodifiableList(list4);
    }

    public final List<zzno> zzlw() {
        return this.zzatu;
    }

    public final List<zzno> zzlx() {
        return this.zzatv;
    }

    public final List<zzno> zzly() {
        return this.zzatw;
    }

    public final List<zzno> zzlz() {
        return this.zzatx;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatu);
        String valueOf2 = String.valueOf(this.zzatv);
        String valueOf3 = String.valueOf(this.zzatw);
        String valueOf4 = String.valueOf(this.zzatx);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Positive predicates: ");
        sb.append(valueOf);
        sb.append("  Negative predicates: ");
        sb.append(valueOf2);
        sb.append("  Add tags: ");
        sb.append(valueOf3);
        sb.append("  Remove tags: ");
        sb.append(valueOf4);
        return sb.toString();
    }
}
