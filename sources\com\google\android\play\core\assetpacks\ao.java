package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class ao extends ak<Void> {
    final int c;
    final String d;
    final int e;
    final /* synthetic */ ar f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ao(ar arVar, i<Void> iVar, int i, String str, int i2) {
        super(arVar, iVar);
        this.f = arVar;
        this.c = i;
        this.d = str;
        this.e = i2;
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void g(Bundle bundle) {
        this.f.e.b();
        int i = bundle.getInt("error_code");
        ar.a.b("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(i));
        int i2 = this.e;
        if (i2 > 0) {
            this.f.y(this.c, this.d, i2 - 1);
        }
    }
}
