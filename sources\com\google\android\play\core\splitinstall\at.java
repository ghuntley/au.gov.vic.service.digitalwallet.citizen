package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;

final class at extends au<Integer> {
    at(av avVar, i<Integer> iVar) {
        super(avVar, iVar);
    }

    @Override // com.google.android.play.core.internal.bx, com.google.android.play.core.splitinstall.au
    public final void i(int i, Bundle bundle) throws RemoteException {
        super.i(i, bundle);
        this.a.e(Integer.valueOf(i));
    }
}
