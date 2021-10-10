package com.google.android.gms.internal.gtm;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final class zzgq implements ThreadFactory {
    zzgq() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-background-thread");
    }
}
