package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ae extends ah {
    final /* synthetic */ List a;
    final /* synthetic */ Map b;
    final /* synthetic */ i c;
    final /* synthetic */ az d;
    final /* synthetic */ ar e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(ar arVar, i iVar, List list, Map map, i iVar2, az azVar) {
        super(iVar);
        this.e = arVar;
        this.a = list;
        this.b = map;
        this.c = iVar2;
        this.d = azVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        ArrayList k = ar.k(this.a);
        try {
            String str = this.e.c;
            Bundle m = ar.m(this.b);
            ar arVar = this.e;
            ((t) this.e.e.c()).k(str, k, m, new ap(arVar, this.c, arVar.d, this.d));
        } catch (RemoteException e2) {
            ar.a.c(e2, "getPackStates(%s)", this.a);
            this.c.d(new RuntimeException(e2));
        }
    }
}
