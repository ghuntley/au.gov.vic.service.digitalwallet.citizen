package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zaaq implements zaay {
    @NotOnlyInitialized
    private final zaax zaa;

    public zaaq(zaax zaax) {
        this.zaa = zaax;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final boolean zab() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zaa() {
        for (Api.Client client : this.zaa.zaa.values()) {
            client.disconnect();
        }
        this.zaa.zad.zac = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t) {
        this.zaa.zad.zaa.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zaay
    public final void zac() {
        this.zaa.zah();
    }
}
