package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;

final /* synthetic */ class d implements Runnable {
    private final j a;
    private final String b;
    private final i c;

    d(j jVar, String str, i iVar) {
        this.a = jVar;
        this.b = str;
        this.c = iVar;
    }

    public final void run() {
        this.a.f(this.b, this.c);
    }
}
