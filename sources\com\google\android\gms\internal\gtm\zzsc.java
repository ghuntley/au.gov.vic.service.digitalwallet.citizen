package com.google.android.gms.internal.gtm;

import java.io.IOException;

public final class zzsc<K, V> {
    static <K, V> void zza(zzqj zzqj, zzsd<K, V> zzsd, K k, V v) throws IOException {
        zzqt.zza(zzqj, zzsd.zzbcp, 1, k);
        zzqt.zza(zzqj, zzsd.zzbcr, 2, v);
    }

    static <K, V> int zza(zzsd<K, V> zzsd, K k, V v) {
        return zzqt.zza(zzsd.zzbcp, 1, k) + zzqt.zza(zzsd.zzbcr, 2, v);
    }
}
