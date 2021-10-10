package com.google.android.play.core.splitcompat;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final class b implements ThreadFactory {
    b() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "SplitCompatBackgroundThread");
    }
}
