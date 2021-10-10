package com.google.android.gms.internal.instantapps;

import android.util.EventLogTags;
import com.google.android.gms.internal.instantapps.zzcx;
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
public final class zzej<T> implements zzeu<T> {
    private static final int[] zzarl = new int[0];
    private static final Unsafe zzarm = zzfs.zzef();
    private final int[] zzarn;
    private final Object[] zzaro;
    private final int zzarp;
    private final int zzarq;
    private final zzef zzarr;
    private final boolean zzars;
    private final boolean zzart;
    private final boolean zzaru;
    private final boolean zzarv;
    private final int[] zzarw;
    private final int zzarx;
    private final int zzary;
    private final zzen zzarz;
    private final zzdp zzasa;
    private final zzfm<?, ?> zzasb;
    private final zzcm<?> zzasc;
    private final zzdy zzasd;

    private zzej(int[] iArr, Object[] objArr, int i, int i2, zzef zzef, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzen zzen, zzdp zzdp, zzfm<?, ?> zzfm, zzcm<?> zzcm, zzdy zzdy) {
        this.zzarn = iArr;
        this.zzaro = objArr;
        this.zzarp = i;
        this.zzarq = i2;
        this.zzart = zzef instanceof zzcx;
        this.zzaru = z;
        this.zzars = zzcm != null && zzcm.zze(zzef);
        this.zzarv = false;
        this.zzarw = iArr2;
        this.zzarx = i3;
        this.zzary = i4;
        this.zzarz = zzen;
        this.zzasa = zzdp;
        this.zzasb = zzfm;
        this.zzasc = zzcm;
        this.zzarr = zzef;
        this.zzasd = zzdy;
    }

    private static boolean zzas(int i) {
        return (i & PKIFailureInfo.duplicateCertReq) != 0;
    }

