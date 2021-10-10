package org.bouncycastle.crypto;

public class StreamBlockCipher implements StreamCipher {
    private BlockCipher cipher;
    private byte[] oneByte = new byte[1];

    public StreamBlockCipher(BlockCipher blockCipher) {
        if (blockCipher.getBlockSize() == 1) {
            this.cipher = blockCipher;
            return;
        }
        throw new IllegalArgumentException("block cipher block size != 1.");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.cipher.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (i3 + i2 <= bArr2.length) {
            for (int i4 = 0; i4 != i2; i4++) {
                this.cipher.processBlock(bArr, i + i4, bArr2, i3 + i4);
            }
            return;
        }
        throw new DataLengthException("output buffer too small in processBytes()");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        this.cipher.reset();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        byte[] bArr = this.oneByte;
        bArr[0] = b;
        this.cipher.processBlock(bArr, 0, bArr, 0);
        return this.oneByte[0];
    }
}
