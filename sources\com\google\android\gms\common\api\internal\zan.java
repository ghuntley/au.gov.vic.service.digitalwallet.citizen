package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zan extends zabl {
    private final /* synthetic */ Dialog zaa;
    private final /* synthetic */ zal zab;

    zan(zal zal, Dialog dialog) {
        this.zab = zal;
        this.zaa = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zabl
    public final void zaa() {
        this.zab.zaa.zab();
        if (this.zaa.isShowing()) {
            this.zaa.dismiss();
        }
    }
}
