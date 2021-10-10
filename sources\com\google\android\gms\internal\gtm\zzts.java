package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Arrays;

public final class zzts {
    private static final zzts zzbem = new zzts(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzavs;
    private int zzbal;
    private Object[] zzbcz;
    private int[] zzben;

    public static zzts zzrj() {
        return zzbem;
    }

    static zzts zzrk() {
        return new zzts();
    }

    static zzts zza(zzts zzts, zzts zzts2) {
        int i = zzts.count + zzts2.count;
        int[] copyOf = Arrays.copyOf(zzts.zzben, i);
        System.arraycopy(zzts2.zzben, 0, copyOf, zzts.count, zzts2.count);
        Object[] copyOf2 = Arrays.copyOf(zzts.zzbcz, i);
        System.arraycopy(zzts2.zzbcz, 0, copyOf2, zzts.count, zzts2.count);
        return new zzts(i, copyOf, copyOf2, true);
    }

    private zzts() {
        this(0, new int[8], new Object[8], true);
    }

    private zzts(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzbal = -1;
        this.count = i;
        this.zzben = iArr;
        this.zzbcz = objArr;
        this.zzavs = z;
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzum zzum) throws IOException {
        if (zzum.zzol() == zzrc.zze.zzbbd) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzum.zza(this.zzben[i] >>> 3, this.zzbcz[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzum.zza(this.zzben[i2] >>> 3, this.zzbcz[i2]);
        }
    }

    public final void zzb(zzum zzum) throws IOException {
        if (this.count != 0) {
            if (zzum.zzol() == zzrc.zze.zzbbc) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzben[i], this.zzbcz[i], zzum);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzben[i2], this.zzbcz[i2], zzum);
            }
        }
    }

    private static void zzb(int i, Object obj, zzum zzum) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzum.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzum.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzum.zza(i2, (zzps) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzum.zzh(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzrk.zzpt());
        } else if (zzum.zzol() == zzrc.zze.zzbbc) {
            zzum.zzbk(i2);
            ((zzts) obj).zzb(zzum);
            zzum.zzbl(i2);
        } else {
            zzum.zzbl(i2);
            ((zzts) obj).zzb(zzum);
            zzum.zzbk(i2);
        }
    }

    public final int zzrl() {
        int i = this.zzbal;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzqj.zzd(this.zzben[i3] >>> 3, (zzps) this.zzbcz[i3]);
        }
        this.zzbal = i2;
        return i2;
    }

    public final int zzpe() {
        int i;
        int i2 = this.zzbal;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzben[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzqj.zze(i6, ((Long) this.zzbcz[i4]).longValue());
            } else if (i7 == 1) {
                i = zzqj.zzg(i6, ((Long) this.zzbcz[i4]).longValue());
            } else if (i7 == 2) {
                i = zzqj.zzc(i6, (zzps) this.zzbcz[i4]);
            } else if (i7 == 3) {
                i = (zzqj.zzbb(i6) << 1) + ((zzts) this.zzbcz[i4]).zzpe();
            } else if (i7 == 5) {
                i = zzqj.zzl(i6, ((Integer) this.zzbcz[i4]).intValue());
            } else {
                throw new IllegalStateException(zzrk.zzpt());
            }
            i3 += i;
        }
        this.zzbal = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzts)) {
            return false;
        }
        zzts zzts = (zzts) obj;
        int i = this.count;
        if (i == zzts.count) {
            int[] iArr = this.zzben;
            int[] iArr2 = zzts.zzben;
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
                Object[] objArr = this.zzbcz;
                Object[] objArr2 = zzts.zzbcz;
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
        int[] iArr = this.zzben;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzbcz;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzsn.zza(sb, i, String.valueOf(this.zzben[i2] >>> 3), this.zzbcz[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzavs) {
            int i2 = this.count;
            int[] iArr = this.zzben;
            if (i2 == iArr.length) {
                int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
                this.zzben = Arrays.copyOf(iArr, i3);
                this.zzbcz = Arrays.copyOf(this.zzbcz, i3);
            }
            int[] iArr2 = this.zzben;
            int i4 = this.count;
            iArr2[i4] = i;
            this.zzbcz[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
