package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzrd extends zzpo<Integer> implements zzrj<Integer>, zzsv, RandomAccess {
    private static final zzrd zzbbf;
    private int size;
    private int[] zzbbg;

    public static zzrd zzpo() {
        return zzbbf;
    }

    zzrd() {
        this(new int[10], 0);
    }

    private zzrd(int[] iArr, int i) {
        this.zzbbg = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            int[] iArr = this.zzbbg;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzrd)) {
            return super.equals(obj);
        }
        zzrd zzrd = (zzrd) obj;
        if (this.size != zzrd.size) {
            return false;
        }
        int[] iArr = zzrd.zzbbg;
        for (int i = 0; i < this.size; i++) {
            if (this.zzbbg[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzbbg[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzah(i);
        return this.zzbbg[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbm(int i) {
        zzq(this.size, i);
    }

    private final void zzq(int i, int i2) {
        int i3;
        zzmz();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
        int[] iArr = this.zzbbg;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzbbg, i, iArr2, i + 1, this.size - i);
            this.zzbbg = iArr2;
        }
        this.zzbbg[i] = i2;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzrd)) {
            return super.addAll(collection);
        }
        zzrd zzrd = (zzrd) collection;
        int i = zzrd.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzbbg;
            if (i3 > iArr.length) {
                this.zzbbg = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzrd.zzbbg, 0, this.zzbbg, this.size, zzrd.size);
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
            if (obj.equals(Integer.valueOf(this.zzbbg[i]))) {
                int[] iArr = this.zzbbg;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Integer set(int i, Integer num) {
        int intValue = num.intValue();
        zzmz();
        zzah(i);
        int[] iArr = this.zzbbg;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Integer remove(int i) {
        zzmz();
        zzah(i);
        int[] iArr = this.zzbbg;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ void add(int i, Integer num) {
        zzq(i, num.intValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzrj' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Integer> zzaj(int i) {
        if (i >= this.size) {
            return new zzrd(Arrays.copyOf(this.zzbbg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzrd zzrd = new zzrd(new int[0], 0);
        zzbbf = zzrd;
        zzrd.zzmi();
    }
}
