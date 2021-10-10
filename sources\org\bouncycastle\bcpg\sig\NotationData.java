package org.bouncycastle.bcpg.sig;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.util.Strings;

public class NotationData extends SignatureSubpacket {
    public static final int HEADER_FLAG_LENGTH = 4;
    public static final int HEADER_NAME_LENGTH = 2;
    public static final int HEADER_VALUE_LENGTH = 2;

    public NotationData(boolean z, boolean z2, String str, String str2) {
        super(20, z, createData(z2, str, str2));
    }

    public NotationData(boolean z, byte[] bArr) {
        super(20, z, bArr);
    }

    private static byte[] createData(boolean z, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(z ? 128 : 0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        int min = Math.min(uTF8ByteArray.length, 255);
        byte[] uTF8ByteArray2 = Strings.toUTF8ByteArray(str2);
        int min2 = Math.min(uTF8ByteArray2.length, 255);
        byteArrayOutputStream.write((min >>> 8) & 255);
        byteArrayOutputStream.write((min >>> 0) & 255);
        byteArrayOutputStream.write((min2 >>> 8) & 255);
        byteArrayOutputStream.write(255 & (min2 >>> 0));
        byteArrayOutputStream.write(uTF8ByteArray, 0, min);
        byteArrayOutputStream.write(uTF8ByteArray2, 0, min2);
        return byteArrayOutputStream.toByteArray();
    }

    public String getNotationName() {
        int i = (this.data[4] << 8) + (this.data[5] << 0);
        byte[] bArr = new byte[i];
        System.arraycopy(this.data, 8, bArr, 0, i);
        return Strings.fromUTF8ByteArray(bArr);
    }

    public String getNotationValue() {
        return Strings.fromUTF8ByteArray(getNotationValueBytes());
    }

    public byte[] getNotationValueBytes() {
        int i = (this.data[4] << 8) + (this.data[5] << 0);
        int i2 = (this.data[6] << 8) + (this.data[7] << 0);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.data, i + 8, bArr, 0, i2);
        return bArr;
    }

    public boolean isHumanReadable() {
        return this.data[0] == Byte.MIN_VALUE;
    }
}
