package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.ag;
import com.google.android.play.core.tasks.i;

final class g extends f<ReviewInfo> {
    g(h hVar, i iVar) {
        super(hVar, new ag("OnRequestInstallCallback"), iVar);
    }

    @Override // com.google.android.play.core.internal.ae, com.google.android.play.core.review.f
    public final void b(Bundle bundle) throws RemoteException {
        super.b(bundle);
        this.b.e(ReviewInfo.b((PendingIntent) bundle.get("confirmation_intent")));
    }
}
