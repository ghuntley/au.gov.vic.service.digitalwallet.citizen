package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class l extends Enum<l> implements e {
    public static final l a = new l();
    private static final AtomicReference<f> b = new AtomicReference<>(null);

    private l() {
    }

    @Override // com.google.android.play.core.splitinstall.e
    public final f a() {
        return b.get();
    }

    public final void b(f fVar) {
        b.set(fVar);
    }
}
