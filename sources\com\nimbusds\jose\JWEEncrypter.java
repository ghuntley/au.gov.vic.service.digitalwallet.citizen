package com.nimbusds.jose;

public interface JWEEncrypter extends JWEProvider {
    JWECryptoParts encrypt(JWEHeader jWEHeader, byte[] bArr) throws JOSEException;
}
