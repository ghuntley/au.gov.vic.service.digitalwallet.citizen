package com.google.android.gms.internal.instantapps;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* access modifiers changed from: package-private */
public class zzbz extends zzbw {
    protected final byte[] zzalc;

    zzbz(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzalc = bArr;
    }

    /* access modifiers changed from: protected */
    public int zzx() {
        return 0;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp
    public byte zzj(int i) {
        return this.zzalc[i];
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzbp
    public byte zzk(int i) {
        return this.zzalc[i];
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp
    public int size() {
        return this.zzalc.length;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final zzbp zza(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzbp.zzakv;
        }
        return new zzbs(this.zzalc, zzx(), zzb);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final void zza(zzbm zzbm) throws IOException {
        zzbm.zza(this.zzalc, zzx(), size());
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final String zza(Charset charset) {
        return new String(this.zzalc, zzx(), size(), charset);
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final boolean zzv() {
        int zzx = zzx();
        return zzfv.zze(this.zzalc, zzx, size() + zzx);
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbp) || size() != ((zzbp) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzbz)) {
            return obj.equals(this);
        }
        zzbz zzbz = (zzbz) obj;
        int zzw = zzw();
        int zzw2 = zzbz.zzw();
        if (zzw == 0 || zzw2 == 0 || zzw == zzw2) {
            return zza(zzbz, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzbw
    public final boolean zza(zzbp zzbp, int i, int i2) {
        if (i2 > zzbp.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzbp.size()) {
            int size2 = zzbp.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzbp instanceof zzbz)) {
            return zzbp.zza(0, i2).equals(zza(0, i2));
        } else {
            zzbz zzbz = (zzbz) zzbp;
            byte[] bArr = this.zzalc;
            byte[] bArr2 = zzbz.zzalc;
            int zzx = zzx() + i2;
            int zzx2 = zzx();
            int zzx3 = zzbz.zzx();
            while (zzx2 < zzx) {
                if (bArr[zzx2] != bArr2[zzx3]) {
                    return false;
                }
                zzx2++;
                zzx3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.instantapps.zzbp
    public final int zza(int i, int i2, int i3) {
        return zzcy.zza(i, this.zzalc, zzx(), i3);
    }
}
