package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

final class zzsg implements zzsf {
    zzsg() {
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final Map<?, ?> zzx(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final zzsd<?, ?> zzac(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final Map<?, ?> zzy(Object obj) {
        return (zzse) obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final boolean zzz(Object obj) {
        return !((zzse) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final Object zzaa(Object obj) {
        ((zzse) obj).zzmi();
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final Object zzab(Object obj) {
        return zzse.zzqf().zzqg();
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final Object zzc(Object obj, Object obj2) {
        zzse zzse = (zzse) obj;
        zzse zzse2 = (zzse) obj2;
        if (!zzse2.isEmpty()) {
            if (!zzse.isMutable()) {
                zzse = zzse.zzqg();
            }
            zzse.zza(zzse2);
        }
        return zzse;
    }

    @Override // com.google.android.gms.internal.gtm.zzsf
    public final int zzb(int i, Object obj, Object obj2) {
        zzse zzse = (zzse) obj;
        if (zzse.isEmpty()) {
            return 0;
        }
        Iterator it = zzse.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
