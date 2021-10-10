package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;

final class r implements d {
    final /* synthetic */ SplitInstallSessionState a;
    final /* synthetic */ Intent b;
    final /* synthetic */ Context c;
    final /* synthetic */ t d;

    r(t tVar, SplitInstallSessionState splitInstallSessionState, Intent intent, Context context) {
        this.d = tVar;
        this.a = splitInstallSessionState;
        this.b = intent;
        this.c = context;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void a() {
        t tVar;
        tVar.d.post(new s(this.d, this.a, 5, 0));
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void b() {
        if (!this.b.getBooleanExtra("triggered_from_app_after_verification", false)) {
            this.b.putExtra("triggered_from_app_after_verification", true);
            this.c.sendBroadcast(this.b);
            return;
        }
        this.d.a.b("Splits copied and verified more than once.", new Object[0]);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void c(int i) {
        t tVar;
        tVar.d.post(new s(this.d, this.a, 6, i));
    }
}
