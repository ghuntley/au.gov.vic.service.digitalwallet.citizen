package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* access modifiers changed from: package-private */
public final class zzbl {
    static int zza(byte[] bArr, int i, zzbk zzbk) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzbk);
        }
        zzbk.zzako = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzbk zzbk) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzbk.zzako = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzbk.zzako = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzbk.zzako = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzbk.zzako = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzbk.zzako = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzbk zzbk) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzbk.zzakp = j;
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
        zzbk.zzakp = j2;
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

    static int zzc(byte[] bArr, int i, zzbk zzbk) throws zzdf {
        int zza = zza(bArr, i, zzbk);
        int i2 = zzbk.zzako;
        if (i2 < 0) {
            throw zzdf.zzcg();
        } else if (i2 == 0) {
            zzbk.zzakq = "";
            return zza;
        } else {
            zzbk.zzakq = new String(bArr, zza, i2, zzcy.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzbk zzbk) throws zzdf {
        int zza = zza(bArr, i, zzbk);
        int i2 = zzbk.zzako;
        if (i2 < 0) {
            throw zzdf.zzcg();
        } else if (i2 == 0) {
            zzbk.zzakq = "";
            return zza;
        } else {
            zzbk.zzakq = zzfv.zzg(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzbk zzbk) throws zzdf {
        int zza = zza(bArr, i, zzbk);
        int i2 = zzbk.zzako;
        if (i2 < 0) {
            throw zzdf.zzcg();
        } else if (i2 > bArr.length - zza) {
            throw zzdf.zzcf();
        } else if (i2 == 0) {
            zzbk.zzakq = zzbp.zzakv;
            return zza;
        } else {
            zzbk.zzakq = zzbp.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zza(zzeu zzeu, byte[] bArr, int i, int i2, zzbk zzbk) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzbk);
            b2 = zzbk.zzako;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzdf.zzcf();
        }
        Object newInstance = zzeu.newInstance();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzeu.zza(newInstance, bArr, i3, i4, zzbk);
        zzeu.zzc(newInstance);
        zzbk.zzakq = newInstance;
        return i4;
    }

    static int zza(zzeu zzeu, byte[] bArr, int i, int i2, int i3, zzbk zzbk) throws IOException {
        zzej zzej = (zzej) zzeu;
        Object newInstance = zzej.newInstance();
        int zza = zzej.zza(newInstance, bArr, i, i2, i3, zzbk);
        zzej.zzc(newInstance);
        zzbk.zzakq = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdc<?> zzdc, zzbk zzbk) {
        zzcz zzcz = (zzcz) zzdc;
        int zza = zza(bArr, i2, zzbk);
        zzcz.zzal(zzbk.zzako);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzbk);
            if (i != zzbk.zzako) {
                break;
            }
            zza = zza(bArr, zza2, zzbk);
            zzcz.zzal(zzbk.zzako);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzdc<?> zzdc, zzbk zzbk) throws IOException {
        zzcz zzcz = (zzcz) zzdc;
        int zza = zza(bArr, i, zzbk);
        int i2 = zzbk.zzako + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzbk);
            zzcz.zzal(zzbk.zzako);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzdf.zzcf();
    }

    static int zza(zzeu<?> zzeu, int i, byte[] bArr, int i2, int i3, zzdc<?> zzdc, zzbk zzbk) throws IOException {
        int zza = zza(zzeu, bArr, i2, i3, zzbk);
        zzdc.add(zzbk.zzakq);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzbk);
            if (i != zzbk.zzako) {
                break;
            }
            zza = zza(zzeu, bArr, zza2, i3, zzbk);
            zzdc.add(zzbk.zzakq);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfp zzfp, zzbk zzbk) throws zzdf {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzbk);
                zzfp.zzb(i, Long.valueOf(zzbk.zzakp));
                return zzb;
            } else if (i4 == 1) {
                zzfp.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzbk);
                int i5 = zzbk.zzako;
                if (i5 < 0) {
                    throw zzdf.zzcg();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzfp.zzb(i, zzbp.zzakv);
                    } else {
                        zzfp.zzb(i, zzbp.zzb(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzdf.zzcf();
                }
            } else if (i4 == 3) {
                zzfp zzeb = zzfp.zzeb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzbk);
                    int i8 = zzbk.zzako;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzeb, zzbk);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzdf.zzcl();
                }
                zzfp.zzb(i, zzeb);
                return i2;
            } else if (i4 == 5) {
                zzfp.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzdf.zzci();
            }
        } else {
            throw zzdf.zzci();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzbk zzbk) throws zzdf {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzbk);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzbk) + zzbk.zzako;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzbk);
                    i6 = zzbk.zzako;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzbk);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzdf.zzcl();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzdf.zzci();
            }
        } else {
            throw zzdf.zzci();
        }
    }
}
