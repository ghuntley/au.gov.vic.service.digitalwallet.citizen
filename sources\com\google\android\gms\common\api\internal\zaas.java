package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.zak;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaas implements zak {
    private final /* synthetic */ zaap zaa;

    zaas(zaap zaap) {
        this.zaa = zaap;
    }

    @Override // com.google.android.gms.common.internal.zak
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.zak
    public final boolean isConnected() {
        return this.zaa.isConnected();
    }
}
