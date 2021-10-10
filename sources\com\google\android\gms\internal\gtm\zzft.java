package com.google.android.gms.internal.gtm;

import android.os.Handler;
import android.os.Message;

final class zzft implements Handler.Callback {
    private final /* synthetic */ zzfs zzapn;

    zzft(zzfs zzfs) {
        this.zzapn = zzfs;
    }

    public final boolean handleMessage(Message message) {
        if (1 == message.what && zzfo.zzakn.equals(message.obj)) {
            this.zzapn.zzapm.dispatch();
            if (!(this.zzapn.zzapm.isPowerSaveMode())) {
                zzfs zzfs = this.zzapn;
                zzfs.zzh((long) zzfs.zzapm.zzakr);
            }
        }
        return true;
    }
}
