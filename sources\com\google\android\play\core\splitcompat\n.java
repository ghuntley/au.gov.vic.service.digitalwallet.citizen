package com.google.android.play.core.splitcompat;

import android.util.Log;

/* access modifiers changed from: package-private */
public final class n implements Runnable {
    final /* synthetic */ SplitCompat a;

    n(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    public final void run() {
        try {
            this.a.b.a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to cleanup splitcompat storage", e);
        }
    }
}
