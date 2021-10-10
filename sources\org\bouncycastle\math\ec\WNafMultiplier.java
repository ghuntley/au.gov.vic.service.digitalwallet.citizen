package org.bouncycastle.math.ec;

import java.math.BigInteger;

class WNafMultiplier implements ECMultiplier {
    WNafMultiplier() {
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        byte b;
        int i;
        int i2;
        WNafPreCompInfo wNafPreCompInfo = (preCompInfo == null || !(preCompInfo instanceof WNafPreCompInfo)) ? new WNafPreCompInfo() : (WNafPreCompInfo) preCompInfo;
        int bitLength = bigInteger.bitLength();
        int i3 = 8;
        if (bitLength < 13) {
            b = 2;
            i3 = 1;
        } else if (bitLength < 41) {
            b = 3;
            i3 = 2;
        } else if (bitLength < 121) {
            b = 4;
            i3 = 4;
        } else if (bitLength < 337) {
            b = 5;
        } else {
            if (bitLength < 897) {
                i3 = 6;
                i2 = 16;
            } else if (bitLength < 2305) {
                i3 = 7;
                i2 = 32;
            } else {
                i2 = 127;
            }
            i3 = i2;
            b = i3 == 1 ? 1 : 0;
        }
        ECPoint[] preComp = wNafPreCompInfo.getPreComp();
        ECPoint twiceP = wNafPreCompInfo.getTwiceP();
        if (preComp == null) {
            preComp = new ECPoint[]{eCPoint};
            i = 1;
        } else {
            i = preComp.length;
        }
        if (twiceP == null) {
            twiceP = eCPoint.twice();
        }
        if (i < i3) {
            ECPoint[] eCPointArr = new ECPoint[i3];
            System.arraycopy(preComp, 0, eCPointArr, 0, i);
            while (i < i3) {
                eCPointArr[i] = twiceP.add(eCPointArr[i - 1]);
                i++;
            }
            preComp = eCPointArr;
        }
        byte[] windowNaf = windowNaf(b, bigInteger);
        int length = windowNaf.length;
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        for (int i4 = length - 1; i4 >= 0; i4--) {
            infinity = infinity.twice();
            if (windowNaf[i4] != 0) {
                infinity = windowNaf[i4] > 0 ? infinity.add(preComp[(windowNaf[i4] - 1) / 2]) : infinity.subtract(preComp[((-windowNaf[i4]) - 1) / 2]);
            }
        }
        wNafPreCompInfo.setPreComp(preComp);
        wNafPreCompInfo.setTwiceP(twiceP);
        eCPoint.setPreCompInfo(wNafPreCompInfo);
        return infinity;
    }

    public byte[] windowNaf(byte b, BigInteger bigInteger) {
        byte[] bArr = new byte[(bigInteger.bitLength() + 1)];
        short s = (short) (1 << b);
        BigInteger valueOf = BigInteger.valueOf((long) s);
        int i = 0;
        int i2 = 0;
        while (bigInteger.signum() > 0) {
            if (bigInteger.testBit(0)) {
                BigInteger mod = bigInteger.mod(valueOf);
                boolean testBit = mod.testBit(b - 1);
                int intValue = mod.intValue();
                if (testBit) {
                    bArr[i2] = (byte) (intValue - s);
                } else {
                    bArr[i2] = (byte) intValue;
                }
                bigInteger = bigInteger.subtract(BigInteger.valueOf((long) bArr[i2]));
                i = i2;
            } else {
                bArr[i2] = 0;
            }
            bigInteger = bigInteger.shiftRight(1);
            i2++;
        }
        int i3 = i + 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }
}
