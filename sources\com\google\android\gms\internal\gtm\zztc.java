package com.google.android.gms.internal.gtm;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public class zztc<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzaut;
    private final int zzbdy;
    private List<zztj> zzbdz;
    private Map<K, V> zzbea;
    private volatile zztl zzbeb;
    private Map<K, V> zzbec;
    private volatile zztf zzbed;

    static <FieldDescriptorType extends zzqv<FieldDescriptorType>> zztc<FieldDescriptorType, Object> zzbu(int i) {
        return new zztd(i);
    }

    private zztc(int i) {
        this.zzbdy = i;
        this.zzbdz = Collections.emptyList();
        this.zzbea = Collections.emptyMap();
        this.zzbec = Collections.emptyMap();
    }

    public void zzmi() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzaut) {
            if (this.zzbea.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzbea);
            }
            this.zzbea = map;
            if (this.zzbec.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzbec);
            }
            this.zzbec = map2;
            this.zzaut = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    public final int zzra() {
        return this.zzbdz.size();
    }

    public final Map.Entry<K, V> zzbv(int i) {
        return this.zzbdz.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzrb() {
        if (this.zzbea.isEmpty()) {
            return zztg.zzrg();
        }
        return this.zzbea.entrySet();
    }

    public int size() {
        return this.zzbdz.size() + this.zzbea.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.gtm.zztc<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzbea.containsKey(comparable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.gtm.zztc<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? (V) this.zzbdz.get(zza).getValue() : this.zzbea.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzrd();
        int zza = zza(k);
        if (zza >= 0) {
            return (V) this.zzbdz.get(zza).setValue(v);
        }
        zzrd();
        if (this.zzbdz.isEmpty() && !(this.zzbdz instanceof ArrayList)) {
            this.zzbdz = new ArrayList(this.zzbdy);
        }
        int i = -(zza + 1);
        if (i >= this.zzbdy) {
            return zzre().put(k, v);
        }
        int size = this.zzbdz.size();
        int i2 = this.zzbdy;
        if (size == i2) {
            zztj remove = this.zzbdz.remove(i2 - 1);
            zzre().put((K) ((Comparable) remove.getKey()), (V) remove.getValue());
        }
        this.zzbdz.add(i, new zztj(this, k, v));
        return null;
    }

    public void clear() {
        zzrd();
        if (!this.zzbdz.isEmpty()) {
            this.zzbdz.clear();
        }
        if (!this.zzbea.isEmpty()) {
            this.zzbea.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.gtm.zztc<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzrd();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return (V) zzbw(zza);
        }
        if (this.zzbea.isEmpty()) {
            return null;
        }
        return this.zzbea.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzbw(int i) {
        zzrd();
        V v = (V) this.zzbdz.remove(i).getValue();
        if (!this.zzbea.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzre().entrySet().iterator();
            this.zzbdz.add(new zztj(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int zza(K k) {
        int size = this.zzbdz.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzbdz.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzbdz.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzbeb == null) {
            this.zzbeb = new zztl(this, null);
        }
        return this.zzbeb;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzrc() {
        if (this.zzbed == null) {
            this.zzbed = new zztf(this, null);
        }
        return this.zzbed;
    }

    /* access modifiers changed from: private */
    public final void zzrd() {
        if (this.zzaut) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzre() {
        zzrd();
        if (this.zzbea.isEmpty() && !(this.zzbea instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzbea = treeMap;
            this.zzbec = treeMap.descendingMap();
        }
        return (SortedMap) this.zzbea;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zztc)) {
            return super.equals(obj);
        }
        zztc zztc = (zztc) obj;
        int size = size();
        if (size != zztc.size()) {
            return false;
        }
        int zzra = zzra();
        if (zzra != zztc.zzra()) {
            return entrySet().equals(zztc.entrySet());
        }
        for (int i = 0; i < zzra; i++) {
            if (!zzbv(i).equals(zztc.zzbv(i))) {
                return false;
            }
        }
        if (zzra != size) {
            return this.zzbea.equals(zztc.zzbea);
        }
        return true;
    }

    public int hashCode() {
        int zzra = zzra();
        int i = 0;
        for (int i2 = 0; i2 < zzra; i2++) {
            i += this.zzbdz.get(i2).hashCode();
        }
        return this.zzbea.size() > 0 ? i + this.zzbea.hashCode() : i;
    }

    /* synthetic */ zztc(int i, zztd zztd) {
        this(i);
    }
}
