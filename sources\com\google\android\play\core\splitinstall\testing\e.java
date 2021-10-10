package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallSessionState;

final /* synthetic */ class e implements j {
    private final int a;

    e(int i) {
        this.a = i;
    }

    @Override // com.google.android.play.core.splitinstall.testing.j
    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        return FakeSplitInstallManager.e(this.a, splitInstallSessionState);
    }
}
