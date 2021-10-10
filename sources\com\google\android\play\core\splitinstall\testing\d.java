package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;

final /* synthetic */ class d implements j {
    private final SplitInstallRequest a;

    d(SplitInstallRequest splitInstallRequest) {
        this.a = splitInstallRequest;
    }

    @Override // com.google.android.play.core.splitinstall.testing.j
    public final SplitInstallSessionState a(SplitInstallSessionState splitInstallSessionState) {
        SplitInstallRequest splitInstallRequest = this.a;
        int i = FakeSplitInstallManager.a;
        if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
            int i2 = 1;
            if (splitInstallSessionState != null) {
                i2 = 1 + splitInstallSessionState.sessionId();
            }
            return SplitInstallSessionState.create(i2, 1, 0, 0, 0, splitInstallRequest.getModuleNames(), new ArrayList());
        }
        throw new SplitInstallException(-1);
    }
}
