package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class dp implements co<Cdo> {
    private final co<bb> a;
    private final co<w> b;

    public dp(co<bb> coVar, co<w> coVar2) {
        this.a = coVar;
        this.b = coVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ Cdo a() {
        return new Cdo(this.a.a(), cm.c(this.b));
    }
}
