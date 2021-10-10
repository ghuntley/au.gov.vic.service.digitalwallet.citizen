package org.bouncycastle.crypto.generators;

import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import okhttp3.internal.http.StatusLine;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.objectweb.asm.Opcodes;

public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, Opcodes.LXOR, Opcodes.L2F, 139, 149, Opcodes.DCMPL, Opcodes.IFGT, Opcodes.IF_ICMPGT, Opcodes.GOTO, Opcodes.LRETURN, Opcodes.PUTSTATIC, Opcodes.PUTFIELD, Opcodes.ATHROW, Opcodes.INSTANCEOF, Opcodes.MULTIANEWARRAY, Opcodes.IFNONNULL, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, StatusLine.HTTP_TEMP_REDIRECT, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    private NaccacheSternKeyGenerationParameters param;

    private static Vector findFirstPrimes(int i) {
        Vector vector = new Vector(i);
        for (int i2 = 0; i2 != i; i2++) {
            vector.addElement(BigInteger.valueOf((long) smallPrimes[i2]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i, int i2, SecureRandom secureRandom) {
        BigInteger bigInteger = new BigInteger(i, i2, secureRandom);
        while (bigInteger.bitLength() != i) {
            bigInteger = new BigInteger(i, i2, secureRandom);
        }
        return bigInteger;
    }

    private static int getInt(SecureRandom secureRandom, int i) {
        int nextInt;
        int i2;
        if (((-i) & i) == i) {
            return (int) ((((long) i) * ((long) (secureRandom.nextInt() & Integer.MAX_VALUE))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i2 = nextInt % i;
        } while ((nextInt - i2) + (i - 1) < 0);
        return i2;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i = 0; i < vector.size(); i++) {
            vector3.addElement(vector.elementAt(i));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        long j;
        BigInteger generatePrime;
        BigInteger add;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger generatePrime2;
        BigInteger bigInteger3;
        BigInteger add2;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        boolean z;
        int i;
        BigInteger bigInteger6;
        BigInteger bigInteger7;
        PrintStream printStream;
        StringBuilder sb;
        String str;
        long j2;
        BigInteger bigInteger8;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean isDebug = this.param.isDebug();
        if (isDebug) {
            PrintStream printStream2 = System.out;
            printStream2.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector permuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigInteger9 = ONE;
        BigInteger bigInteger10 = bigInteger9;
        for (int i2 = 0; i2 < permuteList.size() / 2; i2++) {
            bigInteger10 = bigInteger10.multiply((BigInteger) permuteList.elementAt(i2));
        }
        for (int size = permuteList.size() / 2; size < permuteList.size(); size++) {
            bigInteger9 = bigInteger9.multiply((BigInteger) permuteList.elementAt(size));
        }
        BigInteger multiply = bigInteger10.multiply(bigInteger9);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger generatePrime3 = generatePrime(bitLength, certainty, random);
        BigInteger generatePrime4 = generatePrime(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = generatePrime3.multiply(bigInteger10).shiftLeft(1);
        BigInteger shiftLeft2 = generatePrime4.multiply(bigInteger9).shiftLeft(1);
        long j3 = 0;
        while (true) {
            j = j3 + 1;
            generatePrime = generatePrime(24, certainty, random);
            add = generatePrime.multiply(shiftLeft).add(ONE);
            if (!add.isProbablePrime(certainty)) {
                bigInteger2 = shiftLeft2;
                bigInteger = shiftLeft;
            } else {
                while (true) {
                    do {
                        generatePrime2 = generatePrime(24, certainty, random);
                    } while (generatePrime.equals(generatePrime2));
                    BigInteger multiply2 = generatePrime2.multiply(shiftLeft2);
                    bigInteger2 = shiftLeft2;
                    bigInteger3 = ONE;
                    add2 = multiply2.add(bigInteger3);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    shiftLeft2 = bigInteger2;
                }
                bigInteger = shiftLeft;
                if (!multiply.gcd(generatePrime.multiply(generatePrime2)).equals(bigInteger3)) {
                    continue;
                } else if (add.multiply(add2).bitLength() >= strength) {
                    break;
                } else if (isDebug) {
                    PrintStream printStream3 = System.out;
                    printStream3.println("key size too small. Should be " + strength + " but is actually " + add.multiply(add2).bitLength());
                }
            }
            j3 = j;
            shiftLeft2 = bigInteger2;
            shiftLeft = bigInteger;
        }
        BigInteger bigInteger11 = generatePrime4;
        if (isDebug) {
            PrintStream printStream4 = System.out;
            bigInteger4 = generatePrime3;
            printStream4.println("needed " + j + " tries to generate p and q.");
        } else {
            bigInteger4 = generatePrime3;
        }
        BigInteger multiply3 = add.multiply(add2);
        BigInteger multiply4 = add.subtract(bigInteger3).multiply(add2.subtract(bigInteger3));
        if (isDebug) {
            System.out.println("generating g");
        }
        long j4 = 0;
        while (true) {
            Vector vector = new Vector();
            int i3 = 0;
            while (i3 != permuteList.size()) {
                BigInteger divide = multiply4.divide((BigInteger) permuteList.elementAt(i3));
                while (true) {
                    j2 = j4 + 1;
                    bigInteger8 = new BigInteger(strength, certainty, random);
                    if (!bigInteger8.modPow(divide, multiply3).equals(ONE)) {
                        break;
                    }
                    j4 = j2;
                    strength = strength;
                }
                vector.addElement(bigInteger8);
                i3++;
                j4 = j2;
                strength = strength;
            }
            bigInteger5 = ONE;
            int i4 = 0;
            while (i4 < permuteList.size()) {
                bigInteger5 = bigInteger5.multiply(((BigInteger) vector.elementAt(i4)).modPow(multiply.divide((BigInteger) permuteList.elementAt(i4)), multiply3)).mod(multiply3);
                i4++;
                random = random;
            }
            int i5 = 0;
            while (true) {
                if (i5 >= permuteList.size()) {
                    z = false;
                    break;
                } else if (bigInteger5.modPow(multiply4.divide((BigInteger) permuteList.elementAt(i5)), multiply3).equals(ONE)) {
                    if (isDebug) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("g has order phi(n)/" + permuteList.elementAt(i5) + "\n g: " + bigInteger5);
                    }
                    z = true;
                } else {
                    i5++;
                }
            }
            if (!z) {
                BigInteger modPow = bigInteger5.modPow(multiply4.divide(BigInteger.valueOf(4)), multiply3);
                BigInteger bigInteger12 = ONE;
                if (modPow.equals(bigInteger12)) {
                    if (isDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/4\n g:";
                    }
                } else if (bigInteger5.modPow(multiply4.divide(generatePrime), multiply3).equals(bigInteger12)) {
                    if (isDebug) {
                        printStream = System.out;
                        sb = new StringBuilder();
                        str = "g has order phi(n)/p'\n g: ";
                    }
                } else if (!bigInteger5.modPow(multiply4.divide(generatePrime2), multiply3).equals(bigInteger12)) {
                    bigInteger7 = bigInteger4;
                    if (!bigInteger5.modPow(multiply4.divide(bigInteger7), multiply3).equals(bigInteger12)) {
                        bigInteger6 = bigInteger11;
                        if (!bigInteger5.modPow(multiply4.divide(bigInteger6), multiply3).equals(bigInteger12)) {
                            break;
                        } else if (isDebug) {
                            PrintStream printStream6 = System.out;
                            StringBuilder sb2 = new StringBuilder();
                            i = certainty;
                            sb2.append("g has order phi(n)/b\n g: ");
                            sb2.append(bigInteger5);
                            printStream6.println(sb2.toString());
                            bigInteger4 = bigInteger7;
                            certainty = i;
                            add2 = add2;
                            add = add;
                            strength = strength;
                            random = random;
                            bigInteger11 = bigInteger6;
                        }
                    } else {
                        if (isDebug) {
                            PrintStream printStream7 = System.out;
                            printStream7.println("g has order phi(n)/a\n g: " + bigInteger5);
                        }
                        bigInteger6 = bigInteger11;
                    }
                    i = certainty;
                    bigInteger4 = bigInteger7;
                    certainty = i;
                    add2 = add2;
                    add = add;
                    strength = strength;
                    random = random;
                    bigInteger11 = bigInteger6;
                } else if (isDebug) {
                    printStream = System.out;
                    sb = new StringBuilder();
                    str = "g has order phi(n)/q'\n g: ";
                }
                sb.append(str);
                sb.append(bigInteger5);
                printStream.println(sb.toString());
            }
            bigInteger6 = bigInteger11;
            bigInteger7 = bigInteger4;
            i = certainty;
            bigInteger4 = bigInteger7;
            certainty = i;
            add2 = add2;
            add = add;
            strength = strength;
            random = random;
            bigInteger11 = bigInteger6;
        }
        if (isDebug) {
            PrintStream printStream8 = System.out;
            printStream8.println("needed " + j4 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            PrintStream printStream9 = System.out;
            printStream9.println("smallPrimes: " + permuteList);
            PrintStream printStream10 = System.out;
            printStream10.println("sigma:...... " + multiply + " (" + multiply.bitLength() + " bits)");
            PrintStream printStream11 = System.out;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("a:.......... ");
            sb3.append(bigInteger7);
            printStream11.println(sb3.toString());
            PrintStream printStream12 = System.out;
            printStream12.println("b:.......... " + bigInteger6);
            PrintStream printStream13 = System.out;
            printStream13.println("p':......... " + generatePrime);
            PrintStream printStream14 = System.out;
            printStream14.println("q':......... " + generatePrime2);
            PrintStream printStream15 = System.out;
            printStream15.println("p:.......... " + add);
            PrintStream printStream16 = System.out;
            printStream16.println("q:.......... " + add2);
            PrintStream printStream17 = System.out;
            printStream17.println("n:.......... " + multiply3);
            PrintStream printStream18 = System.out;
            printStream18.println("phi(n):..... " + multiply4);
            PrintStream printStream19 = System.out;
            printStream19.println("g:.......... " + bigInteger5);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair(new NaccacheSternKeyParameters(false, bigInteger5, multiply3, multiply.bitLength()), new NaccacheSternPrivateKeyParameters(bigInteger5, multiply3, multiply.bitLength(), permuteList, multiply4));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
