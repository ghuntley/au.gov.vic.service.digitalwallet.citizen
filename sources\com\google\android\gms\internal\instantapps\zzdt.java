package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdt extends zzbj<Long> implements zzdc<Long>, zzer, RandomAccess {
    private static final zzdt zzarb;
    private int size;
    private long[] zzarc;

    zzdt() {
        this(new long[10], 0);
    }

    private zzdt(long[] jArr, int i) {
        this.zzarc = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzt();
        if (i2 >= i) {
            long[] jArr = this.zzarc;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdt)) {
            return super.equals(obj);
        }
        zzdt zzdt = (zzdt) obj;
        if (this.size != zzdt.size) {
            return false;
        }
        long[] jArr = zzdt.zzarc;
        for (int i = 0; i < this.size; i++) {
            if (this.zzarc[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzcy.zzm(this.zzarc[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzg(i);
        return this.zzarc[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzn(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        int i2;
        zzt();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        long[] jArr = this.zzarc;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzarc, i, jArr2, i + 1, this.size - i);
            this.zzarc = jArr2;
        }
        this.zzarc[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.instantapps.zzbj
    public final boolean addAll(Collection<? extends Long> collection) {
        zzt();
        zzcy.checkNotNull(collection);
        if (!(collection instanceof zzdt)) {
            return super.addAll(collection);
        }
        zzdt zzdt = (zzdt) collection;
        int i = zzdt.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzarc;
            if (i3 > jArr.length) {
                this.zzarc = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzdt.zzarc, 0, this.zzarc, this.size, zzdt.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.List, com.google.android.gms.internal.instantapps.zzbj
    public final boolean remove(Object obj) {
        zzt();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzarc[i]))) {
                long[] jArr = this.zzarc;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    private final String zzh(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ Long set(int i, Long l) {
        long longValue = l.longValue();
        zzt();
        zzg(i);
        long[] jArr = this.zzarc;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ Long remove(int i) {
        zzt();
        zzg(i);
        long[] jArr = this.zzarc;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ void add(int i, Long l) {
        zzk(i, l.longValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.instantapps.zzdc' to match base method */
    @Override // com.google.android.gms.internal.instantapps.zzdc
    public final /* synthetic */ zzdc<Long> zzi(int i) {
        if (i >= this.size) {
            return new zzdt(Arrays.copyOf(this.zzarc, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzdt zzdt = new zzdt(new long[0], 0);
        zzarb = zzdt;
        zzdt.zzs();
    }
}
