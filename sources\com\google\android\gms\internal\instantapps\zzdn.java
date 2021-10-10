package com.google.android.gms.internal.instantapps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdn extends zzbj<String> implements zzdm, RandomAccess {
    private static final zzdn zzaqt;
    private static final zzdm zzaqu;
    private final List<Object> zzaqv;

    public zzdn() {
        this(10);
    }

    public zzdn(int i) {
        this(new ArrayList(i));
    }

    private zzdn(ArrayList<Object> arrayList) {
        this.zzaqv = arrayList;
    }

    public final int size() {
        return this.zzaqv.size();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.instantapps.zzbj
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzt();
        if (collection instanceof zzdm) {
            collection = ((zzdm) collection).zzcq();
        }
        boolean addAll = this.zzaqv.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final void clear() {
        zzt();
        this.zzaqv.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final void zzc(zzbp zzbp) {
        zzt();
        this.zzaqv.add(zzbp);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final Object zzam(int i) {
        return this.zzaqv.get(i);
    }

    private static String zze(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbp) {
            return ((zzbp) obj).zzu();
        }
        return zzcy.zze((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final List<?> zzcq() {
        return Collections.unmodifiableList(this.zzaqv);
    }

    @Override // com.google.android.gms.internal.instantapps.zzdm
    public final zzdm zzcr() {
        return zzr() ? new zzfr(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ String set(int i, String str) {
        zzt();
        return zze(this.zzaqv.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // java.util.List, com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ String remove(int i) {
        zzt();
        Object remove = this.zzaqv.remove(i);
        this.modCount++;
        return zze(remove);
    }

    @Override // com.google.android.gms.internal.instantapps.zzdc, com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ boolean zzr() {
        return super.zzr();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ void add(int i, String str) {
        zzt();
        this.zzaqv.add(i, str);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.instantapps.zzdc
    public final /* synthetic */ zzdc zzi(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzaqv);
            return new zzdn(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzaqv.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbp) {
            zzbp zzbp = (zzbp) obj;
            String zzu = zzbp.zzu();
            if (zzbp.zzv()) {
                this.zzaqv.set(i, zzu);
            }
            return zzu;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzcy.zze(bArr);
        if (zzcy.zzd(bArr)) {
            this.zzaqv.set(i, zze);
        }
        return zze;
    }

    static {
        zzdn zzdn = new zzdn();
        zzaqt = zzdn;
        zzdn.zzs();
        zzaqu = zzdn;
    }
}
