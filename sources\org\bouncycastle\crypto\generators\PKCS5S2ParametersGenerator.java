package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    private Mac hMac = new HMac(new SHA1Digest());

    private void F(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, int i2) {
        int macSize = this.hMac.getMacSize();
        byte[] bArr5 = new byte[macSize];
        KeyParameter keyParameter = new KeyParameter(bArr);
        this.hMac.init(keyParameter);
        if (bArr2 != null) {
            this.hMac.update(bArr2, 0, bArr2.length);
        }
        this.hMac.update(bArr3, 0, bArr3.length);
        this.hMac.doFinal(bArr5, 0);
        System.arraycopy(bArr5, 0, bArr4, i2, macSize);
        if (i != 0) {
            for (int i3 = 1; i3 < i; i3++) {
                this.hMac.init(keyParameter);
                this.hMac.update(bArr5, 0, macSize);
                this.hMac.doFinal(bArr5, 0);
                for (int i4 = 0; i4 != macSize; i4++) {
                    int i5 = i2 + i4;
                    bArr4[i5] = (byte) (bArr4[i5] ^ bArr5[i4]);
                }
            }
            return;
        }
        throw new IllegalArgumentException("iteration count must be at least 1.");
    }

    private byte[] generateDerivedKey(int i) {
        int macSize = this.hMac.getMacSize();
        int i2 = ((i + macSize) - 1) / macSize;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[(i2 * macSize)];
        for (int i3 = 1; i3 <= i2; i3++) {
            intToOctet(bArr, i3);
            F(this.password, this.salt, this.iterationCount, bArr, bArr2, (i3 - 1) * macSize);
        }
        return bArr2;
    }

    private void intToOctet(byte[] bArr, int i) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(i2), 0, i2);
    }

    @Override // org.bouncycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] generateDerivedKey = generateDerivedKey(i3 + i4);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i3), generateDerivedKey, i3, i4);
    }
}
