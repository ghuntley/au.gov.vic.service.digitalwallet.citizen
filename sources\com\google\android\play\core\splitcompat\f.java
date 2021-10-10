package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* access modifiers changed from: package-private */
public final class f implements h {
    final /* synthetic */ Set a;
    final /* synthetic */ q b;
    final /* synthetic */ k c;

    f(k kVar, Set set, q qVar) {
        this.c = kVar;
        this.a = set;
        this.b = qVar;
    }

    @Override // com.google.android.play.core.splitcompat.h
    public final void a(ZipFile zipFile, Set<j> set) throws IOException {
        this.a.addAll(k.d(this.c, set, this.b, zipFile));
    }
}
