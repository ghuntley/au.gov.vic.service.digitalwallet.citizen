package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

public class DSAValidationParameters {
    private int counter;
    private byte[] seed;

    public DSAValidationParameters(byte[] bArr, int i) {
        this.seed = bArr;
        this.counter = i;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAValidationParameters)) {
            return false;
        }
        DSAValidationParameters dSAValidationParameters = (DSAValidationParameters) obj;
        if (dSAValidationParameters.counter != this.counter) {
            return false;
        }
        return Arrays.areEqual(this.seed, dSAValidationParameters.seed);
    }

    public int getCounter() {
        return this.counter;
    }

    public byte[] getSeed() {
        return this.seed;
    }

    public int hashCode() {
        return this.counter ^ Arrays.hashCode(this.seed);
    }
}
