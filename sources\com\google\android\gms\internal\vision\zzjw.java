package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzjw extends zzju {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzjw() {
        super();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzma.zzf(obj, j);
        if (list instanceof zzjv) {
            obj2 = ((zzjv) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzkw) || !(list instanceof zzjl)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzjl zzjl = (zzjl) list;
                if (zzjl.zza()) {
                    zzjl.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzma.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <L> List<L> zza(Object obj, long j, int i) {
        zzjs zzjs;
        List<L> list;
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            if (zzc instanceof zzjv) {
                list = new zzjs(i);
            } else if (!(zzc instanceof zzkw) || !(zzc instanceof zzjl)) {
                list = new ArrayList<>(i);
            } else {
                list = ((zzjl) zzc).zza(i);
            }
            zzma.zza(obj, j, list);
            return list;
        }
        if (zza.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzma.zza(obj, j, arrayList);
            zzjs = arrayList;
        } else if (zzc instanceof zzlz) {
            zzjs zzjs2 = new zzjs(zzc.size() + i);
            zzjs2.addAll((zzlz) zzc);
            zzma.zza(obj, j, zzjs2);
            zzjs = zzjs2;
        } else if (!(zzc instanceof zzkw) || !(zzc instanceof zzjl)) {
            return zzc;
        } else {
            zzjl zzjl = (zzjl) zzc;
            if (zzjl.zza()) {
                return zzc;
            }
            zzjl zza2 = zzjl.zza(zzc.size() + i);
            zzma.zza(obj, j, zza2);
            return zza2;
        }
        return zzjs;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzju
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzma.zza(obj, j, zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzma.zzf(obj, j);
    }
}
