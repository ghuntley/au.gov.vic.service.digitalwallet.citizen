package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.List;

/* access modifiers changed from: package-private */
public final /* synthetic */ class b implements j {
    private final Integer a;
    private final int b;
    private final int c;
    private final Long d;
    private final Long e;
    private final List f;
    private final List g;

    b(Integer num, int i, int i2, Long l, Long l2, List list, List list2) {
        this.a = num;
        this.b = i;
        this.c = i2;
        this.d = l;
        this.e = l2;
        this.f = list;
        this.g = list2;
    }

    @Override // com.google.android.play.core.splitinstall.testing.j
    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.g(this.a, this.b, this.c, this.d, this.e, this.f, this.g, splitInstallSessionState);
    }
}
