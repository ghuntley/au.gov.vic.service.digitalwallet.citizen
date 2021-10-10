package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* access modifiers changed from: package-private */
public final class ap implements ServiceConnection {
    final /* synthetic */ aq a;

    /* synthetic */ ap(aq aqVar) {
        this.a = aqVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.c.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.a.r(new an(this, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.a.c.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.a.r(new ao(this));
    }
}
