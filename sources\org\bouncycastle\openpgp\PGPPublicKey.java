package org.bouncycastle.openpgp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.UByte;
import org.bouncycastle.bcpg.BCPGKey;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.MPInteger;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.TrustPacket;
import org.bouncycastle.bcpg.UserAttributePacket;
import org.bouncycastle.bcpg.UserIDPacket;
import org.bouncycastle.jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPublicKeySpec;
import org.bouncycastle.util.Arrays;

public class PGPPublicKey implements PublicKeyAlgorithmTags {
    private static final int[] MASTER_KEY_CERTIFICATION_TYPES = {19, 18, 17, 16};
    private byte[] fingerprint;
    List idSigs;
    List idTrusts;
    List ids;
    private long keyID;
    List keySigs;
    private int keyStrength;
    PublicKeyPacket publicPk;
    List subSigs;
    TrustPacket trustPk;

    public PGPPublicKey(int i, PublicKey publicKey, Date date) throws PGPException {
        BCPGKey bCPGKey;
        BCPGKey elGamalPublicBCPGKey;
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        if (publicKey instanceof RSAPublicKey) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
            bCPGKey = new RSAPublicBCPGKey(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        } else {
            if (publicKey instanceof DSAPublicKey) {
                DSAPublicKey dSAPublicKey = (DSAPublicKey) publicKey;
                DSAParams params = dSAPublicKey.getParams();
                elGamalPublicBCPGKey = new DSAPublicBCPGKey(params.getP(), params.getQ(), params.getG(), dSAPublicKey.getY());
            } else if (publicKey instanceof ElGamalPublicKey) {
                ElGamalPublicKey elGamalPublicKey = (ElGamalPublicKey) publicKey;
                ElGamalParameterSpec parameters = elGamalPublicKey.getParameters();
                elGamalPublicBCPGKey = new ElGamalPublicBCPGKey(parameters.getP(), parameters.getG(), elGamalPublicKey.getY());
            } else {
                throw new PGPException("unknown key class");
            }
            bCPGKey = elGamalPublicBCPGKey;
        }
        this.publicPk = new PublicKeyPacket(i, date, bCPGKey);
        this.ids = new ArrayList();
        this.idSigs = new ArrayList();
        try {
            init();
        } catch (IOException e) {
            throw new PGPException("exception calculating keyID", e);
        }
    }

    public PGPPublicKey(int i, PublicKey publicKey, Date date, String str) throws PGPException, NoSuchProviderException {
        this(i, publicKey, date);
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, List list, List list2) throws IOException {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = publicKeyPacket;
        this.ids = list;
        this.idSigs = list2;
        init();
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list) throws IOException {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.subSigs = list;
        init();
    }

