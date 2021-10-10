package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* access modifiers changed from: package-private */
public interface ECMultiplier {
    ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo);
}
