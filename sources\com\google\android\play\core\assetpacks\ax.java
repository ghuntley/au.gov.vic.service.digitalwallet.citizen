package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.a;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import java.util.concurrent.Executor;

public final class ax implements co<aw> {
    private final co<Context> a;
    private final co<cp> b;
    private final co<bw> c;
    private final co<w> d;
    private final co<bz> e;
    private final co<bn> f;
    private final co<a> g;
    private final co<Executor> h;
    private final co<Executor> i;

    public ax(co<Context> coVar, co<cp> coVar2, co<bw> coVar3, co<w> coVar4, co<bz> coVar5, co<bn> coVar6, co<a> coVar7, co<Executor> coVar8, co<Executor> coVar9) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
        this.e = coVar5;
        this.f = coVar6;
        this.g = coVar7;
        this.h = coVar8;
        this.i = coVar9;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ aw a() {
        return new aw(((s) this.a).a(), this.b.a(), this.c.a(), cm.c(this.d), this.e.a(), this.f.a(), this.g.a(), cm.c(this.h), cm.c(this.i));
    }
}
