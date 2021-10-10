package com.nimbusds.jose.crypto.bc;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class BouncyCastleProviderSingleton {
    private static BouncyCastleProvider bouncyCastleProvider;

    private BouncyCastleProviderSingleton() {
    }

    public static BouncyCastleProvider getInstance() {
        BouncyCastleProvider bouncyCastleProvider2 = bouncyCastleProvider;
        if (bouncyCastleProvider2 != null) {
            return bouncyCastleProvider2;
        }
        BouncyCastleProvider bouncyCastleProvider3 = new BouncyCastleProvider();
        bouncyCastleProvider = bouncyCastleProvider3;
        return bouncyCastleProvider3;
    }
}
