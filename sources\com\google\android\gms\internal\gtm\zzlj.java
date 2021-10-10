package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlj implements zzgz {
    private Context zzrm;

    public zzlj(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
    }

    @Override // com.google.android.gms.internal.gtm.zzgz
    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(zzoaArr != null);
        String str = null;
        if (zzoaArr.length > 0 && zzoaArr[0] != zzog.zzaum) {
            str = zzha.zzd(zzoo.zza(zzfl, zzoaArr[0]));
        }
        String zze = zzeu.zze(this.zzrm, str);
        return zze != null ? new zzom(zze) : zzog.zzaum;
    }
}
