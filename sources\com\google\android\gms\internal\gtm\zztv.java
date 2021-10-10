package com.google.android.gms.internal.gtm;

import java.util.ListIterator;

final class zztv implements ListIterator<String> {
    private ListIterator<String> zzbep;
    private final /* synthetic */ int zzbeq;
    private final /* synthetic */ zztu zzber;

    zztv(zztu zztu, int i) {
        this.zzber = zztu;
        this.zzbeq = i;
        this.zzbep = zztu.zzbeo.listIterator(i);
    }

    public final boolean hasNext() {
        return this.zzbep.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzbep.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzbep.nextIndex();
    }

    public final int previousIndex() {
        return this.zzbep.previousIndex();
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
        return this.zzbep.previous();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.zzbep.next();
    }
}
