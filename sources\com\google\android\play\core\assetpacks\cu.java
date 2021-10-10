package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.i;
import java.util.List;

final /* synthetic */ class cu implements Runnable {
    private final cz a;
    private final List b;
    private final i c;
    private final List d;

    cu(cz czVar, List list, i iVar, List list2) {
        this.a = czVar;
        this.b = list;
        this.c = iVar;
        this.d = list2;
    }

    public final void run() {
        this.a.o(this.b, this.c, this.d);
    }
}
