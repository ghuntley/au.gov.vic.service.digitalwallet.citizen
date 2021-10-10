package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

final class zzfc implements Iterator<String> {
    private final /* synthetic */ zzfa zzpe;
    private Iterator<String> zzpf;

    zzfc(zzfa zzfa) {
        this.zzpe = zzfa;
        this.zzpf = zzfa.zzpb.iterator();
    }

    public final boolean hasNext() {
        return this.zzpf.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzpf.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
