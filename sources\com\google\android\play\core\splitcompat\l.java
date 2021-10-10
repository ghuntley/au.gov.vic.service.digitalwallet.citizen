package com.google.android.play.core.splitcompat;

import com.google.android.play.core.splitinstall.n;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class l implements n {
    final /* synthetic */ SplitCompat a;

    l(SplitCompat splitCompat) {
        this.a = splitCompat;
    }

    @Override // com.google.android.play.core.splitinstall.n
    public final Set<String> a() {
        return this.a.f();
    }
}
