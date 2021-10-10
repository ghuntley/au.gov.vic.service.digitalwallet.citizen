package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzkg implements zzkh {
    zzkg() {
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zza(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final zzkf<?, ?> zzb(Object obj) {
        zzkc zzkc = (zzkc) obj;
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Map<?, ?> zzc(Object obj) {
        return (zzke) obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final boolean zzd(Object obj) {
        return !((zzke) obj).zzd();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zze(Object obj) {
        ((zzke) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zzf(Object obj) {
        return zzke.zza().zzb();
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final Object zza(Object obj, Object obj2) {
        zzke zzke = (zzke) obj;
        zzke zzke2 = (zzke) obj2;
        if (!zzke2.isEmpty()) {
            if (!zzke.zzd()) {
                zzke = zzke.zzb();
            }
            zzke.zza(zzke2);
        }
        return zzke;
    }

    @Override // com.google.android.gms.internal.vision.zzkh
    public final int zza(int i, Object obj, Object obj2) {
        zzke zzke = (zzke) obj;
        zzkc zzkc = (zzkc) obj2;
        if (zzke.isEmpty()) {
            return 0;
        }
        Iterator it = zzke.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
