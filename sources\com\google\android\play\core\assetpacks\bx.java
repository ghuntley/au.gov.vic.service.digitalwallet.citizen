package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class bx implements co<bw> {
    private final co<cp> a;
    private final co<w> b;
    private final co<bt> c;
    private final co<dv> d;
    private final co<df> e;
    private final co<dj> f;
    private final co<Cdo> g;
    private final co<cs> h;

    public bx(co<cp> coVar, co<w> coVar2, co<bt> coVar3, co<dv> coVar4, co<df> coVar5, co<dj> coVar6, co<Cdo> coVar7, co<cs> coVar8) {
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
    public final /* bridge */ /* synthetic */ bw a() {
        return new bw(this.a.a(), cm.c(this.b), this.c.a(), this.d.a(), this.e.a(), this.f.a(), this.g.a(), this.h.a());
    }
}
