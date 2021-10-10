package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class TrustSignature extends SignatureSubpacket {
    public TrustSignature(boolean z, int i, int i2) {
        super(5, z, intToByteArray(i, i2));
    }

    public TrustSignature(boolean z, byte[] bArr) {
        super(5, z, bArr);
    }

    private static byte[] intToByteArray(int i, int i2) {
        return new byte[]{(byte) i, (byte) i2};
    }

    public int getDepth() {
        return this.data[0] & UByte.MAX_VALUE;
    }

    public int getTrustAmount() {
        return this.data[1] & UByte.MAX_VALUE;
    }
}
