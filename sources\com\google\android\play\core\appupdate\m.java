package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.internal.p;
import com.google.android.play.core.tasks.i;

/* access modifiers changed from: package-private */
public class m<T> extends p {
    final ag a;
    final i<T> b;
    final /* synthetic */ p c;

    m(p pVar, ag agVar, i<T> iVar) {
        this.c = pVar;
        this.a = agVar;
        this.b = iVar;
    }

    @Override // com.google.android.play.core.internal.q
    public void b(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onRequestInfo", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.q
    public void c(Bundle bundle) throws RemoteException {
        this.c.a.b();
        this.a.d("onCompleteUpdate", new Object[0]);
    }
}
