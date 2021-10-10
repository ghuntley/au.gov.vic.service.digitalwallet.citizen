package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.i;
import java.util.ArrayList;
import java.util.List;

final class as extends au<List<SplitInstallSessionState>> {
    as(av avVar, i<List<SplitInstallSessionState>> iVar) {
        super(avVar, iVar);
    }

    @Override // com.google.android.play.core.internal.bx, com.google.android.play.core.splitinstall.au
    public final void h(List<Bundle> list) throws RemoteException {
        super.h(list);
        ArrayList arrayList = new ArrayList(list.size());
        for (Bundle bundle : list) {
            arrayList.add(SplitInstallSessionState.d(bundle));
        }
        this.a.e(arrayList);
    }
}
