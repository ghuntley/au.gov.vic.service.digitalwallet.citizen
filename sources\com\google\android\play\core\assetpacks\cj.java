package com.google.android.play.core.assetpacks;

/* access modifiers changed from: package-private */
public final /* synthetic */ class cj implements Runnable {
    private final cp a;
    private final cm b;

    cj(cp cpVar, cm cmVar) {
        this.a = cpVar;
        this.b = cmVar;
    }

    public final void run() {
        this.a.g(this.b.a);
    }
}
