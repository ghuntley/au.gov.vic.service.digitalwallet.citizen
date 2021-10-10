package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.PublicKeyEncSessionPacket;
import org.bouncycastle.bcpg.SymmetricEncIntegrityPacket;
import org.bouncycastle.jce.interfaces.ElGamalKey;
import org.bouncycastle.openpgp.PGPEncryptedData;

public class PGPPublicKeyEncryptedData extends PGPEncryptedData {
    PublicKeyEncSessionPacket keyData;

    PGPPublicKeyEncryptedData(PublicKeyEncSessionPacket publicKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = publicKeyEncSessionPacket;
    }

    private boolean confirmCheckSum(byte[] bArr) {
        int i = 0;
        for (int i2 = 1; i2 != bArr.length - 2; i2++) {
            i += bArr[i2] & UByte.MAX_VALUE;
        }
        return bArr[bArr.length + -2] == ((byte) (i >> 8)) && bArr[bArr.length - 1] == ((byte) i);
    }

    private byte[] fetchSymmetricKeyData(PGPPrivateKey pGPPrivateKey, Provider provider) throws PGPException {
        Cipher keyCipher = getKeyCipher(this.keyData.getAlgorithm(), provider);
        try {
            keyCipher.init(2, pGPPrivateKey.getKey());
            BigInteger[] encSessionKey = this.keyData.getEncSessionKey();
            if (this.keyData.getAlgorithm() == 2 || this.keyData.getAlgorithm() == 1) {
                byte[] byteArray = encSessionKey[0].toByteArray();
                if (byteArray[0] == 0) {
                    keyCipher.update(byteArray, 1, byteArray.length - 1);
                } else {
                    keyCipher.update(byteArray);
                }
            } else {
                int bitLength = (((ElGamalKey) pGPPrivateKey.getKey()).getParameters().getP().bitLength() + 7) / 8;
                byte[] bArr = new byte[bitLength];
                byte[] byteArray2 = encSessionKey[0].toByteArray();
                if (byteArray2.length > bitLength) {
                    keyCipher.update(byteArray2, 1, byteArray2.length - 1);
                } else {
                    System.arraycopy(byteArray2, 0, bArr, bitLength - byteArray2.length, byteArray2.length);
                    keyCipher.update(bArr);
                }
                byte[] byteArray3 = encSessionKey[1].toByteArray();
                for (int i = 0; i != bitLength; i++) {
                    bArr[i] = 0;
                }
                if (byteArray3.length > bitLength) {
                    keyCipher.update(byteArray3, 1, byteArray3.length - 1);
                } else {
                    System.arraycopy(byteArray3, 0, bArr, bitLength - byteArray3.length, byteArray3.length);
                    keyCipher.update(bArr);
                }
            }
            try {
                byte[] doFinal = keyCipher.doFinal();
                if (confirmCheckSum(doFinal)) {
                    return doFinal;
                }
                throw new PGPKeyValidationException("key checksum failed");
            } catch (Exception e) {
                throw new PGPException("exception decrypting secret key", e);
            }
        } catch (InvalidKeyException e2) {
            throw new PGPException("error setting asymmetric cipher", e2);
        }
    }

    private static Cipher getKeyCipher(int i, Provider provider) throws PGPException {
        if (i == 1 || i == 2) {
            return Cipher.getInstance("RSA/ECB/PKCS1Padding", provider);
        }
        if (i == 16 || i == 20) {
            return Cipher.getInstance("ElGamal/ECB/PKCS1Padding", provider);
        }
        try {
            throw new PGPException("unknown asymmetric algorithm: " + i);
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception creating cipher", e2);
        }
    }

    public InputStream getDataStream(PGPPrivateKey pGPPrivateKey, String str) throws PGPException, NoSuchProviderException {
        return getDataStream(pGPPrivateKey, str, str);
    }

    public InputStream getDataStream(PGPPrivateKey pGPPrivateKey, String str, String str2) throws PGPException, NoSuchProviderException {
        return getDataStream(pGPPrivateKey, PGPUtil.getProvider(str), PGPUtil.getProvider(str2));
    }

    public InputStream getDataStream(PGPPrivateKey pGPPrivateKey, Provider provider) throws PGPException {
        return getDataStream(pGPPrivateKey, provider, provider);
    }

    public InputStream getDataStream(PGPPrivateKey pGPPrivateKey, Provider provider, Provider provider2) throws PGPException {
        byte[] fetchSymmetricKeyData = fetchSymmetricKeyData(pGPPrivateKey, provider);
        try {
            Cipher instance = Cipher.getInstance(this.encData instanceof SymmetricEncIntegrityPacket ? PGPUtil.getSymmetricCipherName(fetchSymmetricKeyData[0]) + "/CFB/NoPadding" : PGPUtil.getSymmetricCipherName(fetchSymmetricKeyData[0]) + "/OpenPGPCFB/NoPadding", provider2);
            if (instance == null) {
                return this.encData.getInputStream();
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(fetchSymmetricKeyData, 1, fetchSymmetricKeyData.length - 3, PGPUtil.getSymmetricCipherName(fetchSymmetricKeyData[0]));
                int blockSize = instance.getBlockSize();
                byte[] bArr = new byte[blockSize];
                instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
                this.encStream = new BCPGInputStream(new CipherInputStream(this.encData.getInputStream(), instance));
                if (this.encData instanceof SymmetricEncIntegrityPacket) {
                    this.truncStream = new PGPEncryptedData.TruncatedStream(this.encStream);
                    this.encStream = new DigestInputStream(this.truncStream, MessageDigest.getInstance(PGPUtil.getDigestName(2), provider2));
                }
                for (int i = 0; i != blockSize; i++) {
                    int read = this.encStream.read();
                    if (read >= 0) {
                        bArr[i] = (byte) read;
                    } else {
                        throw new EOFException("unexpected end of stream.");
                    }
                }
                int read2 = this.encStream.read();
                int read3 = this.encStream.read();
                if (read2 >= 0 && read3 >= 0) {
                    return this.encStream;
                }
                throw new EOFException("unexpected end of stream.");
            } catch (PGPException e) {
                throw e;
            } catch (Exception e2) {
                throw new PGPException("Exception starting decryption", e2);
            }
        } catch (PGPException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new PGPException("exception creating cipher", e4);
        }
    }

    public long getKeyID() {
        return this.keyData.getKeyID();
    }

    public int getSymmetricAlgorithm(PGPPrivateKey pGPPrivateKey, String str) throws PGPException, NoSuchProviderException {
        return getSymmetricAlgorithm(pGPPrivateKey, PGPUtil.getProvider(str));
    }

    public int getSymmetricAlgorithm(PGPPrivateKey pGPPrivateKey, Provider provider) throws PGPException, NoSuchProviderException {
        return fetchSymmetricKeyData(pGPPrivateKey, provider)[0];
    }
}
