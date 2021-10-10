package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.d;
import java.util.List;

final class as implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ d b;
    final /* synthetic */ at c;

    as(at atVar, List list, d dVar) {
        this.c = atVar;
        this.a = list;
        this.b = dVar;
    }

    public final void run() {
        try {
            if (this.c.c.b(this.a)) {
                at.c(this.c, this.b);
            } else {
                at.d(this.c, this.a, this.b);
            }
        } catch (Exception e) {
            Log.e("SplitCompat", "Error checking verified files.", e);
            this.b.c(-11);
        }
    }
}
