package com.google.android.play.core.splitinstall;

import android.os.RemoteException;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.Collection;

/* access modifiers changed from: package-private */
public final class ae extends ah {
    final /* synthetic */ Collection a;
    final /* synthetic */ Collection b;
    final /* synthetic */ i c;
    final /* synthetic */ av d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ae(av avVar, i iVar, Collection collection, Collection collection2, i iVar2) {
        super(iVar);
        this.d = avVar;
        this.a = collection;
        this.b = collection2;
        this.c = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        ArrayList i = av.i(this.a);
        i.addAll(av.j(this.b));
        try {
            this.d.a.c().c(this.d.d, i, av.l(), new at(this.d, this.c));
        } catch (RemoteException e) {
            av.b.c(e, "startInstall(%s,%s)", this.a, this.b);
            this.c.d(new RuntimeException(e));
        }
    }
}
