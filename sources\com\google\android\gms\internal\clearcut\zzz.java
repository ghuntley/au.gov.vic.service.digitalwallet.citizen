package com.google.android.gms.internal.clearcut;

import android.database.ContentObserver;
import android.os.Handler;

/* access modifiers changed from: package-private */
public final class zzz extends ContentObserver {
    zzz(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzy.zzct.set(true);
    }
}
