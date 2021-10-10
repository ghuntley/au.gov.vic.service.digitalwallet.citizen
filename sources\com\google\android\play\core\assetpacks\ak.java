package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.u;
import com.google.android.play.core.tasks.i;
import java.util.List;

/* access modifiers changed from: package-private */
public class ak<T> extends u {
    final i<T> a;
    final /* synthetic */ ar b;

    ak(ar arVar, i<T> iVar) {
        this.b = arVar;
        this.a = iVar;
    }

    ak(ar arVar, i iVar, byte[] bArr) {
        this(arVar, iVar);
    }

    ak(ar arVar, i iVar, char[] cArr) {
        this(arVar, iVar);
    }

    ak(ar arVar, i iVar, int[] iArr) {
        this(arVar, iVar);
    }

    ak(ar arVar, i iVar, short[] sArr) {
        this(arVar, iVar);
    }

    @Override // com.google.android.play.core.internal.v
    public void b(int i, Bundle bundle) {
        ar.o(this.b).b();
        ar.p().d("onStartDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.v
    public void c(List<Bundle> list) {
        ar.o(this.b).b();
        ar.p().d("onGetSessionStates", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.v
    public void d(Bundle bundle, Bundle bundle2) {
        ar.u(this.b).b();
        ar.p().d("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    @Override // com.google.android.play.core.internal.v
    public void e(Bundle bundle, Bundle bundle2) throws RemoteException {
        ar.o(this.b).b();
        ar.p().d("onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.v
    public void f(Bundle bundle, Bundle bundle2) {
        ar.o(this.b).b();
        ar.p().d("onRequestDownloadInfo()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.v
    public void g(Bundle bundle) {
        ar.o(this.b).b();
        int i = bundle.getInt("error_code");
        ar.p().b("onError(%d)", Integer.valueOf(i));
        this.a.d(new AssetPackException(i));
    }

    @Override // com.google.android.play.core.internal.v
    public final void h(int i) {
        ar.o(this.b).b();
        ar.p().d("onCancelDownload(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.v
    public void i() {
        ar.o(this.b).b();
        ar.p().d("onCancelDownloads()", new Object[0]);
    }

    @Override // com.google.android.play.core.internal.v
    public final void j(int i) {
        ar.o(this.b).b();
        ar.p().d("onGetSession(%d)", Integer.valueOf(i));
    }

    @Override // com.google.android.play.core.internal.v
    public void k(Bundle bundle) {
        ar.o(this.b).b();
        ar.p().d("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.v
    public void l(Bundle bundle) {
        ar.o(this.b).b();
        ar.p().d("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.v
    public void m(Bundle bundle) {
        ar.o(this.b).b();
        ar.p().d("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }

    @Override // com.google.android.play.core.internal.v
    public void n() {
        ar.o(this.b).b();
        ar.p().d("onRemoveModule()", new Object[0]);
    }
}
