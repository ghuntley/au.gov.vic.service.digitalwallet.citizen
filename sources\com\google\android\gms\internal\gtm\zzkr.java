package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkr extends zzhb {
    private final zzfj zzarn;
    private final Context zzrm;

    public zzkr(Context context, zzfj zzfj) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
        this.zzarn = zzfj;
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.gtm.zzhb
    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        Preconditions.checkArgument(true);
        if (zzoaArr.length == 0 || zzoaArr[0] == zzog.zzaum) {
            return new zzom("");
        }
        Object obj = this.zzarn.zzkt().zzib().get("_ldl");
        if (obj == null) {
            return new zzom("");
        }
        zzoa<?> zzq = zzoo.zzq(obj);
        if (!(zzq instanceof zzom)) {
            return new zzom("");
        }
        String str = (String) ((zzom) zzq).value();
        if (!zzeu.zze(str, "conv").equals(zzha.zzd(zzoaArr[0]))) {
            return new zzom("");
        }
        String str2 = null;
        if (zzoaArr.length > 1 && zzoaArr[1] != zzog.zzaum) {
            str2 = zzha.zzd(zzoaArr[1]);
        }
        String zze = zzeu.zze(str, str2);
        return zze != null ? new zzom(zze) : new zzom("");
    }
}
