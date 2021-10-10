package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzte implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzbee;
    private final /* synthetic */ zztc zzbef;

    private zzte(zztc zztc) {
        this.zzbef = zztc;
        this.pos = zztc.zzbdz.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzbef.zzbdz.size()) || zzrf().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzrf() {
        if (this.zzbee == null) {
            this.zzbee = this.zzbef.zzbec.entrySet().iterator();
        }
        return this.zzbee;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzrf().hasNext()) {
            return (Map.Entry) zzrf().next();
        }
        List list = this.zzbef.zzbdz;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    /* synthetic */ zzte(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
