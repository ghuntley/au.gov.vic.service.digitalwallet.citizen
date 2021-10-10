package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import java.util.concurrent.Executor;

public final class cq implements co<cp> {
    private final co<bb> a;
    private final co<w> b;
    private final co<bz> c;
    private final co<Executor> d;

    public cq(co<bb> coVar, co<w> coVar2, co<bz> coVar3, co<Executor> coVar4) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ cp a() {
        bb a2 = this.a.a();
        return new cp(a2, cm.c(this.b), this.c.a(), cm.c(this.d));
    }
}
