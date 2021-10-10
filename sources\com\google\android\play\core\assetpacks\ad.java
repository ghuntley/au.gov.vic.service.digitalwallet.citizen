package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.Map;

final class ad extends ah {
    final /* synthetic */ Map a;
    final /* synthetic */ i b;
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ad(ar arVar, i iVar, Map map, i iVar2) {
        super(iVar);
        this.c = arVar;
        this.a = map;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.c.e.c()).e(this.c.c, ar.m(this.a), new am(this.c, this.b));
        } catch (RemoteException e) {
            ar.a.c(e, "syncPacks", new Object[0]);
            this.b.d(new RuntimeException(e));
        }
    }
}
