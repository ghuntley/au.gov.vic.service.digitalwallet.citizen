package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.i;

public abstract class ah implements Runnable {
    private final i<?> a;

    ah() {
        this.a = null;
    }

    public ah(i<?> iVar) {
        this.a = iVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public final i<?> b() {
        return this.a;
    }

    public final void run() {
        try {
            a();
        } catch (Exception e) {
            i<?> iVar = this.a;
            if (iVar != null) {
                iVar.d(e);
            }
        }
    }
}
