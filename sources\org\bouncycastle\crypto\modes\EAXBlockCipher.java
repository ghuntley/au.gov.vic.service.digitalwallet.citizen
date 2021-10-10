package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean forEncryption;
    private Mac mac;
    private byte[] macBlock;
    private int macSize;
    private byte[] nonceMac = new byte[this.mac.getMacSize()];

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.mac = cMac;
        int i = this.blockSize;
        this.macBlock = new byte[i];
        this.bufBlock = new byte[(i * 2)];
        this.associatedTextMac = new byte[cMac.getMacSize()];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i < bArr2.length) {
                bArr2[i] = (byte) ((this.nonceMac[i] ^ this.associatedTextMac[i]) ^ bArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    private int process(byte b, byte[] bArr, int i) {
        int i2;
        byte[] bArr2 = this.bufBlock;
        int i3 = this.bufOff;
        int i4 = i3 + 1;
        this.bufOff = i4;
        bArr2[i3] = b;
        if (i4 != bArr2.length) {
            return 0;
        }
        if (this.forEncryption) {
            i2 = this.cipher.processBlock(bArr2, 0, bArr, i);
            this.mac.update(bArr, i, this.blockSize);
        } else {
            this.mac.update(bArr2, 0, this.blockSize);
            i2 = this.cipher.processBlock(this.bufBlock, 0, bArr, i);
        }
        int i5 = this.blockSize;
        this.bufOff = i5;
        byte[] bArr3 = this.bufBlock;
        System.arraycopy(bArr3, i5, bArr3, 0, i5);
        return i2;
    }

    private void reset(boolean z) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i = this.blockSize;
        byte[] bArr = new byte[i];
        bArr[i - 1] = cTAG;
        this.mac.update(bArr, 0, i);
    }

    private boolean verifyMac(byte[] bArr, int i) {
        for (int i2 = 0; i2 < this.macSize; i2++) {
            if (this.macBlock[i2] != bArr[i + i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int i2 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher = this.cipher;
            byte[] bArr4 = this.bufBlock;
            int i3 = this.blockSize;
            sICBlockCipher.processBlock(bArr4, i3, bArr3, i3);
            System.arraycopy(bArr3, 0, bArr, i, i2);
            this.mac.update(bArr3, 0, i2);
            calculateMac();
            System.arraycopy(this.macBlock, 0, bArr, i + i2, this.macSize);
            reset(false);
            return i2 + this.macSize;
        }
        int i4 = this.macSize;
        if (i2 > i4) {
            this.mac.update(bArr2, 0, i2 - i4);
            this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
            SICBlockCipher sICBlockCipher2 = this.cipher;
            byte[] bArr5 = this.bufBlock;
            int i5 = this.blockSize;
            sICBlockCipher2.processBlock(bArr5, i5, bArr3, i5);
            System.arraycopy(bArr3, 0, bArr, i, i2 - this.macSize);
        }
        calculateMac();
        if (verifyMac(this.bufBlock, i2 - this.macSize)) {
            reset(false);
            return i2 - this.macSize;
        }
        throw new InvalidCipherTextException("mac check in EAX failed");
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
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
        return this.forEncryption ? i + this.bufOff + this.macSize : (i + this.bufOff) - this.macSize;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + this.bufOff;
        int i3 = this.blockSize;
        return (i2 / i3) * i3;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        byte[] bArr2;
        this.forEncryption = z;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            bArr2 = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            bArr2 = new byte[0];
            this.macSize = this.mac.getMacSize() / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        byte[] bArr3 = new byte[this.blockSize];
        this.mac.init(cipherParameters2);
        int i = this.blockSize;
        bArr3[i - 1] = hTAG;
        this.mac.update(bArr3, 0, i);
        this.mac.update(bArr2, 0, bArr2.length);
        this.mac.doFinal(this.associatedTextMac, 0);
        int i2 = this.blockSize;
        bArr3[i2 - 1] = 0;
        this.mac.update(bArr3, 0, i2);
        this.mac.update(bArr, 0, bArr.length);
        this.mac.doFinal(this.nonceMac, 0);
        int i3 = this.blockSize;
        bArr3[i3 - 1] = cTAG;
        this.mac.update(bArr3, 0, i3);
        this.cipher.init(true, new ParametersWithIV(cipherParameters2, this.nonceMac));
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processByte(byte b, byte[] bArr, int i) throws DataLengthException {
        return process(b, bArr, i);
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        int i4 = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            i4 += process(bArr[i + i5], bArr2, i3 + i4);
        }
        return i4;
    }

    @Override // org.bouncycastle.crypto.modes.AEADBlockCipher
    public void reset() {
        reset(true);
    }
}
