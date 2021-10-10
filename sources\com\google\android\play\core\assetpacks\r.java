package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.br;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class r implements co<w> {
    private final co<Context> a;
    private final co<ar> b;
    private final co<cz> c;

    public r(co<Context> coVar, co<ar> coVar2, co<cz> coVar3) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ w a() {
        w wVar = (w) (n.b(((s) this.a).a()) == null ? cm.c(this.b).a() : cm.c(this.c).a());
        br.j(wVar);
        return wVar;
    }
}
