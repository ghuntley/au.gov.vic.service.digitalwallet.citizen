package com.google.android.gms.internal.instantapps;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zzfa extends zzfg {
    private final /* synthetic */ zzez zzasu;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzfa(zzez zzez) {
        super(zzez, null);
        this.zzasu = zzez;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.instantapps.zzfg, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzfb(this.zzasu, null);
    }

    /* synthetic */ zzfa(zzez zzez, zzey zzey) {
        this(zzez);
    }
}
