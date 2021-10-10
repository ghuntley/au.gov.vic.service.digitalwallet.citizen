package com.google.android.gms.internal.measurement;

import android.util.EventLogTags;
import com.google.android.gms.internal.measurement.zzhy;
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
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public final class zzjn<T> implements zzkb<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkz.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjr zzo;
    private final zzit zzp;
    private final zzkt<?, ?> zzq;
    private final zzhn<?> zzr;
    private final zzjc zzs;

    private zzjn(int[] iArr, Object[] objArr, int i, int i2, zzjj zzjj, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjr zzjr, zzit zzit, zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjc zzjc) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjj instanceof zzhy;
        this.zzj = z;
        this.zzh = zzhn != null && zzhn.zza(zzjj);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjr;
        this.zzp = zzit;
        this.zzq = zzkt;
        this.zzr = zzhn;
        this.zzg = zzjj;
        this.zzs = zzjc;
    }

    private static boolean zzf(int i) {
        return (i & PKIFailureInfo.duplicateCertReq) != 0;
    }

    static <T> zzjn<T> zza(Class<T> cls, zzjh zzjh, zzjr zzjr, zzit zzit, zzkt<?, ?> zzkt, zzhn<?> zzhn, zzjc zzjc) {
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
        if (zzjh instanceof zzjz) {
            zzjz zzjz = (zzjz) zzjh;
            int i32 = 0;
            boolean z3 = zzjz.zza() == zzju.zzb;
            String zzd2 = zzjz.zzd();
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
            Object[] zze2 = zzjz.zze();
            Class<?> cls2 = zzjz.zzc().getClass();
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
            return new zzjn<>(iArr2, objArr, i6, i5, zzjz.zzc(), z3, false, iArr, i2, i62, zzjr, zzit, zzkt, zzhn, zzjc);
        }
        ((zzkm) zzjh).zza();
        int i94 = zzju.zzb;
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

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zza(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zza(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzkz.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkz.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkz.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkz.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzkd.zza(com.google.android.gms.internal.measurement.zzkz.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkz.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.measurement.zzkb
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
                        z = zzkd.zza(zzkz.zzf(t, j), zzkz.zzf(t2, j));
                        break;
                    case 50:
                        z = zzkd.zza(zzkz.zzf(t, j), zzkz.zzf(t2, j));
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
                        if (zzkz.zza(t, zze2) == zzkz.zza(t2, zze2)) {
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

    @Override // com.google.android.gms.internal.measurement.zzkb
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
                    i = zzia.zza(Double.doubleToLongBits(zzkz.zze(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzkz.zzd(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzc(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzkz.zzf(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzf2 = zzkz.zzf(t, j);
                    if (zzf2 != null) {
                        i6 = zzf2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzkz.zza(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzia.zza(zzkz.zzb(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzf3 = zzkz.zzf(t, j);
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
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzkz.zzf(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(Double.doubleToLongBits(zzb(t, j)));
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
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzia.zza(zze(t, j));
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
                        i = zzia.zza(zze(t, j));
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
                        i = zzia.zza(zzf(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zzkz.zzf(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
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
                        i = zzia.zza(zze(t, j));
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
                        i = zzia.zza(zze(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzkz.zzf(t, j).hashCode();
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

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzc.length; i += 3) {
            int zzd2 = zzd(i);
            long j = (long) (1048575 & zzd2);
            int i2 = this.zzc[i];
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    if (zza((Object) t2, i)) {
                        zzkz.zza(t, j, zzkz.zze(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzd(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza((Object) t2, i)) {
                        zzkz.zza(t, j, zzkz.zzc(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza((Object) t2, i)) {
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
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
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zza(t2, j));
                        zzb((Object) t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza((Object) t2, i)) {
                        zzkz.zza((Object) t, j, zzkz.zzb(t2, j));
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
                    zzkd.zza(this.zzs, t, t2, j);
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
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
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
                        zzkz.zza(t, j, zzkz.zzf(t2, j));
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
        zzkd.zza(this.zzq, t, t2);
        if (this.zzh) {
            zzkd.zza(this.zzr, t, t2);
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzf2 = zzkz.zzf(t, zzd2);
            Object zzf3 = zzkz.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzkz.zza(t, zzd2, zzia.zza(zzf2, zzf3));
                zzb((Object) t, i);
            } else if (zzf3 != null) {
                zzkz.zza(t, zzd2, zzf3);
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
                obj = zzkz.zzf(t, j);
            }
            Object zzf2 = zzkz.zzf(t2, j);
            if (obj != null && zzf2 != null) {
                zzkz.zza(t, j, zzia.zza(obj, zzf2));
                zzb(t, i2, i);
            } else if (zzf2 != null) {
                zzkz.zza(t, j, zzf2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.measurement.zzkb
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
                if (i19 >= zzhs.DOUBLE_LIST_PACKED.zza() && i19 <= zzhs.SINT64_LIST_PACKED.zza()) {
                    int i21 = this.zzc[i17 + 2];
                }
                switch (i19) {
                    case 0:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 1:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 2:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzd(i20, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 3:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zze(i20, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 4:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzf(i20, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 5:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 6:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 7:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 8:
                        if (zza((Object) t, i17)) {
                            Object zzf2 = zzkz.zzf(t, j2);
                            if (zzf2 instanceof zzgp) {
                                zzb3 = zzhi.zzc(i20, (zzgp) zzf2);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i20, (String) zzf2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 9:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzkd.zza(i20, zzkz.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 10:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzc(i20, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 11:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzg(i20, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 12:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzk(i20, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 13:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 14:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 15:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzh(i20, zzkz.zza(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 16:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzf(i20, zzkz.zzb(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 17:
                        if (zza((Object) t, i17)) {
                            zzb3 = zzhi.zzc(i20, (zzjj) zzkz.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 18:
                        zzb3 = zzkd.zzi(i20, zza(t, j2), false);
                        break;
                    case 19:
                        zzb3 = zzkd.zzh(i20, zza(t, j2), false);
                        break;
                    case 20:
                        zzb3 = zzkd.zza(i20, (List<Long>) zza(t, j2), false);
                        break;
                    case 21:
                        zzb3 = zzkd.zzb(i20, (List<Long>) zza(t, j2), false);
                        break;
                    case 22:
                        zzb3 = zzkd.zze(i20, zza(t, j2), false);
                        break;
                    case 23:
                        zzb3 = zzkd.zzi(i20, zza(t, j2), false);
                        break;
                    case 24:
                        zzb3 = zzkd.zzh(i20, zza(t, j2), false);
                        break;
                    case 25:
                        zzb3 = zzkd.zzj(i20, zza(t, j2), false);
                        break;
                    case 26:
                        zzb3 = zzkd.zza(i20, zza(t, j2));
                        break;
                    case 27:
                        zzb3 = zzkd.zza(i20, zza(t, j2), zza(i17));
                        break;
                    case 28:
                        zzb3 = zzkd.zzb(i20, zza(t, j2));
                        break;
                    case 29:
                        zzb3 = zzkd.zzf(i20, zza(t, j2), false);
                        break;
                    case 30:
                        zzb3 = zzkd.zzd(i20, zza(t, j2), false);
                        break;
                    case 31:
                        zzb3 = zzkd.zzh(i20, zza(t, j2), false);
                        break;
                    case 32:
                        zzb3 = zzkd.zzi(i20, zza(t, j2), false);
                        break;
                    case 33:
                        zzb3 = zzkd.zzg(i20, zza(t, j2), false);
                        break;
                    case 34:
                        zzb3 = zzkd.zzc(i20, zza(t, j2), false);
                        break;
                    case 35:
                        i11 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 36:
                        i11 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 37:
                        i11 = zzkd.zza((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 38:
                        i11 = zzkd.zzb((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 39:
                        i11 = zzkd.zze((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 40:
                        i11 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 41:
                        i11 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 42:
                        i11 = zzkd.zzj((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 43:
                        i11 = zzkd.zzf((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 44:
                        i11 = zzkd.zzd((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 45:
                        i11 = zzkd.zzh((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 46:
                        i11 = zzkd.zzi((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 47:
                        i11 = zzkd.zzg((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 48:
                        i11 = zzkd.zzc((List) unsafe.getObject(t, j2));
                        if (i11 > 0) {
                            i12 = zzhi.zze(i20);
                            i10 = zzhi.zzg(i11);
                            zzb3 = i12 + i10 + i11;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 49:
                        zzb3 = zzkd.zzb(i20, (List<zzjj>) zza(t, j2), zza(i17));
                        break;
                    case 50:
                        zzb3 = this.zzs.zza(i20, zzkz.zzf(t, j2), zzb(i17));
                        break;
                    case 51:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 52:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 53:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzd(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 54:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zze(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 55:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzf(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 56:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 57:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzi(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 58:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzb(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 59:
                        if (zza(t, i20, i17)) {
                            Object zzf3 = zzkz.zzf(t, j2);
                            if (zzf3 instanceof zzgp) {
                                zzb3 = zzhi.zzc(i20, (zzgp) zzf3);
                                break;
                            } else {
                                zzb3 = zzhi.zzb(i20, (String) zzf3);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 60:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzkd.zza(i20, zzkz.zzf(t, j2), zza(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 61:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzc(i20, (zzgp) zzkz.zzf(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 62:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzg(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 63:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzk(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 64:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 65:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 66:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzh(i20, zzd(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 67:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzf(i20, zze(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i13 = 267386880;
                        }
                    case 68:
                        if (zza(t, i20, i17)) {
                            zzb3 = zzhi.zzc(i20, (zzjj) zzkz.zzf(t, j2), zza(i17));
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
            return i18 + zza((zzkt) this.zzq, (Object) t);
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
                        i24 += zzhi.zzb(i26, 0.0d);
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
                        i24 += zzhi.zzb(i26, 0.0f);
                        break;
                    }
                    break;
                case 2:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzhi.zzd(i26, unsafe2.getLong(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 3:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzhi.zze(i26, unsafe2.getLong(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 4:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i & i25) != 0) {
                        i4 = zzhi.zzf(i26, unsafe2.getInt(t, j3));
                        i24 += i4;
                        break;
                    }
                    break;
                case 5:
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i4 = zzhi.zzg(i26, 0L);
                        i24 += i4;
                        break;
                    }
                    break;
                case 6:
                    i3 = 1;
                    i2 = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzhi.zzi(i26, 0);
                    }
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 7:
                    if ((i25 & i) != 0) {
                        i3 = 1;
                        i24 += zzhi.zzb(i26, true);
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
                        if (object instanceof zzgp) {
                            zzb2 = zzhi.zzc(i26, (zzgp) object);
                        } else {
                            zzb2 = zzhi.zzb(i26, (String) object);
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
                        zzb2 = zzkd.zza(i26, unsafe2.getObject(t, j3), zza(i23));
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
                        zzb2 = zzhi.zzc(i26, (zzgp) unsafe2.getObject(t, j3));
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
                        zzb2 = zzhi.zzg(i26, unsafe2.getInt(t, j3));
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
                        zzb2 = zzhi.zzk(i26, unsafe2.getInt(t, j3));
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
                        i5 = zzhi.zzj(i26, 0);
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
                        zzb2 = zzhi.zzh(i26, 0L);
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
                        zzb2 = zzhi.zzh(i26, unsafe2.getInt(t, j3));
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
                        zzb2 = zzhi.zzf(i26, unsafe2.getLong(t, j3));
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
                        zzb2 = zzhi.zzc(i26, (zzjj) unsafe2.getObject(t, j3), zza(i23));
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
                    zzb2 = zzkd.zzi(i26, (List) unsafe2.getObject(t, j3), false);
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
                    i6 = zzkd.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 20:
                    i2 = 0;
                    i6 = zzkd.zza(i26, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 21:
                    i2 = 0;
                    i6 = zzkd.zzb(i26, (List<Long>) ((List) unsafe2.getObject(t, j3)), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 22:
                    i2 = 0;
                    i6 = zzkd.zze(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 23:
                    i2 = 0;
                    i6 = zzkd.zzi(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 24:
                    i2 = 0;
                    i6 = zzkd.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 25:
                    i2 = 0;
                    i6 = zzkd.zzj(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 26:
                    zzb2 = zzkd.zza(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 27:
                    zzb2 = zzkd.zza(i26, (List<?>) ((List) unsafe2.getObject(t, j3)), zza(i23));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 28:
                    zzb2 = zzkd.zzb(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb2;
                    i3 = 1;
                    i2 = 0;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 29:
                    zzb2 = zzkd.zzf(i26, (List) unsafe2.getObject(t, j3), false);
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
                    i6 = zzkd.zzd(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 31:
                    i2 = 0;
                    i6 = zzkd.zzh(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 32:
                    i2 = 0;
                    i6 = zzkd.zzi(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 33:
                    i2 = 0;
                    i6 = zzkd.zzg(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 34:
                    i2 = 0;
                    i6 = zzkd.zzc(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i6;
                    i3 = 1;
                    j = 0;
                    i23 += 3;
                    i15 = i3;
                    i16 = i2;
                    i14 = 1048575;
                case 35:
                    i9 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zza((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzb((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zze((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzj((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzf((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzd((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzh((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzi((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzg((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    i9 = zzkd.zzc((List) unsafe2.getObject(t, j3));
                    if (i9 > 0) {
                        i8 = zzhi.zze(i26);
                        i7 = zzhi.zzg(i9);
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
                    zzb2 = zzkd.zzb(i26, (List) unsafe2.getObject(t, j3), zza(i23));
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
                        zzb2 = zzhi.zzb(i26, 0.0d);
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
                        i5 = zzhi.zzb(i26, 0.0f);
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
                        zzb2 = zzhi.zzd(i26, zze(t, j3));
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
                        zzb2 = zzhi.zze(i26, zze(t, j3));
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
                        zzb2 = zzhi.zzf(i26, zzd(t, j3));
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
                        zzb2 = zzhi.zzg(i26, 0L);
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
                        i5 = zzhi.zzi(i26, 0);
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
                        i5 = zzhi.zzb(i26, true);
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
                        if (object2 instanceof zzgp) {
                            zzb2 = zzhi.zzc(i26, (zzgp) object2);
                        } else {
                            zzb2 = zzhi.zzb(i26, (String) object2);
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
                        zzb2 = zzkd.zza(i26, unsafe2.getObject(t, j3), zza(i23));
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
                        zzb2 = zzhi.zzc(i26, (zzgp) unsafe2.getObject(t, j3));
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
                        zzb2 = zzhi.zzg(i26, zzd(t, j3));
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
                        zzb2 = zzhi.zzk(i26, zzd(t, j3));
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
                        i5 = zzhi.zzj(i26, 0);
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
                        zzb2 = zzhi.zzh(i26, 0L);
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
                        zzb2 = zzhi.zzh(i26, zzd(t, j3));
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
                        zzb2 = zzhi.zzf(i26, zze(t, j3));
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
                        zzb2 = zzhi.zzc(i26, (zzjj) unsafe2.getObject(t, j3), zza(i23));
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
        int zza2 = i24 + zza((zzkt) this.zzq, (Object) t);
        if (!this.zzh) {
            return zza2;
        }
        zzhr<?> zza3 = this.zzr.zza((Object) t);
        for (int i31 = i30; i31 < zza3.zza.zzc(); i31++) {
            Map.Entry<T, Object> zzb4 = zza3.zza.zzb(i31);
            i30 += zzhr.zza((zzht<?>) zzb4.getKey(), zzb4.getValue());
        }
        for (Map.Entry<T, Object> entry : zza3.zza.zzd()) {
            i30 += zzhr.zza((zzht<?>) entry.getKey(), entry.getValue());
        }
        return zza2 + i30;
    }

    private static <UT, UB> int zza(zzkt<UT, UB> zzkt, T t) {
        return zzkt.zzf(zzkt.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzkz.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzlm zzlm) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        if (zzlm.zza() == zzlp.zzb) {
            zza(this.zzq, t, zzlm);
            if (this.zzh) {
                zzhr<?> zza2 = this.zzr.zza((Object) t);
                if (!zza2.zza.isEmpty()) {
                    it2 = zza2.zze();
                    entry2 = it2.next();
                    for (length2 = this.zzc.length - 3; length2 >= 0; length2 -= 3) {
                        int zzd2 = zzd(length2);
                        int i2 = this.zzc[length2];
                        while (entry2 != null && this.zzr.zza(entry2) > i2) {
                            this.zzr.zza(zzlm, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzd2 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzc(i2, zzkz.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzc(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzd(i2, zzkz.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzd(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, length2)) {
                                    zza(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, (zzgp) zzkz.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, length2)) {
                                    zzlm.zze(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzb(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, length2)) {
                                    zzlm.zza(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzb(i2, zzkz.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzf(i2, zzkz.zza(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, length2)) {
                                    zzlm.zze(i2, zzkz.zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, length2)) {
                                    zzlm.zzb(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzkd.zza(this.zzc[length2], (List<Double>) ((List) zzkz.zzf(t, (long) (zzd2 & 1048575))), zzlm, false);
                                break;
                            case 19:
                                zzkd.zzb(this.zzc[length2], (List<Float>) ((List) zzkz.zzf(t, (long) (zzd2 & 1048575))), zzlm, false);
                                break;
                            case 20:
                                zzkd.zzc(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 21:
                                zzkd.zzd(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 22:
                                zzkd.zzh(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 23:
                                zzkd.zzf(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 24:
                                zzkd.zzk(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 25:
                                zzkd.zzn(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 26:
                                zzkd.zza(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm);
                                break;
                            case 27:
                                zzkd.zza(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, zza(length2));
                                break;
                            case 28:
                                zzkd.zzb(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm);
                                break;
                            case 29:
                                zzkd.zzi(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 30:
                                zzkd.zzm(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 31:
                                zzkd.zzl(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 32:
                                zzkd.zzg(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 33:
                                zzkd.zzj(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 34:
                                zzkd.zze(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, false);
                                break;
                            case 35:
                                zzkd.zza(this.zzc[length2], (List<Double>) ((List) zzkz.zzf(t, (long) (zzd2 & 1048575))), zzlm, true);
                                break;
                            case 36:
                                zzkd.zzb(this.zzc[length2], (List<Float>) ((List) zzkz.zzf(t, (long) (zzd2 & 1048575))), zzlm, true);
                                break;
                            case 37:
                                zzkd.zzc(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 38:
                                zzkd.zzd(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 39:
                                zzkd.zzh(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 40:
                                zzkd.zzf(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 41:
                                zzkd.zzk(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 42:
                                zzkd.zzn(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 43:
                                zzkd.zzi(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 44:
                                zzkd.zzm(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 45:
                                zzkd.zzl(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 46:
                                zzkd.zzg(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 47:
                                zzkd.zzj(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 48:
                                zzkd.zze(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, true);
                                break;
                            case 49:
                                zzkd.zzb(this.zzc[length2], (List) zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm, zza(length2));
                                break;
                            case 50:
                                zza(zzlm, i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zzb(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zzc(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzc(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzc(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzd(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzd(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i2, length2)) {
                                    zza(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zzlm);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, (zzgp) zzkz.zzf(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i2, length2)) {
                                    zzlm.zze(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzb(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i2, length2)) {
                                    zzlm.zza(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzb(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzf(i2, zzd(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i2, length2)) {
                                    zzlm.zze(i2, zze(t, (long) (zzd2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i2, length2)) {
                                    zzlm.zzb(i2, zzkz.zzf(t, (long) (zzd2 & 1048575)), zza(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzr.zza(zzlm, entry2);
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
                zzhr<?> zza3 = this.zzr.zza((Object) t);
                if (!zza3.zza.isEmpty()) {
                    it = zza3.zzd();
                    entry = it.next();
                    length = this.zzc.length;
                    for (i = 0; i < length; i += 3) {
                        int zzd3 = zzd(i);
                        int i3 = this.zzc[i];
                        while (entry != null && this.zzr.zza(entry) <= i3) {
                            this.zzr.zza(zzlm, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzd3 & 267386880) >>> 20) {
                            case 0:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza((Object) t, i)) {
                                    zzlm.zzc(i3, zzkz.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza((Object) t, i)) {
                                    zzlm.zzc(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza((Object) t, i)) {
                                    zzlm.zzd(i3, zzkz.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza((Object) t, i)) {
                                    zzlm.zzd(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza((Object) t, i)) {
                                    zza(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, (zzgp) zzkz.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza((Object) t, i)) {
                                    zzlm.zze(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza((Object) t, i)) {
                                    zzlm.zzb(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza((Object) t, i)) {
                                    zzlm.zza(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza((Object) t, i)) {
                                    zzlm.zzb(i3, zzkz.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza((Object) t, i)) {
                                    zzlm.zzf(i3, zzkz.zza(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza((Object) t, i)) {
                                    zzlm.zze(i3, zzkz.zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza((Object) t, i)) {
                                    zzlm.zzb(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzkd.zza(this.zzc[i], (List<Double>) ((List) zzkz.zzf(t, (long) (zzd3 & 1048575))), zzlm, false);
                                break;
                            case 19:
                                zzkd.zzb(this.zzc[i], (List<Float>) ((List) zzkz.zzf(t, (long) (zzd3 & 1048575))), zzlm, false);
                                break;
                            case 20:
                                zzkd.zzc(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 21:
                                zzkd.zzd(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 22:
                                zzkd.zzh(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 23:
                                zzkd.zzf(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 24:
                                zzkd.zzk(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 25:
                                zzkd.zzn(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 26:
                                zzkd.zza(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm);
                                break;
                            case 27:
                                zzkd.zza(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, zza(i));
                                break;
                            case 28:
                                zzkd.zzb(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm);
                                break;
                            case 29:
                                zzkd.zzi(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 30:
                                zzkd.zzm(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 31:
                                zzkd.zzl(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 32:
                                zzkd.zzg(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 33:
                                zzkd.zzj(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 34:
                                zzkd.zze(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, false);
                                break;
                            case 35:
                                zzkd.zza(this.zzc[i], (List<Double>) ((List) zzkz.zzf(t, (long) (zzd3 & 1048575))), zzlm, true);
                                break;
                            case 36:
                                zzkd.zzb(this.zzc[i], (List<Float>) ((List) zzkz.zzf(t, (long) (zzd3 & 1048575))), zzlm, true);
                                break;
                            case 37:
                                zzkd.zzc(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 38:
                                zzkd.zzd(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 39:
                                zzkd.zzh(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 40:
                                zzkd.zzf(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 41:
                                zzkd.zzk(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 42:
                                zzkd.zzn(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 43:
                                zzkd.zzi(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 44:
                                zzkd.zzm(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 45:
                                zzkd.zzl(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 46:
                                zzkd.zzg(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 47:
                                zzkd.zzj(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 48:
                                zzkd.zze(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, true);
                                break;
                            case 49:
                                zzkd.zzb(this.zzc[i], (List) zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm, zza(i));
                                break;
                            case 50:
                                zza(zzlm, i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zzb(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zzc(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i3, i)) {
                                    zzlm.zzc(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i3, i)) {
                                    zzlm.zzc(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i3, i)) {
                                    zzlm.zzd(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i3, i)) {
                                    zzlm.zzd(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i3, i)) {
                                    zza(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zzlm);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, (zzgp) zzkz.zzf(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i3, i)) {
                                    zzlm.zze(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i3, i)) {
                                    zzlm.zzb(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i3, i)) {
                                    zzlm.zza(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i3, i)) {
                                    zzlm.zzb(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i3, i)) {
                                    zzlm.zzf(i3, zzd(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i3, i)) {
                                    zzlm.zze(i3, zze(t, (long) (zzd3 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i3, i)) {
                                    zzlm.zzb(i3, zzkz.zzf(t, (long) (zzd3 & 1048575)), zza(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzr.zza(zzlm, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzq, t, zzlm);
                }
            }
            it = null;
            entry = null;
            length = this.zzc.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzq, t, zzlm);
        } else {
            zzb((Object) t, zzlm);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    private final void zzb(T t, zzlm zzlm) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        boolean z;
        if (this.zzh) {
            zzhr<?> zza2 = this.zzr.zza((Object) t);
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
                        this.zzr.zza(zzlm, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzd2 & 1048575);
                    switch (i6) {
                        case 0:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, zzkz.zze(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, zzkz.zzd(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if ((i2 & i4) != 0) {
                                zzlm.zzc(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if ((i2 & i4) != 0) {
                                zzlm.zzc(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if ((i2 & i4) != 0) {
                                zzlm.zzd(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if ((i2 & i4) != 0) {
                                zzlm.zzd(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, zzkz.zzc(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if ((i2 & i4) != 0) {
                                zza(i5, unsafe.getObject(t, j), zzlm);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, unsafe.getObject(t, j), zza(i));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, (zzgp) unsafe.getObject(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if ((i2 & i4) != 0) {
                                zzlm.zze(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if ((i2 & i4) != 0) {
                                zzlm.zzb(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if ((i2 & i4) != 0) {
                                zzlm.zza(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if ((i2 & i4) != 0) {
                                zzlm.zzb(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if ((i2 & i4) != 0) {
                                zzlm.zzf(i5, unsafe.getInt(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if ((i2 & i4) != 0) {
                                zzlm.zze(i5, unsafe.getLong(t, j));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if ((i2 & i4) != 0) {
                                zzlm.zzb(i5, unsafe.getObject(t, j), zza(i));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            z = false;
                            zzkd.zza(this.zzc[i], (List<Double>) ((List) unsafe.getObject(t, j)), zzlm, false);
                            break;
                        case 19:
                            z = false;
                            zzkd.zzb(this.zzc[i], (List<Float>) ((List) unsafe.getObject(t, j)), zzlm, false);
                            break;
                        case 20:
                            z = false;
                            zzkd.zzc(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 21:
                            z = false;
                            zzkd.zzd(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 22:
                            z = false;
                            zzkd.zzh(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 23:
                            z = false;
                            zzkd.zzf(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 24:
                            z = false;
                            zzkd.zzk(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 25:
                            z = false;
                            zzkd.zzn(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 26:
                            zzkd.zza(this.zzc[i], (List) unsafe.getObject(t, j), zzlm);
                            break;
                        case 27:
                            zzkd.zza(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, zza(i));
                            break;
                        case 28:
                            zzkd.zzb(this.zzc[i], (List) unsafe.getObject(t, j), zzlm);
                            break;
                        case 29:
                            z = false;
                            zzkd.zzi(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 30:
                            z = false;
                            zzkd.zzm(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 31:
                            z = false;
                            zzkd.zzl(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 32:
                            z = false;
                            zzkd.zzg(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 33:
                            z = false;
                            zzkd.zzj(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 34:
                            z = false;
                            zzkd.zze(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, false);
                            break;
                        case 35:
                            zzkd.zza(this.zzc[i], (List<Double>) ((List) unsafe.getObject(t, j)), zzlm, true);
                            break;
                        case 36:
                            zzkd.zzb(this.zzc[i], (List<Float>) ((List) unsafe.getObject(t, j)), zzlm, true);
                            break;
                        case 37:
                            zzkd.zzc(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 38:
                            zzkd.zzd(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 39:
                            zzkd.zzh(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 40:
                            zzkd.zzf(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 41:
                            zzkd.zzk(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 42:
                            zzkd.zzn(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 43:
                            zzkd.zzi(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 44:
                            zzkd.zzm(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 45:
                            zzkd.zzl(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 46:
                            zzkd.zzg(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 47:
                            zzkd.zzj(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 48:
                            zzkd.zze(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, true);
                            break;
                        case 49:
                            zzkd.zzb(this.zzc[i], (List) unsafe.getObject(t, j), zzlm, zza(i));
                            break;
                        case 50:
                            zza(zzlm, i5, unsafe.getObject(t, j), i);
                            break;
                        case 51:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, zzb(t, j));
                            }
                            break;
                        case 52:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, zzc(t, j));
                            }
                            break;
                        case 53:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, zze(t, j));
                            }
                            break;
                        case 54:
                            if (zza(t, i5, i)) {
                                zzlm.zzc(i5, zze(t, j));
                            }
                            break;
                        case 55:
                            if (zza(t, i5, i)) {
                                zzlm.zzc(i5, zzd(t, j));
                            }
                            break;
                        case 56:
                            if (zza(t, i5, i)) {
                                zzlm.zzd(i5, zze(t, j));
                            }
                            break;
                        case 57:
                            if (zza(t, i5, i)) {
                                zzlm.zzd(i5, zzd(t, j));
                            }
                            break;
                        case 58:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, zzf(t, j));
                            }
                            break;
                        case 59:
                            if (zza(t, i5, i)) {
                                zza(i5, unsafe.getObject(t, j), zzlm);
                            }
                            break;
                        case 60:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, unsafe.getObject(t, j), zza(i));
                            }
                            break;
                        case 61:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, (zzgp) unsafe.getObject(t, j));
                            }
                            break;
                        case 62:
                            if (zza(t, i5, i)) {
                                zzlm.zze(i5, zzd(t, j));
                            }
                            break;
                        case 63:
                            if (zza(t, i5, i)) {
                                zzlm.zzb(i5, zzd(t, j));
                            }
                            break;
                        case 64:
                            if (zza(t, i5, i)) {
                                zzlm.zza(i5, zzd(t, j));
                            }
                            break;
                        case 65:
                            if (zza(t, i5, i)) {
                                zzlm.zzb(i5, zze(t, j));
                            }
                            break;
                        case 66:
                            if (zza(t, i5, i)) {
                                zzlm.zzf(i5, zzd(t, j));
                            }
                            break;
                        case 67:
                            if (zza(t, i5, i)) {
                                zzlm.zze(i5, zze(t, j));
                            }
                            break;
                        case 68:
                            if (zza(t, i5, i)) {
                                zzlm.zzb(i5, unsafe.getObject(t, j), zza(i));
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zzr.zza(zzlm, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzq, t, zzlm);
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
        zza(this.zzq, t, zzlm);
    }

    private final <K, V> void zza(zzlm zzlm, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlm.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkt<UT, UB> zzkt, T t, zzlm zzlm) throws IOException {
        zzkt.zza(zzkt.zzb(t), zzlm);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjy r14, com.google.android.gms.internal.measurement.zzhl r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1644
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjy, com.google.android.gms.internal.measurement.zzhl):void");
    }

    private static zzks zze(Object obj) {
        zzhy zzhy = (zzhy) obj;
        zzks zzks = zzhy.zzb;
        if (zzks != zzks.zza()) {
            return zzks;
        }
        zzks zzb2 = zzks.zzb();
        zzhy.zzb = zzb2;
        return zzb2;
    }

    private static int zza(byte[] bArr, int i, int i2, zzlg zzlg, Class<?> cls, zzgo zzgo) throws IOException {
        switch (zzjm.zza[zzlg.ordinal()]) {
            case 1:
                int zzb2 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Boolean.valueOf(zzgo.zzb != 0);
                return zzb2;
            case 2:
                return zzgl.zze(bArr, i, zzgo);
            case 3:
                zzgo.zzc = Double.valueOf(zzgl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzgo.zzc = Integer.valueOf(zzgl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzgo.zzc = Long.valueOf(zzgl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzgo.zzc = Float.valueOf(zzgl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza2 = zzgl.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzgo.zza);
                return zza2;
            case 12:
            case 13:
                int zzb3 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzgo.zzb);
                return zzb3;
            case 14:
                return zzgl.zza(zzjx.zza().zza((Class) cls), bArr, i, i2, zzgo);
            case 15:
                int zza3 = zzgl.zza(bArr, i, zzgo);
                zzgo.zzc = Integer.valueOf(zzhb.zze(zzgo.zza));
                return zza3;
            case 16:
                int zzb4 = zzgl.zzb(bArr, i, zzgo);
                zzgo.zzc = Long.valueOf(zzhb.zza(zzgo.zzb));
                return zzb4;
            case 17:
                return zzgl.zzd(bArr, i, zzgo);
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
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.measurement.zzgo r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgo):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzgo zzgo) throws IOException {
        Unsafe unsafe = zzb;
        Object zzb2 = zzb(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzs.zzc(object)) {
            Object zze2 = this.zzs.zze(zzb2);
            this.zzs.zza(zze2, object);
            unsafe.putObject(t, j, zze2);
            object = zze2;
        }
        zzja<?, ?> zzf2 = this.zzs.zzf(zzb2);
        Map<?, ?> zza2 = this.zzs.zza(object);
        int zza3 = zzgl.zza(bArr, i, zzgo);
        int i4 = zzgo.zza;
        if (i4 < 0 || i4 > i2 - zza3) {
            throw zzij.zza();
        }
        int i5 = i4 + zza3;
        EventLogTags eventLogTags = (K) zzf2.zzb;
        EventLogTags eventLogTags2 = (V) zzf2.zzd;
        while (zza3 < i5) {
            int i6 = zza3 + 1;
            byte b = bArr[zza3];
            int i7 = b;
            if (b < 0) {
                i6 = zzgl.zza(b, bArr, i6, zzgo);
                i7 = zzgo.zza;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzf2.zzc.zzb()) {
                    zza3 = zza(bArr, i6, i2, zzf2.zzc, zzf2.zzd.getClass(), zzgo);
                    eventLogTags2 = (V) zzgo.zzc;
                }
            } else if (i9 == zzf2.zza.zzb()) {
                zza3 = zza(bArr, i6, i2, zzf2.zza, (Class<?>) null, zzgo);
                eventLogTags = (K) zzgo.zzc;
            }
            zza3 = zzgl.zza(i7, bArr, i6, i2, zzgo);
        }
        if (zza3 == i5) {
            zza2.put(eventLogTags, eventLogTags2);
            return i5;
        }
        throw zzij.zzg();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzgo zzgo) throws IOException {
        int i9;
        Unsafe unsafe = zzb;
        long j2 = (long) (this.zzc[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzgl.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzgl.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzgo.zzb));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzgl.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzgo.zza));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzgl.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzgl.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Boolean.valueOf(zzgo.zzb != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza2 = zzgl.zza(bArr, i, zzgo);
                    int i10 = zzgo.zza;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & PKIFailureInfo.duplicateCertReq) == 0 || zzlb.zza(bArr, zza2, zza2 + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza2, i10, zzia.zza));
                        zza2 += i10;
                    } else {
                        throw zzij.zzh();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza3 = zzgl.zza(zza(i8), bArr, i, i2, zzgo);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza3;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzgl.zze(bArr, i, zzgo);
                    unsafe.putObject(t, j, zzgo.zzc);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza4 = zzgl.zza(bArr, i, zzgo);
                    int i11 = zzgo.zza;
                    zzif zzc2 = zzc(i8);
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
                    i9 = zzgl.zza(bArr, i, zzgo);
                    unsafe.putObject(t, j, Integer.valueOf(zzhb.zze(zzgo.zza)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzgl.zzb(bArr, i, zzgo);
                    unsafe.putObject(t, j, Long.valueOf(zzhb.zza(zzgo.zzb)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzgl.zza(zza(i8), bArr, i, i2, (i3 & -8) | 4, zzgo);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzgo.zzc);
                    } else {
                        unsafe.putObject(t, j, zzia.zza(object2, zzgo.zzc));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzkb zza(int i) {
        int i2 = (i / 3) << 1;
        zzkb zzkb = (zzkb) this.zzd[i2];
        if (zzkb != null) {
            return zzkb;
        }
        zzkb<T> zza2 = zzjx.zza().zza((Class) ((Class) this.zzd[i2 + 1]));
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzif zzc(int i) {
        return (zzif) this.zzd[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03ad, code lost:
        if (r0 == r3) goto L_0x0416;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03f0, code lost:
        if (r0 == r15) goto L_0x0416;
     */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzgo zzgo) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzjn<T> zzjn;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        int i11;
        zzgo zzgo2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        zzgo zzgo3;
        int i19;
        zzgo zzgo4;
        int i20;
        zzgo zzgo5;
        zzjn<T> zzjn2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i21 = i2;
        int i22 = i3;
        zzgo zzgo6 = zzgo;
        Unsafe unsafe2 = zzb;
        int i23 = i;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 1048575;
        while (true) {
            if (i23 < i21) {
                int i29 = i23 + 1;
                byte b2 = bArr2[i23];
                if (b2 < 0) {
                    int zza2 = zzgl.zza(b2, bArr2, i29, zzgo6);
                    b = zzgo6.zza;
                    i29 = zza2;
                } else {
                    b = b2;
                }
                int i30 = b >>> 3;
                int i31 = b & 7;
                if (i30 > i27) {
                    i5 = zzjn2.zza(i30, i24 / 3);
                } else {
                    i5 = zzjn2.zzg(i30);
                }
                if (i5 == -1) {
                    i6 = i30;
                    i10 = i29;
                    i9 = b;
                    i7 = i26;
                    unsafe = unsafe2;
                    i4 = i22;
                    i8 = 0;
                } else {
                    int[] iArr = zzjn2.zzc;
                    int i32 = iArr[i5 + 1];
                    int i33 = (i32 & 267386880) >>> 20;
                    long j = (long) (i32 & 1048575);
                    if (i33 <= 17) {
                        int i34 = iArr[i5 + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i28) {
                            if (i28 != 1048575) {
                                unsafe2.putInt(t4, (long) i28, i26);
                            }
                            i26 = unsafe2.getInt(t4, (long) i36);
                            i15 = i36;
                        } else {
                            i15 = i28;
                        }
                        switch (i33) {
                            case 0:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 1) {
                                    zzkz.zza(t4, j, zzgl.zzc(bArr2, i29));
                                    i23 = i29 + 8;
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 1:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 5) {
                                    zzkz.zza((Object) t4, j, zzgl.zzd(bArr2, i29));
                                    i23 = i29 + 4;
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 2:
                            case 3:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 0) {
                                    i19 = zzgl.zzb(bArr2, i29, zzgo3);
                                    unsafe2.putLong(t, j, zzgo3.zzb);
                                    i26 |= i35;
                                    i28 = i16;
                                    i23 = i19;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 4:
                            case 11:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 0) {
                                    i23 = zzgl.zza(bArr2, i29, zzgo3);
                                    unsafe2.putInt(t4, j, zzgo3.zza);
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 5:
                            case 14:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 1) {
                                    unsafe2.putLong(t, j, zzgl.zzb(bArr2, i29));
                                    i23 = i29 + 8;
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 6:
                            case 13:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                i20 = i2;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i31 == 5) {
                                    unsafe2.putInt(t4, j, zzgl.zza(bArr2, i29));
                                    i23 = i29 + 4;
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    zzgo6 = zzgo4;
                                    i21 = i20;
                                    i24 = i17;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 7:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                i20 = i2;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i31 == 0) {
                                    int zzb2 = zzgl.zzb(bArr2, i29, zzgo4);
                                    zzkz.zza(t4, j, zzgo4.zzb != 0);
                                    i26 |= i35;
                                    i28 = i16;
                                    i23 = zzb2;
                                    i25 = i9;
                                    i27 = i18;
                                    zzgo6 = zzgo4;
                                    i21 = i20;
                                    i24 = i17;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 8:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                i20 = i2;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i31 == 2) {
                                    if ((i32 & PKIFailureInfo.duplicateCertReq) == 0) {
                                        i23 = zzgl.zzc(bArr2, i29, zzgo4);
                                    } else {
                                        i23 = zzgl.zzd(bArr2, i29, zzgo4);
                                    }
                                    unsafe2.putObject(t4, j, zzgo4.zzc);
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    zzgo6 = zzgo4;
                                    i21 = i20;
                                    i24 = i17;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 9:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo4 = zzgo;
                                if (i31 == 2) {
                                    i20 = i2;
                                    i23 = zzgl.zza(zzjn2.zza(i17), bArr2, i29, i20, zzgo4);
                                    if ((i26 & i35) == 0) {
                                        unsafe2.putObject(t4, j, zzgo4.zzc);
                                    } else {
                                        unsafe2.putObject(t4, j, zzia.zza(unsafe2.getObject(t4, j), zzgo4.zzc));
                                    }
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    zzgo6 = zzgo4;
                                    i21 = i20;
                                    i24 = i17;
                                    break;
                                } else {
                                    i4 = i3;
                                    i10 = i29;
                                    i7 = i26;
                                    unsafe = unsafe2;
                                    i8 = i17;
                                    i28 = i16;
                                    i6 = i18;
                                    break;
                                }
                            case 10:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 2) {
                                    i23 = zzgl.zze(bArr2, i29, zzgo3);
                                    unsafe2.putObject(t4, j, zzgo3.zzc);
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 12:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 0) {
                                    i23 = zzgl.zza(bArr2, i29, zzgo3);
                                    int i37 = zzgo3.zza;
                                    zzif zzc2 = zzjn2.zzc(i17);
                                    if (zzc2 == null || zzc2.zza(i37)) {
                                        unsafe2.putInt(t4, j, i37);
                                        i26 |= i35;
                                        i28 = i16;
                                        i25 = i9;
                                        i27 = i18;
                                        i24 = i17;
                                        zzgo6 = zzgo3;
                                        i21 = i2;
                                        break;
                                    } else {
                                        zze(t).zza(i9, Long.valueOf((long) i37));
                                        i26 = i26;
                                        i25 = i9;
                                        i27 = i18;
                                        i24 = i17;
                                        zzgo6 = zzgo3;
                                        i28 = i16;
                                        i21 = i2;
                                    }
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 15:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                bArr2 = bArr;
                                zzgo3 = zzgo;
                                if (i31 == 0) {
                                    i23 = zzgl.zza(bArr2, i29, zzgo3);
                                    unsafe2.putInt(t4, j, zzhb.zze(zzgo3.zza));
                                    i26 |= i35;
                                    i28 = i16;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                }
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                            case 16:
                                i18 = i30;
                                i17 = i5;
                                if (i31 == 0) {
                                    bArr2 = bArr;
                                    i19 = zzgl.zzb(bArr2, i29, zzgo);
                                    zzgo3 = zzgo;
                                    i16 = i15;
                                    i9 = b;
                                    unsafe2.putLong(t, j, zzhb.zza(zzgo.zzb));
                                    i26 |= i35;
                                    i28 = i16;
                                    i23 = i19;
                                    i25 = i9;
                                    i27 = i18;
                                    i24 = i17;
                                    zzgo6 = zzgo3;
                                    i21 = i2;
                                    break;
                                } else {
                                    i16 = i15;
                                    i9 = b;
                                    i4 = i3;
                                    i10 = i29;
                                    i7 = i26;
                                    unsafe = unsafe2;
                                    i8 = i17;
                                    i28 = i16;
                                    i6 = i18;
                                    break;
                                }
                            case 17:
                                if (i31 == 3) {
                                    i23 = zzgl.zza(zzjn2.zza(i5), bArr, i29, i2, (i30 << 3) | 4, zzgo);
                                    if ((i26 & i35) == 0) {
                                        zzgo5 = zzgo;
                                        unsafe2.putObject(t4, j, zzgo5.zzc);
                                    } else {
                                        zzgo5 = zzgo;
                                        unsafe2.putObject(t4, j, zzia.zza(unsafe2.getObject(t4, j), zzgo5.zzc));
                                    }
                                    i26 |= i35;
                                    bArr2 = bArr;
                                    i21 = i2;
                                    i25 = b;
                                    i28 = i15;
                                    i27 = i30;
                                    i24 = i5;
                                    i22 = i3;
                                    zzgo6 = zzgo5;
                                    break;
                                } else {
                                    i18 = i30;
                                    i17 = i5;
                                    i16 = i15;
                                    i9 = b;
                                    i4 = i3;
                                    i10 = i29;
                                    i7 = i26;
                                    unsafe = unsafe2;
                                    i8 = i17;
                                    i28 = i16;
                                    i6 = i18;
                                    break;
                                }
                            default:
                                i18 = i30;
                                i17 = i5;
                                i16 = i15;
                                i9 = b;
                                i4 = i3;
                                i10 = i29;
                                i7 = i26;
                                unsafe = unsafe2;
                                i8 = i17;
                                i28 = i16;
                                i6 = i18;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (i33 != 27) {
                            i8 = i5;
                            i7 = i26;
                            i12 = i28;
                            if (i33 <= 49) {
                                i13 = b;
                                i6 = i30;
                                unsafe = unsafe2;
                                i23 = zza(t, bArr, i29, i2, b, i30, i31, i8, (long) i32, i33, j, zzgo);
                            } else {
                                i14 = i29;
                                i13 = b;
                                i6 = i30;
                                unsafe = unsafe2;
                                if (i33 != 50) {
                                    i23 = zza(t, bArr, i14, i2, i13, i6, i31, i32, i33, j, i8, zzgo);
                                    if (i23 != i14) {
                                        zzjn2 = this;
                                        t4 = t;
                                        bArr2 = bArr;
                                        i21 = i2;
                                        zzgo6 = zzgo;
                                        i25 = i13;
                                        i27 = i6;
                                        i24 = i8;
                                        i26 = i7;
                                        i28 = i12;
                                        unsafe2 = unsafe;
                                    }
                                } else if (i31 == 2) {
                                    i23 = zza(t, bArr, i14, i2, i8, j, zzgo);
                                }
                                i4 = i3;
                                i10 = i23;
                                i9 = i13;
                                i28 = i12;
                            }
                            zzjn2 = this;
                            t4 = t;
                            bArr2 = bArr;
                            i27 = i6;
                            i21 = i2;
                            i22 = i3;
                            zzgo6 = zzgo;
                            i24 = i8;
                            i25 = i13;
                            i26 = i7;
                            i28 = i12;
                            unsafe2 = unsafe;
                        } else if (i31 == 2) {
                            zzig zzig = (zzig) unsafe2.getObject(t4, j);
                            if (!zzig.zza()) {
                                int size = zzig.size();
                                zzig = zzig.zza(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzig);
                            }
                            i23 = zzgl.zza(zzjn2.zza(i5), b, bArr, i29, i2, zzig, zzgo);
                            i22 = i3;
                            i25 = b;
                            i27 = i30;
                            zzgo6 = zzgo6;
                            i24 = i5;
                            i26 = i26;
                            i28 = i28;
                            i21 = i2;
                        } else {
                            i8 = i5;
                            i7 = i26;
                            i12 = i28;
                            i14 = i29;
                            i13 = b;
                            i6 = i30;
                            unsafe = unsafe2;
                        }
                        i4 = i3;
                        i10 = i14;
                        i9 = i13;
                        i28 = i12;
                    }
                    i22 = i3;
                }
                if (i9 != i4 || i4 == 0) {
                    if (this.zzh) {
                        zzgo2 = zzgo;
                        if (zzgo2.zzd == zzhl.zza()) {
                            t3 = t;
                            i11 = i6;
                        } else if (zzgo2.zzd.zza(this.zzg, i6) == null) {
                            i23 = zzgl.zza(i9, bArr, i10, i2, zze(t), zzgo);
                            t4 = t;
                            bArr2 = bArr;
                            i21 = i2;
                            i25 = i9;
                            zzjn2 = this;
                            zzgo6 = zzgo2;
                            i27 = i6;
                            i24 = i8;
                            i26 = i7;
                            unsafe2 = unsafe;
                            i22 = i4;
                        } else {
                            T t5 = t;
                            t5.zza();
                            zzhr<zzhy.zzc> zzhr = t5.zzc;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        t3 = t;
                        i11 = i6;
                        zzgo2 = zzgo;
                    }
                    i23 = zzgl.zza(i9, bArr, i10, i2, zze(t), zzgo);
                    i21 = i2;
                    i25 = i9;
                    zzjn2 = this;
                    zzgo6 = zzgo2;
                    i27 = i11;
                    t4 = t3;
                    i24 = i8;
                    i26 = i7;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i22 = i4;
                } else {
                    zzjn = this;
                    t2 = t;
                    i23 = i10;
                    i25 = i9;
                    i26 = i7;
                }
            } else {
                unsafe = unsafe2;
                i4 = i22;
                t2 = t4;
                zzjn = zzjn2;
            }
        }
        if (i28 != 1048575) {
            unsafe.putInt(t2, (long) i28, i26);
        }
        zzks zzks = null;
        for (int i38 = zzjn.zzm; i38 < zzjn.zzn; i38++) {
            zzks = (zzks) zzjn.zza(t2, zzjn.zzl[i38], zzks, (zzkt<UT, UB>) zzjn.zzq);
        }
        if (zzks != null) {
            zzjn.zzq.zzb(t2, zzks);
        }
        if (i4 == 0) {
            if (i23 != i2) {
                throw zzij.zzg();
            }
        } else if (i23 > i2 || i25 != i4) {
            throw zzij.zzg();
        }
        return i23;
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
    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, byte[] bArr, int i, int i2, zzgo zzgo) throws IOException {
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
        zzjn<T> zzjn = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i16 = i2;
        zzgo zzgo2 = zzgo;
        if (zzjn.zzj) {
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
                    i3 = zzgl.zza(b2, bArr2, i24, zzgo2);
                    b = zzgo2.zza;
                } else {
                    b = b2;
                    i3 = i24;
                }
                int i25 = b >>> 3;
                int i26 = b & 7;
                if (i25 > i21) {
                    i4 = zzjn.zza(i25, i22 / 3);
                } else {
                    i4 = zzjn.zzg(i25);
                }
                if (i4 == i17) {
                    i8 = i3;
                    i5 = i25;
                    unsafe = unsafe5;
                    i6 = i17;
                    i7 = 0;
                } else {
                    int[] iArr = zzjn.zzc;
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
                                    zzkz.zza(t2, j, zzgl.zzc(bArr2, i15));
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
                                    zzkz.zza((Object) t2, j, zzgl.zzd(bArr2, i15));
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
                                    int zzb2 = zzgl.zzb(bArr2, i15, zzgo2);
                                    unsafe3.putLong(t, j, zzgo2.zzb);
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
                                    i19 = zzgl.zza(bArr2, i15, zzgo2);
                                    unsafe3.putInt(t2, j, zzgo2.zza);
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
                                    unsafe3.putLong(t, j, zzgl.zzb(bArr2, i3));
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
                                    unsafe3.putInt(t2, j, zzgl.zza(bArr2, i3));
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
                                    i19 = zzgl.zzb(bArr2, i3, zzgo2);
                                    zzkz.zza(t2, j, zzgo2.zzb != 0);
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
                                        i19 = zzgl.zzc(bArr2, i3, zzgo2);
                                    } else {
                                        i19 = zzgl.zzd(bArr2, i3, zzgo2);
                                    }
                                    unsafe3.putObject(t2, j, zzgo2.zzc);
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
                                    i19 = zzgl.zza(zzjn.zza(i14), bArr2, i3, i16, zzgo2);
                                    Object object = unsafe3.getObject(t2, j);
                                    if (object == null) {
                                        unsafe3.putObject(t2, j, zzgo2.zzc);
                                    } else {
                                        unsafe3.putObject(t2, j, zzia.zza(object, zzgo2.zzc));
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
                                    i19 = zzgl.zze(bArr2, i3, zzgo2);
                                    unsafe3.putObject(t2, j, zzgo2.zzc);
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
                                    i19 = zzgl.zza(bArr2, i3, zzgo2);
                                    unsafe3.putInt(t2, j, zzgo2.zza);
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
                                    i19 = zzgl.zza(bArr2, i3, zzgo2);
                                    unsafe3.putInt(t2, j, zzhb.zze(zzgo2.zza));
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
                                    int zzb3 = zzgl.zzb(bArr2, i3, zzgo2);
                                    i10 = i20;
                                    i5 = i25;
                                    i9 = 1048575;
                                    unsafe2.putLong(t, j, zzhb.zza(zzgo2.zzb));
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
                                i19 = zza(t, bArr, i3, i2, b, i5, i26, i7, (long) i27, i28, j, zzgo);
                            } else {
                                i13 = i3;
                                i12 = i23;
                                unsafe = unsafe5;
                                i11 = i10;
                                i6 = -1;
                                if (i28 != 50) {
                                    i19 = zza(t, bArr, i13, i2, b, i5, i26, i27, i28, j, i7, zzgo);
                                } else if (i26 == 2) {
                                    i19 = zza(t, bArr, i13, i2, i7, j, zzgo);
                                }
                            }
                            zzjn = this;
                            t2 = t;
                            bArr2 = bArr;
                            i16 = i2;
                            zzgo2 = zzgo;
                            i22 = i7;
                            i17 = i6;
                            i21 = i5;
                            i23 = i12;
                            i20 = i11;
                            unsafe5 = unsafe;
                            i18 = 1048575;
                        } else if (i26 == 2) {
                            zzig zzig = (zzig) unsafe5.getObject(t2, j);
                            if (!zzig.zza()) {
                                int size = zzig.size();
                                zzig = zzig.zza(size == 0 ? 10 : size << 1);
                                unsafe5.putObject(t2, j, zzig);
                            }
                            i19 = zzgl.zza(zzjn.zza(i4), b, bArr, i3, i2, zzig, zzgo);
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
                i19 = zzgl.zza(b, bArr, i8, i2, zze(t), zzgo);
                zzjn = this;
                t2 = t;
                bArr2 = bArr;
                i16 = i2;
                zzgo2 = zzgo;
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
                throw zzij.zzg();
            }
            return;
        }
        zza(t, bArr, i, i2, 0, zzgo);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzkz.zzf(t, zzd2);
            if (zzf2 != null) {
                zzkz.zza(t, zzd2, this.zzs.zzd(zzf2));
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

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkt<UT, UB> zzkt) {
        zzif zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzkz.zzf(obj, (long) (zzd(i) & 1048575));
        return (zzf2 == null || (zzc2 = zzc(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzs.zza(zzf2), zzc2, ub, zzkt);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzif zzif, UB ub, zzkt<UT, UB> zzkt) {
        zzja<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzif.zza(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzkt.zza();
                }
                zzgx zzc2 = zzgp.zzc(zzjb.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzjb.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkt.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.gms.internal.measurement.zzkb] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23, types: [com.google.android.gms.internal.measurement.zzkb] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.measurement.zzkb
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
                            Map<?, ?> zzb2 = this.zzs.zzb(zzkz.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzln.MESSAGE) {
                                    zzkb<T> zzkb = 0;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzkb == null) {
                                            zzkb = zzjx.zza().zza((Class) next.getClass());
                                        }
                                        boolean zzd3 = zzkb.zzd(next);
                                        zzkb = zzkb;
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
                List list = (List) zzkz.zzf(t, (long) (zzd2 & 1048575));
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.measurement.zzkb */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzkb zzkb) {
        return zzkb.zzd(zzkz.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzlm zzlm) throws IOException {
        if (obj instanceof String) {
            zzlm.zza(i, (String) obj);
        } else {
            zzlm.zza(i, (zzgp) obj);
        }
    }

    private final void zza(Object obj, int i, zzjy zzjy) throws IOException {
        if (zzf(i)) {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzm());
        } else if (this.zzi) {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzl());
        } else {
            zzkz.zza(obj, (long) (i & 1048575), zzjy.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzkz.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzkz.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzkz.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzkz.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkz.zzf(t, j)).booleanValue();
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
                    return zzkz.zze(t, j2) != 0.0d;
                case 1:
                    return zzkz.zzd(t, j2) != 0.0f;
                case 2:
                    return zzkz.zzb(t, j2) != 0;
                case 3:
                    return zzkz.zzb(t, j2) != 0;
                case 4:
                    return zzkz.zza(t, j2) != 0;
                case 5:
                    return zzkz.zzb(t, j2) != 0;
                case 6:
                    return zzkz.zza(t, j2) != 0;
                case 7:
                    return zzkz.zzc(t, j2);
                case 8:
                    Object zzf2 = zzkz.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgp) {
                        return !zzgp.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzkz.zzf(t, j2) != null;
                case 10:
                    return !zzgp.zza.equals(zzkz.zzf(t, j2));
                case 11:
                    return zzkz.zza(t, j2) != 0;
                case 12:
                    return zzkz.zza(t, j2) != 0;
                case 13:
                    return zzkz.zza(t, j2) != 0;
                case 14:
                    return zzkz.zzb(t, j2) != 0;
                case 15:
                    return zzkz.zza(t, j2) != 0;
                case 16:
                    return zzkz.zzb(t, j2) != 0;
                case 17:
                    return zzkz.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzkz.zza(t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzkz.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzkz.zza(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkz.zza(t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzkz.zza((Object) t, (long) (zze(i2) & 1048575), i);
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
