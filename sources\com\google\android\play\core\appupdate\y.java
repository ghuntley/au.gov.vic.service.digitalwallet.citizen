package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class y {
    private co<Context> a;
    private co<r> b;
    private co<p> c;
    private co<a> d;
    private co<e> e;
    private co<AppUpdateManager> f;

    /* synthetic */ y(g gVar) {
        i iVar = new i(gVar);
        this.a = iVar;
        co<r> b2 = cm.b(new s(iVar));
        this.b = b2;
        this.c = cm.b(new q(this.a, b2));
        co<a> b3 = cm.b(new b(this.a));
        this.d = b3;
        co<e> b4 = cm.b(new f(this.c, b3, this.a));
        this.e = b4;
        this.f = cm.b(new h(b4));
    }

    public final AppUpdateManager a() {
        return this.f.a();
    }
}
