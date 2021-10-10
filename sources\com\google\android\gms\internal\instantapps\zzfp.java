package com.google.android.gms.internal.instantapps;

import com.google.android.gms.internal.instantapps.zzcx;
import java.io.IOException;
import java.util.Arrays;

public final class zzfp {
    private static final zzfp zzatc = new zzfp(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzakn;
    private int zzapd;
    private Object[] zzaro;
    private int[] zzatd;

    public static zzfp zzea() {
        return zzatc;
    }

    static zzfp zzeb() {
        return new zzfp();
    }

    static zzfp zza(zzfp zzfp, zzfp zzfp2) {
        int i = zzfp.count + zzfp2.count;
        int[] copyOf = Arrays.copyOf(zzfp.zzatd, i);
        System.arraycopy(zzfp2.zzatd, 0, copyOf, zzfp.count, zzfp2.count);
        Object[] copyOf2 = Arrays.copyOf(zzfp.zzaro, i);
        System.arraycopy(zzfp2.zzaro, 0, copyOf2, zzfp.count, zzfp2.count);
        return new zzfp(i, copyOf, copyOf2, true);
    }

    private zzfp() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzapd = -1;
        this.count = i;
        this.zzatd = iArr;
        this.zzaro = objArr;
        this.zzakn = z;
    }

    public final void zzs() {
        this.zzakn = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgi zzgi) throws IOException {
        if (zzgi.zzbd() == zzcx.zzd.zzaps) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzgi.zza(this.zzatd[i] >>> 3, this.zzaro[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgi.zza(this.zzatd[i2] >>> 3, this.zzaro[i2]);
        }
    }

    public final void zzb(zzgi zzgi) throws IOException {
        if (this.count != 0) {
            if (zzgi.zzbd() == zzcx.zzd.zzapr) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzatd[i], this.zzaro[i], zzgi);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzatd[i2], this.zzaro[i2], zzgi);
            }
        }
    }

    private static void zzb(int i, Object obj, zzgi zzgi) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzgi.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzgi.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzgi.zza(i2, (zzbp) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzgi.zzf(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzdf.zzck());
        } else if (zzgi.zzbd() == zzcx.zzd.zzapr) {
            zzgi.zzaj(i2);
            ((zzfp) obj).zzb(zzgi);
            zzgi.zzak(i2);
        } else {
            zzgi.zzak(i2);
            ((zzfp) obj).zzb(zzgi);
            zzgi.zzaj(i2);
        }
    }

    public final int zzec() {
        int i = this.zzapd;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzce.zzd(this.zzatd[i3] >>> 3, (zzbp) this.zzaro[i3]);
        }
        this.zzapd = i2;
        return i2;
    }

    public final int zzbz() {
        int i;
        int i2 = this.zzapd;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzatd[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzce.zze(i6, ((Long) this.zzaro[i4]).longValue());
            } else if (i7 == 1) {
                i = zzce.zzg(i6, ((Long) this.zzaro[i4]).longValue());
            } else if (i7 == 2) {
                i = zzce.zzc(i6, (zzbp) this.zzaro[i4]);
            } else if (i7 == 3) {
                i = (zzce.zzaa(i6) << 1) + ((zzfp) this.zzaro[i4]).zzbz();
            } else if (i7 == 5) {
                i = zzce.zzj(i6, ((Integer) this.zzaro[i4]).intValue());
            } else {
                throw new IllegalStateException(zzdf.zzck());
            }
            i3 += i;
        }
        this.zzapd = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfp)) {
            return false;
        }
        zzfp zzfp = (zzfp) obj;
        int i = this.count;
        if (i == zzfp.count) {
            int[] iArr = this.zzatd;
            int[] iArr2 = zzfp.zzatd;
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
                Object[] objArr = this.zzaro;
                Object[] objArr2 = zzfp.zzaro;
                int i3 = this.count;
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
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzatd;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzaro;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzeg.zza(sb, i, String.valueOf(this.zzatd[i2] >>> 3), this.zzaro[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzakn) {
            int i2 = this.count;
            int[] iArr = this.zzatd;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzatd = Arrays.copyOf(iArr, i3);
                this.zzaro = Arrays.copyOf(this.zzaro, i3);
            }
            int[] iArr2 = this.zzatd;
            int i4 = this.count;
            iArr2[i4] = i;
            this.zzaro[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
