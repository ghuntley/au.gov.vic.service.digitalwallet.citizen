package org.bouncycastle.bcpg;

import java.io.IOException;

public class ModDetectionCodePacket extends ContainedPacket {
    private byte[] digest;

    ModDetectionCodePacket(BCPGInputStream bCPGInputStream) throws IOException {
        byte[] bArr = new byte[20];
        this.digest = bArr;
        bCPGInputStream.readFully(bArr);
    }

    public ModDetectionCodePacket(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[bArr.length];
        this.digest = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(19, this.digest, false);
    }

    public byte[] getDigest() {
        byte[] bArr = this.digest;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
