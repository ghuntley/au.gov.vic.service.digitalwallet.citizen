package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class aj extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ av c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aj(av avVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = avVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.c.a.c().e(this.c.d, this.a, new ar(this.c, this.b));
        } catch (RemoteException e) {
            av.b.c(e, "getSessionState(%d)", Integer.valueOf(this.a));
            this.b.d(new RuntimeException(e));
        }
    }
}
