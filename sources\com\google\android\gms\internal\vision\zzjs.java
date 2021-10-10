package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzjs extends zzhj<String> implements zzjv, RandomAccess {
    private static final zzjs zza;
    private static final zzjv zzb;
    private final List<Object> zzc;

    public zzjs() {
        this(10);
    }

    public zzjs(int i) {
        this(new ArrayList(i));
    }

    private zzjs(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.vision.zzhj, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.vision.zzhj, java.util.List, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zzjv) {
            collection = ((zzjv) collection).zzd();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.vision.zzhj
    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final void zza(zzht zzht) {
        zzc();
        this.zzc.add(zzht);
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzht) {
            return ((zzht) obj).zzb();
        }
        return zzjf.zzb((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final List<?> zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final zzjv zze() {
        return zza() ? new zzlz(this) : this;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.vision.zzhj, java.util.List, java.util.AbstractList
    public final /* synthetic */ String set(int i, String str) {
        zzc();
        return zza(this.zzc.set(i, str));
    }

    @Override // com.google.android.gms.internal.vision.zzhj, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzhj, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.vision.zzhj, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhj, java.util.List, java.util.AbstractList
    public final /* synthetic */ String remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
    }

    @Override // com.google.android.gms.internal.vision.zzhj, com.google.android.gms.internal.vision.zzjl
    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.android.gms.internal.vision.zzhj, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, String str) {
        zzc();
        this.zzc.add(i, str);
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.vision.zzhj, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public final /* bridge */ /* synthetic */ boolean add(String str) {
        return super.add(str);
    }

    @Override // com.google.android.gms.internal.vision.zzhj
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.vision.zzhj
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.vision.zzjl
    public final /* synthetic */ zzjl zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzjs(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzht) {
            zzht zzht = (zzht) obj;
            String zzb2 = zzht.zzb();
            if (zzht.zzc()) {
                this.zzc.set(i, zzb2);
            }
            return zzb2;
        }
        byte[] bArr = (byte[]) obj;
        String zzb3 = zzjf.zzb(bArr);
        if (zzjf.zza(bArr)) {
            this.zzc.set(i, zzb3);
        }
        return zzb3;
    }

    static {
        zzjs zzjs = new zzjs();
        zza = zzjs;
        zzjs.zzb();
        zzb = zzjs;
    }
}
