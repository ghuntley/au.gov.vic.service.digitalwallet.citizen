package org.bouncycastle.openpgp;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import kotlin.UByte;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.BCPGObject;
import org.bouncycastle.bcpg.BCPGOutputStream;
import org.bouncycastle.bcpg.ContainedPacket;
import org.bouncycastle.bcpg.DSAPublicBCPGKey;
import org.bouncycastle.bcpg.DSASecretBCPGKey;
import org.bouncycastle.bcpg.ElGamalPublicBCPGKey;
import org.bouncycastle.bcpg.ElGamalSecretBCPGKey;
import org.bouncycastle.bcpg.PublicKeyPacket;
import org.bouncycastle.bcpg.RSAPublicBCPGKey;
import org.bouncycastle.bcpg.RSASecretBCPGKey;
import org.bouncycastle.bcpg.S2K;
import org.bouncycastle.bcpg.SecretKeyPacket;
import org.bouncycastle.bcpg.SecretSubkeyPacket;
import org.bouncycastle.bcpg.UserAttributePacket;
import org.bouncycastle.bcpg.UserIDPacket;
import org.bouncycastle.jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;
import org.bouncycastle.jce.spec.ElGamalPrivateKeySpec;

public class PGPSecretKey {
    final PGPPublicKey pub;
    final SecretKeyPacket secret;

