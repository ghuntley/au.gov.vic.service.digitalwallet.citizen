package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class am extends au<Void> {
    am(av avVar, i<Void> iVar) {
        super(avVar, iVar);
    }

    @Override // com.google.android.play.core.internal.bx, com.google.android.play.core.splitinstall.au
    public final void b(int i, Bundle bundle) throws RemoteException {
        super.b(i, bundle);
        this.a.e(null);
    }
}
