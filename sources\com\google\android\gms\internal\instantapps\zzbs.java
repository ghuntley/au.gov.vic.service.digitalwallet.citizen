package com.google.android.gms.internal.instantapps;

final class zzbs extends zzbz {
    private final int zzakz;
    private final int zzala;

    zzbs(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzakz = i;
        this.zzala = i2;
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp, com.google.android.gms.internal.instantapps.zzbz
    public final byte zzj(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzalc[this.zzakz + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.instantapps.zzbp, com.google.android.gms.internal.instantapps.zzbz
    public final byte zzk(int i) {
        return this.zzalc[this.zzakz + i];
    }

    @Override // com.google.android.gms.internal.instantapps.zzbp, com.google.android.gms.internal.instantapps.zzbz
    public final int size() {
        return this.zzala;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.instantapps.zzbz
    public final int zzx() {
        return this.zzakz;
    }
}
