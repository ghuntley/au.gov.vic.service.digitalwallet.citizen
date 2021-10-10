package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

public class Revocable extends SignatureSubpacket {
    public Revocable(boolean z, boolean z2) {
        super(7, z, booleanToByteArray(z2));
    }

    public Revocable(boolean z, byte[] bArr) {
        super(7, z, bArr);
    }

    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public boolean isRevocable() {
        return this.data[0] != 0;
    }
}
