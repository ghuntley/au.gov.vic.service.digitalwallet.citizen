package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OnePassSignaturePacket extends ContainedPacket {
    private int hashAlgorithm;
    private int keyAlgorithm;
    private long keyID;
    private int nested;
    private int sigType;
    private int version;

    public OnePassSignaturePacket(int i, int i2, int i3, long j, boolean z) {
        this.version = 3;
        this.sigType = i;
        this.hashAlgorithm = i2;
        this.keyAlgorithm = i3;
        this.keyID = j;
        this.nested = !z ? 1 : 0;
    }

    OnePassSignaturePacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
        this.sigType = bCPGInputStream.read();
        this.hashAlgorithm = bCPGInputStream.read();
        this.keyAlgorithm = bCPGInputStream.read();
        long read = this.keyID | (((long) bCPGInputStream.read()) << 56);
        this.keyID = read;
        long read2 = read | (((long) bCPGInputStream.read()) << 48);
        this.keyID = read2;
        long read3 = read2 | (((long) bCPGInputStream.read()) << 40);
        this.keyID = read3;
        long read4 = read3 | (((long) bCPGInputStream.read()) << 32);
        this.keyID = read4;
        long read5 = read4 | (((long) bCPGInputStream.read()) << 24);
        this.keyID = read5;
        long read6 = read5 | (((long) bCPGInputStream.read()) << 16);
        this.keyID = read6;
        long read7 = read6 | (((long) bCPGInputStream.read()) << 8);
        this.keyID = read7;
        this.keyID = read7 | ((long) bCPGInputStream.read());
        this.nested = bCPGInputStream.read();
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        bCPGOutputStream2.write(this.sigType);
        bCPGOutputStream2.write(this.hashAlgorithm);
        bCPGOutputStream2.write(this.keyAlgorithm);
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 56)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 48)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 40)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 32)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 24)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 16)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 8)));
        bCPGOutputStream2.write((byte) ((int) this.keyID));
        bCPGOutputStream2.write(this.nested);
        bCPGOutputStream.writePacket(4, byteArrayOutputStream.toByteArray(), true);
    }

    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public int getKeyAlgorithm() {
        return this.keyAlgorithm;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public int getSignatureType() {
        return this.sigType;
    }
}
