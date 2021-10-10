package org.bouncycastle.bcpg;

import java.io.IOException;
import java.math.BigInteger;

public class MPInteger extends BCPGObject {
    BigInteger value = null;

    public MPInteger(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("value must not be null, or negative");
        }
        this.value = bigInteger;
    }

    public MPInteger(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = new byte[((((bCPGInputStream.read() << 8) | bCPGInputStream.read()) + 7) / 8)];
        bCPGInputStream.readFully(bArr);
        this.value = new BigInteger(1, bArr);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        int bitLength = this.value.bitLength();
        bCPGOutputStream.write(bitLength >> 8);
        bCPGOutputStream.write(bitLength);
        byte[] byteArray = this.value.toByteArray();
        if (byteArray[0] == 0) {
            bCPGOutputStream.write(byteArray, 1, byteArray.length - 1);
        } else {
            bCPGOutputStream.write(byteArray, 0, byteArray.length);
        }
    }

    public BigInteger getValue() {
        return this.value;
    }
}
