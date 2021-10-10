package com.google.android.gms.internal.instantapps;

import java.util.Iterator;

final class zzft implements Iterator<String> {
    private final /* synthetic */ zzfr zzatg;
    private Iterator<String> zzauc;

    zzft(zzfr zzfr) {
        this.zzatg = zzfr;
        this.zzauc = zzfr.zzath.iterator();
    }

    public final boolean hasNext() {
        return this.zzauc.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzauc.next();
    }
}
