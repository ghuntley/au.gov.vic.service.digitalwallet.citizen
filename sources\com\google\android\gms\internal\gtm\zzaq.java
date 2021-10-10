package com.google.android.gms.internal.gtm;

import java.lang.Thread;

/* access modifiers changed from: package-private */
public final class zzaq implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzap zzwt;

    zzaq(zzap zzap) {
        this.zzwt = zzap;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        zzci zzdd = this.zzwt.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th);
        }
    }
}
