package com.google.android.play.core.splitinstall.testing;

import java.util.List;

final /* synthetic */ class c implements Runnable {
    private final FakeSplitInstallManager a;
    private final List b;
    private final List c;

    c(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2) {
        this.a = fakeSplitInstallManager;
        this.b = list;
        this.c = list2;
    }

    public final void run() {
        this.a.f(this.b, this.c);
    }
}
