package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tagmanager.zzcm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzdq {
    private volatile int state = 1;
    private final String zzaec;
    private ScheduledFuture<?> zzajk = null;
    private final String zzamr;
    private final String zzams;
    private final zzfk zzamt;
    private final zzmo zzamu;
    private final ExecutorService zzamv;
    private final ScheduledExecutorService zzamw;
    private final zzcm zzamx;
    private final zzdz zzamy;
    private zzff zzamz;
    private List<zzee> zzana = new ArrayList();
    private boolean zzanb = false;
    private final Context zzrm;
    private final Clock zzsd;

    zzdq(Context context, String str, String str2, String str3, zzfk zzfk, zzmo zzmo, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzcm zzcm, Clock clock, zzdz zzdz) {
        this.zzrm = context;
        String str4 = (String) Preconditions.checkNotNull(str);
        this.zzaec = str4;
        this.zzamt = (zzfk) Preconditions.checkNotNull(zzfk);
        this.zzamu = (zzmo) Preconditions.checkNotNull(zzmo);
        ExecutorService executorService2 = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzamv = executorService2;
        this.zzamw = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        zzcm zzcm2 = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzamx = zzcm2;
        this.zzsd = (Clock) Preconditions.checkNotNull(clock);
        this.zzamy = (zzdz) Preconditions.checkNotNull(zzdz);
        this.zzamr = str3;
        this.zzams = str2;
        this.zzana.add(new zzee("gtm.load", new Bundle(), "gtm", new Date(), false, zzcm2));
        StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 35);
        sb.append("Container ");
        sb.append(str4);
        sb.append("is scheduled for loading.");
        zzev.zzab(sb.toString());
        executorService2.execute(new zzdu(this, null));
    }

    public final void zza(zzee zzee) {
        this.zzamv.execute(new zzdv(this, zzee));
    }

    public final void dispatch() {
        this.zzamv.execute(new zzdr(this));
    }

    /* access modifiers changed from: public */
    private final void zzn(long j) {
        ScheduledFuture<?> scheduledFuture = this.zzajk;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        String str = this.zzaec;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 45);
        sb.append("Refresh container ");
        sb.append(str);
        sb.append(" in ");
        sb.append(j);
        sb.append("ms.");
        zzev.zzab(sb.toString());
        this.zzajk = this.zzamw.schedule(new zzds(this), j, TimeUnit.MILLISECONDS);
    }
}
