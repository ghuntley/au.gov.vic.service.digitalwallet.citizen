package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzse<K, V> extends LinkedHashMap<K, V> {
    private static final zzse zzbct;
    private boolean zzavs = true;

    private zzse() {
    }

    private zzse(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzse<K, V> zzqf() {
        return zzbct;
    }

    public final void zza(zzse<K, V> zzse) {
        zzqh();
        if (!zzse.isEmpty()) {
            putAll(zzse);
        }
    }

    @Override // java.util.LinkedHashMap, java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzqh();
        super.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V put(K k, V v) {
        zzqh();
        zzre.checkNotNull(k);
        zzre.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzqh();
        for (Object obj : map.keySet()) {
            zzre.checkNotNull(obj);
            zzre.checkNotNull(map.get(obj));
        }
        super.putAll(map);
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.HashMap
    public final V remove(Object obj) {
        zzqh();
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

    private static int zzw(Object obj) {
        if (obj instanceof byte[]) {
            return zzre.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzrf)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zzw(entry.getValue()) ^ zzw(entry.getKey());
        }
        return i;
    }

    public final zzse<K, V> zzqg() {
        return isEmpty() ? new zzse<>() : new zzse<>(this);
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    public final boolean isMutable() {
        return this.zzavs;
    }

    private final void zzqh() {
        if (!this.zzavs) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzse zzse = new zzse();
        zzbct = zzse;
        zzse.zzavs = false;
    }
}
