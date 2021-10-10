package com.google.android.gms.internal.vision;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public final class zzhw extends zzid {
    private final int zzc;
    private final int zzd;

    zzhw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzid
    public final byte zza(int i) {
        int zza = zza();
        if (((zza - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
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
        sb2.append(zza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzid
    public final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzid
    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzid
    public final int zze() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzid
    public final void zza(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, zze(), bArr, 0, i3);
    }
}
