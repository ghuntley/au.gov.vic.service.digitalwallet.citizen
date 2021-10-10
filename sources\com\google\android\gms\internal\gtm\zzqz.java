package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzqz extends zzpo<Float> implements zzrj<Float>, zzsv, RandomAccess {
    private static final zzqz zzbag;
    private int size;
    private float[] zzbah;

    zzqz() {
        this(new float[10], 0);
    }

    private zzqz(float[] fArr, int i) {
        this.zzbah = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            float[] fArr = this.zzbah;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzqz)) {
            return super.equals(obj);
        }
        zzqz zzqz = (zzqz) obj;
        if (this.size != zzqz.size) {
            return false;
        }
        float[] fArr = zzqz.zzbah;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzbah[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.zzpo
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzbah[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        int i2;
        zzmz();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzai(i));
        }
        float[] fArr = this.zzbah;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzbah, i, fArr2, i + 1, this.size - i);
            this.zzbah = fArr2;
        }
        this.zzbah[i] = f;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof zzqz)) {
            return super.addAll(collection);
        }
        zzqz zzqz = (zzqz) collection;
        int i = zzqz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzbah;
            if (i3 > fArr.length) {
                this.zzbah = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzqz.zzbah, 0, this.zzbah, this.size, zzqz.size);
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
            if (obj.equals(Float.valueOf(this.zzbah[i]))) {
                float[] fArr = this.zzbah;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Float set(int i, Float f) {
        float floatValue = f.floatValue();
        zzmz();
        zzah(i);
        float[] fArr = this.zzbah;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ Float remove(int i) {
        zzmz();
        zzah(i);
        float[] fArr = this.zzbah;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.gtm.zzpo, java.util.AbstractList
    public final /* synthetic */ void add(int i, Float f) {
        zzc(i, f.floatValue());
    }

    /* Return type fixed from 'com.google.android.gms.internal.gtm.zzrj' to match base method */
    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Float> zzaj(int i) {
        if (i >= this.size) {
            return new zzqz(Arrays.copyOf(this.zzbah, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzah(i);
        return Float.valueOf(this.zzbah[i]);
    }

    static {
        zzqz zzqz = new zzqz(new float[0], 0);
        zzbag = zzqz;
        zzqz.zzmi();
    }
}
