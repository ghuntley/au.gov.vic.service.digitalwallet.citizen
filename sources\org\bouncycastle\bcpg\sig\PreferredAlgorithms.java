package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class PreferredAlgorithms extends SignatureSubpacket {
    public PreferredAlgorithms(int i, boolean z, byte[] bArr) {
        super(i, z, bArr);
    }

    public PreferredAlgorithms(int i, boolean z, int[] iArr) {
        super(i, z, intToByteArray(iArr));
    }

    private static byte[] intToByteArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i != iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public int[] getPreferences() {
        int length = this.data.length;
        int[] iArr = new int[length];
        for (int i = 0; i != length; i++) {
            iArr[i] = this.data[i] & UByte.MAX_VALUE;
        }
        return iArr;
    }

    public int[] getPreferrences() {
        return getPreferences();
    }
}
