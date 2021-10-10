package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import org.bouncycastle.math.ec.ECCurve;

public class ECNamedCurveSpec extends ECParameterSpec {
    private String name;

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger) {
        super(ellipticCurve, eCPoint, bigInteger, 1);
        this.name = str;
    }

    public ECNamedCurveSpec(String str, EllipticCurve ellipticCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(ellipticCurve, eCPoint, bigInteger, bigInteger2.intValue());
        this.name = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger) {
        super(convertCurve(eCCurve, null), convertPoint(eCPoint), bigInteger, 1);
        this.name = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        super(convertCurve(eCCurve, null), convertPoint(eCPoint), bigInteger, bigInteger2.intValue());
        this.name = str;
    }

    public ECNamedCurveSpec(String str, ECCurve eCCurve, org.bouncycastle.math.ec.ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        super(convertCurve(eCCurve, bArr), convertPoint(eCPoint), bigInteger, bigInteger2.intValue());
        this.name = str;
    }

    private static EllipticCurve convertCurve(ECCurve eCCurve, byte[] bArr) {
        if (eCCurve instanceof ECCurve.Fp) {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp) eCCurve).getQ()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), bArr);
        }
        ECCurve.F2m f2m = (ECCurve.F2m) eCCurve;
        if (f2m.isTrinomial()) {
            return new EllipticCurve(new ECFieldF2m(f2m.getM(), new int[]{f2m.getK1()}), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), bArr);
        }
        return new EllipticCurve(new ECFieldF2m(f2m.getM(), new int[]{f2m.getK3(), f2m.getK2(), f2m.getK1()}), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), bArr);
    }

    private static ECPoint convertPoint(org.bouncycastle.math.ec.ECPoint eCPoint) {
        return new ECPoint(eCPoint.getX().toBigInteger(), eCPoint.getY().toBigInteger());
    }

    public String getName() {
        return this.name;
    }
}
