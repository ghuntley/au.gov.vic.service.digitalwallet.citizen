package com.google.android.gms.internal.gtm;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzcu;
import com.google.android.gms.stats.WakeLock;

public final class zzcq<T extends Context & zzcu> {
    private static Boolean zzacd;
    private final Handler handler = new zzdj();
    private final T zzacc;

    public zzcq(T t) {
        Preconditions.checkNotNull(t);
        this.zzacc = t;
    }

    public static boolean zze(Context context) {
        Preconditions.checkNotNull(context);
        Boolean bool = zzacd;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zzc = zzcz.zzc(context, "com.google.android.gms.analytics.AnalyticsService");
        zzacd = Boolean.valueOf(zzc);
        return zzc;
    }

    public final void onCreate() {
        zzap.zzc(this.zzacc).zzco().zzq("Local AnalyticsService is starting up");
    }

    public final void onDestroy() {
        zzap.zzc(this.zzacc).zzco().zzq("Local AnalyticsService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (zzcp.lock) {
                WakeLock wakeLock = zzcp.zzacb;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException unused) {
        }
        zzci zzco = zzap.zzc(this.zzacc).zzco();
        if (intent == null) {
            zzco.zzt("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzco.zza("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzb(new zzcr(this, i2, zzco));
        }
        return 2;
    }

    private final void zzb(Runnable runnable) {
        zzap.zzc(this.zzacc).zzcs().zza(new zzct(this, runnable));
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        zzci zzco = zzap.zzc(this.zzacc).zzco();
        String string = jobParameters.getExtras().getString("action");
        zzco.zza("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        zzb(new zzcs(this, zzco, jobParameters));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzci zzci, JobParameters jobParameters) {
        zzci.zzq("AnalyticsJobService processed last dispatch request");
        this.zzacc.zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzci zzci) {
        if (this.zzacc.callServiceStopSelfResult(i)) {
            zzci.zzq("Local AnalyticsService processed last dispatch request");
        }
    }
}
