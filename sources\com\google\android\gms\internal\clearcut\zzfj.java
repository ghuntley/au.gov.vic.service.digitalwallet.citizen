package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

final class zzfj extends zzfg {
    zzfj() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return zzff.zzam(i);
        }
        if (i2 == 1) {
            return zzff.zzp(i, zzfd.zza(bArr, j));
        }
        if (i2 == 2) {
            return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.clearcut.zzfg
    public final int zzb(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j = (long) i2;
            int i5 = (int) (((long) i3) - j);
            if (i5 >= 16) {
                i4 = 0;
                long j2 = j;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j3 = j2 + 1;
                    if (zzfd.zza(bArr, j2) < 0) {
                        break;
                    }
                    i4++;
                    j2 = j3;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j4 = j + ((long) i4);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j5 = j4 + 1;
                    byte zza = zzfd.zza(bArr, j4);
                    if (zza < 0) {
                        b = zza;
                        j4 = j5;
                        break;
                    }
                    i6--;
                    b = zza;
                    j4 = j5;
                }
                if (i6 != 0) {
                    int i7 = i6 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i7 >= 3) {
                                i6 = i7 - 3;
                                long j6 = j4 + 1;
                                byte zza2 = zzfd.zza(bArr, j4);
                                if (zza2 > -65 || (((b << 28) + (zza2 + 112)) >> 30) != 0) {
                                    break;
                                }
                                long j7 = j6 + 1;
                                if (zzfd.zza(bArr, j6) > -65) {
                                    break;
                                }
                                j4 = j7 + 1;
                                if (zzfd.zza(bArr, j7) > -65) {
                                    break;
                                }
                            } else {
                                return zza(bArr, b, j4, i7);
                            }
                        } else if (i7 >= 2) {
                            i6 = i7 - 2;
                            long j8 = j4 + 1;
                            byte zza3 = zzfd.zza(bArr, j4);
                            if (zza3 > -65 || ((b == -32 && zza3 < -96) || (b == -19 && zza3 >= -96))) {
                                break;
                            }
                            j4 = j8 + 1;
                            if (zzfd.zza(bArr, j8) > -65) {
                                break;
                            }
                        } else {
                            return zza(bArr, b, j4, i7);
                        }
                    } else if (i7 != 0) {
                        i6 = i7 - 1;
                        if (b < -62) {
                            break;
                        }
                        long j9 = j4 + 1;
                        if (zzfd.zza(bArr, j4) > -65) {
                            break;
                        }
                        j4 = j9;
                    } else {
                        return b;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.clearcut.zzfg
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        char c;
        long j2;
        int i3;
        char charAt;
        long j3 = (long) i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            char c2 = 128;
            long j5 = 1;
            if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                zzfd.zza(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            } else if (i4 != length) {
                return (int) j3;
            } else {
                while (i4 < length) {
                    char charAt3 = charSequence.charAt(i4);
                    if (charAt3 < c2 && j3 < j4) {
                        long j6 = j3 + j5;
                        zzfd.zza(bArr, j3, (byte) charAt3);
                        j2 = j5;
                        j = j6;
                        c = c2;
                    } else if (charAt3 < 2048 && j3 <= j4 - 2) {
                        long j7 = j3 + j5;
                        zzfd.zza(bArr, j3, (byte) ((charAt3 >>> 6) | 960));
                        long j8 = j7 + j5;
                        zzfd.zza(bArr, j7, (byte) ((charAt3 & '?') | 128));
                        c = 128;
                        j = j8;
                        j2 = j5;
                    } else if ((charAt3 < 55296 || 57343 < charAt3) && j3 <= j4 - 3) {
                        long j9 = j3 + j5;
                        zzfd.zza(bArr, j3, (byte) ((charAt3 >>> '\f') | 480));
                        long j10 = j9 + j5;
                        zzfd.zza(bArr, j9, (byte) (((charAt3 >>> 6) & 63) | 128));
                        zzfd.zza(bArr, j10, (byte) ((charAt3 & '?') | 128));
                        j = j10 + 1;
                        j2 = 1;
                        c = 128;
                    } else if (j3 <= j4 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j11 = j3 + 1;
                                zzfd.zza(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                c = 128;
                                zzfd.zza(bArr, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j13 = j12 + 1;
                                zzfd.zza(bArr, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                                j2 = 1;
                                j = j13 + 1;
                                zzfd.zza(bArr, j13, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new zzfi(i4 - 1, length);
                    } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j3);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    } else {
                        throw new zzfi(i4, length);
                    }
                    i4++;
                    c2 = c;
                    j3 = j;
                    j5 = j2;
                }
                return (int) j3;
            }
        }
        if (i4 != length) {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042 A[LOOP:1: B:12:0x0042->B:37:0x0107, LOOP_START, PHI: r2 r4 r6 r9 r12 
      PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x003a, B:37:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v5 long) = (r4v4 long), (r4v7 long) binds: [B:8:0x003a, B:37:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v3 long) = (r6v2 long), (r6v4 long) binds: [B:8:0x003a, B:37:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v4 int) = (r9v3 int), (r9v6 int) binds: [B:8:0x003a, B:37:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v1 char) = (r12v0 char), (r12v2 char) binds: [B:8:0x003a, B:37:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
    @Override // com.google.android.gms.internal.clearcut.zzfg
    public final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        long j;
        long j2;
        char c;
        int i2;
        int i3;
        char charAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long zzb = zzfd.zzb(byteBuffer);
        long position = ((long) byteBuffer.position()) + zzb;
        long limit = ((long) byteBuffer.limit()) + zzb;
        int length = charSequence.length();
        if (((long) length) <= limit - position) {
            int i4 = 0;
            while (true) {
                char c2 = 128;
                if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                    zzfd.zza(position, (byte) charAt);
                    i4++;
                    position++;
                } else if (i4 != length) {
                    i = (int) (position - zzb);
                } else {
                    while (i4 < length) {
                        char charAt2 = charSequence.charAt(i4);
                        if (charAt2 >= c2 || position >= limit) {
                            if (charAt2 >= 2048 || position > limit - 2) {
                                j2 = zzb;
                                if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                                    long j3 = position + 1;
                                    zzfd.zza(position, (byte) ((charAt2 >>> '\f') | 480));
                                    long j4 = j3 + 1;
                                    zzfd.zza(j3, (byte) (((charAt2 >>> 6) & 63) | 128));
                                    zzfd.zza(j4, (byte) ((charAt2 & '?') | 128));
                                    position = j4 + 1;
                                } else if (position <= limit - 4) {
                                    i2 = i4 + 1;
                                    if (i2 != length) {
                                        char charAt3 = charSequence.charAt(i2);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            j = limit;
                                            long j5 = position + 1;
                                            zzfd.zza(position, (byte) ((codePoint >>> 18) | 240));
                                            long j6 = j5 + 1;
                                            c = 128;
                                            zzfd.zza(j5, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j7 = j6 + 1;
                                            zzfd.zza(j6, (byte) (((codePoint >>> 6) & 63) | 128));
                                            zzfd.zza(j7, (byte) ((codePoint & 63) | 128));
                                            position = j7 + 1;
                                        } else {
                                            i4 = i2;
                                        }
                                    }
                                    throw new zzfi(i4 - 1, length);
                                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                    StringBuilder sb = new StringBuilder(46);
                                    sb.append("Failed writing ");
                                    sb.append(charAt2);
                                    sb.append(" at index ");
                                    sb.append(position);
                                    throw new ArrayIndexOutOfBoundsException(sb.toString());
                                } else {
                                    throw new zzfi(i4, length);
                                }
                            } else {
                                j2 = zzb;
                                long j8 = position + 1;
                                zzfd.zza(position, (byte) ((charAt2 >>> 6) | 960));
                                zzfd.zza(j8, (byte) ((charAt2 & '?') | 128));
                                position = j8 + 1;
                            }
                            j = limit;
                            i2 = i4;
                            c = 128;
                        } else {
                            zzfd.zza(position, (byte) charAt2);
                            j = limit;
                            i2 = i4;
                            c = c2;
                            position++;
                            j2 = zzb;
                        }
                        c2 = c;
                        zzb = j2;
                        limit = j;
                        i4 = i2 + 1;
                    }
                    i = (int) (position - zzb);
                    byteBuffer2 = byteBuffer;
                }
            }
            if (i4 != length) {
            }
            byteBuffer2.position(i);
            return;
        }
        char charAt4 = charSequence.charAt(length - 1);
        int limit2 = byteBuffer.limit();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Failed writing ");
        sb2.append(charAt4);
        sb2.append(" at index ");
        sb2.append(limit2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}