    PGPPublicKey(PublicKeyPacket publicKeyPacket, TrustPacket trustPacket, List list, List list2, List list3, List list4) throws IOException {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = publicKeyPacket;
        this.trustPk = trustPacket;
        this.keySigs = list;
        this.ids = list2;
        this.idTrusts = list3;
        this.idSigs = list4;
        init();
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = pGPPublicKey.publicPk;
        this.keySigs = new ArrayList(pGPPublicKey.keySigs);
        this.ids = new ArrayList(pGPPublicKey.ids);
        this.idTrusts = new ArrayList(pGPPublicKey.idTrusts);
        this.idSigs = new ArrayList(pGPPublicKey.idSigs.size());
        for (int i = 0; i != pGPPublicKey.idSigs.size(); i++) {
            this.idSigs.add(new ArrayList((ArrayList) pGPPublicKey.idSigs.get(i)));
        }
        if (pGPPublicKey.subSigs != null) {
            this.subSigs = new ArrayList(pGPPublicKey.subSigs.size());
            for (int i2 = 0; i2 != pGPPublicKey.subSigs.size(); i2++) {
                this.subSigs.add(pGPPublicKey.subSigs.get(i2));
            }
        }
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    PGPPublicKey(PGPPublicKey pGPPublicKey, TrustPacket trustPacket, List list) {
        this.keySigs = new ArrayList();
        this.ids = new ArrayList();
        this.idTrusts = new ArrayList();
        this.idSigs = new ArrayList();
        this.subSigs = null;
        this.publicPk = pGPPublicKey.publicPk;
        this.trustPk = trustPacket;
        this.subSigs = list;
        this.fingerprint = pGPPublicKey.fingerprint;
        this.keyID = pGPPublicKey.keyID;
        this.keyStrength = pGPPublicKey.keyStrength;
    }

    private static PGPPublicKey addCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = null;
        for (int i = 0; i != pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                list = (List) pGPPublicKey2.idSigs.get(i);
            }
        }
        if (list != null) {
            list.add(pGPSignature);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(pGPSignature);
            pGPPublicKey2.ids.add(obj);
            pGPPublicKey2.idTrusts.add(null);
            pGPPublicKey2.idSigs.add(arrayList);
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, str, pGPSignature);
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        if (pGPPublicKey.isMasterKey()) {
            if (pGPSignature.getSignatureType() == 40) {
                throw new IllegalArgumentException("signature type incorrect for master key revocation.");
            }
        } else if (pGPSignature.getSignatureType() == 32) {
            throw new IllegalArgumentException("signature type incorrect for sub-key revocation.");
        }
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list == null) {
            list = pGPPublicKey2.keySigs;
        }
        list.add(pGPSignature);
        return pGPPublicKey2;
    }

    public static PGPPublicKey addCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return addCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    private long getExpirationTimeFromSig(boolean z, int i) {
        Iterator signaturesOfType = getSignaturesOfType(i);
        if (!signaturesOfType.hasNext()) {
            return -1;
        }
        PGPSignature pGPSignature = (PGPSignature) signaturesOfType.next();
        if (z && pGPSignature.getKeyID() != getKeyID()) {
            return -1;
        }
        PGPSignatureSubpacketVector hashedSubPackets = pGPSignature.getHashedSubPackets();
        if (hashedSubPackets != null) {
            return hashedSubPackets.getKeyExpirationTime();
        }
        return 0;
    }

    private void init() throws IOException {
        BigInteger bigInteger;
        RSAPublicBCPGKey rSAPublicBCPGKey;
        BCPGKey key = this.publicPk.getKey();
        if (this.publicPk.getVersion() <= 3) {
            rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
            this.keyID = rSAPublicBCPGKey.getModulus().longValue();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                byte[] encoded = new MPInteger(rSAPublicBCPGKey.getModulus()).getEncoded();
                instance.update(encoded, 2, encoded.length - 2);
                byte[] encoded2 = new MPInteger(rSAPublicBCPGKey.getPublicExponent()).getEncoded();
                instance.update(encoded2, 2, encoded2.length - 2);
                this.fingerprint = instance.digest();
            } catch (NoSuchAlgorithmException unused) {
                throw new IOException("can't find MD5");
            }
        } else {
            byte[] encodedContents = this.publicPk.getEncodedContents();
            try {
                MessageDigest instance2 = MessageDigest.getInstance("SHA1");
                instance2.update((byte) -103);
                instance2.update((byte) (encodedContents.length >> 8));
                instance2.update((byte) encodedContents.length);
                instance2.update(encodedContents);
                byte[] digest = instance2.digest();
                this.fingerprint = digest;
                this.keyID = (((long) (digest[digest.length - 2] & UByte.MAX_VALUE)) << 8) | (((long) (digest[digest.length - 8] & UByte.MAX_VALUE)) << 56) | (((long) (digest[digest.length - 7] & UByte.MAX_VALUE)) << 48) | (((long) (digest[digest.length - 6] & UByte.MAX_VALUE)) << 40) | (((long) (digest[digest.length - 5] & UByte.MAX_VALUE)) << 32) | (((long) (digest[digest.length - 4] & UByte.MAX_VALUE)) << 24) | (((long) (digest[digest.length - 3] & UByte.MAX_VALUE)) << 16) | ((long) (digest[digest.length - 1] & UByte.MAX_VALUE));
                if (key instanceof RSAPublicBCPGKey) {
                    rSAPublicBCPGKey = (RSAPublicBCPGKey) key;
                } else {
                    if (key instanceof DSAPublicBCPGKey) {
                        bigInteger = ((DSAPublicBCPGKey) key).getP();
                    } else if (key instanceof ElGamalPublicBCPGKey) {
                        bigInteger = ((ElGamalPublicBCPGKey) key).getP();
                    } else {
                        return;
                    }
                    this.keyStrength = bigInteger.bitLength();
                }
            } catch (NoSuchAlgorithmException unused2) {
                throw new IOException("can't find SHA1");
            }
        }
        bigInteger = rSAPublicBCPGKey.getModulus();
        this.keyStrength = bigInteger.bitLength();
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean z = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                pGPPublicKey2.ids.remove(i);
                pGPPublicKey2.idTrusts.remove(i);
                pGPPublicKey2.idSigs.remove(i);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return pGPPublicKey2;
    }

    private static PGPPublicKey removeCert(PGPPublicKey pGPPublicKey, Object obj, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        boolean z = false;
        for (int i = 0; i < pGPPublicKey2.ids.size(); i++) {
            if (obj.equals(pGPPublicKey2.ids.get(i))) {
                z = ((List) pGPPublicKey2.idSigs.get(i)).remove(pGPSignature);
            }
        }
        if (!z) {
            return null;
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str) {
        return removeCert(pGPPublicKey, str);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, String str, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, str, pGPSignature);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPSignature pGPSignature) {
        PGPPublicKey pGPPublicKey2 = new PGPPublicKey(pGPPublicKey);
        List list = pGPPublicKey2.subSigs;
        if (list == null) {
            list = pGPPublicKey2.keySigs;
        }
        boolean remove = list.remove(pGPSignature);
        if (!remove) {
            Iterator userIDs = pGPPublicKey.getUserIDs();
            while (userIDs.hasNext()) {
                String str = (String) userIDs.next();
                Iterator signaturesForID = pGPPublicKey.getSignaturesForID(str);
                while (signaturesForID.hasNext()) {
                    if (pGPSignature == signaturesForID.next()) {
                        remove = true;
                        pGPPublicKey2 = removeCertification(pGPPublicKey2, str, pGPSignature);
                    }
                }
            }
            if (!remove) {
                Iterator userAttributes = pGPPublicKey.getUserAttributes();
                while (userAttributes.hasNext()) {
                    PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector = (PGPUserAttributeSubpacketVector) userAttributes.next();
                    Iterator signaturesForUserAttribute = pGPPublicKey.getSignaturesForUserAttribute(pGPUserAttributeSubpacketVector);
                    while (signaturesForUserAttribute.hasNext()) {
                        if (pGPSignature == signaturesForUserAttribute.next()) {
                            pGPPublicKey2 = removeCertification(pGPPublicKey2, pGPUserAttributeSubpacketVector, pGPSignature);
                        }
                    }
                }
            }
        }
        return pGPPublicKey2;
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector);
    }

    public static PGPPublicKey removeCertification(PGPPublicKey pGPPublicKey, PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector, PGPSignature pGPSignature) {
        return removeCert(pGPPublicKey, pGPUserAttributeSubpacketVector, pGPSignature);
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.publicPk);
        TrustPacket trustPacket = this.trustPk;
        if (trustPacket != null) {
            bCPGOutputStream.writePacket(trustPacket);
        }
        if (this.subSigs == null) {
            for (int i = 0; i != this.keySigs.size(); i++) {
                ((PGPSignature) this.keySigs.get(i)).encode(bCPGOutputStream);
            }
            for (int i2 = 0; i2 != this.ids.size(); i2++) {
                bCPGOutputStream.writePacket(this.ids.get(i2) instanceof String ? new UserIDPacket((String) this.ids.get(i2)) : new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.ids.get(i2)).toSubpacketArray()));
                if (this.idTrusts.get(i2) != null) {
                    bCPGOutputStream.writePacket((ContainedPacket) this.idTrusts.get(i2));
                }
                List list = (List) this.idSigs.get(i2);
                for (int i3 = 0; i3 != list.size(); i3++) {
                    ((PGPSignature) list.get(i3)).encode(bCPGOutputStream);
                }
            }
            return;
        }
        for (int i4 = 0; i4 != this.subSigs.size(); i4++) {
            ((PGPSignature) this.subSigs.get(i4)).encode(bCPGOutputStream);
        }
    }

    public int getAlgorithm() {
        return this.publicPk.getAlgorithm();
    }

    public int getBitStrength() {
        return this.keyStrength;
    }

    public Date getCreationTime() {
        return this.publicPk.getTime();
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getFingerprint() {
        byte[] bArr = this.fingerprint;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public PublicKey getKey(String str) throws PGPException, NoSuchProviderException {
        return getKey(PGPUtil.getProvider(str));
    }

    public PublicKey getKey(Provider provider) throws PGPException {
        try {
            int algorithm = this.publicPk.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSAPublicBCPGKey rSAPublicBCPGKey = (RSAPublicBCPGKey) this.publicPk.getKey();
                return KeyFactory.getInstance("RSA", provider).generatePublic(new RSAPublicKeySpec(rSAPublicBCPGKey.getModulus(), rSAPublicBCPGKey.getPublicExponent()));
            }
            if (algorithm != 16) {
                if (algorithm == 17) {
                    DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) this.publicPk.getKey();
                    return KeyFactory.getInstance("DSA", provider).generatePublic(new DSAPublicKeySpec(dSAPublicBCPGKey.getY(), dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG()));
                } else if (algorithm != 20) {
                    throw new PGPException("unknown public key algorithm encountered");
                }
            }
            ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) this.publicPk.getKey();
            return KeyFactory.getInstance("ElGamal", provider).generatePublic(new ElGamalPublicKeySpec(elGamalPublicBCPGKey.getY(), new ElGamalParameterSpec(elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG())));
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("exception constructing public key", e2);
        }
    }

    public long getKeyID() {
        return this.keyID;
    }

    public Iterator getSignatures() {
        List list = this.subSigs;
        if (list != null) {
            return list.iterator();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.keySigs);
        for (int i = 0; i != this.idSigs.size(); i++) {
            arrayList.addAll((Collection) this.idSigs.get(i));
        }
        return arrayList.iterator();
    }

    public Iterator getSignaturesForID(String str) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (str.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    public Iterator getSignaturesForUserAttribute(PGPUserAttributeSubpacketVector pGPUserAttributeSubpacketVector) {
        for (int i = 0; i != this.ids.size(); i++) {
            if (pGPUserAttributeSubpacketVector.equals(this.ids.get(i))) {
                return ((ArrayList) this.idSigs.get(i)).iterator();
            }
        }
        return null;
    }

    public Iterator getSignaturesOfType(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator signatures = getSignatures();
        while (signatures.hasNext()) {
            PGPSignature pGPSignature = (PGPSignature) signatures.next();
            if (pGPSignature.getSignatureType() == i) {
                arrayList.add(pGPSignature);
            }
        }
        return arrayList.iterator();
    }

    public byte[] getTrustData() {
        TrustPacket trustPacket = this.trustPk;
        if (trustPacket == null) {
            return null;
        }
        return Arrays.clone(trustPacket.getLevelAndTrustAmount());
    }

    public Iterator getUserAttributes() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof PGPUserAttributeSubpacketVector) {
                arrayList.add(this.ids.get(i));
            }
        }
        return arrayList.iterator();
    }

    public Iterator getUserIDs() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != this.ids.size(); i++) {
            if (this.ids.get(i) instanceof String) {
                arrayList.add(this.ids.get(i));
            }
        }
        return arrayList.iterator();
    }

    public int getValidDays() {
        return this.publicPk.getVersion() > 3 ? (int) (getValidSeconds() / 86400) : this.publicPk.getValidDays();
    }

    public long getValidSeconds() {
        if (this.publicPk.getVersion() <= 3) {
            return ((long) this.publicPk.getValidDays()) * 24 * 60 * 60;
        }
        int i = 0;
        if (isMasterKey()) {
            while (true) {
                int[] iArr = MASTER_KEY_CERTIFICATION_TYPES;
                if (i == iArr.length) {
                    break;
                }
                long expirationTimeFromSig = getExpirationTimeFromSig(true, iArr[i]);
                if (expirationTimeFromSig >= 0) {
                    return expirationTimeFromSig;
                }
                i++;
            }
        } else {
            long expirationTimeFromSig2 = getExpirationTimeFromSig(false, 24);
            if (expirationTimeFromSig2 >= 0) {
                return expirationTimeFromSig2;
            }
        }
        return 0;
    }

    public int getVersion() {
        return this.publicPk.getVersion();
    }

    public boolean isEncryptionKey() {
        int algorithm = this.publicPk.getAlgorithm();
        return algorithm == 1 || algorithm == 2 || algorithm == 16 || algorithm == 20;
    }

    public boolean isMasterKey() {
        return this.subSigs == null;
    }

    public boolean isRevoked() {
        boolean z = false;
        if (isMasterKey()) {
            int i = 0;
            while (!z && i < this.keySigs.size()) {
                int i2 = i + 1;
                if (((PGPSignature) this.keySigs.get(i)).getSignatureType() == 32) {
                    z = true;
                }
                i = i2;
            }
        } else {
            int i3 = 0;
            while (!z && i3 < this.subSigs.size()) {
                int i4 = i3 + 1;
                if (((PGPSignature) this.subSigs.get(i3)).getSignatureType() == 40) {
                    z = true;
                }
                i3 = i4;
            }
        }
        return z;
    }
}
