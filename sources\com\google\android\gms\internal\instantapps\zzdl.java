package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzdl<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzaqs;

    public zzdl(Iterator<Map.Entry<K, Object>> it) {
        this.zzaqs = it;
    }

    public final boolean hasNext() {
        return this.zzaqs.hasNext();
    }

    public final void remove() {
        this.zzaqs.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzaqs.next();
        return next.getValue() instanceof zzdg ? new zzdi(next) : next;
    }
}
