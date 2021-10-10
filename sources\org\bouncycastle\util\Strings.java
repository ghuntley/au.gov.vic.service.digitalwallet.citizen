package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.util.Vector;
import kotlin.UByte;
import org.msgpack.core.MessagePack;
import org.objectweb.asm.Opcodes;

public final class Strings {
    public static String fromUTF8ByteArray(byte[] bArr) {
        char c;
        int i;
        byte b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            if ((bArr[i3] & 240) == 240) {
                i4++;
                i3 += 4;
            } else {
                i3 = (bArr[i3] & MessagePack.Code.NEGFIXINT_PREFIX) == 224 ? i3 + 3 : (bArr[i3] & MessagePack.Code.NIL) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 240) == 240) {
                int i6 = (((((bArr[i2] & 3) << 18) | ((bArr[i2 + 1] & 63) << 12)) | ((bArr[i2 + 2] & 63) << 6)) | (bArr[i2 + 3] & 63)) - 65536;
                c = (char) ((i6 & 1023) | 56320);
                cArr[i5] = (char) (55296 | (i6 >> 10));
                i2 += 4;
                i5++;
            } else if ((bArr[i2] & MessagePack.Code.NEGFIXINT_PREFIX) == 224) {
                c = (char) (((bArr[i2] & 15) << 12) | ((bArr[i2 + 1] & 63) << 6) | (bArr[i2 + 2] & 63));
                i2 += 3;
            } else {
                if ((bArr[i2] & MessagePack.Code.INT8) == 208) {
                    i = (bArr[i2] & 31) << 6;
                    b = bArr[i2 + 1];
                } else if ((bArr[i2] & MessagePack.Code.NIL) == 192) {
                    i = (bArr[i2] & 31) << 6;
                    b = bArr[i2 + 1];
                } else {
                    c = (char) (bArr[i2] & UByte.MAX_VALUE);
                    i2++;
                }
                c = (char) (i | (b & 63));
                i2 += 2;
            }
            cArr[i5] = c;
            i5++;
        }
        return new String(cArr);
    }

    public static String[] split(String str, char c) {
        int i;
        Vector vector = new Vector();
        boolean z = true;
        while (true) {
            if (!z) {
                break;
            }
            int indexOf = str.indexOf(c);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i = 0; i != size; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        char c;
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < cArr.length) {
            char c2 = cArr[i2];
            char c3 = c2;
            if (c2 >= 128) {
                if (c2 < 2048) {
                    i = (c2 >> 6) | Opcodes.CHECKCAST;
                } else if (c2 < 55296 || c2 > 57343) {
                    byteArrayOutputStream.write((c2 >> '\f') | 224);
                    i = ((c2 >> 6) & 63) | 128;
                } else {
                    i2++;
                    if (i2 < cArr.length) {
                        char c4 = cArr[i2];
                        if (c2 <= 56319) {
                            int i3 = (((c2 & 1023) << 10) | (c4 & 1023)) + 65536;
                            byteArrayOutputStream.write((i3 >> 18) | 240);
                            byteArrayOutputStream.write(((i3 >> 12) & 63) | 128);
                            byteArrayOutputStream.write(((i3 >> 6) & 63) | 128);
                            c = i3;
                            c3 = ((c == 1 ? 1 : 0) & 63) | 128;
                        } else {
                            throw new IllegalStateException("invalid UTF-16 codepoint");
                        }
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                }
                byteArrayOutputStream.write(i);
                c = c2;
                c3 = ((c == 1 ? 1 : 0) & 63) | 128;
            }
            byteArrayOutputStream.write(c3 == 1 ? 1 : 0);
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
