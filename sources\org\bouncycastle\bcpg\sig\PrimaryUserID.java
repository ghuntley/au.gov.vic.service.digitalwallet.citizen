package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

public class PrimaryUserID extends SignatureSubpacket {
    public PrimaryUserID(boolean z, boolean z2) {
        super(25, z, booleanToByteArray(z2));
    }

    public PrimaryUserID(boolean z, byte[] bArr) {
        super(25, z, bArr);
    }

    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public boolean isPrimaryUserID() {
        return this.data[0] != 0;
    }
}
