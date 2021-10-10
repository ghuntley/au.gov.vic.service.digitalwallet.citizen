package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Random;

public abstract class ECFieldElement implements ECConstants {

    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;
        private int k1;
        private int k2;
        private int k3;
        private int m;
        private int representation;
        private int t;
        private IntArray x;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            int i5;
            int i6 = (i + 31) >> 5;
            this.t = i6;
            this.x = new IntArray(bigInteger, i6);
            if (i3 == 0 && i4 == 0) {
                i5 = 2;
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else if (i3 > 0) {
                i5 = 3;
            } else {
                throw new IllegalArgumentException("k2 must be larger than 0");
            }
            this.representation = i5;
            if (bigInteger.signum() >= 0) {
                this.m = i;
                this.k1 = i2;
                this.k2 = i3;
                this.k3 = i4;
                return;
            }
            throw new IllegalArgumentException("x value cannot be negative");
        }

        private F2m(int i, int i2, int i3, int i4, IntArray intArray) {
            this.t = (i + 31) >> 5;
            this.x = intArray;
            this.m = i;
            this.k1 = i2;
            this.k2 = i3;
            this.k3 = i4;
            this.representation = (i3 == 0 && i4 == 0) ? 2 : 3;
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if (!(eCFieldElement instanceof F2m) || !(eCFieldElement2 instanceof F2m)) {
                throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
            }
            F2m f2m = (F2m) eCFieldElement;
            F2m f2m2 = (F2m) eCFieldElement2;
            if (f2m.m != f2m2.m || f2m.k1 != f2m2.k1 || f2m.k2 != f2m2.k2 || f2m.k3 != f2m2.k3) {
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            } else if (f2m.representation != f2m2.representation) {
                throw new IllegalArgumentException("One of the field elements are not elements has incorrect representation");
            }
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            IntArray intArray = (IntArray) this.x.clone();
            intArray.addShifted(((F2m) eCFieldElement).x, 0);
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof F2m)) {
                return false;
            }
            F2m f2m = (F2m) obj;
            return this.m == f2m.m && this.k1 == f2m.k1 && this.k2 == f2m.k2 && this.k3 == f2m.k3 && this.representation == f2m.representation && this.x.equals(f2m.x);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.m;
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

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (((this.x.hashCode() ^ this.m) ^ this.k1) ^ this.k2) ^ this.k3;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            IntArray intArray = (IntArray) this.x.clone();
            IntArray intArray2 = new IntArray(this.t);
            intArray2.setBit(this.m);
            intArray2.setBit(0);
            intArray2.setBit(this.k1);
            if (this.representation == 3) {
                intArray2.setBit(this.k2);
                intArray2.setBit(this.k3);
            }
            IntArray intArray3 = new IntArray(this.t);
            intArray3.setBit(0);
            IntArray intArray4 = new IntArray(this.t);
            while (!intArray.isZero()) {
                int bitLength = intArray.bitLength() - intArray2.bitLength();
                if (bitLength < 0) {
                    bitLength = -bitLength;
                    intArray2 = intArray;
                    intArray = intArray2;
                    intArray4 = intArray3;
                    intArray3 = intArray4;
                }
                int i = bitLength >> 5;
                int i2 = bitLength & 31;
                intArray.addShifted(intArray2.shiftLeft(i2), i);
                intArray3.addShifted(intArray4.shiftLeft(i2), i);
            }
            return new F2m(this.m, this.k1, this.k2, this.k3, intArray4);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            IntArray multiply = this.x.multiply(((F2m) eCFieldElement).x, this.m);
            multiply.reduce(this.m, new int[]{this.k1, this.k2, this.k3});
            return new F2m(this.m, this.k1, this.k2, this.k3, multiply);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            throw new RuntimeException("Not implemented");
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            IntArray square = this.x.square(this.m);
            square.reduce(this.m, new int[]{this.k1, this.k2, this.k3});
            return new F2m(this.m, this.k1, this.k2, this.k3, square);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x.toBigInteger();
        }
    }

    public static class Fp extends ECFieldElement {
        BigInteger q;
        BigInteger x;

        public Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this.x = bigInteger2;
            if (bigInteger2.compareTo(bigInteger) < 0) {
                this.q = bigInteger;
                return;
            }
            throw new IllegalArgumentException("x value too large in field element");
        }

        private static BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            int bitLength = bigInteger4.bitLength();
            int lowestSetBit = bigInteger4.getLowestSetBit();
            BigInteger bigInteger5 = ECConstants.ONE;
            BigInteger bigInteger6 = ECConstants.TWO;
            BigInteger bigInteger7 = ECConstants.ONE;
            BigInteger bigInteger8 = ECConstants.ONE;
            BigInteger bigInteger9 = bigInteger2;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger7 = bigInteger7.multiply(bigInteger8).mod(bigInteger);
                if (bigInteger4.testBit(i)) {
                    bigInteger8 = bigInteger7.multiply(bigInteger3).mod(bigInteger);
                    bigInteger5 = bigInteger5.multiply(bigInteger9).mod(bigInteger);
                    bigInteger6 = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger7)).mod(bigInteger);
                    bigInteger9 = bigInteger9.multiply(bigInteger9).subtract(bigInteger8.shiftLeft(1)).mod(bigInteger);
                } else {
                    bigInteger5 = bigInteger5.multiply(bigInteger6).subtract(bigInteger7).mod(bigInteger);
                    BigInteger mod = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(bigInteger7)).mod(bigInteger);
                    bigInteger6 = bigInteger6.multiply(bigInteger6).subtract(bigInteger7.shiftLeft(1)).mod(bigInteger);
                    bigInteger9 = mod;
                    bigInteger8 = bigInteger7;
                }
            }
            BigInteger mod2 = bigInteger7.multiply(bigInteger8).mod(bigInteger);
            BigInteger mod3 = mod2.multiply(bigInteger3).mod(bigInteger);
            BigInteger mod4 = bigInteger5.multiply(bigInteger6).subtract(mod2).mod(bigInteger);
            BigInteger mod5 = bigInteger9.multiply(bigInteger6).subtract(bigInteger2.multiply(mod2)).mod(bigInteger);
            BigInteger mod6 = mod2.multiply(mod3).mod(bigInteger);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                mod4 = mod4.multiply(mod5).mod(bigInteger);
                mod5 = mod5.multiply(mod5).subtract(mod6.shiftLeft(1)).mod(bigInteger);
                mod6 = mod6.multiply(mod6).mod(bigInteger);
            }
            return new BigInteger[]{mod4, mod5};
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.add(eCFieldElement.toBigInteger()).mod(this.q));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.multiply(eCFieldElement.toBigInteger().modInverse(this.q)).mod(this.q));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Fp)) {
                return false;
            }
            Fp fp = (Fp) obj;
            return this.q.equals(fp.q) && this.x.equals(fp.x);
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public int getFieldSize() {
            return this.q.bitLength();
        }

        public BigInteger getQ() {
            return this.q;
        }

        public int hashCode() {
            return this.q.hashCode() ^ this.x.hashCode();
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement invert() {
            BigInteger bigInteger = this.q;
            return new Fp(bigInteger, this.x.modInverse(bigInteger));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.multiply(eCFieldElement.toBigInteger()).mod(this.q));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement negate() {
            return new Fp(this.q, this.x.negate().mod(this.q));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (!this.q.testBit(0)) {
                throw new RuntimeException("not done yet");
            } else if (this.q.testBit(1)) {
                BigInteger bigInteger = this.q;
                Fp fp = new Fp(bigInteger, this.x.modPow(bigInteger.shiftRight(2).add(ECConstants.ONE), this.q));
                if (fp.square().equals(this)) {
                    return fp;
                }
                return null;
            } else {
                BigInteger subtract = this.q.subtract(ECConstants.ONE);
                BigInteger shiftRight = subtract.shiftRight(1);
                if (!this.x.modPow(shiftRight, this.q).equals(ECConstants.ONE)) {
                    return null;
                }
                BigInteger add = subtract.shiftRight(2).shiftLeft(1).add(ECConstants.ONE);
                BigInteger bigInteger2 = this.x;
                BigInteger mod = bigInteger2.shiftLeft(2).mod(this.q);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger3 = new BigInteger(this.q.bitLength(), random);
                    if (bigInteger3.compareTo(this.q) < 0 && bigInteger3.multiply(bigInteger3).subtract(mod).modPow(shiftRight, this.q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(this.q, bigInteger3, bigInteger2, add);
                        BigInteger bigInteger4 = lucasSequence[0];
                        BigInteger bigInteger5 = lucasSequence[1];
                        if (bigInteger5.multiply(bigInteger5).mod(this.q).equals(mod)) {
                            if (bigInteger5.testBit(0)) {
                                bigInteger5 = bigInteger5.add(this.q);
                            }
                            return new Fp(this.q, bigInteger5.shiftRight(1));
                        } else if (!bigInteger4.equals(ECConstants.ONE) && !bigInteger4.equals(subtract)) {
                            return null;
                        }
                    }
                }
            }
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.q;
            BigInteger bigInteger2 = this.x;
            return new Fp(bigInteger, bigInteger2.multiply(bigInteger2).mod(this.q));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new Fp(this.q, this.x.subtract(eCFieldElement.toBigInteger()).mod(this.q));
        }

        @Override // org.bouncycastle.math.ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(2);
    }
}
