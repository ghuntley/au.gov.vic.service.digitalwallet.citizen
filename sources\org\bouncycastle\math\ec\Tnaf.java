package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

/* access modifiers changed from: package-private */
public class Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0;
    public static final byte[][] alpha0Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
    public static final ZTauElement[] alpha1;
    public static final byte[][] alpha1Tnaf = {null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};

    static {
        BigInteger negate = ECConstants.ONE.negate();
        MINUS_ONE = negate;
        BigInteger negate2 = ECConstants.THREE.negate();
        MINUS_THREE = negate2;
        alpha0 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(ECConstants.ONE, negate), null};
        alpha1 = new ZTauElement[]{null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(negate2, ECConstants.ONE), null, new ZTauElement(negate, ECConstants.ONE), null, new ZTauElement(ECConstants.ONE, ECConstants.ONE), null};
    }

    Tnaf() {
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        int i3 = ((i + 5) / 2) + i2;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i4 = i3 - i2;
        BigInteger shiftRight = add.shiftRight(i4);
        if (add.testBit(i4 - 1)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(shiftRight, i2);
    }

    public static BigInteger[] getLucas(byte b, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (b == 1 || b == -1) {
            if (z) {
                bigInteger = ECConstants.TWO;
                bigInteger2 = BigInteger.valueOf((long) b);
            } else {
                bigInteger = ECConstants.ZERO;
                bigInteger2 = ECConstants.ONE;
            }
            int i2 = 1;
            while (i2 < i) {
                i2++;
                bigInteger2 = (b == 1 ? bigInteger2 : bigInteger2.negate()).subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger2;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(ECCurve.F2m f2m) {
        BigInteger bigInteger = f2m.getA().toBigInteger();
        if (bigInteger.equals(ECConstants.ZERO)) {
            return -1;
        }
        if (bigInteger.equals(ECConstants.ONE)) {
            return 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static ECPoint.F2m[] getPreComp(ECPoint.F2m f2m, byte b) {
        ECPoint.F2m[] f2mArr = new ECPoint.F2m[16];
        f2mArr[1] = f2m;
        byte[][] bArr = b == 0 ? alpha0Tnaf : alpha1Tnaf;
        int length = bArr.length;
        for (int i = 3; i < length; i += 2) {
            f2mArr[i] = multiplyFromTnaf(f2m, bArr[i]);
        }
        return f2mArr;
    }

    public static BigInteger[] getSi(ECCurve.F2m f2m) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (f2m.isKoblitz()) {
            int m = f2m.getM();
            int intValue = f2m.getA().toBigInteger().intValue();
            byte mu = f2m.getMu();
            int intValue2 = f2m.getH().intValue();
            BigInteger[] lucas = getLucas(mu, (m + 3) - intValue, false);
            if (mu == 1) {
                bigInteger = ECConstants.ONE.subtract(lucas[1]);
                bigInteger2 = ECConstants.ONE.subtract(lucas[0]);
            } else if (mu == -1) {
                bigInteger = ECConstants.ONE.add(lucas[1]);
                bigInteger2 = ECConstants.ONE.add(lucas[0]);
            } else {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            BigInteger[] bigIntegerArr = new BigInteger[2];
            if (intValue2 == 2) {
                bigIntegerArr[0] = bigInteger.shiftRight(1);
                bigIntegerArr[1] = bigInteger2.shiftRight(1).negate();
            } else if (intValue2 == 4) {
                bigIntegerArr[0] = bigInteger.shiftRight(2);
                bigIntegerArr[1] = bigInteger2.shiftRight(2).negate();
            } else {
                throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
            }
            return bigIntegerArr;
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte b, int i) {
        if (i == 4) {
            return b == 1 ? BigInteger.valueOf(6) : BigInteger.valueOf(10);
        }
        BigInteger[] lucas = getLucas(b, i, false);
        BigInteger bit = ECConstants.ZERO.setBit(i);
        return ECConstants.TWO.multiply(lucas[0]).multiply(lucas[1].modInverse(bit)).mod(bit);
    }

    public static ECPoint.F2m multiplyFromTnaf(ECPoint.F2m f2m, byte[] bArr) {
        ECPoint.F2m f2m2 = (ECPoint.F2m) ((ECCurve.F2m) f2m.getCurve()).getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2m2 = tau(f2m2);
            if (bArr[length] == 1) {
                f2m2 = f2m2.addSimple(f2m);
            } else if (bArr[length] == -1) {
                f2m2 = f2m2.subtractSimple(f2m);
            }
        }
        return f2m2;
    }

    public static ECPoint.F2m multiplyRTnaf(ECPoint.F2m f2m, BigInteger bigInteger) {
        ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
        return multiplyTnaf(f2m, partModReduction(bigInteger, f2m2.getM(), (byte) f2m2.getA().toBigInteger().intValue(), f2m2.getSi(), f2m2.getMu(), (byte) 10));
    }

    public static ECPoint.F2m multiplyTnaf(ECPoint.F2m f2m, ZTauElement zTauElement) {
        return multiplyFromTnaf(f2m, tauAdicNaf(((ECCurve.F2m) f2m.getCurve()).getMu(), zTauElement));
    }

    public static BigInteger norm(byte b, ZTauElement zTauElement) {
        BigInteger subtract;
        BigInteger multiply = zTauElement.u.multiply(zTauElement.u);
        BigInteger multiply2 = zTauElement.u.multiply(zTauElement.v);
        BigInteger shiftLeft = zTauElement.v.multiply(zTauElement.v).shiftLeft(1);
        if (b == 1) {
            subtract = multiply.add(multiply2);
        } else if (b == -1) {
            subtract = multiply.subtract(multiply2);
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        return subtract.add(shiftLeft);
    }

    public static SimpleBigDecimal norm(byte b, SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2) {
        SimpleBigDecimal subtract;
        SimpleBigDecimal multiply = simpleBigDecimal.multiply(simpleBigDecimal);
        SimpleBigDecimal multiply2 = simpleBigDecimal.multiply(simpleBigDecimal2);
        SimpleBigDecimal shiftLeft = simpleBigDecimal2.multiply(simpleBigDecimal2).shiftLeft(1);
        if (b == 1) {
            subtract = multiply.add(multiply2);
        } else if (b == -1) {
            subtract = multiply.subtract(multiply2);
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        return subtract.add(shiftLeft);
    }

    public static ZTauElement partModReduction(BigInteger bigInteger, int i, byte b, BigInteger[] bigIntegerArr, byte b2, byte b3) {
        BigInteger add = b2 == 1 ? bigIntegerArr[0].add(bigIntegerArr[1]) : bigIntegerArr[0].subtract(bigIntegerArr[1]);
        BigInteger bigInteger2 = getLucas(b2, i, true)[1];
        ZTauElement round = round(approximateDivisionByN(bigInteger, bigIntegerArr[0], bigInteger2, b, i, b3), approximateDivisionByN(bigInteger, bigIntegerArr[1], bigInteger2, b, i, b3), b2);
        return new ZTauElement(bigInteger.subtract(add.multiply(round.u)).subtract(BigInteger.valueOf(2).multiply(bigIntegerArr[1]).multiply(round.v)), bigIntegerArr[1].multiply(round.u).subtract(bigIntegerArr[0].multiply(round.v)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (r5.compareTo(org.bouncycastle.math.ec.Tnaf.MINUS_ONE) < 0) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (r5.compareTo(org.bouncycastle.math.ec.ECConstants.ONE) >= 0) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (r7.compareTo(org.bouncycastle.math.ec.Tnaf.MINUS_TWO) < 0) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    public static ZTauElement round(SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2, byte b) {
        SimpleBigDecimal simpleBigDecimal3;
        SimpleBigDecimal simpleBigDecimal4;
        if (simpleBigDecimal2.getScale() == simpleBigDecimal.getScale()) {
            int i = -1;
            int i2 = 1;
            if (b == 1 || b == -1) {
                BigInteger round = simpleBigDecimal.round();
                BigInteger round2 = simpleBigDecimal2.round();
                SimpleBigDecimal subtract = simpleBigDecimal.subtract(round);
                SimpleBigDecimal subtract2 = simpleBigDecimal2.subtract(round2);
                SimpleBigDecimal add = subtract.add(subtract);
                SimpleBigDecimal add2 = b == 1 ? add.add(subtract2) : add.subtract(subtract2);
                SimpleBigDecimal add3 = subtract2.add(subtract2).add(subtract2);
                SimpleBigDecimal add4 = add3.add(subtract2);
                if (b == 1) {
                    simpleBigDecimal4 = subtract.subtract(add3);
                    simpleBigDecimal3 = subtract.add(add4);
                } else {
                    simpleBigDecimal4 = subtract.add(add3);
                    simpleBigDecimal3 = subtract.subtract(add4);
                }
                byte b2 = 0;
                if (add2.compareTo(ECConstants.ONE) < 0) {
                    if (simpleBigDecimal3.compareTo(ECConstants.TWO) < 0) {
                        i2 = 0;
                        if (add2.compareTo(MINUS_ONE) >= 0) {
                        }
                        b2 = (byte) (-b);
                        i = i2;
                        return new ZTauElement(round.add(BigInteger.valueOf((long) i)), round2.add(BigInteger.valueOf((long) b2)));
                    }
                }
                i2 = 0;
                b2 = b;
                if (add2.compareTo(MINUS_ONE) >= 0) {
                }
                b2 = (byte) (-b);
                i = i2;
                return new ZTauElement(round.add(BigInteger.valueOf((long) i)), round2.add(BigInteger.valueOf((long) b2)));
            }
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
    }

    public static ECPoint.F2m tau(ECPoint.F2m f2m) {
        if (f2m.isInfinity()) {
            return f2m;
        }
        return new ECPoint.F2m(f2m.getCurve(), f2m.getX().square(), f2m.getY().square(), f2m.isCompressed());
    }

    public static byte[] tauAdicNaf(byte b, ZTauElement zTauElement) {
        if (b == 1 || b == -1) {
            int bitLength = norm(b, zTauElement).bitLength();
            byte[] bArr = new byte[(bitLength > 30 ? bitLength + 4 : 34)];
            BigInteger bigInteger = zTauElement.u;
            BigInteger bigInteger2 = zTauElement.v;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!bigInteger.equals(ECConstants.ZERO) || !bigInteger2.equals(ECConstants.ZERO)) {
                    if (bigInteger.testBit(0)) {
                        bArr[i2] = (byte) ECConstants.TWO.subtract(bigInteger.subtract(bigInteger2.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
                        bigInteger = bArr[i2] == 1 ? bigInteger.clearBit(0) : bigInteger.add(ECConstants.ONE);
                        i = i2;
                    } else {
                        bArr[i2] = 0;
                    }
                    BigInteger shiftRight = bigInteger.shiftRight(1);
                    BigInteger add = b == 1 ? bigInteger2.add(shiftRight) : bigInteger2.subtract(shiftRight);
                    BigInteger negate = bigInteger.shiftRight(1).negate();
                    i2++;
                    bigInteger = add;
                    bigInteger2 = negate;
                } else {
                    int i3 = i + 1;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, 0, bArr2, 0, i3);
                    return bArr2;
                }
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }

    public static byte[] tauAdicWNaf(byte b, ZTauElement zTauElement, byte b2, BigInteger bigInteger, BigInteger bigInteger2, ZTauElement[] zTauElementArr) {
        boolean z;
        if (b == 1 || b == -1) {
            int bitLength = norm(b, zTauElement).bitLength();
            byte[] bArr = new byte[(bitLength > 30 ? bitLength + 4 + b2 : b2 + 34)];
            BigInteger shiftRight = bigInteger.shiftRight(1);
            BigInteger bigInteger3 = zTauElement.u;
            BigInteger bigInteger4 = zTauElement.v;
            int i = 0;
            while (true) {
                if (bigInteger3.equals(ECConstants.ZERO) && bigInteger4.equals(ECConstants.ZERO)) {
                    return bArr;
                }
                if (bigInteger3.testBit(0)) {
                    BigInteger mod = bigInteger3.add(bigInteger4.multiply(bigInteger2)).mod(bigInteger);
                    if (mod.compareTo(shiftRight) >= 0) {
                        mod = mod.subtract(bigInteger);
                    }
                    byte intValue = (byte) mod.intValue();
                    bArr[i] = intValue;
                    if (intValue < 0) {
                        intValue = (byte) (-intValue);
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        bigInteger3 = bigInteger3.subtract(zTauElementArr[intValue].u);
                        bigInteger4 = bigInteger4.subtract(zTauElementArr[intValue].v);
                    } else {
                        bigInteger3 = bigInteger3.add(zTauElementArr[intValue].u);
                        bigInteger4 = bigInteger4.add(zTauElementArr[intValue].v);
                    }
                } else {
                    bArr[i] = 0;
                }
                BigInteger shiftRight2 = bigInteger3.shiftRight(1);
                BigInteger add = b == 1 ? bigInteger4.add(shiftRight2) : bigInteger4.subtract(shiftRight2);
                BigInteger negate = bigInteger3.shiftRight(1).negate();
                i++;
                bigInteger3 = add;
                bigInteger4 = negate;
            }
        } else {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
    }
}
