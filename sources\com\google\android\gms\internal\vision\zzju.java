package com.google.android.gms.internal.vision;

import java.util.List;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public abstract class zzju {
    private static final zzju zza = new zzjw();
    private static final zzju zzb = new zzjz();

    private zzju() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzju zza() {
        return zza;
    }

    static zzju zzb() {
        return zzb;
    }
}
