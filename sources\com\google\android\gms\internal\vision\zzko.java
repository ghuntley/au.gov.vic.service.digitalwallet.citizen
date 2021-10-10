package com.google.android.gms.internal.vision;

import android.util.EventLogTags;
import com.google.android.gms.internal.vision.zzjb;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzko<T> implements zzlc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzma.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzkk zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzks zzo;
    private final zzju zzp;
    private final zzlu<?, ?> zzq;
    private final zziq<?> zzr;
    private final zzkh zzs;

    private zzko(int[] iArr, Object[] objArr, int i, int i2, zzkk zzkk, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzks zzks, zzju zzju, zzlu<?, ?> zzlu, zziq<?> zziq, zzkh zzkh) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzkk instanceof zzjb;
        this.zzj = z;
        this.zzh = zziq != null && zziq.zza(zzkk);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzks;
        this.zzp = zzju;
        this.zzq = zzlu;
        this.zzr = zziq;
        this.zzg = zzkk;
        this.zzs = zzkh;
    }

    private static boolean zzf(int i) {
        return (i & PKIFailureInfo.duplicateCertReq) != 0;
    }

    static <T> zzko<T> zza(Class<T> cls, zzki zzki, zzks zzks, zzju zzju, zzlu<?, ?> zzlu, zziq<?> zziq, zzkh zzkh) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        String str;
        int i12;
        boolean z;
        int i13;
        int i14;
        int i15;
        boolean z2;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        int i19;
        Field field2;
        Field field3;
        int i20;
        char charAt2;
        int i21;
        char charAt3;
        int i22;
        char charAt4;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        int i27;
        char charAt9;
        int i28;
        char charAt10;
        int i29;
        char charAt11;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        if (zzki instanceof zzla) {
            zzla zzla = (zzla) zzki;
            int i32 = 0;
            boolean z3 = zzla.zza() == zzkz.zzb;
            String zzd2 = zzla.zzd();
            int length = zzd2.length();
            if (zzd2.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i = i33 + 1;
                    if (zzd2.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i;
                }
            } else {
                i = 1;
            }
            int i34 = i + 1;
            int charAt14 = zzd2.charAt(i);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = zzd2.charAt(i34);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i35 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i31;
                }
                charAt14 = i35 | (charAt13 << i36);
                i34 = i31;
            }
            if (charAt14 == 0) {
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                iArr = zza;
                i7 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = zzd2.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = zzd2.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i30;
                    }
                    charAt15 = i38 | (charAt12 << i39);
                    i37 = i30;
                }
                int i40 = i37 + 1;
                int charAt16 = zzd2.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = zzd2.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i41 |= (charAt11 & 8191) << i42;
                        i42 += 13;
                        i40 = i29;
                    }
                    charAt16 = i41 | (charAt11 << i42);
                    i40 = i29;
                }
                int i43 = i40 + 1;
                i6 = zzd2.charAt(i40);
                if (i6 >= 55296) {
                    int i44 = i6 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = zzd2.charAt(i43);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i44 |= (charAt10 & 8191) << i45;
                        i45 += 13;
                        i43 = i28;
                    }
                    i6 = i44 | (charAt10 << i45);
                    i43 = i28;
                }
                int i46 = i43 + 1;
                i5 = zzd2.charAt(i43);
                if (i5 >= 55296) {
                    int i47 = i5 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = zzd2.charAt(i46);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i47 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i46 = i27;
                    }
                    i5 = i47 | (charAt9 << i48);
                    i46 = i27;
                }
                int i49 = i46 + 1;
                i4 = zzd2.charAt(i46);
                if (i4 >= 55296) {
                    int i50 = i4 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = zzd2.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i50 |= (charAt8 & 8191) << i51;
                        i51 += 13;
                        i49 = i26;
                    }
                    i4 = i50 | (charAt8 << i51);
                    i49 = i26;
                }
                int i52 = i49 + 1;
                i3 = zzd2.charAt(i49);
                if (i3 >= 55296) {
                    int i53 = i3 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = zzd2.charAt(i52);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i53 |= (charAt7 & 8191) << i54;
                        i54 += 13;
                        i52 = i25;
                    }
                    i3 = i53 | (charAt7 << i54);
                    i52 = i25;
                }
                int i55 = i52 + 1;
                int charAt17 = zzd2.charAt(i52);
                if (charAt17 >= 55296) {
                    int i56 = charAt17 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = zzd2.charAt(i55);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i57;
                        i57 += 13;
                        i55 = i24;
                    }
                    charAt17 = i56 | (charAt6 << i57);
                    i55 = i24;
                }
                int i58 = i55 + 1;
                i2 = zzd2.charAt(i55);
                if (i2 >= 55296) {
                    int i59 = i2 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = zzd2.charAt(i60);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i59 |= (charAt5 & 8191) << i61;
                        i61 += 13;
                        i60 = i23;
                    }
                    i2 = i59 | (charAt5 << i61);
                    i58 = i23;
                }
                i7 = (charAt15 << 1) + charAt16;
                iArr = new int[(i2 + i3 + charAt17)];
                i32 = charAt15;
                i34 = i58;
            }
            Unsafe unsafe = zzb;
            Object[] zze2 = zzla.zze();
            Class<?> cls2 = zzla.zzc().getClass();
            int[] iArr2 = new int[(i4 * 3)];
            Object[] objArr = new Object[(i4 << 1)];
            int i62 = i2 + i3;
            int i63 = i7;
            int i64 = i2;
            int i65 = i34;
            int i66 = i62;
            int i67 = 0;
            int i68 = 0;
            while (i65 < length) {
                int i69 = i65 + 1;
                int charAt18 = zzd2.charAt(i65);
                if (charAt18 >= 55296) {
                    int i70 = charAt18 & 8191;
                    int i71 = i69;
                    int i72 = 13;
                    while (true) {
                        i22 = i71 + 1;
                        charAt4 = zzd2.charAt(i71);
                        i8 = length;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i70 |= (charAt4 & 8191) << i72;
                        i72 += 13;
                        i71 = i22;
                        length = i8;
                    }
                    charAt18 = i70 | (charAt4 << i72);
                    i9 = i22;
                } else {
                    i8 = length;
                    i9 = i69;
                }
                int i73 = i9 + 1;
                int charAt19 = zzd2.charAt(i9);
                if (charAt19 >= 55296) {
                    int i74 = charAt19 & 8191;
                    int i75 = i73;
                    int i76 = 13;
                    while (true) {
                        i21 = i75 + 1;
                        charAt3 = zzd2.charAt(i75);
                        i10 = i2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i74 |= (charAt3 & 8191) << i76;
                        i76 += 13;
                        i75 = i21;
                        i2 = i10;
                    }
                    charAt19 = i74 | (charAt3 << i76);
                    i11 = i21;
                } else {
                    i10 = i2;
                    i11 = i73;
                }
                int i77 = charAt19 & 255;
                if ((charAt19 & 1024) != 0) {
                    iArr[i67] = i68;
                    i67++;
                }
                if (i77 >= 51) {
                    int i78 = i11 + 1;
                    int charAt20 = zzd2.charAt(i11);
                    char c = 55296;
                    if (charAt20 >= 55296) {
                        int i79 = charAt20 & 8191;
                        int i80 = 13;
                        while (true) {
                            i20 = i78 + 1;
                            charAt2 = zzd2.charAt(i78);
                            if (charAt2 < c) {
                                break;
                            }
                            i79 |= (charAt2 & 8191) << i80;
                            i80 += 13;
                            i78 = i20;
                            c = 55296;
                        }
                        charAt20 = i79 | (charAt2 << i80);
                        i78 = i20;
                    }
                    int i81 = i77 - 51;
                    if (i81 == 9 || i81 == 17) {
                        i19 = 1;
                        objArr[((i68 / 3) << 1) + 1] = zze2[i63];
                        i63++;
                    } else {
                        if (i81 == 12 && !z3) {
                            objArr[((i68 / 3) << 1) + 1] = zze2[i63];
                            i63++;
                        }
                        i19 = 1;
                    }
                    int i82 = charAt20 << i19;
                    Object obj = zze2[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zze2[i82] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = zze2[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zze2[i83] = field3;
                    }
                    str = zzd2;
                    i13 = (int) unsafe.objectFieldOffset(field3);
                    z2 = z3;
                    i14 = objectFieldOffset;
                    i12 = i78;
                    i15 = 0;
                    z = true;
                } else {
                    int i84 = i63 + 1;
                    Field zza2 = zza(cls2, (String) zze2[i63]);
                    if (i77 == 9 || i77 == 17) {
                        objArr[((i68 / 3) << 1) + 1] = zza2.getType();
                    } else {
                        if (i77 == 27 || i77 == 49) {
                            i18 = i84 + 1;
                            objArr[((i68 / 3) << 1) + 1] = zze2[i84];
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            if (!z3) {
                                i18 = i84 + 1;
                                objArr[((i68 / 3) << 1) + 1] = zze2[i84];
                            }
                        } else if (i77 == 50) {
                            int i85 = i64 + 1;
                            iArr[i64] = i68;
                            int i86 = (i68 / 3) << 1;
                            i18 = i84 + 1;
                            objArr[i86] = zze2[i84];
                            if ((charAt19 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr[i86 + 1] = zze2[i18];
                                i64 = i85;
                            } else {
                                i64 = i85;
                            }
                        }
                        i16 = i18;
                        i14 = (int) unsafe.objectFieldOffset(zza2);
                        if ((charAt19 & 4096) == 4096 || i77 > 17) {
                            str = zzd2;
                            z2 = z3;
                            z = true;
                            i13 = 1048575;
                            i12 = i11;
                            i15 = 0;
                        } else {
                            int i87 = i11 + 1;
                            int charAt21 = zzd2.charAt(i11);
                            if (charAt21 >= 55296) {
                                int i88 = charAt21 & 8191;
                                int i89 = 13;
                                while (true) {
                                    i17 = i87 + 1;
                                    charAt = zzd2.charAt(i87);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i88 |= (charAt & 8191) << i89;
                                    i89 += 13;
                                    i87 = i17;
                                }
                                charAt21 = i88 | (charAt << i89);
                                i87 = i17;
                            }
                            z = true;
                            int i90 = (i32 << 1) + (charAt21 / 32);
                            Object obj3 = zze2[i90];
                            str = zzd2;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zze2[i90] = field;
                            }
                            i12 = i87;
                            z2 = z3;
                            i13 = (int) unsafe.objectFieldOffset(field);
                            i15 = charAt21 % 32;
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = i14;
                            i66++;
                        }
                        i63 = i16;
                    }
                    i16 = i84;
                    i14 = (int) unsafe.objectFieldOffset(zza2);
                    if ((charAt19 & 4096) == 4096) {
                    }
                    str = zzd2;
                    z2 = z3;
                    z = true;
                    i13 = 1048575;
                    i12 = i11;
                    i15 = 0;
                    iArr[i66] = i14;
                    i66++;
                    i63 = i16;
                }
                int i91 = i68 + 1;
                iArr2[i68] = charAt18;
                int i92 = i91 + 1;
                iArr2[i91] = ((charAt19 & 256) != 0 ? 268435456 : 0) | ((charAt19 & 512) != 0 ? PKIFailureInfo.duplicateCertReq : 0) | (i77 << 20) | i14;
                int i93 = i92 + 1;
                iArr2[i92] = (i15 << 20) | i13;
                z3 = z2;
                i32 = i32;
                i5 = i5;
                i65 = i12;
                i2 = i10;
                i6 = i6;
                zzd2 = str;
                i68 = i93;
                length = i8;
            }
            return new zzko<>(iArr2, objArr, i6, i5, zzla.zzc(), z3, false, iArr, i2, i62, zzks, zzju, zzlu, zziq, zzkh);
        }
        ((zzlr) zzki).zza();
        int i94 = zzkz.zzb;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzc(r10, r6) == com.google.android.gms.internal.vision.zzma.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzma.zza(r10, r6) == com.google.android.gms.internal.vision.zzma.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzma.zzb(r10, r6) == com.google.android.gms.internal.vision.zzma.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzma.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzma.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzma.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzma.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzle.zza(com.google.android.gms.internal.vision.zzma.zzf(r10, r6), com.google.android.gms.internal.vision.zzma.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zza(T t, T t2) {
        int length = this.zzc.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzd2 = zzd(i);
                long j = (long) (zzd2 & 1048575);
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (zzc(t, t2, i)) {
                            break;
                        }
                        z = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzle.zza(zzma.zzf(t, j), zzma.zzf(t2, j));
                        break;
                    case 50:
                        z = zzle.zza(zzma.zzf(t, j), zzma.zzf(t2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long zze2 = (long) (zze(i) & 1048575);
                        if (zzma.zza(t, zze2) == zzma.zza(t2, zze2)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzq.zzb(t).equals(this.zzq.zzb(t2))) {
                return false;
            } else {
                if (this.zzh) {
                    return this.zzr.zza((Object) t).equals(this.zzr.zza((Object) t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zza(T t) {
        int i;
        int i2;
        int length = this.zzc.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzd2 = zzd(i4);
            int i5 = this.zzc[i4];
            long j = (long) (1048575 & zzd2);
            int i6 = 37;
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzjf.zza(Double.doubleToLongBits(zzma.zze(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzma.zzd(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzc(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzma.zzf(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzf2 = zzma.zzf(t, j);
                    if (zzf2 != null) {
                        i6 = zzf2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzma.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzma.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzjf.zza(zzma.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzf3 = zzma.zzf(t, j);
                    if (zzf3 != null) {
                        i6 = zzf3.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = zzma.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzma.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(Double.doubleToLongBits(zzb(t, j)));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzc(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zzma.zzf(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzma.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzma.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzd(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzjf.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzma.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzq.zzb(t).hashCode();
        return this.zzh ? (hashCode * 53) + this.zzr.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd2 = zzd(i);
            long j = (long) (1048575 & zzd2);
            int i2 = this.zzc[i];
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zze(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzd(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzc(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza((Object) t2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((Object) t2, i)) {
                        zzma.zza((Object) t, j, zzma.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzp.zza(t, t2, j);
                    break;
                case 50:
                    zzle.zza(this.zzs, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zza(t2, i2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zza(t2, i2, i)) {
                        zzma.zza(t, j, zzma.zzf(t2, j));
                        zzb(t, i2, i);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        zzle.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzle.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzf2 = zzma.zzf(t, zzd2);
            Object zzf3 = zzma.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzma.zza(t, zzd2, zzjf.zza(zzf2, zzf3));
                zzb((Object) t, i);
            } else if (zzf3 != null) {
                zzma.zza(t, zzd2, zzf3);
                zzb((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object obj = null;
            if (zza(t, i2, i)) {
                obj = zzma.zzf(t, j);
            }
            Object zzf2 = zzma.zzf(t2, j);
            if (obj != null && zzf2 != null) {
                zzma.zza(t, j, zzjf.zza(obj, zzf2));
                zzb(t, i2, i);
            } else if (zzf2 != null) {
                zzma.zza(t, j, zzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final int zzb(T t) {
        int i;
        long j;
        int i2;
        int i3;
        int i4;
        int zzb2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int zzb3;
        int i10;
        int i11;
        int i12;
        int i13 = 267386880;
        int i14 = 1048575;
        int i15 = 1;
        int i16 = 0;
        if (this.zzj) {
            Unsafe unsafe = zzb;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzc.length) {
                int zzd2 = zzd(i17);
                int i19 = (zzd2 & i13) >>> 20;
                int i20 = this.zzc[i17];
                long j2 = (long) (zzd2 & 1048575);
                if (i19 >= zziv.DOUBLE_LIST_PACKED.zza() && i19 <= zziv.SINT64_LIST_PACKED.zza()) {
                    int i21 = this.zzc[i17 + 2];
                }
                switch (i19) {
                    case 0:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 1:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 2:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzd(i20, zzma.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 3:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zze(i20, zzma.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 4:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzf(i20, zzma.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 5:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 6:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 7:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 8:
                        if (zza((Object) t, i17)) {
                            Object zzf2 = zzma.zzf(t, j2);
                            if (zzf2 instanceof zzht) {
                                zzb3 = zzii.zzc(i20, (zzht) zzf2);
                                break;
                            } else {
                                zzb3 = zzii.zzb(i20, (String) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 9:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzle.zza(i20, zzma.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 10:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzc(i20, (zzht) zzma.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 11:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzg(i20, zzma.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 12:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzk(i20, zzma.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 13:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 14:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 15:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzh(i20, zzma.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 16:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzf(i20, zzma.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 17:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzii.zzc(i20, (zzkk) zzma.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 18:
                        zzb3 = zzle.zzi(i20, zza(t, j2), false);
                        break;
                    case 19:
                        zzb3 = zzle.zzh(i20, zza(t, j2), false);
                        break;
                    case 20:
                        zzb3 = zzle.zza(i20, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        zzb3 = zzle.zzb(i20, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        zzb3 = zzle.zze(i20, zza(t, j2), false);
                        break;
                    case 23:
                        zzb3 = zzle.zzi(i20, zza(t, j2), false);
                        break;
                    case 24:
                        zzb3 = zzle.zzh(i20, zza(t, j2), false);
                        break;
                    case 25:
                        zzb3 = zzle.zzj(i20, zza(t, j2), false);
                        break;
                    case 26:
                        zzb3 = zzle.zza(i20, zza(t, j2));
                        break;
                    case 27:
                        zzb3 = zzle.zza(i20, zza(t, j2), zza(i17));
                        break;
                    case 28:
                        zzb3 = zzle.zzb(i20, zza(t, j2));
                        break;
                    case 29:
                        zzb3 = zzle.zzf(i20, zza(t, j2), false);
                        break;
                    case 30:
                        zzb3 = zzle.zzd(i20, zza(t, j2), false);
                        break;
                    case 31:
                        zzb3 = zzle.zzh(i20, zza(t, j2), false);
                        break;
                    case 32:
                        zzb3 = zzle.zzi(i20, zza(t, j2), false);
                        break;
                    case 33:
                        zzb3 = zzle.zzg(i20, zza(t, j2), false);
                        break;
                    case 34:
                        zzb3 = zzle.zzc(i20, zza(t, j2), false);
                        break;
                    case 35:
                        i11 = zzle.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 36:
                        i11 = zzle.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 37:
                        i11 = zzle.zza((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 38:
                        i11 = zzle.zzb((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 39:
                        i11 = zzle.zze((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 40:
                        i11 = zzle.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 41:
                        i11 = zzle.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 42:
                        i11 = zzle.zzj((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 43:
                        i11 = zzle.zzf((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 44:
                        i11 = zzle.zzd((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 45:
                        i11 = zzle.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 46:
                        i11 = zzle.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 47:
                        i11 = zzle.zzg((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 48:
                        i11 = zzle.zzc((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzii.zze(i20);
                            i10 = zzii.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 49:
                        zzb3 = zzle.zzb(i20, (List<zzkk>) zza(t, j2), zza(i17));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i20, zzma.zzf(t, j2), zzb(i17));
                        break;
                    case 51:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 52:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 53:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzd(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 54:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zze(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 55:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzf(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 56:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 57:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 58:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 59:
                        if (zza(t, i20, i17)) {
                            Object zzf3 = zzma.zzf(t, j2);
                            if (zzf3 instanceof zzht) {
                                zzb3 = zzii.zzc(i20, (zzht) zzf3);
                                break;
                            } else {
                                zzb3 = zzii.zzb(i20, (String) zzf3);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 60:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzle.zza(i20, zzma.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 61:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzc(i20, (zzht) zzma.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 62:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzg(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 63:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzk(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 64:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 65:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 66:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzh(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 67:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzf(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 68:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzii.zzc(i20, (zzkk) zzma.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    default:
                        i17 += 3;
                        i13 = 267386880;
                }
                i18 += zzb3;
                i17 += 3;
                i13 = 267386880;
            }
            return i18 + zza((zzlu) this.zzq, (Object) t);
        }
        Unsafe unsafe2 = zzb;
        int i22 = 1048575;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzc.length) {
            int zzd3 = zzd(i23);
            int[] iArr = this.zzc;
            int i26 = iArr[i23];
            int i27 = (zzd3 & 267386880) >>> 20;
            if (i27 <= 17) {
                int i28 = iArr[i23 + 2];
                int i29 = i28 & i14;
                i = i15 << (i28 >>> 20);
                if (i29 != i22) {
                    i25 = unsafe2.getInt(t, (long) i29);
                    i22 = i29;
                }
            } else {
                i = 0;
            }
            long j3 = (long) (zzd3 & i14);
            switch (i27) {
                case 0:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzii.zzb(i26, 0.0d);
                        continue;
                        i23 += 3;
                        i15 = i3;
                        i16 = i2;
                        i14 = 1048575;
                    }
                    break;
                case 1:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzii.zzb(i26, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzii.zzd(i26, unsafe2.getLong(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 3:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzii.zze(i26, unsafe2.getLong(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 4:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzii.zzf(i26, unsafe2.getInt(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 5:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i4 = zzii.zzg(i26, 0L);
                        i24 += i4;
                        break;
                    }
                    break;
                case 6:
                    i3 = 1;
                    i2 = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzii.zzi(i26, 0);
                    }
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 7:
                    if ((i25 & i) != 0) {
                        i3 = 1;
                        i24 += zzii.zzb(i26, true);
                        i2 = 0;
                        j = 0;
                        i23 += 3;
                        i15 = i3;
                        i16 = i2;
                        i14 = 1048575;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 8:
                    if ((i25 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzht) {
                            zzb2 = zzii.zzc(i26, (zzht) object);
                        } else {
                            zzb2 = zzii.zzb(i26, (String) object);
                        }
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 9:
                    if ((i25 & i) != 0) {
                        zzb2 = zzle.zza(i26, unsafe2.getObject(t, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzc(i26, (zzht) unsafe2.getObject(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzg(i26, unsafe2.getInt(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzk(i26, unsafe2.getInt(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 13:
                    if ((i25 & i) != 0) {
                        i5 = zzii.zzj(i26, 0);
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzh(i26, 0L);
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzh(i26, unsafe2.getInt(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzf(i26, unsafe2.getLong(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb2 = zzii.zzc(i26, (zzkk) unsafe2.getObject(t, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 18:
                    zzb2 = zzle.zzi(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 19:
                    i2 = 0;
                    i6 = zzle.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 20:
                    i2 = 0;
                    i6 = zzle.zza(i26, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 21:
                    i2 = 0;
                    i6 = zzle.zzb(i26, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 22:
                    i2 = 0;
                    i6 = zzle.zze(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 23:
                    i2 = 0;
                    i6 = zzle.zzi(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 24:
                    i2 = 0;
                    i6 = zzle.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 25:
                    i2 = 0;
                    i6 = zzle.zzj(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 26:
                    zzb2 = zzle.zza(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 27:
                    zzb2 = zzle.zza(i26, (List<?>) ((List) unsafe2.getObject(t, j3)), zza(i23));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 28:
                    zzb2 = zzle.zzb(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 29:
                    zzb2 = zzle.zzf(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 30:
                    i2 = 0;
                    i6 = zzle.zzd(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 31:
                    i2 = 0;
                    i6 = zzle.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 32:
                    i2 = 0;
                    i6 = zzle.zzi(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 33:
                    i2 = 0;
                    i6 = zzle.zzg(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 34:
                    i2 = 0;
                    i6 = zzle.zzc(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 35:
                    i9 = zzle.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 36:
                    i9 = zzle.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 37:
                    i9 = zzle.zza((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 38:
                    i9 = zzle.zzb((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 39:
                    i9 = zzle.zze((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 40:
                    i9 = zzle.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 41:
                    i9 = zzle.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 42:
                    i9 = zzle.zzj((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 43:
                    i9 = zzle.zzf((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 44:
                    i9 = zzle.zzd((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 45:
                    i9 = zzle.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 46:
                    i9 = zzle.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 47:
                    i9 = zzle.zzg((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 48:
                    i9 = zzle.zzc((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzii.zze(i26);
                        i7 = zzii.zzg(i9);
                        i5 = i8 + i7 + i9;
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 49:
                    zzb2 = zzle.zzb(i26, (List) unsafe2.getObject(t, j3), zza(i23));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 50:
                    zzb2 = this.zzs.zza(i26, unsafe2.getObject(t, j3), zzb(i23));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 51:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzb(i26, 0.0d);
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 52:
                    if (zza(t, i26, i23)) {
                        i5 = zzii.zzb(i26, 0.0f);
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 53:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzd(i26, zze(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 54:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zze(i26, zze(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 55:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzf(i26, zzd(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 56:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzg(i26, 0L);
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 57:
                    if (zza(t, i26, i23)) {
                        i5 = zzii.zzi(i26, 0);
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 58:
                    if (zza(t, i26, i23)) {
                        i5 = zzii.zzb(i26, true);
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 59:
                    if (zza(t, i26, i23)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzht) {
                            zzb2 = zzii.zzc(i26, (zzht) object2);
                        } else {
                            zzb2 = zzii.zzb(i26, (String) object2);
                        }
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 60:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzle.zza(i26, unsafe2.getObject(t, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 61:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzc(i26, (zzht) unsafe2.getObject(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 62:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzg(i26, zzd(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 63:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzk(i26, zzd(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 64:
                    if (zza(t, i26, i23)) {
                        i5 = zzii.zzj(i26, 0);
                        i24 += i5;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 65:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzh(i26, 0L);
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 66:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzh(i26, zzd(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 67:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzf(i26, zze(t, j3));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 68:
                    if (zza(t, i26, i23)) {
                        zzb2 = zzii.zzc(i26, (zzkk) unsafe2.getObject(t, j3), zza(i23));
                        i24 += zzb2;
                    }
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                default:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
            }
            i23 += 3;
            i15 = i3;
            i16 = i2;
            i14 = 1048575;
        }
        int i30 = i16;
        int zza2 = i24 + zza((zzlu) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zziu<?> zza3 = this.zzr.zza((Object) t);
        for (int i31 = i30; i31 < zza3.zza.zzc(); i31++) {
            Map.Entry<T, Object> zzb4 = zza3.zza.zzb(i31);
            i30 += zziu.zzc(zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry<T, Object> entry : zza3.zza.zzd()) {
            i30 += zziu.zzc(entry.getKey(), entry.getValue());
        }
        return zza2 + i30;
    }

    private static <UT, UB> int zza(zzlu<UT, UB> zzlu, T t) {
        return zzlu.zzf(zzlu.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzma.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, zzmr zzmr) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        if (zzmr.zza() == zzmq.zzb) {
            zza(this.zzq, t, zzmr);
            if (this.zzh) {
                zziu<?> zza2 = this.zzr.zza((Object) t);
                if (!zza2.zza.isEmpty()) {
                    it2 = zza2.zze();
                    entry2 = it2.next();
                    for (length2 = this.zzc.length - 3; length2 >= 0; length2 -= 3) {
                        int zzd2 = zzd(length2);
                        int i2 = this.zzc[length2];
                        while (entry2 != null && this.zzr.zza(entry2) > i2) {
                            this.zzr.zza(zzmr, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzd2 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzc(i2, zzma.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzc(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzd(i2, zzma.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzd(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, length2)) {
                                    zza(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, (zzht) zzma.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, length2)) {
                                    zzmr.zze(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzb(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, length2)) {
                                    zzmr.zza(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzb(i2, zzma.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzf(i2, zzma.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, length2)) {
                                    zzmr.zze(i2, zzma.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, length2)) {
                                    zzmr.zzb(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzle.zza(this.zzc[length2], (List<Double>) ((List) zzma.zzf(t, (long) (zzd2 & 1048575))), zzmr, false);
                                break;
                            case 19:
                                zzle.zzb(this.zzc[length2], (List<Float>) ((List) zzma.zzf(t, (long) (zzd2 & 1048575))), zzmr, false);
                                break;
                            case 20:
                                zzle.zzc(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 21:
                                zzle.zzd(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 22:
                                zzle.zzh(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 23:
                                zzle.zzf(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 24:
                                zzle.zzk(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 25:
                                zzle.zzn(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 26:
                                zzle.zza(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr);
                                break;
                            case 27:
                                zzle.zza(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, zza(length2));
                                break;
                            case 28:
                                zzle.zzb(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr);
                                break;
                            case 29:
                                zzle.zzi(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 30:
                                zzle.zzm(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 31:
                                zzle.zzl(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 32:
                                zzle.zzg(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 33:
                                zzle.zzj(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 34:
                                zzle.zze(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, false);
                                break;
                            case 35:
                                zzle.zza(this.zzc[length2], (List<Double>) ((List) zzma.zzf(t, (long) (zzd2 & 1048575))), zzmr, true);
                                break;
                            case 36:
                                zzle.zzb(this.zzc[length2], (List<Float>) ((List) zzma.zzf(t, (long) (zzd2 & 1048575))), zzmr, true);
                                break;
                            case 37:
                                zzle.zzc(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 38:
                                zzle.zzd(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 39:
                                zzle.zzh(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 40:
                                zzle.zzf(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 41:
                                zzle.zzk(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 42:
                                zzle.zzn(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 43:
                                zzle.zzi(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 44:
                                zzle.zzm(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 45:
                                zzle.zzl(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 46:
                                zzle.zzg(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 47:
                                zzle.zzj(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 48:
                                zzle.zze(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, true);
                                break;
                            case 49:
                                zzle.zzb(this.zzc[length2], (List) zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr, zza(length2));
                                break;
                            case 50:
                                zza(zzmr, i2, zzma.zzf(t, (long) (zzd2 & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzc(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzc(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzd(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzd(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i2, length2)) {
                                    zza(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zzmr);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, (zzht) zzma.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i2, length2)) {
                                    zzmr.zze(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzb(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i2, length2)) {
                                    zzmr.zza(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzb(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzf(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i2, length2)) {
                                    zzmr.zze(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i2, length2)) {
                                    zzmr.zzb(i2, zzma.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzr.zza(zzmr, entry2);
                        entry2 = it2.hasNext() ? it2.next() : null;
                    }
                }
            }
            it2 = null;
            entry2 = null;
            while (length2 >= 0) {
            }
            while (entry2 != null) {
            }
        } else if (this.zzj) {
            if (this.zzh) {
                zziu<?> zza3 = this.zzr.zza((Object) t);
                if (!zza3.zza.isEmpty()) {
                    it = zza3.zzd();
                    entry = it.next();
                    length = this.zzc.length;
                    for (i = 0; i < length; i += 3) {
                        int zzd3 = zzd(i);
                        int i3 = this.zzc[i];
                        while (entry != null && this.zzr.zza(entry) <= i3) {
                            this.zzr.zza(zzmr, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzd3 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, i)) {
                                    zzmr.zzc(i3, zzma.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, i)) {
                                    zzmr.zzc(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, i)) {
                                    zzmr.zzd(i3, zzma.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, i)) {
                                    zzmr.zzd(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, i)) {
                                    zza(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, (zzht) zzma.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, i)) {
                                    zzmr.zze(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, i)) {
                                    zzmr.zzb(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, i)) {
                                    zzmr.zza(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, i)) {
                                    zzmr.zzb(i3, zzma.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, i)) {
                                    zzmr.zzf(i3, zzma.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, i)) {
                                    zzmr.zze(i3, zzma.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, i)) {
                                    zzmr.zzb(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzle.zza(this.zzc[i], (List<Double>) ((List) zzma.zzf(t, (long) (zzd3 & 1048575))), zzmr, false);
                                break;
                            case 19:
                                zzle.zzb(this.zzc[i], (List<Float>) ((List) zzma.zzf(t, (long) (zzd3 & 1048575))), zzmr, false);
                                break;
                            case 20:
                                zzle.zzc(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 21:
                                zzle.zzd(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 22:
                                zzle.zzh(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 23:
                                zzle.zzf(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 24:
                                zzle.zzk(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 25:
                                zzle.zzn(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 26:
                                zzle.zza(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr);
                                break;
                            case 27:
                                zzle.zza(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, zza(i));
                                break;
                            case 28:
                                zzle.zzb(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr);
                                break;
                            case 29:
                                zzle.zzi(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 30:
                                zzle.zzm(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 31:
                                zzle.zzl(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 32:
                                zzle.zzg(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 33:
                                zzle.zzj(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 34:
                                zzle.zze(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, false);
                                break;
                            case 35:
                                zzle.zza(this.zzc[i], (List<Double>) ((List) zzma.zzf(t, (long) (zzd3 & 1048575))), zzmr, true);
                                break;
                            case 36:
                                zzle.zzb(this.zzc[i], (List<Float>) ((List) zzma.zzf(t, (long) (zzd3 & 1048575))), zzmr, true);
                                break;
                            case 37:
                                zzle.zzc(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 38:
                                zzle.zzd(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 39:
                                zzle.zzh(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 40:
                                zzle.zzf(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 41:
                                zzle.zzk(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 42:
                                zzle.zzn(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 43:
                                zzle.zzi(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 44:
                                zzle.zzm(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 45:
                                zzle.zzl(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 46:
                                zzle.zzg(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 47:
                                zzle.zzj(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 48:
                                zzle.zze(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, true);
                                break;
                            case 49:
                                zzle.zzb(this.zzc[i], (List) zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr, zza(i));
                                break;
                            case 50:
                                zza(zzmr, i3, zzma.zzf(t, (long) (zzd3 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i3, i)) {
                                    zzmr.zzc(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i3, i)) {
                                    zzmr.zzc(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i3, i)) {
                                    zzmr.zzd(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i3, i)) {
                                    zzmr.zzd(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i3, i)) {
                                    zza(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zzmr);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, (zzht) zzma.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i3, i)) {
                                    zzmr.zze(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i3, i)) {
                                    zzmr.zzb(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i3, i)) {
                                    zzmr.zza(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i3, i)) {
                                    zzmr.zzb(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i3, i)) {
                                    zzmr.zzf(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i3, i)) {
                                    zzmr.zze(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i3, i)) {
                                    zzmr.zzb(i3, zzma.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzr.zza(zzmr, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzq, t, zzmr);
                }
            }
            it = null;
            entry = null;
            length = this.zzc.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzq, t, zzmr);
        } else {
            zzb((Object) t, zzmr);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    private final void zzb(T t, zzmr zzmr) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        boolean z;
        if (this.zzh) {
            zziu<?> zza2 = this.zzr.zza((Object) t);
            if (!zza2.zza.isEmpty()) {
                it = zza2.zzd();
                entry = it.next();
                length = this.zzc.length;
                Unsafe unsafe = zzb;
                int i3 = 1048575;
                int i4 = 0;
                for (i = 0; i < length; i += 3) {
                    int zzd2 = zzd(i);
                    int[] iArr = this.zzc;
                    int i5 = iArr[i];
                    int i6 = (zzd2 & 267386880) >>> 20;
                    if (i6 <= 17) {
                        int i7 = iArr[i + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i3) {
                            i4 = unsafe.getInt(t, (long) i8);
                            i3 = i8;
                        }
                        i2 = 1 << (i7 >>> 20);
                    } else {
                        i2 = 0;
                    }
                    while (entry != null && this.zzr.zza(entry) <= i5) {
                        this.zzr.zza(zzmr, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzd2 & 1048575);
                    switch (i6) {
                        case 0:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, zzma.zze(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, zzma.zzd(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if ((i2 & i4) != 0) {
                                zzmr.zzc(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if ((i2 & i4) != 0) {
                                zzmr.zzc(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if ((i2 & i4) != 0) {
                                zzmr.zzd(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if ((i2 & i4) != 0) {
                                zzmr.zzd(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, zzma.zzc(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if ((i2 & i4) != 0) {
                                zza(i5, unsafe.getObject(t, j), zzmr);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, unsafe.getObject(t, j), zza(i));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, (zzht) unsafe.getObject(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if ((i2 & i4) != 0) {
                                zzmr.zze(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if ((i2 & i4) != 0) {
                                zzmr.zzb(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if ((i2 & i4) != 0) {
                                zzmr.zza(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if ((i2 & i4) != 0) {
                                zzmr.zzb(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if ((i2 & i4) != 0) {
                                zzmr.zzf(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if ((i2 & i4) != 0) {
                                zzmr.zze(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if ((i2 & i4) != 0) {
                                zzmr.zzb(i5, unsafe.getObject(t, j), zza(i));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            z = false;
                            zzle.zza(this.zzc[i], (List<Double>) ((List) unsafe.getObject(t, j)), zzmr, false);
                            break;
                        case 19:
                            z = false;
                            zzle.zzb(this.zzc[i], (List<Float>) ((List) unsafe.getObject(t, j)), zzmr, false);
                            break;
                        case 20:
                            z = false;
                            zzle.zzc(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 21:
                            z = false;
                            zzle.zzd(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 22:
                            z = false;
                            zzle.zzh(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 23:
                            z = false;
                            zzle.zzf(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 24:
                            z = false;
                            zzle.zzk(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 25:
                            z = false;
                            zzle.zzn(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 26:
                            zzle.zza(this.zzc[i], (List) unsafe.getObject(t, j), zzmr);
                            break;
                        case 27:
                            zzle.zza(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, zza(i));
                            break;
                        case 28:
                            zzle.zzb(this.zzc[i], (List) unsafe.getObject(t, j), zzmr);
                            break;
                        case 29:
                            z = false;
                            zzle.zzi(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 30:
                            z = false;
                            zzle.zzm(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 31:
                            z = false;
                            zzle.zzl(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 32:
                            z = false;
                            zzle.zzg(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 33:
                            z = false;
                            zzle.zzj(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 34:
                            z = false;
                            zzle.zze(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, false);
                            break;
                        case 35:
                            zzle.zza(this.zzc[i], (List<Double>) ((List) unsafe.getObject(t, j)), zzmr, true);
                            break;
                        case 36:
                            zzle.zzb(this.zzc[i], (List<Float>) ((List) unsafe.getObject(t, j)), zzmr, true);
                            break;
                        case 37:
                            zzle.zzc(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 38:
                            zzle.zzd(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 39:
                            zzle.zzh(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 40:
                            zzle.zzf(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 41:
                            zzle.zzk(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 42:
                            zzle.zzn(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 43:
                            zzle.zzi(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 44:
                            zzle.zzm(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 45:
                            zzle.zzl(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 46:
                            zzle.zzg(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 47:
                            zzle.zzj(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 48:
                            zzle.zze(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, true);
                            break;
                        case 49:
                            zzle.zzb(this.zzc[i], (List) unsafe.getObject(t, j), zzmr, zza(i));
                            break;
                        case 50:
                            zza(zzmr, i5, unsafe.getObject(t, j), i);
                            break;
                        case 51:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, zzb(t, j));
                            }
                            break;
                        case 52:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, zzc(t, j));
                            }
                            break;
                        case 53:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, zze(t, j));
                            }
                            break;
                        case 54:
                            if (zza(t, i5, i)) {
                                zzmr.zzc(i5, zze(t, j));
                            }
                            break;
                        case 55:
                            if (zza(t, i5, i)) {
                                zzmr.zzc(i5, zzd(t, j));
                            }
                            break;
                        case 56:
                            if (zza(t, i5, i)) {
                                zzmr.zzd(i5, zze(t, j));
                            }
                            break;
                        case 57:
                            if (zza(t, i5, i)) {
                                zzmr.zzd(i5, zzd(t, j));
                            }
                            break;
                        case 58:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, zzf(t, j));
                            }
                            break;
                        case 59:
                            if (zza(t, i5, i)) {
                                zza(i5, unsafe.getObject(t, j), zzmr);
                            }
                            break;
                        case 60:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, unsafe.getObject(t, j), zza(i));
                            }
                            break;
                        case 61:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, (zzht) unsafe.getObject(t, j));
                            }
                            break;
                        case 62:
                            if (zza(t, i5, i)) {
                                zzmr.zze(i5, zzd(t, j));
                            }
                            break;
                        case 63:
                            if (zza(t, i5, i)) {
                                zzmr.zzb(i5, zzd(t, j));
                            }
                            break;
                        case 64:
                            if (zza(t, i5, i)) {
                                zzmr.zza(i5, zzd(t, j));
                            }
                            break;
                        case 65:
                            if (zza(t, i5, i)) {
                                zzmr.zzb(i5, zze(t, j));
                            }
                            break;
                        case 66:
                            if (zza(t, i5, i)) {
                                zzmr.zzf(i5, zzd(t, j));
                            }
                            break;
                        case 67:
                            if (zza(t, i5, i)) {
                                zzmr.zze(i5, zze(t, j));
                            }
                            break;
                        case 68:
                            if (zza(t, i5, i)) {
                                zzmr.zzb(i5, unsafe.getObject(t, j), zza(i));
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zzr.zza(zzmr, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzq, t, zzmr);
            }
        }
        it = null;
        entry = null;
        length = this.zzc.length;
        Unsafe unsafe2 = zzb;
        int i32 = 1048575;
        int i42 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzq, t, zzmr);
    }

    private final <K, V> void zza(zzmr zzmr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzmr.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzlu<UT, UB> zzlu, T t, zzmr zzmr) throws IOException {
        zzlu.zza(zzlu.zzb(t), zzmr);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:311)
        	at jadx.core.dex.instructions.ArithNode.isSame(ArithNode.java:89)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T r13, com.google.android.gms.internal.vision.zzld r14, com.google.android.gms.internal.vision.zzio r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1644
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, com.google.android.gms.internal.vision.zzld, com.google.android.gms.internal.vision.zzio):void");
    }

    private static zzlx zze(Object obj) {
        zzjb zzjb = (zzjb) obj;
        zzlx zzlx = zzjb.zzb;
        if (zzlx != zzlx.zza()) {
            return zzlx;
        }
        zzlx zzb2 = zzlx.zzb();
        zzjb.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzml zzml, Class<?> cls, zzhn zzhn) throws IOException {
        switch (zzkr.zza[zzml.ordinal()]) {
            case 1:
                int zzb2 = zzhl.zzb(bArr, i, zzhn);
                zzhn.zzc = Boolean.valueOf(zzhn.zzb != 0);
                return zzb2;
            case 2:
                return zzhl.zze(bArr, i, zzhn);
            case 3:
                zzhn.zzc = Double.valueOf(zzhl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzhn.zzc = Integer.valueOf(zzhl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzhn.zzc = Long.valueOf(zzhl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzhn.zzc = Float.valueOf(zzhl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzhl.zza(bArr, i, zzhn);
                zzhn.zzc = Integer.valueOf(zzhn.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzhl.zzb(bArr, i, zzhn);
                zzhn.zzc = Long.valueOf(zzhn.zzb);
                return zzb3;
            case 14:
                return zzhl.zza(zzky.zza().zza((Class) cls), bArr, i, i2, zzhn);
            case 15:
                int zza3 = zzhl.zza(bArr, i, zzhn);
                zzhn.zzc = Integer.valueOf(zzif.zze(zzhn.zza));
                return zza3;
            case 16:
                int zzb4 = zzhl.zzb(bArr, i, zzhn);
                zzhn.zzc = Long.valueOf(zzif.zza(zzhn.zzb));
                return zzb4;
            case 17:
                return zzhl.zzd(bArr, i, zzhn);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0420 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e8  */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.vision.zzhn r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzko.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzhn):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzhn zzhn) throws IOException {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzd(object)) {
            Object zzf2 = this.zzs.zzf(zzb2);
            this.zzs.zza(zzf2, object);
            unsafe.putObject(t, j, zzf2);
            object = zzf2;
        }
        zzkf<?, ?> zzb3 = this.zzs.zzb(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzhl.zza(bArr, i, zzhn);
        int i4 = zzhn.zza;
        if (i4 < 0 || i4 > i2 - zza3) {
            throw zzjk.zza();
        }
        int i5 = i4 + zza3;
        EventLogTags eventLogTags = (K) zzb3.zzb;
        EventLogTags eventLogTags2 = (V) zzb3.zzd;
        while (zza3 < i5) {
            int i6 = zza3 + 1;
            byte b = bArr[zza3];
            int i7 = b;
            if (b < 0) {
                i6 = zzhl.zza(b, bArr, i6, zzhn);
                i7 = zzhn.zza;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzb3.zzc.zzb()) {
                    zza3 = zza(bArr, i6, i2, zzb3.zzc, zzb3.zzd.getClass(), zzhn);
                    eventLogTags2 = (V) zzhn.zzc;
                }
            } else if (i9 == zzb3.zza.zzb()) {
                zza3 = zza(bArr, i6, i2, zzb3.zza, (Class<?>) null, zzhn);
                eventLogTags = (K) zzhn.zzc;
            }
            zza3 = zzhl.zza(i7, bArr, i6, i2, zzhn);
        }
        if (zza3 == i5) {
            zza2.put(eventLogTags, eventLogTags2);
            return i5;
        }
        throw zzjk.zzg();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzhn zzhn) throws IOException {
        int i9;
        Unsafe unsafe = zzb;
        long j2 = (long) (this.zzc[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzhl.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzhl.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzhl.zzb(bArr, i, zzhn);
                    unsafe.putObject(t, j, Long.valueOf(zzhn.zzb));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzhl.zza(bArr, i, zzhn);
                    unsafe.putObject(t, j, Integer.valueOf(zzhn.zza));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzhl.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzhl.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzhl.zzb(bArr, i, zzhn);
                    unsafe.putObject(t, j, Boolean.valueOf(zzhn.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzhl.zza(bArr, i, zzhn);
                    int i10 = zzhn.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & PKIFailureInfo.duplicateCertReq) == 0 || zzmd.zza(bArr, zza2, zza2 + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza2, i10, zzjf.zza));
                        zza2 += i10;
                    } else {
                        throw zzjk.zzh();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzhl.zza(zza(i8), bArr, i, i2, zzhn);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzhn.zzc);
                    } else {
                        unsafe.putObject(t, j, zzjf.zza(object, zzhn.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzhl.zze(bArr, i, zzhn);
                    unsafe.putObject(t, j, zzhn.zzc);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzhl.zza(bArr, i, zzhn);
                    int i11 = zzhn.zza;
                    zzjg zzc2 = zzc(i8);
                    if (zzc2 == null || zzc2.zza(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza4;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zze(t).zza(i3, Long.valueOf((long) i11));
                    return zza4;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzhl.zza(bArr, i, zzhn);
                    unsafe.putObject(t, j, Integer.valueOf(zzif.zze(zzhn.zza)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzhl.zzb(bArr, i, zzhn);
                    unsafe.putObject(t, j, Long.valueOf(zzif.zza(zzhn.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzhl.zza(zza(i8), bArr, i, i2, (i3 & -8) | 4, zzhn);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzhn.zzc);
                    } else {
                        unsafe.putObject(t, j, zzjf.zza(object2, zzhn.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzlc zza(int i) {
        int i2 = (i / 3) << 1;
        zzlc zzlc = (zzlc) this.zzd[i2];
        if (zzlc != null) {
            return zzlc;
        }
        zzlc<T> zza2 = zzky.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzjg zzc(int i) {
        return (zzjg) this.zzd[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x03c4, code lost:
        if (r0 == r0) goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x040b, code lost:
        if (r0 == r14) goto L_0x0431;
     */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x05e2  */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzhn zzhn) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        T t2;
        zzko<T> zzko;
        zzlx zzlx;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        byte[] bArr2;
        T t3;
        int i18;
        zzhn zzhn2;
        int i19;
        Object obj;
        Object zza2;
        int i20;
        int i21;
        int i22;
        long j;
        int i23;
        int i24;
        int i25;
        int i26;
        boolean z2;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        T t4;
        zzko<T> zzko2 = this;
        T t5 = t;
        byte[] bArr3 = bArr;
        int i34 = i2;
        int i35 = i3;
        zzhn zzhn3 = zzhn;
        Unsafe unsafe2 = zzb;
        int i36 = i;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = -1;
        int i41 = 1048575;
        while (true) {
            if (i36 < i34) {
                int i42 = i36 + 1;
                byte b = bArr3[i36];
                if (b < 0) {
                    i9 = zzhl.zza(b, bArr3, i42, zzhn3);
                    i8 = zzhn3.zza;
                } else {
                    i8 = b;
                    i9 = i42;
                }
                int i43 = i8 >>> 3;
                int i44 = i8 & 7;
                if (i43 > i40) {
                    i10 = zzko2.zza(i43, i37 / 3);
                } else {
                    i10 = zzko2.zzg(i43);
                }
                if (i10 == -1) {
                    i16 = i9;
                    i11 = i39;
                    i12 = i43;
                    unsafe = unsafe2;
                    i14 = i35;
                    i13 = 0;
                    z = true;
                    i15 = i8;
                } else {
                    int[] iArr = zzko2.zzc;
                    int i45 = iArr[i10 + 1];
                    int i46 = (i45 & 267386880) >>> 20;
                    long j2 = (long) (i45 & 1048575);
                    if (i46 <= 17) {
                        int i47 = iArr[i10 + 2];
                        int i48 = 1 << (i47 >>> 20);
                        int i49 = i47 & 1048575;
                        if (i49 != i41) {
                            if (i41 != 1048575) {
                                long j3 = (long) i41;
                                t4 = t;
                                j = j2;
                                unsafe2.putInt(t4, j3, i39);
                            } else {
                                t4 = t;
                                j = j2;
                            }
                            i39 = unsafe2.getInt(t4, (long) i49);
                            i23 = i49;
                            t5 = t4;
                        } else {
                            t5 = t;
                            j = j2;
                            i23 = i41;
                        }
                        switch (i46) {
                            case 0:
                                i27 = i8;
                                i24 = i23;
                                i26 = i9;
                                z2 = true;
                                i25 = i10;
                                if (i44 == 1) {
                                    zzma.zza(t5, j, zzhl.zzc(bArr3, i26));
                                    i28 = i26 + 8;
                                    i39 |= i48;
                                    i35 = i3;
                                    i38 = i27;
                                    i36 = i28;
                                    i40 = i43;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    break;
                                }
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 1:
                                i27 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 5) {
                                    zzma.zza((Object) t5, j, zzhl.zzd(bArr3, i26));
                                    i28 = i26 + 4;
                                    i39 |= i48;
                                    i35 = i3;
                                    i38 = i27;
                                    i36 = i28;
                                    i40 = i43;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    break;
                                }
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 2:
                            case 3:
                                i29 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 0) {
                                    i31 = zzhl.zzb(bArr3, i26, zzhn3);
                                    i30 = i29;
                                    unsafe2.putLong(t, j, zzhn3.zzb);
                                    i39 |= i48;
                                    i40 = i43;
                                    i36 = i31;
                                    i38 = i30;
                                    i37 = i25;
                                    i41 = i24;
                                    break;
                                }
                                i27 = i29;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 4:
                            case 11:
                                i29 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 0) {
                                    i36 = zzhl.zza(bArr3, i26, zzhn3);
                                    unsafe2.putInt(t5, j, zzhn3.zza);
                                    i39 |= i48;
                                    i35 = i3;
                                    i38 = i29;
                                    i40 = i43;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    break;
                                }
                                i27 = i29;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 5:
                            case 14:
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 1) {
                                    unsafe2.putLong(t, j, zzhl.zzb(bArr3, i26));
                                    i36 = i26 + 8;
                                    i39 |= i48;
                                    i35 = i3;
                                    i40 = i43;
                                    i38 = i8;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    break;
                                } else {
                                    z2 = true;
                                    i27 = i8;
                                    i14 = i3;
                                    i11 = i39;
                                    i12 = i43;
                                    unsafe = unsafe2;
                                    i16 = i26;
                                    i13 = i25;
                                    i41 = i24;
                                    i15 = i27;
                                    z = z2;
                                    break;
                                }
                            case 6:
                            case 13:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 5) {
                                    unsafe2.putInt(t5, j, zzhl.zza(bArr3, i26));
                                    i36 = i26 + 4;
                                    i35 = i3;
                                    i38 = i32;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    i39 |= i48;
                                    i40 = i43;
                                    break;
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 7:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 0) {
                                    int zzb2 = zzhl.zzb(bArr3, i26, zzhn3);
                                    zzma.zza(t5, j, zzhn3.zzb != 0);
                                    i35 = i3;
                                    i38 = i32;
                                    i40 = i43;
                                    i37 = i25;
                                    i41 = i24;
                                    i39 |= i48;
                                    i34 = i2;
                                    i36 = zzb2;
                                    break;
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 8:
                                i33 = i2;
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 2) {
                                    if ((536870912 & i45) == 0) {
                                        i36 = zzhl.zzc(bArr3, i26, zzhn3);
                                    } else {
                                        i36 = zzhl.zzd(bArr3, i26, zzhn3);
                                    }
                                    unsafe2.putObject(t5, j, zzhn3.zzc);
                                    i35 = i3;
                                    i38 = i32;
                                    i37 = i25;
                                    i41 = i24;
                                    i39 |= i48;
                                    i34 = i33;
                                    i40 = i43;
                                    break;
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 9:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 2) {
                                    i33 = i2;
                                    i36 = zzhl.zza(zzko2.zza(i25), bArr3, i26, i33, zzhn3);
                                    if ((i39 & i48) == 0) {
                                        unsafe2.putObject(t5, j, zzhn3.zzc);
                                    } else {
                                        unsafe2.putObject(t5, j, zzjf.zza(unsafe2.getObject(t5, j), zzhn3.zzc));
                                    }
                                    i35 = i3;
                                    i38 = i32;
                                    i37 = i25;
                                    i41 = i24;
                                    i39 |= i48;
                                    i34 = i33;
                                    i40 = i43;
                                    break;
                                } else {
                                    i27 = i32;
                                    z2 = true;
                                    i14 = i3;
                                    i11 = i39;
                                    i12 = i43;
                                    unsafe = unsafe2;
                                    i16 = i26;
                                    i13 = i25;
                                    i41 = i24;
                                    i15 = i27;
                                    z = z2;
                                    break;
                                }
                            case 10:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 2) {
                                    i36 = zzhl.zze(bArr3, i26, zzhn3);
                                    unsafe2.putObject(t5, j, zzhn3.zzc);
                                    i35 = i3;
                                    i38 = i32;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    i39 |= i48;
                                    i40 = i43;
                                    break;
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 12:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 0) {
                                    i36 = zzhl.zza(bArr3, i26, zzhn3);
                                    int i50 = zzhn3.zza;
                                    zzjg zzc2 = zzko2.zzc(i25);
                                    if (zzc2 != null && !zzc2.zza(i50)) {
                                        zze(t).zza(i32, Long.valueOf((long) i50));
                                        i35 = i3;
                                        i38 = i32;
                                        i39 = i39;
                                        i40 = i43;
                                        i37 = i25;
                                        i41 = i24;
                                        i34 = i2;
                                        break;
                                    } else {
                                        unsafe2.putInt(t5, j, i50);
                                        i35 = i3;
                                        i38 = i32;
                                        i37 = i25;
                                        i41 = i24;
                                        i34 = i2;
                                        i39 |= i48;
                                        i40 = i43;
                                        break;
                                    }
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 15:
                                i32 = i8;
                                i24 = i23;
                                i26 = i9;
                                i25 = i10;
                                if (i44 == 0) {
                                    i36 = zzhl.zza(bArr3, i26, zzhn3);
                                    unsafe2.putInt(t5, j, zzif.zze(zzhn3.zza));
                                    i35 = i3;
                                    i38 = i32;
                                    i37 = i25;
                                    i41 = i24;
                                    i34 = i2;
                                    i39 |= i48;
                                    i40 = i43;
                                    break;
                                }
                                i27 = i32;
                                z2 = true;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                            case 16:
                                i26 = i9;
                                if (i44 == 0) {
                                    i31 = zzhl.zzb(bArr3, i26, zzhn3);
                                    i30 = i8;
                                    i24 = i23;
                                    i25 = i10;
                                    unsafe2.putLong(t, j, zzif.zza(zzhn3.zzb));
                                    i39 |= i48;
                                    i40 = i43;
                                    i36 = i31;
                                    i38 = i30;
                                    i37 = i25;
                                    i41 = i24;
                                    break;
                                } else {
                                    i24 = i23;
                                    i25 = i10;
                                    i27 = i8;
                                    z2 = true;
                                    i14 = i3;
                                    i11 = i39;
                                    i12 = i43;
                                    unsafe = unsafe2;
                                    i16 = i26;
                                    i13 = i25;
                                    i41 = i24;
                                    i15 = i27;
                                    z = z2;
                                    break;
                                }
                            case 17:
                                if (i44 == 3) {
                                    i36 = zzhl.zza(zzko2.zza(i10), bArr, i9, i2, (i43 << 3) | 4, zzhn);
                                    if ((i39 & i48) == 0) {
                                        unsafe2.putObject(t5, j, zzhn3.zzc);
                                    } else {
                                        unsafe2.putObject(t5, j, zzjf.zza(unsafe2.getObject(t5, j), zzhn3.zzc));
                                    }
                                    i39 |= i48;
                                    i40 = i43;
                                    i37 = i10;
                                    i38 = i8;
                                    i41 = i23;
                                    break;
                                } else {
                                    i26 = i9;
                                    i27 = i8;
                                    i24 = i23;
                                    z2 = true;
                                    i25 = i10;
                                    i14 = i3;
                                    i11 = i39;
                                    i12 = i43;
                                    unsafe = unsafe2;
                                    i16 = i26;
                                    i13 = i25;
                                    i41 = i24;
                                    i15 = i27;
                                    z = z2;
                                    break;
                                }
                            default:
                                i27 = i8;
                                i24 = i23;
                                i26 = i9;
                                z2 = true;
                                i25 = i10;
                                i14 = i3;
                                i11 = i39;
                                i12 = i43;
                                unsafe = unsafe2;
                                i16 = i26;
                                i13 = i25;
                                i41 = i24;
                                i15 = i27;
                                z = z2;
                                break;
                        }
                    } else {
                        t5 = t;
                        if (i46 != 27) {
                            i11 = i39;
                            i20 = i41;
                            if (i46 <= 49) {
                                z = true;
                                i21 = i8;
                                i12 = i43;
                                unsafe = unsafe2;
                                i14 = i3;
                                i13 = i10;
                                i36 = zza(t, bArr, i9, i2, i8, i43, i44, i10, (long) i45, i46, j2, zzhn);
                            } else {
                                i14 = i3;
                                i21 = i8;
                                i12 = i43;
                                unsafe = unsafe2;
                                i13 = i10;
                                i22 = i9;
                                z = true;
                                if (i46 != 50) {
                                    i36 = zza(t, bArr, i22, i2, i21, i12, i44, i45, i46, j2, i13, zzhn);
                                    if (i36 != i22) {
                                        zzko2 = this;
                                        t5 = t;
                                        bArr3 = bArr;
                                        i34 = i2;
                                        i38 = i21;
                                        i40 = i12;
                                        i37 = i13;
                                        i39 = i11;
                                        i41 = i20;
                                        unsafe2 = unsafe;
                                        i35 = i14;
                                        zzhn3 = zzhn;
                                    }
                                } else if (i44 == 2) {
                                    i36 = zza(t, bArr, i22, i2, i13, j2, zzhn);
                                }
                                i15 = i21;
                                i16 = i36;
                                i41 = i20;
                            }
                            t5 = t;
                            bArr3 = bArr;
                            i38 = i21;
                            i34 = i2;
                            zzhn3 = zzhn;
                            i35 = i14;
                            i37 = i13;
                            i40 = i12;
                            i39 = i11;
                            i41 = i20;
                            unsafe2 = unsafe;
                            zzko2 = this;
                        } else if (i44 == 2) {
                            zzjl zzjl = (zzjl) unsafe2.getObject(t5, j2);
                            if (!zzjl.zza()) {
                                int size = zzjl.size();
                                zzjl = zzjl.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t5, j2, zzjl);
                            }
                            i36 = zzhl.zza(zzko2.zza(i10), i8, bArr, i9, i2, zzjl, zzhn);
                            i40 = i43;
                            i38 = i8;
                            i37 = i10;
                            i39 = i39;
                            i41 = i41;
                        } else {
                            i11 = i39;
                            i20 = i41;
                            i14 = i3;
                            i21 = i8;
                            i12 = i43;
                            unsafe = unsafe2;
                            i13 = i10;
                            i22 = i9;
                            z = true;
                        }
                        i15 = i21;
                        i16 = i22;
                        i41 = i20;
                    }
                    i34 = i2;
                    i35 = i3;
                }
                if (i15 != i14 || i14 == 0) {
                    if (this.zzh) {
                        zzhn2 = zzhn;
                        if (zzhn2.zzd != zzio.zzb()) {
                            zzkk zzkk = this.zzg;
                            zzlu<?, ?> zzlu = this.zzq;
                            i18 = i12;
                            zzjb.zze zza3 = zzhn2.zzd.zza(zzkk, i18);
                            if (zza3 == null) {
                                i36 = zzhl.zza(i15, bArr, i16, i2, zze(t), zzhn);
                                t3 = t;
                                bArr2 = bArr;
                                i17 = i41;
                                i19 = i2;
                            } else {
                                t3 = t;
                                T t6 = t3;
                                t6.zza();
                                zziu<zzjb.zzf> zziu = t6.zzc;
                                boolean z3 = zza3.zzd.zzd;
                                if (zza3.zzd.zzc == zzml.ENUM) {
                                    bArr2 = bArr;
                                    i16 = zzhl.zza(bArr2, i16, zzhn2);
                                    zzjh zzjh = null;
                                    if (zzjh.zza(zzhn2.zza) == null) {
                                        zzlx zzlx2 = t6.zzb;
                                        if (zzlx2 == zzlx.zza()) {
                                            zzlx2 = zzlx.zzb();
                                            t6.zzb = zzlx2;
                                        }
                                        zzle.zza(i18, zzhn2.zza, zzlx2, zzlu);
                                        i17 = i41;
                                        i19 = i2;
                                        i36 = i16;
                                    } else {
                                        obj = Integer.valueOf(zzhn2.zza);
                                    }
                                } else {
                                    bArr2 = bArr;
                                    obj = null;
                                    switch (zzhk.zza[zza3.zzd.zzc.ordinal()]) {
                                        case 1:
                                            i17 = i41;
                                            i19 = i2;
                                            obj = Double.valueOf(zzhl.zzc(bArr2, i16));
                                            i16 += 8;
                                            break;
                                        case 2:
                                            i17 = i41;
                                            i19 = i2;
                                            obj = Float.valueOf(zzhl.zzd(bArr2, i16));
                                            i16 += 4;
                                            break;
                                        case 3:
                                        case 4:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zzb(bArr2, i16, zzhn2);
                                            obj = Long.valueOf(zzhn2.zzb);
                                            break;
                                        case 5:
                                        case 6:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zza(bArr2, i16, zzhn2);
                                            obj = Integer.valueOf(zzhn2.zza);
                                            break;
                                        case 7:
                                        case 8:
                                            i17 = i41;
                                            i19 = i2;
                                            obj = Long.valueOf(zzhl.zzb(bArr2, i16));
                                            i16 += 8;
                                            break;
                                        case 9:
                                        case 10:
                                            i17 = i41;
                                            i19 = i2;
                                            obj = Integer.valueOf(zzhl.zza(bArr2, i16));
                                            i16 += 4;
                                            break;
                                        case 11:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zzb(bArr2, i16, zzhn2);
                                            obj = Boolean.valueOf(zzhn2.zzb != 0 ? z : false);
                                            break;
                                        case 12:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zza(bArr2, i16, zzhn2);
                                            obj = Integer.valueOf(zzif.zze(zzhn2.zza));
                                            break;
                                        case 13:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zzb(bArr2, i16, zzhn2);
                                            obj = Long.valueOf(zzif.zza(zzhn2.zzb));
                                            break;
                                        case 14:
                                            throw new IllegalStateException("Shouldn't reach here.");
                                        case 15:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zze(bArr2, i16, zzhn2);
                                            obj = zzhn2.zzc;
                                            break;
                                        case 16:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zzc(bArr2, i16, zzhn2);
                                            obj = zzhn2.zzc;
                                            break;
                                        case 17:
                                            i17 = i41;
                                            i19 = i2;
                                            i16 = zzhl.zza(zzky.zza().zza((Class) zza3.zzc.getClass()), bArr, i16, i2, (i18 << 3) | 4, zzhn);
                                            obj = zzhn2.zzc;
                                            break;
                                        case 18:
                                            i16 = zzhl.zza(zzky.zza().zza((Class) zza3.zzc.getClass()), bArr2, i16, i2, zzhn2);
                                            obj = zzhn2.zzc;
                                            i17 = i41;
                                            i19 = i2;
                                            break;
                                    }
                                    if (!zza3.zzd.zzd) {
                                        zziu.zzb(zza3.zzd, obj);
                                    } else {
                                        int i51 = zzhk.zza[zza3.zzd.zzc.ordinal()];
                                        if ((i51 == 17 || i51 == 18) && (zza2 = zziu.zza(zza3.zzd)) != null) {
                                            obj = zzjf.zza(zza2, obj);
                                        }
                                        zziu.zza(zza3.zzd, obj);
                                    }
                                    i36 = i16;
                                }
                                i17 = i41;
                                i19 = i2;
                                if (!zza3.zzd.zzd) {
                                }
                                i36 = i16;
                            }
                            i38 = i15;
                            i40 = i18;
                            t5 = t3;
                            bArr3 = bArr2;
                            i37 = i13;
                            i39 = i11;
                            i34 = i19;
                            zzko2 = this;
                            i35 = i14;
                            zzhn3 = zzhn2;
                            unsafe2 = unsafe;
                            i41 = i17;
                        } else {
                            t3 = t;
                            bArr2 = bArr;
                        }
                    } else {
                        t3 = t;
                        bArr2 = bArr;
                        zzhn2 = zzhn;
                    }
                    i17 = i41;
                    i18 = i12;
                    i19 = i2;
                    i36 = zzhl.zza(i15, bArr, i16, i2, zze(t), zzhn);
                    i38 = i15;
                    i40 = i18;
                    t5 = t3;
                    bArr3 = bArr2;
                    i37 = i13;
                    i39 = i11;
                    i34 = i19;
                    zzko2 = this;
                    i35 = i14;
                    zzhn3 = zzhn2;
                    unsafe2 = unsafe;
                    i41 = i17;
                } else {
                    zzko = this;
                    t2 = t;
                    i36 = i16;
                    i6 = i41;
                    i38 = i15;
                    i4 = i14;
                    i39 = i11;
                    i7 = 1048575;
                    zzlx = null;
                    i5 = i2;
                }
            } else {
                unsafe = unsafe2;
                i4 = i35;
                i5 = i34;
                t2 = t5;
                zzko = zzko2;
                zzlx = null;
                i6 = i41;
                i7 = 1048575;
            }
        }
        if (i6 != i7) {
            unsafe.putInt(t2, (long) i6, i39);
        }
        for (int i52 = zzko.zzm; i52 < zzko.zzn; i52++) {
            zzlx = (zzlx) zzko.zza(t2, zzko.zzl[i52], zzlx, (zzlu<UT, UB>) zzko.zzq);
        }
        if (zzlx != null) {
            zzko.zzq.zzb(t2, zzlx);
        }
        if (i4 == 0) {
            if (i36 != i5) {
                throw zzjk.zzg();
            }
        } else if (i36 > i5 || i38 != i4) {
            throw zzjk.zzg();
        }
        return i36;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x031a, code lost:
        if (r0 == r15) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x033d, code lost:
        if (r0 == r15) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x033f, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d1, code lost:
        if (r0 == r4) goto L_0x033f;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zza(T t, byte[] bArr, int i, int i2, zzhn zzhn) throws IOException {
        byte b;
        int i3;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Unsafe unsafe2;
        int i14;
        Unsafe unsafe3;
        int i15;
        Unsafe unsafe4;
        zzko<T> zzko = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i16 = i2;
        zzhn zzhn2 = zzhn;
        if (zzko.zzj) {
            Unsafe unsafe5 = zzb;
            int i17 = -1;
            int i18 = 1048575;
            int i19 = i;
            int i20 = 1048575;
            int i21 = -1;
            int i22 = 0;
            int i23 = 0;
            while (i19 < i16) {
                int i24 = i19 + 1;
                byte b2 = bArr2[i19];
                if (b2 < 0) {
                    i3 = zzhl.zza(b2, bArr2, i24, zzhn2);
                    b = zzhn2.zza;
                } else {
                    b = b2;
                    i3 = i24;
                }
                int i25 = b >>> 3;
                int i26 = b & 7;
                if (i25 > i21) {
                    i4 = zzko.zza(i25, i22 / 3);
                } else {
                    i4 = zzko.zzg(i25);
                }
                if (i4 == i17) {
                    i8 = i3;
                    i5 = i25;
                    unsafe = unsafe5;
                    i6 = i17;
                    i7 = 0;
                } else {
                    int[] iArr = zzko.zzc;
                    int i27 = iArr[i4 + 1];
                    int i28 = (i27 & 267386880) >>> 20;
                    long j = (long) (i27 & i18);
                    if (i28 <= 17) {
                        int i29 = iArr[i4 + 2];
                        int i30 = 1 << (i29 >>> 20);
                        int i31 = i29 & 1048575;
                        if (i31 != i20) {
                            if (i20 != 1048575) {
                                long j2 = (long) i20;
                                unsafe4 = unsafe5;
                                unsafe4.putInt(t2, j2, i23);
                            } else {
                                unsafe4 = unsafe5;
                            }
                            if (i31 != 1048575) {
                                i23 = unsafe4.getInt(t2, (long) i31);
                            }
                            unsafe2 = unsafe4;
                            i20 = i31;
                        } else {
                            unsafe2 = unsafe5;
                        }
                        switch (i28) {
                            case 0:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i15 = i3;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 1) {
                                    zzma.zza(t2, j, zzhl.zzc(bArr2, i15));
                                    i19 = i15 + 8;
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 1:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i15 = i3;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 5) {
                                    zzma.zza((Object) t2, j, zzhl.zzd(bArr2, i15));
                                    i19 = i15 + 4;
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 2:
                            case 3:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i15 = i3;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 0) {
                                    int zzb2 = zzhl.zzb(bArr2, i15, zzhn2);
                                    unsafe3.putLong(t, j, zzhn2.zzb);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    i19 = zzb2;
                                    break;
                                }
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 4:
                            case 11:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i15 = i3;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 0) {
                                    i19 = zzhl.zza(bArr2, i15, zzhn2);
                                    unsafe3.putInt(t2, j, zzhn2.zza);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 5:
                            case 14:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 1) {
                                    unsafe3.putLong(t, j, zzhl.zzb(bArr2, i3));
                                    i19 = i3 + 8;
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 6:
                            case 13:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 5) {
                                    unsafe3.putInt(t2, j, zzhl.zza(bArr2, i3));
                                    i19 = i3 + 4;
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 7:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 0) {
                                    i19 = zzhl.zzb(bArr2, i3, zzhn2);
                                    zzma.zza(t2, j, zzhn2.zzb != 0);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 8:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 2) {
                                    if ((i27 & PKIFailureInfo.duplicateCertReq) == 0) {
                                        i19 = zzhl.zzc(bArr2, i3, zzhn2);
                                    } else {
                                        i19 = zzhl.zzd(bArr2, i3, zzhn2);
                                    }
                                    unsafe3.putObject(t2, j, zzhn2.zzc);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 9:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 2) {
                                    i19 = zzhl.zza(zzko.zza(i14), bArr2, i3, i16, zzhn2);
                                    Object object = unsafe3.getObject(t2, j);
                                    if (object == null) {
                                        unsafe3.putObject(t2, j, zzhn2.zzc);
                                    } else {
                                        unsafe3.putObject(t2, j, zzjf.zza(object, zzhn2.zzc));
                                    }
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 10:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 2) {
                                    i19 = zzhl.zze(bArr2, i3, zzhn2);
                                    unsafe3.putObject(t2, j, zzhn2.zzc);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 12:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 0) {
                                    i19 = zzhl.zza(bArr2, i3, zzhn2);
                                    unsafe3.putInt(t2, j, zzhn2.zza);
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 15:
                                i5 = i25;
                                i9 = 1048575;
                                i14 = i4;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                if (i26 == 0) {
                                    i19 = zzhl.zza(bArr2, i3, zzhn2);
                                    unsafe3.putInt(t2, j, zzif.zze(zzhn2.zza));
                                    i23 |= i30;
                                    unsafe5 = unsafe3;
                                    i22 = i14;
                                    break;
                                }
                                i15 = i3;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                            case 16:
                                if (i26 != 0) {
                                    i5 = i25;
                                    i10 = i20;
                                    unsafe3 = unsafe2;
                                    i15 = i3;
                                    i14 = i4;
                                    i8 = i15;
                                    unsafe = unsafe3;
                                    i7 = i14;
                                    i20 = i10;
                                    i6 = -1;
                                    break;
                                } else {
                                    int zzb3 = zzhl.zzb(bArr2, i3, zzhn2);
                                    i10 = i20;
                                    i5 = i25;
                                    i9 = 1048575;
                                    unsafe2.putLong(t, j, zzif.zza(zzhn2.zzb));
                                    i23 |= i30;
                                    unsafe5 = unsafe2;
                                    i22 = i4;
                                    i19 = zzb3;
                                    break;
                                }
                            default:
                                i5 = i25;
                                i14 = i4;
                                i15 = i3;
                                i10 = i20;
                                unsafe3 = unsafe2;
                                i8 = i15;
                                unsafe = unsafe3;
                                i7 = i14;
                                i20 = i10;
                                i6 = -1;
                                break;
                        }
                    } else {
                        i5 = i25;
                        i10 = i20;
                        i9 = 1048575;
                        if (i28 != 27) {
                            i7 = i4;
                            if (i28 <= 49) {
                                i12 = i23;
                                i11 = i10;
                                unsafe = unsafe5;
                                i6 = -1;
                                i19 = zza(t, bArr, i3, i2, b, i5, i26, i7, (long) i27, i28, j, zzhn);
                            } else {
                                i13 = i3;
                                i12 = i23;
                                unsafe = unsafe5;
                                i11 = i10;
                                i6 = -1;
                                if (i28 != 50) {
                                    i19 = zza(t, bArr, i13, i2, b, i5, i26, i27, i28, j, i7, zzhn);
                                } else if (i26 == 2) {
                                    i19 = zza(t, bArr, i13, i2, i7, j, zzhn);
                                }
                            }
                            zzko = this;
                            t2 = t;
                            bArr2 = bArr;
                            i16 = i2;
                            zzhn2 = zzhn;
                            i22 = i7;
                            i17 = i6;
                            i21 = i5;
                            i23 = i12;
                            i20 = i11;
                            unsafe5 = unsafe;
                            i18 = 1048575;
                        } else if (i26 == 2) {
                            zzjl zzjl = (zzjl) unsafe5.getObject(t2, j);
                            if (!zzjl.zza()) {
                                int size = zzjl.size();
                                zzjl = zzjl.zza(size == 0 ? 10 : size << 1);
                                unsafe5.putObject(t2, j, zzjl);
                            }
                            i19 = zzhl.zza(zzko.zza(i4), b, bArr, i3, i2, zzjl, zzhn);
                            unsafe5 = unsafe5;
                            i23 = i23;
                            i22 = i4;
                        } else {
                            i7 = i4;
                            i13 = i3;
                            i12 = i23;
                            unsafe = unsafe5;
                            i11 = i10;
                            i6 = -1;
                        }
                        i8 = i13;
                        i23 = i12;
                        i20 = i11;
                    }
                    i20 = i10;
                    i21 = i5;
                    i18 = i9;
                    i17 = -1;
                }
                i19 = zzhl.zza(b, bArr, i8, i2, zze(t), zzhn);
                zzko = this;
                t2 = t;
                bArr2 = bArr;
                i16 = i2;
                zzhn2 = zzhn;
                i22 = i7;
                i17 = i6;
                i21 = i5;
                unsafe5 = unsafe;
                i18 = 1048575;
            }
            if (i20 != i18) {
                unsafe5.putInt(t, (long) i20, i23);
            }
            if (i19 != i2) {
                throw zzjk.zzg();
            }
            return;
        }
        zza(t, bArr, i, i2, 0, zzhn);
    }

    @Override // com.google.android.gms.internal.vision.zzlc
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzma.zzf(t, zzd2);
            if (zzf2 != null) {
                zzma.zza(t, zzd2, this.zzs.zze(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzlu<UT, UB> zzlu) {
        zzjg zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzma.zzf(obj, (long) (zzd(i) & 1048575));
        return (zzf2 == null || (zzc2 = zzc(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzs.zza(zzf2), zzc2, ub, zzlu);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzjg zzjg, UB ub, zzlu<UT, UB> zzlu) {
        zzkf<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzjg.zza(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzlu.zza();
                }
                zzib zzc2 = zzht.zzc(zzkc.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zzkc.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzlu.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.vision.zzlc] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.vision.zzlc] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.vision.zzlc
    public final boolean zzd(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza(t).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzb.getInt(t, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t, i7, i6) && !zza(t, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzc2 = this.zzs.zzc(zzma.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i6)).zzc.zza() == zzmo.MESSAGE) {
                                    zzlc<T> zzlc = 0;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzlc == null) {
                                            zzlc = zzky.zza().zza((Class) next.getClass());
                                        }
                                        boolean zzd3 = zzlc.zzd(next);
                                        zzlc = zzlc;
                                        if (!zzd3) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzma.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    ?? zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza(t, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.vision.zzlc */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzlc zzlc) {
        return zzlc.zzd(zzma.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzmr zzmr) throws IOException {
        if (obj instanceof String) {
            zzmr.zza(i, (String) obj);
        } else {
            zzmr.zza(i, (zzht) obj);
        }
    }

    private final void zza(Object obj, int i, zzld zzld) throws IOException {
        if (zzf(i)) {
            zzma.zza(obj, (long) (i & 1048575), zzld.zzm());
        } else if (this.zzi) {
            zzma.zza(obj, (long) (i & 1048575), zzld.zzl());
        } else {
            zzma.zza(obj, (long) (i & 1048575), zzld.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzma.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzma.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzma.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzma.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzma.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzma.zze(t, j2) != 0.0d;
                case 1:
                    return zzma.zzd(t, j2) != 0.0f;
                case 2:
                    return zzma.zzb(t, j2) != 0;
                case 3:
                    return zzma.zzb(t, j2) != 0;
                case 4:
                    return zzma.zza(t, j2) != 0;
                case 5:
                    return zzma.zzb(t, j2) != 0;
                case 6:
                    return zzma.zza(t, j2) != 0;
                case 7:
                    return zzma.zzc(t, j2);
                case 8:
                    Object zzf2 = zzma.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzht) {
                        return !zzht.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzma.zzf(t, j2) != null;
                case 10:
                    return !zzht.zza.equals(zzma.zzf(t, j2));
                case 11:
                    return zzma.zza(t, j2) != 0;
                case 12:
                    return zzma.zza(t, j2) != 0;
                case 13:
                    return zzma.zza(t, j2) != 0;
                case 14:
                    return zzma.zzb(t, j2) != 0;
                case 15:
                    return zzma.zza(t, j2) != 0;
                case 16:
                    return zzma.zzb(t, j2) != 0;
                case 17:
                    return zzma.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzma.zza(t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzma.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzma.zza(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzma.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzma.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
