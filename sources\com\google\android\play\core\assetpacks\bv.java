package com.google.android.play.core.assetpacks;

/* access modifiers changed from: package-private */
public final class bv extends RuntimeException {
    final int a;

    bv(String str) {
        super(str);
        this.a = -1;
    }

    bv(String str, int i) {
        super(str);
        this.a = i;
    }

    bv(String str, Exception exc) {
        super(str, exc);
        this.a = -1;
    }

    bv(String str, Exception exc, int i) {
        super(str, exc);
        this.a = i;
    }
}
