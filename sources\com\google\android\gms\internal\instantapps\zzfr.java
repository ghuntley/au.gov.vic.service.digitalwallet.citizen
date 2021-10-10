package com.google.android.gms.internal.instantapps;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzfr extends AbstractList<String> implements zzdm, RandomAccess {
    private final zzdm zzath;

    public zzfr(zzdm zzdm) {
        this.zzath = zzdm;
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final zzdm zzcr() {
        return this;
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final Object zzam(int i) {
        return this.zzath.zzam(i);
    }

    public final int size() {
        return this.zzath.size();
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final void zzc(zzbp zzbp) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzfq(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzft(this);
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final List<?> zzcq() {
        return this.zzath.zzcq();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zzath.get(i);
    }
}
