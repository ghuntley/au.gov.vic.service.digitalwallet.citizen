package com.google.android.play.core.internal;

import java.io.File;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class bc implements av {
    bc() {
    }

    @Override // com.google.android.play.core.internal.av
    public final void a(ClassLoader classLoader, Set<File> set) {
        bb.c(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.av
    public final boolean b(ClassLoader classLoader, File file, File file2, boolean z) {
        return bb.d(classLoader, file, file2, z, bb.f(), "zip", bb.g());
    }
}
