package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaav extends zabl {
    private WeakReference<zaap> zaa;

    zaav(zaap zaap) {
        this.zaa = new WeakReference<>(zaap);
    }

    @Override // com.google.android.gms.common.api.internal.zabl
    public final void zaa() {
        zaap zaap = this.zaa.get();
        if (zaap != null) {
            zaap.zae();
        }
    }
}
