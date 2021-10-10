package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class bc implements co<bb> {
    private final co<Context> a;
    private final co<dl> b;

    public bc(co<Context> coVar, co<dl> coVar2) {
        this.a = coVar;
        this.b = coVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ bb a() {
        return new bb(((s) this.a).a(), this.b.a());
    }
}
