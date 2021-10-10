package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zav implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult zaa;
    private final /* synthetic */ zaw zab;

    zav(zaw zaw, BasePendingResult basePendingResult) {
        this.zab = zaw;
        this.zaa = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
