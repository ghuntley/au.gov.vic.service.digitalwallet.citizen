package com.google.android.gms.internal.gtm;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* access modifiers changed from: package-private */
public final class zzgh implements ComponentCallbacks2 {
    final /* synthetic */ zzfy zzaqb;

    zzgh(zzfy zzfy) {
        this.zzaqb = zzfy;
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            this.zzaqb.zzamv.execute(new zzgi(this));
        }
    }
}
