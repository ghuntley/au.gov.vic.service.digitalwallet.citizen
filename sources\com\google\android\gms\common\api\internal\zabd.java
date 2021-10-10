package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zabd implements Runnable {
    private final /* synthetic */ int zaa;
    private final /* synthetic */ GoogleApiManager.zaa zab;

    zabd(GoogleApiManager.zaa zaa2, int i) {
        this.zab = zaa2;
        this.zaa = i;
    }

    public final void run() {
        this.zab.zaa((GoogleApiManager.zaa) this.zaa);
    }
}
