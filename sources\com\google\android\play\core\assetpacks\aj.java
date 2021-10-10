package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class aj extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ ar b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(ar arVar, i iVar, i iVar2) {
        super(iVar);
        this.b = arVar;
        this.a = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.b.f.c()).i(this.b.c, ar.C(), new an(this.b, this.a));
        } catch (RemoteException e) {
            ar.a.c(e, "keepAlive", new Object[0]);
        }
    }
}
