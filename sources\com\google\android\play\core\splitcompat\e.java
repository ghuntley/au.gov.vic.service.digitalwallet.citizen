package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* access modifiers changed from: package-private */
public final class e implements h {
    final /* synthetic */ q a;
    final /* synthetic */ Set b;
    final /* synthetic */ AtomicBoolean c;
    final /* synthetic */ k d;

    e(k kVar, q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.d = kVar;
        this.a = qVar;
        this.b = set;
        this.c = atomicBoolean;
    }

    @Override // com.google.android.play.core.splitcompat.h
    public final void a(ZipFile zipFile, Set<j> set) throws IOException {
        this.d.f(this.a, set, new d(this));
    }
}
