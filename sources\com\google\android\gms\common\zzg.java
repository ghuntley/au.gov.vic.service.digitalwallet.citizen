package com.google.android.gms.common;

import java.util.Arrays;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzg extends zzd {
    private final byte[] zza;

    zzg(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzd
    public final byte[] zza() {
        return this.zza;
    }
}
