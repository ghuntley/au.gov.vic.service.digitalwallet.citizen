package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410ValidationParameters;

public class GOST3410ParametersGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private SecureRandom init_random;
    private int size;
    private int typeproc;

    private int procedure_A(int i, int i2, BigInteger[] bigIntegerArr, int i3) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        int i4 = i;
        while (true) {
            if (i4 >= 0 && i4 <= 65536) {
                break;
            }
            i4 = this.init_random.nextInt() / 32768;
        }
        int i5 = i2;
        while (true) {
            if (i5 >= 0 && i5 <= 65536 && i5 / 2 != 0) {
                break;
            }
            i5 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger bigInteger2 = new BigInteger(Integer.toString(i5));
        BigInteger bigInteger3 = new BigInteger("19381");
        BigInteger bigInteger4 = new BigInteger(Integer.toString(i4));
        int i6 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger4};
        int[] iArr = {i3};
        int i7 = 0;
        int i8 = 0;
        while (iArr[i7] >= 17) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i8 = i7 + 1;
            iArr[i8] = iArr[i7] / 2;
            i7 = i8;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i8 + 1)];
        int i9 = 16;
        bigIntegerArr4[i8] = new BigInteger("8003", 16);
        int i10 = i8 - 1;
        int i11 = 0;
        while (true) {
            if (i11 >= i8) {
                bigInteger = bigIntegerArr3[i6];
                break;
            }
            int i12 = iArr[i10] / i9;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i6, bigIntegerArr5, i6, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i12 + 1)];
                System.arraycopy(bigIntegerArr5, i6, bigIntegerArr2, i6, length2);
                int i13 = i6;
                while (i13 < i12) {
                    int i14 = i13 + 1;
                    bigIntegerArr2[i14] = bigIntegerArr2[i13].multiply(bigInteger3).add(bigInteger2).mod(TWO.pow(i9));
                    i13 = i14;
                }
                BigInteger bigInteger5 = new BigInteger("0");
                for (int i15 = i6; i15 < i12; i15++) {
                    bigInteger5 = bigInteger5.add(bigIntegerArr2[i15].multiply(TWO.pow(i15 * 16)));
                }
                bigIntegerArr2[i6] = bigIntegerArr2[i12];
                BigInteger bigInteger6 = TWO;
                int i16 = i10 + 1;
                BigInteger add = bigInteger6.pow(iArr[i10] - 1).divide(bigIntegerArr4[i16]).add(bigInteger6.pow(iArr[i10] - 1).multiply(bigInteger5).divide(bigIntegerArr4[i16].multiply(bigInteger6.pow(i12 * 16))));
                BigInteger mod = add.mod(bigInteger6);
                BigInteger bigInteger7 = ONE;
                if (mod.compareTo(bigInteger7) == 0) {
                    add = add.add(bigInteger7);
                }
                int i17 = 0;
                while (true) {
                    long j = (long) i17;
                    BigInteger multiply = bigIntegerArr4[i16].multiply(add.add(BigInteger.valueOf(j)));
                    BigInteger bigInteger8 = ONE;
                    bigIntegerArr4[i10] = multiply.add(bigInteger8);
                    BigInteger bigInteger9 = bigIntegerArr4[i10];
                    BigInteger bigInteger10 = TWO;
                    if (bigInteger9.compareTo(bigInteger10.pow(iArr[i10])) == 1) {
                        break;
                    }
                    if (bigInteger10.modPow(bigIntegerArr4[i16].multiply(add.add(BigInteger.valueOf(j))), bigIntegerArr4[i10]).compareTo(bigInteger8) == 0 && bigInteger10.modPow(add.add(BigInteger.valueOf(j)), bigIntegerArr4[i10]).compareTo(bigInteger8) != 0) {
                        break;
                    }
                    i17 += 2;
                    i8 = i8;
                    bigInteger3 = bigInteger3;
                    bigInteger2 = bigInteger2;
                    i12 = i12;
                }
                i8 = i8;
                bigInteger3 = bigInteger3;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger2 = bigInteger2;
                i12 = i12;
                i6 = 0;
                i9 = 16;
            }
            i10--;
            if (i10 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i11++;
            i8 = i8;
            bigInteger3 = bigInteger3;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger2 = bigInteger2;
            i6 = 0;
            i9 = 16;
        }
        return bigInteger.intValue();
    }

    private long procedure_Aa(long j, long j2, BigInteger[] bigIntegerArr, int i) {
        BigInteger bigInteger;
        BigInteger[] bigIntegerArr2;
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.init_random.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger bigInteger2 = new BigInteger(Long.toString(j4));
        BigInteger bigInteger3 = new BigInteger("97781173");
        BigInteger bigInteger4 = new BigInteger(Long.toString(j3));
        int i2 = 0;
        BigInteger[] bigIntegerArr3 = {bigInteger4};
        int[] iArr = {i};
        int i3 = 0;
        int i4 = 0;
        while (iArr[i3] >= 33) {
            int length = iArr.length + 1;
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            iArr = new int[length];
            System.arraycopy(iArr2, 0, iArr, 0, length);
            i4 = i3 + 1;
            iArr[i4] = iArr[i3] / 2;
            i3 = i4;
        }
        BigInteger[] bigIntegerArr4 = new BigInteger[(i4 + 1)];
        bigIntegerArr4[i4] = new BigInteger("8000000B", 16);
        int i5 = i4 - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= i4) {
                bigInteger = bigIntegerArr3[i2];
                break;
            }
            int i7 = 32;
            int i8 = iArr[i5] / 32;
            while (true) {
                int length2 = bigIntegerArr3.length;
                BigInteger[] bigIntegerArr5 = new BigInteger[length2];
                System.arraycopy(bigIntegerArr3, i2, bigIntegerArr5, i2, bigIntegerArr3.length);
                bigIntegerArr2 = new BigInteger[(i8 + 1)];
                System.arraycopy(bigIntegerArr5, i2, bigIntegerArr2, i2, length2);
                int i9 = i2;
                while (i9 < i8) {
                    int i10 = i9 + 1;
                    bigIntegerArr2[i10] = bigIntegerArr2[i9].multiply(bigInteger3).add(bigInteger2).mod(TWO.pow(i7));
                    i9 = i10;
                }
                BigInteger bigInteger5 = new BigInteger("0");
                for (int i11 = i2; i11 < i8; i11++) {
                    bigInteger5 = bigInteger5.add(bigIntegerArr2[i11].multiply(TWO.pow(i11 * 32)));
                }
                bigIntegerArr2[i2] = bigIntegerArr2[i8];
                BigInteger bigInteger6 = TWO;
                int i12 = i5 + 1;
                BigInteger add = bigInteger6.pow(iArr[i5] - 1).divide(bigIntegerArr4[i12]).add(bigInteger6.pow(iArr[i5] - 1).multiply(bigInteger5).divide(bigIntegerArr4[i12].multiply(bigInteger6.pow(i8 * 32))));
                BigInteger mod = add.mod(bigInteger6);
                BigInteger bigInteger7 = ONE;
                if (mod.compareTo(bigInteger7) == 0) {
                    add = add.add(bigInteger7);
                }
                int i13 = 0;
                while (true) {
                    long j5 = (long) i13;
                    BigInteger multiply = bigIntegerArr4[i12].multiply(add.add(BigInteger.valueOf(j5)));
                    BigInteger bigInteger8 = ONE;
                    bigIntegerArr4[i5] = multiply.add(bigInteger8);
                    BigInteger bigInteger9 = bigIntegerArr4[i5];
                    BigInteger bigInteger10 = TWO;
                    if (bigInteger9.compareTo(bigInteger10.pow(iArr[i5])) == 1) {
                        break;
                    }
                    if (bigInteger10.modPow(bigIntegerArr4[i12].multiply(add.add(BigInteger.valueOf(j5))), bigIntegerArr4[i5]).compareTo(bigInteger8) == 0 && bigInteger10.modPow(add.add(BigInteger.valueOf(j5)), bigIntegerArr4[i5]).compareTo(bigInteger8) != 0) {
                        break;
                    }
                    i13 += 2;
                    bigInteger2 = bigInteger2;
                    i4 = i4;
                    bigInteger3 = bigInteger3;
                }
                bigInteger2 = bigInteger2;
                bigIntegerArr3 = bigIntegerArr2;
                bigInteger3 = bigInteger3;
                i2 = 0;
                i7 = 32;
                i4 = i4;
            }
            i5--;
            if (i5 < 0) {
                bigIntegerArr[0] = bigIntegerArr4[0];
                bigIntegerArr[1] = bigIntegerArr4[1];
                bigInteger = bigIntegerArr2[0];
                break;
            }
            i6++;
            bigInteger2 = bigInteger2;
            i4 = i4;
            bigIntegerArr3 = bigIntegerArr2;
            bigInteger3 = bigInteger3;
            i2 = 0;
        }
        return bigInteger.longValue();
    }

    private void procedure_B(int i, int i2, BigInteger[] bigIntegerArr) {
        int i3 = i;
        while (true) {
            if (i3 >= 0 && i3 <= 65536) {
                break;
            }
            i3 = this.init_random.nextInt() / 32768;
        }
        int i4 = i2;
        while (true) {
            if (i4 >= 0 && i4 <= 65536 && i4 / 2 != 0) {
                break;
            }
            i4 = (this.init_random.nextInt() / 32768) + 1;
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Integer.toString(i4));
        BigInteger bigInteger2 = new BigInteger("19381");
        int procedure_A = procedure_A(i3, i4, bigIntegerArr2, 256);
        int i5 = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        int procedure_A2 = procedure_A(procedure_A, i4, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[65];
        bigIntegerArr3[0] = new BigInteger(Integer.toString(procedure_A2));
        while (true) {
            int i6 = i5;
            while (i6 < 64) {
                int i7 = i6 + 1;
                bigIntegerArr3[i7] = bigIntegerArr3[i6].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(16));
                i6 = i7;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i8 = i5; i8 < 64; i8++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i8].multiply(TWO.pow(i8 * 16)));
            }
            bigIntegerArr3[i5] = bigIntegerArr3[64];
            BigInteger bigInteger6 = TWO;
            int i9 = 1024;
            BigInteger add = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger mod = add.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (mod.compareTo(bigInteger7) == 0) {
                add = add.add(bigInteger7);
            }
            int i10 = i5;
            while (true) {
                long j = (long) i10;
                BigInteger multiply = bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j)));
                BigInteger bigInteger8 = ONE;
                BigInteger add2 = multiply.add(bigInteger8);
                BigInteger bigInteger9 = TWO;
                if (add2.compareTo(bigInteger9.pow(i9)) == 1) {
                    break;
                } else if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j))), add2).compareTo(bigInteger8) != 0 || bigInteger9.modPow(bigInteger3.multiply(add.add(BigInteger.valueOf(j))), add2).compareTo(bigInteger8) == 0) {
                    i10 += 2;
                    i9 = 1024;
                } else {
                    bigIntegerArr[0] = add2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                }
            }
            i5 = 0;
        }
    }

    private void procedure_Bb(long j, long j2, BigInteger[] bigIntegerArr) {
        long j3 = j;
        while (true) {
            if (j3 >= 0 && j3 <= 4294967296L) {
                break;
            }
            j3 = (long) (this.init_random.nextInt() * 2);
        }
        long j4 = j2;
        while (true) {
            if (j4 >= 0 && j4 <= 4294967296L && j4 / 2 != 0) {
                break;
            }
            j4 = (long) ((this.init_random.nextInt() * 2) + 1);
        }
        BigInteger[] bigIntegerArr2 = new BigInteger[2];
        BigInteger bigInteger = new BigInteger(Long.toString(j4));
        BigInteger bigInteger2 = new BigInteger("97781173");
        long procedure_Aa = procedure_Aa(j3, j4, bigIntegerArr2, 256);
        int i = 0;
        BigInteger bigInteger3 = bigIntegerArr2[0];
        long procedure_Aa2 = procedure_Aa(procedure_Aa, j4, bigIntegerArr2, 512);
        BigInteger bigInteger4 = bigIntegerArr2[0];
        BigInteger[] bigIntegerArr3 = new BigInteger[33];
        bigIntegerArr3[0] = new BigInteger(Long.toString(procedure_Aa2));
        while (true) {
            int i2 = i;
            while (i2 < 32) {
                int i3 = i2 + 1;
                bigIntegerArr3[i3] = bigIntegerArr3[i2].multiply(bigInteger2).add(bigInteger).mod(TWO.pow(32));
                i2 = i3;
            }
            BigInteger bigInteger5 = new BigInteger("0");
            for (int i4 = i; i4 < 32; i4++) {
                bigInteger5 = bigInteger5.add(bigIntegerArr3[i4].multiply(TWO.pow(i4 * 32)));
            }
            bigIntegerArr3[i] = bigIntegerArr3[32];
            BigInteger bigInteger6 = TWO;
            int i5 = 1024;
            BigInteger add = bigInteger6.pow(1023).divide(bigInteger3.multiply(bigInteger4)).add(bigInteger6.pow(1023).multiply(bigInteger5).divide(bigInteger3.multiply(bigInteger4).multiply(bigInteger6.pow(1024))));
            BigInteger mod = add.mod(bigInteger6);
            BigInteger bigInteger7 = ONE;
            if (mod.compareTo(bigInteger7) == 0) {
                add = add.add(bigInteger7);
            }
            int i6 = i;
            while (true) {
                long j5 = (long) i6;
                BigInteger multiply = bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j5)));
                BigInteger bigInteger8 = ONE;
                BigInteger add2 = multiply.add(bigInteger8);
                BigInteger bigInteger9 = TWO;
                if (add2.compareTo(bigInteger9.pow(i5)) == 1) {
                    break;
                } else if (bigInteger9.modPow(bigInteger3.multiply(bigInteger4).multiply(add.add(BigInteger.valueOf(j5))), add2).compareTo(bigInteger8) != 0 || bigInteger9.modPow(bigInteger3.multiply(add.add(BigInteger.valueOf(j5))), add2).compareTo(bigInteger8) == 0) {
                    i6 += 2;
                    i5 = 1024;
                } else {
                    bigIntegerArr[0] = add2;
                    bigIntegerArr[1] = bigInteger3;
                    return;
                }
            }
            i = 0;
        }
    }

    private BigInteger procedure_C(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger subtract = bigInteger.subtract(ONE);
        BigInteger divide = subtract.divide(bigInteger2);
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigInteger3 = new BigInteger(bitLength, this.init_random);
            BigInteger bigInteger4 = ONE;
            if (bigInteger3.compareTo(bigInteger4) > 0 && bigInteger3.compareTo(subtract) < 0) {
                BigInteger modPow = bigInteger3.modPow(divide, bigInteger);
                if (modPow.compareTo(bigInteger4) != 0) {
                    return modPow;
                }
            }
        }
    }

    public GOST3410Parameters generateParameters() {
        BigInteger[] bigIntegerArr = new BigInteger[2];
        if (this.typeproc == 1) {
            int nextInt = this.init_random.nextInt();
            int nextInt2 = this.init_random.nextInt();
            int i = this.size;
            if (i == 512) {
                procedure_A(nextInt, nextInt2, bigIntegerArr, 512);
            } else if (i == 1024) {
                procedure_B(nextInt, nextInt2, bigIntegerArr);
            } else {
                throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
            }
            BigInteger bigInteger = bigIntegerArr[0];
            BigInteger bigInteger2 = bigIntegerArr[1];
            return new GOST3410Parameters(bigInteger, bigInteger2, procedure_C(bigInteger, bigInteger2), new GOST3410ValidationParameters(nextInt, nextInt2));
        }
        long nextLong = this.init_random.nextLong();
        long nextLong2 = this.init_random.nextLong();
        int i2 = this.size;
        if (i2 == 512) {
            procedure_Aa(nextLong, nextLong2, bigIntegerArr, 512);
        } else if (i2 == 1024) {
            procedure_Bb(nextLong, nextLong2, bigIntegerArr);
        } else {
            throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
        }
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        return new GOST3410Parameters(bigInteger3, bigInteger4, procedure_C(bigInteger3, bigInteger4), new GOST3410ValidationParameters(nextLong, nextLong2));
    }

    public void init(int i, int i2, SecureRandom secureRandom) {
        this.size = i;
        this.typeproc = i2;
        this.init_random = secureRandom;
    }
}
