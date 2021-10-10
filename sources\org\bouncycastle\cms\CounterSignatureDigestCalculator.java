package org.bouncycastle.cms;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;

class CounterSignatureDigestCalculator implements IntDigestCalculator {
    private final String alg;
    private final byte[] data;
    private final Provider provider;

    CounterSignatureDigestCalculator(String str, Provider provider2, byte[] bArr) {
        this.alg = str;
        this.provider = provider2;
        this.data = bArr;
    }

    @Override // org.bouncycastle.cms.IntDigestCalculator
    public byte[] getDigest() throws NoSuchAlgorithmException {
        return CMSSignedHelper.INSTANCE.getDigestInstance(this.alg, this.provider).digest(this.data);
    }
}
