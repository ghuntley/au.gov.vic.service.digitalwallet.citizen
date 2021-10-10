package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* access modifiers changed from: package-private */
public final class zzoc implements Iterator<zzoa<?>> {
    private zzoc() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzoa<?> next() {
        throw new NoSuchElementException();
    }

    /* synthetic */ zzoc(zzob zzob) {
        this();
    }
}
