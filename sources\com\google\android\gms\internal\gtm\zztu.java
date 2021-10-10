package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zztu extends AbstractList<String> implements zzrt, RandomAccess {
    private final zzrt zzbeo;

    public zztu(zzrt zzrt) {
        this.zzbeo = zzrt;
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final zzrt zzqb() {
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final Object zzbn(int i) {
        return this.zzbeo.zzbn(i);
    }

    public final int size() {
        return this.zzbeo.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final void zzc(zzps zzps) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zztv(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zztw(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzrt
    public final List<?> zzqa() {
        return this.zzbeo.zzqa();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzbeo.get(i);
    }
}
