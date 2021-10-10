package com.google.android.gms.internal.gtm;

import java.util.Map;

final class zzrp<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzrn> zzbbz;

    private zzrp(Map.Entry<K, zzrn> entry) {
        this.zzbbz = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzbbz.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzbbz.getValue() == null) {
            return null;
        }
        return zzrn.zzpy();
    }

    public final zzrn zzpz() {
        return this.zzbbz.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzsk) {
            return this.zzbbz.getValue().zzi((zzsk) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
