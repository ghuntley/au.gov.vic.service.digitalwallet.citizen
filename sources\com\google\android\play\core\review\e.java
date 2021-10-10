package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.ah;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public final class e extends ah {
    final /* synthetic */ i a;
    final /* synthetic */ h b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(h hVar, i iVar, i iVar2) {
        super(iVar);
        this.b = hVar;
        this.a = iVar2;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.internal.ah
    public final void a() {
        try {
            this.b.a.c().c(this.b.c, PlayCoreVersion.b(), new g(this.b, this.a));
        } catch (RemoteException e) {
            h.b.c(e, "error requesting in-app review for %s", this.b.c);
            this.a.d(new RuntimeException(e));
        }
    }
}
