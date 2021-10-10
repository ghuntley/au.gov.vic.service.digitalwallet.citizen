package com.google.android.gms.internal.vision;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
final class zzhx implements zzhz {
    private zzhx() {
    }

    @Override // com.google.android.gms.internal.vision.zzhz
    public final byte[] zza(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* synthetic */ zzhx(zzhs zzhs) {
        this();
    }
}
