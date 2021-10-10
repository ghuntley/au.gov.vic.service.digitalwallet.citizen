package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzeu extends zzee<Map.Entry<K, V>> {
    private final /* synthetic */ zzer zza;

    zzeu(zzer zzer) {
        this.zza = zzer;
    }

    @Override // com.google.android.gms.internal.vision.zzeb
    public final boolean zzf() {
        return true;
    }

    public final int size() {
        return zzer.zza(this.zza);
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzde.zza(i, zzer.zza(this.zza));
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(zzer.zzb(this.zza)[i2], zzer.zzb(this.zza)[i2 + 1]);
    }
}
