package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzlx {
    private static final zzlx zza = new zzlx(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    public static zzlx zza() {
        return zza;
    }

    static zzlx zzb() {
        return new zzlx();
    }

    static zzlx zza(zzlx zzlx, zzlx zzlx2) {
        int i = zzlx.zzb + zzlx2.zzb;
        int[] copyOf = Arrays.copyOf(zzlx.zzc, i);
        System.arraycopy(zzlx2.zzc, 0, copyOf, zzlx.zzb, zzlx2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzlx.zzd, i);
        System.arraycopy(zzlx2.zzd, 0, copyOf2, zzlx.zzb, zzlx2.zzb);
        return new zzlx(i, copyOf, copyOf2, true);
    }

    private zzlx() {
        this(0, new int[8], new Object[8], true);
    }

    private zzlx(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final void zzc() {
        this.zzf = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzmr zzmr) throws IOException {
        if (zzmr.zza() == zzmq.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzmr.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzmr.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zzb(zzmr zzmr) throws IOException {
        if (this.zzb != 0) {
            if (zzmr.zza() == zzmq.zza) {
                for (int i = 0; i < this.zzb; i++) {
                    zza(this.zzc[i], this.zzd[i], zzmr);
                }
                return;
            }
            for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
                zza(this.zzc[i2], this.zzd[i2], zzmr);
            }
        }
    }

    private static void zza(int i, Object obj, zzmr zzmr) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzmr.zza(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzmr.zzd(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzmr.zza(i2, (zzht) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzmr.zzd(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzjk.zzf());
        } else if (zzmr.zza() == zzmq.zza) {
            zzmr.zza(i2);
            ((zzlx) obj).zzb(zzmr);
            zzmr.zzb(i2);
        } else {
            zzmr.zzb(i2);
            ((zzlx) obj).zzb(zzmr);
            zzmr.zza(i2);
        }
    }

    public final int zzd() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzii.zzd(this.zzc[i3] >>> 3, (zzht) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final int zze() {
        int i;
        int i2 = this.zze;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzb; i4++) {
            int i5 = this.zzc[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzii.zze(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 1) {
                i = zzii.zzg(i6, ((Long) this.zzd[i4]).longValue());
            } else if (i7 == 2) {
                i = zzii.zzc(i6, (zzht) this.zzd[i4]);
            } else if (i7 == 3) {
                i = (zzii.zze(i6) << 1) + ((zzlx) this.zzd[i4]).zze();
            } else if (i7 == 5) {
                i = zzii.zzi(i6, ((Integer) this.zzd[i4]).intValue());
            } else {
                throw new IllegalStateException(zzjk.zzf());
            }
            i3 += i;
        }
        this.zze = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzlx)) {
            return false;
        }
        zzlx zzlx = (zzlx) obj;
        int i = this.zzb;
        if (i == zzlx.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzlx.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzd;
                Object[] objArr2 = zzlx.zzd;
                int i3 = this.zzb;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzkp.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, Object obj) {
        if (this.zzf) {
            int i2 = this.zzb;
            int[] iArr = this.zzc;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzc = Arrays.copyOf(iArr, i3);
                this.zzd = Arrays.copyOf(this.zzd, i3);
            }
            int[] iArr2 = this.zzc;
            int i4 = this.zzb;
            iArr2[i4] = i;
            this.zzd[i4] = obj;
            this.zzb = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
