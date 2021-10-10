package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.i;

final class b extends ResultReceiver {
    final /* synthetic */ i a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    b(Handler handler, i iVar) {
        super(handler);
        this.a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.a.e(null);
    }
}