    public PGPSecretKey(int i, int i2, PublicKey publicKey, PrivateKey privateKey, Date date, String str, int i3, char[] cArr, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, new PGPKeyPair(i2, publicKey, privateKey, date), str, i3, cArr, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, str2);
    }

    public PGPSecretKey(int i, int i2, PublicKey publicKey, PrivateKey privateKey, Date date, String str, int i3, char[] cArr, boolean z, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, new PGPKeyPair(i2, publicKey, privateKey, date), str, i3, cArr, z, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, str2);
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, pGPKeyPair, str, i2, cArr, false, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, str2);
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, boolean z, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, String str2) throws PGPException, NoSuchProviderException {
        this(i, pGPKeyPair, str, i2, cArr, z, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, secureRandom, PGPUtil.getProvider(str2));
    }

    public PGPSecretKey(int i, PGPKeyPair pGPKeyPair, String str, int i2, char[] cArr, boolean z, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, SecureRandom secureRandom, Provider provider) throws PGPException {
        this(pGPKeyPair.getPrivateKey(), certifiedPublicKey(i, pGPKeyPair, str, pGPSignatureSubpacketVector, pGPSignatureSubpacketVector2, provider), i2, cArr, z, secureRandom, true, provider);
    }

    PGPSecretKey(SecretKeyPacket secretKeyPacket, PGPPublicKey pGPPublicKey) {
        this.secret = secretKeyPacket;
        this.pub = pGPPublicKey;
    }

    PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, int i, char[] cArr, boolean z, SecureRandom secureRandom, Provider provider) throws PGPException {
        this(pGPPrivateKey, pGPPublicKey, i, cArr, z, secureRandom, false, provider);
    }

    PGPSecretKey(PGPPrivateKey pGPPrivateKey, PGPPublicKey pGPPublicKey, int i, char[] cArr, boolean z, SecureRandom secureRandom, boolean z2, Provider provider) throws PGPException {
        BCPGObject bCPGObject;
        SecretKeyPacket secretKeyPacket;
        this.pub = pGPPublicKey;
        int algorithm = pGPPublicKey.getAlgorithm();
        if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) pGPPrivateKey.getKey();
            bCPGObject = new RSASecretBCPGKey(rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ());
        } else {
            if (algorithm != 16) {
                if (algorithm == 17) {
                    bCPGObject = new DSASecretBCPGKey(((DSAPrivateKey) pGPPrivateKey.getKey()).getX());
                } else if (algorithm != 20) {
                    throw new PGPException("unknown key class");
                }
            }
            bCPGObject = new ElGamalSecretBCPGKey(((ElGamalPrivateKey) pGPPrivateKey.getKey()).getX());
        }
        String symmetricCipherName = PGPUtil.getSymmetricCipherName(i);
        Cipher cipher = null;
        if (symmetricCipherName != null) {
            try {
                cipher = Cipher.getInstance(symmetricCipherName + "/CFB/NoPadding", provider);
            } catch (Exception e) {
                throw new PGPException("Exception creating cipher", e);
            }
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BCPGOutputStream bCPGOutputStream = new BCPGOutputStream(byteArrayOutputStream);
            bCPGOutputStream.writeObject(bCPGObject);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            bCPGOutputStream.write(checksum(z, byteArray, byteArray.length));
            if (cipher != null) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                S2K s2k = new S2K(2, bArr, 96);
                cipher.init(1, PGPUtil.makeKeyFromPassPhrase(i, s2k, cArr, provider), secureRandom);
                byte[] iv = cipher.getIV();
                byte[] doFinal = cipher.doFinal(byteArrayOutputStream.toByteArray());
                int i2 = z ? SecretKeyPacket.USAGE_SHA1 : 255;
                secretKeyPacket = z2 ? new SecretKeyPacket(pGPPublicKey.publicPk, i, i2, s2k, iv, doFinal) : new SecretSubkeyPacket(pGPPublicKey.publicPk, i, i2, s2k, iv, doFinal);
            } else {
                secretKeyPacket = z2 ? new SecretKeyPacket(pGPPublicKey.publicPk, i, null, null, byteArrayOutputStream.toByteArray()) : new SecretSubkeyPacket(pGPPublicKey.publicPk, i, null, null, byteArrayOutputStream.toByteArray());
            }
            this.secret = secretKeyPacket;
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception encrypting key", e3);
        }
    }

    private static PGPPublicKey certifiedPublicKey(int i, PGPKeyPair pGPKeyPair, String str, PGPSignatureSubpacketVector pGPSignatureSubpacketVector, PGPSignatureSubpacketVector pGPSignatureSubpacketVector2, Provider provider) throws PGPException {
        try {
            PGPSignatureGenerator pGPSignatureGenerator = new PGPSignatureGenerator(pGPKeyPair.getPublicKey().getAlgorithm(), 2, provider);
            pGPSignatureGenerator.initSign(i, pGPKeyPair.getPrivateKey());
            pGPSignatureGenerator.setHashedSubpackets(pGPSignatureSubpacketVector);
            pGPSignatureGenerator.setUnhashedSubpackets(pGPSignatureSubpacketVector2);
            try {
                return PGPPublicKey.addCertification(pGPKeyPair.getPublicKey(), str, pGPSignatureGenerator.generateCertification(str, pGPKeyPair.getPublicKey()));
            } catch (Exception e) {
                throw new PGPException("exception doing certification: " + e, e);
            }
        } catch (Exception e2) {
            throw new PGPException("creating signature generator: " + e2, e2);
        }
    }

    private static byte[] checksum(boolean z, byte[] bArr, int i) throws PGPException {
        if (z) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA1");
                instance.update(bArr, 0, i);
                return instance.digest();
            } catch (NoSuchAlgorithmException e) {
                throw new PGPException("Can't find SHA-1", e);
            }
        } else {
            int i2 = 0;
            for (int i3 = 0; i3 != i; i3++) {
                i2 += bArr[i3] & UByte.MAX_VALUE;
            }
            return new byte[]{(byte) (i2 >> 8), (byte) i2};
        }
    }

    public static PGPSecretKey copyWithNewPassword(PGPSecretKey pGPSecretKey, char[] cArr, char[] cArr2, int i, SecureRandom secureRandom, String str) throws PGPException, NoSuchProviderException {
        return copyWithNewPassword(pGPSecretKey, cArr, cArr2, i, secureRandom, PGPUtil.getProvider(str));
    }

    public static PGPSecretKey copyWithNewPassword(PGPSecretKey pGPSecretKey, char[] cArr, char[] cArr2, int i, SecureRandom secureRandom, Provider provider) throws PGPException {
        byte[] bArr;
        S2K s2k;
        int i2;
        byte[] extractKeyData = pGPSecretKey.extractKeyData(cArr, provider);
        int s2KUsage = pGPSecretKey.secret.getS2KUsage();
        byte[] bArr2 = null;
        if (i == 0) {
            if (pGPSecretKey.secret.getS2KUsage() == 254) {
                int length = extractKeyData.length - 18;
                byte[] bArr3 = new byte[length];
                int i3 = length - 2;
                System.arraycopy(extractKeyData, 0, bArr3, 0, i3);
                byte[] checksum = checksum(false, bArr3, i3);
                bArr3[i3] = checksum[0];
                bArr3[length - 1] = checksum[1];
                bArr = bArr3;
            } else {
                bArr = extractKeyData;
            }
            s2k = null;
            i2 = 0;
        } else {
            try {
                Cipher instance = Cipher.getInstance(PGPUtil.getSymmetricCipherName(i) + "/CFB/NoPadding", provider);
                byte[] bArr4 = new byte[8];
                secureRandom.nextBytes(bArr4);
                S2K s2k2 = new S2K(2, bArr4, 96);
                try {
                    instance.init(1, PGPUtil.makeKeyFromPassPhrase(i, s2k2, cArr2, provider), secureRandom);
                    byte[] iv = instance.getIV();
                    byte[] doFinal = instance.doFinal(extractKeyData);
                    bArr2 = iv;
                    bArr = doFinal;
                    i2 = s2KUsage;
                    s2k = s2k2;
                } catch (PGPException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new PGPException("Exception encrypting key", e2);
                }
            } catch (Exception e3) {
                throw new PGPException("Exception creating cipher", e3);
            }
        }
        SecretKeyPacket secretKeyPacket = pGPSecretKey.secret;
        return new PGPSecretKey(secretKeyPacket instanceof SecretSubkeyPacket ? new SecretSubkeyPacket(secretKeyPacket.getPublicKeyPacket(), i, i2, s2k, bArr2, bArr) : new SecretKeyPacket(secretKeyPacket.getPublicKeyPacket(), i, i2, s2k, bArr2, bArr), pGPSecretKey.pub);
    }

    private byte[] extractKeyData(char[] cArr, Provider provider) throws PGPException {
        Cipher cipher;
        String symmetricCipherName = PGPUtil.getSymmetricCipherName(this.secret.getEncAlgorithm());
        if (symmetricCipherName != null) {
            try {
                cipher = Cipher.getInstance(symmetricCipherName + "/CFB/NoPadding", provider);
            } catch (Exception e) {
                throw new PGPException("Exception creating cipher", e);
            }
        } else {
            cipher = null;
        }
        byte[] secretKeyData = this.secret.getSecretKeyData();
        if (cipher == null) {
            return secretKeyData;
        }
        try {
            int i = 4;
            int i2 = 2;
            int i3 = 0;
            if (this.secret.getPublicKeyPacket().getVersion() == 4) {
                cipher.init(2, PGPUtil.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K(), cArr, provider), new IvParameterSpec(this.secret.getIV()));
                byte[] doFinal = cipher.doFinal(secretKeyData, 0, secretKeyData.length);
                boolean z = this.secret.getS2KUsage() == 254;
                byte[] checksum = checksum(z, doFinal, z ? doFinal.length - 20 : doFinal.length - 2);
                while (i3 != checksum.length) {
                    if (checksum[i3] == doFinal[(doFinal.length - checksum.length) + i3]) {
                        i3++;
                    } else {
                        throw new PGPException("checksum mismatch at " + i3 + " of " + checksum.length);
                    }
                }
                return doFinal;
            }
            SecretKey makeKeyFromPassPhrase = PGPUtil.makeKeyFromPassPhrase(this.secret.getEncAlgorithm(), this.secret.getS2K(), cArr, provider);
            int length = secretKeyData.length;
            byte[] bArr = new byte[length];
            int length2 = this.secret.getIV().length;
            byte[] bArr2 = new byte[length2];
            System.arraycopy(this.secret.getIV(), 0, bArr2, 0, length2);
            int i4 = 0;
            int i5 = 0;
            while (i4 != i) {
                cipher.init(i2, makeKeyFromPassPhrase, new IvParameterSpec(bArr2));
                int i6 = i5 + 1;
                int i7 = (((secretKeyData[i5] << 8) | (secretKeyData[i6] & UByte.MAX_VALUE)) + 7) / 8;
                bArr[i5] = secretKeyData[i5];
                bArr[i6] = secretKeyData[i6];
                int i8 = i5 + 2;
                cipher.doFinal(secretKeyData, i8, i7, bArr, i8);
                i5 += i7 + 2;
                if (i4 != 3) {
                    System.arraycopy(secretKeyData, i5 - length2, bArr2, 0, length2);
                }
                i4++;
                length2 = length2;
                bArr2 = bArr2;
                i = 4;
                i2 = 2;
            }
            int i9 = ((secretKeyData[i5] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (secretKeyData[i5 + 1] & UByte.MAX_VALUE);
            int i10 = 0;
            while (i3 < length - 2) {
                i10 += bArr[i3] & UByte.MAX_VALUE;
                i3++;
            }
            int i11 = 65535 & i10;
            if (i11 == i9) {
                return bArr;
            }
            throw new PGPException("checksum mismatch: passphrase wrong, expected " + Integer.toHexString(i9) + " found " + Integer.toHexString(i11));
        } catch (PGPException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new PGPException("Exception decrypting key", e3);
        } catch (PGPException e4) {
            throw e4;
        } catch (Exception e5) {
            throw new PGPException("Exception constructing key", e5);
        }
    }

    public static PGPSecretKey replacePublicKey(PGPSecretKey pGPSecretKey, PGPPublicKey pGPPublicKey) {
        if (pGPPublicKey.getKeyID() == pGPSecretKey.getKeyID()) {
            return new PGPSecretKey(pGPSecretKey.secret, pGPPublicKey);
        }
        throw new IllegalArgumentException("keyIDs do not match");
    }

    public void encode(OutputStream outputStream) throws IOException {
        BCPGOutputStream bCPGOutputStream = outputStream instanceof BCPGOutputStream ? (BCPGOutputStream) outputStream : new BCPGOutputStream(outputStream);
        bCPGOutputStream.writePacket(this.secret);
        if (this.pub.trustPk != null) {
            bCPGOutputStream.writePacket(this.pub.trustPk);
        }
        if (this.pub.subSigs == null) {
            for (int i = 0; i != this.pub.keySigs.size(); i++) {
                ((PGPSignature) this.pub.keySigs.get(i)).encode(bCPGOutputStream);
            }
            for (int i2 = 0; i2 != this.pub.ids.size(); i2++) {
                bCPGOutputStream.writePacket(this.pub.ids.get(i2) instanceof String ? new UserIDPacket((String) this.pub.ids.get(i2)) : new UserAttributePacket(((PGPUserAttributeSubpacketVector) this.pub.ids.get(i2)).toSubpacketArray()));
                if (this.pub.idTrusts.get(i2) != null) {
                    bCPGOutputStream.writePacket((ContainedPacket) this.pub.idTrusts.get(i2));
                }
                ArrayList arrayList = (ArrayList) this.pub.idSigs.get(i2);
                for (int i3 = 0; i3 != arrayList.size(); i3++) {
                    ((PGPSignature) arrayList.get(i3)).encode(bCPGOutputStream);
                }
            }
            return;
        }
        for (int i4 = 0; i4 != this.pub.subSigs.size(); i4++) {
            ((PGPSignature) this.pub.subSigs.get(i4)).encode(bCPGOutputStream);
        }
    }

    public PGPPrivateKey extractPrivateKey(char[] cArr, String str) throws PGPException, NoSuchProviderException {
        return extractPrivateKey(cArr, PGPUtil.getProvider(str));
    }

    public PGPPrivateKey extractPrivateKey(char[] cArr, Provider provider) throws PGPException {
        byte[] secretKeyData = this.secret.getSecretKeyData();
        if (secretKeyData == null || secretKeyData.length < 1) {
            return null;
        }
        PublicKeyPacket publicKeyPacket = this.secret.getPublicKeyPacket();
        try {
            BCPGInputStream bCPGInputStream = new BCPGInputStream(new ByteArrayInputStream(extractKeyData(cArr, provider)));
            int algorithm = publicKeyPacket.getAlgorithm();
            if (algorithm == 1 || algorithm == 2 || algorithm == 3) {
                RSASecretBCPGKey rSASecretBCPGKey = new RSASecretBCPGKey(bCPGInputStream);
                return new PGPPrivateKey(KeyFactory.getInstance("RSA", provider).generatePrivate(new RSAPrivateCrtKeySpec(rSASecretBCPGKey.getModulus(), ((RSAPublicBCPGKey) publicKeyPacket.getKey()).getPublicExponent(), rSASecretBCPGKey.getPrivateExponent(), rSASecretBCPGKey.getPrimeP(), rSASecretBCPGKey.getPrimeQ(), rSASecretBCPGKey.getPrimeExponentP(), rSASecretBCPGKey.getPrimeExponentQ(), rSASecretBCPGKey.getCrtCoefficient())), getKeyID());
            }
            if (algorithm != 16) {
                if (algorithm == 17) {
                    DSAPublicBCPGKey dSAPublicBCPGKey = (DSAPublicBCPGKey) publicKeyPacket.getKey();
                    return new PGPPrivateKey(KeyFactory.getInstance("DSA", provider).generatePrivate(new DSAPrivateKeySpec(new DSASecretBCPGKey(bCPGInputStream).getX(), dSAPublicBCPGKey.getP(), dSAPublicBCPGKey.getQ(), dSAPublicBCPGKey.getG())), getKeyID());
                } else if (algorithm != 20) {
                    throw new PGPException("unknown public key algorithm encountered");
                }
            }
            ElGamalPublicBCPGKey elGamalPublicBCPGKey = (ElGamalPublicBCPGKey) publicKeyPacket.getKey();
            return new PGPPrivateKey(KeyFactory.getInstance("ElGamal", provider).generatePrivate(new ElGamalPrivateKeySpec(new ElGamalSecretBCPGKey(bCPGInputStream).getX(), new ElGamalParameterSpec(elGamalPublicBCPGKey.getP(), elGamalPublicBCPGKey.getG()))), getKeyID());
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception constructing key", e2);
        }
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public int getKeyEncryptionAlgorithm() {
        return this.secret.getEncAlgorithm();
    }

    public long getKeyID() {
        return this.pub.getKeyID();
    }

    public PGPPublicKey getPublicKey() {
        return this.pub;
    }

    public Iterator getUserAttributes() {
        return this.pub.getUserAttributes();
    }

    public Iterator getUserIDs() {
        return this.pub.getUserIDs();
    }

    public boolean isMasterKey() {
        return this.pub.isMasterKey();
    }

    public boolean isSigningKey() {
        int algorithm = this.pub.getAlgorithm();
        return algorithm == 1 || algorithm == 3 || algorithm == 17 || algorithm == 19 || algorithm == 20;
    }
}
