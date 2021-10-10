package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class zztf extends zztl {
    private final /* synthetic */ zztc zzbef;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zztf(zztc zztc) {
        super(zztc, null);
        this.zzbef = zztc;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.google.android.gms.internal.gtm.zztl, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzte(this.zzbef, null);
    }

    /* synthetic */ zztf(zztc zztc, zztd zztd) {
        this(zztc);
    }
}
