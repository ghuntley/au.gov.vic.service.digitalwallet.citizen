package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.common.a;
import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.cl;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.splitinstall.q;
import java.util.concurrent.Executor;

public final class br implements a {
    private final n a;
    private co<Context> b;
    private co<dl> c;
    private co<bb> d;
    private co<bz> e;
    private co<ar> f;
    private co<String> g = cm.b(new t(this.b));
    private co<w> h = new cl();
    private co<Executor> i;
    private co<cp> j;
    private co<aw> k;
    private co<bt> l;
    private co<dv> m;
    private co<df> n;
    private co<dj> o;
    private co<Cdo> p;
    private co<bk> q;
    private co<cs> r;
    private co<bw> s;
    private co<bn> t;
    private co<a> u;
    private co<Executor> v;
    private co<cz> w;
    private co<p> x;
    private co<j> y;
    private co<AssetPackManager> z;

    /* synthetic */ br(n nVar) {
        this.a = nVar;
        s sVar = new s(nVar);
        this.b = sVar;
        co<dl> b2 = cm.b(new dm(sVar));
        this.c = b2;
        this.d = cm.b(new bc(this.b, b2));
        co<bz> b3 = cm.b(ca.a());
        this.e = b3;
        this.f = cm.b(new as(this.b, b3));
        co<Executor> b4 = cm.b(o.a());
        this.i = b4;
        this.j = cm.b(new cq(this.d, this.h, this.e, b4));
        cl clVar = new cl();
        this.k = clVar;
        this.l = cm.b(new bu(this.d, this.h, clVar, this.e));
        this.m = cm.b(new dw(this.d));
        this.n = cm.b(new dg(this.d));
        this.o = cm.b(new dk(this.d, this.h, this.j, this.i, this.e));
        this.p = cm.b(new dp(this.d, this.h));
        co<bk> b5 = cm.b(new bl(this.h));
        this.q = b5;
        co<cs> b6 = cm.b(new ct(this.j, this.d, b5));
        this.r = b6;
        this.s = cm.b(new bx(this.j, this.h, this.l, this.m, this.n, this.o, this.p, b6));
        this.t = cm.b(bo.a);
        this.u = cm.b(c.b());
        co<Executor> b7 = cm.b(u.a());
        this.v = b7;
        cl.b(this.k, cm.b(new ax(this.b, this.j, this.s, this.h, this.e, this.t, this.u, this.i, b7)));
        co<cz> b8 = cm.b(new da(this.g, this.k, this.e, this.b, this.c, this.i));
        this.w = b8;
        cl.b(this.h, cm.b(new r(this.b, this.f, b8)));
        co<p> b9 = cm.b(q.b(this.b));
        this.x = b9;
        co<j> b10 = cm.b(new k(this.d, this.h, this.k, b9, this.j, this.e, this.t, this.i));
        this.y = b10;
        this.z = cm.b(new q(b10, this.b));
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final AssetPackManager a() {
        return this.z.a();
    }

    @Override // com.google.android.play.core.assetpacks.a
    public final void b(AssetPackExtractionService assetPackExtractionService) {
        assetPackExtractionService.a = s.c(this.a);
        assetPackExtractionService.b = this.y.a();
        assetPackExtractionService.c = this.d.a();
    }
}
