package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.d;
import java.util.List;

/* access modifiers changed from: package-private */
public final class i implements d {
    final /* synthetic */ List a;
    final /* synthetic */ List b;
    final /* synthetic */ long c;
    final /* synthetic */ boolean d;
    final /* synthetic */ List e;
    final /* synthetic */ FakeSplitInstallManager f;

    i(FakeSplitInstallManager fakeSplitInstallManager, List list, List list2, long j, boolean z, List list3) {
        this.f = fakeSplitInstallManager;
        this.a = list;
        this.b = list2;
        this.c = j;
        this.d = z;
        this.e = list3;
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void a() {
        this.f.l.addAll(this.a);
        this.f.m.addAll(this.b);
        this.f.p(5, 0, Long.valueOf(this.c), Long.valueOf(this.c), null, null, null);
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void b() {
        if (!this.d) {
            this.f.t(this.e, this.a, this.b, this.c, true);
        }
    }

    @Override // com.google.android.play.core.splitinstall.d
    public final void c(int i) {
        this.f.u(i);
    }
}
