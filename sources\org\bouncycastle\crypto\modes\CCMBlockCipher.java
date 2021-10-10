package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CCMBlockCipher implements AEADBlockCipher {
    private byte[] associatedText;
    private int blockSize;
    private BlockCipher cipher;
    private ByteArrayOutputStream data = new ByteArrayOutputStream();
    private boolean forEncryption;
    private CipherParameters keyParam;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonce;

    public CCMBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.macBlock = new byte[blockSize2];
        if (blockSize2 != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    private int calculateMac(byte[] bArr, int i, int i2, byte[] bArr2) {
        CBCBlockCipherMac cBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
        cBCBlockCipherMac.init(this.keyParam);
        byte[] bArr3 = new byte[16];
        if (hasAssociatedText()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i3 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((cBCBlockCipherMac.getMacSize() - 2) / 2) & 7) << 3));
        byte b = bArr3[0];
        byte[] bArr4 = this.nonce;
        bArr3[0] = (byte) (b | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[16 - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        cBCBlockCipherMac.update(bArr3, 0, 16);
        if (hasAssociatedText()) {
            byte[] bArr5 = this.associatedText;
            if (bArr5.length < 65280) {
                cBCBlockCipherMac.update((byte) (bArr5.length >> 8));
                cBCBlockCipherMac.update((byte) this.associatedText.length);
            } else {
                cBCBlockCipherMac.update((byte) -1);
                cBCBlockCipherMac.update((byte) -2);
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 24));
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 16));
                cBCBlockCipherMac.update((byte) (this.associatedText.length >> 8));
                cBCBlockCipherMac.update((byte) this.associatedText.length);
                i3 = 6;
            }
            byte[] bArr6 = this.associatedText;
            cBCBlockCipherMac.update(bArr6, 0, bArr6.length);
            int length = (i3 + this.associatedText.length) % 16;
            if (length != 0) {
                for (int i6 = 0; i6 != 16 - length; i6++) {
                    cBCBlockCipherMac.update((byte) 0);
                }
            }
        }
        cBCBlockCipherMac.update(bArr, i, i2);
        return cBCBlockCipherMac.doFinal(bArr2, 0);
    }

    private boolean hasAssociatedText() {
        byte[] bArr = this.associatedText;
        return (bArr == null || bArr.length == 0) ? false : true;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        byte[] byteArray = this.data.toByteArray();
        byte[] processPacket = processPacket(byteArray, 0, byteArray.length);
        System.arraycopy(processPacket, 0, bArr, i, processPacket.length);
        reset();
        return processPacket.length;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CCM";
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public byte[] getMac() {
        int i = this.macSize;
        byte[] bArr = new byte[i];
        System.arraycopy(this.macBlock, 0, bArr, 0, i);
        return bArr;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int getOutputSize(int i) {
        return this.forEncryption ? this.data.size() + i + this.macSize : (this.data.size() + i) - this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i) {
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters parameters;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            this.nonce = aEADParameters.getNonce();
            this.associatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            parameters = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.nonce = parametersWithIV.getIV();
            this.associatedText = null;
            this.macSize = this.macBlock.length / 2;
            parameters = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to CCM");
        }
        this.keyParam = parameters;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        this.data.write(b);
        return 0;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException, IllegalStateException {
        this.data.write(bArr, i, i2);
        return 0;
    }

    public byte[] processPacket(byte[] bArr, int i, int i2) throws IllegalStateException, InvalidCipherTextException {
        int i3;
        if (this.keyParam != null) {
            SICBlockCipher sICBlockCipher = new SICBlockCipher(this.cipher);
            byte[] bArr2 = new byte[this.blockSize];
            byte[] bArr3 = this.nonce;
            bArr2[0] = (byte) (((15 - bArr3.length) - 1) & 7);
            System.arraycopy(bArr3, 0, bArr2, 1, bArr3.length);
            sICBlockCipher.init(this.forEncryption, new ParametersWithIV(this.keyParam, bArr2));
            if (this.forEncryption) {
                int i4 = this.macSize + i2;
                byte[] bArr4 = new byte[i4];
                calculateMac(bArr, i, i2, this.macBlock);
                byte[] bArr5 = this.macBlock;
                sICBlockCipher.processBlock(bArr5, 0, bArr5, 0);
                int i5 = 0;
                while (true) {
                    int i6 = this.blockSize;
                    if (i < i2 - i6) {
                        sICBlockCipher.processBlock(bArr, i, bArr4, i5);
                        int i7 = this.blockSize;
                        i5 += i7;
                        i += i7;
                    } else {
                        byte[] bArr6 = new byte[i6];
                        int i8 = i2 - i;
                        System.arraycopy(bArr, i, bArr6, 0, i8);
                        sICBlockCipher.processBlock(bArr6, 0, bArr6, 0);
                        System.arraycopy(bArr6, 0, bArr4, i5, i8);
                        int i9 = i5 + i8;
                        System.arraycopy(this.macBlock, 0, bArr4, i9, i4 - i9);
                        return bArr4;
                    }
                }
            } else {
                int i10 = this.macSize;
                int i11 = i2 - i10;
                byte[] bArr7 = new byte[i11];
                System.arraycopy(bArr, (i2 + i) - i10, this.macBlock, 0, i10);
                byte[] bArr8 = this.macBlock;
                sICBlockCipher.processBlock(bArr8, 0, bArr8, 0);
                int i12 = this.macSize;
                while (true) {
                    byte[] bArr9 = this.macBlock;
                    if (i12 == bArr9.length) {
                        break;
                    }
                    bArr9[i12] = 0;
                    i12++;
                }
                int i13 = 0;
                while (true) {
                    i3 = this.blockSize;
                    if (i13 >= i11 - i3) {
                        break;
                    }
                    sICBlockCipher.processBlock(bArr, i, bArr7, i13);
                    int i14 = this.blockSize;
                    i13 += i14;
                    i += i14;
                }
                byte[] bArr10 = new byte[i3];
                int i15 = i11 - i13;
                System.arraycopy(bArr, i, bArr10, 0, i15);
                sICBlockCipher.processBlock(bArr10, 0, bArr10, 0);
                System.arraycopy(bArr10, 0, bArr7, i13, i15);
                byte[] bArr11 = new byte[this.blockSize];
                calculateMac(bArr7, 0, i11, bArr11);
                if (Arrays.constantTimeAreEqual(this.macBlock, bArr11)) {
                    return bArr7;
                }
                throw new InvalidCipherTextException("mac check in CCM failed");
            }
        } else {
            throw new IllegalStateException("CCM cipher unitialized.");
        }
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        this.cipher.reset();
        this.data.reset();
    }
}
