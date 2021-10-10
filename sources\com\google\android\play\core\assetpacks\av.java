package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* access modifiers changed from: package-private */
public final /* synthetic */ class av implements Runnable {
    private final aw a;
    private final Bundle b;

    av(aw awVar, Bundle bundle) {
        this.a = awVar;
        this.b = bundle;
    }

    public final void run() {
        this.a.c(this.b);
    }
}
