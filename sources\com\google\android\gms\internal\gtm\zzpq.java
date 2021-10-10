package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzpq extends zzpo<Boolean> implements zzrj<Boolean>, zzsv, RandomAccess {
    private static final zzpq zzavv;
    private int size;
    private boolean[] zzavw;

    zzpq() {
        this(new boolean[10], 0);
    }

    private zzpq(boolean[] zArr, int i) {
        this.zzavw = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            boolean[] zArr = this.zzavw;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzpq)) {
            return super.equals(obj);
        }
        zzpq zzpq = (zzpq) obj;
        if (this.size != zzpq.size) {
            return false;
        }
        boolean[] zArr = zzpq.zzavw;
        for (int i = 0; i < this.size; i++) {
            if (this.zzavw[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzre.zzk(this.zzavw[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    private final void zza(int i, boolean z) {
        int i2;
        zzmz();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
        boolean[] zArr = this.zzavw;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzavw, i, zArr2, i + 1, this.size - i);
            this.zzavw = zArr2;
        }
        this.zzavw[i] = z;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzpq)) {
            return super.addAll(collection);
        }
        zzpq zzpq = (zzpq) collection;
        int i = zzpq.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzavw;
            if (i3 > zArr.length) {
                this.zzavw = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzpq.zzavw, 0, this.zzavw, this.size, zzpq.size);
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
            if (obj.equals(Boolean.valueOf(this.zzavw[i]))) {
                boolean[] zArr = this.zzavw;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Boolean set(int i, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        zzmz();
        zzah(i);
        boolean[] zArr = this.zzavw;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Boolean remove(int i) {
        zzmz();
        zzah(i);
        boolean[] zArr = this.zzavw;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ void add(int i, Boolean bool) {
        zza(i, bool.booleanValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzrj' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Boolean> zzaj(int i) {
        if (i >= this.size) {
            return new zzpq(Arrays.copyOf(this.zzavw, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzah(i);
        return Boolean.valueOf(this.zzavw[i]);
    }

    static {
        zzpq zzpq = new zzpq(new boolean[0], 0);
        zzavv = zzpq;
        zzpq.zzmi();
    }
}
