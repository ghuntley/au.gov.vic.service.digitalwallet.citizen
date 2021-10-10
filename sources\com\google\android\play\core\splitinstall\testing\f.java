package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

/* access modifiers changed from: package-private */
public final /* synthetic */ class f implements Runnable {
    private final FakeSplitInstallManager a;
    private final SplitInstallSessionState b;

    f(FakeSplitInstallManager fakeSplitInstallManager, SplitInstallSessionState splitInstallSessionState) {
        this.a = fakeSplitInstallManager;
        this.b = splitInstallSessionState;
    }

    public final void run() {
        this.a.d(this.b);
    }
}
