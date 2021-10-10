package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

public final class o {
    private static final AtomicReference<n> a = new AtomicReference<>(null);

    static n a() {
        return a.get();
    }

    public static void b(n nVar) {
        a.compareAndSet(null, nVar);
    }
}
