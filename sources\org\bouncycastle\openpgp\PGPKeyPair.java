package org.bouncycastle.openpgp;

import java.security.KeyPair;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;

public class PGPKeyPair {
    PGPPrivateKey priv;
    PGPPublicKey pub;

    public PGPKeyPair(int i, KeyPair keyPair, Date date) throws PGPException {
        this(i, keyPair.getPublic(), keyPair.getPrivate(), date);
    }

    public PGPKeyPair(int i, KeyPair keyPair, Date date, String str) throws PGPException, NoSuchProviderException {
        this(i, keyPair.getPublic(), keyPair.getPrivate(), date, str);
    }

    public PGPKeyPair(int i, PublicKey publicKey, PrivateKey privateKey, Date date) throws PGPException {
        PGPPublicKey pGPPublicKey = new PGPPublicKey(i, publicKey, date);
        this.pub = pGPPublicKey;
        this.priv = new PGPPrivateKey(privateKey, pGPPublicKey.getKeyID());
    }

    public PGPKeyPair(int i, PublicKey publicKey, PrivateKey privateKey, Date date, String str) throws PGPException, NoSuchProviderException {
        this(i, publicKey, privateKey, date);
    }

    public PGPKeyPair(PGPPublicKey pGPPublicKey, PGPPrivateKey pGPPrivateKey) {
        this.pub = pGPPublicKey;
        this.priv = pGPPrivateKey;
    }

    public long getKeyID() {
        return this.pub.getKeyID();
    }

    public PGPPrivateKey getPrivateKey() {
        return this.priv;
    }

    public PGPPublicKey getPublicKey() {
        return this.pub;
    }
}
