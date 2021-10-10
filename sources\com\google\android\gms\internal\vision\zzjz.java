package com.google.android.gms.internal.vision;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzjz extends zzju {
    private zzjz() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final <L> List<L> zza(Object obj, long j) {
        zzjl zzc = zzc(obj, j);
        if (zzc.zza()) {
            return zzc;
        }
        int size = zzc.size();
        zzjl zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzma.zza(obj, j, zza);
        return zza;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.vision.zzjl] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzjl<E> zzc = zzc(obj, j);
        zzjl<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzjl<E> zzjl = zzc;
        zzjl = zzc;
        if (size > 0 && size2 > 0) {
            boolean zza = zzc.zza();
            zzjl<E> zzjl2 = zzc;
            if (!zza) {
                zzjl2 = zzc.zza(size2 + size);
            }
            zzjl2.addAll(zzc2);
            zzjl = zzjl2;
        }
        if (size > 0) {
            zzc2 = zzjl;
        }
        zzma.zza(obj, j, zzc2);
    }

    private static <E> zzjl<E> zzc(Object obj, long j) {
        return (zzjl) zzma.zzf(obj, j);
    }
}
