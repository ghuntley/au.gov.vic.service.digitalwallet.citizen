package org.bouncycastle.crypto;

public class InvalidCipherTextException extends CryptoException {
    public InvalidCipherTextException() {
    }

    public InvalidCipherTextException(String str) {
        super(str);
    }
}
