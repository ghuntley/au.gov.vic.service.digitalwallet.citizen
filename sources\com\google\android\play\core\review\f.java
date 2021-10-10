package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ad;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public class f<T> extends ad {
    final ag a;
    final i<T> b;
    final /* synthetic */ h c;

    f(h hVar, ag agVar, i<T> iVar) {
        this.c = hVar;
        this.a = agVar;
        this.b = iVar;
    }

    @Override // com.google.android.play.core.internal.ae
    public void b(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
