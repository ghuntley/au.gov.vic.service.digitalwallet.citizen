package com.google.android.gms.internal.clearcut;

import android.util.EventLogTags;
import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdo, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdo instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbu != null && zzbu.zze(zzdo);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdw;
        this.zzmw = zzcy;
        this.zzmx = zzex;
        this.zzmy = zzbu;
        this.zzmn = zzdo;
        this.zzmz = zzdj;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzay) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzay);
    }

    private static int zza(zzef<?> zzef, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcn, zzay zzay) throws IOException {
        int zza = zza((zzef) zzef, bArr, i2, i3, zzay);
        while (true) {
            zzcn.add(zzay.zzff);
            if (zza >= i3) {
                break;
            }
            int zza2 = zzax.zza(bArr, zza, zzay);
            if (i != zzay.zzfd) {
                break;
            }
            zza = zza((zzef) zzef, bArr, zza2, i3, zzay);
        }
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: com.google.android.gms.internal.clearcut.zzds */
    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzef, byte[] bArr, int i, int i2, int i3, zzay zzay) throws IOException {
        zzds zzds = (zzds) zzef;
        Object newInstance = zzds.newInstance();
        int zza = zzds.zza(newInstance, bArr, i, i2, i3, zzay);
        zzds.zzc(newInstance);
        zzay.zzff = newInstance;
        return zza;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.android.gms.internal.clearcut.zzef */
    /* JADX WARN: Multi-variable type inference failed */
    private static int zza(zzef zzef, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zzax.zza(b, bArr, i3, zzay);
            b2 = zzay.zzfd;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzco.zzbl();
        }
        Object newInstance = zzef.newInstance();
        int i4 = (b2 == 1 ? 1 : 0) + i3;
        zzef.zza(newInstance, bArr, i3, i4, zzay);
        zzef.zzc(newInstance);
        zzay.zzff = newInstance;
        return i4;
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzex, T t) {
        return zzex.zzm(zzex.zzq(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzay zzay) throws IOException {
        int i9;
        Object obj;
        Object obj2;
        Object obj3;
        long j2;
        int i10;
        int i11;
        Unsafe unsafe = zzmh;
        long j3 = (long) (this.zzmi[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    obj = Double.valueOf(zzax.zze(bArr, i));
                    unsafe.putObject(t, j, obj);
                    i9 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    obj2 = Float.valueOf(zzax.zzf(bArr, i));
                    unsafe.putObject(t, j, obj2);
                    i9 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzax.zzb(bArr, i, zzay);
                    j2 = zzay.zzfe;
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i10 = zzay.zzfd;
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    obj = Long.valueOf(zzax.zzd(bArr, i));
                    unsafe.putObject(t, j, obj);
                    i9 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                    unsafe.putObject(t, j, obj2);
                    i9 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzax.zzb(bArr, i, zzay);
                    obj3 = Boolean.valueOf(zzay.zzfe != 0);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i11 = zzay.zzfd;
                    if (i11 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j, obj3);
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    } else if ((i6 & PKIFailureInfo.duplicateCertReq) == 0 || zzff.zze(bArr, i9, i9 + i11)) {
                        unsafe.putObject(t, j, new String(bArr, i9, i11, zzci.UTF_8));
                        i9 += i11;
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    } else {
                        throw zzco.zzbp();
                    }
                }
                return i;
            case 60:
                if (i5 == 2) {
                    i9 = zza(zzad(i8), bArr, i, i2, zzay);
                    Object object = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    obj3 = zzay.zzff;
                    if (object != null) {
                        obj3 = zzci.zza(object, obj3);
                    }
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i11 = zzay.zzfd;
                    if (i11 == 0) {
                        obj3 = zzbb.zzfi;
                        unsafe.putObject(t, j, obj3);
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    }
                    unsafe.putObject(t, j, zzbb.zzb(bArr, i9, i11));
                    i9 += i11;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza = zzax.zza(bArr, i, zzay);
                    int i12 = zzay.zzfd;
                    zzck<?> zzaf = zzaf(i8);
                    if (zzaf == null || zzaf.zzb(i12) != null) {
                        unsafe.putObject(t, j, Integer.valueOf(i12));
                        i9 = zza;
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    }
                    zzn(t).zzb(i3, Long.valueOf((long) i12));
                    return zza;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i10 = zzbk.zzm(zzay.zzfd);
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzax.zzb(bArr, i, zzay);
                    j2 = zzbk.zza(zzay.zzfe);
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zza(zzad(i8), bArr, i, i2, (i3 & -8) | 4, zzay);
                    Object object2 = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    obj3 = zzay.zzff;
                    if (object2 != null) {
                        obj3 = zzci.zza(object2, obj3);
                    }
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0233, code lost:
        if (r29.zzfe != 0) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0235, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0237, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0238, code lost:
        r12.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x023b, code lost:
        if (r4 >= r19) goto L_0x039c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x023d, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzax.zza(r17, r4, r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0243, code lost:
        if (r20 != r29.zzfd) goto L_0x039c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0245, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r17, r6, r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024d, code lost:
        if (r29.zzfe == 0) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0137, code lost:
        if (r4 == 0) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0139, code lost:
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013f, code lost:
        r12.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r17, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0147, code lost:
        if (r1 >= r19) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0149, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zza(r17, r1, r29);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x014f, code lost:
        if (r20 != r29.zzfd) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0151, code lost:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r17, r4, r29);
        r4 = r29.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0157, code lost:
        if (r4 != 0) goto L_0x013f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d4  */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzay zzay) throws IOException {
        int zzb;
        int zza;
        int zza2;
        int zzb2;
        int i8 = i;
        Unsafe unsafe = zzmh;
        zzcn zzcn = (zzcn) unsafe.getObject(t, j2);
        if (!zzcn.zzu()) {
            int size = zzcn.size();
            zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
            unsafe.putObject(t, j2, zzcn);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbq zzbq = (zzbq) zzcn;
                    int zza3 = zzax.zza(bArr, i8, zzay);
                    int i9 = zzay.zzfd + zza3;
                    while (zza3 < i9) {
                        zzbq.zzc(zzax.zze(bArr, zza3));
                        zza3 += 8;
                    }
                    if (zza3 == i9) {
                        return zza3;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 1) {
                    zzbq zzbq2 = (zzbq) zzcn;
                    zzbq2.zzc(zzax.zze(bArr, i));
                    while (true) {
                        int i10 = i8 + 8;
                        if (i10 >= i2) {
                            return i10;
                        }
                        i8 = zzax.zza(bArr, i10, zzay);
                        if (i3 != zzay.zzfd) {
                            return i10;
                        }
                        zzbq2.zzc(zzax.zze(bArr, i8));
                    }
                }
                return i8;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzce zzce = (zzce) zzcn;
                    int zza4 = zzax.zza(bArr, i8, zzay);
                    int i11 = zzay.zzfd + zza4;
                    while (zza4 < i11) {
                        zzce.zzc(zzax.zzf(bArr, zza4));
                        zza4 += 4;
                    }
                    if (zza4 == i11) {
                        return zza4;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 5) {
                    zzce zzce2 = (zzce) zzcn;
                    zzce2.zzc(zzax.zzf(bArr, i));
                    while (true) {
                        int i12 = i8 + 4;
                        if (i12 >= i2) {
                            return i12;
                        }
                        i8 = zzax.zza(bArr, i12, zzay);
                        if (i3 != zzay.zzfd) {
                            return i12;
                        }
                        zzce2.zzc(zzax.zzf(bArr, i8));
                    }
                }
                return i8;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzdc zzdc = (zzdc) zzcn;
                    int zza5 = zzax.zza(bArr, i8, zzay);
                    int i13 = zzay.zzfd + zza5;
                    while (zza5 < i13) {
                        zza5 = zzax.zzb(bArr, zza5, zzay);
                        zzdc.zzm(zzay.zzfe);
                    }
                    if (zza5 == i13) {
                        return zza5;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 0) {
                    zzdc zzdc2 = (zzdc) zzcn;
                    do {
                        zzb = zzax.zzb(bArr, i8, zzay);
                        zzdc2.zzm(zzay.zzfe);
                        if (zzb >= i2) {
                            return zzb;
                        }
                        i8 = zzax.zza(bArr, zzb, zzay);
                    } while (i3 == zzay.zzfd);
                    return zzb;
                }
                return i8;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzax.zza(bArr, i8, zzcn, zzay);
                }
                if (i5 == 0) {
                    return zzax.zza(i3, bArr, i, i2, zzcn, zzay);
                }
                return i8;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzdc zzdc3 = (zzdc) zzcn;
                    int zza6 = zzax.zza(bArr, i8, zzay);
                    int i14 = zzay.zzfd + zza6;
                    while (zza6 < i14) {
                        zzdc3.zzm(zzax.zzd(bArr, zza6));
                        zza6 += 8;
                    }
                    if (zza6 == i14) {
                        return zza6;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 1) {
                    zzdc zzdc4 = (zzdc) zzcn;
                    zzdc4.zzm(zzax.zzd(bArr, i));
                    while (true) {
                        int i15 = i8 + 8;
                        if (i15 >= i2) {
                            return i15;
                        }
                        i8 = zzax.zza(bArr, i15, zzay);
                        if (i3 != zzay.zzfd) {
                            return i15;
                        }
                        zzdc4.zzm(zzax.zzd(bArr, i8));
                    }
                }
                return i8;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzch zzch = (zzch) zzcn;
                    int zza7 = zzax.zza(bArr, i8, zzay);
                    int i16 = zzay.zzfd + zza7;
                    while (zza7 < i16) {
                        zzch.zzac(zzax.zzc(bArr, zza7));
                        zza7 += 4;
                    }
                    if (zza7 == i16) {
                        return zza7;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 5) {
                    zzch zzch2 = (zzch) zzcn;
                    zzch2.zzac(zzax.zzc(bArr, i));
                    while (true) {
                        int i17 = i8 + 4;
                        if (i17 >= i2) {
                            return i17;
                        }
                        i8 = zzax.zza(bArr, i17, zzay);
                        if (i3 != zzay.zzfd) {
                            return i17;
                        }
                        zzch2.zzac(zzax.zzc(bArr, i8));
                    }
                }
                return i8;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzaz zzaz = (zzaz) zzcn;
                    zza = zzax.zza(bArr, i8, zzay);
                    int i18 = zzay.zzfd + zza;
                    while (zza < i18) {
                        zza = zzax.zzb(bArr, zza, zzay);
                        zzaz.addBoolean(zzay.zzfe != 0);
                    }
                    if (zza != i18) {
                        throw zzco.zzbl();
                    }
                    return zza;
                }
                if (i5 == 0) {
                    zzaz zzaz2 = (zzaz) zzcn;
                    i8 = zzax.zzb(bArr, i8, zzay);
                    break;
                }
                return i8;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int zza8 = zzax.zza(bArr, i8, zzay);
                        int i19 = zzay.zzfd;
                        if (i19 != 0) {
                            String str = new String(bArr, zza8, i19, zzci.UTF_8);
                            zzcn.add(str);
                            zza8 += i19;
                            if (zza8 < i2) {
                                int zza9 = zzax.zza(bArr, zza8, zzay);
                                if (i3 == zzay.zzfd) {
                                    zza8 = zzax.zza(bArr, zza9, zzay);
                                    i19 = zzay.zzfd;
                                    if (i19 != 0) {
                                        str = new String(bArr, zza8, i19, zzci.UTF_8);
                                        zzcn.add(str);
                                        zza8 += i19;
                                        if (zza8 < i2) {
                                            return zza8;
                                        }
                                    }
                                }
                                return zza8;
                            }
                            return zza8;
                        }
                        zzcn.add("");
                        if (zza8 < i2) {
                        }
                        return zza8;
                    }
                    int zza10 = zzax.zza(bArr, i8, zzay);
                    int i20 = zzay.zzfd;
                    if (i20 != 0) {
                        int i21 = zza10 + i20;
                        if (zzff.zze(bArr, zza10, i21)) {
                            String str2 = new String(bArr, zza10, i20, zzci.UTF_8);
                            zzcn.add(str2);
                            zza10 = i21;
                            if (zza10 < i2) {
                                int zza11 = zzax.zza(bArr, zza10, zzay);
                                if (i3 == zzay.zzfd) {
                                    zza10 = zzax.zza(bArr, zza11, zzay);
                                    int i22 = zzay.zzfd;
                                    if (i22 != 0) {
                                        i21 = zza10 + i22;
                                        if (zzff.zze(bArr, zza10, i21)) {
                                            str2 = new String(bArr, zza10, i22, zzci.UTF_8);
                                            zzcn.add(str2);
                                            zza10 = i21;
                                            if (zza10 < i2) {
                                                return zza10;
                                            }
                                        }
                                        throw zzco.zzbp();
                                    }
                                }
                                return zza10;
                            }
                            return zza10;
                        }
                        throw zzco.zzbp();
                    }
                    zzcn.add("");
                    if (zza10 < i2) {
                    }
                    return zza10;
                }
                return i8;
            case 27:
                if (i5 == 2) {
                    return zza(zzad(i6), i3, bArr, i, i2, zzcn, zzay);
                }
                return i8;
            case 28:
                if (i5 == 2) {
                    int zza12 = zzax.zza(bArr, i8, zzay);
                    int i23 = zzay.zzfd;
                    break;
                }
                return i8;
            case 30:
            case 44:
                if (i5 == 2) {
                    zza = zzax.zza(bArr, i8, zzcn, zzay);
                } else {
                    if (i5 == 0) {
                        zza = zzax.zza(i3, bArr, i, i2, zzcn, zzay);
                    }
                    return i8;
                }
                T t2 = t;
                zzey zzey = t2.zzjp;
                if (zzey == zzey.zzea()) {
                    zzey = null;
                }
                zzey zzey2 = (zzey) zzeh.zza(i4, zzcn, zzaf(i6), zzey, this.zzmx);
                if (zzey2 != null) {
                    t2.zzjp = zzey2;
                }
                return zza;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzch zzch3 = (zzch) zzcn;
                    int zza13 = zzax.zza(bArr, i8, zzay);
                    int i24 = zzay.zzfd + zza13;
                    while (zza13 < i24) {
                        zza13 = zzax.zza(bArr, zza13, zzay);
                        zzch3.zzac(zzbk.zzm(zzay.zzfd));
                    }
                    if (zza13 == i24) {
                        return zza13;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 0) {
                    zzch zzch4 = (zzch) zzcn;
                    do {
                        zza2 = zzax.zza(bArr, i8, zzay);
                        zzch4.zzac(zzbk.zzm(zzay.zzfd));
                        if (zza2 >= i2) {
                            return zza2;
                        }
                        i8 = zzax.zza(bArr, zza2, zzay);
                    } while (i3 == zzay.zzfd);
                    return zza2;
                }
                return i8;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzdc zzdc5 = (zzdc) zzcn;
                    int zza14 = zzax.zza(bArr, i8, zzay);
                    int i25 = zzay.zzfd + zza14;
                    while (zza14 < i25) {
                        zza14 = zzax.zzb(bArr, zza14, zzay);
                        zzdc5.zzm(zzbk.zza(zzay.zzfe));
                    }
                    if (zza14 == i25) {
                        return zza14;
                    }
                    throw zzco.zzbl();
                }
                if (i5 == 0) {
                    zzdc zzdc6 = (zzdc) zzcn;
                    do {
                        zzb2 = zzax.zzb(bArr, i8, zzay);
                        zzdc6.zzm(zzbk.zza(zzay.zzfe));
                        if (zzb2 >= i2) {
                            return zzb2;
                        }
                        i8 = zzax.zza(bArr, zzb2, zzay);
                    } while (i3 == zzay.zzfd);
                    return zzb2;
                }
                return i8;
            case 49:
                if (i5 == 3) {
                    zzef zzad = zzad(i6);
                    int i26 = (i3 & -8) | 4;
                    i8 = zza(zzad, bArr, i, i2, i26, zzay);
                    while (true) {
                        zzcn.add(zzay.zzff);
                        if (i8 < i2) {
                            int zza15 = zzax.zza(bArr, i8, zzay);
                            if (i3 == zzay.zzfd) {
                                i8 = zza(zzad, bArr, zza15, i2, i26, zzay);
                            }
                        }
                    }
                }
                return i8;
            default:
                return i8;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x003e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x003e */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzay zzay) throws IOException {
        Unsafe unsafe = zzmh;
        Object zzae = zzae(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzmz.zzi(object)) {
            Object zzk = this.zzmz.zzk(zzae);
            this.zzmz.zzb(zzk, object);
            unsafe.putObject(t, j, zzk);
            object = zzk;
        }
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae);
        Map<?, ?> zzg = this.zzmz.zzg(object);
        int zza = zzax.zza(bArr, i, zzay);
        int i5 = zzay.zzfd;
        if (i5 < 0 || i5 > i2 - zza) {
            throw zzco.zzbl();
        }
        int i6 = i5 + zza;
        EventLogTags eventLogTags = (K) zzl.zzmc;
        EventLogTags eventLogTags2 = (V) zzl.zzdu;
        while (zza < i6) {
            int i7 = zza + 1;
            byte b = bArr[zza];
            int i8 = b;
            if (b < 0) {
                i7 = zzax.zza(b, bArr, i7, zzay);
                i8 = zzay.zzfd;
            }
            int i9 = (i8 == 1 ? 1 : 0) >>> 3;
            int i10 = (i8 == 1 ? 1 : 0) & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzl.zzmd.zzel()) {
                    zza = zza(bArr, i7, i2, zzl.zzmd, zzl.zzdu.getClass(), zzay);
                    eventLogTags2 = (V) zzay.zzff;
                }
            } else if (i10 == zzl.zzmb.zzel()) {
                zza = zza(bArr, i7, i2, zzl.zzmb, (Class<?>) null, zzay);
                eventLogTags = (K) zzay.zzff;
            }
            zza = zzax.zza(i8, bArr, i7, i2, zzay);
        }
        if (zza == i6) {
            zzg.put(eventLogTags, eventLogTags2);
            return i6;
        }
        throw zzco.zzbo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f2, code lost:
        if (r0 == r4) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x033a, code lost:
        if (r0 == r15) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0356, code lost:
        if (r0 == r15) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0358, code lost:
        r9 = r29;
        r8 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0372 A[ADDED_TO_REGION] */
    private final int zza(T t, byte[] bArr, int i, int i2, int i3, zzay zzay) throws IOException {
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        T t2;
        zzck<?> zzaf;
        byte b;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        zzay zzay2;
        int i17;
        long j;
        Object obj;
        zzay zzay3;
        int i18;
        zzds<T> zzds = this;
        T t3 = t;
        byte[] bArr2 = bArr;
        int i19 = i2;
        int i20 = i3;
        zzay zzay4 = zzay;
        Unsafe unsafe2 = zzmh;
        int i21 = -1;
        int i22 = i;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        while (true) {
            if (i22 < i19) {
                int i26 = i22 + 1;
                byte b2 = bArr2[i22];
                if (b2 < 0) {
                    i9 = zzax.zza(b2, bArr2, i26, zzay4);
                    b = zzay4.zzfd;
                } else {
                    b = b2;
                    i9 = i26;
                }
                int i27 = b >>> 3;
                int i28 = b & 7;
                int zzai = zzds.zzai(i27);
                if (zzai != i21) {
                    int[] iArr = zzds.zzmi;
                    int i29 = iArr[zzai + 1];
                    int i30 = (i29 & 267386880) >>> 20;
                    long j2 = (long) (i29 & 1048575);
                    if (i30 <= 17) {
                        int i31 = iArr[zzai + 2];
                        int i32 = 1 << (i31 >>> 20);
                        int i33 = i31 & 1048575;
                        if (i33 != i23) {
                            if (i23 != -1) {
                                unsafe2.putInt(t3, (long) i23, i25);
                            }
                            i25 = unsafe2.getInt(t3, (long) i33);
                            i23 = i33;
                        }
                        switch (i30) {
                            case 0:
                                i6 = b;
                                zzay2 = zzay;
                                i16 = i9;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 1) {
                                    zzfd.zza(t3, j2, zzax.zze(bArr2, i16));
                                    i22 = i16 + 8;
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4 && i4 != 0) {
                                    i7 = i23;
                                    i8 = -1;
                                    i5 = i10;
                                    break;
                                } else {
                                    i22 = zza(i6, bArr, i10, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i19 = i2;
                                    i20 = i4;
                                    i24 = i6;
                                    unsafe2 = unsafe;
                                    i21 = -1;
                                    zzay4 = zzay;
                                    break;
                                }
                            case 1:
                                i6 = b;
                                zzay2 = zzay;
                                i16 = i9;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 5) {
                                    zzfd.zza((Object) t3, j2, zzax.zzf(bArr2, i16));
                                    i22 = i16 + 4;
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 2:
                            case 3:
                                i6 = b;
                                i16 = i9;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    int zzb = zzax.zzb(bArr2, i16, zzay);
                                    unsafe2.putLong(t, j2, zzay.zzfe);
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay;
                                    i22 = zzb;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 4:
                            case 11:
                                i6 = b;
                                zzay2 = zzay;
                                i16 = i9;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i22 = zzax.zza(bArr2, i16, zzay2);
                                    unsafe2.putInt(t3, j2, zzay2.zzfd);
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 5:
                            case 14:
                                i6 = b;
                                zzay2 = zzay;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 1) {
                                    unsafe2.putLong(t, j2, zzax.zzd(bArr2, i9));
                                    i22 = i9 + 8;
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 6:
                            case 13:
                                i6 = b;
                                i17 = i2;
                                zzay2 = zzay;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 5) {
                                    unsafe2.putInt(t3, j2, zzax.zzc(bArr2, i9));
                                    i22 = i9 + 4;
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i17;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 7:
                                i6 = b;
                                i17 = i2;
                                zzay2 = zzay;
                                i15 = i23;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i22 = zzax.zzb(bArr2, i9, zzay2);
                                    zzfd.zza(t3, j2, zzay2.zzfe != 0);
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i17;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 8:
                                i6 = b;
                                i17 = i2;
                                zzay2 = zzay;
                                i15 = i23;
                                j = j2;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    i22 = (i29 & PKIFailureInfo.duplicateCertReq) == 0 ? zzax.zzc(bArr2, i9, zzay2) : zzax.zzd(bArr2, i9, zzay2);
                                    obj = zzay2.zzff;
                                    unsafe2.putObject(t3, j, obj);
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i17;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 9:
                                i6 = b;
                                zzay2 = zzay;
                                i15 = i23;
                                j = j2;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    i17 = i2;
                                    i22 = zza(zzds.zzad(zzai), bArr2, i9, i17, zzay2);
                                    obj = (i25 & i32) == 0 ? zzay2.zzff : zzci.zza(unsafe2.getObject(t3, j), zzay2.zzff);
                                    unsafe2.putObject(t3, j, obj);
                                    i25 |= i32;
                                    i23 = i15;
                                    i19 = i17;
                                    i24 = i6;
                                    zzay4 = zzay2;
                                    i21 = -1;
                                    i20 = i3;
                                    break;
                                } else {
                                    i16 = i9;
                                    i23 = i15;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    if (i6 != i4) {
                                    }
                                    i22 = zza(i6, bArr, i10, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i19 = i2;
                                    i20 = i4;
                                    i24 = i6;
                                    unsafe2 = unsafe;
                                    i21 = -1;
                                    zzay4 = zzay;
                                    break;
                                }
                                break;
                            case 10:
                                i6 = b;
                                zzay3 = zzay;
                                i21 = -1;
                                bArr2 = bArr;
                                if (i28 == 2) {
                                    i18 = zzax.zze(bArr2, i9, zzay3);
                                    unsafe2.putObject(t3, j2, zzay3.zzff);
                                    i25 |= i32;
                                    i19 = i2;
                                    i22 = i18;
                                    i24 = i6;
                                    zzay4 = zzay3;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i15 = i23;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 12:
                                i6 = b;
                                zzay3 = zzay;
                                i21 = -1;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i22 = zzax.zza(bArr2, i9, zzay3);
                                    int i34 = zzay3.zzfd;
                                    zzck<?> zzaf2 = zzds.zzaf(zzai);
                                    if (zzaf2 == null || zzaf2.zzb(i34) != null) {
                                        unsafe2.putInt(t3, j2, i34);
                                        i25 |= i32;
                                    } else {
                                        zzn(t).zzb(i6, Long.valueOf((long) i34));
                                    }
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay3;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i15 = i23;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 15:
                                i6 = b;
                                zzay3 = zzay;
                                i21 = -1;
                                bArr2 = bArr;
                                if (i28 == 0) {
                                    i18 = zzax.zza(bArr2, i9, zzay3);
                                    unsafe2.putInt(t3, j2, zzbk.zzm(zzay3.zzfd));
                                    i25 |= i32;
                                    i19 = i2;
                                    i22 = i18;
                                    i24 = i6;
                                    zzay4 = zzay3;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i15 = i23;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 16:
                                i6 = b;
                                i21 = -1;
                                if (i28 == 0) {
                                    bArr2 = bArr;
                                    int zzb2 = zzax.zzb(bArr2, i9, zzay);
                                    unsafe2.putLong(t, j2, zzbk.zza(zzay.zzfe));
                                    i25 |= i32;
                                    i24 = i6;
                                    zzay4 = zzay;
                                    i22 = zzb2;
                                    i19 = i2;
                                    i20 = i3;
                                    break;
                                }
                                i16 = i9;
                                i15 = i23;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                            case 17:
                                if (i28 == 3) {
                                    i6 = b;
                                    i21 = -1;
                                    i22 = zza(zzds.zzad(zzai), bArr, i9, i2, (i27 << 3) | 4, zzay);
                                    zzay3 = zzay;
                                    unsafe2.putObject(t3, j2, (i25 & i32) == 0 ? zzay3.zzff : zzci.zza(unsafe2.getObject(t3, j2), zzay3.zzff));
                                    i25 |= i32;
                                    bArr2 = bArr;
                                    i19 = i2;
                                    i24 = i6;
                                    zzay4 = zzay3;
                                    i20 = i3;
                                    break;
                                } else {
                                    i6 = b;
                                    i16 = i9;
                                    i15 = i23;
                                    i23 = i15;
                                    i4 = i3;
                                    i10 = i16;
                                    unsafe = unsafe2;
                                    if (i6 != i4) {
                                    }
                                    i22 = zza(i6, bArr, i10, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i19 = i2;
                                    i20 = i4;
                                    i24 = i6;
                                    unsafe2 = unsafe;
                                    i21 = -1;
                                    zzay4 = zzay;
                                    break;
                                }
                                break;
                            default:
                                i6 = b;
                                i16 = i9;
                                i15 = i23;
                                i23 = i15;
                                i4 = i3;
                                i10 = i16;
                                unsafe = unsafe2;
                                if (i6 != i4) {
                                }
                                i22 = zza(i6, bArr, i10, i2, t, zzay);
                                zzds = this;
                                t3 = t;
                                bArr2 = bArr;
                                i19 = i2;
                                i20 = i4;
                                i24 = i6;
                                unsafe2 = unsafe;
                                i21 = -1;
                                zzay4 = zzay;
                                break;
                        }
                    } else {
                        i12 = i23;
                        bArr2 = bArr;
                        if (i30 != 27) {
                            i11 = i25;
                            if (i30 <= 49) {
                                i13 = b;
                                unsafe = unsafe2;
                                i22 = zza(t, bArr, i9, i2, b, i27, i28, zzai, (long) i29, i30, j2, zzay);
                            } else {
                                i14 = i9;
                                i13 = b;
                                unsafe = unsafe2;
                                if (i30 == 50) {
                                    if (i28 == 2) {
                                        i22 = zza(t, bArr, i14, i2, zzai, i27, j2, zzay);
                                    }
                                    i6 = i13;
                                    i4 = i3;
                                    i10 = i14;
                                    i23 = i12;
                                    i25 = i11;
                                    if (i6 != i4) {
                                    }
                                    i22 = zza(i6, bArr, i10, i2, t, zzay);
                                    zzds = this;
                                    t3 = t;
                                    bArr2 = bArr;
                                    i19 = i2;
                                    i20 = i4;
                                    i24 = i6;
                                    unsafe2 = unsafe;
                                    i21 = -1;
                                    zzay4 = zzay;
                                } else {
                                    i22 = zza(t, bArr, i14, i2, i13, i27, i28, i29, i30, j2, zzai, zzay);
                                }
                            }
                            zzds = this;
                            t3 = t;
                            bArr2 = bArr;
                            i24 = i13;
                            i19 = i2;
                            i20 = i3;
                            zzay4 = zzay;
                            i23 = i12;
                            i25 = i11;
                            unsafe2 = unsafe;
                            i21 = -1;
                        } else if (i28 == 2) {
                            zzcn zzcn = (zzcn) unsafe2.getObject(t3, j2);
                            if (!zzcn.zzu()) {
                                int size = zzcn.size();
                                zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j2, zzcn);
                            }
                            zzef zzad = zzds.zzad(zzai);
                            i24 = b;
                            i22 = zza(zzad, i24, bArr, i9, i2, zzcn, zzay);
                            i19 = i2;
                            i20 = i3;
                            i23 = i12;
                            i25 = i25;
                            i21 = -1;
                            zzay4 = zzay;
                        } else {
                            i11 = i25;
                            i14 = i9;
                            i13 = b;
                        }
                    }
                } else {
                    i14 = i9;
                    i13 = b;
                    i11 = i25;
                    i12 = i23;
                }
                unsafe = unsafe2;
                i6 = i13;
                i4 = i3;
                i10 = i14;
                i23 = i12;
                i25 = i11;
                if (i6 != i4) {
                }
                i22 = zza(i6, bArr, i10, i2, t, zzay);
                zzds = this;
                t3 = t;
                bArr2 = bArr;
                i19 = i2;
                i20 = i4;
                i24 = i6;
                unsafe2 = unsafe;
                i21 = -1;
                zzay4 = zzay;
            } else {
                unsafe = unsafe2;
                i4 = i20;
                i5 = i22;
                i6 = i24;
                i7 = i23;
                i8 = -1;
            }
        }
        if (i7 != i8) {
            t2 = t;
            unsafe.putInt(t2, (long) i7, i25);
        } else {
            t2 = t;
        }
        int[] iArr2 = this.zzmt;
        if (iArr2 != null) {
            Object obj2 = null;
            for (int i35 : iArr2) {
                zzex<UT, UB> zzex = (zzex<UT, UB>) this.zzmx;
                int i36 = this.zzmi[i35];
                Object zzo = zzfd.zzo(t2, (long) (zzag(i35) & 1048575));
                if (!(zzo == null || (zzaf = zzaf(i35)) == null)) {
                    obj2 = zza(i35, i36, (Map<K, V>) this.zzmz.zzg(zzo), zzaf, obj2, zzex);
                }
                obj2 = (zzey) obj2;
            }
            if (obj2 != null) {
                this.zzmx.zzf(t2, obj2);
            }
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw zzco.zzbo();
            }
        } else if (i5 > i2 || i6 != i4) {
            throw zzco.zzbo();
        }
        return i5;
    }

    private static int zza(byte[] bArr, int i, int i2, zzfl zzfl, Class<?> cls, zzay zzay) throws IOException {
        int zzb;
        Object valueOf;
        Object obj;
        Object obj2;
        int i3;
        long j;
        switch (zzdt.zzgq[zzfl.ordinal()]) {
            case 1:
                zzb = zzax.zzb(bArr, i, zzay);
                valueOf = Boolean.valueOf(zzay.zzfe != 0);
                zzay.zzff = valueOf;
                return zzb;
            case 2:
                return zzax.zze(bArr, i, zzay);
            case 3:
                obj = Double.valueOf(zzax.zze(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case 4:
            case 5:
                obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 6:
            case 7:
                obj = Long.valueOf(zzax.zzd(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case 8:
                obj2 = Float.valueOf(zzax.zzf(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 9:
            case 10:
            case 11:
                zzb = zzax.zza(bArr, i, zzay);
                i3 = zzay.zzfd;
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case 12:
            case 13:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzay.zzfe;
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 14:
                return zza((zzef) zzea.zzcm().zze(cls), bArr, i, i2, zzay);
            case 15:
                zzb = zzax.zza(bArr, i, zzay);
                i3 = zzbk.zzm(zzay.zzfd);
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case 16:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzbk.zza(zzay.zzfe);
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 17:
                return zzax.zzd(bArr, i, zzay);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    static <T> zzds<T> zza(Class<T> cls, zzdm zzdm, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (zzdm instanceof zzec) {
            zzec zzec = (zzec) zzdm;
            boolean z = zzec.zzcf() == zzcg.zzg.zzkm;
            if (zzec.getFieldCount() == 0) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                int zzcp = zzec.zzcp();
                int zzcq = zzec.zzcq();
                i3 = zzec.zzcu();
                i2 = zzcp;
                i = zzcq;
            }
            int[] iArr = new int[(i3 << 2)];
            Object[] objArr = new Object[(i3 << 1)];
            int[] iArr2 = zzec.zzcr() > 0 ? new int[zzec.zzcr()] : null;
            int[] iArr3 = zzec.zzcs() > 0 ? new int[zzec.zzcs()] : null;
            zzed zzco = zzec.zzco();
            if (zzco.next()) {
                int zzcx = zzco.zzcx();
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (zzcx >= zzec.zzcv() || i7 >= ((zzcx - i2) << 2)) {
                        if (zzco.zzda()) {
                            i6 = (int) zzfd.zza(zzco.zzdb());
                            i5 = (int) zzfd.zza(zzco.zzdc());
                            i4 = 0;
                        } else {
                            i6 = (int) zzfd.zza(zzco.zzdd());
                            if (zzco.zzde()) {
                                i5 = (int) zzfd.zza(zzco.zzdf());
                                i4 = zzco.zzdg();
                            } else {
                                i5 = 0;
                                i4 = 0;
                            }
                        }
                        iArr[i7] = zzco.zzcx();
                        int i10 = i7 + 1;
                        iArr[i10] = (zzco.zzdi() ? PKIFailureInfo.duplicateCertReq : 0) | (zzco.zzdh() ? 268435456 : 0) | (zzco.zzcy() << 20) | i6;
                        iArr[i7 + 2] = i5 | (i4 << 20);
                        if (zzco.zzdl() != null) {
                            int i11 = (i7 / 4) << 1;
                            objArr[i11] = zzco.zzdl();
                            if (zzco.zzdj() != null) {
                                objArr[i11 + 1] = zzco.zzdj();
                            } else if (zzco.zzdk() != null) {
                                objArr[i11 + 1] = zzco.zzdk();
                            }
                        } else if (zzco.zzdj() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdj();
                        } else if (zzco.zzdk() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdk();
                        }
                        int zzcy2 = zzco.zzcy();
                        if (zzcy2 == zzcb.MAP.ordinal()) {
                            iArr2[i8] = i7;
                            i8++;
                        } else if (zzcy2 >= 18 && zzcy2 <= 49) {
                            iArr3[i9] = iArr[i10] & 1048575;
                            i9++;
                        }
                        if (!zzco.next()) {
                            break;
                        }
                        zzcx = zzco.zzcx();
                    } else {
                        for (int i12 = 0; i12 < 4; i12++) {
                            iArr[i7 + i12] = -1;
                        }
                    }
                    i7 += 4;
                }
            }
            return new zzds<>(iArr, objArr, i2, i, zzec.zzcv(), zzec.zzch(), z, false, zzec.zzct(), iArr2, iArr3, zzdw, zzcy, zzex, zzbu, zzdj);
        }
        ((zzes) zzdm).zzcf();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzck, UB ub, zzex<UT, UB> zzex) {
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (zzck.zzb(next.getValue().intValue()) == null) {
                if (ub == null) {
                    ub = zzex.zzdz();
                }
                zzbg zzk = zzbb.zzk(zzdg.zza(zzl, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzk.zzae(), zzl, next.getKey(), next.getValue());
                    zzex.zza(ub, i2, zzk.zzad());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfr) throws IOException {
        if (obj instanceof String) {
            zzfr.zza(i, (String) obj);
        } else {
            zzfr.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzex, T t, zzfr zzfr) throws IOException {
        zzex.zza(zzex.zzq(t), zzfr);
    }

    private final <K, V> void zza(zzfr zzfr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfr.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzfd.zzo(t, zzag);
            Object zzo2 = zzfd.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, zzag, zzci.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzmq) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzfd.zzn(t, j) != 0.0d;
                case 1:
                    return zzfd.zzm(t, j) != 0.0f;
                case 2:
                    return zzfd.zzk(t, j) != 0;
                case 3:
                    return zzfd.zzk(t, j) != 0;
                case 4:
                    return zzfd.zzj(t, j) != 0;
                case 5:
                    return zzfd.zzk(t, j) != 0;
                case 6:
                    return zzfd.zzj(t, j) != 0;
                case 7:
                    return zzfd.zzl(t, j);
                case 8:
                    Object zzo = zzfd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzbb) {
                        return !zzbb.zzfi.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfd.zzo(t, j) != null;
                case 10:
                    return !zzbb.zzfi.equals(zzfd.zzo(t, j));
                case 11:
                    return zzfd.zzj(t, j) != 0;
                case 12:
                    return zzfd.zzj(t, j) != 0;
                case 13:
                    return zzfd.zzj(t, j) != 0;
                case 14:
                    return zzfd.zzk(t, j) != 0;
                case 15:
                    return zzfd.zzj(t, j) != 0;
                case 16:
                    return zzfd.zzk(t, j) != 0;
                case 17:
                    return zzfd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzfd.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza(t, i) : (i2 & i3) != 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.android.gms.internal.clearcut.zzef */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean zza(Object obj, int i, zzef zzef) {
        return zzef.zzo(zzfd.zzo(obj, (long) (i & 1048575)));
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzef = (zzef) this.zzmj[i2];
        if (zzef != null) {
            return zzef;
        }
        zzef<T> zze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zze;
        return zze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            } else if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (!this.zzmq) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    private final void zzb(T t, zzfr zzfr) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        int i2;
        int i3;
        if (this.zzmo) {
            zzby<?> zza = this.zzmy.zza((Object) t);
            if (!zza.isEmpty()) {
                it = zza.iterator();
                entry = it.next();
                int i4 = -1;
                length = this.zzmi.length;
                Unsafe unsafe = zzmh;
                int i5 = 0;
                for (i = 0; i < length; i = i2 + 4) {
                    int zzag = zzag(i);
                    int[] iArr = this.zzmi;
                    int i6 = iArr[i];
                    int i7 = (267386880 & zzag) >>> 20;
                    if (this.zzmq || i7 > 17) {
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
                    while (entry != null && this.zzmy.zza(entry) <= i6) {
                        this.zzmy.zza(zzfr, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    long j = (long) (zzag & 1048575);
                    switch (i7) {
                        case 0:
                            if ((i3 & i5) != 0) {
                                zzfr.zza(i6, zzfd.zzn(t, j));
                                continue;
                            }
                        case 1:
                            if ((i3 & i5) != 0) {
                                zzfr.zza(i6, zzfd.zzm(t, j));
                            } else {
                                continue;
                            }
                        case 2:
                            if ((i3 & i5) != 0) {
                                zzfr.zzi(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 3:
                            if ((i3 & i5) != 0) {
                                zzfr.zza(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 4:
                            if ((i3 & i5) != 0) {
                                zzfr.zzc(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 5:
                            if ((i3 & i5) != 0) {
                                zzfr.zzc(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 6:
                            if ((i3 & i5) != 0) {
                                zzfr.zzf(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 7:
                            if ((i3 & i5) != 0) {
                                zzfr.zzb(i6, zzfd.zzl(t, j));
                            } else {
                                continue;
                            }
                        case 8:
                            if ((i3 & i5) != 0) {
                                zza(i6, unsafe.getObject(t, j), zzfr);
                            } else {
                                continue;
                            }
                        case 9:
                            if ((i3 & i5) != 0) {
                                zzfr.zza(i6, unsafe.getObject(t, j), zzad(i2));
                            } else {
                                continue;
                            }
                        case 10:
                            if ((i3 & i5) != 0) {
                                zzfr.zza(i6, (zzbb) unsafe.getObject(t, j));
                            } else {
                                continue;
                            }
                        case 11:
                            if ((i3 & i5) != 0) {
                                zzfr.zzd(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 12:
                            if ((i3 & i5) != 0) {
                                zzfr.zzn(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 13:
                            if ((i3 & i5) != 0) {
                                zzfr.zzm(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 14:
                            if ((i3 & i5) != 0) {
                                zzfr.zzj(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 15:
                            if ((i3 & i5) != 0) {
                                zzfr.zze(i6, unsafe.getInt(t, j));
                            } else {
                                continue;
                            }
                        case 16:
                            if ((i3 & i5) != 0) {
                                zzfr.zzb(i6, unsafe.getLong(t, j));
                            } else {
                                continue;
                            }
                        case 17:
                            if ((i3 & i5) != 0) {
                                zzfr.zzb(i6, unsafe.getObject(t, j), zzad(i2));
                            } else {
                                continue;
                            }
                        case 18:
                            zzeh.zza(this.zzmi[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzfr, false);
                            continue;
                        case 19:
                            zzeh.zzb(this.zzmi[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzfr, false);
                            continue;
                        case 20:
                            zzeh.zzc(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 21:
                            zzeh.zzd(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 22:
                            zzeh.zzh(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 23:
                            zzeh.zzf(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 24:
                            zzeh.zzk(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 25:
                            zzeh.zzn(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 26:
                            zzeh.zza(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr);
                            break;
                        case 27:
                            zzeh.zza(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, zzad(i2));
                            break;
                        case 28:
                            zzeh.zzb(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr);
                            break;
                        case 29:
                            zzeh.zzi(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 30:
                            zzeh.zzm(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 31:
                            zzeh.zzl(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 32:
                            zzeh.zzg(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 33:
                            zzeh.zzj(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 34:
                            zzeh.zze(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, false);
                            continue;
                        case 35:
                            zzeh.zza(this.zzmi[i2], (List<Double>) ((List) unsafe.getObject(t, j)), zzfr, true);
                            break;
                        case 36:
                            zzeh.zzb(this.zzmi[i2], (List<Float>) ((List) unsafe.getObject(t, j)), zzfr, true);
                            break;
                        case 37:
                            zzeh.zzc(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 38:
                            zzeh.zzd(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 39:
                            zzeh.zzh(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 40:
                            zzeh.zzf(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 41:
                            zzeh.zzk(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 42:
                            zzeh.zzn(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 43:
                            zzeh.zzi(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 44:
                            zzeh.zzm(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 45:
                            zzeh.zzl(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 46:
                            zzeh.zzg(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 47:
                            zzeh.zzj(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 48:
                            zzeh.zze(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, true);
                            break;
                        case 49:
                            zzeh.zzb(this.zzmi[i2], (List) unsafe.getObject(t, j), zzfr, zzad(i2));
                            break;
                        case 50:
                            zza(zzfr, i6, unsafe.getObject(t, j), i2);
                            break;
                        case 51:
                            if (zza(t, i6, i2)) {
                                zzfr.zza(i6, zze(t, j));
                                break;
                            }
                            break;
                        case 52:
                            if (zza(t, i6, i2)) {
                                zzfr.zza(i6, zzf(t, j));
                                break;
                            }
                            break;
                        case 53:
                            if (zza(t, i6, i2)) {
                                zzfr.zzi(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 54:
                            if (zza(t, i6, i2)) {
                                zzfr.zza(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 55:
                            if (zza(t, i6, i2)) {
                                zzfr.zzc(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 56:
                            if (zza(t, i6, i2)) {
                                zzfr.zzc(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 57:
                            if (zza(t, i6, i2)) {
                                zzfr.zzf(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 58:
                            if (zza(t, i6, i2)) {
                                zzfr.zzb(i6, zzi(t, j));
                                break;
                            }
                            break;
                        case 59:
                            if (zza(t, i6, i2)) {
                                zza(i6, unsafe.getObject(t, j), zzfr);
                                break;
                            }
                            break;
                        case 60:
                            if (zza(t, i6, i2)) {
                                zzfr.zza(i6, unsafe.getObject(t, j), zzad(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (zza(t, i6, i2)) {
                                zzfr.zza(i6, (zzbb) unsafe.getObject(t, j));
                                break;
                            }
                            break;
                        case 62:
                            if (zza(t, i6, i2)) {
                                zzfr.zzd(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 63:
                            if (zza(t, i6, i2)) {
                                zzfr.zzn(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 64:
                            if (zza(t, i6, i2)) {
                                zzfr.zzm(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 65:
                            if (zza(t, i6, i2)) {
                                zzfr.zzj(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 66:
                            if (zza(t, i6, i2)) {
                                zzfr.zze(i6, zzg(t, j));
                                break;
                            }
                            break;
                        case 67:
                            if (zza(t, i6, i2)) {
                                zzfr.zzb(i6, zzh(t, j));
                                break;
                            }
                            break;
                        case 68:
                            if (zza(t, i6, i2)) {
                                zzfr.zzb(i6, unsafe.getObject(t, j), zzad(i2));
                                break;
                            }
                            break;
                    }
                }
                while (entry != null) {
                    this.zzmy.zza(zzfr, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                zza(this.zzmx, t, zzfr);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.zzmi.length;
        Unsafe unsafe2 = zzmh;
        int i52 = 0;
        while (i < length) {
        }
        while (entry != null) {
        }
        zza(this.zzmx, t, zzfr);
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzfd.zzo(t, j);
            Object zzo2 = zzfd.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, j, zzci.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcg = (zzcg) obj;
        zzey zzey = zzcg.zzjp;
        if (zzey != zzey.zzea()) {
            return zzey;
        }
        zzey zzeb = zzey.zzeb();
        zzcg.zzjp = zzeb;
        return zzeb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean equals(T t, T t2) {
        int length = this.zzmi.length;
        int i = 0;
        while (true) {
            boolean z = true;
            if (i < length) {
                int zzag = zzag(i);
                long j = (long) (zzag & 1048575);
                switch ((zzag & 267386880) >>> 20) {
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
                    case 50:
                        z = zzeh.zzd(zzfd.zzo(t, j), zzfd.zzo(t2, j));
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
                        long zzah = (long) (zzah(i) & 1048575);
                        if (zzfd.zzj(t, zzah) == zzfd.zzj(t2, zzah)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i += 4;
            } else if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
                return false;
            } else {
                if (this.zzmo) {
                    return this.zzmy.zza((Object) t).equals(this.zzmy.zza((Object) t2));
                }
                return true;
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int hashCode(T t) {
        int i;
        int i2;
        long j;
        double d;
        float f;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.zzmi.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 4) {
            int zzag = zzag(i4);
            int i5 = this.zzmi[i4];
            long j2 = (long) (1048575 & zzag);
            int i6 = 37;
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    d = zzfd.zzn(t, j2);
                    j = Double.doubleToLongBits(d);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    f = zzfd.zzm(t, j2);
                    i = Float.floatToIntBits(f);
                    i3 = i2 + i;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i2 = i3 * 53;
                    j = zzfd.zzk(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i2 = i3 * 53;
                    i = zzfd.zzj(t, j2);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    z = zzfd.zzl(t, j2);
                    i = zzci.zzc(z);
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzfd.zzo(t, j2)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    obj = zzfd.zzo(t, j2);
                    break;
                case 10:
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
                case 50:
                    i2 = i3 * 53;
                    obj2 = zzfd.zzo(t, j2);
                    i = obj2.hashCode();
                    i3 = i2 + i;
                    break;
                case 17:
                    obj = zzfd.zzo(t, j2);
                    break;
                case 51:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        d = zze(t, j2);
                        j = Double.doubleToLongBits(d);
                        i = zzci.zzl(j);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        f = zzf(t, j2);
                        i = Float.floatToIntBits(f);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 55:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 56:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 57:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 58:
                    if (zza(t, i5, i4)) {
                        i2 = i3 * 53;
                        z = zzi(t, j2);
                        i = zzci.zzc(z);
                        i3 = i2 + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = ((String) zzfd.zzo(t, j2)).hashCode();
                    i3 = i2 + i;
                    break;
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    obj2 = zzfd.zzo(t, j2);
                    i2 = i3 * 53;
                    i = obj2.hashCode();
                    i3 = i2 + i;
                    break;
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    obj2 = zzfd.zzo(t, j2);
                    i = obj2.hashCode();
                    i3 = i2 + i;
                    break;
                case 62:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 63:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 64:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 65:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 66:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    i = zzg(t, j2);
                    i3 = i2 + i;
                    break;
                case 67:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    i2 = i3 * 53;
                    j = zzh(t, j2);
                    i = zzci.zzl(j);
                    i3 = i2 + i;
                    break;
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    }
                    obj2 = zzfd.zzo(t, j2);
                    i2 = i3 * 53;
                    i = obj2.hashCode();
                    i3 = i2 + i;
                    break;
            }
        }
        int hashCode = (i3 * 53) + this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (hashCode * 53) + this.zzmy.zza((Object) t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return (T) this.zzmv.newInstance(this.zzmn);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0976  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, zzfr zzfr) throws IOException {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i;
        double d;
        float f;
        long j;
        long j2;
        int i2;
        long j3;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        long j4;
        int i7;
        long j5;
        Map.Entry<?, Object> entry2;
        Iterator<Map.Entry<?, Object>> it2;
        int length2;
        double d2;
        float f2;
        long j6;
        long j7;
        int i8;
        long j8;
        int i9;
        boolean z2;
        int i10;
        int i11;
        int i12;
        long j9;
        int i13;
        long j10;
        if (zzfr.zzaj() == zzcg.zzg.zzkp) {
            zza(this.zzmx, t, zzfr);
            if (this.zzmo) {
                zzby<?> zza = this.zzmy.zza((Object) t);
                if (!zza.isEmpty()) {
                    it2 = zza.descendingIterator();
                    entry2 = it2.next();
                    for (length2 = this.zzmi.length - 4; length2 >= 0; length2 -= 4) {
                        int zzag = zzag(length2);
                        int i14 = this.zzmi[length2];
                        while (entry2 != null && this.zzmy.zza(entry2) > i14) {
                            this.zzmy.zza(zzfr, entry2);
                            entry2 = it2.hasNext() ? it2.next() : null;
                        }
                        switch ((zzag & 267386880) >>> 20) {
                            case 0:
                                if (zza(t, length2)) {
                                    d2 = zzfd.zzn(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza(t, length2)) {
                                    f2 = zzfd.zzm(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza(t, length2)) {
                                    j6 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzi(i14, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza(t, length2)) {
                                    j7 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, j7);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza(t, length2)) {
                                    i8 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza(t, length2)) {
                                    j8 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, j8);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza(t, length2)) {
                                    i9 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzf(i14, i9);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza(t, length2)) {
                                    z2 = zzfd.zzl(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, z2);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 9:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 10:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, (zzbb) zzfd.zzo(t, (long) (zzag & 1048575)));
                                break;
                            case 11:
                                if (zza(t, length2)) {
                                    i10 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzd(i14, i10);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza(t, length2)) {
                                    i11 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzn(i14, i11);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza(t, length2)) {
                                    i12 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zzm(i14, i12);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza(t, length2)) {
                                    j9 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzj(i14, j9);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza(t, length2)) {
                                    i13 = zzfd.zzj(t, (long) (zzag & 1048575));
                                    zzfr.zze(i14, i13);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza(t, length2)) {
                                    j10 = zzfd.zzk(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, j10);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!zza(t, length2)) {
                                    break;
                                }
                                zzfr.zzb(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 18:
                                zzeh.zza(this.zzmi[length2], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, false);
                                break;
                            case 19:
                                zzeh.zzb(this.zzmi[length2], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, false);
                                break;
                            case 20:
                                zzeh.zzc(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 21:
                                zzeh.zzd(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 22:
                                zzeh.zzh(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 23:
                                zzeh.zzf(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 24:
                                zzeh.zzk(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 25:
                                zzeh.zzn(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 26:
                                zzeh.zza(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 27:
                                zzeh.zza(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, zzad(length2));
                                break;
                            case 28:
                                zzeh.zzb(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 29:
                                zzeh.zzi(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 30:
                                zzeh.zzm(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 31:
                                zzeh.zzl(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 32:
                                zzeh.zzg(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 33:
                                zzeh.zzj(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 34:
                                zzeh.zze(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, false);
                                break;
                            case 35:
                                zzeh.zza(this.zzmi[length2], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, true);
                                break;
                            case 36:
                                zzeh.zzb(this.zzmi[length2], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag & 1048575))), zzfr, true);
                                break;
                            case 37:
                                zzeh.zzc(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 38:
                                zzeh.zzd(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 39:
                                zzeh.zzh(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 40:
                                zzeh.zzf(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 41:
                                zzeh.zzk(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 42:
                                zzeh.zzn(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 43:
                                zzeh.zzi(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 44:
                                zzeh.zzm(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 45:
                                zzeh.zzl(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 46:
                                zzeh.zzg(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 47:
                                zzeh.zzj(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 48:
                                zzeh.zze(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, true);
                                break;
                            case 49:
                                zzeh.zzb(this.zzmi[length2], (List) zzfd.zzo(t, (long) (zzag & 1048575)), zzfr, zzad(length2));
                                break;
                            case 50:
                                zza(zzfr, i14, zzfd.zzo(t, (long) (zzag & 1048575)), length2);
                                break;
                            case 51:
                                if (zza(t, i14, length2)) {
                                    d2 = zze(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i14, length2)) {
                                    f2 = zzf(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i14, length2)) {
                                    j6 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzi(i14, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i14, length2)) {
                                    j7 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zza(i14, j7);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i14, length2)) {
                                    i8 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i14, length2)) {
                                    j8 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzc(i14, j8);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i14, length2)) {
                                    i9 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzf(i14, i9);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i14, length2)) {
                                    z2 = zzi(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, z2);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzfr);
                                break;
                            case 60:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                            case 61:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zza(i14, (zzbb) zzfd.zzo(t, (long) (zzag & 1048575)));
                                break;
                            case 62:
                                if (zza(t, i14, length2)) {
                                    i10 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzd(i14, i10);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i14, length2)) {
                                    i11 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzn(i14, i11);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i14, length2)) {
                                    i12 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zzm(i14, i12);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i14, length2)) {
                                    j9 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzj(i14, j9);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i14, length2)) {
                                    i13 = zzg(t, (long) (zzag & 1048575));
                                    zzfr.zze(i14, i13);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i14, length2)) {
                                    j10 = zzh(t, (long) (zzag & 1048575));
                                    zzfr.zzb(i14, j10);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!zza(t, i14, length2)) {
                                    break;
                                }
                                zzfr.zzb(i14, zzfd.zzo(t, (long) (zzag & 1048575)), zzad(length2));
                                break;
                        }
                    }
                    while (entry2 != null) {
                        this.zzmy.zza(zzfr, entry2);
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
        } else if (this.zzmq) {
            if (this.zzmo) {
                zzby<?> zza2 = this.zzmy.zza((Object) t);
                if (!zza2.isEmpty()) {
                    it = zza2.iterator();
                    entry = it.next();
                    length = this.zzmi.length;
                    for (i = 0; i < length; i += 4) {
                        int zzag2 = zzag(i);
                        int i15 = this.zzmi[i];
                        while (entry != null && this.zzmy.zza(entry) <= i15) {
                            this.zzmy.zza(zzfr, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch ((zzag2 & 267386880) >>> 20) {
                            case 0:
                                if (zza(t, i)) {
                                    d = zzfd.zzn(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, d);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (zza(t, i)) {
                                    f = zzfd.zzm(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, f);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (zza(t, i)) {
                                    j = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzi(i15, j);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (zza(t, i)) {
                                    j2 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (zza(t, i)) {
                                    i2 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, i2);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (zza(t, i)) {
                                    j3 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (zza(t, i)) {
                                    i3 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzf(i15, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (zza(t, i)) {
                                    z = zzfd.zzl(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 9:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 10:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zza(i15, (zzbb) zzfd.zzo(t, (long) (zzag2 & 1048575)));
                                break;
                            case 11:
                                if (zza(t, i)) {
                                    i4 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzd(i15, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (zza(t, i)) {
                                    i5 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzn(i15, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (zza(t, i)) {
                                    i6 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zzm(i15, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (zza(t, i)) {
                                    j4 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzj(i15, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (zza(t, i)) {
                                    i7 = zzfd.zzj(t, (long) (zzag2 & 1048575));
                                    zzfr.zze(i15, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (zza(t, i)) {
                                    j5 = zzfd.zzk(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!zza(t, i)) {
                                    break;
                                }
                                zzfr.zzb(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 18:
                                zzeh.zza(this.zzmi[i], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, false);
                                break;
                            case 19:
                                zzeh.zzb(this.zzmi[i], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, false);
                                break;
                            case 20:
                                zzeh.zzc(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 21:
                                zzeh.zzd(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 22:
                                zzeh.zzh(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 23:
                                zzeh.zzf(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 24:
                                zzeh.zzk(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 25:
                                zzeh.zzn(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 26:
                                zzeh.zza(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 27:
                                zzeh.zza(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, zzad(i));
                                break;
                            case 28:
                                zzeh.zzb(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 29:
                                zzeh.zzi(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 30:
                                zzeh.zzm(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 31:
                                zzeh.zzl(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 32:
                                zzeh.zzg(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 33:
                                zzeh.zzj(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 34:
                                zzeh.zze(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, false);
                                break;
                            case 35:
                                zzeh.zza(this.zzmi[i], (List<Double>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, true);
                                break;
                            case 36:
                                zzeh.zzb(this.zzmi[i], (List<Float>) ((List) zzfd.zzo(t, (long) (zzag2 & 1048575))), zzfr, true);
                                break;
                            case 37:
                                zzeh.zzc(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 38:
                                zzeh.zzd(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 39:
                                zzeh.zzh(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 40:
                                zzeh.zzf(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 41:
                                zzeh.zzk(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 42:
                                zzeh.zzn(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 43:
                                zzeh.zzi(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 44:
                                zzeh.zzm(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 45:
                                zzeh.zzl(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 46:
                                zzeh.zzg(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 47:
                                zzeh.zzj(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 48:
                                zzeh.zze(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, true);
                                break;
                            case 49:
                                zzeh.zzb(this.zzmi[i], (List) zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr, zzad(i));
                                break;
                            case 50:
                                zza(zzfr, i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), i);
                                break;
                            case 51:
                                if (zza(t, i15, i)) {
                                    d = zze(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, d);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (zza(t, i15, i)) {
                                    f = zzf(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, f);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (zza(t, i15, i)) {
                                    j = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzi(i15, j);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (zza(t, i15, i)) {
                                    j2 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zza(i15, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (zza(t, i15, i)) {
                                    i2 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, i2);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (zza(t, i15, i)) {
                                    j3 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzc(i15, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (zza(t, i15, i)) {
                                    i3 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzf(i15, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (zza(t, i15, i)) {
                                    z = zzi(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzfr);
                                break;
                            case 60:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zza(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                            case 61:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zza(i15, (zzbb) zzfd.zzo(t, (long) (zzag2 & 1048575)));
                                break;
                            case 62:
                                if (zza(t, i15, i)) {
                                    i4 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzd(i15, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (zza(t, i15, i)) {
                                    i5 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzn(i15, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (zza(t, i15, i)) {
                                    i6 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zzm(i15, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (zza(t, i15, i)) {
                                    j4 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzj(i15, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (zza(t, i15, i)) {
                                    i7 = zzg(t, (long) (zzag2 & 1048575));
                                    zzfr.zze(i15, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (zza(t, i15, i)) {
                                    j5 = zzh(t, (long) (zzag2 & 1048575));
                                    zzfr.zzb(i15, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!zza(t, i15, i)) {
                                    break;
                                }
                                zzfr.zzb(i15, zzfd.zzo(t, (long) (zzag2 & 1048575)), zzad(i));
                                break;
                        }
                    }
                    while (entry != null) {
                        this.zzmy.zza(zzfr, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    zza(this.zzmx, t, zzfr);
                }
            }
            it = null;
            entry = null;
            length = this.zzmi.length;
            while (i < length) {
            }
            while (entry != null) {
            }
            zza(this.zzmx, t, zzfr);
        } else {
            zzb(t, zzfr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0164, code lost:
        if (r0 == r10) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0188, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a1, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        byte b;
        int i3;
        Unsafe unsafe;
        int i4;
        int i5;
        int i6;
        long j;
        Object zza;
        zzds<T> zzds = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i7 = i2;
        zzay zzay2 = zzay;
        if (zzds.zzmq) {
            Unsafe unsafe2 = zzmh;
            int i8 = i;
            while (i8 < i7) {
                int i9 = i8 + 1;
                byte b2 = bArr2[i8];
                if (b2 < 0) {
                    i3 = zzax.zza(b2, bArr2, i9, zzay2);
                    b = zzay2.zzfd;
                } else {
                    b = b2;
                    i3 = i9;
                }
                int i10 = b >>> 3;
                int i11 = b & 7;
                int zzai = zzds.zzai(i10);
                if (zzai >= 0) {
                    int i12 = zzds.zzmi[zzai + 1];
                    int i13 = (267386880 & i12) >>> 20;
                    long j2 = (long) (1048575 & i12);
                    if (i13 <= 17) {
                        boolean z = true;
                        switch (i13) {
                            case 0:
                                if (i11 == 1) {
                                    zzfd.zza(t2, j2, zzax.zze(bArr2, i3));
                                    i8 = i3 + 8;
                                    break;
                                }
                                break;
                            case 1:
                                if (i11 == 5) {
                                    zzfd.zza((Object) t2, j2, zzax.zzf(bArr2, i3));
                                    i8 = i3 + 4;
                                    break;
                                }
                                break;
                            case 2:
                            case 3:
                                if (i11 == 0) {
                                    i6 = zzax.zzb(bArr2, i3, zzay2);
                                    j = zzay2.zzfe;
                                    unsafe2.putLong(t, j2, j);
                                    i8 = i6;
                                    break;
                                }
                                break;
                            case 5:
                            case 14:
                                if (i11 == 1) {
                                    unsafe2.putLong(t, j2, zzax.zzd(bArr2, i3));
                                    i8 = i3 + 8;
                                    break;
                                }
                                break;
                            case 6:
                            case 13:
                                if (i11 == 5) {
                                    unsafe2.putInt(t2, j2, zzax.zzc(bArr2, i3));
                                    i8 = i3 + 4;
                                    break;
                                }
                                break;
                            case 7:
                                if (i11 == 0) {
                                    i8 = zzax.zzb(bArr2, i3, zzay2);
                                    if (zzay2.zzfe == 0) {
                                        z = false;
                                    }
                                    zzfd.zza(t2, j2, z);
                                    break;
                                }
                                break;
                            case 8:
                                if (i11 == 2) {
                                    i8 = (536870912 & i12) == 0 ? zzax.zzc(bArr2, i3, zzay2) : zzax.zzd(bArr2, i3, zzay2);
                                    zza = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza);
                                    break;
                                }
                                break;
                            case 9:
                                if (i11 == 2) {
                                    i8 = zza(zzds.zzad(zzai), bArr2, i3, i7, zzay2);
                                    Object object = unsafe2.getObject(t2, j2);
                                    if (object != null) {
                                        zza = zzci.zza(object, zzay2.zzff);
                                        unsafe2.putObject(t2, j2, zza);
                                        break;
                                    }
                                    zza = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza);
                                }
                                break;
                            case 10:
                                if (i11 == 2) {
                                    i8 = zzax.zze(bArr2, i3, zzay2);
                                    zza = zzay2.zzff;
                                    unsafe2.putObject(t2, j2, zza);
                                    break;
                                }
                                break;
                            case 15:
                                if (i11 == 0) {
                                    i8 = zzax.zza(bArr2, i3, zzay2);
                                    int i14 = zzbk.zzm(zzay2.zzfd);
                                    unsafe2.putInt(t2, j2, i14);
                                    break;
                                }
                                break;
                            case 16:
                                if (i11 == 0) {
                                    i6 = zzax.zzb(bArr2, i3, zzay2);
                                    j = zzbk.zza(zzay2.zzfe);
                                    unsafe2.putLong(t, j2, j);
                                    i8 = i6;
                                    break;
                                }
                                break;
                        }
                    } else if (i13 != 27) {
                        if (i13 <= 49) {
                            unsafe = unsafe2;
                            i8 = zza(t, bArr, i3, i2, b, i10, i11, zzai, (long) i12, i13, j2, zzay);
                        } else {
                            unsafe = unsafe2;
                            i5 = i3;
                            if (i13 == 50) {
                                if (i11 == 2) {
                                    i8 = zza(t, bArr, i5, i2, zzai, i10, j2, zzay);
                                }
                                i4 = i5;
                                i8 = zza(b, bArr, i4, i2, t, zzay);
                                zzds = this;
                                t2 = t;
                                bArr2 = bArr;
                                i7 = i2;
                                zzay2 = zzay;
                                unsafe2 = unsafe;
                            } else {
                                i8 = zza(t, bArr, i5, i2, b, i10, i11, i12, i13, j2, zzai, zzay);
                            }
                        }
                        i4 = i8;
                        i8 = zza(b, bArr, i4, i2, t, zzay);
                        zzds = this;
                        t2 = t;
                        bArr2 = bArr;
                        i7 = i2;
                        zzay2 = zzay;
                        unsafe2 = unsafe;
                    } else if (i11 == 2) {
                        zzcn zzcn = (zzcn) unsafe2.getObject(t2, j2);
                        if (!zzcn.zzu()) {
                            int size = zzcn.size();
                            zzcn = zzcn.zzi(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j2, zzcn);
                        }
                        i8 = zza(zzds.zzad(zzai), b, bArr, i3, i2, zzcn, zzay);
                    }
                }
                unsafe = unsafe2;
                i5 = i3;
                i4 = i5;
                i8 = zza(b, bArr, i4, i2, t, zzay);
                zzds = this;
                t2 = t;
                bArr2 = bArr;
                i7 = i2;
                zzay2 = zzay;
                unsafe2 = unsafe;
            }
            if (i8 != i7) {
                throw zzco.zzbo();
            }
            return;
        }
        zza((Object) t, bArr, i, i2, 0, zzay);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int i : iArr) {
                long zzag = (long) (zzag(i) & 1048575);
                Object zzo = zzfd.zzo(t, zzag);
                if (zzo != null) {
                    zzfd.zza(t, zzag, this.zzmz.zzj(zzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.zzmw.zza(t, (long) i2);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t, T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.zzmi.length; i += 4) {
            int zzag = zzag(i);
            long j = (long) (1048575 & zzag);
            int i2 = this.zzmi[i];
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    if (zza(t2, i)) {
                        zzfd.zza(t, j, zzfd.zzn(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zza(t2, i)) {
                        zzfd.zza((Object) t, j, zzfd.zzm(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 3:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 4:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 5:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 6:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 7:
                    if (zza(t2, i)) {
                        zzfd.zza(t, j, zzfd.zzl(t2, j));
                        zzb(t, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i);
                    break;
                case 9:
                case 17:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i);
                    break;
                case 11:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 12:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 13:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 14:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
                    break;
                case 15:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                    zzb(t, i);
                    break;
                case 16:
                    if (!zza(t2, i)) {
                        break;
                    }
                    zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                    zzb(t, i);
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
                    this.zzmw.zza(t, t2, j);
                    break;
                case 50:
                    zzeh.zza(this.zzmz, t, t2, j);
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
                    if (!zza(t2, i2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i2, i);
                    break;
                case 60:
                case 68:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t2, i2, i)) {
                        break;
                    }
                    zzfd.zza(t, j, zzfd.zzo(t2, j));
                    zzb(t, i2, i);
                    break;
            }
        }
        if (!this.zzmq) {
            zzeh.zza(this.zzmx, t, t2);
            if (this.zzmo) {
                zzeh.zza(this.zzmy, t, t2);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d8, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fa, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020b, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020d, code lost:
        r2.putInt(r20, (long) r14, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0211, code lost:
        r3 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r3) + com.google.android.gms.internal.clearcut.zzbn.zzt(r5)) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0334, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0414, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0434, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x043c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x045c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0723;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0464, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0732;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0474, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0727;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x047c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0759;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0514, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0526, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0538, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x054a, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x055c, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x056e, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0580, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0592, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x05a3, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x05b4, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x05c5, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x05d6, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x05e7, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05f8, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05fa, code lost:
        r2.putInt(r20, (long) r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05fe, code lost:
        r9 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r15) + com.google.android.gms.internal.clearcut.zzbn.zzt(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x06c4, code lost:
        if ((r12 & r18) != 0) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x06c6, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r20, r10), zzad(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x06f1, code lost:
        if ((r12 & r18) != 0) goto L_0x06f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x06f3, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06fc, code lost:
        if ((r12 & r18) != 0) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x06fe, code lost:
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0721, code lost:
        if ((r12 & r18) != 0) goto L_0x0723;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:0x0723, code lost:
        r4 = r2.getObject(r20, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0727, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzbb) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x0730, code lost:
        if ((r12 & r18) != 0) goto L_0x0732;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x0732, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r20, r10), zzad(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x074a, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0727;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x074d, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0757, code lost:
        if ((r12 & r18) != 0) goto L_0x0759;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0759, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0139, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014b, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015d, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016f, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0181, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b6, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c7, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int zzm(T t) {
        int i;
        int i2;
        long j;
        boolean z;
        boolean z2;
        int i3;
        int zzc;
        Object obj;
        int i4;
        int i5;
        int i6;
        int i7;
        long j2;
        boolean z3;
        int i8;
        int i9;
        int zzb;
        long j3;
        long j4;
        int i10;
        Object obj2;
        int i11;
        int i12;
        int i13;
        long j5;
        int i14;
        int i15 = 267386880;
        if (this.zzmq) {
            Unsafe unsafe = zzmh;
            int i16 = 0;
            int i17 = 0;
            while (i16 < this.zzmi.length) {
                int zzag = zzag(i16);
                int i18 = (zzag & i15) >>> 20;
                int i19 = this.zzmi[i16];
                long j6 = (long) (zzag & 1048575);
                int i20 = (i18 < zzcb.DOUBLE_LIST_PACKED.id() || i18 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i16 + 2] & 1048575;
                switch (i18) {
                    case 0:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzb(i19, 0.0d);
                        break;
                    case 1:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzb(i19, 0.0f);
                        break;
                    case 2:
                        if (zza(t, i16)) {
                            j3 = zzfd.zzk(t, j6);
                            zzb = zzbn.zzd(i19, j3);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 3:
                        if (zza(t, i16)) {
                            j4 = zzfd.zzk(t, j6);
                            zzb = zzbn.zze(i19, j4);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 4:
                        if (zza(t, i16)) {
                            i10 = zzfd.zzj(t, j6);
                            zzb = zzbn.zzg(i19, i10);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 5:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzg(i19, 0L);
                        break;
                    case 6:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzj(i19, 0);
                        break;
                    case 7:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzc(i19, true);
                        break;
                    case 8:
                        if (zza(t, i16)) {
                            obj2 = zzfd.zzo(t, j6);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 9:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzeh.zzc(i19, zzfd.zzo(t, j6), zzad(i16));
                        break;
                    case 10:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        obj2 = zzfd.zzo(t, j6);
                        zzb = zzbn.zzc(i19, (zzbb) obj2);
                        break;
                    case 11:
                        if (zza(t, i16)) {
                            i11 = zzfd.zzj(t, j6);
                            zzb = zzbn.zzh(i19, i11);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 12:
                        if (zza(t, i16)) {
                            i12 = zzfd.zzj(t, j6);
                            zzb = zzbn.zzl(i19, i12);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 13:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzk(i19, 0);
                        break;
                    case 14:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzh(i19, 0L);
                        break;
                    case 15:
                        if (zza(t, i16)) {
                            i13 = zzfd.zzj(t, j6);
                            zzb = zzbn.zzi(i19, i13);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 16:
                        if (zza(t, i16)) {
                            j5 = zzfd.zzk(t, j6);
                            zzb = zzbn.zzf(i19, j5);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 17:
                        if (!zza(t, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzc(i19, (zzdo) zzfd.zzo(t, j6), zzad(i16));
                        break;
                    case 18:
                    case 23:
                    case 32:
                        zzb = zzeh.zzw(i19, zzd(t, j6), false);
                        break;
                    case 19:
                    case 24:
                    case 31:
                        zzb = zzeh.zzv(i19, zzd(t, j6), false);
                        break;
                    case 20:
                        zzb = zzeh.zzo(i19, zzd(t, j6), false);
                        break;
                    case 21:
                        zzb = zzeh.zzp(i19, zzd(t, j6), false);
                        break;
                    case 22:
                        zzb = zzeh.zzs(i19, zzd(t, j6), false);
                        break;
                    case 25:
                        zzb = zzeh.zzx(i19, zzd(t, j6), false);
                        break;
                    case 26:
                        zzb = zzeh.zzc(i19, zzd(t, j6));
                        break;
                    case 27:
                        zzb = zzeh.zzc(i19, (List<?>) zzd(t, j6), zzad(i16));
                        break;
                    case 28:
                        zzb = zzeh.zzd(i19, zzd(t, j6));
                        break;
                    case 29:
                        zzb = zzeh.zzt(i19, zzd(t, j6), false);
                        break;
                    case 30:
                        zzb = zzeh.zzr(i19, zzd(t, j6), false);
                        break;
                    case 33:
                        zzb = zzeh.zzu(i19, zzd(t, j6), false);
                        break;
                    case 34:
                        zzb = zzeh.zzq(i19, zzd(t, j6), false);
                        break;
                    case 35:
                        i14 = zzeh.zzi((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 36:
                        i14 = zzeh.zzh((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 37:
                        i14 = zzeh.zza((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 38:
                        i14 = zzeh.zzb((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 39:
                        i14 = zzeh.zze((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 40:
                        i14 = zzeh.zzi((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 41:
                        i14 = zzeh.zzh((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 42:
                        i14 = zzeh.zzj((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 43:
                        i14 = zzeh.zzf((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 44:
                        i14 = zzeh.zzd((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 45:
                        i14 = zzeh.zzh((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 46:
                        i14 = zzeh.zzi((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 47:
                        i14 = zzeh.zzg((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 48:
                        i14 = zzeh.zzc((List) unsafe.getObject(t, j6));
                        if (i14 > 0) {
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 49:
                        zzb = zzeh.zzd(i19, zzd(t, j6), zzad(i16));
                        break;
                    case 50:
                        zzb = this.zzmz.zzb(i19, zzfd.zzo(t, j6), zzae(i16));
                        break;
                    case 51:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzb(i19, 0.0d);
                        break;
                    case 52:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzb(i19, 0.0f);
                        break;
                    case 53:
                        if (zza(t, i19, i16)) {
                            j3 = zzh(t, j6);
                            zzb = zzbn.zzd(i19, j3);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 54:
                        if (zza(t, i19, i16)) {
                            j4 = zzh(t, j6);
                            zzb = zzbn.zze(i19, j4);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 55:
                        if (zza(t, i19, i16)) {
                            i10 = zzg(t, j6);
                            zzb = zzbn.zzg(i19, i10);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 56:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzg(i19, 0L);
                        break;
                    case 57:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzj(i19, 0);
                        break;
                    case 58:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzc(i19, true);
                        break;
                    case 59:
                        if (zza(t, i19, i16)) {
                            obj2 = zzfd.zzo(t, j6);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 60:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzeh.zzc(i19, zzfd.zzo(t, j6), zzad(i16));
                        break;
                    case 61:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        obj2 = zzfd.zzo(t, j6);
                        zzb = zzbn.zzc(i19, (zzbb) obj2);
                        break;
                    case 62:
                        if (zza(t, i19, i16)) {
                            i11 = zzg(t, j6);
                            zzb = zzbn.zzh(i19, i11);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 63:
                        if (zza(t, i19, i16)) {
                            i12 = zzg(t, j6);
                            zzb = zzbn.zzl(i19, i12);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 64:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzk(i19, 0);
                        break;
                    case 65:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzh(i19, 0L);
                        break;
                    case 66:
                        if (zza(t, i19, i16)) {
                            i13 = zzg(t, j6);
                            zzb = zzbn.zzi(i19, i13);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 67:
                        if (zza(t, i19, i16)) {
                            j5 = zzh(t, j6);
                            zzb = zzbn.zzf(i19, j5);
                            break;
                        } else {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                    case 68:
                        if (!zza(t, i19, i16)) {
                            continue;
                            i16 += 4;
                            i15 = 267386880;
                        }
                        zzb = zzbn.zzc(i19, (zzdo) zzfd.zzo(t, j6), zzad(i16));
                        break;
                    default:
                        i16 += 4;
                        i15 = 267386880;
                }
                i17 += zzb;
                i16 += 4;
                i15 = 267386880;
            }
            return i17 + zza((zzex) this.zzmx, (Object) t);
        }
        Unsafe unsafe2 = zzmh;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i22 < this.zzmi.length) {
            int zzag2 = zzag(i22);
            int[] iArr = this.zzmi;
            int i25 = iArr[i22];
            int i26 = (zzag2 & 267386880) >>> 20;
            if (i26 <= 17) {
                int i27 = iArr[i22 + 2];
                int i28 = i27 & 1048575;
                i = 1 << (i27 >>> 20);
                if (i28 != i21) {
                    i24 = unsafe2.getInt(t, (long) i28);
                    i21 = i28;
                }
                i2 = i27;
            } else {
                i2 = (!this.zzmr || i26 < zzcb.DOUBLE_LIST_PACKED.id() || i26 > zzcb.SINT64_LIST_PACKED.id()) ? 0 : this.zzmi[i22 + 2] & 1048575;
                i = 0;
            }
            long j7 = (long) (zzag2 & 1048575);
            switch (i26) {
                case 0:
                    z2 = false;
                    z = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        i23 += zzbn.zzb(i25, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    z2 = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        z = false;
                        i23 += zzbn.zzb(i25, 0.0f);
                        break;
                    }
                    z = false;
                case 2:
                    z2 = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        i3 = zzbn.zzd(i25, unsafe2.getLong(t, j7));
                        i23 += i3;
                    }
                    z = false;
                    break;
                case 3:
                    z2 = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        i3 = zzbn.zze(i25, unsafe2.getLong(t, j7));
                        i23 += i3;
                    }
                    z = false;
                    break;
                case 4:
                    z2 = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        i3 = zzbn.zzg(i25, unsafe2.getInt(t, j7));
                        i23 += i3;
                    }
                    z = false;
                    break;
                case 5:
                    z2 = false;
                    j = 0;
                    if ((i24 & i) != 0) {
                        i3 = zzbn.zzg(i25, 0L);
                        i23 += i3;
                    }
                    z = false;
                    break;
                case 6:
                    if ((i24 & i) != 0) {
                        z2 = false;
                        i23 += zzbn.zzj(i25, 0);
                        z = false;
                        j = 0;
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                case 7:
                    break;
                case 8:
                    if ((i24 & i) != 0) {
                        obj = unsafe2.getObject(t, j7);
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    if ((i24 & i) != 0) {
                        i4 = unsafe2.getInt(t, j7);
                        zzc = zzbn.zzh(i25, i4);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 12:
                    if ((i24 & i) != 0) {
                        i5 = unsafe2.getInt(t, j7);
                        zzc = zzbn.zzl(i25, i5);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    if ((i24 & i) != 0) {
                        i7 = unsafe2.getInt(t, j7);
                        zzc = zzbn.zzi(i25, i7);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 16:
                    if ((i24 & i) != 0) {
                        j2 = unsafe2.getLong(t, j7);
                        zzc = zzbn.zzf(i25, j2);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 17:
                    break;
                case 18:
                    zzc = zzeh.zzw(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 19:
                case 24:
                case 31:
                    z3 = false;
                    i8 = zzeh.zzv(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 20:
                    z3 = false;
                    i8 = zzeh.zzo(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 21:
                    z3 = false;
                    i8 = zzeh.zzp(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 22:
                    z3 = false;
                    i8 = zzeh.zzs(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 23:
                case 32:
                    z3 = false;
                    i8 = zzeh.zzw(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 25:
                    z3 = false;
                    i8 = zzeh.zzx(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 26:
                    zzc = zzeh.zzc(i25, (List) unsafe2.getObject(t, j7));
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 27:
                    zzc = zzeh.zzc(i25, (List<?>) ((List) unsafe2.getObject(t, j7)), zzad(i22));
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 28:
                    zzc = zzeh.zzd(i25, (List) unsafe2.getObject(t, j7));
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 29:
                    zzc = zzeh.zzt(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 30:
                    z3 = false;
                    i8 = zzeh.zzr(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 33:
                    z3 = false;
                    i8 = zzeh.zzu(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 34:
                    z3 = false;
                    i8 = zzeh.zzq(i25, (List) unsafe2.getObject(t, j7), false);
                    i23 += i8;
                    z2 = z3;
                    z = false;
                    j = 0;
                    break;
                case 35:
                    i9 = zzeh.zzi((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 36:
                    i9 = zzeh.zzh((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 37:
                    i9 = zzeh.zza((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 38:
                    i9 = zzeh.zzb((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 39:
                    i9 = zzeh.zze((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 40:
                    i9 = zzeh.zzi((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 41:
                    i9 = zzeh.zzh((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 42:
                    i9 = zzeh.zzj((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 43:
                    i9 = zzeh.zzf((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 44:
                    i9 = zzeh.zzd((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 45:
                    i9 = zzeh.zzh((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 46:
                    i9 = zzeh.zzi((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 47:
                    i9 = zzeh.zzg((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 48:
                    i9 = zzeh.zzc((List) unsafe2.getObject(t, j7));
                    if (i9 > 0) {
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 49:
                    zzc = zzeh.zzd(i25, (List) unsafe2.getObject(t, j7), zzad(i22));
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 50:
                    zzc = this.zzmz.zzb(i25, unsafe2.getObject(t, j7), zzae(i22));
                    i23 += zzc;
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i25, i22)) {
                        zzc = zzbn.zzb(i25, 0.0d);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 52:
                    if (zza(t, i25, i22)) {
                        i6 = zzbn.zzb(i25, 0.0f);
                        i23 += i6;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 53:
                    if (zza(t, i25, i22)) {
                        zzc = zzbn.zzd(i25, zzh(t, j7));
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 54:
                    if (zza(t, i25, i22)) {
                        zzc = zzbn.zze(i25, zzh(t, j7));
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 55:
                    if (zza(t, i25, i22)) {
                        zzc = zzbn.zzg(i25, zzg(t, j7));
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 56:
                    if (zza(t, i25, i22)) {
                        zzc = zzbn.zzg(i25, 0L);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 57:
                    if (zza(t, i25, i22)) {
                        i6 = zzbn.zzj(i25, 0);
                        i23 += i6;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 58:
                    break;
                case 59:
                    if (zza(t, i25, i22)) {
                        obj = unsafe2.getObject(t, j7);
                        break;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 60:
                    break;
                case 61:
                    break;
                case 62:
                    if (zza(t, i25, i22)) {
                        i4 = zzg(t, j7);
                        zzc = zzbn.zzh(i25, i4);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 63:
                    if (zza(t, i25, i22)) {
                        i5 = zzg(t, j7);
                        zzc = zzbn.zzl(i25, i5);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 64:
                    break;
                case 65:
                    break;
                case 66:
                    if (zza(t, i25, i22)) {
                        i7 = zzg(t, j7);
                        zzc = zzbn.zzi(i25, i7);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 67:
                    if (zza(t, i25, i22)) {
                        j2 = zzh(t, j7);
                        zzc = zzbn.zzf(i25, j2);
                        i23 += zzc;
                    }
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
                case 68:
                    break;
                default:
                    z2 = false;
                    z = false;
                    j = 0;
                    break;
            }
            i22 += 4;
        }
        int zza = i23 + zza((zzex) this.zzmx, (Object) t);
        return this.zzmo ? zza + this.zzmy.zza((Object) t).zzas() : zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.google.android.gms.internal.clearcut.zzef] */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27, types: [com.google.android.gms.internal.clearcut.zzef] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean zzo(T t) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        int[] iArr = this.zzms;
        if (!(iArr == null || iArr.length == 0)) {
            int i3 = -1;
            int length = iArr.length;
            int i4 = 0;
            for (int i5 = 0; i5 < length; i5 = i + 1) {
                int i6 = iArr[i5];
                int zzai = zzai(i6);
                int zzag = zzag(zzai);
                if (!this.zzmq) {
                    int i7 = this.zzmi[zzai + 2];
                    int i8 = i7 & 1048575;
                    i2 = 1 << (i7 >>> 20);
                    if (i8 != i3) {
                        i = i5;
                        i4 = zzmh.getInt(t, (long) i8);
                        i3 = i8;
                    } else {
                        i = i5;
                    }
                } else {
                    i = i5;
                    i2 = 0;
                }
                if (((268435456 & zzag) != 0) && !zza(t, zzai, i4, i2)) {
                    return false;
                }
                int i9 = (267386880 & zzag) >>> 20;
                if (i9 != 9 && i9 != 17) {
                    if (i9 != 27) {
                        if (i9 == 60 || i9 == 68) {
                            if (zza(t, i6, zzai) && !zza(t, zzag, zzad(zzai))) {
                                return false;
                            }
                        } else if (i9 != 49) {
                            if (i9 != 50) {
                                continue;
                            } else {
                                Map<?, ?> zzh = this.zzmz.zzh(zzfd.zzo(t, (long) (zzag & 1048575)));
                                if (!zzh.isEmpty()) {
                                    if (this.zzmz.zzl(zzae(zzai)).zzmd.zzek() == zzfq.MESSAGE) {
                                        zzef<T> zzef = 0;
                                        Iterator<?> it = zzh.values().iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            if (zzef == null) {
                                                zzef = zzea.zzcm().zze(next.getClass());
                                            }
                                            boolean zzo = zzef.zzo(next);
                                            zzef = zzef;
                                            if (!zzo) {
                                                z2 = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                                z2 = true;
                                if (!z2) {
                                    return false;
                                }
                            }
                        }
                    }
                    List list = (List) zzfd.zzo(t, (long) (zzag & 1048575));
                    if (!list.isEmpty()) {
                        ?? zzad = zzad(zzai);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= list.size()) {
                                break;
                            } else if (!zzad.zzo(list.get(i10))) {
                                z = false;
                                break;
                            } else {
                                i10++;
                            }
                        }
                        if (z) {
                            return false;
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else if (zza(t, zzai, i4, i2) && !zza(t, zzag, zzad(zzai))) {
                    return false;
                }
            }
            return !this.zzmo || this.zzmy.zza(t).isInitialized();
        }
    }
}
