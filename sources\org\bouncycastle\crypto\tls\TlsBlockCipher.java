package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class TlsBlockCipher implements TlsCipher {
    protected TlsClientContext context;
    protected BlockCipher decryptCipher;
    protected BlockCipher encryptCipher;
    protected TlsMac readMac;
    protected TlsMac writeMac;

    public TlsBlockCipher(TlsClientContext tlsClientContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) {
        this.context = tlsClientContext;
        this.encryptCipher = blockCipher;
        this.decryptCipher = blockCipher2;
        int i2 = i * 2;
        int digestSize = digest.getDigestSize() + i2 + digest2.getDigestSize() + blockCipher.getBlockSize() + blockCipher2.getBlockSize();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] PRF = TlsUtils.PRF(securityParameters.masterSecret, "key expansion", TlsUtils.concat(securityParameters.serverRandom, securityParameters.clientRandom), digestSize);
        this.writeMac = new TlsMac(digest, PRF, 0, digest.getDigestSize());
        int digestSize2 = digest.getDigestSize() + 0;
        this.readMac = new TlsMac(digest2, PRF, digestSize2, digest2.getDigestSize());
        int digestSize3 = digestSize2 + digest2.getDigestSize();
        initCipher(true, blockCipher, PRF, i, digestSize3, digestSize3 + i2);
        int i3 = digestSize3 + i;
        initCipher(false, blockCipher2, PRF, i, i3, i3 + i + blockCipher.getBlockSize());
    }

    /* access modifiers changed from: protected */
    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f  */
    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] decodeCiphertext(short s, byte[] bArr, int i, int i2) throws IOException {
        boolean z;
        byte[] calculateMac;
        byte[] bArr2;
        boolean z2 = true;
        int size = this.readMac.getSize() + 1;
        int blockSize = this.decryptCipher.getBlockSize();
        if (i2 < size) {
            throw new TlsFatalAlert(50);
        } else if (i2 % blockSize == 0) {
            for (int i3 = 0; i3 < i2; i3 += blockSize) {
                int i4 = i3 + i;
                this.decryptCipher.processBlock(bArr, i4, bArr, i4);
            }
            int i5 = (i + i2) - 1;
            byte b = bArr[i5];
            int i6 = b & UByte.MAX_VALUE;
            int i7 = i2 - size;
            if (i6 <= i7) {
                byte b2 = 0;
                for (int i8 = i5 - i6; i8 < i5; i8++) {
                    b2 = (byte) (b2 | (bArr[i8] ^ b));
                }
                if (b2 == 0) {
                    z = false;
                    int i9 = i7 - i6;
                    calculateMac = this.readMac.calculateMac(s, bArr, i, i9);
                    bArr2 = new byte[calculateMac.length];
                    System.arraycopy(bArr, i + i9, bArr2, 0, calculateMac.length);
                    if (Arrays.constantTimeAreEqual(calculateMac, bArr2)) {
                        z2 = z;
                    }
                    if (z2) {
                        byte[] bArr3 = new byte[i9];
                        System.arraycopy(bArr, i, bArr3, 0, i9);
                        return bArr3;
                    }
                    throw new TlsFatalAlert(20);
                }
            }
            z = true;
            i6 = 0;
            int i92 = i7 - i6;
            calculateMac = this.readMac.calculateMac(s, bArr, i, i92);
            bArr2 = new byte[calculateMac.length];
            System.arraycopy(bArr, i + i92, bArr2, 0, calculateMac.length);
            if (Arrays.constantTimeAreEqual(calculateMac, bArr2)) {
            }
            if (z2) {
            }
        } else {
            throw new TlsFatalAlert(21);
        }
    }

    @Override // org.bouncycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(short s, byte[] bArr, int i, int i2) {
        int blockSize = this.encryptCipher.getBlockSize();
        int size = blockSize - (((this.writeMac.getSize() + i2) + 1) % blockSize);
        int chooseExtraPadBlocks = size + (chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - size) / blockSize) * blockSize);
        int size2 = this.writeMac.getSize() + i2 + chooseExtraPadBlocks + 1;
        byte[] bArr2 = new byte[size2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        byte[] calculateMac = this.writeMac.calculateMac(s, bArr, i, i2);
        System.arraycopy(calculateMac, 0, bArr2, i2, calculateMac.length);
        int length = i2 + calculateMac.length;
        for (int i3 = 0; i3 <= chooseExtraPadBlocks; i3++) {
            bArr2[i3 + length] = (byte) chooseExtraPadBlocks;
        }
        for (int i4 = 0; i4 < size2; i4 += blockSize) {
            this.encryptCipher.processBlock(bArr2, i4, bArr2, i4);
        }
        return bArr2;
    }

    /* access modifiers changed from: protected */
    public void initCipher(boolean z, BlockCipher blockCipher, byte[] bArr, int i, int i2, int i3) {
        blockCipher.init(z, new ParametersWithIV(new KeyParameter(bArr, i2, i), bArr, i3, blockCipher.getBlockSize()));
    }

    /* access modifiers changed from: protected */
    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }
}
