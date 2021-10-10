package org.bouncycastle.crypto.macs;

import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

public class HMac implements Mac {
    private static final byte IPAD = 54;
    private static final byte OPAD = 92;
    private static Hashtable blockLengths;
    private int blockLength;
    private Digest digest;
    private int digestSize;
    private byte[] inputPad;
    private byte[] outputPad;

    static {
        Hashtable hashtable = new Hashtable();
        blockLengths = hashtable;
        hashtable.put("GOST3411", new Integer(32));
        blockLengths.put("MD2", new Integer(16));
        blockLengths.put("MD4", new Integer(64));
        blockLengths.put("MD5", new Integer(64));
        blockLengths.put("RIPEMD128", new Integer(64));
        blockLengths.put("RIPEMD160", new Integer(64));
        blockLengths.put("SHA-1", new Integer(64));
        blockLengths.put("SHA-224", new Integer(64));
        blockLengths.put("SHA-256", new Integer(64));
        blockLengths.put("SHA-384", new Integer(128));
        blockLengths.put("SHA-512", new Integer(128));
        blockLengths.put("Tiger", new Integer(64));
        blockLengths.put("Whirlpool", new Integer(64));
    }

    public HMac(Digest digest2) {
        this(digest2, getByteLength(digest2));
    }

    private HMac(Digest digest2, int i) {
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
        this.blockLength = i;
        this.inputPad = new byte[i];
        this.outputPad = new byte[i];
    }

    private static int getByteLength(Digest digest2) {
        if (digest2 instanceof ExtendedDigest) {
            return ((ExtendedDigest) digest2).getByteLength();
        }
        Integer num = (Integer) blockLengths.get(digest2.getAlgorithmName());
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("unknown digest passed: " + digest2.getAlgorithmName());
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int i2 = this.digestSize;
        byte[] bArr2 = new byte[i2];
        this.digest.doFinal(bArr2, 0);
        Digest digest2 = this.digest;
        byte[] bArr3 = this.outputPad;
        digest2.update(bArr3, 0, bArr3.length);
        this.digest.update(bArr2, 0, i2);
        int doFinal = this.digest.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.digestSize;
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        this.digest.reset();
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        if (key.length <= this.blockLength) {
            System.arraycopy(key, 0, this.inputPad, 0, key.length);
            int length = key.length;
            while (true) {
                byte[] bArr = this.inputPad;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
        } else {
            this.digest.update(key, 0, key.length);
            this.digest.doFinal(this.inputPad, 0);
            int i = this.digestSize;
            while (true) {
                byte[] bArr2 = this.inputPad;
                if (i >= bArr2.length) {
                    break;
                }
                bArr2[i] = 0;
                i++;
            }
        }
        byte[] bArr3 = this.inputPad;
        byte[] bArr4 = new byte[bArr3.length];
        this.outputPad = bArr4;
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int i2 = 0;
        while (true) {
            byte[] bArr5 = this.inputPad;
            if (i2 >= bArr5.length) {
                break;
            }
            bArr5[i2] = (byte) (bArr5[i2] ^ IPAD);
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr6 = this.outputPad;
            if (i3 < bArr6.length) {
                bArr6[i3] = (byte) (bArr6[i3] ^ OPAD);
                i3++;
            } else {
                Digest digest2 = this.digest;
                byte[] bArr7 = this.inputPad;
                digest2.update(bArr7, 0, bArr7.length);
                return;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.digest.reset();
        Digest digest2 = this.digest;
        byte[] bArr = this.inputPad;
        digest2.update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
