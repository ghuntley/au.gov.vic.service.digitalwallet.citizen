package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class am extends ak<List<String>> {
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    am(ar arVar, i<List<String>> iVar) {
        super(arVar, iVar);
        this.c = arVar;
    }

    @Override // com.google.android.play.core.assetpacks.ak, com.google.android.play.core.internal.v
    public final void c(List<Bundle> list) {
        super.c(list);
        this.a.e(ar.v(this.c, list));
    }
}
