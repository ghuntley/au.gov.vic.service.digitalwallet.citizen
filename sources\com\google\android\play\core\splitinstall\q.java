package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class q implements co<p> {
    private final co<Context> a;

    public q(co<Context> coVar) {
        this.a = coVar;
    }

    public static q b(co<Context> coVar) {
        return new q(coVar);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ p a() {
        return new p(this.a.a());
    }
}
