package com.google.android.gms.internal.gtm;

import android.os.Handler;
import android.os.Message;

/* access modifiers changed from: package-private */
public final class zzfs implements zzfr {
    private Handler handler;
    final /* synthetic */ zzfo zzapm;

    private zzfs(zzfo zzfo) {
        this.zzapm = zzfo;
        this.handler = new zzdj(zzfo.zzako.getMainLooper(), new zzft(this));
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final void zzjt() {
        this.handler.removeMessages(1, zzfo.zzakn);
        this.handler.sendMessage(obtainMessage());
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final void cancel() {
        this.handler.removeMessages(1, zzfo.zzakn);
    }

    @Override // com.google.android.gms.internal.gtm.zzfr
    public final void zzh(long j) {
        this.handler.removeMessages(1, zzfo.zzakn);
        this.handler.sendMessageDelayed(obtainMessage(), j);
    }

    private final Message obtainMessage() {
        return this.handler.obtainMessage(1, zzfo.zzakn);
    }

    /* synthetic */ zzfs(zzfo zzfo, zzfp zzfp) {
        this(zzfo);
    }
}
