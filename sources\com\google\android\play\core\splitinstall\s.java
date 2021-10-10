package com.google.android.play.core.splitinstall;

/* access modifiers changed from: package-private */
public final class s implements Runnable {
    final /* synthetic */ SplitInstallSessionState a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ t d;

    s(t tVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.d = tVar;
        this.a = splitInstallSessionState;
        this.b = i;
        this.c = i2;
    }

    public final void run() {
        t tVar = this.d;
        SplitInstallSessionState splitInstallSessionState = this.a;
        tVar.i(new a(splitInstallSessionState.sessionId(), this.b, this.c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.a(), splitInstallSessionState.b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.c()));
    }
}