    static <T> zzej<T> zza(Class<T> cls, zzed zzed, zzen zzen, zzdp zzdp, zzfm<?, ?> zzfm, zzcm<?> zzcm, zzdy zzdy) {
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
        zzes zzes;
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
        if (zzed instanceof zzes) {
            zzes zzes2 = (zzes) zzed;
            int i32 = 0;
            boolean z2 = zzes2.zzdb() == zzcx.zzd.zzapp;
            String zzdj = zzes2.zzdj();
            int length = zzdj.length();
            int charAt15 = zzdj.charAt(0);
            if (charAt15 >= 55296) {
                int i33 = charAt15 & 8191;
                int i34 = 1;
                int i35 = 13;
                while (true) {
                    i = i34 + 1;
                    charAt14 = zzdj.charAt(i34);
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
            int charAt16 = zzdj.charAt(i);
            if (charAt16 >= 55296) {
                int i37 = charAt16 & 8191;
                int i38 = 13;
                while (true) {
                    i31 = i36 + 1;
                    charAt13 = zzdj.charAt(i36);
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
                iArr = zzarl;
                i6 = 0;
            } else {
                int i39 = i36 + 1;
                int charAt17 = zzdj.charAt(i36);
                if (charAt17 >= 55296) {
                    int i40 = charAt17 & 8191;
                    int i41 = 13;
                    while (true) {
                        i30 = i39 + 1;
                        charAt12 = zzdj.charAt(i39);
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
                int charAt18 = zzdj.charAt(i39);
                if (charAt18 >= 55296) {
                    int i43 = charAt18 & 8191;
                    int i44 = 13;
                    while (true) {
                        i29 = i42 + 1;
                        charAt11 = zzdj.charAt(i42);
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
                i5 = zzdj.charAt(i42);
                if (i5 >= 55296) {
                    int i46 = i5 & 8191;
                    int i47 = 13;
                    while (true) {
                        i28 = i45 + 1;
                        charAt10 = zzdj.charAt(i45);
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
                int charAt19 = zzdj.charAt(i45);
                if (charAt19 >= 55296) {
                    int i49 = charAt19 & 8191;
                    int i50 = 13;
                    while (true) {
                        i27 = i48 + 1;
                        charAt9 = zzdj.charAt(i48);
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
                i3 = zzdj.charAt(i48);
                if (i3 >= 55296) {
                    int i52 = i3 & 8191;
                    int i53 = 13;
                    while (true) {
                        i26 = i51 + 1;
                        charAt8 = zzdj.charAt(i51);
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
                int charAt20 = zzdj.charAt(i51);
                if (charAt20 >= 55296) {
                    int i55 = charAt20 & 8191;
                    int i56 = 13;
                    while (true) {
                        i25 = i54 + 1;
                        charAt7 = zzdj.charAt(i54);
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
                int charAt21 = zzdj.charAt(i54);
                if (charAt21 >= 55296) {
                    int i58 = charAt21 & 8191;
                    int i59 = i57;
                    int i60 = 13;
                    while (true) {
                        i24 = i59 + 1;
                        charAt6 = zzdj.charAt(i59);
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
                int charAt22 = zzdj.charAt(i22);
                if (charAt22 >= 55296) {
                    int i62 = charAt22 & 8191;
                    int i63 = i61;
                    int i64 = 13;
                    while (true) {
                        i23 = i63 + 1;
                        charAt5 = zzdj.charAt(i63);
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
            Unsafe unsafe = zzarm;
            Object[] zzdk = zzes2.zzdk();
            Class<?> cls3 = zzes2.zzdd().getClass();
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
                int charAt23 = zzdj.charAt(i68);
                if (charAt23 >= 55296) {
                    int i73 = charAt23 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i21 = i74 + 1;
                        charAt4 = zzdj.charAt(i74);
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
                int charAt24 = zzdj.charAt(i9);
                if (charAt24 >= 55296) {
                    int i77 = charAt24 & 8191;
                    int i78 = i76;
                    int i79 = 13;
                    while (true) {
                        i20 = i78 + 1;
                        charAt3 = zzdj.charAt(i78);
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
                    int charAt25 = zzdj.charAt(i10);
                    char c = 55296;
                    if (charAt25 >= 55296) {
                        int i82 = charAt25 & 8191;
                        int i83 = 13;
                        while (true) {
                            i19 = i81 + 1;
                            charAt2 = zzdj.charAt(i81);
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
                        objArr[((i71 / 3) << 1) + 1] = zzdk[i4];
                        i4++;
                    } else if (i84 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i71 / 3) << 1) + 1] = zzdk[i4];
                        i4++;
                    }
                    int i85 = charAt25 << 1;
                    Object obj = zzdk[i85];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzdk[i85] = field2;
                    }
                    zzes = zzes2;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i86 = i85 + 1;
                    Object obj2 = zzdk[i86];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzdk[i86] = field3;
                    }
                    cls2 = cls3;
                    i11 = i4;
                    i10 = i81;
                    str = zzdj;
                    i12 = 0;
                    i13 = (int) unsafe.objectFieldOffset(field3);
                    i14 = objectFieldOffset;
                    i15 = i32;
                } else {
                    zzes = zzes2;
                    int i87 = i4 + 1;
                    Field zza = zza(cls3, (String) zzdk[i4]);
                    if (i80 == 9 || i80 == 17) {
                        i16 = 1;
                        objArr[((i71 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (i80 == 27 || i80 == 49) {
                            i16 = 1;
                            i18 = i87 + 1;
                            objArr[((i71 / 3) << 1) + 1] = zzdk[i87];
                        } else if (i80 == 12 || i80 == 30 || i80 == 44) {
                            i16 = 1;
                            if ((charAt15 & 1) == 1) {
                                i18 = i87 + 1;
                                objArr[((i71 / 3) << 1) + 1] = zzdk[i87];
                            }
                        } else {
                            if (i80 == 50) {
                                int i88 = i67 + 1;
                                iArr[i67] = i71;
                                int i89 = (i71 / 3) << 1;
                                int i90 = i87 + 1;
                                objArr[i89] = zzdk[i87];
                                if ((charAt24 & 2048) != 0) {
                                    i87 = i90 + 1;
                                    objArr[i89 + 1] = zzdk[i90];
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
                        str = zzdj;
                    } else if (i80 <= 17) {
                        int i91 = i10 + 1;
                        str = zzdj;
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
                        Object obj3 = zzdk[i94];
                        i11 = i87;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzdk[i94] = field;
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
                        str = zzdj;
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
                zzdj = str;
                i68 = i10;
                cls3 = cls2;
                i6 = i6;
                length = length;
                i2 = i8;
                z2 = z;
                i5 = i5;
                i4 = i11;
                zzes2 = zzes;
            }
            return new zzej<>(iArr2, objArr, i5, i6, zzes2.zzdd(), z2, false, iArr, i2, i66, zzen, zzdp, zzfm, zzcm, zzdy);
        }
        ((zzfj) zzed).zzdb();
        int i97 = zzcx.zzd.zzapp;
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

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final T newInstance() {
        return (T) this.zzarz.newInstance(this.zzarr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.instantapps.zzew.zzd(com.google.android.gms.internal.instantapps.zzfs.zzp(r10, r6), com.google.android.gms.internal.instantapps.zzfs.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzl(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzl(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.instantapps.zzew.zzd(com.google.android.gms.internal.instantapps.zzfs.zzp(r10, r6), com.google.android.gms.internal.instantapps.zzfs.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.instantapps.zzew.zzd(com.google.android.gms.internal.instantapps.zzfs.zzp(r10, r6), com.google.android.gms.internal.instantapps.zzfs.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.instantapps.zzew.zzd(com.google.android.gms.internal.instantapps.zzfs.zzp(r10, r6), com.google.android.gms.internal.instantapps.zzfs.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzm(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzl(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzk(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzl(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.instantapps.zzfs.zzl(r10, r6) == com.google.android.gms.internal.instantapps.zzfs.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.instantapps.zzfs.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.instantapps.zzfs.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.instantapps.zzfs.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.instantapps.zzfs.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.instantapps.zzew.zzd(com.google.android.gms.internal.instantapps.zzfs.zzp(r10, r6), com.google.android.gms.internal.instantapps.zzfs.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final boolean equals(T t, T t2) {
        int length = this.zzarn.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzaq = zzaq(i);
                long j = (long) (zzaq & 1048575);
                switch ((zzaq & 267386880) >>> 20) {
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
                        z = zzew.zzd(zzfs.zzp(t, j), zzfs.zzp(t2, j));
                        break;
                    case 50:
                        z = zzew.zzd(zzfs.zzp(t, j), zzfs.zzp(t2, j));
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
                        long zzar = (long) (zzar(i) & 1048575);
                        if (zzfs.zzk(t, zzar) == zzfs.zzk(t2, zzar)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 3;
            } else if (!this.zzasb.zzq(t).equals(this.zzasb.zzq(t2))) {
                return false;
            } else {
                if (this.zzars) {
                    return this.zzasc.zza((Object) t).equals(this.zzasc.zza((Object) t2));
                }
                return true;
            }
        }
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzarn.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzaq = zzaq(i4);
            int i5 = this.zzarn[i4];
            long j = (long) (1048575 & zzaq);
            int i6 = 37;
            switch ((zzaq & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzcy.zzm(Double.doubleToLongBits(zzfs.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzfs.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzcy.zzm(zzfs.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzcy.zzm(zzfs.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzcy.zzm(zzfs.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzcy.zzc(zzfs.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzfs.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zzfs.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzfs.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzcy.zzm(zzfs.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzfs.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzcy.zzm(zzfs.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zzfs.zzp(t, j);
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
                    i = zzfs.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzfs.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzcy.zzm(Double.doubleToLongBits(zzf(t, j)));
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
                        i = zzcy.zzm(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzcy.zzm(zzi(t, j));
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
                        i = zzcy.zzm(zzi(t, j));
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
                        i = zzcy.zzc(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = ((String) zzfs.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzfs.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzfs.zzp(t, j).hashCode();
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
                        i = zzcy.zzm(zzi(t, j));
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
                        i = zzcy.zzm(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        i = zzfs.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzasb.zzq(t).hashCode();
        return this.zzars ? (hashCode * 53) + this.zzasc.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zzc(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzarn.length; i += 3) {
            int zzaq = zzaq(i);
            long j = (long) (1048575 & zzaq);
            int i2 = this.zzarn[i];
            switch ((zzaq & 267386880) >>> 20) {
                case 0:
                    if (zza(t2, i)) {
                        zzfs.zza(t, j, zzfs.zzo(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzn(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzl(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzl(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzl(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zza(t2, i)) {
                        zzfs.zza(t, j, zzfs.zzm(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zza(t2, i)) {
                        zzfs.zza(t, j, zzfs.zzp(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (zza(t2, i)) {
                        zzfs.zza(t, j, zzfs.zzp(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzl(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zza(t2, i)) {
                        zzfs.zzb(t, j, zzfs.zzk(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zza(t2, i)) {
                        zzfs.zza((Object) t, j, zzfs.zzl(t2, j));
                        zzb(t, i);
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
                    this.zzasa.zza(t, t2, j);
                    break;
                case 50:
                    zzew.zza(this.zzasd, t, t2, j);
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
                        zzfs.zza(t, j, zzfs.zzp(t2, j));
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
                        zzfs.zza(t, j, zzfs.zzp(t2, j));
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
        if (!this.zzaru) {
            zzew.zza(this.zzasb, t, t2);
            if (this.zzars) {
                zzew.zza(this.zzasc, t, t2);
            }
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzaq = (long) (zzaq(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzfs.zzp(t, zzaq);
            Object zzp2 = zzfs.zzp(t2, zzaq);
            if (zzp != null && zzp2 != null) {
                zzfs.zza(t, zzaq, zzcy.zza(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzfs.zza(t, zzaq, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzaq = zzaq(i);
        int i2 = this.zzarn[i];
        long j = (long) (zzaq & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzfs.zzp(t, j);
            Object zzp2 = zzfs.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzfs.zza(t, j, zzcy.zza(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzfs.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final int zzm(T t) {
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
        if (this.zzaru) {
            Unsafe unsafe = zzarm;
            int i17 = 0;
            int i18 = 0;
            while (i17 < this.zzarn.length) {
                int zzaq = zzaq(i17);
                int i19 = (zzaq & i14) >>> 20;
                int i20 = this.zzarn[i17];
                long j2 = (long) (zzaq & 1048575);
                int i21 = (i19 < zzcr.DOUBLE_LIST_PACKED.id() || i19 > zzcr.SINT64_LIST_PACKED.id()) ? 0 : this.zzarn[i17 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 1:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 2:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzd(i20, zzfs.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 3:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zze(i20, zzfs.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 4:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzg(i20, zzfs.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 5:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 6:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 7:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzc(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 8:
                        if (zza(t, i17)) {
                            Object zzp = zzfs.zzp(t, j2);
                            if (zzp instanceof zzbp) {
                                zzb2 = zzce.zzc(i20, (zzbp) zzp);
                                break;
                            } else {
                                zzb2 = zzce.zzb(i20, (String) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 9:
                        if (zza(t, i17)) {
                            zzb2 = zzew.zzc(i20, zzfs.zzp(t, j2), zzan(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 10:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzc(i20, (zzbp) zzfs.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 11:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzh(i20, zzfs.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 12:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzl(i20, zzfs.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 13:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzk(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 14:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 15:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzi(i20, zzfs.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 16:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzf(i20, zzfs.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 17:
                        if (zza(t, i17)) {
                            zzb2 = zzce.zzc(i20, (zzef) zzfs.zzp(t, j2), zzan(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 18:
                        zzb2 = zzew.zzw(i20, zze(t, j2), false);
                        break;
                    case 19:
                        zzb2 = zzew.zzv(i20, zze(t, j2), false);
                        break;
                    case 20:
                        zzb2 = zzew.zzo(i20, zze(t, j2), false);
                        break;
                    case 21:
                        zzb2 = zzew.zzp(i20, zze(t, j2), false);
                        break;
                    case 22:
                        zzb2 = zzew.zzs(i20, zze(t, j2), false);
                        break;
                    case 23:
                        zzb2 = zzew.zzw(i20, zze(t, j2), false);
                        break;
                    case 24:
                        zzb2 = zzew.zzv(i20, zze(t, j2), false);
                        break;
                    case 25:
                        zzb2 = zzew.zzx(i20, zze(t, j2), false);
                        break;
                    case 26:
                        zzb2 = zzew.zzc(i20, zze(t, j2));
                        break;
                    case 27:
                        zzb2 = zzew.zzc(i20, zze(t, j2), zzan(i17));
                        break;
                    case 28:
                        zzb2 = zzew.zzd(i20, (List<zzbp>) zze(t, j2));
                        break;
                    case 29:
                        zzb2 = zzew.zzt(i20, zze(t, j2), false);
                        break;
                    case 30:
                        zzb2 = zzew.zzr(i20, zze(t, j2), false);
                        break;
                    case 31:
                        zzb2 = zzew.zzv(i20, zze(t, j2), false);
                        break;
                    case 32:
                        zzb2 = zzew.zzw(i20, zze(t, j2), false);
                        break;
                    case 33:
                        zzb2 = zzew.zzu(i20, zze(t, j2), false);
                        break;
                    case 34:
                        zzb2 = zzew.zzq(i20, zze(t, j2), false);
                        break;
                    case 35:
                        i12 = zzew.zzy((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 36:
                        i12 = zzew.zzx((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 37:
                        i12 = zzew.zzq((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 38:
                        i12 = zzew.zzr((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 39:
                        i12 = zzew.zzu((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 40:
                        i12 = zzew.zzy((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 41:
                        i12 = zzew.zzx((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 42:
                        i12 = zzew.zzz((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 43:
                        i12 = zzew.zzv((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 44:
                        i12 = zzew.zzt((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 45:
                        i12 = zzew.zzx((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 46:
                        i12 = zzew.zzy((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 47:
                        i12 = zzew.zzw((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 48:
                        i12 = zzew.zzs((List) unsafe.getObject(t, j2));
                        if (i12 > 0) {
                            if (this.zzarv) {
                                unsafe.putInt(t, (long) i21, i12);
                            }
                            i13 = zzce.zzaa(i20);
                            i11 = zzce.zzac(i12);
                            zzb2 = i13 + i11 + i12;
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 49:
                        zzb2 = zzew.zzd(i20, zze(t, j2), zzan(i17));
                        break;
                    case 50:
                        zzb2 = this.zzasd.zzb(i20, zzfs.zzp(t, j2), zzao(i17));
                        break;
                    case 51:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzb(i20, 0.0d);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 52:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzb(i20, 0.0f);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 53:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzd(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 54:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zze(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 55:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzg(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 56:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzg(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 57:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzj(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 58:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzc(i20, true);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 59:
                        if (zza(t, i20, i17)) {
                            Object zzp2 = zzfs.zzp(t, j2);
                            if (zzp2 instanceof zzbp) {
                                zzb2 = zzce.zzc(i20, (zzbp) zzp2);
                                break;
                            } else {
                                zzb2 = zzce.zzb(i20, (String) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 60:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzew.zzc(i20, zzfs.zzp(t, j2), zzan(i17));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 61:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzc(i20, (zzbp) zzfs.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 62:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzh(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 63:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzl(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 64:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzk(i20, 0);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 65:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzh(i20, 0L);
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 66:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzi(i20, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 67:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzf(i20, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i17 += 3;
                            i14 = 267386880;
                        }
                    case 68:
                        if (zza(t, i20, i17)) {
                            zzb2 = zzce.zzc(i20, (zzef) zzfs.zzp(t, j2), zzan(i17));
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
            return i18 + zza((zzfm) this.zzasb, (Object) t);
        }
        Unsafe unsafe2 = zzarm;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.zzarn.length) {
            int zzaq2 = zzaq(i23);
            int[] iArr = this.zzarn;
            int i26 = iArr[i23];
            int i27 = (zzaq2 & 267386880) >>> 20;
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
                i2 = (!this.zzarv || i27 < zzcr.DOUBLE_LIST_PACKED.id() || i27 > zzcr.SINT64_LIST_PACKED.id()) ? 0 : this.zzarn[i23 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzaq2 & 1048575);
            switch (i27) {
                case 0:
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i24 += zzce.zzb(i26, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        z = false;
                        i24 += zzce.zzb(i26, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzce.zzd(i26, unsafe2.getLong(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 3:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzce.zze(i26, unsafe2.getLong(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 4:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzce.zzg(i26, unsafe2.getInt(t, j3));
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 5:
                    i4 = 1;
                    i3 = 0;
                    j = 0;
                    if ((i25 & i) != 0) {
                        i5 = zzce.zzg(i26, 0L);
                        i24 += i5;
                    }
                    z = false;
                    break;
                case 6:
                    i4 = 1;
                    if ((i25 & i) != 0) {
                        i3 = 0;
                        i24 += zzce.zzj(i26, 0);
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
                        i24 += zzce.zzc(i26, true);
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
                        if (object instanceof zzbp) {
                            zzb = zzce.zzc(i26, (zzbp) object);
                        } else {
                            zzb = zzce.zzb(i26, (String) object);
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
                        zzb = zzew.zzc(i26, unsafe2.getObject(t, j3), zzan(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 10:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzc(i26, (zzbp) unsafe2.getObject(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 11:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzh(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzl(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    if ((i25 & i) != 0) {
                        i6 = zzce.zzk(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 14:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 15:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzi(i26, unsafe2.getInt(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzf(i26, unsafe2.getLong(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    if ((i25 & i) != 0) {
                        zzb = zzce.zzc(i26, (zzef) unsafe2.getObject(t, j3), zzan(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 18:
                    zzb = zzew.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 19:
                    i3 = 0;
                    i7 = zzew.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    i3 = 0;
                    i7 = zzew.zzo(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    i3 = 0;
                    i7 = zzew.zzp(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    i3 = 0;
                    i7 = zzew.zzs(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 23:
                    i3 = 0;
                    i7 = zzew.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 24:
                    i3 = 0;
                    i7 = zzew.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    i3 = 0;
                    i7 = zzew.zzx(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzb = zzew.zzc(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzb = zzew.zzc(i26, (List<?>) ((List) unsafe2.getObject(t, j3)), zzan(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzb = zzew.zzd(i26, (List) unsafe2.getObject(t, j3));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzb = zzew.zzt(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    i3 = 0;
                    i7 = zzew.zzr(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 31:
                    i3 = 0;
                    i7 = zzew.zzv(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 32:
                    i3 = 0;
                    i7 = zzew.zzw(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    i3 = 0;
                    i7 = zzew.zzu(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    i3 = 0;
                    i7 = zzew.zzq(i26, (List) unsafe2.getObject(t, j3), false);
                    i24 += i7;
                    i4 = 1;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i10 = zzew.zzy((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i10 = zzew.zzx((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i10 = zzew.zzq((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i10 = zzew.zzr((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i10 = zzew.zzu((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i10 = zzew.zzy((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i10 = zzew.zzx((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i10 = zzew.zzz((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i10 = zzew.zzv((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i10 = zzew.zzt((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i10 = zzew.zzx((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i10 = zzew.zzy((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i10 = zzew.zzw((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i10 = zzew.zzs((List) unsafe2.getObject(t, j3));
                    if (i10 > 0) {
                        if (this.zzarv) {
                            unsafe2.putInt(t, (long) i2, i10);
                        }
                        i9 = zzce.zzaa(i26);
                        i8 = zzce.zzac(i10);
                        i6 = i9 + i8 + i10;
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzb = zzew.zzd(i26, (List) unsafe2.getObject(t, j3), zzan(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzb = this.zzasd.zzb(i26, unsafe2.getObject(t, j3), zzao(i23));
                    i24 += zzb;
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzb(i26, 0.0d);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t, i26, i23)) {
                        i6 = zzce.zzb(i26, 0.0f);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzd(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zze(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzg(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzg(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t, i26, i23)) {
                        i6 = zzce.zzj(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    if (zza(t, i26, i23)) {
                        i6 = zzce.zzc(i26, true);
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
                        if (object2 instanceof zzbp) {
                            zzb = zzce.zzc(i26, (zzbp) object2);
                        } else {
                            zzb = zzce.zzb(i26, (String) object2);
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
                        zzb = zzew.zzc(i26, unsafe2.getObject(t, j3), zzan(i23));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 61:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzc(i26, (zzbp) unsafe2.getObject(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 62:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzh(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzl(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    if (zza(t, i26, i23)) {
                        i6 = zzce.zzk(i26, 0);
                        i24 += i6;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 65:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzh(i26, 0L);
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 66:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzi(i26, zzh(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzf(i26, zzi(t, j3));
                        i24 += zzb;
                    }
                    i4 = 1;
                    i3 = 0;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    if (zza(t, i26, i23)) {
                        zzb = zzce.zzc(i26, (zzef) unsafe2.getObject(t, j3), zzan(i23));
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
        int zza = i24 + zza((zzfm) this.zzasb, (Object) t);
        if (!this.zzars) {
            return zza;
        }
        zzcq<?> zza2 = this.zzasc.zza((Object) t);
        for (int i31 = i30; i31 < zza2.zzame.zzdr(); i31++) {
            Map.Entry<FieldDescriptorType, Object> zzav = zza2.zzame.zzav(i31);
            i30 += zzcq.zzb((zzcs<?>) zzav.getKey(), zzav.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zza2.zzame.zzds()) {
            i30 += zzcq.zzb((zzcs<?>) entry.getKey(), entry.getValue());
        }
        return zza + i30;
    }

    private static <UT, UB> int zza(zzfm<UT, UB> zzfm, T t) {
        return zzfm.zzm(zzfm.zzq(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzfs.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T t, zzgi zzgi) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        if (zzgi.zzbd() == zzcx.zzd.zzaps) {
            zza(this.zzasb, t, zzgi);
            if (this.zzars) {
                zzcq<?> zza = this.zzasc.zza((Object) t);
                if (!zza.zzame.isEmpty()) {
                    it2 = zza.descendingIterator();
                    entry2 = it2.next();
                    for (length2 = this.zzarn.length - 3; length2 >= 0; length2 -= 3) {
                        int zzaq = zzaq(length2);
                        int i2 = this.zzarn[length2];
                        while (entry2 != null && this.zzasc.zza(entry2) > i2) {
                            this.zzasc.zza(zzgi, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzaq & 267386880) >>> 20) {
                            case 0:
                                if (zza(t, length2)) {
                                    zzgi.zza(i2, zzfs.zzo(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza(t, length2)) {
                                    zzgi.zza(i2, zzfs.zzn(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza(t, length2)) {
                                    zzgi.zzi(i2, zzfs.zzl(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza(t, length2)) {
                                    zzgi.zza(i2, zzfs.zzl(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza(t, length2)) {
                                    zzgi.zzc(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza(t, length2)) {
                                    zzgi.zzc(i2, zzfs.zzl(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza(t, length2)) {
                                    zzgi.zzf(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza(t, length2)) {
                                    zzgi.zzb(i2, zzfs.zzm(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza(t, length2)) {
                                    zza(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza(t, length2)) {
                                    zzgi.zza(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzan(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza(t, length2)) {
                                    zzgi.zza(i2, (zzbp) zzfs.zzp(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza(t, length2)) {
                                    zzgi.zzd(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza(t, length2)) {
                                    zzgi.zzn(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza(t, length2)) {
                                    zzgi.zzm(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza(t, length2)) {
                                    zzgi.zzj(i2, zzfs.zzl(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza(t, length2)) {
                                    zzgi.zze(i2, zzfs.zzk(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza(t, length2)) {
                                    zzgi.zzb(i2, zzfs.zzl(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza(t, length2)) {
                                    zzgi.zzb(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzan(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzew.zza(this.zzarn[length2], (List<Double>) ((List) zzfs.zzp(t, (long) (zzaq & 1048575))), zzgi, false);
                                break;
                            case 19:
                                zzew.zzb(this.zzarn[length2], (List<Float>) ((List) zzfs.zzp(t, (long) (zzaq & 1048575))), zzgi, false);
                                break;
                            case 20:
                                zzew.zzc(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 21:
                                zzew.zzd(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 22:
                                zzew.zzh(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 23:
                                zzew.zzf(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 24:
                                zzew.zzk(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 25:
                                zzew.zzn(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 26:
                                zzew.zza(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi);
                                break;
                            case 27:
                                zzew.zza(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, zzan(length2));
                                break;
                            case 28:
                                zzew.zzb(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi);
                                break;
                            case 29:
                                zzew.zzi(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 30:
                                zzew.zzm(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 31:
                                zzew.zzl(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 32:
                                zzew.zzg(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 33:
                                zzew.zzj(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 34:
                                zzew.zze(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, false);
                                break;
                            case 35:
                                zzew.zza(this.zzarn[length2], (List<Double>) ((List) zzfs.zzp(t, (long) (zzaq & 1048575))), zzgi, true);
                                break;
                            case 36:
                                zzew.zzb(this.zzarn[length2], (List<Float>) ((List) zzfs.zzp(t, (long) (zzaq & 1048575))), zzgi, true);
                                break;
                            case 37:
                                zzew.zzc(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 38:
                                zzew.zzd(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 39:
                                zzew.zzh(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 40:
                                zzew.zzf(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 41:
                                zzew.zzk(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 42:
                                zzew.zzn(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 43:
                                zzew.zzi(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 44:
                                zzew.zzm(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 45:
                                zzew.zzl(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 46:
                                zzew.zzg(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 47:
                                zzew.zzj(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 48:
                                zzew.zze(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, true);
                                break;
                            case 49:
                                zzew.zzb(this.zzarn[length2], (List) zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi, zzan(length2));
                                break;
                            case 50:
                                zza(zzgi, i2, zzfs.zzp(t, (long) (zzaq & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i2, length2)) {
                                    zzgi.zza(i2, zzf(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i2, length2)) {
                                    zzgi.zza(i2, zzg(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzi(i2, zzi(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i2, length2)) {
                                    zzgi.zza(i2, zzi(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzc(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzc(i2, zzi(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzf(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzb(i2, zzj(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i2, length2)) {
                                    zza(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzgi);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i2, length2)) {
                                    zzgi.zza(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzan(length2));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i2, length2)) {
                                    zzgi.zza(i2, (zzbp) zzfs.zzp(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzd(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzn(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzm(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzj(i2, zzi(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i2, length2)) {
                                    zzgi.zze(i2, zzh(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzb(i2, zzi(t, (long) (zzaq & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i2, length2)) {
                                    zzgi.zzb(i2, zzfs.zzp(t, (long) (zzaq & 1048575)), zzan(length2));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry2 != null) {
                        this.zzasc.zza(zzgi, entry2);
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
        } else if (this.zzaru) {
            if (this.zzars) {
                zzcq<?> zza2 = this.zzasc.zza((Object) t);
                if (!zza2.zzame.isEmpty()) {
                    it = zza2.iterator();
                    entry = it.next();
                    length = this.zzarn.length;
                    for (i = 0; i < length; i += 3) {
                        int zzaq2 = zzaq(i);
                        int i3 = this.zzarn[i];
                        while (entry != null && this.zzasc.zza(entry) <= i3) {
                            this.zzasc.zza(zzgi, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzaq2 & 267386880) >>> 20) {
                            case 0:
                                if (zza(t, i)) {
                                    zzgi.zza(i3, zzfs.zzo(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza(t, i)) {
                                    zzgi.zza(i3, zzfs.zzn(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza(t, i)) {
                                    zzgi.zzi(i3, zzfs.zzl(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza(t, i)) {
                                    zzgi.zza(i3, zzfs.zzl(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza(t, i)) {
                                    zzgi.zzc(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza(t, i)) {
                                    zzgi.zzc(i3, zzfs.zzl(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza(t, i)) {
                                    zzgi.zzf(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza(t, i)) {
                                    zzgi.zzb(i3, zzfs.zzm(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (zza(t, i)) {
                                    zza(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if (zza(t, i)) {
                                    zzgi.zza(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzan(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if (zza(t, i)) {
                                    zzgi.zza(i3, (zzbp) zzfs.zzp(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if (zza(t, i)) {
                                    zzgi.zzd(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza(t, i)) {
                                    zzgi.zzn(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza(t, i)) {
                                    zzgi.zzm(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza(t, i)) {
                                    zzgi.zzj(i3, zzfs.zzl(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza(t, i)) {
                                    zzgi.zze(i3, zzfs.zzk(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza(t, i)) {
                                    zzgi.zzb(i3, zzfs.zzl(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (zza(t, i)) {
                                    zzgi.zzb(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzan(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                zzew.zza(this.zzarn[i], (List<Double>) ((List) zzfs.zzp(t, (long) (zzaq2 & 1048575))), zzgi, false);
                                break;
                            case 19:
                                zzew.zzb(this.zzarn[i], (List<Float>) ((List) zzfs.zzp(t, (long) (zzaq2 & 1048575))), zzgi, false);
                                break;
                            case 20:
                                zzew.zzc(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 21:
                                zzew.zzd(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 22:
                                zzew.zzh(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 23:
                                zzew.zzf(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 24:
                                zzew.zzk(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 25:
                                zzew.zzn(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 26:
                                zzew.zza(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi);
                                break;
                            case 27:
                                zzew.zza(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, zzan(i));
                                break;
                            case 28:
                                zzew.zzb(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi);
                                break;
                            case 29:
                                zzew.zzi(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 30:
                                zzew.zzm(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 31:
                                zzew.zzl(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 32:
                                zzew.zzg(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 33:
                                zzew.zzj(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 34:
                                zzew.zze(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, false);
                                break;
                            case 35:
                                zzew.zza(this.zzarn[i], (List<Double>) ((List) zzfs.zzp(t, (long) (zzaq2 & 1048575))), zzgi, true);
                                break;
                            case 36:
                                zzew.zzb(this.zzarn[i], (List<Float>) ((List) zzfs.zzp(t, (long) (zzaq2 & 1048575))), zzgi, true);
                                break;
                            case 37:
                                zzew.zzc(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 38:
                                zzew.zzd(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 39:
                                zzew.zzh(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 40:
                                zzew.zzf(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 41:
                                zzew.zzk(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 42:
                                zzew.zzn(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 43:
                                zzew.zzi(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 44:
                                zzew.zzm(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 45:
                                zzew.zzl(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 46:
                                zzew.zzg(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 47:
                                zzew.zzj(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 48:
                                zzew.zze(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, true);
                                break;
                            case 49:
                                zzew.zzb(this.zzarn[i], (List) zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi, zzan(i));
                                break;
                            case 50:
                                zza(zzgi, i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i3, i)) {
                                    zzgi.zza(i3, zzf(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i3, i)) {
                                    zzgi.zza(i3, zzg(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i3, i)) {
                                    zzgi.zzi(i3, zzi(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i3, i)) {
                                    zzgi.zza(i3, zzi(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i3, i)) {
                                    zzgi.zzc(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i3, i)) {
                                    zzgi.zzc(i3, zzi(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i3, i)) {
                                    zzgi.zzf(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i3, i)) {
                                    zzgi.zzb(i3, zzj(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (zza(t, i3, i)) {
                                    zza(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzgi);
                                    break;
                                } else {
                                    break;
                                }
                            case 60:
                                if (zza(t, i3, i)) {
                                    zzgi.zza(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzan(i));
                                    break;
                                } else {
                                    break;
                                }
                            case 61:
                                if (zza(t, i3, i)) {
                                    zzgi.zza(i3, (zzbp) zzfs.zzp(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 62:
                                if (zza(t, i3, i)) {
                                    zzgi.zzd(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i3, i)) {
                                    zzgi.zzn(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i3, i)) {
                                    zzgi.zzm(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i3, i)) {
                                    zzgi.zzj(i3, zzi(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i3, i)) {
                                    zzgi.zze(i3, zzh(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i3, i)) {
                                    zzgi.zzb(i3, zzi(t, (long) (zzaq2 & 1048575)));
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (zza(t, i3, i)) {
                                    zzgi.zzb(i3, zzfs.zzp(t, (long) (zzaq2 & 1048575)), zzan(i));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    while (entry != null) {
                        this.zzasc.zza(zzgi, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzasb, t, zzgi);
                }
            }
            it = null;
            entry = null;
            length = this.zzarn.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzasb, t, zzgi);
        } else {
            zzb(t, zzgi);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0496  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    private final void zzb(T t, zzgi zzgi) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        int i3;
        if (this.zzars) {
            zzcq<?> zza = this.zzasc.zza((Object) t);
            if (!zza.zzame.isEmpty()) {
                it = zza.iterator();
                entry = it.next();
                int i4 = -1;
                length = this.zzarn.length;
                Unsafe unsafe = zzarm;
                int i5 = 0;
                for (i = 0; i < length; i = i2 + 3) {
                    int zzaq = zzaq(i);
                    int[] iArr = this.zzarn;
                    int i6 = iArr[i];
                    int i7 = (267386880 & zzaq) >>> 20;
                    if (this.zzaru || i7 > 17) {
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
                    while (entry != null && this.zzasc.zza(entry) <= i6) {
                        this.zzasc.zza(zzgi, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzaq & 1048575);
                    switch (i7) {
                        case 0:
                            if ((i3 & i5) != 0) {
                                zzgi.zza(i6, zzfs.zzo(t, j));
                                continue;
                            }
                        case 1:
                            if ((i3 & i5) != 0) {
                                zzgi.zza(i6, zzfs.zzn(t, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i3 & i5) != 0) {
                                zzgi.zzi(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i3 & i5) != 0) {
                                zzgi.zza(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i3 & i5) != 0) {
                                zzgi.zzc(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i3 & i5) != 0) {
                                zzgi.zzc(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i3 & i5) != 0) {
                                zzgi.zzf(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i3 & i5) != 0) {
                                zzgi.zzb(i6, zzfs.zzm(t, j));
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i3 & i5) != 0) {
                                zza(i6, unsafe.getObject(t, j), zzgi);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i3 & i5) != 0) {
                                zzgi.zza(i6, unsafe.getObject(t, j), zzan(i2));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i3 & i5) != 0) {
                                zzgi.zza(i6, (zzbp) unsafe.getObject(t, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i3 & i5) != 0) {
                                zzgi.zzd(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i3 & i5) != 0) {
                                zzgi.zzn(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i3 & i5) != 0) {
                                zzgi.zzm(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i3 & i5) != 0) {
                                zzgi.zzj(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i3 & i5) != 0) {
                                zzgi.zze(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i3 & i5) != 0) {
                                zzgi.zzb(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i3 & i5) != 0) {
                                zzgi.zzb(i6, unsafe.getObject(t, j), zzan(i2));
                            } else {
                                continue;
                            }
                        case 18:
                            zzew.zza(this.zzarn[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzgi, false);
                            continue;
                        case 19:
                            zzew.zzb(this.zzarn[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzgi, false);
                            continue;
                        case 20:
                            zzew.zzc(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 21:
                            zzew.zzd(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 22:
                            zzew.zzh(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 23:
                            zzew.zzf(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 24:
                            zzew.zzk(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 25:
                            zzew.zzn(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 26:
                            zzew.zza(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi);
                            break;
                        case 27:
                            zzew.zza(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, zzan(i2));
                            break;
                        case 28:
                            zzew.zzb(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi);
                            break;
                        case 29:
                            zzew.zzi(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 30:
                            zzew.zzm(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 31:
                            zzew.zzl(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 32:
                            zzew.zzg(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 33:
                            zzew.zzj(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 34:
                            zzew.zze(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, false);
                            continue;
                        case 35:
                            zzew.zza(this.zzarn[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzgi, true);
                            break;
                        case 36:
                            zzew.zzb(this.zzarn[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzgi, true);
                            break;
                        case 37:
                            zzew.zzc(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 38:
                            zzew.zzd(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 39:
                            zzew.zzh(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 40:
                            zzew.zzf(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 41:
                            zzew.zzk(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 42:
                            zzew.zzn(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 43:
                            zzew.zzi(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 44:
                            zzew.zzm(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 45:
                            zzew.zzl(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 46:
                            zzew.zzg(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 47:
                            zzew.zzj(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 48:
                            zzew.zze(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, true);
                            break;
                        case 49:
                            zzew.zzb(this.zzarn[i2], (List) unsafe.getObject(t, j), zzgi, zzan(i2));
                            break;
                        case 50:
                            zza(zzgi, i6, unsafe.getObject(t, j), i2);
                            break;
                        case 51:
                            if (zza(t, i6, i2)) {
                                zzgi.zza(i6, zzf(t, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zza(t, i6, i2)) {
                                zzgi.zza(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zza(t, i6, i2)) {
                                zzgi.zzi(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zza(t, i6, i2)) {
                                zzgi.zza(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zza(t, i6, i2)) {
                                zzgi.zzc(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zza(t, i6, i2)) {
                                zzgi.zzc(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zza(t, i6, i2)) {
                                zzgi.zzf(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zza(t, i6, i2)) {
                                zzgi.zzb(i6, zzj(t, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zza(t, i6, i2)) {
                                zza(i6, unsafe.getObject(t, j), zzgi);
                                break;
                            }
                            break;
                        case 60:
                            if (zza(t, i6, i2)) {
                                zzgi.zza(i6, unsafe.getObject(t, j), zzan(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (zza(t, i6, i2)) {
                                zzgi.zza(i6, (zzbp) unsafe.getObject(t, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zza(t, i6, i2)) {
                                zzgi.zzd(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zza(t, i6, i2)) {
                                zzgi.zzn(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zza(t, i6, i2)) {
                                zzgi.zzm(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zza(t, i6, i2)) {
                                zzgi.zzj(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zza(t, i6, i2)) {
                                zzgi.zze(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zza(t, i6, i2)) {
                                zzgi.zzb(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zza(t, i6, i2)) {
                                zzgi.zzb(i6, unsafe.getObject(t, j), zzan(i2));
                                break;
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zzasc.zza(zzgi, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzasb, t, zzgi);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.zzarn.length;
        Unsafe unsafe2 = zzarm;
        int i52 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzasb, t, zzgi);
    }

    private final <K, V> void zza(zzgi zzgi, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzgi.zza(i, this.zzasd.zzk(zzao(i2)), this.zzasd.zzg(obj));
        }
    }

    private static <UT, UB> void zza(zzfm<UT, UB> zzfm, T t, zzgi zzgi) throws IOException {
        zzfm.zza(zzfm.zzq(t), zzgi);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T r13, com.google.android.gms.internal.instantapps.zzev r14, com.google.android.gms.internal.instantapps.zzck r15) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1644
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzej.zza(java.lang.Object, com.google.android.gms.internal.instantapps.zzev, com.google.android.gms.internal.instantapps.zzck):void");
    }

    private static zzfp zzn(Object obj) {
        zzcx zzcx = (zzcx) obj;
        zzfp zzfp = zzcx.zzapc;
        if (zzfp != zzfp.zzea()) {
            return zzfp;
        }
        zzfp zzeb = zzfp.zzeb();
        zzcx.zzapc = zzeb;
        return zzeb;
    }

    private static int zza(byte[] bArr, int i, int i2, zzgd zzgd, Class<?> cls, zzbk zzbk) throws IOException {
        switch (zzei.zzals[zzgd.ordinal()]) {
            case 1:
                int zzb = zzbl.zzb(bArr, i, zzbk);
                zzbk.zzakq = Boolean.valueOf(zzbk.zzakp != 0);
                return zzb;
            case 2:
                return zzbl.zze(bArr, i, zzbk);
            case 3:
                zzbk.zzakq = Double.valueOf(zzbl.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzbk.zzakq = Integer.valueOf(zzbl.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzbk.zzakq = Long.valueOf(zzbl.zzb(bArr, i));
                return i + 8;
            case 8:
                zzbk.zzakq = Float.valueOf(zzbl.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzbl.zza(bArr, i, zzbk);
                zzbk.zzakq = Integer.valueOf(zzbk.zzako);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzbl.zzb(bArr, i, zzbk);
                zzbk.zzakq = Long.valueOf(zzbk.zzakp);
                return zzb2;
            case 14:
                return zzbl.zza(zzeq.zzdi().zze(cls), bArr, i, i2, zzbk);
            case 15:
                int zza2 = zzbl.zza(bArr, i, zzbk);
                zzbk.zzakq = Integer.valueOf(zzcb.zzq(zzbk.zzako));
                return zza2;
            case 16:
                int zzb3 = zzbl.zzb(bArr, i, zzbk);
                zzbk.zzakq = Long.valueOf(zzcb.zzc(zzbk.zzakp));
                return zzb3;
            case 17:
                return zzbl.zzd(bArr, i, zzbk);
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
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.instantapps.zzbk r29) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 1126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.instantapps.zzej.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.instantapps.zzbk):int");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzbk zzbk) throws IOException {
        Unsafe unsafe = zzarm;
        Object zzao = zzao(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzasd.zzh(object)) {
            Object zzj = this.zzasd.zzj(zzao);
            this.zzasd.zzb(zzj, object);
            unsafe.putObject(t, j, zzj);
            object = zzj;
        }
        zzdw<?, ?> zzk = this.zzasd.zzk(zzao);
        Map<?, ?> zzf = this.zzasd.zzf(object);
        int zza = zzbl.zza(bArr, i, zzbk);
        int i4 = zzbk.zzako;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzdf.zzcf();
        }
        int i5 = i4 + zza;
        EventLogTags eventLogTags = (K) zzk.zzarf;
        EventLogTags eventLogTags2 = (V) zzk.zzarh;
        while (zza < i5) {
            int i6 = zza + 1;
            byte b = bArr[zza];
            int i7 = b;
            if (b < 0) {
                i6 = zzbl.zza(b, bArr, i6, zzbk);
                i7 = zzbk.zzako;
            }
            int i8 = (i7 == 1 ? 1 : 0) >>> 3;
            int i9 = (i7 == 1 ? 1 : 0) & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzk.zzarg.zzek()) {
                    zza = zza(bArr, i6, i2, zzk.zzarg, zzk.zzarh.getClass(), zzbk);
                    eventLogTags2 = (V) zzbk.zzakq;
                }
            } else if (i9 == zzk.zzare.zzek()) {
                zza = zza(bArr, i6, i2, zzk.zzare, (Class<?>) null, zzbk);
                eventLogTags = (K) zzbk.zzakq;
            }
            zza = zzbl.zza(i7, bArr, i6, i2, zzbk);
        }
        if (zza == i5) {
            zzf.put(eventLogTags, eventLogTags2);
            return i5;
        }
        throw zzdf.zzcl();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzbk zzbk) throws IOException {
        int i9;
        Unsafe unsafe = zzarm;
        long j2 = (long) (this.zzarn[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzbl.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzbl.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzbl.zzb(bArr, i, zzbk);
                    unsafe.putObject(t, j, Long.valueOf(zzbk.zzakp));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzbl.zza(bArr, i, zzbk);
                    unsafe.putObject(t, j, Integer.valueOf(zzbk.zzako));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzbl.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzbl.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzbl.zzb(bArr, i, zzbk);
                    unsafe.putObject(t, j, Boolean.valueOf(zzbk.zzakp != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzbl.zza(bArr, i, zzbk);
                    int i10 = zzbk.zzako;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & PKIFailureInfo.duplicateCertReq) == 0 || zzfv.zze(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzcy.UTF_8));
                        zza += i10;
                    } else {
                        throw zzdf.zzcm();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzbl.zza(zzan(i8), bArr, i, i2, zzbk);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzbk.zzakq);
                    } else {
                        unsafe.putObject(t, j, zzcy.zza(object, zzbk.zzakq));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzbl.zze(bArr, i, zzbk);
                    unsafe.putObject(t, j, zzbk.zzakq);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzbl.zza(bArr, i, zzbk);
                    int i11 = zzbk.zzako;
                    zzdd zzap = zzap(i8);
                    if (zzap == null || zzap.zzf(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzn(t).zzb(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzbl.zza(bArr, i, zzbk);
                    unsafe.putObject(t, j, Integer.valueOf(zzcb.zzq(zzbk.zzako)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzbl.zzb(bArr, i, zzbk);
                    unsafe.putObject(t, j, Long.valueOf(zzcb.zzc(zzbk.zzakp)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzbl.zza(zzan(i8), bArr, i, i2, (i3 & -8) | 4, zzbk);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzbk.zzakq);
                    } else {
                        unsafe.putObject(t, j, zzcy.zza(object2, zzbk.zzakq));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzeu zzan(int i) {
        int i2 = (i / 3) << 1;
        zzeu zzeu = (zzeu) this.zzaro[i2];
        if (zzeu != null) {
            return zzeu;
        }
        zzeu<T> zze = zzeq.zzdi().zze((Class) this.zzaro[i2 + 1]);
        this.zzaro[i2] = zze;
        return zze;
    }

    private final Object zzao(int i) {
        return this.zzaro[(i / 3) << 1];
    }

    private final zzdd zzap(int i) {
        return (zzdd) this.zzaro[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x036c, code lost:
        if (r0 == r4) goto L_0x03df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b5, code lost:
        if (r0 == r15) goto L_0x03df;
     */
    public final int zza(T t, byte[] bArr, int i, int i2, int i3, zzbk zzbk) throws IOException {
        Unsafe unsafe;
        int i4;
        T t2;
        zzej<T> zzej;
        byte b;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        T t3;
        zzbk zzbk2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        zzbk zzbk3;
        zzbk zzbk4;
        int i19;
        zzbk zzbk5;
        zzej<T> zzej2 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i20 = i2;
        int i21 = i3;
        zzbk zzbk6 = zzbk;
        Unsafe unsafe2 = zzarm;
        int i22 = i;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = -1;
        int i27 = -1;
        while (true) {
            if (i22 < i20) {
                int i28 = i22 + 1;
                byte b2 = bArr2[i22];
                if (b2 < 0) {
                    i5 = zzbl.zza(b2, bArr2, i28, zzbk6);
                    b = zzbk6.zzako;
                } else {
                    b = b2;
                    i5 = i28;
                }
                int i29 = b >>> 3;
                int i30 = b & 7;
                if (i29 > i26) {
                    i6 = zzej2.zzp(i29, i23 / 3);
                } else {
                    i6 = zzej2.zzat(i29);
                }
                if (i6 == -1) {
                    i7 = i29;
                    i10 = i5;
                    i9 = b;
                    unsafe = unsafe2;
                    i4 = i21;
                    i8 = 0;
                } else {
                    int[] iArr = zzej2.zzarn;
                    int i31 = iArr[i6 + 1];
                    int i32 = (i31 & 267386880) >>> 20;
                    long j = (long) (i31 & 1048575);
                    if (i32 <= 17) {
                        int i33 = iArr[i6 + 2];
                        int i34 = 1 << (i33 >>> 20);
                        int i35 = i33 & 1048575;
                        if (i35 != i27) {
                            if (i27 != -1) {
                                unsafe2.putInt(t4, (long) i27, i25);
                            }
                            i25 = unsafe2.getInt(t4, (long) i35);
                            i27 = i35;
                        }
                        switch (i32) {
                            case 0:
                                i16 = i6;
                                i15 = i29;
                                i14 = i27;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                i18 = i5;
                                if (i30 == 1) {
                                    zzfs.zza(t4, j, zzbl.zzc(bArr2, i18));
                                    i22 = i18 + 8;
                                    i25 |= i34;
                                    i27 = i14;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 1:
                                i16 = i6;
                                i15 = i29;
                                i14 = i27;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                i18 = i5;
                                if (i30 == 5) {
                                    zzfs.zza((Object) t4, j, zzbl.zzd(bArr2, i18));
                                    i22 = i18 + 4;
                                    i25 |= i34;
                                    i27 = i14;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 2:
                            case 3:
                                i16 = i6;
                                i15 = i29;
                                i14 = i27;
                                i17 = b;
                                bArr2 = bArr;
                                i18 = i5;
                                if (i30 == 0) {
                                    int zzb = zzbl.zzb(bArr2, i18, zzbk);
                                    unsafe2.putLong(t, j, zzbk.zzakp);
                                    i25 |= i34;
                                    i22 = zzb;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk;
                                    i27 = i14;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 4:
                            case 11:
                                i16 = i6;
                                i15 = i29;
                                i14 = i27;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                i18 = i5;
                                if (i30 == 0) {
                                    i22 = zzbl.zza(bArr2, i18, zzbk3);
                                    unsafe2.putInt(t4, j, zzbk3.zzako);
                                    i25 |= i34;
                                    i27 = i14;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 5:
                            case 14:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                if (i30 == 1) {
                                    i14 = i27;
                                    i18 = i5;
                                    unsafe2.putLong(t, j, zzbl.zzb(bArr2, i5));
                                    i22 = i18 + 8;
                                    i25 |= i34;
                                    i27 = i14;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 6:
                            case 13:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                i19 = i2;
                                zzbk4 = zzbk;
                                if (i30 == 5) {
                                    unsafe2.putInt(t4, j, zzbl.zza(bArr2, i5));
                                    i22 = i5 + 4;
                                    i25 |= i34;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk4;
                                    i21 = i3;
                                    i20 = i19;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 7:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                i19 = i2;
                                zzbk4 = zzbk;
                                if (i30 == 0) {
                                    int zzb2 = zzbl.zzb(bArr2, i5, zzbk4);
                                    zzfs.zza(t4, j, zzbk4.zzakp != 0);
                                    i25 |= i34;
                                    i22 = zzb2;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk4;
                                    i21 = i3;
                                    i20 = i19;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 8:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                i19 = i2;
                                zzbk4 = zzbk;
                                if (i30 == 2) {
                                    if ((i31 & PKIFailureInfo.duplicateCertReq) == 0) {
                                        i22 = zzbl.zzc(bArr2, i5, zzbk4);
                                    } else {
                                        i22 = zzbl.zzd(bArr2, i5, zzbk4);
                                    }
                                    unsafe2.putObject(t4, j, zzbk4.zzakq);
                                    i25 |= i34;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk4;
                                    i21 = i3;
                                    i20 = i19;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 9:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk4 = zzbk;
                                if (i30 == 2) {
                                    i19 = i2;
                                    i22 = zzbl.zza(zzej2.zzan(i16), bArr2, i5, i19, zzbk4);
                                    if ((i25 & i34) == 0) {
                                        unsafe2.putObject(t4, j, zzbk4.zzakq);
                                    } else {
                                        unsafe2.putObject(t4, j, zzcy.zza(unsafe2.getObject(t4, j), zzbk4.zzakq));
                                    }
                                    i25 |= i34;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk4;
                                    i21 = i3;
                                    i20 = i19;
                                    break;
                                } else {
                                    i14 = i27;
                                    i18 = i5;
                                    i10 = i18;
                                    i8 = i16;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i27 = i14;
                                    i9 = i17;
                                    i4 = i3;
                                    break;
                                }
                            case 10:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                if (i30 == 2) {
                                    i22 = zzbl.zze(bArr2, i5, zzbk3);
                                    unsafe2.putObject(t4, j, zzbk3.zzakq);
                                    i25 |= i34;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 12:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                if (i30 == 0) {
                                    i22 = zzbl.zza(bArr2, i5, zzbk3);
                                    int i36 = zzbk3.zzako;
                                    zzdd zzap = zzej2.zzap(i16);
                                    if (zzap == null || zzap.zzf(i36)) {
                                        unsafe2.putInt(t4, j, i36);
                                        i25 |= i34;
                                        i24 = i17;
                                        i23 = i16;
                                        i26 = i15;
                                        zzbk6 = zzbk3;
                                        i20 = i2;
                                        i21 = i3;
                                        break;
                                    } else {
                                        zzn(t).zzb(i17, Long.valueOf((long) i36));
                                        i24 = i17;
                                        i23 = i16;
                                        i26 = i15;
                                        zzbk6 = zzbk3;
                                        i20 = i2;
                                        i21 = i3;
                                    }
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 15:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                bArr2 = bArr;
                                zzbk3 = zzbk;
                                if (i30 == 0) {
                                    i22 = zzbl.zza(bArr2, i5, zzbk3);
                                    unsafe2.putInt(t4, j, zzcb.zzq(zzbk3.zzako));
                                    i25 |= i34;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                }
                                i14 = i27;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                            case 16:
                                i16 = i6;
                                i15 = i29;
                                i17 = b;
                                if (i30 == 0) {
                                    bArr2 = bArr;
                                    int zzb3 = zzbl.zzb(bArr2, i5, zzbk);
                                    zzbk3 = zzbk;
                                    unsafe2.putLong(t, j, zzcb.zzc(zzbk.zzakp));
                                    i25 |= i34;
                                    i22 = zzb3;
                                    i24 = i17;
                                    i23 = i16;
                                    i26 = i15;
                                    zzbk6 = zzbk3;
                                    i20 = i2;
                                    i21 = i3;
                                    break;
                                } else {
                                    i14 = i27;
                                    i18 = i5;
                                    i10 = i18;
                                    i8 = i16;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i27 = i14;
                                    i9 = i17;
                                    i4 = i3;
                                    break;
                                }
                            case 17:
                                if (i30 == 3) {
                                    i22 = zzbl.zza(zzej2.zzan(i6), bArr, i5, i2, (i29 << 3) | 4, zzbk);
                                    if ((i25 & i34) == 0) {
                                        zzbk5 = zzbk;
                                        unsafe2.putObject(t4, j, zzbk5.zzakq);
                                    } else {
                                        zzbk5 = zzbk;
                                        unsafe2.putObject(t4, j, zzcy.zza(unsafe2.getObject(t4, j), zzbk5.zzakq));
                                    }
                                    i25 |= i34;
                                    bArr2 = bArr;
                                    i20 = i2;
                                    i24 = b;
                                    i23 = i6;
                                    i26 = i29;
                                    i21 = i3;
                                    zzbk6 = zzbk5;
                                    break;
                                } else {
                                    i16 = i6;
                                    i15 = i29;
                                    i17 = b;
                                    i14 = i27;
                                    i18 = i5;
                                    i10 = i18;
                                    i8 = i16;
                                    unsafe = unsafe2;
                                    i7 = i15;
                                    i27 = i14;
                                    i9 = i17;
                                    i4 = i3;
                                    break;
                                }
                            default:
                                i16 = i6;
                                i15 = i29;
                                i14 = i27;
                                i17 = b;
                                i18 = i5;
                                i10 = i18;
                                i8 = i16;
                                unsafe = unsafe2;
                                i7 = i15;
                                i27 = i14;
                                i9 = i17;
                                i4 = i3;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        if (i32 != 27) {
                            i12 = i25;
                            if (i32 <= 49) {
                                i7 = i29;
                                i11 = b;
                                i8 = i6;
                                unsafe = unsafe2;
                                i22 = zza(t, bArr, i5, i2, b, i29, i30, i6, (long) i31, i32, j, zzbk);
                            } else {
                                i7 = i29;
                                i13 = i5;
                                i11 = b;
                                i8 = i6;
                                unsafe = unsafe2;
                                if (i32 != 50) {
                                    i22 = zza(t, bArr, i13, i2, i11, i7, i30, i31, i32, j, i8, zzbk);
                                    if (i22 != i13) {
                                        zzej2 = this;
                                        t4 = t;
                                        i20 = i2;
                                        i21 = i3;
                                        i24 = i11;
                                        i26 = i7;
                                        i27 = i27;
                                        i23 = i8;
                                        i25 = i12;
                                        unsafe2 = unsafe;
                                        bArr2 = bArr;
                                        zzbk6 = zzbk;
                                    }
                                } else if (i30 == 2) {
                                    i22 = zza(t, bArr, i13, i2, i8, j, zzbk);
                                }
                                i4 = i3;
                                i10 = i22;
                                i27 = i27;
                                i25 = i12;
                                i9 = i11;
                            }
                            zzej2 = this;
                            t4 = t;
                            bArr2 = bArr;
                            i20 = i2;
                            i21 = i3;
                            zzbk6 = zzbk;
                            i27 = i27;
                            i23 = i8;
                            i25 = i12;
                            i26 = i7;
                            i24 = i11;
                            unsafe2 = unsafe;
                        } else if (i30 == 2) {
                            zzdc zzdc = (zzdc) unsafe2.getObject(t4, j);
                            if (!zzdc.zzr()) {
                                int size = zzdc.size();
                                zzdc = zzdc.zzi(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t4, j, zzdc);
                            }
                            i22 = zzbl.zza(zzej2.zzan(i6), b, bArr, i5, i2, zzdc, zzbk);
                            i21 = i3;
                            i26 = i29;
                            i24 = b;
                            i23 = i6;
                            zzbk6 = zzbk6;
                            i27 = i27;
                            i25 = i25;
                            i20 = i2;
                        } else {
                            i12 = i25;
                            i7 = i29;
                            i13 = i5;
                            i11 = b;
                            i8 = i6;
                            unsafe = unsafe2;
                        }
                        i4 = i3;
                        i10 = i13;
                        i27 = i27;
                        i25 = i12;
                        i9 = i11;
                    }
                }
                if (i9 != i4 || i4 == 0) {
                    if (this.zzars) {
                        zzbk2 = zzbk;
                        if (zzbk2.zzakr == zzck.zzbf()) {
                            t3 = t;
                        } else if (zzbk2.zzakr.zza(this.zzarr, i7) == null) {
                            i22 = zzbl.zza(i9, bArr, i10, i2, zzn(t), zzbk);
                            t4 = t;
                            i20 = i2;
                            i24 = i9;
                            zzej2 = this;
                            zzbk6 = zzbk2;
                            i26 = i7;
                            i23 = i8;
                            unsafe2 = unsafe;
                            bArr2 = bArr;
                            i21 = i4;
                        } else {
                            T t5 = t;
                            t5.zzcd();
                            zzcq<Object> zzcq = t5.zzapf;
                            throw new NoSuchMethodError();
                        }
                    } else {
                        t3 = t;
                        zzbk2 = zzbk;
                    }
                    i22 = zzbl.zza(i9, bArr, i10, i2, zzn(t), zzbk);
                    i24 = i9;
                    zzej2 = this;
                    zzbk6 = zzbk2;
                    i26 = i7;
                    t4 = t3;
                    i23 = i8;
                    unsafe2 = unsafe;
                    bArr2 = bArr;
                    i20 = i2;
                    i21 = i4;
                } else {
                    zzej = this;
                    t2 = t;
                    i22 = i10;
                    i24 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i21;
                t2 = t4;
                zzej = zzej2;
            }
        }
        if (i27 != -1) {
            unsafe.putInt(t2, (long) i27, i25);
        }
        zzfp zzfp = null;
        for (int i37 = zzej.zzarx; i37 < zzej.zzary; i37++) {
            zzfp = (zzfp) zzej.zza(t2, zzej.zzarw[i37], zzfp, (zzfm<UT, UB>) zzej.zzasb);
        }
        if (zzfp != null) {
            zzej.zzasb.zzf(t2, zzfp);
        }
        if (i4 == 0) {
            if (i22 != i2) {
                throw zzdf.zzcl();
            }
        } else if (i22 > i2 || i24 != i4) {
            throw zzdf.zzcl();
        }
        return i22;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e4, code lost:
        if (r0 == r8) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0211, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0230, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zza(T t, byte[] bArr, int i, int i2, zzbk zzbk) throws IOException {
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Unsafe unsafe;
        int i8;
        int i9;
        int i10;
        int i11;
        zzej<T> zzej = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i12 = i2;
        zzbk zzbk2 = zzbk;
        if (zzej.zzaru) {
            Unsafe unsafe2 = zzarm;
            int i13 = -1;
            int i14 = i;
            int i15 = -1;
            int i16 = 0;
            while (i14 < i12) {
                int i17 = i14 + 1;
                byte b2 = bArr2[i14];
                if (b2 < 0) {
                    i3 = zzbl.zza(b2, bArr2, i17, zzbk2);
                    b = zzbk2.zzako;
                } else {
                    b = b2;
                    i3 = i17;
                }
                int i18 = b >>> 3;
                int i19 = b & 7;
                if (i18 > i15) {
                    i4 = zzej.zzp(i18, i16 / 3);
                } else {
                    i4 = zzej.zzat(i18);
                }
                if (i4 == i13) {
                    i6 = i18;
                    i8 = i3;
                    unsafe = unsafe2;
                    i5 = i13;
                    i7 = 0;
                } else {
                    int i20 = zzej.zzarn[i4 + 1];
                    int i21 = (267386880 & i20) >>> 20;
                    long j = (long) (1048575 & i20);
                    if (i21 <= 17) {
                        boolean z = true;
                        switch (i21) {
                            case 0:
                                i10 = i4;
                                if (i19 == 1) {
                                    zzfs.zza(t2, j, zzbl.zzc(bArr2, i3));
                                    i14 = i3 + 8;
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 1:
                                i10 = i4;
                                if (i19 == 5) {
                                    zzfs.zza((Object) t2, j, zzbl.zzd(bArr2, i3));
                                    i14 = i3 + 4;
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 2:
                            case 3:
                                i10 = i4;
                                if (i19 == 0) {
                                    i11 = zzbl.zzb(bArr2, i3, zzbk2);
                                    unsafe2.putLong(t, j, zzbk2.zzakp);
                                    i14 = i11;
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 4:
                            case 11:
                                i10 = i4;
                                if (i19 == 0) {
                                    i14 = zzbl.zza(bArr2, i3, zzbk2);
                                    unsafe2.putInt(t2, j, zzbk2.zzako);
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 5:
                            case 14:
                                if (i19 == 1) {
                                    i10 = i4;
                                    unsafe2.putLong(t, j, zzbl.zzb(bArr2, i3));
                                    i14 = i3 + 8;
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 6:
                            case 13:
                                if (i19 == 5) {
                                    unsafe2.putInt(t2, j, zzbl.zza(bArr2, i3));
                                    i14 = i3 + 4;
                                    i16 = i4;
                                    i15 = i18;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 7:
                                if (i19 == 0) {
                                    int zzb = zzbl.zzb(bArr2, i3, zzbk2);
                                    if (zzbk2.zzakp == 0) {
                                        z = false;
                                    }
                                    zzfs.zza(t2, j, z);
                                    i14 = zzb;
                                    i16 = i4;
                                    i15 = i18;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 8:
                                if (i19 == 2) {
                                    if ((536870912 & i20) == 0) {
                                        i14 = zzbl.zzc(bArr2, i3, zzbk2);
                                    } else {
                                        i14 = zzbl.zzd(bArr2, i3, zzbk2);
                                    }
                                    unsafe2.putObject(t2, j, zzbk2.zzakq);
                                    i16 = i4;
                                    i15 = i18;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 9:
                                if (i19 == 2) {
                                    i14 = zzbl.zza(zzej.zzan(i4), bArr2, i3, i12, zzbk2);
                                    Object object = unsafe2.getObject(t2, j);
                                    if (object == null) {
                                        unsafe2.putObject(t2, j, zzbk2.zzakq);
                                    } else {
                                        unsafe2.putObject(t2, j, zzcy.zza(object, zzbk2.zzakq));
                                    }
                                    i16 = i4;
                                    i15 = i18;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 10:
                                if (i19 == 2) {
                                    i14 = zzbl.zze(bArr2, i3, zzbk2);
                                    unsafe2.putObject(t2, j, zzbk2.zzakq);
                                    i16 = i4;
                                    i15 = i18;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 12:
                                i10 = i4;
                                if (i19 == 0) {
                                    i14 = zzbl.zza(bArr2, i3, zzbk2);
                                    unsafe2.putInt(t2, j, zzbk2.zzako);
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 15:
                                i10 = i4;
                                if (i19 == 0) {
                                    i14 = zzbl.zza(bArr2, i3, zzbk2);
                                    unsafe2.putInt(t2, j, zzcb.zzq(zzbk2.zzako));
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i7 = i10;
                                i5 = -1;
                                i8 = i9;
                                break;
                            case 16:
                                if (i19 == 0) {
                                    i11 = zzbl.zzb(bArr2, i3, zzbk2);
                                    i10 = i4;
                                    unsafe2.putLong(t, j, zzcb.zzc(zzbk2.zzakp));
                                    i14 = i11;
                                    i15 = i18;
                                    i16 = i10;
                                    break;
                                }
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                            default:
                                i7 = i4;
                                i6 = i18;
                                i9 = i3;
                                unsafe = unsafe2;
                                i5 = -1;
                                i8 = i9;
                                break;
                        }
                    } else if (i21 == 27) {
                        if (i19 == 2) {
                            zzdc zzdc = (zzdc) unsafe2.getObject(t2, j);
                            if (!zzdc.zzr()) {
                                int size = zzdc.size();
                                zzdc = zzdc.zzi(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t2, j, zzdc);
                            }
                            i14 = zzbl.zza(zzej.zzan(i4), b, bArr, i3, i2, zzdc, zzbk);
                            i15 = i18;
                            i16 = i4;
                        }
                        i7 = i4;
                        i6 = i18;
                        i9 = i3;
                        unsafe = unsafe2;
                        i5 = -1;
                        i8 = i9;
                    } else {
                        i7 = i4;
                        if (i21 <= 49) {
                            i6 = i18;
                            unsafe = unsafe2;
                            i5 = -1;
                            i14 = zza(t, bArr, i3, i2, b, i18, i19, i7, (long) i20, i21, j, zzbk);
                        } else {
                            i6 = i18;
                            i9 = i3;
                            unsafe = unsafe2;
                            i5 = -1;
                            if (i21 == 50) {
                                if (i19 == 2) {
                                    i14 = zza(t, bArr, i9, i2, i7, j, zzbk);
                                }
                                i8 = i9;
                            } else {
                                i14 = zza(t, bArr, i9, i2, b, i6, i19, i20, i21, j, i7, zzbk);
                            }
                        }
                        i8 = i14;
                    }
                    i13 = -1;
                }
                i14 = zzbl.zza(b, bArr, i8, i2, zzn(t), zzbk);
                zzej = this;
                t2 = t;
                bArr2 = bArr;
                i12 = i2;
                zzbk2 = zzbk;
                unsafe2 = unsafe;
                i16 = i7;
                i15 = i6;
                i13 = i5;
            }
            if (i14 != i12) {
                throw zzdf.zzcl();
            }
            return;
        }
        zza(t, bArr, i, i2, 0, zzbk);
    }

    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final void zzc(T t) {
        int i;
        int i2 = this.zzarx;
        while (true) {
            i = this.zzary;
            if (i2 >= i) {
                break;
            }
            long zzaq = (long) (zzaq(this.zzarw[i2]) & 1048575);
            Object zzp = zzfs.zzp(t, zzaq);
            if (zzp != null) {
                zzfs.zza(t, zzaq, this.zzasd.zzi(zzp));
            }
            i2++;
        }
        int length = this.zzarw.length;
        while (i < length) {
            this.zzasa.zzb(t, (long) this.zzarw[i]);
            i++;
        }
        this.zzasb.zzc(t);
        if (this.zzars) {
            this.zzasc.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzfm<UT, UB> zzfm) {
        zzdd zzap;
        int i2 = this.zzarn[i];
        Object zzp = zzfs.zzp(obj, (long) (zzaq(i) & 1048575));
        return (zzp == null || (zzap = zzap(i)) == null) ? ub : (UB) zza(i, i2, (Map<K, V>) this.zzasd.zzf(zzp), zzap, ub, zzfm);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzdd zzdd, UB ub, zzfm<UT, UB> zzfm) {
        zzdw<?, ?> zzk = this.zzasd.zzk(zzao(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!zzdd.zzf(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzfm.zzdz();
                }
                zzbx zzl = zzbp.zzl(zzdx.zza(zzk, next.getKey(), next.getValue()));
                try {
                    zzdx.zza(zzl.zzz(), zzk, next.getKey(), next.getValue());
                    zzfm.zza(ub, i2, zzl.zzy());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.android.gms.internal.instantapps.zzeu] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14, types: [com.google.android.gms.internal.instantapps.zzeu] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.instantapps.zzeu
    public final boolean zzo(T t) {
        int i;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i3 >= this.zzarx) {
                return !this.zzars || this.zzasc.zza(t).isInitialized();
            }
            int i5 = this.zzarw[i3];
            int i6 = this.zzarn[i5];
            int zzaq = zzaq(i5);
            if (!this.zzaru) {
                int i7 = this.zzarn[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i2) {
                    i4 = zzarm.getInt(t, (long) i8);
                    i2 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzaq) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzaq) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza(t, zzaq, zzan(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzg = this.zzasd.zzg(zzfs.zzp(t, (long) (zzaq & 1048575)));
                            if (!zzg.isEmpty()) {
                                if (this.zzasd.zzk(zzao(i5)).zzarg.zzej() == zzgg.MESSAGE) {
                                    zzeu<T> zzeu = 0;
                                    Iterator<?> it = zzg.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzeu == null) {
                                            zzeu = zzeq.zzdi().zze(next.getClass());
                                        }
                                        boolean zzo = zzeu.zzo(next);
                                        zzeu = zzeu;
                                        if (!zzo) {
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
                List list = (List) zzfs.zzp(t, (long) (zzaq & 1048575));
                if (!list.isEmpty()) {
                    ?? zzan = zzan(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zzan.zzo(list.get(i10))) {
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
            } else if (zza(t, i5, i4, i) && !zza(t, zzaq, zzan(i5))) {
                return false;
            }
            i3++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.instantapps.zzeu */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzeu zzeu) {
        return zzeu.zzo(zzfs.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzgi zzgi) throws IOException {
        if (obj instanceof String) {
            zzgi.zza(i, (String) obj);
        } else {
            zzgi.zza(i, (zzbp) obj);
        }
    }

    private final void zza(Object obj, int i, zzev zzev) throws IOException {
        if (zzas(i)) {
            zzfs.zza(obj, (long) (i & 1048575), zzev.zzah());
        } else if (this.zzart) {
            zzfs.zza(obj, (long) (i & 1048575), zzev.readString());
        } else {
            zzfs.zza(obj, (long) (i & 1048575), zzev.zzai());
        }
    }

    private final int zzaq(int i) {
        return this.zzarn[i + 1];
    }

    private final int zzar(int i) {
        return this.zzarn[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzfs.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzfs.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzfs.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzfs.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzfs.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzaru) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzaru) {
            int zzaq = zzaq(i);
            long j = (long) (zzaq & 1048575);
            switch ((zzaq & 267386880) >>> 20) {
                case 0:
                    return zzfs.zzo(t, j) != 0.0d;
                case 1:
                    return zzfs.zzn(t, j) != 0.0f;
                case 2:
                    return zzfs.zzl(t, j) != 0;
                case 3:
                    return zzfs.zzl(t, j) != 0;
                case 4:
                    return zzfs.zzk(t, j) != 0;
                case 5:
                    return zzfs.zzl(t, j) != 0;
                case 6:
                    return zzfs.zzk(t, j) != 0;
                case 7:
                    return zzfs.zzm(t, j);
                case 8:
                    Object zzp = zzfs.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzbp) {
                        return !zzbp.zzakv.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfs.zzp(t, j) != null;
                case 10:
                    return !zzbp.zzakv.equals(zzfs.zzp(t, j));
                case 11:
                    return zzfs.zzk(t, j) != 0;
                case 12:
                    return zzfs.zzk(t, j) != 0;
                case 13:
                    return zzfs.zzk(t, j) != 0;
                case 14:
                    return zzfs.zzl(t, j) != 0;
                case 15:
                    return zzfs.zzk(t, j) != 0;
                case 16:
                    return zzfs.zzl(t, j) != 0;
                case 17:
                    return zzfs.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzar = zzar(i);
            return (zzfs.zzk(t, (long) (zzar & 1048575)) & (1 << (zzar >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzaru) {
            int zzar = zzar(i);
            long j = (long) (zzar & 1048575);
            zzfs.zzb(t, j, zzfs.zzk(t, j) | (1 << (zzar >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfs.zzk(t, (long) (zzar(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzfs.zzb(t, (long) (zzar(i2) & 1048575), i);
    }

    private final int zzat(int i) {
        if (i < this.zzarp || i > this.zzarq) {
            return -1;
        }
        return zzq(i, 0);
    }

    private final int zzp(int i, int i2) {
        if (i < this.zzarp || i > this.zzarq) {
            return -1;
        }
        return zzq(i, i2);
    }

    private final int zzq(int i, int i2) {
        int length = (this.zzarn.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzarn[i4];
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
