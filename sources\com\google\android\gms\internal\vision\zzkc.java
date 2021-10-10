package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzkc<K, V> {
    static <K, V> void zza(zzii zzii, zzkf<K, V> zzkf, K k, V v) throws IOException {
        zziu.zza(zzii, zzkf.zza, 1, k);
        zziu.zza(zzii, zzkf.zzc, 2, v);
    }

    static <K, V> int zza(zzkf<K, V> zzkf, K k, V v) {
        return zziu.zza(zzkf.zza, 1, k) + zziu.zza(zzkf.zzc, 2, v);
    }
}
