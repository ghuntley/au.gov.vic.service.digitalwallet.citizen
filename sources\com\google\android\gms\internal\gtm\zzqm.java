package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzqm extends zzpo<Double> implements zzrj<Double>, zzsv, RandomAccess {
    private static final zzqm zzaxe;
    private int size;
    private double[] zzaxf;

    zzqm() {
        this(new double[10], 0);
    }

    private zzqm(double[] dArr, int i) {
        this.zzaxf = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            double[] dArr = this.zzaxf;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzqm)) {
            return super.equals(obj);
        }
        zzqm zzqm = (zzqm) obj;
        if (this.size != zzqm.size) {
            return false;
        }
        double[] dArr = zzqm.zzaxf;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzaxf[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzre.zzz(Double.doubleToLongBits(this.zzaxf[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzd(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        int i2;
        zzmz();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
        double[] dArr = this.zzaxf;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzaxf, i, dArr2, i + 1, this.size - i);
            this.zzaxf = dArr2;
        }
        this.zzaxf[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.Collection
    public final boolean addAll(Collection<? extends Double> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzqm)) {
            return super.addAll(collection);
        }
        zzqm zzqm = (zzqm) collection;
        int i = zzqm.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzaxf;
            if (i3 > dArr.length) {
                this.zzaxf = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzqm.zzaxf, 0, this.zzaxf, this.size, zzqm.size);
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
            if (obj.equals(Double.valueOf(this.zzaxf[i]))) {
                double[] dArr = this.zzaxf;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Double set(int i, Double d) {
        double doubleValue = d.doubleValue();
        zzmz();
        zzah(i);
        double[] dArr = this.zzaxf;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Double remove(int i) {
        zzmz();
        zzah(i);
        double[] dArr = this.zzaxf;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ void add(int i, Double d) {
        zzc(i, d.doubleValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzrj' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Double> zzaj(int i) {
        if (i >= this.size) {
            return new zzqm(Arrays.copyOf(this.zzaxf, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzah(i);
        return Double.valueOf(this.zzaxf[i]);
    }

    static {
        zzqm zzqm = new zzqm(new double[0], 0);
        zzaxe = zzqm;
        zzqm.zzmi();
    }
}
