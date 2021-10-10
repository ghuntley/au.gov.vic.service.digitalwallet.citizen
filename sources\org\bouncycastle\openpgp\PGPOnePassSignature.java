package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.OnePassSignaturePacket;

public class PGPOnePassSignature {
    private byte lastb;
    private Signature sig;
    private OnePassSignaturePacket sigPack;
    private int signatureType;

    PGPOnePassSignature(BCPGInputStream bCPGInputStream) throws IOException, PGPException {
        this((OnePassSignaturePacket) bCPGInputStream.readPacket());
    }

    PGPOnePassSignature(OnePassSignaturePacket onePassSignaturePacket) throws PGPException {
        this.sigPack = onePassSignaturePacket;
        this.signatureType = onePassSignaturePacket.getSignatureType();
    }

    public void encode(OutputStream outputStream) throws IOException {
        (outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream)).writePacket(this.sigPack);
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int getHashAlgorithm() {
        return this.sigPack.getHashAlgorithm();
    }

    public int getKeyAlgorithm() {
        return this.sigPack.getKeyAlgorithm();
    }

    public long getKeyID() {
        return this.sigPack.getKeyID();
    }

    public int getSignatureType() {
        return this.sigPack.getSignatureType();
    }

    public void initVerify(PGPPublicKey pGPPublicKey, String str) throws NoSuchProviderException, PGPException {
        initVerify(pGPPublicKey, PGPUtil.getProvider(str));
    }

    public void initVerify(PGPPublicKey pGPPublicKey, Provider provider) throws PGPException {
        this.lastb = 0;
        try {
            Signature instance = Signature.getInstance(PGPUtil.getSignatureName(this.sigPack.getKeyAlgorithm(), this.sigPack.getHashAlgorithm()), provider);
            this.sig = instance;
            try {
                instance.initVerify(pGPPublicKey.getKey(provider));
            } catch (InvalidKeyException e) {
                throw new PGPException("invalid key.", e);
            }
        } catch (Exception e2) {
            throw new PGPException("can't set up signature object.", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        if (r3.lastb != 13) goto L_0x000b;
     */
    public void update(byte b) throws SignatureException {
        if (this.signatureType == 1) {
            if (b != 13) {
                if (b != 10) {
                    this.sig.update(b);
                }
                this.lastb = b;
                return;
            }
            this.sig.update((byte) 13);
            this.sig.update((byte) 10);
            this.lastb = b;
            return;
        }
        this.sig.update(b);
    }

    public void update(byte[] bArr) throws SignatureException {
        if (this.signatureType == 1) {
            for (int i = 0; i != bArr.length; i++) {
                update(bArr[i]);
            }
            return;
        }
        this.sig.update(bArr);
    }

    public void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.signatureType == 1) {
            int i3 = i2 + i;
            while (i != i3) {
                update(bArr[i]);
                i++;
            }
            return;
        }
        this.sig.update(bArr, i, i2);
    }

    public boolean verify(PGPSignature pGPSignature) throws PGPException, SignatureException {
        this.sig.update(pGPSignature.getSignatureTrailer());
        return this.sig.verify(pGPSignature.getSignature());
    }
}
