package org.bouncycastle.bcpg.sig;

import org.bouncycastle.bcpg.SignatureSubpacket;

public class Exportable extends SignatureSubpacket {
    public Exportable(boolean z, boolean z2) {
        super(4, z, booleanToByteArray(z2));
    }

    public Exportable(boolean z, byte[] bArr) {
        super(4, z, bArr);
    }

    private static byte[] booleanToByteArray(boolean z) {
        byte[] bArr = new byte[1];
        if (z) {
            bArr[0] = 1;
        }
        return bArr;
    }

    public boolean isExportable() {
        return this.data[0] != 0;
    }
}
