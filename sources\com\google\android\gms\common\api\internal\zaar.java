package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
final class zaar implements GoogleApiClient.ConnectionCallbacks {
    private final /* synthetic */ AtomicReference zaa;
    private final /* synthetic */ StatusPendingResult zab;
    private final /* synthetic */ zaap zac;

    zaar(zaap zaap, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.zac = zaap;
        this.zaa = atomicReference;
        this.zab = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.zac.zaa((GoogleApiClient) Preconditions.checkNotNull((GoogleApiClient) this.zaa.get()), this.zab, true);
    }
}
