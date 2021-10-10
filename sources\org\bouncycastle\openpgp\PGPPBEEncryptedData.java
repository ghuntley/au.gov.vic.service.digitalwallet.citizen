package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.bcpg.BCPGInputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.SymmetricEncIntegrityPacket;
import org.bouncycastle.bcpg.SymmetricKeyEncSessionPacket;
import org.bouncycastle.openpgp.PGPEncryptedData;

public class PGPPBEEncryptedData extends PGPEncryptedData {
    SymmetricKeyEncSessionPacket keyData;

    PGPPBEEncryptedData(SymmetricKeyEncSessionPacket symmetricKeyEncSessionPacket, InputStreamPacket inputStreamPacket) {
        super(inputStreamPacket);
        this.keyData = symmetricKeyEncSessionPacket;
    }

    private Cipher createStreamCipher(int i, Provider provider) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException, PGPException {
        String str = this.encData instanceof SymmetricEncIntegrityPacket ? "CFB" : "OpenPGPCFB";
        return Cipher.getInstance(PGPUtil.getSymmetricCipherName(i) + "/" + str + "/NoPadding", provider);
    }

    public InputStream getDataStream(char[] cArr, String str) throws PGPException, NoSuchProviderException {
        return getDataStream(cArr, PGPUtil.getProvider(str));
    }

    public InputStream getDataStream(char[] cArr, Provider provider) throws PGPException {
        try {
            int encAlgorithm = this.keyData.getEncAlgorithm();
            SecretKey makeKeyFromPassPhrase = PGPUtil.makeKeyFromPassPhrase(encAlgorithm, this.keyData.getS2K(), cArr, provider);
            byte[] secKeyData = this.keyData.getSecKeyData();
            boolean z = false;
            byte b = encAlgorithm;
            if (secKeyData != null) {
                b = encAlgorithm;
                if (secKeyData.length > 0) {
                    Cipher instance = Cipher.getInstance(PGPUtil.getSymmetricCipherName(encAlgorithm) + "/CFB/NoPadding", provider);
                    instance.init(2, makeKeyFromPassPhrase, new IvParameterSpec(new byte[instance.getBlockSize()]));
                    byte[] doFinal = instance.doFinal(secKeyData);
                    byte b2 = doFinal[0];
                    makeKeyFromPassPhrase = new SecretKeySpec(doFinal, 1, doFinal.length - 1, PGPUtil.getSymmetricCipherName(b2));
                    b = b2;
                }
            }
            Cipher createStreamCipher = createStreamCipher(b, provider);
            int blockSize = createStreamCipher.getBlockSize();
            byte[] bArr = new byte[blockSize];
            createStreamCipher.init(2, makeKeyFromPassPhrase, new IvParameterSpec(bArr));
            this.encStream = new BCPGInputStream(new CipherInputStream(this.encData.getInputStream(), createStreamCipher));
            if (this.encData instanceof SymmetricEncIntegrityPacket) {
                this.truncStream = new PGPEncryptedData.TruncatedStream(this.encStream);
                this.encStream = new DigestInputStream(this.truncStream, MessageDigest.getInstance(PGPUtil.getDigestName(2), provider));
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
            if (read2 < 0 || read3 < 0) {
                throw new EOFException("unexpected end of stream.");
            }
            boolean z2 = bArr[blockSize + -2] == ((byte) read2) && bArr[blockSize - 1] == ((byte) read3);
            if (read2 == 0 && read3 == 0) {
                z = true;
            }
            if (z2 || z) {
                return this.encStream;
            }
            throw new PGPDataValidationException("data check failed.");
        } catch (PGPException e) {
            throw e;
        } catch (Exception e2) {
            throw new PGPException("Exception creating cipher", e2);
        }
    }

    @Override // org.bouncycastle.openpgp.PGPEncryptedData
    public InputStream getInputStream() {
        return this.encData.getInputStream();
    }
}
