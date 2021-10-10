package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SymmetricKeyEncSessionPacket extends ContainedPacket {
    private int encAlgorithm;
    private S2K s2k;
    private byte[] secKeyData;
    private int version;

    public SymmetricKeyEncSessionPacket(int i, S2K s2k2, byte[] bArr) {
        this.version = 4;
        this.encAlgorithm = i;
        this.s2k = s2k2;
        this.secKeyData = bArr;
    }

    public SymmetricKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
        this.encAlgorithm = bCPGInputStream.read();
        this.s2k = new S2K(bCPGInputStream);
        if (bCPGInputStream.available() != 0) {
            byte[] bArr = new byte[bCPGInputStream.available()];
            this.secKeyData = bArr;
            bCPGInputStream.readFully(bArr, 0, bArr.length);
        }
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        bCPGOutputStream2.write(this.encAlgorithm);
        bCPGOutputStream2.writeObject(this.s2k);
        byte[] bArr = this.secKeyData;
        if (bArr != null && bArr.length > 0) {
            bCPGOutputStream2.write(bArr);
        }
        bCPGOutputStream.writePacket(3, byteArrayOutputStream.toByteArray(), true);
    }

    public int getEncAlgorithm() {
        return this.encAlgorithm;
    }

    public S2K getS2K() {
        return this.s2k;
    }

    public byte[] getSecKeyData() {
        return this.secKeyData;
    }

    public int getVersion() {
        return this.version;
    }
}
