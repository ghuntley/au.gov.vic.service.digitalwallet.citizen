package com.google.android.gms.internal.clearcut;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* access modifiers changed from: package-private */
public final class zzea {
    private static final zzea zznc = new zzea();
    private final zzeg zznd;
    private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();

    private zzea() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzeg zzeg = null;
        for (int i = 0; i <= 0; i++) {
            zzeg = zzk(strArr[0]);
            if (zzeg != null) {
                break;
            }
        }
        this.zznd = zzeg == null ? new zzdd() : zzeg;
    }

    public static zzea zzcm() {
        return zznc;
    }

    private static zzeg zzk(String str) {
        try {
            return (zzeg) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> zzef<T> zze(Class<T> cls) {
        zzci.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzef<T> zzef = (zzef<T>) this.zzne.get(cls);
        if (zzef != null) {
            return zzef;
        }
        zzef<T> zzd = this.zznd.zzd(cls);
        zzci.zza((Object) cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        zzci.zza((Object) zzd, "schema");
        zzef<T> zzef2 = (zzef<T>) this.zzne.putIfAbsent(cls, zzd);
        return zzef2 != null ? zzef2 : zzd;
    }

    public final <T> zzef<T> zzp(T t) {
        return zze(t.getClass());
    }
}
