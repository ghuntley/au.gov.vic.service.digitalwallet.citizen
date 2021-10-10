package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class SignerUserID extends SignatureSubpacket {
    public SignerUserID(boolean z, String str) {
        super(28, z, userIDToBytes(str));
    }

    public SignerUserID(boolean z, byte[] bArr) {
        super(28, z, bArr);
    }

    private static byte[] userIDToBytes(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i != str.length(); i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public String getID() {
        int length = this.data.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (this.data[i] & UByte.MAX_VALUE);
        }
        return new String(cArr);
    }
}
