package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.co;

public final class ct implements co<cs> {
    private final co<cp> a;
    private final co<bb> b;
    private final co<bk> c;

    public ct(co<cp> coVar, co<bb> coVar2, co<bk> coVar3) {
        this.a = coVar;
        this.b = coVar2;
        this.c = coVar3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ cs a() {
        return new cs(this.a.a(), this.b.a(), this.c.a());
    }
}
