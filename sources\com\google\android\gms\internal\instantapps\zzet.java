package com.google.android.gms.internal.instantapps;

import java.util.ArrayList;
import java.util.List;

final class zzet<E> extends zzbj<E> {
    private static final zzet<Object> zzasj;
    private final List<E> zzaqv;

    public static <E> zzet<E> zzdl() {
        return (zzet<E>) zzasj;
    }

    zzet() {
        this(new ArrayList(10));
    }

    private zzet(List<E> list) {
        this.zzaqv = list;
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final void add(int i, E e) {
        zzt();
        this.zzaqv.add(i, e);
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        return this.zzaqv.get(i);
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final E remove(int i) {
        zzt();
        E remove = this.zzaqv.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final E set(int i, E e) {
        zzt();
        E e2 = this.zzaqv.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzaqv.size();
    }

    @Override // com.google.android.gms.internal.instantapps.zzdc
    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzaqv);
            return new zzet(arrayList);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzet<Object> zzet = new zzet<>(new ArrayList(0));
        zzasj = zzet;
        zzet.zzs();
    }
}
