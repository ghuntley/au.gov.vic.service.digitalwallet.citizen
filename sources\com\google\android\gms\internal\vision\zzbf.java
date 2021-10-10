package com.google.android.gms.internal.vision;

import android.database.ContentObserver;
import android.os.Handler;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzbf extends ContentObserver {
    zzbf(zzbd zzbd, Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzbi.zza();
    }
}
