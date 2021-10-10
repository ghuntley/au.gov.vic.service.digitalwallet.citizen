package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzry extends zzpo<Long> implements zzrj<Long>, zzsv, RandomAccess {
    private static final zzry zzbck;
    private int size;
    private long[] zzbcl;

    zzry() {
        this(new long[10], 0);
    }

    private zzry(long[] jArr, int i) {
        this.zzbcl = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            long[] jArr = this.zzbcl;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzry)) {
            return super.equals(obj);
        }
        zzry zzry = (zzry) obj;
        if (this.size != zzry.size) {
            return false;
        }
        long[] jArr = zzry.zzbcl;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbcl[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzre.zzz(this.zzbcl[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzah(i);
        return this.zzbcl[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzaa(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        int i2;
        zzmz();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
        long[] jArr = this.zzbcl;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzbcl, i, jArr2, i + 1, this.size - i);
            this.zzbcl = jArr2;
        }
        this.zzbcl[i] = j;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzry)) {
            return super.addAll(collection);
        }
        zzry zzry = (zzry) collection;
        int i = zzry.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzbcl;
            if (i3 > jArr.length) {
                this.zzbcl = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzry.zzbcl, 0, this.zzbcl, this.size, zzry.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzbcl[i]))) {
                long[] jArr = this.zzbcl;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzah(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
    }

    private final String zzai(int i) {
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
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Long set(int i, Long l) {
        long longValue = l.longValue();
        zzmz();
        zzah(i);
        long[] jArr = this.zzbcl;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Long remove(int i) {
        zzmz();
        zzah(i);
        long[] jArr = this.zzbcl;
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
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ void add(int i, Long l) {
        zzk(i, l.longValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzrj' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Long> zzaj(int i) {
        if (i >= this.size) {
            return new zzry(Arrays.copyOf(this.zzbcl, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzry zzry = new zzry(new long[0], 0);
        zzbck = zzry;
        zzry.zzmi();
    }
}
