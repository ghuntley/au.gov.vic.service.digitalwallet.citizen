package org.bouncycastle.crypto.modes;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class SICBlockCipher implements BlockCipher {
    private byte[] IV;
    private final int blockSize;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.IV = new byte[blockSize2];
        this.counter = new byte[blockSize2];
        this.counterOut = new byte[blockSize2];
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.IV;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            reset();
            this.cipher.init(true, parametersWithIV.getParameters());
            return;
        }
        throw new IllegalArgumentException("SIC mode requires ParametersWithIV");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.counterOut;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr2[i2 + i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
            i3++;
        }
        int i4 = 1;
        for (int length = this.counter.length - 1; length >= 0; length--) {
            byte[] bArr4 = this.counter;
            int i5 = (bArr4[length] & UByte.MAX_VALUE) + i4;
            i4 = i5 > 255 ? 1 : 0;
            bArr4[length] = (byte) i5;
        }
        return this.counter.length;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] bArr = this.IV;
        byte[] bArr2 = this.counter;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.cipher.reset();
    }
}
