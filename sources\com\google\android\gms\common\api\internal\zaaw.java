package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaaw extends zap {
    private final /* synthetic */ zaap zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaaw(zaap zaap, Looper looper) {
        super(looper);
        this.zaa = zaap;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            this.zaa.zaf();
        } else if (i != 2) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            this.zaa.zae();
        }
    }
}
