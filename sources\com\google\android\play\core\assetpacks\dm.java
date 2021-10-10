package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.co;

public final class dm implements co<dl> {
    private final co<Context> a;

    public dm(co<Context> coVar) {
        this.a = coVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ dl a() {
        return new dl(((s) this.a).a());
    }
}
