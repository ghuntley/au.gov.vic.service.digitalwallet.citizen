package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzfb implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzez zzasu;
    private Iterator<Map.Entry<K, V>> zzasv;

    private zzfb(zzez zzez) {
        this.zzasu = zzez;
        this.pos = zzez.zzasp.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzasu.zzasp.size()) || zzdw().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzdw() {
        if (this.zzasv == null) {
            this.zzasv = this.zzasu.zzass.entrySet().iterator();
        }
        return this.zzasv;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzdw().hasNext()) {
            return (Map.Entry) zzdw().next();
        }
        List list = this.zzasu.zzasp;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ zzfb(zzez zzez, zzey zzey) {
        this(zzez);
    }
}
