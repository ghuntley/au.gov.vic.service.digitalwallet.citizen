package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.splitinstall.testing.k;
import java.io.File;

public final class c implements m {
    private co<Context> a;
    private co<av> b;
    private co<t> c;
    private co<p> d = cm.b(q.b(this.a));
    private co<ax> e;
    private co<w> f;
    private co<File> g;
    private co<FakeSplitInstallManager> h;
    private co<i> i;
    private co<SplitInstallManager> j;

    /* synthetic */ c(y yVar) {
        z zVar = new z(yVar);
        this.a = zVar;
        this.b = cm.b(new aw(zVar));
        this.c = cm.b(new ab(yVar));
        co<ax> b2 = cm.b(new ay(this.a));
        this.e = b2;
        this.f = cm.b(new x(this.b, this.c, this.d, b2));
        co<File> b3 = cm.b(new aa(this.a));
        this.g = b3;
        co<FakeSplitInstallManager> b4 = cm.b(new k(this.a, b3, this.d));
        this.h = b4;
        co<i> b5 = cm.b(new j(this.f, b4, this.g));
        this.i = b5;
        this.j = cm.b(new ac(yVar, b5));
    }

    @Override // com.google.android.play.core.splitinstall.m
    public final SplitInstallManager a() {
        return this.j.a();
    }

    @Override // com.google.android.play.core.splitinstall.m
    public final File b() {
        return this.g.a();
    }
}
