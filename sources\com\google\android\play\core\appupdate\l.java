package com.google.android.play.core.appupdate;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class l extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ String b;
    final /* synthetic */ p c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    l(p pVar, i iVar, i iVar2, String str) {
        super(iVar);
        this.c = pVar;
        this.a = iVar2;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.c.a.c().d(this.c.d, p.j(), new n(this.c, this.a));
        } catch (RemoteException e) {
            p.b.c(e, "completeUpdate(%s)", this.b);
            this.a.d(new RuntimeException(e));
        }
    }
}
