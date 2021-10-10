package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class cv implements Runnable {
    private final cz a;
    private final List b;
    private final az c;
    private final i d;

    cv(cz czVar, List list, az azVar, i iVar) {
        this.a = czVar;
        this.b = list;
        this.c = azVar;
        this.d = iVar;
    }

    public final void run() {
        this.a.n(this.b, this.c, this.d);
    }
}
