package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ExperimentalPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private byte[] contents;
    private int tag;

    ExperimentalPacket(int i, BCPGInputStream bCPGInputStream) throws IOException {
        this.tag = i;
        if (bCPGInputStream.available() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bCPGInputStream.available());
            while (true) {
                int read = bCPGInputStream.read();
                if (read >= 0) {
                    byteArrayOutputStream.write(read);
                } else {
                    this.contents = byteArrayOutputStream.toByteArray();
                    return;
                }
            }
        } else {
            this.contents = new byte[0];
        }
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(this.tag, this.contents, true);
    }

    public byte[] getContents() {
        byte[] bArr = this.contents;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public int getTag() {
        return this.tag;
    }
}
