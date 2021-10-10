package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzdp<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Object zzd = new Object();
    @NullableDecl
    transient int[] zza;
    @NullableDecl
    transient Object[] zzb;
    @NullableDecl
    transient Object[] zzc;
    @NullableDecl
    private transient Object zze;
    private transient int zzf = zzfc.zza(3, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    private transient int zzg;
    @NullableDecl
    private transient Set<K> zzh;
    @NullableDecl
    private transient Set<Map.Entry<K, V>> zzi;
    @NullableDecl
    private transient Collection<V> zzj;

    zzdp() {
        zzde.zza(true, (Object) "Expected size must be >= 0");
    }

    static int zzb(int i, int i2) {
        return i - 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zze == null;
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public final Map<K, V> zzb() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    private final void zzb(int i) {
        this.zzf = zzea.zza(this.zzf, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    /* access modifiers changed from: private */
    public final int zzi() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        this.zzf += 32;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.util.LinkedHashMap */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V put(@NullableDecl K k, @NullableDecl V v) {
        int min;
        if (zza()) {
            zzde.zzb(zza(), "Arrays already allocated");
            int i = this.zzf;
            int max = Math.max(i + 1, 2);
            int highestOneBit = Integer.highestOneBit(max);
            int max2 = Math.max(4, (max <= ((int) (((double) highestOneBit) * 1.0d)) || (highestOneBit = highestOneBit << 1) > 0) ? highestOneBit : 1073741824);
            this.zze = zzea.zza(max2);
            zzb(max2 - 1);
            this.zza = new int[i];
            this.zzb = new Object[i];
            this.zzc = new Object[i];
        }
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.put(k, v);
        }
        int[] iArr = this.zza;
        Object[] objArr = this.zzb;
        Object[] objArr2 = this.zzc;
        int i2 = this.zzg;
        int i3 = i2 + 1;
        int zza2 = zzec.zza(k);
        int zzi2 = zzi();
        int i4 = zza2 & zzi2;
        int zza3 = zzea.zza(this.zze, i4);
        if (zza3 != 0) {
            int i5 = ~zzi2;
            int i6 = zza2 & i5;
            int i7 = 0;
            while (true) {
                int i8 = zza3 - 1;
                int i9 = iArr[i8];
                if ((i9 & i5) != i6 || !zzcz.zza(k, objArr[i8])) {
                    int i10 = i9 & zzi2;
                    int i11 = i7 + 1;
                    if (i10 != 0) {
                        i7 = i11;
                        zza3 = i10;
                        objArr = objArr;
                    } else if (i11 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(zzi() + 1, 1.0f);
                        int zzd2 = zzd();
                        while (zzd2 >= 0) {
                            linkedHashMap.put(this.zzb[zzd2], this.zzc[zzd2]);
                            zzd2 = zza(zzd2);
                        }
                        this.zze = linkedHashMap;
                        this.zza = null;
                        this.zzb = null;
                        this.zzc = null;
                        zzc();
                        return (V) linkedHashMap.put(k, v);
                    } else if (i3 > zzi2) {
                        zzi2 = zza(zzi2, zzea.zzb(zzi2), zza2, i2);
                    } else {
                        iArr[i8] = zzea.zza(i9, i3, zzi2);
                    }
                } else {
                    V v2 = (V) objArr2[i8];
                    objArr2[i8] = v;
                    return v2;
                }
            }
        } else if (i3 > zzi2) {
            zzi2 = zza(zzi2, zzea.zzb(zzi2), zza2, i2);
        } else {
            zzea.zza(this.zze, i4, i3);
        }
        int length = this.zza.length;
        if (i3 > length && (min = Math.min((int) LockFreeTaskQueueCore.MAX_CAPACITY_MASK, 1 | (Math.max(1, length >>> 1) + length))) != length) {
            this.zza = Arrays.copyOf(this.zza, min);
            this.zzb = Arrays.copyOf(this.zzb, min);
            this.zzc = Arrays.copyOf(this.zzc, min);
        }
        this.zza[i2] = zzea.zza(zza2, 0, zzi2);
        this.zzb[i2] = k;
        this.zzc[i2] = v;
        this.zzg = i3;
        zzc();
        return null;
    }

    private final int zza(int i, int i2, int i3, int i4) {
        Object zza2 = zzea.zza(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            zzea.zza(zza2, i3 & i5, i4 + 1);
        }
        Object obj = this.zze;
        int[] iArr = this.zza;
        for (int i6 = 0; i6 <= i; i6++) {
            int zza3 = zzea.zza(obj, i6);
            while (zza3 != 0) {
                int i7 = zza3 - 1;
                int i8 = iArr[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int zza4 = zzea.zza(zza2, i10);
                zzea.zza(zza2, i10, zza3);
                iArr[i7] = zzea.zza(i9, zza4, i5);
                zza3 = i8 & i;
            }
        }
        this.zze = zza2;
        zzb(i5);
        return i5;
    }

    /* access modifiers changed from: private */
    public final int zza(@NullableDecl Object obj) {
        if (zza()) {
            return -1;
        }
        int zza2 = zzec.zza(obj);
        int zzi2 = zzi();
        int zza3 = zzea.zza(this.zze, zza2 & zzi2);
        if (zza3 == 0) {
            return -1;
        }
        int i = ~zzi2;
        int i2 = zza2 & i;
        do {
            int i3 = zza3 - 1;
            int i4 = this.zza[i3];
            if ((i4 & i) == i2 && zzcz.zza(obj, this.zzb[i3])) {
                return i3;
            }
            zza3 = i4 & zzi2;
        } while (zza3 != 0);
        return -1;
    }

    public final boolean containsKey(@NullableDecl Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsKey(obj);
        }
        return zza(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final V get(@NullableDecl Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.get(obj);
        }
        int zza2 = zza(obj);
        if (zza2 == -1) {
            return null;
        }
        return (V) this.zzc[zza2];
    }

    @Override // java.util.AbstractMap, java.util.Map
    @NullableDecl
    public final V remove(@NullableDecl Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.remove(obj);
        }
        V v = (V) zzb(obj);
        if (v == zzd) {
            return null;
        }
        return v;
    }

    /* access modifiers changed from: private */
    @NullableDecl
    public final Object zzb(@NullableDecl Object obj) {
        if (zza()) {
            return zzd;
        }
        int zzi2 = zzi();
        int zza2 = zzea.zza(obj, null, zzi2, this.zze, this.zza, this.zzb, null);
        if (zza2 == -1) {
            return zzd;
        }
        Object obj2 = this.zzc[zza2];
        zza(zza2, zzi2);
        this.zzg--;
        zzc();
        return obj2;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, int i2) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.zzb;
            Object obj = objArr[size];
            objArr[i] = obj;
            Object[] objArr2 = this.zzc;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            int[] iArr = this.zza;
            iArr[i] = iArr[size];
            iArr[size] = 0;
            int zza2 = zzec.zza(obj) & i2;
            int zza3 = zzea.zza(this.zze, zza2);
            int i3 = size + 1;
            if (zza3 == i3) {
                zzea.zza(this.zze, zza2, i + 1);
                return;
            }
            while (true) {
                int i4 = zza3 - 1;
                int[] iArr2 = this.zza;
                int i5 = iArr2[i4];
                int i6 = i5 & i2;
                if (i6 == i3) {
                    iArr2[i4] = zzea.zza(i5, i + 1, i2);
                    return;
                }
                zza3 = i6;
            }
        } else {
            this.zzb[i] = null;
            this.zzc[i] = null;
            this.zza[i] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        Set<K> set = this.zzh;
        if (set != null) {
            return set;
        }
        zzdv zzdv = new zzdv(this);
        this.zzh = zzdv;
        return zzdv;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<K> zze() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.keySet().iterator();
        }
        return new zzds(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.zzi;
        if (set != null) {
            return set;
        }
        zzdt zzdt = new zzdt(this);
        this.zzi = zzdt;
        return zzdt;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<K, V>> zzf() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.entrySet().iterator();
        }
        return new zzdr(this);
    }

    public final int size() {
        Map<K, V> zzb2 = zzb();
        return zzb2 != null ? zzb2.size() : this.zzg;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final boolean containsValue(@NullableDecl Object obj) {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (zzcz.zza(obj, this.zzc[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        Collection<V> collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzdx zzdx = new zzdx(this);
        this.zzj = zzdx;
        return zzdx;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> zzg() {
        Map<K, V> zzb2 = zzb();
        if (zzb2 != null) {
            return zzb2.values().iterator();
        }
        return new zzdu(this);
    }

    public final void clear() {
        if (!zza()) {
            zzc();
            Map<K, V> zzb2 = zzb();
            if (zzb2 != null) {
                this.zzf = zzfc.zza(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
                zzb2.clear();
                this.zze = null;
                this.zzg = 0;
                return;
            }
            Arrays.fill(this.zzb, 0, this.zzg, (Object) null);
            Arrays.fill(this.zzc, 0, this.zzg, (Object) null);
            Object obj = this.zze;
            if (obj instanceof byte[]) {
                Arrays.fill((byte[]) obj, (byte) 0);
            } else if (obj instanceof short[]) {
                Arrays.fill((short[]) obj, (short) 0);
            } else {
                Arrays.fill((int[]) obj, 0);
            }
            Arrays.fill(this.zza, 0, this.zzg, 0);
            this.zzg = 0;
        }
    }

    static /* synthetic */ int zzd(zzdp zzdp) {
        int i = zzdp.zzg;
        zzdp.zzg = i - 1;
        return i;
    }
}
