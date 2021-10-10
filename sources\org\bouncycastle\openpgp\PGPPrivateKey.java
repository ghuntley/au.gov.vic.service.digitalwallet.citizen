package org.bouncycastle.openpgp;

import java.security.PrivateKey;

public class PGPPrivateKey {
    private long keyID;
    private PrivateKey privateKey;

    public PGPPrivateKey(PrivateKey privateKey2, long j) {
        this.privateKey = privateKey2;
        this.keyID = j;
    }

    public PrivateKey getKey() {
        return this.privateKey;
    }

    public long getKeyID() {
        return this.keyID;
    }
}
