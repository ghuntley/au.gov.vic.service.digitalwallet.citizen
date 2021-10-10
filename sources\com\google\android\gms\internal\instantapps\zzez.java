package com.google.android.gms.internal.instantapps;

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
public class zzez<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzamf;
    private final int zzaso;
    private List<zzfe> zzasp;
    private Map<K, V> zzasq;
    private volatile zzfg zzasr;
    private Map<K, V> zzass;
    private volatile zzfa zzast;

    static <FieldDescriptorType extends zzcs<FieldDescriptorType>> zzez<FieldDescriptorType, Object> zzau(int i) {
        return new zzey(i);
    }

    private zzez(int i) {
        this.zzaso = i;
        this.zzasp = Collections.emptyList();
        this.zzasq = Collections.emptyMap();
        this.zzass = Collections.emptyMap();
    }

    public void zzs() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzamf) {
            if (this.zzasq.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzasq);
            }
            this.zzasq = map;
            if (this.zzass.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzass);
            }
            this.zzass = map2;
            this.zzamf = true;
        }
    }

    public final boolean isImmutable() {
        return this.zzamf;
    }

    public final int zzdr() {
        return this.zzasp.size();
    }

    public final Map.Entry<K, V> zzav(int i) {
        return this.zzasp.get(i);
    }

    public final Iterable<Map.Entry<K, V>> zzds() {
        if (this.zzasq.isEmpty()) {
            return zzfd.zzdx();
        }
        return this.zzasq.entrySet();
    }

    public int size() {
        return this.zzasp.size() + this.zzasq.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.instantapps.zzez<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzasq.containsKey(comparable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.instantapps.zzez<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? (V) this.zzasp.get(zza).getValue() : this.zzasq.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzdu();
        int zza = zza(k);
        if (zza >= 0) {
            return (V) this.zzasp.get(zza).setValue(v);
        }
        zzdu();
        if (this.zzasp.isEmpty() && !(this.zzasp instanceof ArrayList)) {
            this.zzasp = new ArrayList(this.zzaso);
        }
        int i = -(zza + 1);
        if (i >= this.zzaso) {
            return zzdv().put(k, v);
        }
        int size = this.zzasp.size();
        int i2 = this.zzaso;
        if (size == i2) {
            zzfe remove = this.zzasp.remove(i2 - 1);
            zzdv().put((K) ((Comparable) remove.getKey()), (V) remove.getValue());
        }
        this.zzasp.add(i, new zzfe(this, k, v));
        return null;
    }

    public void clear() {
        zzdu();
        if (!this.zzasp.isEmpty()) {
            this.zzasp.clear();
        }
        if (!this.zzasq.isEmpty()) {
            this.zzasq.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.instantapps.zzez<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzdu();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return (V) zzaw(zza);
        }
        if (this.zzasq.isEmpty()) {
            return null;
        }
        return this.zzasq.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzaw(int i) {
        zzdu();
        V v = (V) this.zzasp.remove(i).getValue();
        if (!this.zzasq.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzdv().entrySet().iterator();
            this.zzasp.add(new zzfe(this, it.next()));
            it.remove();
        }
        return v;
    }

    private final int zza(K k) {
        int size = this.zzasp.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzasp.get(size).getKey());
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
            int compareTo2 = k.compareTo((Comparable) this.zzasp.get(i2).getKey());
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
        if (this.zzasr == null) {
            this.zzasr = new zzfg(this, null);
        }
        return this.zzasr;
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzdt() {
        if (this.zzast == null) {
            this.zzast = new zzfa(this, null);
        }
        return this.zzast;
    }

    /* access modifiers changed from: private */
    public final void zzdu() {
        if (this.zzamf) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzdv() {
        zzdu();
        if (this.zzasq.isEmpty() && !(this.zzasq instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzasq = treeMap;
            this.zzass = treeMap.descendingMap();
        }
        return (SortedMap) this.zzasq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzez)) {
            return super.equals(obj);
        }
        zzez zzez = (zzez) obj;
        int size = size();
        if (size != zzez.size()) {
            return false;
        }
        int zzdr = zzdr();
        if (zzdr != zzez.zzdr()) {
            return entrySet().equals(zzez.entrySet());
        }
        for (int i = 0; i < zzdr; i++) {
            if (!zzav(i).equals(zzez.zzav(i))) {
                return false;
            }
        }
        if (zzdr != size) {
            return this.zzasq.equals(zzez.zzasq);
        }
        return true;
    }

    public int hashCode() {
        int zzdr = zzdr();
        int i = 0;
        for (int i2 = 0; i2 < zzdr; i2++) {
            i += this.zzasp.get(i2).hashCode();
        }
        return this.zzasq.size() > 0 ? i + this.zzasq.hashCode() : i;
    }

    /* synthetic */ zzez(int i, zzey zzey) {
        this(i);
    }
}
