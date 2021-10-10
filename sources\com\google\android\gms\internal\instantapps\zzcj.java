package com.google.android.gms.internal.instantapps;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcj extends zzbj<Double> implements zzdc<Double>, zzer, RandomAccess {
    private static final zzcj zzalt;
    private int size;
    private double[] zzalu;

    zzcj() {
        this(new double[10], 0);
    }

    private zzcj(double[] dArr, int i) {
        this.zzalu = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzt();
        if (i2 >= i) {
            double[] dArr = this.zzalu;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzcj)) {
            return super.equals(obj);
        }
        zzcj zzcj = (zzcj) obj;
        if (this.size != zzcj.size) {
            return false;
        }
        double[] dArr = zzcj.zzalu;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzalu[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbj
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzcy.zzm(Double.doubleToLongBits(this.zzalu[i2]));
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzc(this.size, d);
    }

    private final void zzc(int i, double d) {
        int i2;
        zzt();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        double[] dArr = this.zzalu;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzalu, i, dArr2, i + 1, this.size - i);
            this.zzalu = dArr2;
        }
        this.zzalu[i] = d;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.instantapps.zzbj
    public final boolean addAll(Collection<? extends Double> collection) {
        zzt();
        zzcy.checkNotNull(collection);
        if (!(collection instanceof zzcj)) {
            return super.addAll(collection);
        }
        zzcj zzcj = (zzcj) collection;
        int i = zzcj.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzalu;
            if (i3 > dArr.length) {
                this.zzalu = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzcj.zzalu, 0, this.zzalu, this.size, zzcj.size);
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
            if (obj.equals(Double.valueOf(this.zzalu[i]))) {
                double[] dArr = this.zzalu;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Double set(int i, Double d) {
        double doubleValue = d.doubleValue();
        zzt();
        zzg(i);
        double[] dArr = this.zzalu;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ Double remove(int i) {
        zzt();
        zzg(i);
        double[] dArr = this.zzalu;
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
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.instantapps.zzbj
    public final /* synthetic */ void add(int i, Double d) {
        zzc(i, d.doubleValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.instantapps.zzdc' to match base method */
    @Override // com.google.android.gms.internal.instantapps.zzdc
    public final /* synthetic */ zzdc<Double> zzi(int i) {
        if (i >= this.size) {
            return new zzcj(Arrays.copyOf(this.zzalu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Double.valueOf(this.zzalu[i]);
    }

    static {
        zzcj zzcj = new zzcj(new double[0], 0);
        zzalt = zzcj;
        zzcj.zzs();
    }
}
