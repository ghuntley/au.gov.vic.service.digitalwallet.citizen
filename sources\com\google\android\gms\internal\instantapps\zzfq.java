package com.google.android.gms.internal.instantapps;

import java.util.ListIterator;

final class zzfq implements ListIterator<String> {
    private ListIterator<String> zzate;
    private final /* synthetic */ int zzatf;
    private final /* synthetic */ zzfr zzatg;

    zzfq(zzfr zzfr, int i) {
        this.zzatg = zzfr;
        this.zzatf = i;
        this.zzate = zzfr.zzath.listIterator(i);
    }

    public final boolean hasNext() {
        return this.zzate.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzate.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzate.nextIndex();
    }

    public final int previousIndex() {
        return this.zzate.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzate.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzate.next();
    }
}
