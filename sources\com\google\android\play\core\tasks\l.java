package com.google.android.play.core.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class l implements Executor {
    private final Handler a = new Handler(Looper.getMainLooper());

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
