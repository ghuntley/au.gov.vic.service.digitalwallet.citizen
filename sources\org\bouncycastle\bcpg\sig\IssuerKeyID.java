package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class IssuerKeyID extends SignatureSubpacket {
    public IssuerKeyID(boolean z, long j) {
        super(16, z, keyIDToBytes(j));
    }

    public IssuerKeyID(boolean z, byte[] bArr) {
        super(16, z, bArr);
    }

    protected static byte[] keyIDToBytes(long j) {
        return new byte[]{(byte) ((int) (j >> 56)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)};
    }

    public long getKeyID() {
        return (((long) (this.data[0] & UByte.MAX_VALUE)) << 56) | (((long) (this.data[1] & UByte.MAX_VALUE)) << 48) | (((long) (this.data[2] & UByte.MAX_VALUE)) << 40) | (((long) (this.data[3] & UByte.MAX_VALUE)) << 32) | (((long) (this.data[4] & UByte.MAX_VALUE)) << 24) | ((long) ((this.data[5] & UByte.MAX_VALUE) << 16)) | ((long) ((this.data[6] & UByte.MAX_VALUE) << 8)) | ((long) (this.data[7] & UByte.MAX_VALUE));
    }
}
