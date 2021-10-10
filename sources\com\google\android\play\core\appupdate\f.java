package com.google.android.play.core.appupdate;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class f implements co<e> {
    private final co<p> a;
    private final co<a> b;
    private final co<Context> c;

    public f(co<p> coVar, co<a> coVar2, co<Context> coVar3) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ e a() {
        return new e(this.a.a(), this.b.a(), ((i) this.c).a());
    }
}
