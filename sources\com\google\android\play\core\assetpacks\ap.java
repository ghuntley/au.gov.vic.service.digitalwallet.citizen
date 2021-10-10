package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;

final class ap extends ak<AssetPackStates> {
    private final bz c;
    private final az d;

    ap(ar arVar, i<AssetPackStates> iVar, bz bzVar, az azVar) {
        super(arVar, iVar);
        this.c = bzVar;
        this.d = azVar;
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void f(Bundle bundle, Bundle bundle2) {
        super.f(bundle, bundle2);
        this.a.e(AssetPackStates.d(bundle, this.c, this.d));
    }
}
