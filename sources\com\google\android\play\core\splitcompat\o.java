package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class o implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ SplitCompat b;

    o(SplitCompat splitCompat, Set set) {
        this.b = splitCompat;
        this.a = set;
    }

    public final void run() {
        try {
            for (String str : this.a) {
                this.b.b.n(str);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Failed to remove from splitcompat storage split that is already installed", e);
        }
    }
}
