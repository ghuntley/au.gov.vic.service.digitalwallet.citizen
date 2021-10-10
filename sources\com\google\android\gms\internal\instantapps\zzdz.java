package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdz<K, V> extends LinkedHashMap<K, V> {
    private static final zzdz zzari;
    private boolean zzakn = true;

    private zzdz() {
    }

    private zzdz(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzdz<K, V> zzcv() {
        return zzari;
    }

    public final void zza(zzdz<K, V> zzdz) {
        zzcx();
        if (!zzdz.isEmpty()) {
            putAll(zzdz);
        }
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzcx();
        super.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V put(K k, V v) {
        zzcx();
        zzcy.checkNotNull(k);
        zzcy.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzcx();
        for (Object obj : map.keySet()) {
            zzcy.checkNotNull(obj);
            zzcy.checkNotNull(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V remove(Object obj) {
        zzcx();
        return (V) super.remove(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator<Map.Entry<K, V>> it = entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<K, V> next = it.next();
                        if (map.containsKey(next.getKey())) {
                            V value = next.getValue();
                            Object obj2 = map.get(next.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z2 = value.equals(obj2);
                                continue;
                            } else {
                                z2 = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z2) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    private static int zzl(Object obj) {
        if (obj instanceof byte[]) {
            return zzcy.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzdb)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zzl(entry.getValue()) ^ zzl(entry.getKey());
        }
        return i;
    }

    public final zzdz<K, V> zzcw() {
        return isEmpty() ? new zzdz<>() : new zzdz<>(this);
    }

    public final void zzs() {
        this.zzakn = false;
    }

    public final boolean isMutable() {
        return this.zzakn;
    }

    private final void zzcx() {
        if (!this.zzakn) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzdz zzdz = new zzdz();
        zzari = zzdz;
        zzdz.zzakn = false;
    }
}
