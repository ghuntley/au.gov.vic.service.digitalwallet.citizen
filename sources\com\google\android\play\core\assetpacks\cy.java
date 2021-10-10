package com.google.android.play.core.assetpacks;

import android.content.Intent;

/* access modifiers changed from: package-private */
public final /* synthetic */ class cy implements Runnable {
    private final cz a;
    private final Intent b;

    cy(cz czVar, Intent intent) {
        this.a = czVar;
        this.b = intent;
    }

    public final void run() {
        this.a.l(this.b);
    }
}
