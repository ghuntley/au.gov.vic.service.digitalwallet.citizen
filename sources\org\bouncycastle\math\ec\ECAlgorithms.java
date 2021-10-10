package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;

public class ECAlgorithms {
    private static ECPoint implShamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        int max = Math.max(bigInteger.bitLength(), bigInteger2.bitLength());
        ECPoint add = eCPoint.add(eCPoint2);
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        for (int i = max - 1; i >= 0; i--) {
            infinity = infinity.twice();
            if (bigInteger.testBit(i)) {
                infinity = bigInteger2.testBit(i) ? infinity.add(add) : infinity.add(eCPoint);
            } else if (bigInteger2.testBit(i)) {
                infinity = infinity.add(eCPoint2);
            }
        }
        return infinity;
    }

    public static ECPoint shamirsTrick(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        if (eCPoint.getCurve().equals(eCPoint2.getCurve())) {
            return implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2);
        }
        throw new IllegalArgumentException("P and Q must be on same curve");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint eCPoint, BigInteger bigInteger, ECPoint eCPoint2, BigInteger bigInteger2) {
        ECCurve curve = eCPoint.getCurve();
        if (curve.equals(eCPoint2.getCurve())) {
            return (!(curve instanceof ECCurve.F2m) || !((ECCurve.F2m) curve).isKoblitz()) ? implShamirsTrick(eCPoint, bigInteger, eCPoint2, bigInteger2) : eCPoint.multiply(bigInteger).add(eCPoint2.multiply(bigInteger2));
        }
        throw new IllegalArgumentException("P and Q must be on same curve");
    }
}
