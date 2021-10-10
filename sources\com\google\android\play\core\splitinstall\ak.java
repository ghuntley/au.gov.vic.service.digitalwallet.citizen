package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class ak extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ av b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ak(av avVar, i iVar, i iVar2) {
        super(iVar);
        this.b = avVar;
        this.a = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.b.a.c().f(this.b.d, new as(this.b, this.a));
        } catch (RemoteException e) {
            av.b.c(e, "getSessionStates", new Object[0]);
            this.a.d(new RuntimeException(e));
        }
    }
}
