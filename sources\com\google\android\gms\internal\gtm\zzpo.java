package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzpo<E> extends AbstractList<E> implements zzrj<E> {
    private boolean zzavs = true;

    zzpo() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        zzmz();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        zzmz();
        super.add(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        zzmz();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzmz();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzmz();
        super.clear();
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public boolean zzmy() {
        return this.zzavs;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final void zzmi() {
        this.zzavs = false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        zzmz();
        return (E) super.remove(i);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        zzmz();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        zzmz();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzmz();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        zzmz();
        return (E) super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzmz() {
        if (!this.zzavs) {
            throw new UnsupportedOperationException();
        }
    }
}
