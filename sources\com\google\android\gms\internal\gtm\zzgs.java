package com.google.android.gms.internal.gtm;

import java.util.concurrent.ThreadFactory;

final class zzgs implements ThreadFactory {
    zzgs() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "google-tag-manager-scheduler-thread");
    }
}
