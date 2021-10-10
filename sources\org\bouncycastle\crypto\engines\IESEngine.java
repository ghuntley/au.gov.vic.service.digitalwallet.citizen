package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.IESParameters;
import org.bouncycastle.crypto.params.IESWithCipherParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;

public class IESEngine {
    BasicAgreement agree;
    BufferedBlockCipher cipher;
    boolean forEncryption;
    DerivationFunction kdf;
    Mac mac;
    byte[] macBuf;
    IESParameters param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = null;
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, Mac mac2, BufferedBlockCipher bufferedBlockCipher) {
        this.agree = basicAgreement;
        this.kdf = derivationFunction;
        this.mac = mac2;
        this.macBuf = new byte[mac2.getMacSize()];
        this.cipher = bufferedBlockCipher;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2, byte[] bArr2) throws InvalidCipherTextException {
        KeyParameter keyParameter;
        byte[] bArr3;
        KDFParameters kDFParameters = new KDFParameters(bArr2, this.param.getDerivationV());
        int macKeySize = this.param.getMacKeySize();
        this.kdf.init(kDFParameters);
        int macSize = i2 - this.mac.getMacSize();
        int i3 = 0;
        if (this.cipher == null) {
            int i4 = macKeySize / 8;
            byte[] generateKdfBytes = generateKdfBytes(kDFParameters, macSize + i4);
            bArr3 = new byte[macSize];
            for (int i5 = 0; i5 != macSize; i5++) {
                bArr3[i5] = (byte) (bArr[i + i5] ^ generateKdfBytes[i5]);
            }
            keyParameter = new KeyParameter(generateKdfBytes, macSize, i4);
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            int i6 = macKeySize / 8;
            byte[] generateKdfBytes2 = generateKdfBytes(kDFParameters, cipherKeySize + i6);
            this.cipher.init(false, new KeyParameter(generateKdfBytes2, 0, cipherKeySize));
            byte[] bArr4 = new byte[this.cipher.getOutputSize(macSize)];
            int processBytes = this.cipher.processBytes(bArr, i, macSize, bArr4, 0);
            int doFinal = processBytes + this.cipher.doFinal(bArr4, processBytes);
            byte[] bArr5 = new byte[doFinal];
            System.arraycopy(bArr4, 0, bArr5, 0, doFinal);
            keyParameter = new KeyParameter(generateKdfBytes2, cipherKeySize, i6);
            bArr3 = bArr5;
        }
        byte[] encodingV = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(bArr, i, macSize);
        this.mac.update(encodingV, 0, encodingV.length);
        this.mac.doFinal(this.macBuf, 0);
        int i7 = i + macSize;
        while (true) {
            byte[] bArr6 = this.macBuf;
            if (i3 >= bArr6.length) {
                return bArr3;
            }
            if (bArr6[i3] == bArr[i7 + i3]) {
                i3++;
            } else {
                throw new InvalidCipherTextException("Mac codes failed to equal.");
            }
        }
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2, byte[] bArr2) throws InvalidCipherTextException {
        KeyParameter keyParameter;
        byte[] bArr3;
        KDFParameters kDFParameters = new KDFParameters(bArr2, this.param.getDerivationV());
        int macKeySize = this.param.getMacKeySize();
        if (this.cipher == null) {
            int i3 = macKeySize / 8;
            byte[] generateKdfBytes = generateKdfBytes(kDFParameters, i2 + i3);
            bArr3 = new byte[(this.mac.getMacSize() + i2)];
            for (int i4 = 0; i4 != i2; i4++) {
                bArr3[i4] = (byte) (bArr[i + i4] ^ generateKdfBytes[i4]);
            }
            keyParameter = new KeyParameter(generateKdfBytes, i2, i3);
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.param).getCipherKeySize() / 8;
            int i5 = macKeySize / 8;
            byte[] generateKdfBytes2 = generateKdfBytes(kDFParameters, cipherKeySize + i5);
            this.cipher.init(true, new KeyParameter(generateKdfBytes2, 0, cipherKeySize));
            byte[] bArr4 = new byte[this.cipher.getOutputSize(i2)];
            int processBytes = this.cipher.processBytes(bArr, i, i2, bArr4, 0);
            i2 = processBytes + this.cipher.doFinal(bArr4, processBytes);
            byte[] bArr5 = new byte[(this.mac.getMacSize() + i2)];
            System.arraycopy(bArr4, 0, bArr5, 0, i2);
            KeyParameter keyParameter2 = new KeyParameter(generateKdfBytes2, cipherKeySize, i5);
            bArr3 = bArr5;
            keyParameter = keyParameter2;
        }
        byte[] encodingV = this.param.getEncodingV();
        this.mac.init(keyParameter);
        this.mac.update(bArr3, 0, i2);
        this.mac.update(encodingV, 0, encodingV.length);
        this.mac.doFinal(bArr3, i2);
        return bArr3;
    }

    private byte[] generateKdfBytes(KDFParameters kDFParameters, int i) {
        byte[] bArr = new byte[i];
        this.kdf.init(kDFParameters);
        this.kdf.generateBytes(bArr, 0, i);
        return bArr;
    }

    public void init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.param = (IESParameters) cipherParameters3;
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        this.agree.init(this.privParam);
        BigInteger calculateAgreement = this.agree.calculateAgreement(this.pubParam);
        boolean z = this.forEncryption;
        byte[] byteArray = calculateAgreement.toByteArray();
        return z ? encryptBlock(bArr, i, i2, byteArray) : decryptBlock(bArr, i, i2, byteArray);
    }
}
