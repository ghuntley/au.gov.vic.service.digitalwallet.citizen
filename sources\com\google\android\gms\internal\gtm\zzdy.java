package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzgp;
import com.google.android.gms.tagmanager.zzcd;
import com.google.android.gms.tagmanager.zzcm;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdy {
    private final zzmo zzamu;
    private final zzcm zzamx;
    private final ExecutorService zzanf;
    private final ScheduledExecutorService zzang;
    private final zzcd zzanh;
    private final Context zzrm;

    public zzdy(Context context, zzcm zzcm, zzcd zzcd) {
        this(context, zzcm, zzcd, new zzmo(context), zzgp.zza.zzr(context), zzgr.zzaqy);
    }

    private zzdy(Context context, zzcm zzcm, zzcd zzcd, zzmo zzmo, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.zzrm = ((Context) Preconditions.checkNotNull(context)).getApplicationContext();
        this.zzamx = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzanh = (zzcd) Preconditions.checkNotNull(zzcd);
        this.zzamu = (zzmo) Preconditions.checkNotNull(zzmo);
        this.zzanf = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzang = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
    }

    public final zzdq zzb(String str, String str2, String str3) {
        return new zzdq(this.zzrm, str, str2, str3, new zzfk(this.zzrm, this.zzamx, this.zzanh, str), this.zzamu, this.zzanf, this.zzang, this.zzamx, DefaultClock.getInstance(), new zzdz(this.zzrm, str));
    }
}
