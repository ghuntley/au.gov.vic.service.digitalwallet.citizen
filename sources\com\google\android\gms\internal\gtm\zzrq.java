package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzrq<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbca;

    public zzrq(Iterator<Map.Entry<K, Object>> it) {
        this.zzbca = it;
    }

    public final boolean hasNext() {
        return this.zzbca.hasNext();
    }

    public final void remove() {
        this.zzbca.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzbca.next();
        return next.getValue() instanceof zzrn ? new zzrp(next) : next;
    }
}
