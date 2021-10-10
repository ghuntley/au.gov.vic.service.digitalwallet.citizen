package com.google.android.gms.internal.gtm;

import java.util.Iterator;

final class zztw implements Iterator<String> {
    private final /* synthetic */ zztu zzber;
    private Iterator<String> zzbes;

    zztw(zztu zztu) {
        this.zzber = zztu;
        this.zzbes = zztu.zzbeo.iterator();
    }

    public final boolean hasNext() {
        return this.zzbes.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzbes.next();
    }
}
