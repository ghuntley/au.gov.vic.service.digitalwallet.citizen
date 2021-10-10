package com.google.android.play.core.internal;

final class ci extends cd {
    ci() {
    }

    @Override // com.google.android.play.core.internal.cd
    public final void a(Throwable th, Throwable th2) {
        th.addSuppressed(th2);
    }
}
