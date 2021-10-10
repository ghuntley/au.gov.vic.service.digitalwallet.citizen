package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

public class PublicKeyPacket extends ContainedPacket implements PublicKeyAlgorithmTags {
    private int algorithm;
    private BCPGKey key;
    private long time;
    private int validDays;
    private int version;

    public PublicKeyPacket(int i, Date date, BCPGKey bCPGKey) {
        this.version = 4;
        this.time = date.getTime() / 1000;
        this.algorithm = i;
        this.key = bCPGKey;
    }

    PublicKeyPacket(BCPGInputStream bCPGInputStream) throws IOException {
        BCPGKey bCPGKey;
        this.version = bCPGInputStream.read();
        this.time = (((long) bCPGInputStream.read()) << 24) | ((long) (bCPGInputStream.read() << 16)) | ((long) (bCPGInputStream.read() << 8)) | ((long) bCPGInputStream.read());
        if (this.version <= 3) {
            this.validDays = (bCPGInputStream.read() << 8) | bCPGInputStream.read();
        }
        byte read = (byte) bCPGInputStream.read();
        this.algorithm = read;
        if (read == 1 || read == 2 || read == 3) {
            bCPGKey = new RSAPublicBCPGKey(bCPGInputStream);
        } else {
            if (read != 16) {
                if (read == 17) {
                    bCPGKey = new DSAPublicBCPGKey(bCPGInputStream);
                } else if (read != 20) {
                    throw new IOException("unknown PGP public key algorithm encountered");
                }
            }
            bCPGKey = new ElGamalPublicBCPGKey(bCPGInputStream);
        }
        this.key = bCPGKey;
    }

    @Override // org.bouncycastle.bcpg.ContainedPacket
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writePacket(6, getEncodedContents(), true);
    }

    public int getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncodedContents() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
        bCPGOutputStream.write(this.version);
        bCPGOutputStream.write((byte) ((int) (this.time >> 24)));
        bCPGOutputStream.write((byte) ((int) (this.time >> 16)));
        bCPGOutputStream.write((byte) ((int) (this.time >> 8)));
        bCPGOutputStream.write((byte) ((int) this.time));
        if (this.version <= 3) {
            bCPGOutputStream.write((byte) (this.validDays >> 8));
            bCPGOutputStream.write((byte) this.validDays);
        }
        bCPGOutputStream.write(this.algorithm);
        bCPGOutputStream.writeObject((BCPGObject) this.key);
        return byteArrayOutputStream.toByteArray();
    }

    public BCPGKey getKey() {
        return this.key;
    }

    public Date getTime() {
        return new Date(this.time * 1000);
    }

    public int getValidDays() {
        return this.validDays;
    }

    public int getVersion() {
        return this.version;
    }
}
