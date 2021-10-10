package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.List;

/* access modifiers changed from: package-private */
public final class ah extends com.google.android.play.core.internal.ah {
    final /* synthetic */ List a;
    final /* synthetic */ i b;
    final /* synthetic */ av c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ah(av avVar, i iVar, List list, i iVar2) {
        super(iVar);
        this.c = avVar;
        this.a = list;
        this.b = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.c.a.c().i(this.c.d, av.j(this.a), av.l(), new ao(this.c, this.b));
        } catch (RemoteException e) {
            av.b.c(e, "deferredLanguageInstall(%s)", this.a);
            this.b.d(new RuntimeException(e));
        }
    }
}
