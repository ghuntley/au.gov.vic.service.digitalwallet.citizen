package org.bouncycastle.crypto.params;

import org.msgpack.core.MessagePack;

public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = {1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, 14, 14, 14, 14, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, MessagePack.Code.NEGFIXINT_PREFIX, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, MessagePack.Code.NEGFIXINT_PREFIX, 31, MessagePack.Code.NEGFIXINT_PREFIX, 14, -15, 14, -15, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, -15, 1, -15, 31, -2, 31, -2, 14, -2, 14, -2, 1, 31, 1, 31, 1, 14, 1, 14, MessagePack.Code.NEGFIXINT_PREFIX, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, MessagePack.Code.NEGFIXINT_PREFIX, 31, MessagePack.Code.NEGFIXINT_PREFIX, 31, -15, 14, -15, 14, MessagePack.Code.NEGFIXINT_PREFIX, 1, MessagePack.Code.NEGFIXINT_PREFIX, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, 14, -2, 14, 31, 1, 31, 1, 14, 1, 14, 1, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, MessagePack.Code.NEGFIXINT_PREFIX, -2, -15, -2, -15};
    private static final int N_DES_WEAK_KEYS = 16;

    public DESParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    public static boolean isWeakKey(byte[] bArr, int i) {
        if (bArr.length - i >= 8) {
            for (int i2 = 0; i2 < 16; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if (bArr[i3 + i] != DES_weak_keys[(i2 * 8) + i3]) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("key material too short.");
    }

    public static void setOddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
