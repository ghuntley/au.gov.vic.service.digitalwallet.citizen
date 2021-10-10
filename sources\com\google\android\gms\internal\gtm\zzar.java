package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzar {
    private final Context zzwu;
    private final Context zzwv;

    public zzar(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        this.zzwu = applicationContext;
        this.zzwv = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.zzwu;
    }

    public final Context zzdc() {
        return this.zzwv;
    }
}
