package org.bouncycastle.bcpg.sig;

import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class KeyExpirationTime extends SignatureSubpacket {
    public KeyExpirationTime(boolean z, long j) {
        super(9, z, timeToBytes(j));
    }

    public KeyExpirationTime(boolean z, byte[] bArr) {
        super(9, z, bArr);
    }

    protected static byte[] timeToBytes(long j) {
        return new byte[]{(byte) ((int) (j >> 24)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 8)), (byte) ((int) j)};
    }

    public long getTime() {
        return (((long) (this.data[0] & UByte.MAX_VALUE)) << 24) | ((long) ((this.data[1] & UByte.MAX_VALUE) << 16)) | ((long) ((this.data[2] & UByte.MAX_VALUE) << 8)) | ((long) (this.data[3] & UByte.MAX_VALUE));
    }
}
