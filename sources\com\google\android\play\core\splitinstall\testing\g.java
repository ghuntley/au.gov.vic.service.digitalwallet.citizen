package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* access modifiers changed from: package-private */
public final /* synthetic */ class g implements Runnable {
    private final FakeSplitInstallManager a;
    private final long b;
    private final List c;
    private final List d;
    private final List e;

    g(FakeSplitInstallManager fakeSplitInstallManager, long j, List list, List list2, List list3) {
        this.a = fakeSplitInstallManager;
        this.b = j;
        this.c = list;
        this.d = list2;
        this.e = list3;
    }

    public final void run() {
        this.a.c(this.b, this.c, this.d, this.e);
    }
}
