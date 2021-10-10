package com.google.android.gms.internal.gtm;

import android.app.job.JobParameters;

final /* synthetic */ class zzcs implements Runnable {
    private final zzcq zzace;
    private final zzci zzach;
    private final JobParameters zzaci;

    zzcs(zzcq zzcq, zzci zzci, JobParameters jobParameters) {
        this.zzace = zzcq;
        this.zzach = zzci;
        this.zzaci = jobParameters;
    }

    public final void run() {
        this.zzace.zza(this.zzach, this.zzaci);
    }
}
