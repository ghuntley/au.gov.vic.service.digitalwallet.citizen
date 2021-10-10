package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzlz extends AbstractList<String> implements zzjv, RandomAccess {
    private final zzjv zza;

    public zzlz(zzjv zzjv) {
        this.zza = zzjv;
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final zzjv zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final void zza(zzht zzht) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final ListIterator<String> listIterator(int i) {
        return new zzly(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzmb(this);
    }

    @Override // com.google.android.gms.internal.vision.zzjv
    public final List<?> zzd() {
        return this.zza.zzd();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ String get(int i) {
        return (String) this.zza.get(i);
    }
}
