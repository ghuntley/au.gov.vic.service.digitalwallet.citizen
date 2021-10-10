package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

final class ah extends com.google.android.play.core.internal.ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(ar arVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = arVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.c.e.c()).h(this.c.c, ar.B(this.a), ar.C(), new ak(this.c, this.b, (int[]) null));
        } catch (RemoteException e) {
            ar.a.c(e, "notifySessionFailed", new Object[0]);
        }
    }
}
