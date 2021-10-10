package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.Map;

final class zzfh implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzez zzasu;
    private Iterator<Map.Entry<K, V>> zzasv;
    private boolean zzasz;

    private zzfh(zzez zzez) {
        this.zzasu = zzez;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzasu.zzasp.size() || (!this.zzasu.zzasq.isEmpty() && zzdw().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzasz) {
            this.zzasz = false;
            this.zzasu.zzdu();
            if (this.pos < this.zzasu.zzasp.size()) {
                zzez zzez = this.zzasu;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzez.zzaw(i);
                return;
            }
            zzdw().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzdw() {
        if (this.zzasv == null) {
            this.zzasv = this.zzasu.zzasq.entrySet().iterator();
        }
        return this.zzasv;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzasz = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzasu.zzasp.size()) {
            return (Map.Entry) this.zzasu.zzasp.get(this.pos);
        }
        return (Map.Entry) zzdw().next();
    }

    /* synthetic */ zzfh(zzez zzez, zzey zzey) {
        this(zzez);
    }
}
