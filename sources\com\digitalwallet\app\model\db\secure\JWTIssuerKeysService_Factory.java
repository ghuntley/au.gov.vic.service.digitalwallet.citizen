package com.digitalwallet.app.model.db.secure;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class JWTIssuerKeysService_Factory implements Factory<JWTIssuerKeysService> {
    private final Provider<JWTIssuerKeysDao> jwtIssuerKeysDaoProvider;

    public JWTIssuerKeysService_Factory(Provider<JWTIssuerKeysDao> provider) {
        this.jwtIssuerKeysDaoProvider = provider;
    }

    @Override // javax.inject.Provider
    public JWTIssuerKeysService get() {
        return new JWTIssuerKeysService(this.jwtIssuerKeysDaoProvider.get());
    }

    public static JWTIssuerKeysService_Factory create(Provider<JWTIssuerKeysDao> provider) {
        return new JWTIssuerKeysService_Factory(provider);
    }

    public static JWTIssuerKeysService newInstance(JWTIssuerKeysDao jWTIssuerKeysDao) {
        return new JWTIssuerKeysService(jWTIssuerKeysDao);
    }
}
