package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzeb<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    zzeb() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zza */
    public abstract zzfa<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzb() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzf();

    public final Object[] toArray() {
        return toArray(zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzde.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzb = zzb();
            if (zzb != null) {
                return (T[]) Arrays.copyOfRange(zzb, zzc(), zzd(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzc() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzd() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzee<E> zze() {
        return isEmpty() ? zzee.zzg() : zzee.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzfa zzfa = (zzfa) iterator();
        while (zzfa.hasNext()) {
            objArr[i] = zzfa.next();
            i++;
        }
        return i;
    }
}
