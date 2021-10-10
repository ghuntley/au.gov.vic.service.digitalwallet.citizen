package org.bouncycastle.crypto;

import java.math.BigInteger;

public interface BasicAgreement {
    BigInteger calculateAgreement(CipherParameters cipherParameters);

    void init(CipherParameters cipherParameters);
}
