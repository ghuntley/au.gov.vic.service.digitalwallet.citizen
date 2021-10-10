package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.i;
import java.util.List;

final class ac extends ah {
    final /* synthetic */ List a;
    final /* synthetic */ i b;
    final /* synthetic */ ar c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ac(ar arVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = arVar;
        this.a = list;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            ((t) this.c.e.c()).d(this.c.c, ar.k(this.a), ar.C(), new ak(this.c, this.b, (byte[]) null));
        } catch (RemoteException e) {
            ar.a.c(e, "cancelDownloads(%s)", this.a);
        }
    }
}
