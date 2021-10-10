package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class q implements co<p> {
    private final co<Context> a;
    private final co<r> b;

    public q(co<Context> coVar, co<r> coVar2) {
        this.a = coVar;
        this.b = coVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ p a() {
        return new p(((i) this.a).a(), this.b.a());
    }
}
