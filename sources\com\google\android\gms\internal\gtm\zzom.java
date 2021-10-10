package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzom extends zzoa<String> {
    private static final Map<String, zzgz> zzaug;
    private final String value;

    public zzom(String str) {
        Preconditions.checkNotNull(str);
        this.value = str;
    }

    public final zzoa<?> zzae(int i) {
        if (i < 0 || i >= this.value.length()) {
            return zzog.zzaum;
        }
        return new zzom(String.valueOf(this.value.charAt(i)));
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final Iterator<zzoa<?>> zzmf() {
        return new zzon(this);
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

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzom) {
            return this.value.equals((String) ((zzom) obj).value());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.value.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ String value() {
        return this.value;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("charAt", new zzjp());
        hashMap.put("concat", new zzjq());
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("indexOf", new zzjr());
        hashMap.put("lastIndexOf", new zzjs());
        hashMap.put("match", new zzjt());
        hashMap.put("replace", new zzju());
        hashMap.put(FirebaseAnalytics.Event.SEARCH, new zzjv());
        hashMap.put("slice", new zzjw());
        hashMap.put("split", new zzjx());
        hashMap.put("substring", new zzjy());
        hashMap.put("toLocaleLowerCase", new zzjz());
        hashMap.put("toLocaleUpperCase", new zzka());
        hashMap.put("toLowerCase", new zzkb());
        hashMap.put("toUpperCase", new zzkd());
        hashMap.put("toString", new zzkc());
        hashMap.put("trim", new zzke());
        zzaug = Collections.unmodifiableMap(hashMap);
    }
}
