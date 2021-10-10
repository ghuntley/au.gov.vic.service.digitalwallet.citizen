package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class PublicKeyEncSessionPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private int algorithm;
    private BigInteger[] data;
    private long keyID;
    private int version;

    public PublicKeyEncSessionPacket(long j, int i, BigInteger[] bigIntegerArr) {
        this.version = 3;
        this.keyID = j;
        this.algorithm = i;
        this.data = bigIntegerArr;
    }

    PublicKeyEncSessionPacket(BCPGInputStream bCPGInputStream) throws IOException {
        this.version = bCPGInputStream.read();
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
        int read8 = bCPGInputStream.read();
        this.algorithm = read8;
        if (read8 == 1 || read8 == 2) {
            BigInteger[] bigIntegerArr = new BigInteger[1];
            this.data = bigIntegerArr;
            bigIntegerArr[0] = new MPInteger(bCPGInputStream).getValue();
        } else if (read8 == 16 || read8 == 20) {
            BigInteger[] bigIntegerArr2 = new BigInteger[2];
            this.data = bigIntegerArr2;
            bigIntegerArr2[0] = new MPInteger(bCPGInputStream).getValue();
            this.data[1] = new MPInteger(bCPGInputStream).getValue();
        } else {
            throw new IOException("unknown PGP public key algorithm encountered");
        }
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream2 = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream2.write(this.version);
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 56)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 48)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 40)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 32)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 24)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 16)));
        bCPGOutputStream2.write((byte) ((int) (this.keyID >> 8)));
        bCPGOutputStream2.write((byte) ((int) this.keyID));
        bCPGOutputStream2.write(this.algorithm);
        int i = 0;
        while (true) {
            BigInteger[] bigIntegerArr = this.data;
            if (i != bigIntegerArr.length) {
                bCPGOutputStream2.writeObject(new MPInteger(bigIntegerArr[i]));
                i++;
            } else {
                bCPGOutputStream.writePacket(1, byteArrayOutputStream.toByteArray(), true);
                return;
            }
        }
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public BigInteger[] getEncSessionKey() {
        return this.data;
    }

    public long getKeyID() {
        return this.keyID;
    }

    public int getVersion() {
        return this.version;
    }
}
