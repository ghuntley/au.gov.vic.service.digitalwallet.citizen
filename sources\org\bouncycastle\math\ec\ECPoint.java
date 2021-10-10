package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9IntegerConverter;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;

public abstract class ECPoint {
    private static X9IntegerConverter converter = new X9IntegerConverter();
    ECCurve curve;
    protected ECMultiplier multiplier = null;
    protected PreCompInfo preCompInfo = null;
    protected boolean withCompression;
    ECFieldElement x;
    ECFieldElement y;

    public static class F2m extends ECPoint {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null || eCFieldElement2 != null) && (eCFieldElement != null || eCFieldElement2 == null)) {
                if (eCFieldElement != null) {
                    ECFieldElement.F2m.checkFieldElements(this.x, this.y);
                    if (eCCurve != null) {
                        ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
                    }
                }
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (!eCPoint.curve.equals(eCPoint2.curve)) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return addSimple((F2m) eCPoint);
        }

        public F2m addSimple(F2m f2m) {
            if (isInfinity()) {
                return f2m;
            }
            if (f2m.isInfinity()) {
                return this;
            }
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m) f2m.getX();
            ECFieldElement.F2m f2m3 = (ECFieldElement.F2m) f2m.getY();
            if (this.x.equals(f2m2)) {
                return (F2m) (this.y.equals(f2m3) ? twice() : this.curve.getInfinity());
            }
            ECFieldElement.F2m f2m4 = (ECFieldElement.F2m) this.y.add(f2m3).divide(this.x.add(f2m2));
            ECFieldElement.F2m f2m5 = (ECFieldElement.F2m) f2m4.square().add(f2m4).add(this.x).add(f2m2).add(this.curve.getA());
            return new F2m(this.curve, f2m5, (ECFieldElement.F2m) f2m4.multiply(this.x.add(f2m5)).add(f2m5).add(this.y), this.withCompression);
        }

        /* access modifiers changed from: package-private */
        @Override // org.bouncycastle.math.ec.ECPoint
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = ((ECCurve.F2m) this.curve).isKoblitz() ? new WTauNafMultiplier() : new WNafMultiplier();
            }
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.x);
            byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            if (this.withCompression) {
                byte[] bArr = new byte[(byteLength + 1)];
                bArr[0] = 2;
                if (!getX().toBigInteger().equals(ECConstants.ZERO) && getY().multiply(getX().invert()).toBigInteger().testBit(0)) {
                    bArr[0] = 3;
                }
                System.arraycopy(integerToBytes, 0, bArr, 1, byteLength);
                return bArr;
            }
            byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
            byte[] bArr2 = new byte[(byteLength + byteLength + 1)];
            bArr2[0] = 4;
            System.arraycopy(integerToBytes, 0, bArr2, 1, byteLength);
            System.arraycopy(integerToBytes2, 0, bArr2, byteLength + 1, byteLength);
            return bArr2;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            return new F2m(this.curve, getX(), getY().add(getX()), this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return subtractSimple((F2m) eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            return f2m.isInfinity() ? this : addSimple((F2m) f2m.negate());
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.x.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement.F2m f2m = (ECFieldElement.F2m) this.x.add(this.y.divide(this.x));
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m) f2m.square().add(f2m).add(this.curve.getA());
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(ECConstants.ONE);
            return new F2m(this.curve, f2m2, (ECFieldElement.F2m) this.x.square().add(f2m2.multiply(f2m.add(fromBigInteger))), this.withCompression);
        }
    }

    public static class Fp extends ECPoint {
        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        public Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement == null || eCFieldElement2 != null) && (eCFieldElement != null || eCFieldElement2 == null)) {
                this.withCompression = z;
                return;
            }
            throw new IllegalArgumentException("Exactly one of the field elements is null");
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (this.x.equals(eCPoint.x)) {
                return this.y.equals(eCPoint.y) ? twice() : this.curve.getInfinity();
            }
            ECFieldElement divide = eCPoint.y.subtract(this.y).divide(eCPoint.x.subtract(this.x));
            ECFieldElement subtract = divide.square().subtract(this.x).subtract(eCPoint.x);
            return new Fp(this.curve, subtract, divide.multiply(this.x.subtract(subtract)).subtract(this.y));
        }

        /* access modifiers changed from: package-private */
        @Override // org.bouncycastle.math.ec.ECPoint
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = new WNafMultiplier();
            }
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.x);
            if (this.withCompression) {
                byte b = getY().toBigInteger().testBit(0) ? (byte) 3 : 2;
                byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
                byte[] bArr = new byte[(integerToBytes.length + 1)];
                bArr[0] = b;
                System.arraycopy(integerToBytes, 0, bArr, 1, integerToBytes.length);
                return bArr;
            }
            byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            byte[] integerToBytes3 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
            byte[] bArr2 = new byte[(integerToBytes2.length + integerToBytes3.length + 1)];
            bArr2[0] = 4;
            System.arraycopy(integerToBytes2, 0, bArr2, 1, integerToBytes2.length);
            System.arraycopy(integerToBytes3, 0, bArr2, integerToBytes2.length + 1, integerToBytes3.length);
            return bArr2;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            return new Fp(this.curve, this.x, this.y.negate(), this.withCompression);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.y.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(BigInteger.valueOf(2));
            ECFieldElement divide = this.x.square().multiply(this.curve.fromBigInteger(BigInteger.valueOf(3))).add(this.curve.a).divide(this.y.multiply(fromBigInteger));
            ECFieldElement subtract = divide.square().subtract(this.x.multiply(fromBigInteger));
            return new Fp(this.curve, subtract, divide.multiply(this.x.subtract(subtract)).subtract(this.y), this.withCompression);
        }
    }

    protected ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this.curve = eCCurve;
        this.x = eCFieldElement;
        this.y = eCFieldElement2;
    }

    public abstract ECPoint add(ECPoint eCPoint);

    /* access modifiers changed from: package-private */
    public synchronized void assertECMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = new FpNafMultiplier();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ECPoint)) {
            return false;
        }
        ECPoint eCPoint = (ECPoint) obj;
        return isInfinity() ? eCPoint.isInfinity() : this.x.equals(eCPoint.x) && this.y.equals(eCPoint.y);
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public abstract byte[] getEncoded();

    public ECFieldElement getX() {
        return this.x;
    }

    public ECFieldElement getY() {
        return this.y;
    }

    public int hashCode() {
        if (isInfinity()) {
            return 0;
        }
        return this.x.hashCode() ^ this.y.hashCode();
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean isInfinity() {
        return this.x == null && this.y == null;
    }

    public ECPoint multiply(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("The multiplicator cannot be negative");
        } else if (isInfinity()) {
            return this;
        } else {
            if (bigInteger.signum() == 0) {
                return this.curve.getInfinity();
            }
            assertECMultiplier();
            return this.multiplier.multiply(this, bigInteger, this.preCompInfo);
        }
    }

    public abstract ECPoint negate();

    /* access modifiers changed from: package-private */
    public void setPreCompInfo(PreCompInfo preCompInfo2) {
        this.preCompInfo = preCompInfo2;
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public abstract ECPoint twice();
}
