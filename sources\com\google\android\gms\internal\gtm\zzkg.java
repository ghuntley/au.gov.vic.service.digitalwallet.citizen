package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzkg extends zzhb {
    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        try {
            return new zzom(zzkf.decode(zzha.zzd(zzoaArr.length > 0 ? (zzoa) Preconditions.checkNotNull(zzoaArr[0]) : zzog.zzaum), ""));
        } catch (UnsupportedEncodingException unused) {
            return zzog.zzaum;
        }
    }
}
