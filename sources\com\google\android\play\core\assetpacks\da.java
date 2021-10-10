package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import java.io.File;
import java.util.concurrent.Executor;

public final class da implements co<cz> {
    private final co<String> a;
    private final co<aw> b;
    private final co<bz> c;
    private final co<Context> d;
    private final co<dl> e;
    private final co<Executor> f;

    public da(co<String> coVar, co<aw> coVar2, co<bz> coVar3, co<Context> coVar4, co<dl> coVar5, co<Executor> coVar6) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
        this.d = coVar4;
        this.e = coVar5;
        this.f = coVar6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ cz a() {
        String a2 = this.a.a();
        aw a3 = this.b.a();
        bz a4 = this.c.a();
        Context b2 = ((s) this.d).a();
        dl a5 = this.e.a();
        return new cz(a2 != null ? new File(b2.getExternalFilesDir(null), a2) : b2.getExternalFilesDir(null), a3, a4, b2, a5, cm.c(this.f));
    }
}
