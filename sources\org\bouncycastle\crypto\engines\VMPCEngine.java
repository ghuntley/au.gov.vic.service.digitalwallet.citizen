package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCEngine implements StreamCipher {
    protected byte[] P = null;
    protected byte n = 0;
    protected byte s = 0;
    protected byte[] workingIV;
    protected byte[] workingKey;

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
            if (parametersWithIV.getParameters() instanceof KeyParameter) {
                byte[] iv = parametersWithIV.getIV();
                this.workingIV = iv;
                if (iv == null || iv.length < 1 || iv.length > 768) {
                    throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
                }
                byte[] key = keyParameter.getKey();
                this.workingKey = key;
                initKey(key, this.workingIV);
                return;
            }
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        throw new IllegalArgumentException("VMPC init parameters must include an IV");
    }

    /* access modifiers changed from: protected */
    public void initKey(byte[] bArr, byte[] bArr2) {
        this.s = 0;
        this.P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.P;
            int i3 = i2 & 255;
            byte b = bArr3[(this.s + bArr3[i3] + bArr[i2 % bArr.length]) & 255];
            this.s = b;
            byte b2 = bArr3[i3];
            bArr3[i3] = bArr3[b & UByte.MAX_VALUE];
            bArr3[b & UByte.MAX_VALUE] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.P;
            int i5 = i4 & 255;
            byte b3 = bArr4[(this.s + bArr4[i5] + bArr2[i4 % bArr2.length]) & 255];
            this.s = b3;
            byte b4 = bArr4[i5];
            bArr4[i5] = bArr4[b3 & UByte.MAX_VALUE];
            bArr4[b3 & UByte.MAX_VALUE] = b4;
        }
        this.n = 0;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 < i2; i4++) {
                byte[] bArr3 = this.P;
                byte b = this.s;
                byte b2 = this.n;
                byte b3 = bArr3[(b + bArr3[b2 & UByte.MAX_VALUE]) & 255];
                this.s = b3;
                byte b4 = bArr3[(bArr3[bArr3[b3 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
                byte b5 = bArr3[b2 & UByte.MAX_VALUE];
                bArr3[b2 & UByte.MAX_VALUE] = bArr3[b3 & UByte.MAX_VALUE];
                bArr3[b3 & UByte.MAX_VALUE] = b5;
                this.n = (byte) ((b2 + 1) & 255);
                bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b4);
            }
        } else {
            throw new DataLengthException("output buffer too short");
        }
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        byte[] bArr = this.P;
        byte b2 = this.s;
        byte b3 = this.n;
        byte b4 = bArr[(b2 + bArr[b3 & UByte.MAX_VALUE]) & 255];
        this.s = b4;
        byte b5 = bArr[(bArr[bArr[b4 & UByte.MAX_VALUE] & UByte.MAX_VALUE] + 1) & 255];
        byte b6 = bArr[b3 & UByte.MAX_VALUE];
        bArr[b3 & UByte.MAX_VALUE] = bArr[b4 & UByte.MAX_VALUE];
        bArr[b4 & UByte.MAX_VALUE] = b6;
        this.n = (byte) ((b3 + 1) & 255);
        return (byte) (b ^ b5);
    }
}
