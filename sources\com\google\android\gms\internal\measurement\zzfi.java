package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzfi<K, V> extends zzfh<K, V> {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (r9.zzf() == false) goto L_0x00c8;
     */
    public final zzfj<K, V> zza() {
        V v;
        Set<Map.Entry<K, V>> entrySet = this.zza.entrySet();
        if (entrySet.isEmpty()) {
            return zzew.zza;
        }
        zzff zzff = new zzff(entrySet.size());
        Iterator<Map.Entry<K, V>> it = entrySet.iterator();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                K key = next.getKey();
                V value = next.getValue();
                if ((value instanceof zzfg) && !(value instanceof SortedSet)) {
                    v = value;
                }
                Object[] array = value.toArray();
                int length = array.length;
                while (true) {
                    if (length == 0) {
                        v = zzfs.zza;
                        break;
                    }
                    if (length == i2) {
                        v = new zzfu(array[0]);
                        break;
                    }
                    int zza = zzfg.zza(length);
                    Object[] objArr = new Object[zza];
                    int i3 = zza - 1;
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < length; i6++) {
                        Object zza2 = zzfn.zza(array[i6], i6);
                        int hashCode = zza2.hashCode();
                        int zza3 = zzez.zza(hashCode);
                        while (true) {
                            int i7 = zza3 & i3;
                            Object obj = objArr[i7];
                            if (obj == null) {
                                array[i4] = zza2;
                                objArr[i7] = zza2;
                                i5 += hashCode;
                                i4++;
                                break;
                            }
                            if (obj.equals(zza2)) {
                                break;
                            }
                            zza3++;
                        }
                    }
                    Arrays.fill(array, i4, length, (Object) null);
                    if (i4 == 1) {
                        v = new zzfu(array[0], i5);
                        break;
                    } else if (zzfg.zza(i4) < zza / 2) {
                        length = i4;
                        i2 = 1;
                    } else {
                        int length2 = array.length;
                        if (i4 < (length2 >> 1) + (length2 >> 2)) {
                            array = Arrays.copyOf(array, i4);
                        }
                        v = new zzfs(array, i5, objArr, i3, i4);
                    }
                }
                if (!v.isEmpty()) {
                    int i8 = (zzff.zzb + 1) << 1;
                    if (i8 > zzff.zza.length) {
                        Object[] objArr2 = zzff.zza;
                        int length3 = zzff.zza.length;
                        if (i8 >= 0) {
                            int i9 = length3 + (length3 >> 1) + 1;
                            if (i9 < i8) {
                                i9 = Integer.highestOneBit(i8 - 1) << 1;
                            }
                            if (i9 < 0) {
                                i9 = Integer.MAX_VALUE;
                            }
                            zzff.zza = Arrays.copyOf(objArr2, i9);
                            zzff.zzc = false;
                        } else {
                            throw new AssertionError("cannot store more than MAX_VALUE elements");
                        }
                    }
                    zzen.zza(key, v);
                    zzff.zza[zzff.zzb * 2] = key;
                    zzff.zza[(zzff.zzb * 2) + 1] = v;
                    zzff.zzb++;
                    i += v.size();
                }
            } else {
                zzff.zzc = true;
                return new zzfj<>(zzfp.zza(zzff.zzb, zzff.zza), i, null);
            }
        }
    }
}
