package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;

public final class zzfk {
    private final String zzaec;
    private final zzcm zzamx;
    private final zzcd zzanh;
    private final Context zzrm;

    public zzfk(Context context, zzcm zzcm, zzcd zzcd, String str) {
        this.zzrm = context.getApplicationContext();
        this.zzamx = zzcm;
        this.zzanh = zzcd;
        this.zzaec = str;
    }

    public final zzff zza(zznm zznm, zznu zznu) {
        return new zzff(this.zzrm, this.zzaec, zznm, zznu, this.zzamx, this.zzanh);
    }
}
