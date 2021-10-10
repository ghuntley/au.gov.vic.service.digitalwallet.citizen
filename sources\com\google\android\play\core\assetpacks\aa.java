package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;

final class aa extends ah {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    aa(ar arVar, i iVar, String str, i iVar2) {
        super(iVar);
        this.c = arVar;
        this.a = str;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.c.e.c()).l(this.c.c, ar.A(0, this.a), ar.C(), new ak(this.c, this.b, (short[]) null));
        } catch (RemoteException e) {
            ar.a.c(e, "removePack(%s)", this.a);
        }
    }
}
