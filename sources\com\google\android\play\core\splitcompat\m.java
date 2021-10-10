package com.google.android.play.core.splitcompat;

import android.content.Context;
import com.google.android.play.core.splitinstall.t;

/* access modifiers changed from: package-private */
public final class m implements Runnable {
    final /* synthetic */ Context a;

    m(Context context) {
        this.a = context;
    }

    public final void run() {
        t.b(this.a).e(true);
    }
}
