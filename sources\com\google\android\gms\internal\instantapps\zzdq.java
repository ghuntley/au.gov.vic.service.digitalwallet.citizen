package com.google.android.gms.internal.instantapps;

import java.util.List;

final class zzdq extends zzdp {
    private zzdq() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final <L> List<L> zza(Object obj, long j) {
        zzdc zzc = zzc(obj, j);
        if (zzc.zzr()) {
            return zzc;
        }
        int size = zzc.size();
        zzdc zzi = zzc.zzi(size == 0 ? 10 : size << 1);
        zzfs.zza(obj, j, zzi);
        return zzi;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final void zzb(Object obj, long j) {
        zzc(obj, j).zzs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.instantapps.zzdc] */
    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdc<E> zzc = zzc(obj, j);
        zzdc<E> zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        zzdc<E> zzdc = zzc;
        zzdc = zzc;
        if (size > 0 && size2 > 0) {
            boolean zzr = zzc.zzr();
            zzdc<E> zzdc2 = zzc;
            if (!zzr) {
                zzdc2 = zzc.zzi(size2 + size);
            }
            zzdc2.addAll(zzc2);
            zzdc = zzdc2;
        }
        if (size > 0) {
            zzc2 = zzdc;
        }
        zzfs.zza(obj, j, zzc2);
    }

    private static <E> zzdc<E> zzc(Object obj, long j) {
        return (zzdc) zzfs.zzp(obj, j);
    }
}
