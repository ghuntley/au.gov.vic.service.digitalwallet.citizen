package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class i extends ResultReceiver {
    final /* synthetic */ com.google.android.play.core.tasks.i a;
    final /* synthetic */ j b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    i(j jVar, Handler handler, com.google.android.play.core.tasks.i iVar) {
        super(handler);
        this.b = jVar;
        this.a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        if (i == 1) {
            this.a.e(-1);
            this.b.h.a(null);
        } else if (i != 2) {
            this.a.d(new AssetPackException(-100));
        } else {
            this.a.e(0);
        }
    }
}
