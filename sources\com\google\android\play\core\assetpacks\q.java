package com.google.android.play.core.assetpacks;

import android.content.ComponentName;
import android.content.Context;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.br;
import com.google.android.play.core.internal.co;

public final class q implements co<AssetPackManager> {
    private final co<j> a;
    private final co<Context> b;

    public q(co<j> coVar, co<Context> coVar2) {
        this.a = coVar;
        this.b = coVar2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.play.core.internal.co
    public final /* bridge */ /* synthetic */ AssetPackManager a() {
        j a2 = this.a.a();
        Context b2 = ((s) this.b).a();
        j jVar = a2;
        br.g(b2.getPackageManager(), new ComponentName(b2.getPackageName(), "com.google.android.play.core.assetpacks.AssetPackExtractionService"), 4);
        PlayCoreDialogWrapperActivity.a(b2);
        br.j(jVar);
        return jVar;
    }
}
