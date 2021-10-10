package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final /* synthetic */ class zze implements Callable {
    private final boolean zza;
    private final String zzb;
    private final zzd zzc;

    zze(boolean z, String str, zzd zzd) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzd;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return zzc.zza(this.zza, this.zzb, this.zzc);
    }
}
