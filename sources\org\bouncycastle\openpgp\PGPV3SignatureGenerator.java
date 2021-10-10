package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Date;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.OnePassSignaturePacket;
import org.bouncycastle.bcpg.SignaturePacket;

public class PGPV3SignatureGenerator {
    private MessageDigest dig;
    private int hashAlgorithm;
    private int keyAlgorithm;
    private byte lastb;
    private PGPPrivateKey privKey;
    private Signature sig;
    private int signatureType;

    public PGPV3SignatureGenerator(int i, int i2, String str) throws NoSuchAlgorithmException, NoSuchProviderException, PGPException {
        this(i, i2, PGPUtil.getProvider(str));
    }

    public PGPV3SignatureGenerator(int i, int i2, Provider provider) throws NoSuchAlgorithmException, PGPException {
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
        this.dig = PGPUtil.getDigestInstance(PGPUtil.getDigestName(i2), provider);
        this.sig = Signature.getInstance(PGPUtil.getSignatureName(i, i2), provider);
    }

    public PGPSignature generate() throws PGPException, SignatureException {
        long time = new Date().getTime() / 1000;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(this.signatureType);
        byteArrayOutputStream.write((byte) ((int) (time >> 24)));
        byteArrayOutputStream.write((byte) ((int) (time >> 16)));
        byteArrayOutputStream.write((byte) ((int) (time >> 8)));
        byteArrayOutputStream.write((byte) ((int) time));
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.sig.update(byteArray);
        this.dig.update(byteArray);
        int i = this.keyAlgorithm;
        MPInteger[] dsaSigToMpi = (i == 3 || i == 1) ? new MPInteger[]{new MPInteger(new BigInteger(1, this.sig.sign()))} : PGPUtil.dsaSigToMpi(this.sig.sign());
        byte[] digest = this.dig.digest();
        return new PGPSignature(new SignaturePacket(3, this.signatureType, this.privKey.getKeyID(), this.keyAlgorithm, this.hashAlgorithm, time * 1000, new byte[]{digest[0], digest[1]}, dsaSigToMpi));
    }

    public PGPOnePassSignature generateOnePassVersion(boolean z) throws PGPException {
        return new PGPOnePassSignature(new OnePassSignaturePacket(this.signatureType, this.hashAlgorithm, this.keyAlgorithm, this.privKey.getKeyID(), z));
    }

    public void initSign(int i, PGPPrivateKey pGPPrivateKey) throws PGPException {
        initSign(i, pGPPrivateKey, null);
    }

    public void initSign(int i, PGPPrivateKey pGPPrivateKey, SecureRandom secureRandom) throws PGPException {
        this.privKey = pGPPrivateKey;
        this.signatureType = i;
        if (secureRandom == null) {
            try {
                this.sig.initSign(pGPPrivateKey.getKey());
            } catch (InvalidKeyException e) {
                throw new PGPException("invalid key.", e);
            }
        } else {
            this.sig.initSign(pGPPrivateKey.getKey(), secureRandom);
        }
        this.dig.reset();
        this.lastb = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r3.lastb != 13) goto L_0x000b;
     */
    public void update(byte b) throws SignatureException {
        if (this.signatureType == 1) {
            if (b != 13) {
                if (b != 10) {
                    this.sig.update(b);
                    this.dig.update(b);
                }
                this.lastb = b;
                return;
            }
            this.sig.update((byte) 13);
            this.sig.update((byte) 10);
            this.dig.update((byte) 13);
            this.dig.update((byte) 10);
            this.lastb = b;
            return;
        }
        this.sig.update(b);
        this.dig.update(b);
    }

    public void update(byte[] bArr) throws SignatureException {
        update(bArr, 0, bArr.length);
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
        this.dig.update(bArr, i, i2);
    }
}
