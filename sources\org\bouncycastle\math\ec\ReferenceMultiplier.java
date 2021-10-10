package org.bouncycastle.math.ec;

import java.math.BigInteger;

class ReferenceMultiplier implements ECMultiplier {
    ReferenceMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        int bitLength = bigInteger.bitLength();
        for (int i = 0; i < bitLength; i++) {
            if (bigInteger.testBit(i)) {
                infinity = infinity.add(eCPoint);
            }
            eCPoint = eCPoint.twice();
        }
        return infinity;
    }
}
