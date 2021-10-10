package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzok extends zzoa<Map<String, zzoa<?>>> {
    private static final Map<String, zzgz> zzaug;
    private boolean zzaut = false;

    public zzok(Map<String, zzoa<?>> map) {
        this.zzaud = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final zzoa<?> zzco(String str) {
        zzoa<?> zzco = super.zzco(str);
        return zzco == null ? zzog.zzaum : zzco;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Native Method ");
        sb.append(str);
        sb.append(" is not defined for type ListWrapper.");
        throw new IllegalStateException(sb.toString());
    }

    public final void zzmi() {
        this.zzaut = true;
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzok) {
            return this.zzaud.entrySet().equals(((Map) ((zzok) obj).value()).entrySet());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzaud.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ Map<String, zzoa<?>> value() {
        return this.zzaud;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }
}
