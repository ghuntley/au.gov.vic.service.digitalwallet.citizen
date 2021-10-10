package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.co;
import java.io.File;

public final class aa implements co<File> {
    private final co<Context> a;

    public aa(co<Context> coVar) {
        this.a = coVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ File a() {
        return y.c(((z) this.a).a());
    }
}
