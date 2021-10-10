package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

final class zzso<T> implements zzsz<T> {
    private static final int[] zzbcw = new int[0];
    private static final Unsafe zzbcx = zztx.zzro();
    private final int[] zzbcy;
    private final Object[] zzbcz;
    private final int zzbda;
    private final int zzbdb;
    private final zzsk zzbdc;
    private final boolean zzbdd;
    private final boolean zzbde;
    private final boolean zzbdf;
    private final boolean zzbdg;
    private final int[] zzbdh;
    private final int zzbdi;
    private final int zzbdj;
    private final zzsr zzbdk;
    private final zzru zzbdl;
    private final zztr<?, ?> zzbdm;
    private final zzqq<?> zzbdn;
    private final zzsf zzbdo;

    private zzso(int[] iArr, Object[] objArr, int i, int i2, zzsk zzsk, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzsr zzsr, zzru zzru, zztr<?, ?> zztr, zzqq<?> zzqq, zzsf zzsf) {
        this.zzbcy = iArr;
        this.zzbcz = objArr;
        this.zzbda = i;
        this.zzbdb = i2;
        this.zzbde = zzsk instanceof zzrc;
        this.zzbdf = z;
        this.zzbdd = zzqq != null && zzqq.zze(zzsk);
        this.zzbdg = false;
        this.zzbdh = iArr2;
        this.zzbdi = i3;
        this.zzbdj = i4;
        this.zzbdk = zzsr;
        this.zzbdl = zzru;
        this.zzbdm = zztr;
        this.zzbdn = zzqq;
        this.zzbdc = zzsk;
        this.zzbdo = zzsf;
    }

    private static boolean zzbt(int i) {
        return (i & PKIFailureInfo.duplicateCertReq) != 0;
    }

