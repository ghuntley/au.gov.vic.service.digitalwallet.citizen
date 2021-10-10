package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.co;

public final class x implements co<w> {
    private final co<av> a;
    private final co<t> b;
    private final co<p> c;
    private final co<ax> d;

    public x(co<av> coVar, co<t> coVar2, co<p> coVar3, co<ax> coVar4) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ w a() {
        return new w(this.a.a(), this.b.a(), this.c.a(), this.d.a());
    }
}
