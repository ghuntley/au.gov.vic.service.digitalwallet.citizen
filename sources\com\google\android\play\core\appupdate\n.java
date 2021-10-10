package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class n extends m<Void> {
    n(p pVar, i<Void> iVar) {
        super(pVar, new ag("OnCompleteUpdateCallback"), iVar);
    }

    @Override // com.google.android.play.core.internal.q, com.google.android.play.core.appupdate.m
    public final void c(Bundle bundle) throws RemoteException {
        super.c(bundle);
        if (bundle.getInt("error.code", -2) != 0) {
            this.b.d(new InstallException(bundle.getInt("error.code", -2)));
        } else {
            this.b.e(null);
        }
    }
}
