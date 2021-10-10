package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.listener.b;

public final class t extends b<SplitInstallSessionState> {
    private static t c;
    private final Handler d = new Handler(Looper.getMainLooper());
    private final e e;

    public t(Context context, e eVar) {
        super(new ag("SplitInstallListenerRegistry"), new IntentFilter("com.google.android.play.core.splitinstall.receiver.SplitInstallUpdateIntentService"), context);
        this.e = eVar;
    }

    public static synchronized t b(Context context) {
        t tVar;
        synchronized (t.class) {
            if (c == null) {
                c = new t(context, l.a);
            }
            tVar = c;
        }
        return tVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.play.core.listener.b
    public final void a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("session_state");
        if (bundleExtra != null) {
            SplitInstallSessionState d2 = SplitInstallSessionState.d(bundleExtra);
            this.a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", d2);
            f a = this.e.a();
            if (d2.status() != 3 || a == null) {
                i(d2);
            } else {
                a.a(d2.c(), new r(this, d2, intent, context));
            }
        }
    }
}
