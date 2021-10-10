package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class ag extends ah {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;
    final /* synthetic */ int d;
    final /* synthetic */ ar e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ag(ar arVar, i iVar, int i, String str, i iVar2, int i2) {
        super(iVar);
        this.e = arVar;
        this.a = i;
        this.b = str;
        this.c = iVar2;
        this.d = i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.e.e.c()).g(this.e.c, ar.A(this.a, this.b), ar.C(), new ao(this.e, this.c, this.a, this.b, this.d));
        } catch (RemoteException e2) {
            ar.a.c(e2, "notifyModuleCompleted", new Object[0]);
        }
    }
}
