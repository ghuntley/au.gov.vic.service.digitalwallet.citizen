package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class aq extends ak<AssetPackStates> {
    private final List<String> c;
    private final bz d;

    aq(ar arVar, i<AssetPackStates> iVar, bz bzVar, List<String> list) {
        super(arVar, iVar);
        this.d = bzVar;
        this.c = list;
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void b(int i, Bundle bundle) {
        super.b(i, bundle);
        this.a.e(AssetPackStates.c(bundle, this.d, this.c));
    }
}
