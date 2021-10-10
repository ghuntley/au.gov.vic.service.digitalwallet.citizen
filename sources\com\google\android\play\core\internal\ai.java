package com.google.android.play.core.internal;

import android.os.IBinder;

/* access modifiers changed from: package-private */
public final /* synthetic */ class ai implements IBinder.DeathRecipient {
    private final aq a;

    ai(aq aqVar) {
        this.a = aqVar;
    }

    public final void binderDied() {
        this.a.n();
    }
}
