package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.bw;
import com.google.android.play.core.tasks.i;
import java.util.List;

/* access modifiers changed from: package-private */
public class au<T> extends bw {
    final i<T> a;
    final /* synthetic */ av b;

    au(av avVar, i<T> iVar) {
        this.b = avVar;
        this.a = iVar;
    }

    @Override // com.google.android.play.core.internal.bx
    public void b(int i, Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onCancelInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.bx
    public void c(Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onDeferredInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public void d(Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onDeferredLanguageInstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public void e(Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onDeferredLanguageUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public void f(Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onDeferredUninstall", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public void g(int i, Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.bx
    public void h(List<Bundle> list) throws RemoteException {
        this.b.a.b();
        av.b.d("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public void i(int i, Bundle bundle) throws RemoteException {
        this.b.a.b();
        av.b.d("onStartInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.bx
    public final void j(Bundle bundle) throws RemoteException {
        this.b.a.b();
        int i = bundle.getInt("error_code");
        av.b.b("onError(%d)", Integer.valueOf(i));
        this.a.d(new SplitInstallException(i));
    }

    @Override // com.google.android.play.core.internal.bx
    public final void k(int i) throws RemoteException {
        this.b.a.b();
        av.b.d("onCompleteInstall(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.bx
    public final void l() throws RemoteException {
        this.b.a.b();
        av.b.d("onCompleteInstallForAppUpdate", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.bx
    public final void m() throws RemoteException {
        this.b.a.b();
        av.b.d("onGetSplitsForAppUpdate", new Object[0]);
    }
}
