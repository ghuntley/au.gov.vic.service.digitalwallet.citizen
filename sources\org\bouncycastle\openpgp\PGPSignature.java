package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Date;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.SignaturePacket;
import org.bouncycastle.bcpg.SignatureSubpacket;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.bcpg.UserAttributeSubpacket;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;

public class PGPSignature {
    public static final int BINARY_DOCUMENT = 0;
    public static final int CANONICAL_TEXT_DOCUMENT = 1;
    public static final int CASUAL_CERTIFICATION = 18;
    public static final int CERTIFICATION_REVOCATION = 48;
    public static final int DEFAULT_CERTIFICATION = 16;
    public static final int DIRECT_KEY = 31;
    public static final int KEY_REVOCATION = 32;
    public static final int NO_CERTIFICATION = 17;
    public static final int POSITIVE_CERTIFICATION = 19;
    public static final int PRIMARYKEY_BINDING = 25;
    public static final int STAND_ALONE = 2;
    public static final int SUBKEY_BINDING = 24;
    public static final int SUBKEY_REVOCATION = 40;
    public static final int TIMESTAMP = 64;
    private byte lastb;
    private Signature sig;
    private SignaturePacket sigPck;
    private int signatureType;
    private TrustPacket trustPck;

    PGPSignature(BCPGInputStream bCPGInputStream) throws IOException, PGPException {
        this((SignaturePacket) bCPGInputStream.readPacket());
    }

    PGPSignature(SignaturePacket signaturePacket) throws PGPException {
        this.sigPck = signaturePacket;
        this.signatureType = signaturePacket.getSignatureType();
        this.trustPck = null;
    }

    PGPSignature(SignaturePacket signaturePacket, TrustPacket trustPacket) throws PGPException {
        this(signaturePacket);
        this.trustPck = trustPacket;
    }

    private PGPSignatureSubpacketVector createSubpacketVector(SignatureSubpacket[] signatureSubpacketArr) {
        if (signatureSubpacketArr != null) {
            return new PGPSignatureSubpacketVector(signatureSubpacketArr);
        }
        return null;
    }

    private byte[] getEncodedPublicKey(PGPPublicKey pGPPublicKey) throws PGPException {
        try {
            return pGPPublicKey.publicPk.getEncodedContents();
        } catch (IOException e) {
            throw new PGPException("exception preparing key.", e);
        }
    }

    private void getSig(Provider provider) throws PGPException {
        try {
            this.sig = Signature.getInstance(PGPUtil.getSignatureName(this.sigPck.getKeyAlgorithm(), this.sigPck.getHashAlgorithm()), provider);
        } catch (Exception e) {
            throw new PGPException("can't set up signature object.", e);
        }
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

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.sigPck);
        TrustPacket trustPacket = this.trustPck;
        if (trustPacket != null) {
            bCPGOutputStream.writePacket(trustPacket);
        }
    }

    public Date getCreationTime() {
        return new Date(this.sigPck.getCreationTime());
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int getHashAlgorithm() {
        return this.sigPck.getHashAlgorithm();
    }

    public PGPSignatureSubpacketVector getHashedSubPackets() {
        return createSubpacketVector(this.sigPck.getHashedSubPackets());
    }

    public int getKeyAlgorithm() {
        return this.sigPck.getKeyAlgorithm();
    }

    public long getKeyID() {
        return this.sigPck.getKeyID();
    }

    public byte[] getSignature() throws PGPException {
        MPInteger[] signature = this.sigPck.getSignature();
        if (signature == null) {
            return this.sigPck.getSignatureBytes();
        }
        if (signature.length == 1) {
            return BigIntegers.asUnsignedByteArray(signature[0].getValue());
        }
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new DERInteger(signature[0].getValue()));
            aSN1EncodableVector.add(new DERInteger(signature[1].getValue()));
            return new DERSequence(aSN1EncodableVector).getEncoded();
        } catch (IOException e) {
            throw new PGPException("exception encoding DSA sig.", e);
        }
    }

    public byte[] getSignatureTrailer() {
        return this.sigPck.getSignatureTrailer();
    }

    public int getSignatureType() {
        return this.sigPck.getSignatureType();
    }

    public PGPSignatureSubpacketVector getUnhashedSubPackets() {
        return createSubpacketVector(this.sigPck.getUnhashedSubPackets());
    }

    public int getVersion() {
        return this.sigPck.getVersion();
    }

    public boolean hasSubpackets() {
        return (this.sigPck.getHashedSubPackets() == null && this.sigPck.getUnhashedSubPackets() == null) ? false : true;
    }

    public void initVerify(PGPPublicKey pGPPublicKey, String str) throws NoSuchProviderException, PGPException {
        initVerify(pGPPublicKey, PGPUtil.getProvider(str));
    }

    public void initVerify(PGPPublicKey pGPPublicKey, Provider provider) throws PGPException {
        if (this.sig == null) {
            getSig(provider);
        }
        try {
            this.sig.initVerify(pGPPublicKey.getKey(provider));
            this.lastb = 0;
        } catch (InvalidKeyException e) {
            throw new PGPException("invalid key.", e);
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
    }

    public boolean verify() throws PGPException, SignatureException {
        this.sig.update(getSignatureTrailer());
        return this.sig.verify(getSignature());
    }

    public boolean verifyCertification(String str, PGPPublicKey pGPPublicKey) throws PGPException, SignatureException {
        updateWithPublicKey(pGPPublicKey);
        updateWithIdData(180, Strings.toByteArray(str));
        update(this.sigPck.getSignatureTrailer());
        return this.sig.verify(getSignature());
    }

    public boolean verifyCertification(PGPPublicKey pGPPublicKey) throws SignatureException, PGPException {
        if (getSignatureType() == 32 || getSignatureType() == 40) {
            updateWithPublicKey(pGPPublicKey);
            update(this.sigPck.getSignatureTrailer());
            return this.sig.verify(getSignature());
        }
        throw new IllegalStateException("signature is not a key signature");
    }

    public boolean verifyCertification(PGPPublicKey pGPPublicKey, PGPPublicKey pGPPublicKey2) throws SignatureException, PGPException {
        updateWithPublicKey(pGPPublicKey);
        updateWithPublicKey(pGPPublicKey2);
        update(this.sigPck.getSignatureTrailer());
        return this.sig.verify(getSignature());
    }

    public boolean verifyCertification(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPPublicKey pGPPublicKey) throws PGPException, SignatureException {
        updateWithPublicKey(pGPPublicKey);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            UserAttributeSubpacket[] subpacketArray = pGPUserAttributeSubpacketVector.toSubpacketArray();
            for (int i = 0; i != subpacketArray.length; i++) {
                subpacketArray[i].encode(byteArrayOutputStream);
            }
            updateWithIdData(209, byteArrayOutputStream.toByteArray());
            update(this.sigPck.getSignatureTrailer());
            return this.sig.verify(getSignature());
        } catch (IOException e) {
            throw new PGPException("cannot encode subpacket array", e);
        }
    }
}
