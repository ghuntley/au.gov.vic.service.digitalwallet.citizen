package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzdi {
    public static <T> zzdf<T> zza(zzdf<T> zzdf) {
        if ((zzdf instanceof zzdk) || (zzdf instanceof zzdh)) {
            return zzdf;
        }
        if (zzdf instanceof Serializable) {
            return new zzdh(zzdf);
        }
        return new zzdk(zzdf);
    }

    public static <T> zzdf<T> zza(@NullableDecl T t) {
        return new zzdj(t);
    }
}
