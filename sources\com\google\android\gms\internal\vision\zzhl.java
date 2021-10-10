package com.google.android.gms.internal.vision;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzhl {
    static int zza(byte[] bArr, int i, zzhn zzhn) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzhn);
        }
        zzhn.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzhn zzhn) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzhn.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzhn.zza = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzhn.zza = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzhn.zza = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzhn.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzhn zzhn) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzhn.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzhn.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzhn zzhn) throws zzjk {
        int zza = zza(bArr, i, zzhn);
        int i2 = zzhn.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        } else if (i2 == 0) {
            zzhn.zzc = "";
            return zza;
        } else {
            zzhn.zzc = new String(bArr, zza, i2, zzjf.zza);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzhn zzhn) throws zzjk {
        int zza = zza(bArr, i, zzhn);
        int i2 = zzhn.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        } else if (i2 == 0) {
            zzhn.zzc = "";
            return zza;
        } else {
            zzhn.zzc = zzmd.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzhn zzhn) throws zzjk {
        int zza = zza(bArr, i, zzhn);
        int i2 = zzhn.zza;
        if (i2 < 0) {
            throw zzjk.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzjk.zza();
        } else if (i2 == 0) {
            zzhn.zzc = zzht.zza;
            return zza;
        } else {
            zzhn.zzc = zzht.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zza(zzlc zzlc, byte[] bArr, int i, int i2, zzhn zzhn) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzhn);
            b2 = zzhn.zza;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzjk.zza();
        }
        Object zza = zzlc.zza();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzlc.zza(zza, bArr, i3, i4, zzhn);
        zzlc.zzc(zza);
        zzhn.zzc = zza;
        return i4;
    }

    static int zza(zzlc zzlc, byte[] bArr, int i, int i2, int i3, zzhn zzhn) throws IOException {
        zzko zzko = (zzko) zzlc;
        Object zza = zzko.zza();
        int zza2 = zzko.zza(zza, bArr, i, i2, i3, zzhn);
        zzko.zzc(zza);
        zzhn.zzc = zza;
        return zza2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzjl<?> zzjl, zzhn zzhn) {
        zzjd zzjd = (zzjd) zzjl;
        int zza = zza(bArr, i2, zzhn);
        zzjd.zzc(zzhn.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzhn);
            if (i != zzhn.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzhn);
            zzjd.zzc(zzhn.zza);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzjl<?> zzjl, zzhn zzhn) throws IOException {
        zzjd zzjd = (zzjd) zzjl;
        int zza = zza(bArr, i, zzhn);
        int i2 = zzhn.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzhn);
            zzjd.zzc(zzhn.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzjk.zza();
    }

    static int zza(zzlc<?> zzlc, int i, byte[] bArr, int i2, int i3, zzjl<?> zzjl, zzhn zzhn) throws IOException {
        int zza = zza(zzlc, bArr, i2, i3, zzhn);
        zzjl.add(zzhn.zzc);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzhn);
            if (i != zzhn.zza) {
                break;
            }
            zza = zza(zzlc, bArr, zza2, i3, zzhn);
            zzjl.add(zzhn.zzc);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzlx zzlx, zzhn zzhn) throws zzjk {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzhn);
                zzlx.zza(i, Long.valueOf(zzhn.zzb));
                return zzb;
            } else if (i4 == 1) {
                zzlx.zza(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzhn);
                int i5 = zzhn.zza;
                if (i5 < 0) {
                    throw zzjk.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzlx.zza(i, zzht.zza);
                    } else {
                        zzlx.zza(i, zzht.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzjk.zza();
                }
            } else if (i4 == 3) {
                zzlx zzb2 = zzlx.zzb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzhn);
                    int i8 = zzhn.zza;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzb2, zzhn);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzjk.zzg();
                }
                zzlx.zza(i, zzb2);
                return i2;
            } else if (i4 == 5) {
                zzlx.zza(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzjk.zzd();
            }
        } else {
            throw zzjk.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhn zzhn) throws zzjk {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzhn);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzhn) + zzhn.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzhn);
                    i6 = zzhn.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzhn);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzjk.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzjk.zzd();
            }
        } else {
            throw zzjk.zzd();
        }
    }
}
