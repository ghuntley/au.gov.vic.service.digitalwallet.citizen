package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.cm;
import com.google.android.play.core.internal.co;

public final class bl implements co<bk> {
    private final co<w> a;

    public bl(co<w> coVar) {
        this.a = coVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ bk a() {
        return new bk(cm.c(this.a));
    }
}
