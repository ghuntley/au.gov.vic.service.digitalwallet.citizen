package org.bouncycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class TlsMac {
    protected HMac mac;
    protected long seqNo = 0;

    public TlsMac(Digest digest, byte[] bArr, int i, int i2) {
        this.mac = new HMac(digest);
        this.mac.init(new KeyParameter(bArr, i, i2));
    }

    public byte[] calculateMac(short s, byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(13);
        try {
            long j = this.seqNo;
            this.seqNo = 1 + j;
            TlsUtils.writeUint64(j, byteArrayOutputStream);
            TlsUtils.writeUint8(s, byteArrayOutputStream);
            TlsUtils.writeVersion(byteArrayOutputStream);
            TlsUtils.writeUint16(i2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.mac.update(byteArray, 0, byteArray.length);
            this.mac.update(bArr, i, i2);
            byte[] bArr2 = new byte[this.mac.getMacSize()];
            this.mac.doFinal(bArr2, 0);
            return bArr2;
        } catch (IOException unused) {
            throw new IllegalStateException("Internal error during mac calculation");
        }
    }

    public int getSize() {
        return this.mac.getMacSize();
    }
}
