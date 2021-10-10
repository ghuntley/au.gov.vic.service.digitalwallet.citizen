package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzoh extends zzoa<List<zzoa<?>>> {
    private static final Map<String, zzgz> zzaug;
    private final ArrayList<zzoa<?>> zzaup;

    public zzoh(List<zzoa<?>> list) {
        Preconditions.checkNotNull(list);
        this.zzaup = new ArrayList<>(list);
    }

    public final void zza(int i, zzoa<?> zzoa) {
        if (i >= 0) {
            if (i >= this.zzaup.size()) {
                setSize(i + 1);
            }
            this.zzaup.set(i, zzoa);
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    public final void setSize(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid array length");
        if (this.zzaup.size() != i) {
            if (this.zzaup.size() < i) {
                this.zzaup.ensureCapacity(i);
                for (int size = this.zzaup.size(); size < i; size++) {
                    this.zzaup.add(null);
                }
                return;
            }
            ArrayList<zzoa<?>> arrayList = this.zzaup;
            arrayList.subList(i, arrayList.size()).clear();
        }
    }

    public final zzoa<?> zzac(int i) {
        if (i < 0 || i >= this.zzaup.size()) {
            return zzog.zzaum;
        }
        zzoa<?> zzoa = this.zzaup.get(i);
        return zzoa == null ? zzog.zzaum : zzoa;
    }

    public final boolean zzad(int i) {
        return i >= 0 && i < this.zzaup.size() && this.zzaup.get(i) != null;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final Iterator<zzoa<?>> zzmf() {
        return new zzoj(this, new zzoi(this), super.zzmg());
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
        if (!(obj instanceof zzoh)) {
            return false;
        }
        List list = (List) ((zzoh) obj).value();
        if (this.zzaup.size() != list.size()) {
            return false;
        }
        boolean z = true;
        for (int i = 0; i < this.zzaup.size(); i++) {
            if (this.zzaup.get(i) == null) {
                z = list.get(i) == null;
            } else {
                z = this.zzaup.get(i).equals(list.get(i));
            }
            if (!z) {
                break;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.gtm.zzoa
    public final String toString() {
        return this.zzaup.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzoa
    public final /* synthetic */ List<zzoa<?>> value() {
        return this.zzaup;
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("concat", new zzhc());
        hashMap.put("every", new zzhd());
        hashMap.put("filter", new zzhe());
        hashMap.put("forEach", new zzhf());
        hashMap.put("indexOf", new zzhg());
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("join", new zzhh());
        hashMap.put("lastIndexOf", new zzhi());
        hashMap.put("map", new zzhj());
        hashMap.put("pop", new zzhk());
        hashMap.put("push", new zzhl());
        hashMap.put("reduce", new zzhm());
        hashMap.put("reduceRight", new zzhn());
        hashMap.put("reverse", new zzho());
        hashMap.put("shift", new zzhp());
        hashMap.put("slice", new zzhq());
        hashMap.put("some", new zzhr());
        hashMap.put("sort", new zzhs());
        hashMap.put("splice", new zzhw());
        hashMap.put("toString", new zzkc());
        hashMap.put("unshift", new zzhx());
        zzaug = Collections.unmodifiableMap(hashMap);
    }
}
