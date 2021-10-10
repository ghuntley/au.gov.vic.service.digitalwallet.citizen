package org.bouncycastle.pkcs;

import java.io.IOException;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;

public class EncryptedPrivateKeyInfoHolder {
    private EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;

    public EncryptedPrivateKeyInfoHolder(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo2) {
        this.encryptedPrivateKeyInfo = encryptedPrivateKeyInfo2;
    }

    public byte[] getEncoded() throws IOException {
        return this.encryptedPrivateKeyInfo.getEncoded();
    }

    public EncryptedPrivateKeyInfo toASN1Structure() {
        return this.encryptedPrivateKeyInfo;
    }
}
