package com.nimbusds.jose.crypto.impl;

import net.jcip.annotations.Immutable;

@Immutable
public final class AuthenticatedCipherText {
    private final byte[] authenticationTag;
    private final byte[] cipherText;

    public AuthenticatedCipherText(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            this.cipherText = bArr;
            if (bArr2 != null) {
                this.authenticationTag = bArr2;
                return;
            }
            throw new IllegalArgumentException("The authentication tag must not be null");
        }
        throw new IllegalArgumentException("The cipher text must not be null");
    }

    public byte[] getCipherText() {
        return this.cipherText;
    }

    public byte[] getAuthenticationTag() {
        return this.authenticationTag;
    }
}
