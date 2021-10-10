package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class bu implements co<bt> {
    private final co<bb> a;
    private final co<w> b;
    private final co<aw> c;
    private final co<bz> d;

    public bu(co<bb> coVar, co<w> coVar2, co<aw> coVar3, co<bz> coVar4) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ bt a() {
        return new bt(this.a.a(), cm.c(this.b), cm.c(this.c), this.d.a());
    }
}
