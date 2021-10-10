package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzew {
    private static final Class<?> zzask = zzdp();
    private static final zzfm<?, ?> zzasl = zzd(false);
    private static final zzfm<?, ?> zzasm = zzd(true);
    private static final zzfm<?, ?> zzasn = new zzfo();

    public static void zzf(Class<?> cls) {
        Class<?> cls2;
        if (!zzcx.class.isAssignableFrom(cls) && (cls2 = zzask) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzgi zzgi, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzgi zzgi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzbp> list, zzgi zzgi) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzgi zzgi, zzeu zzeu) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zza(i, list, zzeu);
        }
    }

    public static void zzb(int i, List<?> list, zzgi zzgi, zzeu zzeu) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgi.zzb(i, list, zzeu);
        }
    }

    static int zzq(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzg(zzdt.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzg(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzce.zzaa(i));
    }

    static int zzr(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzh(zzdt.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzh(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzce.zzaa(i));
    }

    static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzi(zzdt.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzi(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzce.zzaa(i));
    }

    static int zzt(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzag(zzcz.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzag(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzce.zzaa(i));
    }

    static int zzu(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzab(zzcz.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzab(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzce.zzaa(i));
    }

    static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzac(zzcz.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzac(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzce.zzaa(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzcz) {
            zzcz zzcz = (zzcz) list;
            i = 0;
            while (i2 < size) {
                i += zzce.zzad(zzcz.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzce.zzad(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzce.zzaa(i));
    }

    static int zzx(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzce.zzj(i, 0);
    }

    static int zzy(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzce.zzg(i, 0L);
    }

    static int zzz(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzce.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzaa = zzce.zzaa(i) * size;
        if (list instanceof zzdm) {
            zzdm zzdm = (zzdm) list;
            while (i4 < size) {
                Object zzam = zzdm.zzam(i4);
                if (zzam instanceof zzbp) {
                    i3 = zzce.zzb((zzbp) zzam);
                } else {
                    i3 = zzce.zzg((String) zzam);
                }
                zzaa += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzbp) {
                    i2 = zzce.zzb((zzbp) obj);
                } else {
                    i2 = zzce.zzg((String) obj);
                }
                zzaa += i2;
                i4++;
            }
        }
        return zzaa;
    }

    static int zzc(int i, Object obj, zzeu zzeu) {
        if (obj instanceof zzdk) {
            return zzce.zza(i, (zzdk) obj);
        }
        return zzce.zzb(i, (zzef) obj, zzeu);
    }

    static int zzc(int i, List<?> list, zzeu zzeu) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaa = zzce.zzaa(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzdk) {
                i2 = zzce.zza((zzdk) obj);
            } else {
                i2 = zzce.zza((zzef) obj, zzeu);
            }
            zzaa += i2;
        }
        return zzaa;
    }

    static int zzd(int i, List<zzbp> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzaa = size * zzce.zzaa(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzaa += zzce.zzb(list.get(i2));
        }
        return zzaa;
    }

    static int zzd(int i, List<zzef> list, zzeu zzeu) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzce.zzc(i, list.get(i3), zzeu);
        }
        return i2;
    }

    public static zzfm<?, ?> zzdm() {
        return zzasl;
    }

    public static zzfm<?, ?> zzdn() {
        return zzasm;
    }

    public static zzfm<?, ?> zzdo() {
        return zzasn;
    }

    private static zzfm<?, ?> zzd(boolean z) {
        try {
            Class<?> zzdq = zzdq();
            if (zzdq == null) {
                return null;
            }
            return (zzfm) zzdq.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdp() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzdy zzdy, T t, T t2, long j) {
        zzfs.zza(t, j, zzdy.zzb(zzfs.zzp(t, j), zzfs.zzp(t2, j)));
    }

    static <T, FT extends zzcs<FT>> void zza(zzcm<FT> zzcm, T t, T t2) {
        zzcq<FT> zza = zzcm.zza((Object) t2);
        if (!zza.zzame.isEmpty()) {
            zzcm.zzb(t).zza(zza);
        }
    }

    static <T, UT, UB> void zza(zzfm<UT, UB> zzfm, T t, T t2) {
        zzfm.zze(t, zzfm.zzg(zzfm.zzq(t), zzfm.zzq(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzdd zzdd, UB ub, zzfm<UT, UB> zzfm) {
        if (zzdd == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzdd.zzf(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zzfm);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzdd.zzf(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zzfm);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzfm<UT, UB> zzfm) {
        if (ub == null) {
            ub = zzfm.zzdz();
        }
        zzfm.zza(ub, i, (long) i2);
        return ub;
    }
}
