package com.google.android.gms.internal.gtm;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public class zztl extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zztc zzbef;

    private zztl(zztc zztc) {
        this.zzbef = zztc;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new zztk(this.zzbef, null);
    }

    public int size() {
        return this.zzbef.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzbef.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzbef.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzbef.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzbef.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zztl(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
