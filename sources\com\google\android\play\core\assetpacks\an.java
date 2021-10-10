package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class an extends ak<Void> {
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    an(ar arVar, i<Void> iVar) {
        super(arVar, iVar);
        this.c = arVar;
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void d(Bundle bundle, Bundle bundle2) {
        super.d(bundle, bundle2);
        if (!this.c.g.compareAndSet(true, false)) {
            ar.a.e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.j();
        }
    }
}
