package com.google.android.gms.internal.gtm;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
public final class zzsw {
    private static final zzsw zzbdr = new zzsw();
    private final zzta zzbds = new zzrz();
    private final ConcurrentMap<Class<?>, zzsz<?>> zzbdt = new ConcurrentHashMap();

    public static zzsw zzqs() {
        return zzbdr;
    }

    public final <T> zzsz<T> zzi(Class<T> cls) {
        zzre.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzsz<T> zzsz = (zzsz<T>) this.zzbdt.get(cls);
        if (zzsz != null) {
            return zzsz;
        }
        zzsz<T> zzh = this.zzbds.zzh(cls);
        zzre.zza(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzre.zza(zzh, "schema");
        zzsz<T> zzsz2 = (zzsz<T>) this.zzbdt.putIfAbsent(cls, zzh);
        return zzsz2 != null ? zzsz2 : zzh;
    }

    public final <T> zzsz<T> zzaf(T t) {
        return zzi(t.getClass());
    }

    private zzsw() {
    }
}
