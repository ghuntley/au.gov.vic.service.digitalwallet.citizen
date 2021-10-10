package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zztb {
    private static final Class<?> zzbdu = zzqy();
    private static final zztr<?, ?> zzbdv = zzl(false);
    private static final zztr<?, ?> zzbdw = zzl(true);
    private static final zztr<?, ?> zzbdx = new zztt();

    public static void zzj(Class<?> cls) {
        Class<?> cls2;
        if (!zzrc.class.isAssignableFrom(cls) && (cls2 = zzbdu) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzum zzum, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzum zzum) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzps> list, zzum zzum) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzum zzum, zzsz zzsz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i, list, zzsz);
        }
    }

    public static void zzb(int i, List<?> list, zzum zzum, zzsz zzsz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i, list, zzsz);
        }
    }

    static int zzw(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(zzry.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzs(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzw(list) + (list.size() * zzqj.zzbb(i));
    }

    static int zzx(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(zzry.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzt(list.get(i2).longValue());
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
        return zzx(list) + (size * zzqj.zzbb(i));
    }

    static int zzy(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(zzry.getLong(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzu(list.get(i2).longValue());
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
        return zzy(list) + (size * zzqj.zzbb(i));
    }

    static int zzz(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(zzrd.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbh(list.get(i2).intValue());
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
        return zzz(list) + (size * zzqj.zzbb(i));
    }

    static int zzaa(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(zzrd.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbc(list.get(i2).intValue());
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
        return zzaa(list) + (size * zzqj.zzbb(i));
    }

    static int zzab(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(zzrd.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbd(list.get(i2).intValue());
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
        return zzab(list) + (size * zzqj.zzbb(i));
    }

    static int zzac(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(zzrd.getInt(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += zzqj.zzbe(list.get(i2).intValue());
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
        return zzac(list) + (size * zzqj.zzbb(i));
    }

    static int zzad(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzl(i, 0);
    }

    static int zzae(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzg(i, 0L);
    }

    static int zzaf(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        if (list instanceof zzrt) {
            zzrt zzrt = (zzrt) list;
            while (i4 < size) {
                Object zzbn = zzrt.zzbn(i4);
                if (zzbn instanceof zzps) {
                    i3 = zzqj.zzb((zzps) zzbn);
                } else {
                    i3 = zzqj.zzda((String) zzbn);
                }
                zzbb += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzps) {
                    i2 = zzqj.zzb((zzps) obj);
                } else {
                    i2 = zzqj.zzda((String) obj);
                }
                zzbb += i2;
                i4++;
            }
        }
        return zzbb;
    }

    static int zzc(int i, Object obj, zzsz zzsz) {
        if (obj instanceof zzrr) {
            return zzqj.zza(i, (zzrr) obj);
        }
        return zzqj.zzb(i, (zzsk) obj, zzsz);
    }

    static int zzc(int i, List<?> list, zzsz zzsz) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzrr) {
                i2 = zzqj.zza((zzrr) obj);
            } else {
                i2 = zzqj.zzb((zzsk) obj, zzsz);
            }
            zzbb += i2;
        }
        return zzbb;
    }

    static int zzd(int i, List<zzps> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzqj.zzbb(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzbb += zzqj.zzb(list.get(i2));
        }
        return zzbb;
    }

    static int zzd(int i, List<zzsk> list, zzsz zzsz) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzqj.zzc(i, list.get(i3), zzsz);
        }
        return i2;
    }

    public static zztr<?, ?> zzqv() {
        return zzbdv;
    }

    public static zztr<?, ?> zzqw() {
        return zzbdw;
    }

    public static zztr<?, ?> zzqx() {
        return zzbdx;
    }

    private static zztr<?, ?> zzl(boolean z) {
        try {
            Class<?> zzqz = zzqz();
            if (zzqz == null) {
                return null;
            }
            return (zztr) zzqz.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzqy() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzqz() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzsf zzsf, T t, T t2, long j) {
        zztx.zza(t, j, zzsf.zzc(zztx.zzp(t, j), zztx.zzp(t2, j)));
    }

    static <T, FT extends zzqv<FT>> void zza(zzqq<FT> zzqq, T t, T t2) {
        zzqt<FT> zzr = zzqq.zzr(t2);
        if (!zzr.zzaxo.isEmpty()) {
            zzqq.zzs(t).zza(zzr);
        }
    }

    static <T, UT, UB> void zza(zztr<UT, UB> zztr, T t, T t2) {
        zztr.zzf(t, zztr.zzh(zztr.zzag(t), zztr.zzag(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzrh zzrh, UB ub, zztr<UT, UB> zztr) {
        if (zzrh == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (zzrh.zzb(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) zza(i, intValue, ub, zztr);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzrh.zzb(intValue2)) {
                    ub = (UB) zza(i, intValue2, ub, zztr);
                    it.remove();
                }
            }
        }
        return ub;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zztr<UT, UB> zztr) {
        if (ub == null) {
            ub = zztr.zzri();
        }
        zztr.zza(ub, i, (long) i2);
        return ub;
    }
}
