package org.bouncycastle.bcpg.sig;

import java.util.Date;
import kotlin.UByte;
import org.bouncycastle.bcpg.SignatureSubpacket;

public class SignatureCreationTime extends SignatureSubpacket {
    public SignatureCreationTime(boolean z, Date date) {
        super(2, z, timeToBytes(date));
    }

    public SignatureCreationTime(boolean z, byte[] bArr) {
        super(2, z, bArr);
    }

    protected static byte[] timeToBytes(Date date) {
        long time = date.getTime() / 1000;
        return new byte[]{(byte) ((int) (time >> 24)), (byte) ((int) (time >> 16)), (byte) ((int) (time >> 8)), (byte) ((int) time)};
    }

    public Date getTime() {
        return new Date(((((long) (this.data[0] & UByte.MAX_VALUE)) << 24) | ((long) ((this.data[1] & UByte.MAX_VALUE) << 16)) | ((long) ((this.data[2] & UByte.MAX_VALUE) << 8)) | ((long) (this.data[3] & UByte.MAX_VALUE))) * 1000);
    }
}
