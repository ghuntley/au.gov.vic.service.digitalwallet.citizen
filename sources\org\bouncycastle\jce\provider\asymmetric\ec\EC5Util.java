package org.bouncycastle.jce.provider.asymmetric.ec;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class EC5Util {
    public static EllipticCurve convertCurve(ECCurve eCCurve, byte[] bArr) {
        if (eCCurve instanceof ECCurve.Fp) {
            return new EllipticCurve(new ECFieldFp(((ECCurve.Fp) eCCurve).getQ()), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
        }
        ECCurve.F2m f2m = (ECCurve.F2m) eCCurve;
        if (f2m.isTrinomial()) {
            return new EllipticCurve(new ECFieldF2m(f2m.getM(), new int[]{f2m.getK1()}), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
        }
        return new EllipticCurve(new ECFieldF2m(f2m.getM(), new int[]{f2m.getK3(), f2m.getK2(), f2m.getK1()}), eCCurve.getA().toBigInteger(), eCCurve.getB().toBigInteger(), null);
    }

    public static ECCurve convertCurve(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            return new ECCurve.Fp(((ECFieldFp) field).getP(), a, b);
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] convertMidTerms = ECUtil.convertMidTerms(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new ECCurve.F2m(m, convertMidTerms[0], convertMidTerms[1], convertMidTerms[2], a, b);
    }

    public static ECPoint convertPoint(ECParameterSpec eCParameterSpec, java.security.spec.ECPoint eCPoint, boolean z) {
        return convertPoint(convertCurve(eCParameterSpec.getCurve()), eCPoint, z);
    }

    public static ECPoint convertPoint(ECCurve eCCurve, java.security.spec.ECPoint eCPoint, boolean z) {
        return eCCurve.createPoint(eCPoint.getAffineX(), eCPoint.getAffineY(), z);
    }

    public static ECParameterSpec convertSpec(EllipticCurve ellipticCurve, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        return eCParameterSpec instanceof ECNamedCurveParameterSpec ? new ECNamedCurveSpec(((ECNamedCurveParameterSpec) eCParameterSpec).getName(), ellipticCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getX().toBigInteger(), eCParameterSpec.getG().getY().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH()) : new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCParameterSpec.getG().getX().toBigInteger(), eCParameterSpec.getG().getY().toBigInteger()), eCParameterSpec.getN(), eCParameterSpec.getH().intValue());
    }

    public static org.bouncycastle.jce.spec.ECParameterSpec convertSpec(ECParameterSpec eCParameterSpec, boolean z) {
        ECCurve convertCurve = convertCurve(eCParameterSpec.getCurve());
        return new org.bouncycastle.jce.spec.ECParameterSpec(convertCurve, convertPoint(convertCurve, eCParameterSpec.getGenerator(), z), eCParameterSpec.getOrder(), BigInteger.valueOf((long) eCParameterSpec.getCofactor()), eCParameterSpec.getCurve().getSeed());
    }
}
