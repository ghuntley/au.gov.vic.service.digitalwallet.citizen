package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import java.io.File;

public final class j implements co<i> {
    private final co<w> a;
    private final co<FakeSplitInstallManager> b;
    private final co<File> c;

    public j(co<w> coVar, co<FakeSplitInstallManager> coVar2, co<File> coVar3) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ i a() {
        return new i(cm.c(this.a), cm.c(this.b), cm.c(this.c));
    }
}
