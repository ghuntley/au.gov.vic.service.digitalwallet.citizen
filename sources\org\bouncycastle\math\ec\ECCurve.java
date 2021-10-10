package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public abstract class ECCurve {
    ECFieldElement a;
    ECFieldElement b;

    public static class F2m extends ECCurve {
        private BigInteger h;
        private ECPoint.F2m infinity;
        private int k1;
        private int k2;
        private int k3;
        private int m;
        private byte mu;
        private BigInteger n;
        private BigInteger[] si;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, null, null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this.mu = 0;
            this.si = null;
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.n = bigInteger3;
            this.h = bigInteger4;
            if (i2 != 0) {
                if (i3 == 0) {
                    if (i4 != 0) {
                        throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    }
                } else if (i3 <= i2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                } else if (i4 <= i3) {
                    throw new IllegalArgumentException("k3 must be > k2");
                }
                this.a = fromBigInteger(bigInteger);
                this.b = fromBigInteger(bigInteger2);
                this.infinity = new ECPoint.F2m(this, null, null);
                return;
            }
            throw new IllegalArgumentException("k1 must be > 0");
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, null, null);
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        private ECPoint decompressPoint(byte[] bArr, int i) {
            ECFieldElement eCFieldElement;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, bArr));
            if (f2m.toBigInteger().equals(ECConstants.ZERO)) {
                eCFieldElement = (ECFieldElement.F2m) this.b;
                for (int i2 = 0; i2 < this.m - 1; i2++) {
                    eCFieldElement = eCFieldElement.square();
                }
            } else {
                ECFieldElement solveQuadradicEquation = solveQuadradicEquation(f2m.add(this.a).add(this.b.multiply(f2m.square().invert())));
                if (solveQuadradicEquation != null) {
                    if (solveQuadradicEquation.toBigInteger().testBit(0) != i) {
                        solveQuadradicEquation = solveQuadradicEquation.add(new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, ECConstants.ONE));
                    }
                    eCFieldElement = f2m.multiply(solveQuadradicEquation);
                } else {
                    throw new RuntimeException("Invalid point compression");
                }
            }
            return new ECPoint.F2m(this, f2m, eCFieldElement);
        }

        private ECFieldElement solveQuadradicEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, ECConstants.ZERO);
            if (eCFieldElement.toBigInteger().equals(ECConstants.ZERO)) {
                return f2m;
            }
            Random random = new Random();
            do {
                ECFieldElement.F2m f2m2 = new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(this.m, random));
                ECFieldElement eCFieldElement3 = eCFieldElement;
                eCFieldElement2 = f2m;
                for (int i = 1; i <= this.m - 1; i++) {
                    ECFieldElement square = eCFieldElement3.square();
                    eCFieldElement2 = eCFieldElement2.square().add(square.multiply(f2m2));
                    eCFieldElement3 = square.add(eCFieldElement);
                }
                if (!eCFieldElement3.toBigInteger().equals(ECConstants.ZERO)) {
                    return null;
                }
            } while (eCFieldElement2.square().add(eCFieldElement2).toBigInteger().equals(ECConstants.ZERO));
            return eCFieldElement2;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.F2m(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decodePoint(byte[] bArr) {
            byte b = bArr[0];
            if (b != 0) {
                if (b == 2 || b == 3) {
                    int length = bArr.length - 1;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 1, bArr2, 0, length);
                    return bArr[0] == 2 ? decompressPoint(bArr2, 0) : decompressPoint(bArr2, 1);
                } else if (b == 4 || b == 6 || b == 7) {
                    int length2 = (bArr.length - 1) / 2;
                    byte[] bArr3 = new byte[length2];
                    int length3 = (bArr.length - 1) / 2;
                    byte[] bArr4 = new byte[length3];
                    System.arraycopy(bArr, 1, bArr3, 0, length2);
                    System.arraycopy(bArr, length2 + 1, bArr4, 0, length3);
                    return new ECPoint.F2m(this, new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, bArr3)), new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, new BigInteger(1, bArr4)), false);
                } else {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(bArr[0], 16));
                }
            } else if (bArr.length <= 1) {
                return getInfinity();
            } else {
                throw new RuntimeException("Invalid point encoding");
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.m == f2m.m && this.k1 == f2m.k1 && this.k2 == f2m.k2 && this.k3 == f2m.k3 && this.a.equals(f2m.a) && this.b.equals(f2m.b);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.m, this.k1, this.k2, this.k3, bigInteger);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.m;
        }

        public BigInteger getH() {
            return this.h;
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.k1;
        }

        public int getK2() {
            return this.k2;
        }

        public int getK3() {
            return this.k3;
        }

        public int getM() {
            return this.m;
        }

        /* access modifiers changed from: package-private */
        public synchronized byte getMu() {
            if (this.mu == 0) {
                this.mu = Tnaf.getMu(this);
            }
            return this.mu;
        }

        public BigInteger getN() {
            return this.n;
        }

        /* access modifiers changed from: package-private */
        public synchronized BigInteger[] getSi() {
            if (this.si == null) {
                this.si = Tnaf.getSi(this);
            }
            return this.si;
        }

        public int hashCode() {
            return ((((this.a.hashCode() ^ this.b.hashCode()) ^ this.m) ^ this.k1) ^ this.k2) ^ this.k3;
        }

        public boolean isKoblitz() {
            return (this.n == null || this.h == null || (!this.a.toBigInteger().equals(ECConstants.ZERO) && !this.a.toBigInteger().equals(ECConstants.ONE)) || !this.b.toBigInteger().equals(ECConstants.ONE)) ? false : true;
        }

        public boolean isTrinomial() {
            return this.k2 == 0 && this.k3 == 0;
        }
    }

    public static class Fp extends ECCurve {
        ECPoint.Fp infinity = new ECPoint.Fp(this, null, null);
        BigInteger q;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.q = bigInteger;
            this.a = fromBigInteger(bigInteger2);
            this.b = fromBigInteger(bigInteger3);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.Fp(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint decodePoint(byte[] bArr) {
            ECPoint.Fp fp;
            byte b = bArr[0];
            if (b != 0) {
                if (b == 2 || b == 3) {
                    int i = bArr[0] & 1;
                    int length = bArr.length - 1;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 1, bArr2, 0, length);
                    ECFieldElement.Fp fp2 = new ECFieldElement.Fp(this.q, new BigInteger(1, bArr2));
                    ECFieldElement sqrt = fp2.multiply(fp2.square().add(this.a)).add(this.b).sqrt();
                    if (sqrt != null) {
                        if (sqrt.toBigInteger().testBit(0) == i) {
                            fp = new ECPoint.Fp(this, fp2, sqrt, true);
                        } else {
                            BigInteger bigInteger = this.q;
                            fp = new ECPoint.Fp(this, fp2, new ECFieldElement.Fp(bigInteger, bigInteger.subtract(sqrt.toBigInteger())), true);
                        }
                        return fp;
                    }
                    throw new RuntimeException("Invalid point compression");
                } else if (b == 4 || b == 6 || b == 7) {
                    int length2 = (bArr.length - 1) / 2;
                    byte[] bArr3 = new byte[length2];
                    int length3 = (bArr.length - 1) / 2;
                    byte[] bArr4 = new byte[length3];
                    System.arraycopy(bArr, 1, bArr3, 0, length2);
                    System.arraycopy(bArr, length2 + 1, bArr4, 0, length3);
                    return new ECPoint.Fp(this, new ECFieldElement.Fp(this.q, new BigInteger(1, bArr3)), new ECFieldElement.Fp(this.q, new BigInteger(1, bArr4)));
                } else {
                    throw new RuntimeException("Invalid point encoding 0x" + Integer.toString(bArr[0], 16));
                }
            } else if (bArr.length <= 1) {
                return getInfinity();
            } else {
                throw new RuntimeException("Invalid point encoding");
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.q.equals(fp.q) && this.a.equals(fp.a) && this.b.equals(fp.b);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.Fp(this.q, bigInteger);
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public int getFieldSize() {
            return this.q.bitLength();
        }

        @Override // org.bouncycastle.math.ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int hashCode() {
            return (this.a.hashCode() ^ this.b.hashCode()) ^ this.q.hashCode();
        }
    }

    public abstract ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z);

    public abstract ECPoint decodePoint(byte[] bArr);

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public ECFieldElement getA() {
        return this.a;
    }

    public ECFieldElement getB() {
        return this.b;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();
}
