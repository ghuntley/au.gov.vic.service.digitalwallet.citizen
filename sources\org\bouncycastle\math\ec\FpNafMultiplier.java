package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* access modifiers changed from: package-private */
public class FpNafMultiplier implements ECMultiplier {
    FpNafMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        BigInteger multiply = bigInteger.multiply(BigInteger.valueOf(3));
        ECPoint negate = eCPoint.negate();
        ECPoint eCPoint2 = eCPoint;
        for (int bitLength = multiply.bitLength() - 2; bitLength > 0; bitLength--) {
            eCPoint2 = eCPoint2.twice();
            boolean testBit = multiply.testBit(bitLength);
            if (testBit != bigInteger.testBit(bitLength)) {
                eCPoint2 = eCPoint2.add(testBit ? eCPoint : negate);
            }
        }
        return eCPoint2;
    }
}
