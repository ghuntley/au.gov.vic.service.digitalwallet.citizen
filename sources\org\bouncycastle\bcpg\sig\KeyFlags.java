package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class KeyFlags extends SignatureSubpacket {
    public static final int AUTHENTICATION = 32;
    public static final int CERTIFY_OTHER = 1;
    public static final int ENCRYPT_COMMS = 4;
    public static final int ENCRYPT_STORAGE = 8;
    public static final int SHARED = 128;
    public static final int SIGN_DATA = 2;
    public static final int SPLIT = 16;

    public KeyFlags(boolean z, int i) {
        super(27, z, intToByteArray(i));
    }

    public KeyFlags(boolean z, byte[] bArr) {
        super(27, z, bArr);
    }

    private static byte[] intToByteArray(int i) {
        byte[] bArr = new byte[4];
        int i2 = 0;
        for (int i3 = 0; i3 != 4; i3++) {
            bArr[i3] = (byte) (i >> (i3 * 8));
            if (bArr[i3] != 0) {
                i2 = i3;
            }
        }
        int i4 = i2 + 1;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, 0, bArr2, 0, i4);
        return bArr2;
    }

    public int getFlags() {
        int i = 0;
        for (int i2 = 0; i2 != this.data.length; i2++) {
            i |= (this.data[i2] & UByte.MAX_VALUE) << (i2 * 8);
        }
        return i;
    }
}
