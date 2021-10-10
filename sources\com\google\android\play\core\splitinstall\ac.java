package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.br;
import com.google.android.play.core.internal.co;

public final class ac implements co<SplitInstallManager> {
    private final y a;
    private final co<i> b;

    public ac(y yVar, co<i> coVar) {
        this.a = yVar;
        this.b = coVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ SplitInstallManager a() {
        i a2 = this.b.a();
        br.j(a2);
        return a2;
    }
}
