package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class ar extends au<SplitInstallSessionState> {
    ar(av avVar, i<SplitInstallSessionState> iVar) {
        super(avVar, iVar);
    }

    @Override // com.google.android.play.core.internal.bx, com.google.android.play.core.splitinstall.au
    public final void g(int i, Bundle bundle) throws RemoteException {
        super.g(i, bundle);
        this.a.e(SplitInstallSessionState.d(bundle));
    }
}
