package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import com.google.android.play.core.internal.co;
import com.google.android.play.core.splitinstall.p;
import com.google.android.play.core.splitinstall.z;
import java.io.File;

public final class k implements co<FakeSplitInstallManager> {
    private final co<Context> a;
    private final co<File> b;
    private final co<p> c;

    public k(co<Context> coVar, co<File> coVar2, co<p> coVar3) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ FakeSplitInstallManager a() {
        return new FakeSplitInstallManager(((z) this.a).a(), this.b.a(), this.c.a());
    }
}
