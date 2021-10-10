package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class bh implements av {
    bh() {
    }

    @Override // com.google.android.play.core.internal.av
    public final void a(ClassLoader classLoader, Set<File> set) {
        bg.c(classLoader, set, bg.e());
    }

    @Override // com.google.android.play.core.internal.av
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return bg.f(classLoader, file, file2, z);
    }
}
