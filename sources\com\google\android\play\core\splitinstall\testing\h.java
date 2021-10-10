package com.google.android.play.core.splitinstall.testing;

import java.util.List;

/* access modifiers changed from: package-private */
public final /* synthetic */ class h implements Runnable {
    private final FakeSplitInstallManager a;
    private final List b;
    private final List c;
    private final List d;
    private final long e;

    h(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, List list3, long j) {
        this.a = fakeSplitInstallManager;
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = j;
    }

    public final void run() {
        this.a.b(this.b, this.c, this.d, this.e);
    }
}
