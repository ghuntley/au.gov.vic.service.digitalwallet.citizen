package com.google.android.gms.internal.instantapps;

import java.util.Map;

final class zzdi<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzdg> zzaqo;

    private zzdi(Map.Entry<K, zzdg> entry) {
        this.zzaqo = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzaqo.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzaqo.getValue() == null) {
            return null;
        }
        return zzdg.zzcn();
    }

    public final zzdg zzcp() {
        return this.zzaqo.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzef) {
            return this.zzaqo.getValue().zzh((zzef) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
