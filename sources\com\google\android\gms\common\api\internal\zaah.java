package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zaah extends zaba {
    private final /* synthetic */ ConnectionResult zaa;
    private final /* synthetic */ zaai zab;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaah(zaai zaai, zaay zaay, ConnectionResult connectionResult) {
        super(zaay);
        this.zab = zaai;
        this.zaa = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zaba
    public final void zaa() {
        this.zab.zaa.zab((zaad) this.zaa);
    }
}
