package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import com.google.android.play.core.splitinstall.p;
import java.util.concurrent.Executor;

public final class k implements co<j> {
    private final co<bb> a;
    private final co<w> b;
    private final co<aw> c;
    private final co<p> d;
    private final co<cp> e;
    private final co<bz> f;
    private final co<bn> g;
    private final co<Executor> h;

    public k(co<bb> coVar, co<w> coVar2, co<aw> coVar3, co<p> coVar4, co<cp> coVar5, co<bz> coVar6, co<bn> coVar7, co<Executor> coVar8) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
        this.e = coVar5;
        this.f = coVar6;
        this.g = coVar7;
        this.h = coVar8;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ j a() {
        return new j(this.a.a(), cm.c(this.b), this.c.a(), this.d.a(), this.e.a(), this.f.a(), this.g.a(), cm.c(this.h));
    }
}
