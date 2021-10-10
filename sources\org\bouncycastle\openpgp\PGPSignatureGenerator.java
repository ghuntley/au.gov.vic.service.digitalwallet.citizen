package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.bcpg.sig.IssuerKeyID;
import org.bouncycastle.bcpg.sig.SignatureCreationTime;
import org.bouncycastle.util.Strings;

public class PGPSignatureGenerator {
    private MessageDigest dig;
    private int hashAlgorithm;
    SignatureSubpacket[] hashed;
    private int keyAlgorithm;
    private byte lastb;
    private PGPPrivateKey privKey;
    private Signature sig;
    private int signatureType;
    SignatureSubpacket[] unhashed;

    public PGPSignatureGenerator(int i, int i2, String str) throws NoSuchAlgorithmException, NoSuchProviderException, PGPException {
        this(i, str, i2, str);
    }

    public PGPSignatureGenerator(int i, int i2, Provider provider) throws NoSuchAlgorithmException, PGPException {
        this(i, provider, i2, provider);
    }

    public PGPSignatureGenerator(int i, String str, int i2, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, PGPException {
        this(i, PGPUtil.getProvider(str), i2, PGPUtil.getProvider(str2));
    }

    public PGPSignatureGenerator(int i, Provider provider, int i2, Provider provider2) throws NoSuchAlgorithmException, PGPException {
        this.unhashed = new SignatureSubpacket[0];
        this.hashed = new SignatureSubpacket[0];
        this.keyAlgorithm = i;
        this.hashAlgorithm = i2;
        this.dig = PGPUtil.getDigestInstance(PGPUtil.getDigestName(i2), provider2);
        this.sig = Signature.getInstance(PGPUtil.getSignatureName(i, i2), provider);
    }

    private byte[] getEncodedPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        try {
            return pGPPublicKey.publicPk.getEncodedContents();
        } catch (IOException e) {
            throw new PGPException("exception preparing key.", e);
        }
    }

    private SignatureSubpacket[] insertSubpacket(SignatureSubpacket[] signatureSubpacketArr, SignatureSubpacket signatureSubpacket) {
        SignatureSubpacket[] signatureSubpacketArr2 = new SignatureSubpacket[(signatureSubpacketArr.length + 1)];
        signatureSubpacketArr2[0] = signatureSubpacket;
        System.arraycopy(signatureSubpacketArr, 0, signatureSubpacketArr2, 1, signatureSubpacketArr.length);
        return signatureSubpacketArr2;
    }

    private boolean packetPresent(SignatureSubpacket[] signatureSubpacketArr, int i) {
        for (int i2 = 0; i2 != signatureSubpacketArr.length; i2++) {
            if (signatureSubpacketArr[i2].getType() == i) {
                return true;
            }
        }
        return false;
    }

    private void updateWithIdData(int i, byte[] bArr) throws SignatureException {
        update((byte) i);
        update((byte) (bArr.length >> 24));
        update((byte) (bArr.length >> 16));
        update((byte) (bArr.length >> 8));
        update((byte) bArr.length);
        update(bArr);
    }

    private void updateWithPublicKey(PGPPublicKey pGPPublicKey) throws PGPException, SignatureException {
        byte[] encodedPublicKey = getEncodedPublicKey(pGPPublicKey);
        update((byte) -103);
        update((byte) (encodedPublicKey.length >> 8));
        update((byte) encodedPublicKey.length);
        update(encodedPublicKey);
    }

    public PGPSignature generate() throws PGPException, SignatureException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        SignatureSubpacket[] insertSubpacket = !packetPresent(this.hashed, 2) ? insertSubpacket(this.hashed, new SignatureCreationTime(false, new Date())) : this.hashed;
        SignatureSubpacket[] insertSubpacket2 = (packetPresent(this.hashed, 16) || packetPresent(this.unhashed, 16)) ? this.unhashed : insertSubpacket(this.unhashed, new IssuerKeyID(false, this.privKey.getKeyID()));
        byte b = (byte) 4;
        try {
            byteArrayOutputStream.write(b);
            byteArrayOutputStream.write((byte) this.signatureType);
            byteArrayOutputStream.write((byte) this.keyAlgorithm);
            byteArrayOutputStream.write((byte) this.hashAlgorithm);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (int i = 0; i != insertSubpacket.length; i++) {
                insertSubpacket[i].encode(byteArrayOutputStream2);
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            byteArrayOutputStream.write((byte) (byteArray.length >> 8));
            byteArrayOutputStream.write((byte) byteArray.length);
            byteArrayOutputStream.write(byteArray);
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.write(b);
            byteArrayOutputStream.write(-1);
            byteArrayOutputStream.write((byte) (byteArray2.length >> 24));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 16));
            byteArrayOutputStream.write((byte) (byteArray2.length >> 8));
            byteArrayOutputStream.write((byte) byteArray2.length);
            byte[] byteArray3 = byteArrayOutputStream.toByteArray();
            this.sig.update(byteArray3);
            this.dig.update(byteArray3);
            int i2 = this.keyAlgorithm;
            MPInteger[] dsaSigToMpi = (i2 == 3 || i2 == 1) ? new MPInteger[]{new MPInteger(new BigInteger(1, this.sig.sign()))} : PGPUtil.dsaSigToMpi(this.sig.sign());
            byte[] digest = this.dig.digest();
            return new PGPSignature(new SignaturePacket(this.signatureType, this.privKey.getKeyID(), this.keyAlgorithm, this.hashAlgorithm, insertSubpacket, insertSubpacket2, new byte[]{digest[0], digest[1]}, dsaSigToMpi));
        } catch (IOException e) {
            throw new PGPException("exception encoding hashed data.", e);
        }
    }

    public PGPSignature generateCertification(String str, PGPPublicKey pGPPublicKey) throws SignatureException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        updateWithIdData(180, Strings.toByteArray(str));
        return generate();
    }

    public PGPSignature generateCertification(PGPPublicKey pGPPublicKey) throws SignatureException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        return generate();
    }

    public PGPSignature generateCertification(PGPPublicKey pGPPublicKey, PGPPublicKey pGPPublicKey2) throws SignatureException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        updateWithPublicKey(pGPPublicKey2);
        return generate();
    }

    public PGPSignature generateCertification(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPPublicKey pGPPublicKey) throws SignatureException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            UserAttributeSubpacket[] subpacketArray = pGPUserAttributeSubpacketVector.toSubpacketArray();
            for (int i = 0; i != subpacketArray.length; i++) {
                subpacketArray[i].encode(byteArrayOutputStream);
            }
            updateWithIdData(209, byteArrayOutputStream.toByteArray());
            return generate();
        } catch (IOException e) {
            throw new PGPException("cannot encode subpacket array", e);
        }
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

    public void setHashedSubpackets(PGPSignatureSubpacketVector pGPSignatureSubpacketVector) {
        if (pGPSignatureSubpacketVector == null) {
            this.hashed = new SignatureSubpacket[0];
        } else {
            this.hashed = pGPSignatureSubpacketVector.toSubpacketArray();
        }
    }

    public void setUnhashedSubpackets(PGPSignatureSubpacketVector pGPSignatureSubpacketVector) {
        if (pGPSignatureSubpacketVector == null) {
            this.unhashed = new SignatureSubpacket[0];
        } else {
            this.unhashed = pGPSignatureSubpacketVector.toSubpacketArray();
        }
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
