package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class k extends ah {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ p c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    k(p pVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = pVar;
        this.a = str;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.c.a.c().c(this.c.d, p.d(this.c, this.a), new o(this.c, this.b, this.a));
        } catch (RemoteException e) {
            p.b.c(e, "requestUpdateInfo(%s)", this.a);
            this.b.d(new RuntimeException(e));
        }
    }
}
