package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class al extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ av c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    al(av avVar, i iVar, int i, i iVar2) {
        super(iVar);
        this.c = avVar;
        this.a = i;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.c.a.c().d(this.c.d, this.a, av.l(), new am(this.c, this.b));
        } catch (RemoteException e) {
            av.b.c(e, "cancelInstall(%d)", Integer.valueOf(this.a));
            this.b.d(new RuntimeException(e));
        }
    }
}
