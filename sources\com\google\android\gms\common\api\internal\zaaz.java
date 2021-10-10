package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zap;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaaz extends zap {
    private final /* synthetic */ zaax zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaaz(zaax zaax, Looper looper) {
        super(looper);
        this.zaa = zaax;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zaba) message.obj).zaa(this.zaa);
        } else if (i != 2) {
            int i2 = message.what;
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GACStateManager", sb.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
