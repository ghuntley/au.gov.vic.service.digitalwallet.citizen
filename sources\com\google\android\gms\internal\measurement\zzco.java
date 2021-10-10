package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zzco extends ContentObserver {
    zzco(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzcp.zze.set(true);
    }
}
