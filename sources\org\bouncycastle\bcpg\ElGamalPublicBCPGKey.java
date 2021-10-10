package org.bouncycastle.bcpg;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class ElGamalPublicBCPGKey extends BCPGObject implements BCPGKey {
    MPInteger g;
    MPInteger p;
    MPInteger y;

    public ElGamalPublicBCPGKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.p = new MPInteger(bigInteger);
        this.g = new MPInteger(bigInteger2);
        this.y = new MPInteger(bigInteger3);
    }

    public ElGamalPublicBCPGKey(BCPGInputStream bCPGInputStream) throws IOException {
        this.p = new MPInteger(bCPGInputStream);
        this.g = new MPInteger(bCPGInputStream);
        this.y = new MPInteger(bCPGInputStream);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject
    public void encode(BCPGOutputStream bCPGOutputStream) throws IOException {
        bCPGOutputStream.writeObject(this.p);
        bCPGOutputStream.writeObject(this.g);
        bCPGOutputStream.writeObject(this.y);
    }

    @Override // org.bouncycastle.bcpg.BCPGObject, org.bouncycastle.bcpg.BCPGKey
    public byte[] getEncoded() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new BCPGOutputStream(byteArrayOutputStream).writeObject(this);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.bcpg.BCPGKey
    public String getFormat() {
        return "PGP";
    }

    public BigInteger getG() {
        return this.g.getValue();
    }

    public BigInteger getP() {
        return this.p.getValue();
    }

    public BigInteger getY() {
        return this.y.getValue();
    }
}
