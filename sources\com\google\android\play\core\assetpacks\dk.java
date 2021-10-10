package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import java.util.concurrent.Executor;

public final class dk implements co<dj> {
    private final co<bb> a;
    private final co<w> b;
    private final co<cp> c;
    private final co<Executor> d;
    private final co<bz> e;

    public dk(co<bb> coVar, co<w> coVar2, co<cp> coVar3, co<Executor> coVar4, co<bz> coVar5) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
        this.e = coVar5;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ dj a() {
        bb a2 = this.a.a();
        return new dj(a2, cm.c(this.b), this.c.a(), cm.c(this.d), this.e.a());
    }
}
