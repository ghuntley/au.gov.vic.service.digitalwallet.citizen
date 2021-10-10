package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class bl implements av {
    bl() {
    }

    static void c(ClassLoader classLoader, Set<File> set) {
        bg.c(classLoader, set, new bj());
    }

    static boolean d(ClassLoader classLoader, File file, File file2, boolean z) {
        return bb.d(classLoader, file, file2, z, bg.d(), "path", new bk());
    }

    @Override // com.google.android.play.core.internal.av
    public final void a(ClassLoader classLoader, Set<File> set) {
        c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.av
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return d(classLoader, file, file2, z);
    }
}