    static <T> zzso<T> zza(Class<T> cls, zzsi zzsi, zzsr zzsr, zzru zzru, zztr<?, ?> zztr, zzqq<?> zzqq, zzsf zzsf) {
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
        boolean z;
        int i10;
        zzsx zzsx;
        int i11;
        Class<?> cls2;
        int i12;
        String str;
        int i13;
        int i14;
        int i15;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        Field field2;
        Field field3;
        int i19;
        char charAt2;
        int i20;
        char charAt3;
        int i21;
        char charAt4;
        int i22;
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
        char charAt14;
        if (zzsi instanceof zzsx) {
            zzsx zzsx2 = (zzsx) zzsi;
            int i32 = 0;
            boolean z2 = zzsx2.zzql() == zzrc.zze.zzbba;
            String zzqt = zzsx2.zzqt();
            int length = zzqt.length();
            int charAt15 = zzqt.charAt(0);
            if (charAt15 >= 55296) {
                int i33 = charAt15 & 8191;
                int i34 = 1;
                int i35 = 13;
                while (true) {
                    i = i34 + 1;
                    charAt14 = zzqt.charAt(i34);
                    if (charAt14 < 55296) {
                        break;
                    }
                    i33 |= (charAt14 & 8191) << i35;
                    i35 += 13;
                    i34 = i;
                }
                charAt15 = i33 | (charAt14 << i35);
            } else {
                i = 1;
            }
            int i36 = i + 1;
            int charAt16 = zzqt.charAt(i);
            if (charAt16 >= 55296) {
                int i37 = charAt16 & 8191;
                int i38 = 13;
                while (true) {
                    i31 = i36 + 1;
                    charAt13 = zzqt.charAt(i36);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i37 |= (charAt13 & 8191) << i38;
                    i38 += 13;
                    i36 = i31;
                }
                charAt16 = i37 | (charAt13 << i38);
                i36 = i31;
            }
            if (charAt16 == 0) {
                i7 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                iArr = zzbcw;
                i6 = 0;
            } else {
                int i39 = i36 + 1;
                int charAt17 = zzqt.charAt(i36);
                if (charAt17 >= 55296) {
                    int i40 = charAt17 & 8191;
                    int i41 = 13;
                    while (true) {
                        i30 = i39 + 1;
                        charAt12 = zzqt.charAt(i39);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i40 |= (charAt12 & 8191) << i41;
                        i41 += 13;
                        i39 = i30;
                    }
                    charAt17 = i40 | (charAt12 << i41);
                    i39 = i30;
                }
                int i42 = i39 + 1;
                int charAt18 = zzqt.charAt(i39);
                if (charAt18 >= 55296) {
                    int i43 = charAt18 & 8191;
                    int i44 = 13;
                    while (true) {
                        i29 = i42 + 1;
                        charAt11 = zzqt.charAt(i42);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i43 |= (charAt11 & 8191) << i44;
                        i44 += 13;
                        i42 = i29;
                    }
                    charAt18 = i43 | (charAt11 << i44);
                    i42 = i29;
                }
                int i45 = i42 + 1;
                i5 = zzqt.charAt(i42);
                if (i5 >= 55296) {
                    int i46 = i5 & 8191;
                    int i47 = 13;
                    while (true) {
                        i28 = i45 + 1;
                        charAt10 = zzqt.charAt(i45);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i46 |= (charAt10 & 8191) << i47;
                        i47 += 13;
                        i45 = i28;
                    }
                    i5 = i46 | (charAt10 << i47);
                    i45 = i28;
                }
                int i48 = i45 + 1;
                int charAt19 = zzqt.charAt(i45);
                if (charAt19 >= 55296) {
                    int i49 = charAt19 & 8191;
                    int i50 = 13;
                    while (true) {
                        i27 = i48 + 1;
                        charAt9 = zzqt.charAt(i48);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i49 |= (charAt9 & 8191) << i50;
                        i50 += 13;
                        i48 = i27;
                    }
                    charAt19 = i49 | (charAt9 << i50);
                    i48 = i27;
                }
                int i51 = i48 + 1;
                i3 = zzqt.charAt(i48);
                if (i3 >= 55296) {
                    int i52 = i3 & 8191;
                    int i53 = 13;
                    while (true) {
                        i26 = i51 + 1;
                        charAt8 = zzqt.charAt(i51);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i52 |= (charAt8 & 8191) << i53;
                        i53 += 13;
                        i51 = i26;
                    }
                    i3 = i52 | (charAt8 << i53);
                    i51 = i26;
                }
                int i54 = i51 + 1;
                int charAt20 = zzqt.charAt(i51);
                if (charAt20 >= 55296) {
                    int i55 = charAt20 & 8191;
                    int i56 = 13;
                    while (true) {
                        i25 = i54 + 1;
                        charAt7 = zzqt.charAt(i54);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i55 |= (charAt7 & 8191) << i56;
                        i56 += 13;
                        i54 = i25;
                    }
                    charAt20 = i55 | (charAt7 << i56);
                    i54 = i25;
                }
                int i57 = i54 + 1;
                int charAt21 = zzqt.charAt(i54);
                if (charAt21 >= 55296) {
                    int i58 = charAt21 & 8191;
                    int i59 = i57;
                    int i60 = 13;
                    while (true) {
                        i24 = i59 + 1;
                        charAt6 = zzqt.charAt(i59);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i58 |= (charAt6 & 8191) << i60;
                        i60 += 13;
                        i59 = i24;
                    }
                    charAt21 = i58 | (charAt6 << i60);
                    i22 = i24;
                } else {
                    i22 = i57;
                }
                int i61 = i22 + 1;
                int charAt22 = zzqt.charAt(i22);
                if (charAt22 >= 55296) {
                    int i62 = charAt22 & 8191;
                    int i63 = i61;
                    int i64 = 13;
                    while (true) {
                        i23 = i63 + 1;
                        charAt5 = zzqt.charAt(i63);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i62 |= (charAt5 & 8191) << i64;
                        i64 += 13;
                        i63 = i23;
                    }
                    charAt22 = i62 | (charAt5 << i64);
                    i61 = i23;
                }
                int i65 = (charAt17 << 1) + charAt18;
                i6 = charAt19;
                i4 = i65;
                i2 = charAt22;
                i32 = charAt17;
                i36 = i61;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                i7 = charAt20;
            }
            Unsafe unsafe = zzbcx;
            Object[] zzqu = zzsx2.zzqu();
            Class<?> cls3 = zzsx2.zzqn().getClass();
            int[] iArr2 = new int[(i3 * 3)];
            Object[] objArr = new Object[(i3 << 1)];
            int i66 = i2 + i7;
            int i67 = i2;
            int i68 = i36;
            int i69 = i66;
            int i70 = 0;
            int i71 = 0;
            while (i68 < length) {
                int i72 = i68 + 1;
                int charAt23 = zzqt.charAt(i68);
                if (charAt23 >= 55296) {
                    int i73 = charAt23 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i21 = i74 + 1;
                        charAt4 = zzqt.charAt(i74);
                        i8 = i2;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i73 |= (charAt4 & 8191) << i75;
                        i75 += 13;
                        i74 = i21;
                        i2 = i8;
                    }
                    charAt23 = i73 | (charAt4 << i75);
                    i9 = i21;
                } else {
                    i8 = i2;
                    i9 = i72;
                }
                int i76 = i9 + 1;
                int charAt24 = zzqt.charAt(i9);
                if (charAt24 >= 55296) {
                    int i77 = charAt24 & 8191;
                    int i78 = i76;
                    int i79 = 13;
                    while (true) {
                        i20 = i78 + 1;
                        charAt3 = zzqt.charAt(i78);
                        z = z2;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i77 |= (charAt3 & 8191) << i79;
                        i79 += 13;
                        i78 = i20;
                        z2 = z;
                    }
                    charAt24 = i77 | (charAt3 << i79);
                    i10 = i20;
                } else {
                    z = z2;
                    i10 = i76;
                }
                int i80 = charAt24 & 255;
                if ((charAt24 & 1024) != 0) {
                    iArr[i70] = i71;
                    i70++;
                }
                if (i80 >= 51) {
                    int i81 = i10 + 1;
                    int charAt25 = zzqt.charAt(i10);
                    char c = 55296;
                    if (charAt25 >= 55296) {
                        int i82 = charAt25 & 8191;
                        int i83 = 13;
                        while (true) {
                            i19 = i81 + 1;
                            charAt2 = zzqt.charAt(i81);
                            if (charAt2 < c) {
                                break;
                            }
                            i82 |= (charAt2 & 8191) << i83;
                            i83 += 13;
                            i81 = i19;
                            c = 55296;
                        }
                        charAt25 = i82 | (charAt2 << i83);
                        i81 = i19;
                    }
                    int i84 = i80 - 51;
                    if (i84 == 9 || i84 == 17) {
                        objArr[((i71 / 3) << 1) + 1] = zzqu[i4];
                        i4++;
                    } else if (i84 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i71 / 3) << 1) + 1] = zzqu[i4];
                        i4++;
                    }
                    int i85 = charAt25 << 1;
                    Object obj = zzqu[i85];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzqu[i85] = field2;
                    }
                    zzsx = zzsx2;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i86 = i85 + 1;
                    Object obj2 = zzqu[i86];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzqu[i86] = field3;
                    }
                    cls2 = cls3;
                    i11 = i4;
                    i10 = i81;
                    str = zzqt;
                    i12 = 0;
                    i13 = (int) unsafe.objectFieldOffset(field3);
                    i14 = objectFieldOffset;
                    i15 = i32;
                } else {
                    zzsx = zzsx2;
                    int i87 = i4 + 1;
                    Field zza = zza(cls3, (String) zzqu[i4]);
                    if (i80 == 9 || i80 == 17) {
                        i16 = 1;
                        objArr[((i71 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (i80 == 27 || i80 == 49) {
                            i16 = 1;
                            i18 = i87 + 1;
                            objArr[((i71 / 3) << 1) + 1] = zzqu[i87];
                        } else if (i80 == 12 || i80 == 30 || i80 == 44) {
                            i16 = 1;
                            if ((charAt15 & 1) == 1) {
                                i18 = i87 + 1;
                                objArr[((i71 / 3) << 1) + 1] = zzqu[i87];
                            }
                        } else {
                            if (i80 == 50) {
                                int i88 = i67 + 1;
                                iArr[i67] = i71;
                                int i89 = (i71 / 3) << 1;
                                int i90 = i87 + 1;
                                objArr[i89] = zzqu[i87];
                                if ((charAt24 & 2048) != 0) {
                                    i87 = i90 + 1;
                                    objArr[i89 + 1] = zzqu[i90];
                                    i67 = i88;
                                } else {
                                    i87 = i90;
                                    i16 = 1;
                                    i67 = i88;
                                }
                            }
                            i16 = 1;
                        }
                        i87 = i18;
                    }
                    i14 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != i16) {
                        i11 = i87;
                        i15 = i32;
                        cls2 = cls3;
                        str = zzqt;
                    } else if (i80 <= 17) {
                        int i91 = i10 + 1;
                        str = zzqt;
                        int charAt26 = str.charAt(i10);
                        if (charAt26 >= 55296) {
                            int i92 = charAt26 & 8191;
                            int i93 = 13;
                            while (true) {
                                i17 = i91 + 1;
                                charAt = str.charAt(i91);
                                if (charAt < 55296) {
                                    break;
                                }
                                i92 |= (charAt & 8191) << i93;
                                i93 += 13;
                                i91 = i17;
                            }
                            charAt26 = i92 | (charAt << i93);
                            i91 = i17;
                        }
                        int i94 = (i32 << 1) + (charAt26 / 32);
                        Object obj3 = zzqu[i94];
                        i11 = i87;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzqu[i94] = field;
                        }
                        i15 = i32;
                        cls2 = cls3;
                        i12 = charAt26 % 32;
                        i13 = (int) unsafe.objectFieldOffset(field);
                        i10 = i91;
                        if (i80 >= 18 && i80 <= 49) {
                            iArr[i69] = i14;
                            i69++;
                        }
                    } else {
                        i11 = i87;
                        i15 = i32;
                        cls2 = cls3;
                        str = zzqt;
                    }
                    i13 = 0;
                    i12 = 0;
                    iArr[i69] = i14;
                    i69++;
                }
                int i95 = i71 + 1;
                iArr2[i71] = charAt23;
                int i96 = i95 + 1;
                iArr2[i95] = i14 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? PKIFailureInfo.duplicateCertReq : 0) | (i80 << 20);
                i71 = i96 + 1;
                iArr2[i96] = (i12 << 20) | i13;
                i32 = i15;
                zzqt = str;
                i68 = i10;
                cls3 = cls2;
                i6 = i6;
                length = length;
                i2 = i8;
                z2 = z;
                i5 = i5;
                i4 = i11;
                zzsx2 = zzsx;
            }
            return new zzso<>(iArr2, objArr, i5, i6, zzsx2.zzqn(), z2, false, iArr, i2, i66, zzsr, zzru, zztr, zzqq, zzsf);
        }
        ((zztm) zzsi).zzql();
        int i97 = zzrc.zze.zzbba;
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

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final T newInstance() {
        return (T) this.zzbdk.newInstance(this.zzbdc);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzm(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.zztx.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.zztx.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.zztx.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.zztx.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.gtm.zzsz
    public final boolean equals(T t, T t2) {
        int length = this.zzbcy.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzbr = zzbr(i);
                long j = (long) (zzbr & 1048575);
                switch ((zzbr & 267386880) >>> 20) {
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
                        z = zztb.zze(zztx.zzp(t, j), zztx.zzp(t2, j));
                        break;
                    case 50:
                        z = zztb.zze(zztx.zzp(t, j), zztx.zzp(t2, j));
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
                        long zzbs = (long) (zzbs(i) & 1048575);
                        if (zztx.zzk(t, zzbs) == zztx.zzk(t2, zzbs)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzbdm.zzag(t).equals(this.zzbdm.zzag(t2))) {
                return false;
            } else {
                if (this.zzbdd) {
                    return this.zzbdn.zzr(t).equals(this.zzbdn.zzr(t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzbcy.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzbr = zzbr(i4);
            int i5 = this.zzbcy[i4];
            long j = (long) (1048575 & zzbr);
            int i6 = 37;
            switch ((zzbr & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzre.zzz(Double.doubleToLongBits(zztx.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zztx.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzre.zzz(zztx.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzre.zzz(zztx.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzre.zzz(zztx.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzre.zzk(zztx.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zztx.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zztx.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zztx.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzre.zzz(zztx.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zztx.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzre.zzz(zztx.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zztx.zzp(t, j);
                    if (zzp2 != null) {
                        i6 = zzp2.hashCode();
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
                    i = zztx.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zztx.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(Double.doubleToLongBits(zzf(t, j)));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzg(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzk(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zztx.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zztx.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zztx.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzre.zzz(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zztx.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzbdm.zzag(t).hashCode();
        return this.zzbdd ? (hashCode * 53) + this.zzbdn.zzr(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zzd(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzbcy.length; i += 3) {
            int zzbr = zzbr(i);
            long j = (long) (1048575 & zzbr);
            int i2 = this.zzbcy[i];
            switch ((zzbr & 267386880) >>> 20) {
                case 0:
                    if (zzb(t2, i)) {
                        zztx.zza(t, j, zztx.zzo(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzn(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzl(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzl(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzl(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzb(t2, i)) {
                        zztx.zza(t, j, zztx.zzm(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzb(t2, i)) {
                        zztx.zza(t, j, zztx.zzp(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zzb(t2, i)) {
                        zztx.zza(t, j, zztx.zzp(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzl(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzb(t2, i)) {
                        zztx.zzb(t, j, zztx.zzk(t2, j));
                        zzc(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzb(t2, i)) {
                        zztx.zza((Object) t, j, zztx.zzl(t2, j));
                        zzc(t, i);
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
                    this.zzbdl.zza(t, t2, j);
                    break;
                case 50:
                    zztb.zza(this.zzbdo, t, t2, j);
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
                        zztx.zza(t, j, zztx.zzp(t2, j));
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
                        zztx.zza(t, j, zztx.zzp(t2, j));
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
        if (!this.zzbdf) {
            zztb.zza(this.zzbdm, t, t2);
            if (this.zzbdd) {
                zztb.zza(this.zzbdn, t, t2);
            }
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzbr = (long) (zzbr(i) & 1048575);
        if (zzb(t2, i)) {
            Object zzp = zztx.zzp(t, zzbr);
            Object zzp2 = zztx.zzp(t2, zzbr);
            if (zzp != null && zzp2 != null) {
                zztx.zza(t, zzbr, zzre.zzb(zzp, zzp2));
                zzc(t, i);
            } else if (zzp2 != null) {
                zztx.zza(t, zzbr, zzp2);
                zzc(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbr = zzbr(i);
        int i2 = this.zzbcy[i];
        long j = (long) (zzbr & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zztx.zzp(t, j);
            Object zzp2 = zztx.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zztx.zza(t, j, zzre.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zztx.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.gtm.zzsz
    public final int zzad(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        int i3;
        int i4;
        int i5;
        int zzb;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int zzb2;
        int i11;
        int i12;
        int i13;
        int i14 = 267386880;
        int i15 = 1;
        int i16 = 0;
        if (this.zzbdf) {
            Unsafe unsafe = zzbcx;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzbcy.length) {
                int zzbr = zzbr(i17);
                int i19 = (zzbr & i14) >>> 20;
                int i20 = this.zzbcy[i17];
                long j2 = (long) (zzbr & 1048575);
                int i21 = (i19 < zzqw.DOUBLE_LIST_PACKED.id() || i19 > zzqw.SINT64_LIST_PACKED.id()) ? 0 : this.zzbcy[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzd(i20, zztx.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zze(i20, zztx.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzi(i20, zztx.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzl(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzc(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zzb(t, i17)) {
                            Object zzp = zztx.zzp(t, j2);
                            if (zzp instanceof zzps) {
                                zzb2 = zzqj.zzc(i20, (zzps) zzp);
                                break;
                            } else {
                                zzb2 = zzqj.zzb(i20, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zzb(t, i17)) {
                            zzb2 = zztb.zzc(i20, zztx.zzp(t, j2), zzbo(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzc(i20, (zzps) zztx.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzj(i20, zztx.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzn(i20, zztx.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzm(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzk(i20, zztx.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzf(i20, zztx.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zzb(t, i17)) {
                            zzb2 = zzqj.zzc(i20, (zzsk) zztx.zzp(t, j2), zzbo(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb2 = zztb.zzw(i20, zze(t, j2), false);
                        break;
                    case 19:
                        zzb2 = zztb.zzv(i20, zze(t, j2), false);
                        break;
                    case 20:
                        zzb2 = zztb.zzo(i20, zze(t, j2), false);
                        break;
                    case 21:
                        zzb2 = zztb.zzp(i20, zze(t, j2), false);
                        break;
                    case 22:
                        zzb2 = zztb.zzs(i20, zze(t, j2), false);
                        break;
                    case 23:
                        zzb2 = zztb.zzw(i20, zze(t, j2), false);
                        break;
                    case 24:
                        zzb2 = zztb.zzv(i20, zze(t, j2), false);
                        break;
                    case 25:
                        zzb2 = zztb.zzx(i20, zze(t, j2), false);
                        break;
                    case 26:
                        zzb2 = zztb.zzc(i20, zze(t, j2));
                        break;
                    case 27:
                        zzb2 = zztb.zzc(i20, (List<?>) zze(t, j2), zzbo(i17));
                        break;
                    case 28:
                        zzb2 = zztb.zzd(i20, zze(t, j2));
                        break;
                    case 29:
                        zzb2 = zztb.zzt(i20, zze(t, j2), false);
                        break;
                    case 30:
                        zzb2 = zztb.zzr(i20, zze(t, j2), false);
                        break;
                    case 31:
                        zzb2 = zztb.zzv(i20, zze(t, j2), false);
                        break;
                    case 32:
                        zzb2 = zztb.zzw(i20, zze(t, j2), false);
                        break;
                    case 33:
                        zzb2 = zztb.zzu(i20, zze(t, j2), false);
                        break;
                    case 34:
                        zzb2 = zztb.zzq(i20, zze(t, j2), false);
                        break;
                    case 35:
                        i12 = zztb.zzae((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zztb.zzad((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zztb.zzw((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zztb.zzx((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zztb.zzaa((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zztb.zzae((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zztb.zzad((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zztb.zzaf((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zztb.zzab((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zztb.zzz((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zztb.zzad((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zztb.zzae((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zztb.zzac((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zztb.zzy((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzbdg) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzqj.zzbb(i20);
                            i11 = zzqj.zzbd(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb2 = zztb.zzd(i20, zze(t, j2), zzbo(i17));
                        break;
                    case 50:
                        zzb2 = this.zzbdo.zzb(i20, zztx.zzp(t, j2), zzbp(i17));
                        break;
                    case 51:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzd(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zze(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzi(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzl(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzc(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t, i20, i17)) {
                            Object zzp2 = zztx.zzp(t, j2);
                            if (zzp2 instanceof zzps) {
                                zzb2 = zzqj.zzc(i20, (zzps) zzp2);
                                break;
                            } else {
                                zzb2 = zzqj.zzb(i20, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t, i20, i17)) {
                            zzb2 = zztb.zzc(i20, zztx.zzp(t, j2), zzbo(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzc(i20, (zzps) zztx.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzj(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzn(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzm(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzk(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzf(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzqj.zzc(i20, (zzsk) zztx.zzp(t, j2), zzbo(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    default:
                        i17 += 3;
                        i14 = 267386880;
                }
                i18 += zzb2;
                i17 += 3;
                i14 = 267386880;
            }
            return i18 + zza((zztr) this.zzbdm, (Object) t);
        }
        Unsafe unsafe2 = zzbcx;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzbcy.length) {
            int zzbr2 = zzbr(i23);
            int[] iArr = this.zzbcy;
            int i26 = iArr[i23];
            int i27 = (zzbr2 & 267386880) >>> 20;
            if (i27 <= 17) {
                int i28 = iArr[i23 + 2];
                int i29 = i28 & 1048575;
                i = i15 << (i28 >>> 20);
                if (i29 != i22) {
                    i25 = unsafe2.getInt(t, (long) i29);
                    i22 = i29;
                }
                i2 = i28;
            } else {
                i2 = (!this.zzbdg || i27 < zzqw.DOUBLE_LIST_PACKED.id() || i27 > zzqw.SINT64_LIST_PACKED.id()) ? 0 : this.zzbcy[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzbr2 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzqj.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzqj.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzqj.zzd(i26, unsafe2.getLong(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzqj.zze(i26, unsafe2.getLong(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzqj.zzi(i26, unsafe2.getInt(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzqj.zzg(i26, 0L);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzqj.zzl(i26, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                    i3 = 0;
                    z = false;
                    j = 0;
                case 7:
                    if ((i25 & i) != 0) {
                        i4 = 1;
                        i24 += zzqj.zzc(i26, true);
                        i3 = 0;
                        z = false;
                        j = 0;
                        break;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                case 8:
                    if ((i25 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        if (object instanceof zzps) {
                            zzb = zzqj.zzc(i26, (zzps) object);
                        } else {
                            zzb = zzqj.zzb(i26, (String) object);
                        }
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    if ((i25 & i) != 0) {
                        zzb = zztb.zzc(i26, unsafe2.getObject(t, j3), zzbo(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzc(i26, (zzps) unsafe2.getObject(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzj(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzn(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzqj.zzm(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzk(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzf(i26, unsafe2.getLong(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb = zzqj.zzc(i26, (zzsk) unsafe2.getObject(t, j3), zzbo(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzb = zztb.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zztb.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zztb.zzo(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zztb.zzp(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zztb.zzs(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zztb.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zztb.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zztb.zzx(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzb = zztb.zzc(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzb = zztb.zzc(i26, (List<?>) ((List) unsafe2.getObject(t, j3)), zzbo(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzb = zztb.zzd(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzb = zztb.zzt(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zztb.zzr(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zztb.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zztb.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zztb.zzu(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zztb.zzq(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zztb.zzae((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zztb.zzad((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zztb.zzw((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zztb.zzx((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zztb.zzaa((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zztb.zzae((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zztb.zzad((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zztb.zzaf((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zztb.zzab((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zztb.zzz((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zztb.zzad((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zztb.zzae((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zztb.zzac((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zztb.zzy((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzbdg) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzqj.zzbb(i26);
                        i8 = zzqj.zzbd(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzb = zztb.zzd(i26, (List) unsafe2.getObject(t, j3), zzbo(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzb = this.zzbdo.zzb(i26, unsafe2.getObject(t, j3), zzbp(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzb(i26, 0.0d);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t, i26, i23)) {
                        i6 = zzqj.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzd(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zze(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzi(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzg(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t, i26, i23)) {
                        i6 = zzqj.zzl(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t, i26, i23)) {
                        i6 = zzqj.zzc(i26, true);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 59:
                    if (zza(t, i26, i23)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzps) {
                            zzb = zzqj.zzc(i26, (zzps) object2);
                        } else {
                            zzb = zzqj.zzb(i26, (String) object2);
                        }
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    if (zza(t, i26, i23)) {
                        zzb = zztb.zzc(i26, unsafe2.getObject(t, j3), zzbo(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzc(i26, (zzps) unsafe2.getObject(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzj(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzn(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t, i26, i23)) {
                        i6 = zzqj.zzm(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzk(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzf(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t, i26, i23)) {
                        zzb = zzqj.zzc(i26, (zzsk) unsafe2.getObject(t, j3), zzbo(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                default:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
            }
            i23 += 3;
            i16 = i3;
            i15 = i4;
        }
        int i30 = i16;
        int zza = i24 + zza((zztr) this.zzbdm, (Object) t);
        if (!this.zzbdd) {
            return zza;
        }
        zzqt<?> zzr = this.zzbdn.zzr(t);
        for (int i31 = i30; i31 < zzr.zzaxo.zzra(); i31++) {
            Map.Entry<FieldDescriptorType, Object> zzbv = zzr.zzaxo.zzbv(i31);
            i30 += zzqt.zzb((zzqv<?>) zzbv.getKey(), zzbv.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zzr.zzaxo.zzrb()) {
            i30 += zzqt.zzb((zzqv<?>) entry.getKey(), entry.getValue());
        }
        return zza + i30;
    }

    private static <UT, UB> int zza(zztr<UT, UB> zztr, T t) {
        return zztr.zzad(zztr.zzag(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zztx.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zza(T t, zzum zzum) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        if (zzum.zzol() == zzrc.zze.zzbbd) {
            zza(this.zzbdm, t, zzum);
            if (this.zzbdd) {
                zzqt<?> zzr = this.zzbdn.zzr(t);
                if (!zzr.zzaxo.isEmpty()) {
                    it2 = zzr.descendingIterator();
                    entry2 = it2.next();
                    for (length2 = this.zzbcy.length - 3; length2 >= 0; length2 -= 3) {
                        int zzbr = zzbr(length2);
                        int i2 = this.zzbcy[length2];
                        while (entry2 != null && this.zzbdn.zzb(entry2) > i2) {
                            this.zzbdn.zza(zzum, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzbr & 267386880) >>> 20) {
                            case 0:
                                if (zzb(t, length2)) {
                                    zzum.zza(i2, zztx.zzo(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zzb(t, length2)) {
                                    zzum.zza(i2, zztx.zzn(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zzb(t, length2)) {
                                    zzum.zzi(i2, zztx.zzl(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zzb(t, length2)) {
                                    zzum.zza(i2, zztx.zzl(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zzb(t, length2)) {
                                    zzum.zze(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zzb(t, length2)) {
                                    zzum.zzc(i2, zztx.zzl(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zzb(t, length2)) {
                                    zzum.zzh(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zzb(t, length2)) {
                                    zzum.zzb(i2, zztx.zzm(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zzb(t, length2)) {
                                    zza(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzum);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zzb(t, length2)) {
                                    zzum.zza(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzbo(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zzb(t, length2)) {
                                    zzum.zza(i2, (zzps) zztx.zzp(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zzb(t, length2)) {
                                    zzum.zzf(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zzb(t, length2)) {
                                    zzum.zzp(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zzb(t, length2)) {
                                    zzum.zzo(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zzb(t, length2)) {
                                    zzum.zzj(i2, zztx.zzl(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zzb(t, length2)) {
                                    zzum.zzg(i2, zztx.zzk(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zzb(t, length2)) {
                                    zzum.zzb(i2, zztx.zzl(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zzb(t, length2)) {
                                    zzum.zzb(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzbo(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zztb.zza(this.zzbcy[length2], (List<Double>) ((List) zztx.zzp(t, (long) (zzbr & 1048575))), zzum, false);
                                break;
                            case 19:
                                zztb.zzb(this.zzbcy[length2], (List<Float>) ((List) zztx.zzp(t, (long) (zzbr & 1048575))), zzum, false);
                                break;
                            case 20:
                                zztb.zzc(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 21:
                                zztb.zzd(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 22:
                                zztb.zzh(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 23:
                                zztb.zzf(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 24:
                                zztb.zzk(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 25:
                                zztb.zzn(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 26:
                                zztb.zza(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum);
                                break;
                            case 27:
                                zztb.zza(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, zzbo(length2));
                                break;
                            case 28:
                                zztb.zzb(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum);
                                break;
                            case 29:
                                zztb.zzi(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 30:
                                zztb.zzm(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 31:
                                zztb.zzl(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 32:
                                zztb.zzg(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 33:
                                zztb.zzj(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 34:
                                zztb.zze(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, false);
                                break;
                            case 35:
                                zztb.zza(this.zzbcy[length2], (List<Double>) ((List) zztx.zzp(t, (long) (zzbr & 1048575))), zzum, true);
                                break;
                            case 36:
                                zztb.zzb(this.zzbcy[length2], (List<Float>) ((List) zztx.zzp(t, (long) (zzbr & 1048575))), zzum, true);
                                break;
                            case 37:
                                zztb.zzc(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 38:
                                zztb.zzd(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 39:
                                zztb.zzh(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 40:
                                zztb.zzf(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 41:
                                zztb.zzk(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 42:
                                zztb.zzn(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 43:
                                zztb.zzi(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 44:
                                zztb.zzm(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 45:
                                zztb.zzl(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 46:
                                zztb.zzg(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 47:
                                zztb.zzj(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 48:
                                zztb.zze(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, true);
                                break;
                            case 49:
                                zztb.zzb(this.zzbcy[length2], (List) zztx.zzp(t, (long) (zzbr & 1048575)), zzum, zzbo(length2));
                                break;
                            case 50:
                                zza(zzum, i2, zztx.zzp(t, (long) (zzbr & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i2, length2)) {
                                    zzum.zza(i2, zzf(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i2, length2)) {
                                    zzum.zza(i2, zzg(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i2, length2)) {
                                    zzum.zzi(i2, zzi(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i2, length2)) {
                                    zzum.zza(i2, zzi(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i2, length2)) {
                                    zzum.zze(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i2, length2)) {
                                    zzum.zzc(i2, zzi(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i2, length2)) {
                                    zzum.zzh(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i2, length2)) {
                                    zzum.zzb(i2, zzj(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i2, length2)) {
                                    zza(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzum);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i2, length2)) {
                                    zzum.zza(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzbo(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i2, length2)) {
                                    zzum.zza(i2, (zzps) zztx.zzp(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i2, length2)) {
                                    zzum.zzf(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i2, length2)) {
                                    zzum.zzp(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i2, length2)) {
                                    zzum.zzo(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i2, length2)) {
                                    zzum.zzj(i2, zzi(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i2, length2)) {
                                    zzum.zzg(i2, zzh(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i2, length2)) {
                                    zzum.zzb(i2, zzi(t, (long) (zzbr & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i2, length2)) {
                                    zzum.zzb(i2, zztx.zzp(t, (long) (zzbr & 1048575)), zzbo(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzbdn.zza(zzum, entry2);
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
        } else if (this.zzbdf) {
            if (this.zzbdd) {
                zzqt<?> zzr2 = this.zzbdn.zzr(t);
                if (!zzr2.zzaxo.isEmpty()) {
                    it = zzr2.iterator();
                    entry = it.next();
                    length = this.zzbcy.length;
                    for (i = 0; i < length; i += 3) {
                        int zzbr2 = zzbr(i);
                        int i3 = this.zzbcy[i];
                        while (entry != null && this.zzbdn.zzb(entry) <= i3) {
                            this.zzbdn.zza(zzum, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzbr2 & 267386880) >>> 20) {
                            case 0:
                                if (zzb(t, i)) {
                                    zzum.zza(i3, zztx.zzo(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zzb(t, i)) {
                                    zzum.zza(i3, zztx.zzn(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zzb(t, i)) {
                                    zzum.zzi(i3, zztx.zzl(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zzb(t, i)) {
                                    zzum.zza(i3, zztx.zzl(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zzb(t, i)) {
                                    zzum.zze(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zzb(t, i)) {
                                    zzum.zzc(i3, zztx.zzl(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zzb(t, i)) {
                                    zzum.zzh(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zzb(t, i)) {
                                    zzum.zzb(i3, zztx.zzm(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zzb(t, i)) {
                                    zza(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zzb(t, i)) {
                                    zzum.zza(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzbo(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zzb(t, i)) {
                                    zzum.zza(i3, (zzps) zztx.zzp(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zzb(t, i)) {
                                    zzum.zzf(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zzb(t, i)) {
                                    zzum.zzp(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zzb(t, i)) {
                                    zzum.zzo(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zzb(t, i)) {
                                    zzum.zzj(i3, zztx.zzl(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zzb(t, i)) {
                                    zzum.zzg(i3, zztx.zzk(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zzb(t, i)) {
                                    zzum.zzb(i3, zztx.zzl(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zzb(t, i)) {
                                    zzum.zzb(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzbo(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zztb.zza(this.zzbcy[i], (List<Double>) ((List) zztx.zzp(t, (long) (zzbr2 & 1048575))), zzum, false);
                                break;
                            case 19:
                                zztb.zzb(this.zzbcy[i], (List<Float>) ((List) zztx.zzp(t, (long) (zzbr2 & 1048575))), zzum, false);
                                break;
                            case 20:
                                zztb.zzc(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 21:
                                zztb.zzd(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 22:
                                zztb.zzh(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 23:
                                zztb.zzf(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 24:
                                zztb.zzk(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 25:
                                zztb.zzn(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 26:
                                zztb.zza(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum);
                                break;
                            case 27:
                                zztb.zza(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, zzbo(i));
                                break;
                            case 28:
                                zztb.zzb(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum);
                                break;
                            case 29:
                                zztb.zzi(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 30:
                                zztb.zzm(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 31:
                                zztb.zzl(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 32:
                                zztb.zzg(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 33:
                                zztb.zzj(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 34:
                                zztb.zze(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, false);
                                break;
                            case 35:
                                zztb.zza(this.zzbcy[i], (List<Double>) ((List) zztx.zzp(t, (long) (zzbr2 & 1048575))), zzum, true);
                                break;
                            case 36:
                                zztb.zzb(this.zzbcy[i], (List<Float>) ((List) zztx.zzp(t, (long) (zzbr2 & 1048575))), zzum, true);
                                break;
                            case 37:
                                zztb.zzc(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 38:
                                zztb.zzd(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 39:
                                zztb.zzh(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 40:
                                zztb.zzf(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 41:
                                zztb.zzk(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 42:
                                zztb.zzn(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 43:
                                zztb.zzi(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 44:
                                zztb.zzm(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 45:
                                zztb.zzl(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 46:
                                zztb.zzg(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 47:
                                zztb.zzj(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 48:
                                zztb.zze(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, true);
                                break;
                            case 49:
                                zztb.zzb(this.zzbcy[i], (List) zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum, zzbo(i));
                                break;
                            case 50:
                                zza(zzum, i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i3, i)) {
                                    zzum.zza(i3, zzf(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i3, i)) {
                                    zzum.zza(i3, zzg(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i3, i)) {
                                    zzum.zzi(i3, zzi(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i3, i)) {
                                    zzum.zza(i3, zzi(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i3, i)) {
                                    zzum.zze(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i3, i)) {
                                    zzum.zzc(i3, zzi(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i3, i)) {
                                    zzum.zzh(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i3, i)) {
                                    zzum.zzb(i3, zzj(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i3, i)) {
                                    zza(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzum);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i3, i)) {
                                    zzum.zza(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzbo(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i3, i)) {
                                    zzum.zza(i3, (zzps) zztx.zzp(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i3, i)) {
                                    zzum.zzf(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i3, i)) {
                                    zzum.zzp(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i3, i)) {
                                    zzum.zzo(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i3, i)) {
                                    zzum.zzj(i3, zzi(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i3, i)) {
                                    zzum.zzg(i3, zzh(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i3, i)) {
                                    zzum.zzb(i3, zzi(t, (long) (zzbr2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i3, i)) {
                                    zzum.zzb(i3, zztx.zzp(t, (long) (zzbr2 & 1048575)), zzbo(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzbdn.zza(zzum, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzbdm, t, zzum);
                }
            }
            it = null;
            entry = null;
            length = this.zzbcy.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzbdm, t, zzum);
        } else {
            zzb(t, zzum);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    private final void zzb(T t, zzum zzum) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        int i3;
        if (this.zzbdd) {
            zzqt<?> zzr = this.zzbdn.zzr(t);
            if (!zzr.zzaxo.isEmpty()) {
                it = zzr.iterator();
                entry = it.next();
                int i4 = -1;
                length = this.zzbcy.length;
                Unsafe unsafe = zzbcx;
                int i5 = 0;
                for (i = 0; i < length; i = i2 + 3) {
                    int zzbr = zzbr(i);
                    int[] iArr = this.zzbcy;
                    int i6 = iArr[i];
                    int i7 = (267386880 & zzbr) >>> 20;
                    if (this.zzbdf || i7 > 17) {
                        i2 = i;
                        i3 = 0;
                    } else {
                        int i8 = iArr[i + 2];
                        int i9 = i8 & 1048575;
                        i2 = i;
                        if (i9 != i4) {
                            i5 = unsafe.getInt(t, (long) i9);
                            i4 = i9;
                        }
                        i3 = 1 << (i8 >>> 20);
                    }
                    while (entry != null && this.zzbdn.zzb(entry) <= i6) {
                        this.zzbdn.zza(zzum, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzbr & 1048575);
                    switch (i7) {
                        case 0:
                            if ((i3 & i5) != 0) {
                                zzum.zza(i6, zztx.zzo(t, j));
                                continue;
                            }
                        case 1:
                            if ((i3 & i5) != 0) {
                                zzum.zza(i6, zztx.zzn(t, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i3 & i5) != 0) {
                                zzum.zzi(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i3 & i5) != 0) {
                                zzum.zza(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i3 & i5) != 0) {
                                zzum.zze(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i3 & i5) != 0) {
                                zzum.zzc(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i3 & i5) != 0) {
                                zzum.zzh(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i3 & i5) != 0) {
                                zzum.zzb(i6, zztx.zzm(t, j));
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i3 & i5) != 0) {
                                zza(i6, unsafe.getObject(t, j), zzum);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i3 & i5) != 0) {
                                zzum.zza(i6, unsafe.getObject(t, j), zzbo(i2));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i3 & i5) != 0) {
                                zzum.zza(i6, (zzps) unsafe.getObject(t, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i3 & i5) != 0) {
                                zzum.zzf(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i3 & i5) != 0) {
                                zzum.zzp(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i3 & i5) != 0) {
                                zzum.zzo(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i3 & i5) != 0) {
                                zzum.zzj(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i3 & i5) != 0) {
                                zzum.zzg(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i3 & i5) != 0) {
                                zzum.zzb(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i3 & i5) != 0) {
                                zzum.zzb(i6, unsafe.getObject(t, j), zzbo(i2));
                            } else {
                                continue;
                            }
                        case 18:
                            zztb.zza(this.zzbcy[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzum, false);
                            continue;
                        case 19:
                            zztb.zzb(this.zzbcy[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzum, false);
                            continue;
                        case 20:
                            zztb.zzc(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 21:
                            zztb.zzd(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 22:
                            zztb.zzh(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 23:
                            zztb.zzf(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 24:
                            zztb.zzk(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 25:
                            zztb.zzn(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 26:
                            zztb.zza(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum);
                            break;
                        case 27:
                            zztb.zza(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, zzbo(i2));
                            break;
                        case 28:
                            zztb.zzb(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum);
                            break;
                        case 29:
                            zztb.zzi(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 30:
                            zztb.zzm(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 31:
                            zztb.zzl(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 32:
                            zztb.zzg(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 33:
                            zztb.zzj(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 34:
                            zztb.zze(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, false);
                            continue;
                        case 35:
                            zztb.zza(this.zzbcy[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzum, true);
                            break;
                        case 36:
                            zztb.zzb(this.zzbcy[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzum, true);
                            break;
                        case 37:
                            zztb.zzc(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 38:
                            zztb.zzd(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 39:
                            zztb.zzh(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 40:
                            zztb.zzf(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 41:
                            zztb.zzk(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 42:
                            zztb.zzn(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 43:
                            zztb.zzi(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 44:
                            zztb.zzm(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 45:
                            zztb.zzl(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 46:
                            zztb.zzg(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 47:
                            zztb.zzj(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 48:
                            zztb.zze(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, true);
                            break;
                        case 49:
                            zztb.zzb(this.zzbcy[i2], (List) unsafe.getObject(t, j), zzum, zzbo(i2));
                            break;
                        case 50:
                            zza(zzum, i6, unsafe.getObject(t, j), i2);
                            break;
                        case 51:
                            if (zza(t, i6, i2)) {
                                zzum.zza(i6, zzf(t, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zza(t, i6, i2)) {
                                zzum.zza(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zza(t, i6, i2)) {
                                zzum.zzi(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zza(t, i6, i2)) {
                                zzum.zza(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zza(t, i6, i2)) {
                                zzum.zze(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zza(t, i6, i2)) {
                                zzum.zzc(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zza(t, i6, i2)) {
                                zzum.zzh(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zza(t, i6, i2)) {
                                zzum.zzb(i6, zzj(t, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zza(t, i6, i2)) {
                                zza(i6, unsafe.getObject(t, j), zzum);
                                break;
                            }
                            break;
                        case 60:
                            if (zza(t, i6, i2)) {
                                zzum.zza(i6, unsafe.getObject(t, j), zzbo(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (zza(t, i6, i2)) {
                                zzum.zza(i6, (zzps) unsafe.getObject(t, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zza(t, i6, i2)) {
                                zzum.zzf(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zza(t, i6, i2)) {
                                zzum.zzp(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zza(t, i6, i2)) {
                                zzum.zzo(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zza(t, i6, i2)) {
                                zzum.zzj(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zza(t, i6, i2)) {
                                zzum.zzg(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zza(t, i6, i2)) {
                                zzum.zzb(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zza(t, i6, i2)) {
                                zzum.zzb(i6, unsafe.getObject(t, j), zzbo(i2));
                                break;
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zzbdn.zza(zzum, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzbdm, t, zzum);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.zzbcy.length;
        Unsafe unsafe2 = zzbcx;
        int i52 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzbdm, t, zzum);
    }

    private final <K, V> void zza(zzum zzum, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzum.zza(i, this.zzbdo.zzac(zzbp(i2)), this.zzbdo.zzy(obj));
        }
    }

    private static <UT, UB> void zza(zztr<UT, UB> zztr, T t, zzum zzum) throws IOException {
        zztr.zza(zztr.zzag(t), zzum);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zza(T r18, com.google.android.gms.internal.gtm.zzsy r19, com.google.android.gms.internal.gtm.zzqp r20) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1660
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.zza(java.lang.Object, com.google.android.gms.internal.gtm.zzsy, com.google.android.gms.internal.gtm.zzqp):void");
    }

    private final zzsz zzbo(int i) {
        int i2 = (i / 3) << 1;
        zzsz zzsz = (zzsz) this.zzbcz[i2];
        if (zzsz != null) {
            return zzsz;
        }
        zzsz<T> zzi = zzsw.zzqs().zzi((Class) this.zzbcz[i2 + 1]);
        this.zzbcz[i2] = zzi;
        return zzi;
    }

    private final Object zzbp(int i) {
        return this.zzbcz[(i / 3) << 1];
    }

    private final zzrh zzbq(int i) {
        return (zzrh) this.zzbcz[((i / 3) << 1) + 1];
    }

    @Override // com.google.android.gms.internal.gtm.zzsz
    public final void zzt(T t) {
        int i;
        int i2 = this.zzbdi;
        while (true) {
            i = this.zzbdj;
            if (i2 >= i) {
                break;
            }
            long zzbr = (long) (zzbr(this.zzbdh[i2]) & 1048575);
            Object zzp = zztx.zzp(t, zzbr);
            if (zzp != null) {
                zztx.zza(t, zzbr, this.zzbdo.zzaa(zzp));
            }
            i2++;
        }
        int length = this.zzbdh.length;
        while (i < length) {
            this.zzbdl.zzb(t, (long) this.zzbdh[i]);
            i++;
        }
        this.zzbdm.zzt(t);
        if (this.zzbdd) {
            this.zzbdn.zzt(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zztr<UT, UB> zztr) {
        zzrh zzbq;
        int i2 = this.zzbcy[i];
        Object zzp = zztx.zzp(obj, (long) (zzbr(i) & 1048575));
        return (zzp == null || (zzbq = zzbq(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzbdo.zzx(zzp), zzbq, ub, zztr);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzrh zzrh, UB ub, zztr<UT, UB> zztr) {
        zzsd<?, ?> zzac = this.zzbdo.zzac(zzbp(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzrh.zzb(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zztr.zzri();
                }
                zzqa zzam = zzps.zzam(zzsc.zza(zzac, next.getKey(), next.getValue()));
                try {
                    zzsc.zza(zzam.zznh(), zzac, next.getKey(), next.getValue());
                    zztr.zza(ub, i2, zzam.zzng());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.gtm.zzsz] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.gtm.zzsz] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.gtm.zzsz
    public final boolean zzae(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzbdi) {
                return !this.zzbdd || this.zzbdn.zzr(t).isInitialized();
            }
            int i5 = this.zzbdh[i3];
            int i6 = this.zzbcy[i5];
            int zzbr = zzbr(i5);
            if (!this.zzbdf) {
                int i7 = this.zzbcy[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzbcx.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzbr) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzbr) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzbr, zzbo(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzy = this.zzbdo.zzy(zztx.zzp(t, (long) (zzbr & 1048575)));
                            if (!zzy.isEmpty()) {
                                if (this.zzbdo.zzac(zzbp(i5)).zzbcr.zzrs() == zzul.MESSAGE) {
                                    zzsz<T> zzsz = 0;
                                    Iterator<?> it = zzy.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzsz == null) {
                                            zzsz = zzsw.zzqs().zzi(next.getClass());
                                        }
                                        boolean zzae = zzsz.zzae(next);
                                        zzsz = zzsz;
                                        if (!zzae) {
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
                List list = (List) zztx.zzp(t, (long) (zzbr & 1048575));
                if (!list.isEmpty()) {
                    ?? zzbo = zzbo(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzbo.zzae(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza(t, zzbr, zzbo(i5))) {
                return false;
            }
            i3++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.gtm.zzsz */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzsz zzsz) {
        return zzsz.zzae(zztx.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzum zzum) throws IOException {
        if (obj instanceof String) {
            zzum.zza(i, (String) obj);
        } else {
            zzum.zza(i, (zzps) obj);
        }
    }

    private final void zza(Object obj, int i, zzsy zzsy) throws IOException {
        if (zzbt(i)) {
            zztx.zza(obj, (long) (i & 1048575), zzsy.zznp());
        } else if (this.zzbde) {
            zztx.zza(obj, (long) (i & 1048575), zzsy.readString());
        } else {
            zztx.zza(obj, (long) (i & 1048575), zzsy.zznq());
        }
    }

    private final int zzbr(int i) {
        return this.zzbcy[i + 1];
    }

    private final int zzbs(int i) {
        return this.zzbcy[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zztx.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zztx.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zztx.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zztx.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zztx.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zzb(t, i) == zzb(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzbdf) {
            return zzb(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zzb(T t, int i) {
        if (this.zzbdf) {
            int zzbr = zzbr(i);
            long j = (long) (zzbr & 1048575);
            switch ((zzbr & 267386880) >>> 20) {
                case 0:
                    return zztx.zzo(t, j) != 0.0d;
                case 1:
                    return zztx.zzn(t, j) != 0.0f;
                case 2:
                    return zztx.zzl(t, j) != 0;
                case 3:
                    return zztx.zzl(t, j) != 0;
                case 4:
                    return zztx.zzk(t, j) != 0;
                case 5:
                    return zztx.zzl(t, j) != 0;
                case 6:
                    return zztx.zzk(t, j) != 0;
                case 7:
                    return zztx.zzm(t, j);
                case 8:
                    Object zzp = zztx.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzps) {
                        return !zzps.zzavx.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zztx.zzp(t, j) != null;
                case 10:
                    return !zzps.zzavx.equals(zztx.zzp(t, j));
                case 11:
                    return zztx.zzk(t, j) != 0;
                case 12:
                    return zztx.zzk(t, j) != 0;
                case 13:
                    return zztx.zzk(t, j) != 0;
                case 14:
                    return zztx.zzl(t, j) != 0;
                case 15:
                    return zztx.zzk(t, j) != 0;
                case 16:
                    return zztx.zzl(t, j) != 0;
                case 17:
                    return zztx.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbs = zzbs(i);
            return (zztx.zzk(t, (long) (zzbs & 1048575)) & (1 << (zzbs >>> 20))) != 0;
        }
    }

    private final void zzc(T t, int i) {
        if (!this.zzbdf) {
            int zzbs = zzbs(i);
            long j = (long) (zzbs & 1048575);
            zztx.zzb(t, j, zztx.zzk(t, j) | (1 << (zzbs >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zztx.zzk(t, (long) (zzbs(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zztx.zzb(t, (long) (zzbs(i2) & 1048575), i);
    }
}
