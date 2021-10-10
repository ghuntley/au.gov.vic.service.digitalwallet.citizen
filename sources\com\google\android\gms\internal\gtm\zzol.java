package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzol extends zzoa<String> {
    private final String zzauu;
    private final List<zzoa<?>> zzauv;

    public zzol(String str, List<zzoa<?>> list) {
        Preconditions.checkNotNull(str, "Instruction name must be a string.");
        Preconditions.checkNotNull(list);
        this.zzauu = str;
        this.zzauv = list;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        String str = this.zzauu;
        String obj = this.zzauv.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(obj).length());
        sb.append("*");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        return sb.toString();
    }

    public final String zzmj() {
        return this.zzauu;
    }

    public final List<zzoa<?>> zzmk() {
        return this.zzauv;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ String value() {
        return toString();
    }
}
