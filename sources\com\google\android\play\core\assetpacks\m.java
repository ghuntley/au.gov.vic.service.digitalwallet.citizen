package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

/* access modifiers changed from: package-private */
public final /* synthetic */ class m implements ThreadFactory {
    static final ThreadFactory a = new m();

    private m() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
