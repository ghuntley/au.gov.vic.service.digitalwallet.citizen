package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

class WTauNafMultiplier implements ECMultiplier {
    WTauNafMultiplier() {
    }

    private static ECPoint.F2m multiplyFromWTnaf(ECPoint.F2m f2m, byte[] bArr, PreCompInfo preCompInfo) {
        ECPoint.F2m[] f2mArr;
        byte byteValue = ((ECCurve.F2m) f2m.getCurve()).getA().toBigInteger().byteValue();
        if (preCompInfo == null || !(preCompInfo instanceof WTauNafPreCompInfo)) {
            f2mArr = Tnaf.getPreComp(f2m, byteValue);
            f2m.setPreCompInfo(new WTauNafPreCompInfo(f2mArr));
        } else {
            f2mArr = ((WTauNafPreCompInfo) preCompInfo).getPreComp();
        }
        ECPoint.F2m f2m2 = (ECPoint.F2m) f2m.getCurve().getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2m2 = Tnaf.tau(f2m2);
            if (bArr[length] != 0) {
                f2m2 = bArr[length] > 0 ? f2m2.addSimple(f2mArr[bArr[length]]) : f2m2.subtractSimple(f2mArr[-bArr[length]]);
            }
        }
        return f2m2;
    }

    private ECPoint.F2m multiplyWTnaf(ECPoint.F2m f2m, ZTauElement zTauElement, PreCompInfo preCompInfo, byte b, byte b2) {
        return multiplyFromWTnaf(f2m, Tnaf.tauAdicWNaf(b2, zTauElement, (byte) 4, BigInteger.valueOf(16), Tnaf.getTw(b2, 4), b == 0 ? Tnaf.alpha0 : Tnaf.alpha1), preCompInfo);
    }

    @Override // org.bouncycastle.math.ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        if (eCPoint instanceof ECPoint.F2m) {
            ECPoint.F2m f2m = (ECPoint.F2m) eCPoint;
            ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
            int m = f2m2.getM();
            byte byteValue = f2m2.getA().toBigInteger().byteValue();
            byte mu = f2m2.getMu();
            return multiplyWTnaf(f2m, Tnaf.partModReduction(bigInteger, m, byteValue, f2m2.getSi(), mu, (byte) 10), preCompInfo, byteValue, mu);
        }
        throw new IllegalArgumentException("Only ECPoint.F2m can be used in WTauNafMultiplier");
    }
}
