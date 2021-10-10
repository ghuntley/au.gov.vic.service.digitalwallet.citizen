package com.google.android.gms.internal.instantapps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzdr extends zzdp {
    private static final Class<?> zzaqy = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdr() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzfs.zzp(obj, j);
        if (list instanceof zzdm) {
            obj2 = ((zzdm) list).zzcr();
        } else if (!zzaqy.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzer) || !(list instanceof zzdc)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzdc zzdc = (zzdc) list;
                if (zzdc.zzr()) {
                    zzdc.zzs();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzfs.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzdn zzdn;
        List<L> list;
        List<L> zzd = zzd(obj, j);
        if (zzd.isEmpty()) {
            if (zzd instanceof zzdm) {
                list = new zzdn(i);
            } else if (!(zzd instanceof zzer) || !(zzd instanceof zzdc)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzdc) zzd).zzi(i);
            }
            zzfs.zza(obj, j, list);
            return list;
        }
        if (zzaqy.isAssignableFrom(zzd.getClass())) {
            ArrayList arrayList = new ArrayList(zzd.size() + i);
            arrayList.addAll(zzd);
            zzfs.zza(obj, j, arrayList);
            zzdn = arrayList;
        } else if (zzd instanceof zzfr) {
            zzdn zzdn2 = new zzdn(zzd.size() + i);
            zzdn2.addAll((zzfr) zzd);
            zzfs.zza(obj, j, zzdn2);
            zzdn = zzdn2;
        } else if (!(zzd instanceof zzer) || !(zzd instanceof zzdc)) {
            return zzd;
        } else {
            zzdc zzdc = (zzdc) zzd;
            if (zzdc.zzr()) {
                return zzd;
            }
            zzdc zzi = zzdc.zzi(zzd.size() + i);
            zzfs.zza(obj, j, zzi);
            return zzi;
        }
        return zzdn;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzdp
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzd = zzd(obj2, j);
        List zza = zza(obj, j, zzd.size());
        int size = zza.size();
        int size2 = zzd.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzd);
        }
        if (size > 0) {
            zzd = zza;
        }
        zzfs.zza(obj, j, zzd);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfs.zzp(obj, j);
    }
}
