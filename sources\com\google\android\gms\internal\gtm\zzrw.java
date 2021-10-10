package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzrw extends zzru {
    private static final Class<?> zzbcj = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzrw() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzru
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzru
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zztx.zzp(obj, j);
        if (list instanceof zzrt) {
            obj2 = ((zzrt) list).zzqb();
        } else if (!zzbcj.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzsv) || !(list instanceof zzrj)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzrj zzrj = (zzrj) list;
                if (zzrj.zzmy()) {
                    zzrj.zzmi();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zztx.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzrs zzrs;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzrt) {
                list = new zzrs(i);
            } else if (!(zzc instanceof zzsv) || !(zzc instanceof zzrj)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzrj) zzc).zzaj(i);
            }
            zztx.zza(obj, j, list);
            return list;
        }
        if (zzbcj.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zztx.zza(obj, j, arrayList);
            zzrs = arrayList;
        } else if (zzc instanceof zztu) {
            zzrs zzrs2 = new zzrs(zzc.size() + i);
            zzrs2.addAll((zztu) zzc);
            zztx.zza(obj, j, zzrs2);
            zzrs = zzrs2;
        } else if (!(zzc instanceof zzsv) || !(zzc instanceof zzrj)) {
            return zzc;
        } else {
            zzrj zzrj = (zzrj) zzc;
            if (zzrj.zzmy()) {
                return zzc;
            }
            zzrj zzaj = zzrj.zzaj(zzc.size() + i);
            zztx.zza(obj, j, zzaj);
            return zzaj;
        }
        return zzrs;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzru
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza;
        }
        zztx.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zztx.zzp(obj, j);
    }
}
