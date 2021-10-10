package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzaw extends ContentObserver {
    private final /* synthetic */ zzau zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaw(zzau zzau, Handler handler) {
        super(null);
        this.zza = zzau;
    }

    public final void onChange(boolean z) {
        this.zza.zza();
    }
}
