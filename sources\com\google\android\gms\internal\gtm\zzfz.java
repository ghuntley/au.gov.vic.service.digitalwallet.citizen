package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzfy;
import com.google.android.gms.internal.gtm.zzgp;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;

final class zzfz implements zzfy.zzc {
    zzfz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzfy.zzc
    public final zzfy zzb(Context context, zzcm zzcm, zzcd zzcd) {
        return new zzfy(context, zzcm, zzcd, new zzgt(context), zzgp.zza.zzr(context), zzgr.zzaqy, zzfd.zzkr(), new zzfy.zza(context));
    }
}
