package com.google.android.play.core.assetpacks;

final /* synthetic */ class cw implements Runnable {
    private final cz a;
    private final int b;
    private final String c;

    cw(cz czVar, int i, String str) {
        this.a = czVar;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        this.a.m(this.b, this.c);
    }
}
