package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzle {
    private static final Class<?> zza = zzd();
    private static final zzlu<?, ?> zzb = zza(false);
    private static final zzlu<?, ?> zzc = zza(true);
    private static final zzlu<?, ?> zzd = new zzlw();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzjb.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzmr zzmr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzmr zzmr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzht> list, zzmr zzmr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzmr zzmr, zzlc zzlc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zza(i, list, zzlc);
        }
    }

    public static void zzb(int i, List<?> list, zzmr zzmr, zzlc zzlc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmr.zzb(i, list, zzlc);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzd(zzjy.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzii.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zze(zzjy.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzii.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(zzjy.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzii.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzk(zzjd.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzii.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(zzjd.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzii.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzg(zzjd.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzii.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjd) {
            zzjd zzjd = (zzjd) list;
            i = 0;
            while (i2 < size) {
                i += zzii.zzh(zzjd.zzb(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzii.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzii.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzg(i, 0L);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzii.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzii.zze(i) * size;
        if (list instanceof zzjv) {
            zzjv zzjv = (zzjv) list;
            while (i4 < size) {
                Object zzb2 = zzjv.zzb(i4);
                if (zzb2 instanceof zzht) {
                    i3 = zzii.zzb((zzht) zzb2);
                } else {
                    i3 = zzii.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzht) {
                    i2 = zzii.zzb((zzht) obj);
                } else {
                    i2 = zzii.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzlc zzlc) {
        if (obj instanceof zzjt) {
            return zzii.zza(i, (zzjt) obj);
        }
        return zzii.zzb(i, (zzkk) obj, zzlc);
    }

    static int zza(int i, List<?> list, zzlc zzlc) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzii.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzjt) {
                i2 = zzii.zza((zzjt) obj);
            } else {
                i2 = zzii.zza((zzkk) obj, zzlc);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzht> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzii.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzii.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzkk> list, zzlc zzlc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzii.zzc(i, list.get(i3), zzlc);
        }
        return i2;
    }

    public static zzlu<?, ?> zza() {
        return zzb;
    }

    public static zzlu<?, ?> zzb() {
        return zzc;
    }

    public static zzlu<?, ?> zzc() {
        return zzd;
    }

    private static zzlu<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzlu) zze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzkh zzkh, T t, T t2, long j) {
        zzma.zza(t, j, zzkh.zza(zzma.zzf(t, j), zzma.zzf(t2, j)));
    }

    static <T, FT extends zziw<FT>> void zza(zziq<FT> zziq, T t, T t2) {
        zziu<FT> zza2 = zziq.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zziq.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzlu<UT, UB> zzlu, T t, T t2) {
        zzlu.zza(t, zzlu.zzc(zzlu.zzb(t), zzlu.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzjg zzjg, UB ub, zzlu<UT, UB> zzlu) {
        if (zzjg == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzjg.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzlu);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzjg.zza(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzlu);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzlu<UT, UB> zzlu) {
        if (ub == null) {
            ub = zzlu.zza();
        }
        zzlu.zza(ub, i, (long) i2);
        return ub;
    }
}
