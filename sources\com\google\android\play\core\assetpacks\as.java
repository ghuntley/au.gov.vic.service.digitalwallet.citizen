package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class as implements co<ar> {
    private final co<Context> a;
    private final co<bz> b;

    public as(co<Context> coVar, co<bz> coVar2) {
        this.a = coVar;
        this.b = coVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ ar a() {
        return new ar(((s) this.a).a(), this.b.a());
    }
}
