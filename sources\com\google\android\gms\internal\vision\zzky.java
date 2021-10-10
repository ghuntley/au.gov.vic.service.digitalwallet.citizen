package com.google.android.gms.internal.vision;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzky {
    private static final zzky zza = new zzky();
    private final zzlf zzb = new zzkb();
    private final ConcurrentMap<Class<?>, zzlc<?>> zzc = new ConcurrentHashMap();

    public static zzky zza() {
        return zza;
    }

    public final <T> zzlc<T> zza(Class<T> cls) {
        zzjf.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzlc<T> zzlc = (zzlc<T>) this.zzc.get(cls);
        if (zzlc != null) {
            return zzlc;
        }
        zzlc<T> zza2 = this.zzb.zza(cls);
        zzjf.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzjf.zza((Object) zza2, "schema");
        zzlc<T> zzlc2 = (zzlc<T>) this.zzc.putIfAbsent(cls, zza2);
        return zzlc2 != null ? zzlc2 : zza2;
    }

    public final <T> zzlc<T> zza(T t) {
        return zza((Class) t.getClass());
    }

    private zzky() {
    }
}
