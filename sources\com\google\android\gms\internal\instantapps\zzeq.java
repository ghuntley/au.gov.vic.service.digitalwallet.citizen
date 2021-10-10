package com.google.android.gms.internal.instantapps;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
public final class zzeq {
    private static final zzeq zzasg = new zzeq();
    private final zzex zzash = new zzds();
    private final ConcurrentMap<Class<?>, zzeu<?>> zzasi = new ConcurrentHashMap();

    public static zzeq zzdi() {
        return zzasg;
    }

    public final <T> zzeu<T> zze(Class<T> cls) {
        zzcy.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzeu<T> zzeu = (zzeu<T>) this.zzasi.get(cls);
        if (zzeu != null) {
            return zzeu;
        }
        zzeu<T> zzd = this.zzash.zzd(cls);
        zzcy.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzcy.zza((Object) zzd, "schema");
        zzeu<T> zzeu2 = (zzeu<T>) this.zzasi.putIfAbsent(cls, zzd);
        return zzeu2 != null ? zzeu2 : zzd;
    }

    public final <T> zzeu<T> zzp(T t) {
        return zze(t.getClass());
    }

    private zzeq() {
    }
}
