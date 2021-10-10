package com.google.android.gms.internal.gtm;

import java.util.Iterator;

/* access modifiers changed from: package-private */
public final class zzob implements Iterator<zzoa<?>> {
    private final /* synthetic */ Iterator zzaue;

    zzob(zzoa zzoa, Iterator it) {
        this.zzaue = it;
    }

    public final boolean hasNext() {
        return this.zzaue.hasNext();
    }

    public final void remove() {
        this.zzaue.remove();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        return new zzom((String) this.zzaue.next());
    }
}
