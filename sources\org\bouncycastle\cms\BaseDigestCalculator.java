package org.bouncycastle.cms;

import org.bouncycastle.util.Arrays;

class BaseDigestCalculator implements IntDigestCalculator {
    private final byte[] digest;

    BaseDigestCalculator(byte[] bArr) {
        this.digest = bArr;
    }

    @Override // org.bouncycastle.cms.IntDigestCalculator
    public byte[] getDigest() {
        return Arrays.clone(this.digest);
    }
}
