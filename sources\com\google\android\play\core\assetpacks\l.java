package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final /* synthetic */ class l implements ThreadFactory {
    static final ThreadFactory a = new l();

    private l() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
