package com.digitalwallet.app.holdings;

import com.digitalwallet.app.oidc.model.BootstrapConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: HoldingsApiService.kt */
public final /* synthetic */ class HoldingsApiService$fetchSecureHoldings$3 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new HoldingsApiService$fetchSecureHoldings$3();

    HoldingsApiService$fetchSecureHoldings$3() {
        super(BootstrapConfig.class, "apiConfig", "getApiConfig()Lcom/digitalwallet/app/oidc/model/ApiConfig;", 0);
    }

    @Override // kotlin.reflect.KProperty1, kotlin.jvm.internal.PropertyReference1Impl
    public Object get(Object obj) {
        return ((BootstrapConfig) obj).getApiConfig();
    }
}
