package com.digitalwallet.app.oidc;

import com.digitalwallet.app.oidc.model.BootstrapConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* compiled from: AuthenticationService.kt */
public final /* synthetic */ class AuthenticationService$generateAuthSession$1 extends PropertyReference1Impl {
    public static final KProperty1 INSTANCE = new AuthenticationService$generateAuthSession$1();

    AuthenticationService$generateAuthSession$1() {
        super(BootstrapConfig.class, "authentication", "getAuthentication()Lcom/digitalwallet/app/oidc/model/AuthenticationConfig;", 0);
    }

    @Override // kotlin.reflect.KProperty1, kotlin.jvm.internal.PropertyReference1Impl
    public Object get(Object obj) {
        return ((BootstrapConfig) obj).getAuthentication();
    }
}
